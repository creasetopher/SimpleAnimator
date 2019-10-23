package cs5004.animator.controller;

import cs5004.animator.model.IReadOnlyShape;
import java.util.List;

/**
 * An interface representing a controller for controlling an animation.
 */
public interface IController {

  /**
   * Set's the controller's data. Intended to be called once the controller has received
   * animation data from model.
   */
  void setData(List<IReadOnlyShape> data);

  /**
   * Runs the view.
   */
  void run();

  /**
   * Sets the frame per seconds which the controller will use to run the animation.
   */
  void setFramesPerSecond(int fps);

  /**
   * Gets all shapes that exist within the animation and stores them as a list as an
   * attribute of the controller object.
   */
  void getAllShapes();

}
