package cs5004.animator.model;

/**
 * This is a class representing a Triangle shape object. This class extends the
 * AbstractShape class which implements the IShape interface.
 */
public class Triangle extends AbstractShape {

  /**
   * This constructor for a Triangle shape object.
   * @param id the id that will be associated with the shape object.
   * @param x the lower left x-value of the shape object.
   * @param y the lower y-value of the shape object.
   * @param w the starting base of the shape object.
   * @param h the starting height of the shape object.
   * @param r the red-value of the shape object's color.
   * @param g the green-value of the shape object's color.
   * @param b the blue-value of the shape object's color.
   * @param appearTime the frame in which the shape object appears in the animation.
   * @param disappearTime the frame in which the shape object disappears in the animation.
   */
  protected Triangle(String id,
                     float x,
                     float y,
                     float w,
                     float h,
                     float r,
                     float g,
                     float b,
                     int appearTime,
                     int disappearTime) {
    super(id,
            x,
            y,
            w,
            h,
            r,
            g,
            b,
            appearTime,
            disappearTime);
    this.shapeType = ShapeType.TRIANGLE;
  }

  @Override
  public String toString() {
    return x + " " + y + " " + w + " " + h;
  }
}
