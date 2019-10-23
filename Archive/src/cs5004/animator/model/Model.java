package cs5004.animator.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cs5004.animator.util.TweenModelBuilder;

/**
 * This is a class representing a simple Model for an animation. This class implements
 * the IModel interface.
 */
public final class Model implements IModel {

  /**
   * A List holding all animations created through the model.
   */
  private List<IMotion> animations;

  /**
   * A HashMap holding all shapes created and animated through the model.
   */
  private Map<String, AbstractShape> animatedShapes;

  /**
   * The constructor for the animation model.
   */
  public Model() {
    this.animations = new ArrayList<>();
    this.animatedShapes = new LinkedHashMap<String, AbstractShape>();
  }

  /**
   * A static builder class used to build out an IModel animation model object. This class
   * implements the TweenModelBuilder interface.
   */
  public static final class Builder implements TweenModelBuilder {


    /**
     * A HashMap holding all shapes created through the builder.
     */
    private List<AbstractShape> builderShapes;

    /**
     * A HashMap holding all shapes animations created through the builder.
     */
    private List<IMotion> builderAnimations;

    /**
     * The IModel animation model object that will be built.
     */
    private IModel model;

    /**
     * The constructor for a Builder object.
     */
    public Builder() {
      this.model = new Model();
      this.builderShapes = new ArrayList<>();
      this.builderAnimations = new ArrayList<>();
    }

    private boolean shapeExists(String id) {
      for (IShape shape : this.builderShapes) {
        if (shape.getID().equals(id)) {
          return true;
        }
      }
      return false;
    }

    @Override
    public TweenModelBuilder addOval(String name,
                                     float cx,
                                     float cy,
                                     float xRadius,
                                     float yRadius,
                                     float red,
                                     float green,
                                     float blue,
                                     int startOfLife,
                                     int endOfLife) {

      this.builderShapes.add(new Elipse(name,
              cx,
              cy,
              xRadius,
              yRadius,
              red,
              green,
              blue,
              startOfLife,
              endOfLife));

      IMotion animation = new Motion(name);
      animation.setStartTime(startOfLife);
      animation.setEndTime(endOfLife);
      animation.setStartX(cx);
      animation.setStartY(cy);
      animation.setType(AnimationTypes.CREATE);
      this.builderAnimations.add(animation);
      return this;
    }

    @Override
    public TweenModelBuilder addRectangle(String name,
                                          float lx,
                                          float ly,
                                          float width,
                                          float height,
                                          float red,
                                          float green,
                                          float blue,
                                          int startOfLife,
                                          int endOfLife) {
      this.builderShapes.add(new Rectangle(name,
              lx,
              ly,
              width,
              height,
              red,
              green,
              blue,
              startOfLife,
              endOfLife));

      IMotion animation = new Motion(name);
      animation.setStartTime(startOfLife);
      animation.setEndTime(endOfLife);
      animation.setStartX(lx);
      animation.setStartY(ly);
      animation.setType(AnimationTypes.CREATE);
      this.builderAnimations.add(animation);

      return this;
    }

    @Override
    public TweenModelBuilder addMove(String name,
                                     float moveFromX,
                                     float moveFromY,
                                     float moveToX,
                                     float moveToY,
                                     int startTime,
                                     int endTime) throws IllegalArgumentException {
      if (!(this.shapeExists(name))) {
        String shapeNotFound = String.format("Shape with ID: %s does not exist!", name);
        throw new IllegalArgumentException(shapeNotFound);
      }
      IMotion animation = new Motion(name);
      animation.setStartTime(startTime);
      animation.setEndTime(endTime);
      animation.setStartX(moveFromX);
      animation.setStartY(moveFromY);
      animation.setEndX(moveToX);
      animation.setEndY(moveToY);
      animation.setType(AnimationTypes.MOVE);
      this.builderAnimations.add(animation);

      return this;
    }

    @Override
    public TweenModelBuilder addColorChange(String name,
                                            float oldR,
                                            float oldG,
                                            float oldB,
                                            float newR,
                                            float newG,
                                            float newB,
                                            int startTime,
                                            int endTime) {
      if (!(this.shapeExists(name))) {
        String shapeNotFound = String.format("Shape with ID: %s does not exist!", name);
        throw new IllegalArgumentException(shapeNotFound);
      }
      IMotion animation = new Motion(name);
      animation.setStartTime(startTime);
      animation.setEndTime(endTime);
      animation.setOldColor(oldR, oldG, oldB);
      animation.setColor(newR, newG, newB);
      animation.setType(AnimationTypes.COLOR);
      this.builderAnimations.add(animation);
      return this;
    }

