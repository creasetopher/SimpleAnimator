package cs5004.animator.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.model.IViewMotions;
import cs5004.animator.model.ShapeType;

/**
 * This is a class representing an SVG view. The SVG view can generate a formatted XML-like
 * string that complies with the SVG structure. This class implements the IView interface.
 */
public class SVGView implements IView {
  private List<IReadOnlyShape> rawData;
  private Appendable dataIn;
  private int fps;

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

  /**
   * The constructor for an SVG view object that can be for an animation.
   * @param output the output destination where the view will be displayed.
   * @throws FileNotFoundException if the output parameter is a filename that cannot be located.
   */
  public SVGView(String output)throws FileNotFoundException {
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
    float maxHeight = 0;
    float maxWidth = 0;
    String animationSequence = "";

    for (IReadOnlyShape shape : this.rawData) {

      for (IViewMotions animation : shape.getViewAnimations()) {

        if (animation.getEndX() + shape.getW() > maxWidth) {
          maxWidth = animation.getEndX() + shape.getW();
        }
        if (animation.getEndY() + shape.getH() > maxHeight) {
          maxHeight = animation.getEndY() + shape.getH();
        }
        switch (animation.getType()) {

          case MOVE:
            String moveString = SVGBuilder.generateMoveString(animation, this.fps);
            animationSequence += moveString + "\n";
            break;

          case SPEED_CHANGE:
            String speedString = SVGBuilder.generateSpeedString(animation, this.fps);
            animationSequence += speedString + "\n";
            break;

          case CREATE:
            String createString = SVGBuilder.generateCreateString(animation, this.fps);
            animationSequence += createString + "\n";
            break;

          case COLOR:
            String colorString = SVGBuilder.generateColorString(animation, this.fps);
            animationSequence += colorString + "\n";
            break;

          case SCALE:
            String scaleString = SVGBuilder.generateScaleString(animation, this.fps);
            animationSequence += scaleString + "\n";
            break;

          default:
            this.appendWithCatch("Unknown Animation.\n\n");
        }
      }
      if (shape.getShapeType().equals(ShapeType.RECTANGLE)) {
        animationSequence += "</rect>";
      }
      else if (shape.getShapeType().equals(ShapeType.ELIPSE)) {
        animationSequence += "</ellipse>";
      }
      animationSequence += "\n\n";
    }
    animationSequence = String.format("<svg width=\"%.0f\" height=\"%.0f\" version=\"1.1\"\n"
                    + "\txmlns=\"http://www.w3.org/2000/svg\">\n\n",
            maxWidth,
            maxHeight)
            + animationSequence;
    animationSequence += "</svg>";
    this.appendWithCatch(animationSequence);
  }

  @Override
  public void setData(List<IReadOnlyShape> readOnlyShapes) {
    this.rawData = readOnlyShapes;
  }


  @Override
  public List<IReadOnlyShape> getData() {
    return this.rawData;
  }

  @Override
  public void setFps(int fps) {
    this.fps = fps;
  }


}
