package cs5004.animator.view;

import cs5004.animator.model.AnimationTypes;
import cs5004.animator.model.IViewMotions;
import cs5004.animator.model.ShapeType;

/**
 * This is a class representing a formatted string-builder for SVG Animations.
 * This class contains static methods that may be used to generate SVG-compliant
 * formatted strings that describe an animation.
 */
public class SVGBuilder {

  /**
   * Generates a string representing a move animation on a particular shape.
   * @param animation an animation object associated with a particular shape.
   * @param fps the frames per second that the animation runs.
   * @return a formatted string representing a move animation on a particular shape.
   */
  public static String generateMoveString(IViewMotions animation,
                                   int fps) throws IllegalArgumentException {
    if (animation == null || animation.getType() != AnimationTypes.MOVE) {
      throw new IllegalArgumentException("check your inputs!");
    }
    String commentString = "";
    String moveString = "";

    if (animation.getShapeType().equals(ShapeType.RECTANGLE)) {

      commentString = String.format("<!-- starting at time=%.1fs, "
                      + "move the rectangle from (%.0f, %.0f) to (%.0f, %.0f) "
                      + "during t=%.1f to t=%.1f -->\n",
              (float) animation.getStartTime() / fps,
              animation.getStartX(),
              animation.getStartY(),
              animation.getEndX(),
              animation.getEndY(),
              (float) animation.getStartTime() / fps,
              (float) animation.getEndTime() / fps);


      moveString = String.format("<animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"x\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float) (animation.getStartTime() / fps) * 1000,
              (float) ((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getStartX(),
              animation.getEndX());

      moveString += String.format("<animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"y\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float) (animation.getStartTime() / fps) * 1000,
              (float) ((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getStartY(),
              animation.getEndY());

      moveString = commentString + moveString;
    } else if (animation.getShapeType().equals(ShapeType.ELIPSE)) {

      commentString = String.format("<!-- starting at time=%.1fs, "
                      + "move the ellipse from (%.0f, %.0f) to (%.0f, %.0f) "
                      + "during t=%.1f to t=%.1f -->\n",
              (float) animation.getStartTime() / fps,
              animation.getStartX(),
              animation.getStartY(),
              animation.getEndX(),
              animation.getEndY(),
              (float) animation.getStartTime() / fps,
              (float) animation.getEndTime() / fps);


      moveString = String.format("<animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"cx\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float) (animation.getStartTime() / fps) * 1000,
              (float) ((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getStartX(),
              animation.getEndX());

      moveString += String.format("<animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"cy\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float) (animation.getStartTime() / fps) * 1000,
              (float) ((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getStartY(),
              animation.getEndY());

      moveString = commentString + moveString;
    }
    return moveString;
  }


  /**
   * Generates a string representing a speed change animation on a particular shape.
   * @param animation an animation object associated with a particular shape.
   * @param fps the frames per second that the animation runs.
   * @return a formatted string representing a speed change animation on a particular shape.
   */
  public static String generateSpeedString(IViewMotions animation, int fps) {
    return null;
  }

  /**
   * Generates a string representing a create animation on a particular shape.
   * @param animation an animation object associated with a particular shape.
   * @param fps the frames per second that the animation runs.
   * @return a formatted string representing a create animation on a particular shape.
   */
  public static String generateCreateString(IViewMotions animation,
                                     int fps) throws IllegalArgumentException {
    if (animation == null || animation.getType() != AnimationTypes.CREATE) {
      throw new IllegalArgumentException("check your inputs!");
    }
    String commentString;
    String createString;
    switch (animation.getShapeType()) {
      case RECTANGLE:

        commentString = String.format("<!--"
                        +  "A rectangle named %s with rgb values (%.2f, %.2f, %.2f) "
                        + "and lower left corner "
                        + "(%.2f, %.2f), width %.1f and height %.1f"
                        +  "-->\n",
                animation.getID(),
                animation.getColor()[0],
                animation.getColor()[1],
                animation.getColor()[2],
                animation.getStartX(),
                animation.getStartY(),
                animation.getOldW(),
                animation.getOldH());

        createString = commentString
                + String.format("<rect id=\"%s\" "
                        + "x=\"%.0f\" y=\"%.0f\" "
                        + "width=\"%.0f\" height=\"%.0f\" "
                        + "fill=\"rgb(%.0f,%.0f,%.0f)\" "
                        + "visibility=\"visible\" >",
                animation.getID(),
                animation.getStartX(),
                animation.getStartY(),
                animation.getOldW(),
                animation.getOldH(),
                animation.getColor()[0],
                animation.getColor()[1],
                animation.getColor()[2]);
        break;

      case ELIPSE:
        commentString = String.format("<!--"
                        +  "An ellipse named %s with rgb values (%.0f, %.0f, %.0f) "
                        + "and center at "
                        + "(%.2f, %.2f), x-radius %.1f and y-radius %.1f"
                        +  "-->\n",
                animation.getID(),
                animation.getColor()[0],
                animation.getColor()[1],
                animation.getColor()[2],
                animation.getStartX(),
                animation.getStartY(),
                animation.getOldW(),
                animation.getOldH());


        createString =  commentString
                + String.format("<ellipse id=\"%s\" "
                        + "cx=\"%.0f\" cy=\"%.0f\" "
                        + "rx=\"%.0f\" ry=\"%.0f\" "
                        + "fill=\"rgb(%.0f,%.0f,%.0f)\" "
                        + "visibility=\"visible\" >",
                animation.getID(),
                animation.getStartX(),
                animation.getStartY(),
                animation.getOldW(),
                animation.getOldH(),
                animation.getColor()[0],
                animation.getColor()[1],
                animation.getColor()[2]);
        break;

      case TRIANGLE:
        createString = String.format("Create "
                        + animation.getShapeType().name()
                        + " with ID: "
                        + animation.getID()
                        + " with corner at (%d, %d), "
                        + "base = %d, height = %d"
                        + " Color (%.2f, %.2f, %.2f)\n"
                        + "Appears at t = %.2fs\n"
                        + "Disappears at t = %.2fs",
                animation.getStartX(), animation.getStartY(),
                animation.getOldW(), animation.getOldH(),
                animation.getColor()[0],
                animation.getColor()[1],
                animation.getColor()[2],
                (float)animation.getStartTime() / fps,
                (float)animation.getEndTime() / fps);
        break;

      default:
        createString = "Invalid shape type!";
    }
    return createString;
  }


  /**
   * Generates a string representing a color-change animation on a particular shape.
   * @param animation an animation object associated with a particular shape.
   * @param fps the frames per second that the animation runs.
   * @return a formatted string representing a color-change animation on a particular shape.
   */
  public static String generateColorString(IViewMotions animation, int fps) {
    if (animation == null || animation.getType() != AnimationTypes.COLOR) {
      throw new IllegalArgumentException("check your inputs!");
    }
    String commentString;
    String colorString;

    commentString = String.format("<!-- starting at time=%.1fs, "
                    + "change the color from (%.0f, %.0f, %.0f) to (%.0f, %.0f, %.0f) "
                    + "during t=%.1f to t=%.1f -->\n",
            (float)animation.getStartTime() / fps,
            animation.getOldColor()[0],
            animation.getOldColor()[1],
            animation.getOldColor()[2],
            animation.getColor()[0],
            animation.getColor()[1],
            animation.getColor()[2],
            (float)animation.getStartTime() / fps,
            (float)animation.getEndTime() / fps);


    colorString = String.format("<animate attributeType=\"xml\" "
                    + "begin=\"%.0fms\" dur=\"%.0fms\" "
                    + "attributeName=\"fill\" "
                    + "from=\"rgb(%.0f,%.0f,%.0f)\" "
                    + "to=\"rgb(%.0f,%.0f,%.0f)\" />\n",
            (float)(animation.getStartTime() / fps) * 1000,
            (float)((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
            animation.getOldColor()[0],
            animation.getOldColor()[1],
            animation.getOldColor()[2],
            animation.getColor()[0],
            animation.getColor()[1],
            animation.getColor()[2]);

    return commentString + colorString;
  }


  /**
   * Generates a string representing a scale animation on a particular shape.
   * @param animation an animation object associated with a particular shape.
   * @param fps the frames per second that the animation runs.
   * @return a formatted string representing a scale animation on a particular shape.
   */
  public static String generateScaleString(IViewMotions animation, int fps) {
    if (animation == null || animation.getType() != AnimationTypes.SCALE) {
      throw new IllegalArgumentException("check your inputs!");
    }
    String commentString = "";
    String scaleString = "";

    if (animation.getShapeType().equals(ShapeType.RECTANGLE)) {
      commentString = String.format("<!-- starting at time=%.1fs, "
                      + "scale the rectangle from height %.1f, width %.1f "
                      + "to height %.1f, width %.1f "
                      + "during t=%.1f to t=%.1f -->\n",
              (float)(animation.getStartTime() / fps) * 1000,
              animation.getOldH(),
              animation.getOldW(),
              animation.getScaledH(),
              animation.getScaledW(),
              (float)animation.getStartTime() / fps,
              (float)animation.getEndTime() / fps);


      scaleString = String.format("animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"x\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float)(animation.getStartTime() / fps) * 1000,
              (float)((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getStartX(),
              animation.getEndX());

      scaleString += String.format("animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"y\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float)(animation.getStartTime() / fps) * 1000,
              (float)((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getStartY(),
              animation.getEndY());

      scaleString += String.format("animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"height\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float)(animation.getStartTime() / fps) * 1000,
              (float)((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getOldH(),
              animation.getScaledH());


      scaleString += String.format("animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"width\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float)(animation.getStartTime() / fps) * 1000,
              (float)((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getOldW(),
              animation.getScaledW());

      scaleString = commentString + scaleString;

    } else if (animation.getShapeType().equals(ShapeType.ELIPSE)) {
      commentString = String.format("<!-- starting at time=%.1fs, "
                      + "scale the ellipse from y-radius %.1f, x-radius %.1f "
                      + "to y-radius %.1f, x-radius %.1f "
                      + "during t=%.1f to t=%.1f -->\n",
              (float)(animation.getStartTime() / fps) * 1000,
              animation.getOldH(),
              animation.getOldW(),
              animation.getScaledH(),
              animation.getScaledW(),
              (float)animation.getStartTime() / fps,
              (float)animation.getEndTime() / fps);


      scaleString = String.format("animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"cx\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float)(animation.getStartTime() / fps) * 1000,
              (float)((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getStartX(),
              animation.getEndX());

      scaleString += String.format("animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"cy\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float)(animation.getStartTime() / fps) * 1000,
              (float)((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getStartY(),
              animation.getEndY());

      scaleString += String.format("animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"ry\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float)(animation.getStartTime() / fps) * 1000,
              (float)((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getOldH(),
              animation.getScaledH());


      scaleString += String.format("animate attributeType=\"xml\" "
                      + "begin=\"%.0fms\" dur=\"%.0fms\" "
                      + "attributeName=\"rx\" "
                      + "from=\"%.0f\" to=\"%.0f\" "
                      + "fill=\"freeze\" />\n",
              (float)(animation.getStartTime() / fps) * 1000,
              (float)((animation.getEndTime() - animation.getStartTime()) / fps) * 1000,
              animation.getOldW(),
              animation.getScaledW());

      scaleString = commentString + scaleString;
    }
    return scaleString;
  }


}
