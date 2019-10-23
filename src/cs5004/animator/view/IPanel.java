package cs5004.animator.view;

import java.awt.*;
import java.util.List;

import cs5004.animator.model.IViewMotions;

/**
 * An interface for an animation GUI panel. This interface contains
 * all the necessary methods needed to render and display an animation.
 */
public interface IPanel {

  /**
   * Takes in a list of shape animations to animate on the panel.
   * @param shapesToDraw a list of read-only animations that will be animated on the panel.
   */
  void drawShapes(List<IViewMotions> shapesToDraw);

  /**
   * Paints the animations on the panel.
   * @param g a Graphic object used to represent a shape.
   */
  void paintComponent(Graphics g);

}
