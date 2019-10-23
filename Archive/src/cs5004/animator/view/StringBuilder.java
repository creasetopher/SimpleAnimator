package cs5004.animator.view;

import cs5004.animator.model.AnimationTypes;
import cs5004.animator.model.IViewMotions;

/**
 * This is a class representing a formatted string-builder for text-based Animations.
 * This class contains static methods that may be used to generate
 * formatted strings that describe an animation.
 */
public class StringBuilder {

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
    String createString;
    switch (animation.getShapeType()) {
      case RECTANGLE:
        createString = String.format("Create "
                        + animation.getShapeType().name()
                        + " with ID: "
                        + animation.getID()
                        + " with minimum corner at (%.2f, %.2f), "
                        + "Width = %.2f, Height = %.2f,"
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

      case ELIPSE:
        createString = String.format("Create "
                        + animation.getShapeType().name()
                        + " with ID: "
                        + animation.getID()
                        + " with center at (%.2f, %.2f), "
                        + "radius = %.2f, radius = %.2f"
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
   * Generates a string representing a move animation on a particular shape.
   * @param animation an animation object associated with a particular shape.
   * @param fps the frames per second that the animation runs.
   * @return a formatted string representing a move animation on a particular shape.
   */
  public static String generateMoveString(IViewMotions animation, int fps)
          throws IllegalArgumentException {
    if (animation == null || animation.getType() != AnimationTypes.MOVE) {
      throw new IllegalArgumentException("check your inputs!");
    }
    String moveString = String.format(animation.getShapeType().name()
                    + " " + animation.getID()
                    + " moves from "
                    + "(%.2f, %.2f) "
                    + " to (%.2f, %.2f) "
                    + "from time "
                    + "t = %.2f to t = %.2f",
            animation.getStartX(),
            animation.getStartY(),
            animation.getEndX(),
            animation.getEndY(),
            (float)animation.getStartTime() / fps,
            (float)animation.getEndTime() / fps);
    return moveString;
  }

  /**
   * Generates a string representing a speed change animation on a particular shape.
   * @param animation an animation object associated with a particular shape.
   * @param fps the frames per second that the animation runs.
   * @return a formatted string representing a speed change animation on a particular shape.
   */
  public static String generateSpeedString(IViewMotions animation,
                                    int fps) throws IllegalArgumentException {
    if (animation == null || animation.getType() != AnimationTypes.SPEED_CHANGE) {
      throw new IllegalArgumentException("check your inputs!");
    }

    String speedString = String.format(animation.getShapeType().toString()
                    + animation.getID()
                    + "changes speed from %d "
                    + "to %d from time "
                    + "t = %.2f to t = %.2f)",
            animation.getOldSpeed(),
            animation.getNewSpeed(),
            (float)animation.getStartTime() / fps,
            (float)animation.getEndTime() / fps);

    return speedString;
  }

  /**
   * Generates a string representing a color-change animation on a particular shape.
   * @param animation an animation object associated with a particular shape.
   * @param fps the frames per second that the animation runs.
   * @return a formatted string representing a color-change animation on a particular shape.
   */
  public static String generateColorString(IViewMotions animation,
                                    int fps) throws IllegalArgumentException {
    if (animation == null || animation.getType() != AnimationTypes.COLOR) {
      throw new IllegalArgumentException("check your inputs!");
    }
    String colorString = String.format(animation.getShapeType().name()
                    + " " + animation.getID()
                    + " changes color from (%.2f, %.2f, %.2f) "
                    + "to (%.2f, %.2f, %.2f)"
                    + " from time t1 = %.2f to t2 = %.2f",
            animation.getOldColor()[0],
            animation.getOldColor()[1],
            animation.getOldColor()[2],
            animation.getColor()[0],
            animation.getColor()[1],
            animation.getColor()[2],
            (float)animation.getStartTime() / fps,
            (float)animation.getEndTime() / fps);
    return colorString;
  }

  /**
   * Generates a string representing a scale animation on a particular shape.
   * @param animation an animation object associated with a particular shape.
   * @param fps the frames per second that the animation runs.
   * @return a formatted string representing a scale animation on a particular shape.
   */
  public static String generateScaleString(IViewMotions animation,
                                    int fps) throws IllegalArgumentException {
    if (animation == null || animation.getType() != AnimationTypes.SCALE) {
      throw new IllegalArgumentException("check your inputs!");
    }
    String scaleString;
    switch (animation.getShapeType()) {

      case RECTANGLE:
        scaleString = String.format(animation.getShapeType().name()
                        + " " + animation.getID()
                        + " scales from  "
                        + "height = %.2f, width = %.2f"
                        + " to height = %.2f, width = %.2f "
                        + "from time t1 = %.2f to t2 = %.2f",
                animation.getOldH(),
                animation.getOldW(),
                animation.getScaledH(),
                animation.getScaledW(),
                (float)animation.getStartTime() / fps,
                (float)animation.getEndTime() / fps);
        break;

      case ELIPSE:
        scaleString = String.format(animation.getShapeType().name()
                        + " " + animation.getID()
                        + "scales from  "
                        + "radius = %.2f, radius = %.2f"
                        + " to radius = %.2f, radius = %.2f "
                        + "from time t1 = %.2f to t2 = %.2f",
                animation.getOldH(),
                animation.getOldW(),
                animation.getScaledH(),
                animation.getScaledW(),
                (float)animation.getStartTime() / fps,
                (float)animation.getEndTime() / fps);
        break;

      case TRIANGLE:
        scaleString = String.format(animation.getShapeType().name()
                        + " " + animation.getID()
                        + "scales from  "
                        + "height = %.2f, base = %.2f"
                        + " to height = %.2f, base = %.2f "
                        + "from time t1 = %.2f to t2 = %.2f",
                animation.getOldH(),
                animation.getOldW(),
                animation.getScaledH(),
                animation.getScaledW(),
                (float)animation.getStartTime() / fps,
                (float)animation.getEndTime() / fps);
        break;

      default:
        scaleString = "Invalid shape type!";
    }
    return scaleString;
  }


}
