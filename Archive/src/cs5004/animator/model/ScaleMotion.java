package cs5004.animator.model;

/**
 * This is a class representing a Scale animation that can be applied to a shape object.
 * This class extends the generic Motion class.
 */
public class ScaleMotion extends Motion {

  /**
   * This constructor for a Scale animation object.
   * @param id The ID that will be associated with the Scale animation object.
   */
  public ScaleMotion(String id) {
    super(id);
    this.setType(AnimationTypes.SCALE);
  }

}