    @Override
    public TweenModelBuilder addScaleToChange(String name,
                                              float fromSx,
                                              float fromSy,
                                              float toSx,
                                              float toSy,
                                              int startTime,
                                              int endTime) {

      if (!(this.shapeExists(name))) {
        String shapeNotFound = String.format("Shape with ID: %s does not exist!", name);
        throw new IllegalArgumentException(shapeNotFound);
      }
      IMotion animation = new Motion(name);
      animation.setStartTime(startTime);
      animation.setEndTime(endTime);
      animation.setStartX(fromSx);
      animation.setStartY(fromSy);
      animation.setEndX(toSx);
      animation.setEndY(toSy);
      animation.setType(AnimationTypes.SCALE);
      this.builderAnimations.add(animation);
      return this;
    }

    @Override
    public Object build() {
      for (IShape shape : this.builderShapes) {
        this.model.addShape(shape.getID(),
                shape.getShapeType(),
                shape.getX(),
                shape.getY(),
                shape.getW(),
                shape.getH(),
                shape.getR(),
                shape.getB(),
                shape.getG(),
                shape.getAppearTime(),
                shape.getDisappearTime());
      }

      for (IMotion animation : this.builderAnimations) {
        AnimationTypes animationType = animation.getType();
        String shapeID = animation.getID();

        switch (animationType) {
          case MOVE:
            this.model.moveShape(shapeID,
                    animation.getStartTime(),
                    animation.getEndTime(),
                    animation.getStartX(),
                    animation.getStartY(),
                    animation.getEndX(),
                    animation.getEndY(),
                    1);
            break;

          case SCALE:
            this.model.scaleShape(shapeID,
                    animation.getStartTime(),
                    animation.getEndTime(),
                    animation.getStartX(),
                    animation.getStartY(),
                    animation.getEndX(),
                    animation.getEndY());
            break;

          case COLOR:
            this.model.setShapeColor(shapeID,
                    animation.getStartTime(),
                    animation.getEndTime(),
                    animation.getOldColor()[0],
                    animation.getOldColor()[1],
                    animation.getOldColor()[2],
                    animation.getColor()[0],
                    animation.getColor()[1],
                    animation.getColor()[2]);
            break;

          default:
            break;
        }
      }

      return this.model;
    }
  }


  private boolean shapeExists(String shapeID) {
    if (this.animatedShapes.get(shapeID) == null) {
      for (String key : this.animatedShapes.keySet()) {
        System.out.println(key);
      }
      System.out.println("\n\n");
      String shapeNotFound = String.format("Shape with ID: %s does not exist!", shapeID);
      throw new IllegalArgumentException(shapeNotFound);
    }
    return true;
  }


  private AbstractShape getShape(String shapeID) {
    if (shapeExists(shapeID)) {
      return this.animatedShapes.get(shapeID);
    }
    return null;
  }

  @Override
  public void addShape(String id,
                       ShapeType type,
                       float x,
                       float y,
                       float w,
                       float h,
                       float r,
                       float g,
                       float b,
                       int startTime,
                       int endTime) throws IllegalArgumentException {
    // if shape with id already exists, throw exception
    AbstractShape shape;

    if (this.animatedShapes.get(id) != null) {
      String shapeAlreadyExists = String.format("Shape with ID: %s already exists!", id);
      throw new IllegalArgumentException(shapeAlreadyExists);
    }

    if (r > 0 && r <= 1) {
      r = r * 255;
    }
    if (g > 0 && g <= 1) {
      g = g * 255;
    }
    if (b > 0 && b <= 1) {
      b = b * 255;
    }

    switch (type) {
      case RECTANGLE:
        shape = new Rectangle(id, x, y, w, h, r, g, b, startTime, endTime);
        break;

      case ELIPSE:
        shape = new Elipse(id, x, y, w, h, r, g, b, startTime, endTime);
        break;


      default:
        shape = null;
    }
    if (shape != null) {
      IMotion newAnimation = new CreateMotion(id);
      newAnimation.setShapeType(shape.getShapeType());
      newAnimation.setStartTime(startTime);
      newAnimation.setEndTime(endTime);
      newAnimation.setStartX(x);
      newAnimation.setStartY(y);
      newAnimation.setEndX(x);
      newAnimation.setEndY(y);
      newAnimation.setOldW(w);
      newAnimation.setOldH(h);
      newAnimation.setScaledW(w);
      newAnimation.setScaledH(h);
      newAnimation.setOldColor(r, g, b);
      newAnimation.setColor(r, g, b);
      shape.allAnimations.add(newAnimation);
      this.animations.add(newAnimation);
      this.animatedShapes.putIfAbsent(id, shape);
    }
  }

  @Override
  public void removeShape(String id) {
    this.animatedShapes.remove(id);
  }



