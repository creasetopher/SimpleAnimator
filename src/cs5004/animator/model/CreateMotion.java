package cs5004.animator.model;

/**
 * This is a class representing a Create animation that can be applied to a shape object.
 * This class extends the generic Motion class.
 */
public class CreateMotion extends Motion {

  /**
   * This constructor for a Create animation object.
   * @param id The ID that will be associated with the Create animation object.
   */
  public CreateMotion(String id) {
    super(id);
    this.setType(AnimationTypes.CREATE);
  }


}
