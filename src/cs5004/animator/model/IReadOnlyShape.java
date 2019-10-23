package cs5004.animator.model;

import java.util.List;

/**
 * An interface for all animated shapes. This interface contains
 * all the read-only operations that may be used by a shape object
 * to get specific attributes.
 */
public interface IReadOnlyShape {

  /**
   * Returns the x value of a shape. This is seen as a reference point for the shape
   * within the animation frame.
   * @return an int representing the shapes x-value.
   */
  float getX();

  /**
   * Returns the y value of a shape. This is seen as a reference point for the shape
   * within the animation frame.
   * @return an int representing the shapes y-value.
   */
  float getY();

  /**
   * Returns the width of a shape.
   * @return an int representing the shapes width.
   */
  float getW();

  /**
   * Returns the height of a shape.
   * @return an int representing the shapes height.
   */
  float getH();

  /**
   * Returns the R-value representing the initial red-value of a shape's color.
   * @return an int representing the shapes red-value.
   */
  float getR();

  /**
   * Returns the G-value representing the initial green-value of a shape's color.
   * @return an int representing the shapes green-value.
   */
  float getG();

  /**
   * Returns the B-value representing the initial blue-value of a shape's color.
   * @return an int representing the shapes blue-value.
   */
  float getB();

  /**
   * Returns a shape's type.
   * @return a ShapeType enum value describing the shape's type.
   */
  ShapeType getShapeType();

  /**
   * Returns a shape's ID.
   * @return a String representing the shape's ID.
   */
  String getID();

  /**
   * Returns a shape's appear time.
   * @return an int representing the shape's appear time.
   */
  int getAppearTime();

  /**
   * Returns a shape's disappear time.
   * @return an int representing the shape's disappear time.
   */
  int getDisappearTime();

  /**
   * Returns a list of animations associated with the shape.
   * @return a list of IViewMotions animations.
   */
  public List<IViewMotions> getViewAnimations();


  /**
   * Returns a list of animations associated with the shape at a given frame/tick.
   * @return a list of IViewMotions animations at a given frame.
   */
  List<IMotion> getCurrentViewAnimations();

}
