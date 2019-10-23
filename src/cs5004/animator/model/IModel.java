package cs5004.animator.model;


import java.util.List;

/**
 * An interface representing a model for describing an animation.
 *
 */
public interface IModel {

  /**
   * Creates a shape and adds it to the model.
   *
   * @param id   the id to be associated with the shape object.
   * @param type the shape type.
   * @param x    the starting x-value of the shape object.
   * @param y    the starting y-value of the shape object.
   * @param w    the initial width of the shape object.
   * @param h    the initial height of the shape object.
   * @throws IllegalArgumentException if a shape with the passed in id already exists in the model.
   */
  void addShape(String id,
                ShapeType type,
                float x,
                float y,
                float w,
                float h,
                float r,
                float g,
                float b,
                int startTime,
                int endTime) throws IllegalArgumentException;

  /**
   * Removes a shape from the model.
   *
   * @param id the id to be associated with the shape object.
   */
  void removeShape(String id);


  // returns the abstract shape instead of the interface
  // because we want to hide interface from user

  /**
   * Gets all the shapes at a particular frame.
   *
   * @param frame a particular frame of interest.
   * @return an array containing all shapes that exist at the given frame.
   */
  List<AbstractShape> getAllShapesAtFrame(int frame);

  /**
   * Gets all the shapes created through the model.
   *
   * @return an array containing all shapes that exist.
   */
  List<IReadOnlyShape> getAllShapes();


  /**
   * Transcribes the entire animation to a string.
   *
   * @return an string describing the entire animation.
   */
  List<IViewMotions> getAnimations();


  /**
   * Scales the size of a particular shape at a given time.
   *
   * @param id        the id associated with a shape object.
   * @param startTime the starting time/frame in which the size will be changed.
   * @param endTime   the ending time/frame in which the size will be changed.
   * @param oldX      the initial x-value of the shape object.
   * @param oldY      the initial y-value of the shape object.
   * @param newX      the new x-value of the shape object once it's been scaled.
   * @param newY      the new y-value of the shape object once it's been scaled.
   * @throws IllegalArgumentException if a shape with the passed in id does not exist.
   */
  void scaleShape(String id,
                  int startTime,
                  int endTime,
                  float oldX,
                  float oldY,
                  float newX,
                  float newY) throws IllegalArgumentException;

  /**
   * Moves a particular shape at a given time with a given speed.
   *
   * @param shapeID   the id associated with a shape object.
   * @param startTime the starting time/frame in which the shape will move.
   * @param endTime   the ending time/frame in which the shape will move.
   * @param startX    initial x point from which the shape is being moved.
   * @param startY    initial y point from which the shape is being moved.
   * @param endX      ending x point from which the shape is being moved.
   * @param endY      ending x point from which the shape is being moved.
   * @param speed     the speed with which the shape object will move.
   * @throws IllegalArgumentException if a shape with the passed in id does not exist or the
   *                                  newSpeed is < 1 or > 3 or if the time interval is 0 (i.e.
   *                                  startTime == endTime).
   */
  void moveShape(String shapeID,
                 int startTime,
                 int endTime,
                 float startX,
                 float startY,
                 float endX,
                 float endY,
                 int speed) throws IllegalArgumentException;

  /**
   * Sets the color of a shape at a given time.
   *
   * @param shapeID   the id associated with a shape object.
   * @param r         an r-value describing the amount of red in the shape's color.
   * @param g         an g-value describing the amount of green in the shape's color.
   * @param b         an b-value describing the amount of blue in the shape's color.
   * @param startTime the starting time/frame in which the shape will move.
   * @param endTime   the ending time/frame in which the shape will move.
   * @throws IllegalArgumentException if a shape with the passed in id does not exist or the time
   *                                  interval is 0 (i.e. startTime == endTime).
   */
  void setShapeColor(String shapeID,
                     int startTime,
                     int endTime,
                     float oldR,
                     float oldG,
                     float oldB,
                     float r,
                     float g,
                     float b) throws IllegalArgumentException;


}



