package cs5004.animator.view;

import java.util.Comparator;

import cs5004.animator.model.AnimationTypes;
import cs5004.animator.model.IViewMotions;

/**
 * This is class representing an animation comparator object. This class implements
 * the Comparator interface.
 */
public class MotionSort implements Comparator<IViewMotions> {

  /**
   * Compares two IViewMotions objects primarily for sorting purposes.
   * @param motion1 an IViewMotions object to be compared against.
   * @param motion2 an IViewMotions object to be comared.
   * @return an int representing motion2's comparison against motion 1.
   *          if < 0, motion 1 is smaller; if > 0, motion1 is larger; if 0,
   *          both are equal.
   */
  @Override
  public int compare(IViewMotions motion1, IViewMotions motion2) {
    int val = motion1.getStartTime() - motion2.getStartTime();
    if (motion1.getType() == AnimationTypes.CREATE) {
      return -1;
    }
    return val;
  }
}
