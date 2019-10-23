package cs5004.animator.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.model.IViewMotions;

/**
 * This is a class representing a simple Text view for an animation. This class implements
 * the IView interface.
 */
public class TextView implements IView {

  /**
   * The frames per second that the view will use to display the animation.
   */
  private int fps;

  /**
   * The shapes that will be animated through the view.
   */
  private List<IReadOnlyShape> shapeData;

  /**
   * The extracted animations from each shape that will be animated through the view.
   */
  private List<IViewMotions> rawData;

  @Override
  public void addData(IViewMotions motion) {
    return;
  }

  @Override
  public void clearData() {
    this.rawData = new ArrayList<>();
  }

  @Override
  public boolean getPlayState() {
    return false;
  }

  @Override
  public boolean isRestartTriggered() {
    return false;
  }

  @Override
  public void resetRestart() {
    return;
  }

  private Appendable dataIn;

  /**
   * The constructor for a simple Text view object for an animation.
   * @param output the output destination where the view will be displayed.
   * @throws FileNotFoundException if the output parameter is a filename that cannot be located.
   */
  public TextView(String output) throws FileNotFoundException {
    if (output.equals("out")) {
      this.dataIn = new PrintStream(System.out);
    }
    else {
      try {
        this.dataIn = new PrintStream("./" + output);
      }
      catch (Exception e) {
        throw new FileNotFoundException("Output file not found!");
      }
    }
    this.rawData = new ArrayList<>();
    this.fps = 1;
  }

  /**
   * Appends data to an the views Appendable object attribute.
   * @param data the data to be appended.
   * @throws IOException if there's an error appending the data to the appendable.
   */
  private void appendWithCatch(String data) throws IOException {
    try {
      this.dataIn.append(data);
    }
    catch (IOException e) {
      throw new IOException("Unable to transmit data to output");
    }
  }




  @Override
  public void render() throws IOException {

    for (IViewMotions animation : this.rawData) {

      switch (animation.getType()) {

        case MOVE:
          String moveString = StringBuilder.generateMoveString(animation, this.fps);
          this.appendWithCatch(moveString + "\n\n");
          break;

        case SPEED_CHANGE:
          String speedString = StringBuilder.generateSpeedString(animation, this.fps);
          this.appendWithCatch(speedString + "\n\n");
          break;

        case CREATE:
          String createString = StringBuilder.generateCreateString(animation, this.fps);

          this.appendWithCatch(createString + "\n\n");
          break;

        case COLOR:
          String colorString = StringBuilder.generateColorString(animation, this.fps);
          this.appendWithCatch(colorString + "\n\n");
          break;

        case SCALE:
          String scaleString = StringBuilder.generateScaleString(animation, this.fps);
          this.appendWithCatch(scaleString + "\n\n");
          break;


        default:
          this.appendWithCatch("Unknown Animation.\n\n");
      }
    }
    this.dataIn.append("\n\n");
  }


  @Override
  public void setData(List<IReadOnlyShape> readOnlyShapes) {
    this.shapeData = readOnlyShapes;
    List<IViewMotions> allMotions = new ArrayList<>();
    for (IReadOnlyShape shape : readOnlyShapes) {
      for (IViewMotions motion : shape.getViewAnimations()) {
        if (motion != null) {
          allMotions.add(motion);
        }
      }
    }
    allMotions.sort(new MotionSort());
    this.rawData = allMotions;
  }


  @Override
  public List<IReadOnlyShape> getData() {
    return this.shapeData;
  }

  @Override
  public void setFps(int fps) {
    this.fps = fps;
  }
}