  @Override
  public List<AbstractShape> getAllShapesAtFrame(int frame) {
    //
    List<AbstractShape> result = new ArrayList<>();
    for (String shapeID : this.animatedShapes.keySet()) {

      AbstractShape shape = this.animatedShapes.get(shapeID);
      shape.currentViewAnimations = new ArrayList<>();
      for (IMotion animation : shape.allAnimations) {
        if (animation.getStartTime() == frame
                || (animation.getStartTime() < frame
                && animation.getEndTime() > frame)) {
          shape.addCurrentAnimation(animation);
          if (!result.contains(shape)) {
            result.add(shape);
          }
        }
      }
    }
    return result;
  }

  @Override
  public List<IReadOnlyShape> getAllShapes() {
    List<IReadOnlyShape> allShapes = new ArrayList<>(this.animatedShapes.values());
    return allShapes;
  }


  @Override
  public List<IViewMotions> getAnimations() {
    List<IViewMotions> animationsCopy = new ArrayList<>(this.animations);
    return animationsCopy;
  }


  @Override

  public void scaleShape(String id,
                         int startTime,
                         int endTime,
                         float oldX,
                         float oldY,
                         float newX,
                         float newY) throws IllegalArgumentException {
    if (shapeExists(id)) {
      AbstractShape shape = getShape(id);
      float oldWidth = shape.getW();
      float oldHeight = shape.getH();

      float widthScale = (newX - oldX);
      float heightScale = (newY - oldY);

      if (widthScale + shape.getW() < 0) {
        shape.setW(Math.abs(widthScale));
      }

      if (heightScale + shape.getH() < 0) {
        shape.setH(Math.abs(heightScale));
      }

      IMotion newAnimation = new ScaleMotion(id);
      newAnimation.setShapeType(shape.getShapeType());
      newAnimation.setStartTime(startTime);
      newAnimation.setEndTime(endTime);

      newAnimation.setStartX(shape.getLastAnimation().getEndX());
      newAnimation.setStartY(shape.getLastAnimation().getEndY());
      newAnimation.setEndX(shape.getLastAnimation().getEndX());
      newAnimation.setEndY(shape.getLastAnimation().getEndY());

      newAnimation.setOldColor(shape.getR(), shape.getG(), shape.getB());
      newAnimation.setColor(shape.getR(), shape.getG(), shape.getB());

      newAnimation.setOldW(shape.getW());
      newAnimation.setOldH(shape.getH());
      newAnimation.setScaledW(shape.getW() + widthScale);
      newAnimation.setScaledH(shape.getH() + heightScale);

      shape.setW(shape.getW() + widthScale);
      shape.setH(shape.getH() + heightScale);

      shape.getLastAnimation().setEndTime(startTime);

      shape.allAnimations.add(newAnimation);
      this.animations.add(newAnimation);
      this.animatedShapes.put(id, shape);
    }
  }

  @Override
  public void moveShape(String shapeID,
                        int startTime,
                        int endTime,
                        float startX,
                        float startY,
                        float endX,
                        float endY,
                        int speed) throws IllegalArgumentException, IllegalStateException {

    if (speed < 1 || speed > 3) {
      throw new IllegalArgumentException("speed should be between 1-3");
    }

    if (startTime == endTime) {
      throw new IllegalArgumentException("time interval must be greater th0a01n 0!");
    }

    if (shapeExists(shapeID)) {
      AbstractShape shape = getShape(shapeID);
      float newMoveXDirection = endX - startX;
      float newMoveYDirection = endY - startY;

      for (IMotion animation : shape.allAnimations) {
        if (  (animation.getStartTime() == startTime || animation.getEndTime() == endTime)

                // existing animation starts after this attempted move starts
                // and ends before attempted move ends -> existing move is sandwiched
                || (animation.getStartTime() > startTime
                && animation.getEndTime() < endTime)

                // existing animation starts before this attempted move starts
                // and ends after attempted move ends -> attempted move is sandwiched
                || (animation.getStartTime() < startTime
                && animation.getEndTime() > endTime)

                // existing animation starts before attempted move ends
                || (animation.getStartTime() > startTime
                && animation.getStartTime() < endTime)

                // attempted move starts before existing move ends
                || (animation.getStartTime() < startTime
                && animation.getEndTime() > startTime)

        ) {
          if (animation.getType() == AnimationTypes.MOVE) {
            // if xdirection is < 0, direction is left
            // id ydirection is < 0, direction is down
            float xDirection = animation.getEndX() - animation.getStartX();
            float yDirection = animation.getEndY() - animation.getStartY();

            if ((xDirection < 0 && newMoveXDirection > 0)
                    || (xDirection > 0 && newMoveXDirection < 0)
                    || (yDirection < 0 && newMoveYDirection > 0)
                    || (yDirection > 0 && newMoveYDirection < 0)) {
              String conflictString = String.format("Cannot move shape. The shape "
                              + "is already moving in a conflicting "
                              + "direction during this time interval.\n"
                              + "%s shape: %s moving from (%d, %d) to "
                              + "(%d, %d) from time t1 = %d to t2 = %d",
                      shape.shapeType.name(), shapeID,
                      animation.getStartX(), animation.getStartY(),
                      animation.getEndX(), animation.getEndY(),
                      animation.getStartTime(),
                      animation.getEndTime());
              throw new IllegalStateException(conflictString);
            }
          }
        }
      }

      IMotion newAnimation = new MoveMotion(shapeID);
      newAnimation.setShapeType(shape.getShapeType());
      newAnimation.setStartTime(startTime);
      newAnimation.setEndTime(endTime);
      newAnimation.setStartX(startX);
      newAnimation.setStartY(startY);
      newAnimation.setEndX(endX);
      newAnimation.setEndY(endY);
      newAnimation.setOldColor(shape.getR(), shape.getG(), shape.getB());
      newAnimation.setColor(shape.getR(), shape.getG(), shape.getB());
      if (newAnimation.doesOverlap(shape.getLastAnimation())) {
        shape.getLastAnimation().setEndTime(startTime);
      }

      newAnimation.setOldW(shape.getW());
      newAnimation.setOldH(shape.getH());
      newAnimation.setScaledW(shape.getW());
      newAnimation.setScaledH(shape.getH());
      newAnimation.setNewSpeed(speed);
      newAnimation.setType(AnimationTypes.MOVE);
      shape.allAnimations.add(newAnimation);
      this.animations.add(newAnimation);
      this.animatedShapes.putIfAbsent(shapeID, shape);

    }
  }

