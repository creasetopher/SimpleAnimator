package cs5004.animator.model;

/**
 * This is a class representing a Move animation that can be applied to a shape object.
 * This class extends the generic Motion class.
 */
public class MoveMotion extends Motion {

  /**
   * This constructor for a Move animation object.
   * @param id The ID that will be associated with the Move animation object.
   */
  public MoveMotion(String id) {
    super(id);
    this.setType(AnimationTypes.MOVE);
  }

}
