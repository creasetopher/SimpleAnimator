package cs5004.animator.view;


import java.io.IOException;
import java.util.List;

import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.model.IViewMotions;

/**
 * An interface representing an animation view. This interface provides all the methods
 * needed for an animation view.
 */
public interface IView {

  /**
   * Renders the data to display using the view.
   */
  void render() throws IOException;

  /**
   * Sets the data which the view will render.
   *
   * @param readOnlyShapes A List of readOnlyShapes that appear in the animation.
   */
  void setData(List<IReadOnlyShape> readOnlyShapes);


  /**
   * Gets the data from which the view will render.
   *
   * @return a list representing the view's data.
   */
  List<IReadOnlyShape> getData();


  /**
   * Adds a animation to the view's data. Intended for use with a GUI View.
   *
   * @param motion an animation to add to the view's data.
   */
  void addData(IViewMotions motion);

  /**
   * Clears all animations from the view's data. Intended for use with a GUI View.
   */
  void clearData();

  /**
   * Determines whether the view is currently playing an animation.
   *
   * @return a boolean indicating whether the animation is currently playing or not.
   */
  boolean getPlayState();

  /**
   * Determines whether a restart has been triggered by the user.
   *
   * @return a boolean indicating whether the user has requested a restart of the animation.
   */
  boolean isRestartTriggered();

  /**
   * Resets the restart trigger (usually called after an animation is restarted).
   */
  void resetRestart();

  /**
   * Sets the frames per second that the view will use to display the animation.
   *
   * @param fps the user-provided frames/ticks per second with which the animation will run.
   */
  void setFps(int fps);

}