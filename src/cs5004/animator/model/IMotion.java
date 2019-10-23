package cs5004.animator.model;


/**
 * An interface representing an animation. AN animation is meant to be
 * coupled with a particular shape. This interface provides all the methods
 * needed in for an animation.
 */
public interface IMotion extends IViewMotions {

  void setShapeType(ShapeType shapeType);

  /**
   * Sets the start time for an animation.
   * @param t1 the time in which the animation will start.
   */
  void setStartTime(int t1);

  /**
   * Sets the end time for an animation.
   * @param t2 the time in which the animation will end.
   */
  void setEndTime(int t2);

  /**
   * Sets the scaled height for an animation.
   * @param scaledH the new scaled height for the related shape.
   */
  void setScaledH(float scaledH);

  /**
   * Sets the scaled width for an animation.
   * @param scaledW the new scaled width for the related shape.
   */
  void setScaledW(float scaledW);

  /**
   * Sets the scaled width for an animation.
   * @param oldH the old scaled width for the related shape.
   */
  void setOldH(float oldH);

  /**
   * Sets the scaled width for an animation.
   * @param oldW the old width for the related shape.
   */
  void setOldW(float oldW);


  /**
   * Sets the animation's starting x point.
   * @param x the animation's starting x point.
   */
  void setStartX(float x);

  /**
   * Sets the animation's starting y point.
   * @param y the animation's starting y point.
   */
  void setStartY(float y);

  /**
   * Sets the animation's ending x point.
   * @param x the animation's ending x point.
   */
  void setEndX(float x);

  /**
   * Sets the animation's ending y point.
   * @param y the animation's ending x point.
   */
  void setEndY(float y);

  /**
   * Sets the animation's current speed.
   * @param speed the animation's speed.
   */
  void setNewSpeed(int speed);

  /**
   * Sets the animation's old/previous speed.
   * @param speed the animation's speed.
   */
  void setOldSpeed(int speed);

  /**
   * Sets the animation's type.
   * @param type the animation's type.
   */
  void setType(AnimationTypes type);

  /**
   * Sets the color of the shape associated with the animation.
   * @param r an r-value describing the amount of red in the shape's color.
   * @param g an g-value describing the amount of green in the shape's color.
   * @param b an b-value describing the amount of blue in the shape's color.
   */
  void setColor(float r, float g, float b);

  /**
   * Sets the old/previous color of the shape associated with the animation.
   * @param r an r-value describing the amount of red in the shape's color.
   * @param g an g-value describing the amount of green in the shape's color.
   * @param b an b-value describing the amount of blue in the shape's color.
   */
  void setOldColor(float r, float g, float b);


  /**
   * Sets the visibility of the shape associated with the animation.
   * @param visibility a boolean describing the visibility of a shape.
   */
  void setVisibility(boolean visibility);

  /**
   * Sets the tween x-value of the shape animation at a given frame using linear interpolation.
   * @param tick the frame used to calculate the tween-value.
   */
  void setTweenX(float tick);

  /**
   * Sets the tween y-value of the shape animation at a given frame using linear interpolation.
   * @param tick the frame used to calculate the tween-value.
   */
  void setTweenY(float tick);

  /**
   * Sets the tween width of the shape animation at a given frame using linear interpolation.
   * @param tick the frame used to calculate the tween-value.
   */
  void setTweenW(float tick);

  /**
   * Sets the tween height of the shape animation at a given frame using linear interpolation.
   * @param tick the frame used to calculate the tween-value.
   */
  void setTweenH(float tick);

  /**
   * Sets the tween r, g, b-values of the shape animation at a given frame
   * using linear interpolation.
   * @param tick the frame used to calculate the tween-value.
   */
  void setTweenColor(float tick);


}
