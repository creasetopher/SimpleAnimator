package cs5004.animator.controller;

//import cs5004.animator.model.AnimationTypes;
import cs5004.animator.model.IMotion;
import cs5004.animator.model.IReadOnlyShape;
//import cs5004.animator.model.IViewMotions;
//import cs5004.animator.view.AnimationPanel;
//import cs5004.animator.view.GUIView;
import cs5004.animator.view.IView;
import cs5004.animator.model.IModel;

import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

/**
 * This is a class representing a simple GUI Controller. This class implements
 * the IController interface.
 */
public class GUIController implements IController {

  /**
   * the frames per second that will be transmitted to the view when rendering the animation.
   */
  private int fps;

  /**
   * the animation data provided by model which is transmitted to the view.
   */
  private List<IReadOnlyShape> data;

  /**
   * the animation model.
   */
  private IModel model;

  /**
   * the animation view.
   */
  private IView view;

  /**
   * A timer used to consistently run the animation.
   */
  private Timer timer;

  /**
   * the animation frame to request from model.
   */
  private int currentFrame;

  /**
   * The constructor for a simple GUI view object for an animation.
   * @param model the model used in the animation.
   * @param view the view used in the animation.
   */
  public GUIController(IModel model, IView view) {
    this.fps = 1;
    this.view = view;
    this.model = model;
    this.currentFrame = 0;
    this.data = null;
  }


  @Override
  public void run() {
    this.timer.start();
  }

  @Override
  public void setData(List<IReadOnlyShape> shapes) {
    this.data = shapes;
  }

  @Override
  public void setFramesPerSecond(int fps) {
    this.fps = fps;
    int delay = (int)((1 / (float)this.fps) * 1000);


    this.timer = new Timer( delay, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        if (view.isRestartTriggered()) {
          timer.stop();
          currentFrame = 0;
          timer.start();
          view.resetRestart();
        }

        if (view.getPlayState()) {

          List<IReadOnlyShape> viewShapes;

          viewShapes = new ArrayList<IReadOnlyShape>(model.getAllShapesAtFrame(currentFrame));
          view.clearData();
          for (IReadOnlyShape shape : viewShapes) {
            for (IMotion currentAnimation : shape.getCurrentViewAnimations()) {

              currentAnimation.setTweenX(currentFrame);
              currentAnimation.setTweenY(currentFrame);
              currentAnimation.setTweenH(currentFrame);
              currentAnimation.setTweenW(currentFrame);
              currentAnimation.setTweenColor(currentFrame);
              view.addData(currentAnimation);

            }
          }

          setData(viewShapes);
          try {
            view.render();
          } catch (Exception excp) {
            throw new IllegalStateException("Cannot render data!");
          }

          currentFrame++;
        }
      }
    });
  }

  @Override
  public void getAllShapes() {
    return;
  }
}
