package cs5004.animator.model;

/**
 * This is a class representing a Color change animation that can be applied to a shape object.
 * This class extends the generic Motion class.
 */
public class ColorMotion extends Motion {

  /**
   * This constructor for a Color change animation object.
   * @param id The ID that will be associated with the Color change animation object.
   */
  public ColorMotion(String id) {
    super(id);
    this.setType(AnimationTypes.COLOR);
  }

}
