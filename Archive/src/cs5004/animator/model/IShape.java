package cs5004.animator.model;

import java.util.List;

/**
 * An interface for all animated shapes. This interface extends the
 * IReadOnly interface and contains all the necessary methods used by a shape object.
 */

public interface IShape extends IReadOnlyShape {

  /**
   * Sets a shape's width.
   * @param w the shape's width.
   */
  void setW(float w);

  /**
   * Sets a shape's height.
   * @param h the shape's height.
   */
  void setH(float h);

  /**
   * Sets a shape's R-value representing the red-value of a shape's color.
   * @param r an r-value
   */
  void setR(float r);

  /**
   * Sets a shape's G-value representing the green-value of a shape's color.
   * @param g a g-value
   */
  void setG(float g);

  /**
   * Sets a shape's B-value representing the blue-value of a shape's color.
   * @param b a b-value
   */
  void setB(float b);

  /**
   * Gets a list of animations associated with the shape.
   * @return a list of animations associated with the shape.
   */
  List<IMotion> getAnimations();

  /**
   * Adds an animation to a shapes list of current animations (i.e. animations at a given frame).
   * @param animation the animation to be added.
   */
  void addCurrentAnimation(IMotion animation);

  /**
   * Gets the last animation in a shapes list of all animations.
   * @return a shape's most recent/last animation.
   */
  IMotion getLastAnimation();

}
