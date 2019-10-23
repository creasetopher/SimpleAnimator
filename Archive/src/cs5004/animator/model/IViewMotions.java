package cs5004.animator.model;

/**
 * An interface representing an animation. AN animation is meant to be
 * coupled with a particular shape. This interface provides all the methods
 * needed in for an animation.
 */
public interface IViewMotions {

  /**
   * Gets the ID associated with an animation.
   * @return an string representing the animation's ID.
   */
  String getID();

  /**
   * Gets the shape type of the shape associated with an animation.
   * @return an ShapeType object representing the associated shape's type.
   */
  ShapeType getShapeType();

  /**
   * Gets the start time for an animation.
   * @return an int representing the animation's start time.
   */
  int getStartTime();

  /**
   * Gets the end time for an animation.
   * @return an int representing the animation's end time.
   */
  int getEndTime();

  /**
   * Gets the current shape-height for an animation.
   * @return an int representing the associated shape's height at
   *          the time of the animation.
   */
  float getScaledH();

  /**
   * Gets the current shape-width for an animation.
   * @return an int representing the associated shape's width at
   *          the time of the animation.
   */
  float getScaledW();

  /**
   * Gets the old height for an animation.
   */
  float getOldH();

  /**
   * Gets the old width for an animation.
   */
  float getOldW();


  /**
   * Gets the animation's starting x point.
   * @return an int representing the animation's starting x point.
   */
  float getStartX();

  /**
   * Gets the animation's starting y point.
   * @return an int representing the animation's starting y point.
   */
  float getStartY();

  /**
   * Gets the animation's ending x point.
   * @return an int representing the animation's ending x point.
   */
  float getEndX();

  /**
   * Gets the animation's ending y point.
   * @return an int representing the animation's ending y point.
   */
  float getEndY();

  /**
   * Gets the animation's current speed.
   * @return an int representing the animation's speed.
   */
  int getNewSpeed();

  /**
   * Gets the animation's old/previous speed.
   * @return an int representing the animation's speed.
   */
  int getOldSpeed();

  /**
   * Gets the animation's type.
   * @return an AnimationTypes enum value represeting the animation's type.
   */
  AnimationTypes getType();

  /**
   * Gets the color of the shape associated with the animation.
   * @return an array-like string representing the associated shape's R,G,B values.
   */
  float[] getColor();

  /**
   * Gets the old color (i.e. before any color changes)
   * of the shape associated with the animation.
   * @return an array-like string representing the associated shape's R,G,B values.
   */
  float[] getOldColor();

  /**
   * Gets the visbility of the shape associated with the animation.
   * @return a boolean representing the associated shape's visibility.
   */
  boolean getVisibility();

  /**
   * Gets the tween x-value of the shape animation at a given frame.
   * @return a float that is the animation's tween x-value at a given frame.
   */
  float getTweenX();

  /**
   * Gets the tween y-value of the shape animation at a given frame.
   * @return a float that is the animation's tween y-value at a given frame.
   */
  float getTweenY();

  /**
   * Gets the tween width of the shape animation at a given frame.
   * @return a float that is the animation's tween width at a given frame.
   */
  float getTweenW();

  /**
   * Gets the tween height of the shape animation at a given frame.
   * @return a float that is the animation's tween height at a given frame.
   */
  float getTweenH();

  /**
   * Gets the tween r, g, b-values of the shape animation at a given frame.
   * @return a float that is the animation's tween r, g, b-values at a given frame.
   */
  float[] getTweenColor();

  /**
   * Determines whether two animations overlap in time.
   * @param other another animation to compare with this animation.
   * @return a boolean indicating whether the two animations overlap or not.
   */
  boolean doesOverlap(IMotion other);

}
