package cs5004.animator.controller;


import java.util.List;
import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.view.IView;
import cs5004.animator.model.IModel;




/**
 * This is an class representing a simple text-based animation Controller. This class implements
 * the IController interface.
 */
public class TextController implements IController {
  private int framesPerSecond;
  private List<IReadOnlyShape> readOnlyShapes;
  private IModel model;
  private IView view;

  /**
   * The constructor for a simple animation Controller.
   * @param model an IModel object that will act as the animation's model.
   * @param view an IView object that will act as the animation's view.
   * @throws IllegalStateException if the model and/or view isn't properly instantiated.
   */
  public TextController(IModel model, IView view) throws IllegalStateException {
    this.framesPerSecond = 1;
    this.model = model;
    this.view = view;

    if (model == null) {
      throw new IllegalStateException("Cannot get model.");
    }

    if (view == null) {
      throw new IllegalStateException("Cannot get view.");
    }

  }


  @Override
  public void setData(List<IReadOnlyShape> data) {
    return;
  }

  @Override
  public void run() {
    this.view.setData(this.readOnlyShapes);
    this.view.setFps(this.framesPerSecond);
    try {
      this.view.render();
    }
    catch (Exception e) {
      System.err.println("Cannot run animation from controller. See run() method.");
    }

  }

  @Override
  public void getAllShapes() {
    this.readOnlyShapes = this.model.getAllShapes();
  }

  @Override
  public void setFramesPerSecond(int fps) {
    this.framesPerSecond = fps;
  }
}