  @Override
  public void setShapeColor(String shapeID,
                            int startTime,
                            int endTime,
                            float oldR,
                            float oldG,
                            float oldB,
                            float r,
                            float g,
                            float b) throws IllegalArgumentException {
    if (r < 0
            || g < 0
            || b < 0
            || r > 255
            || g > 255
            || b > 255) {
      throw new IllegalArgumentException("R, G, B values must be between 0 and 255!");
    }

    if (r > 0 && r <= 1) {
      r = r * 255;
    }
    if (g > 0 && g <= 1) {
      g = g * 255;
    }
    if (b > 0 && b <= 1) {
      b = b * 255;
    }

    if (shapeExists(shapeID)) {
      AbstractShape shape = getShape(shapeID);
      IMotion newAnimation = new ColorMotion(shapeID);
      shape.setR(r);
      shape.setG(g);
      shape.setB(b);

      newAnimation.setStartTime(startTime);
      newAnimation.setStartX(shape.getLastAnimation().getEndX());
      newAnimation.setStartY(shape.getLastAnimation().getEndY());
      newAnimation.setEndX(shape.getLastAnimation().getEndX());
      newAnimation.setEndY(shape.getLastAnimation().getEndY());

      newAnimation.setShapeType(shape.getShapeType());
      newAnimation.setEndTime(endTime);
      newAnimation.setOldColor(oldR, oldG, oldB);
      newAnimation.setColor(r, g, b);
      newAnimation.setOldW(shape.getW());
      newAnimation.setScaledW(shape.getW());
      newAnimation.setOldH(shape.getH());
      newAnimation.setScaledH(shape.getH());

      if (newAnimation.doesOverlap(shape.getLastAnimation())) {
        float lastAnimationXDist =
                shape.getLastAnimation().getEndX() - shape.getLastAnimation().getStartX();

        float lastAnimationYDist =
                shape.getLastAnimation().getEndY() - shape.getLastAnimation().getStartY();

        float lastAnimationDuration =
                shape.getLastAnimation().getEndTime() - shape.getLastAnimation().getStartTime();

        float xDistEachTick = lastAnimationXDist / lastAnimationDuration;
        float yDistEachTick = lastAnimationYDist / lastAnimationDuration;

        newAnimation.setEndTime(shape.getLastAnimation().getEndTime());
        newAnimation.setOldW(shape.getLastAnimation().getScaledW());
        newAnimation.setOldH(shape.getLastAnimation().getScaledH());
        newAnimation.setScaledW(shape.getLastAnimation().getScaledW());
        newAnimation.setScaledH(shape.getLastAnimation().getScaledH());

        shape.getLastAnimation().setEndTime(startTime);
        shape.getLastAnimation().setEndX(shape.getLastAnimation().getStartX()
                                          + xDistEachTick * startTime);

        shape.getLastAnimation().setEndY(shape.getLastAnimation().getStartY()
                                          + yDistEachTick * startTime);

        newAnimation.setStartX(shape.getLastAnimation().getEndX());
        newAnimation.setStartY(shape.getLastAnimation().getEndY());
      }

      shape.allAnimations.add(newAnimation);
      this.animations.add(newAnimation);
      this.animatedShapes.putIfAbsent(shapeID, shape);
    }

  }

}
