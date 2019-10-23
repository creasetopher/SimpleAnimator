package cs5004.animator.view;


import java.awt.*;
import java.util.List;

import javax.swing.*;

import cs5004.animator.model.IViewMotions;
import cs5004.animator.model.ShapeType;

/**
 * This is a class representing an animation panel that can be used in a JFrame animation view.
 * This class implements the IPanel interface and extends JPanel.
 */
public class AnimationPanel extends JPanel implements IPanel {
  List<IViewMotions> shapesToDraw;

  public AnimationPanel() {
    super();
  }


  @Override
  public void drawShapes(List<IViewMotions> shapesToDraw) {
    this.shapesToDraw = shapesToDraw;
    this.repaint();
  }


  @Override
  public void paintComponent(Graphics g) {
    if (shapesToDraw != null) {
      for (IViewMotions shapeMotion : this.shapesToDraw) {

        float[] shapeColor = shapeMotion.getTweenColor();

        g.setColor(new Color((int) shapeColor[0], (int) shapeColor[1], (int) shapeColor[2]));

        if (shapeMotion.getShapeType().equals(ShapeType.RECTANGLE)) {
          g.fillRect((int) shapeMotion.getTweenX(),
                  (int) shapeMotion.getTweenY(),
                  (int) shapeMotion.getTweenW(),
                  (int) shapeMotion.getTweenH());
        }

        else if (shapeMotion.getShapeType().equals(ShapeType.ELIPSE)) {
          g.fillOval((int) shapeMotion.getTweenX(),
                  (int) shapeMotion.getTweenY(),
                  (int) shapeMotion.getTweenW(),
                  (int) shapeMotion.getTweenH());

        }
      }
    }
  }

}
