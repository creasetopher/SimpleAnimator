package cs5004.animator.model;


import java.util.ArrayList;
import java.util.List;

/**
 * This is an abstract class for all animated shapes. This class implements
 * the IShape interface.
 */
public abstract class AbstractShape implements IShape {

  protected int appearTime;

  protected int disappearTime;

  /**
   * the starting x-value of the shape object.
   */
  protected float x;

  /**
   * the starting y-value of the shape object.
   */
  protected float y;

  /**
   * the starting width of the shape object.
   */
  protected float w;

  /**
   * the starting height of the shape object.
   */
  protected float h;

  /**
   * the starting r-value of the shape object's color.
   */
  protected float r;

  /**
   * the starting g-value of the shape object's color.
   */
  protected float g;

  /**
   * the starting b-value of the shape object's color.
   */
  protected float b;


  /**
   * the the shape object's type.
   */
  protected ShapeType shapeType;

  /**
   * the the shape object's ID.
   */
  protected String id;

  /**
   * An array of animations associated with the shape object.
   */
  protected List<IMotion> allAnimations;

  /**
   * A boolean indicating whether the shape's ID has been set.
   */
  protected boolean idIsSet;

  protected List<IMotion> currentViewAnimations;



  /**
   * A constructor for an Abstract shape object.
   * @param x the starting x-value of the shape object.
   * @param y the starting y-value of the shape object.
   * @param w the starting width of the shape object.
   * @param h the starting height of the shape object.
   * @param r the red-value of the shape object's color.
   * @param g the green-value of the shape object's color.
   * @param b the blue-value of the shape object's color.
   * @param appearTime the frame in which the shape object appears in the animation.
   * @param disappearTime the frame in which the shape object disappears in the animation.
   */
  protected AbstractShape(String shapeID,
                          float x,
                          float y,
                          float w,
                          float h,
                          float r,
                          float g,
                          float b,
                          int appearTime,
                          int disappearTime) throws IllegalArgumentException {
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("Height and width must be positive!");
    }
    this.id = shapeID;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.b = b;
    this.g = g;
    this.appearTime = appearTime;
    this.disappearTime = disappearTime;
    this.allAnimations = new ArrayList<>();

  }




  @Override
  public float getX() {
    return this.x;
  }

  @Override
  public float getY() {
    return this.y;
  }

  @Override
  public float getW() {
    return this.w;
  }

  @Override
  public float getH() {
    return this.h;
  }

  @Override
  public float getR() {
    return this.r;
  }

  @Override
  public float getG() {
    return this.g;
  }

  @Override
  public float getB() {
    return this.b;
  }

  @Override
  public String getID() {
    return this.id;
  }

  @Override
  public ShapeType getShapeType() {
    return this.shapeType;
  }

  @Override
  public List<IMotion> getAnimations() {
    return this.allAnimations;
  }

  @Override
  public List<IViewMotions> getViewAnimations() {
    List<IViewMotions> shapeAnimations = new ArrayList<>();
    for (IMotion animation : this.allAnimations) {
      shapeAnimations.add(animation);
    }
    return shapeAnimations;
  }

  @Override
  public void addCurrentAnimation(IMotion animation) {
    this.currentViewAnimations.add(animation);
  }

  @Override
  public List<IMotion> getCurrentViewAnimations() {
    return this.currentViewAnimations;
  }

  @Override
  public IMotion getLastAnimation() {
    List<IMotion> allAnimations = this.getAnimations();
    return allAnimations.get(allAnimations.size() - 1);
  }

  @Override
  public void setW(float w) {
    this.w = w;
  }

  @Override
  public void setH(float h) {
    this.h = h;
  }

  @Override
  public int getAppearTime() {
    return this.appearTime;
  }

  @Override
  public int getDisappearTime() {
    return this.disappearTime;
  }

  @Override
  public void setR(float r) {
    this.r = r;
  }

  @Override
  public void setG(float g) {
    this.g = g;
  }

  @Override
  public void setB(float b) {
    this.b = b;
  }

}
