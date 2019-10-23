package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.model.IViewMotions;


/**
 * This is a class representing a simple GUI view for an animation. This class extends the
 * JFrame class and implements the IView interface.
 */
public class GUIView extends JFrame implements IView {

  /**
   * The views data received from the controller.
   */
  private List<IViewMotions> data;

  /**
   * The views drawing panel which will be used to display an animation.
   */
  public AnimationPanel drawingPanel;

  /**
   * The view's scroll pane used to house scroll bars for navigating the frame.
   */
  JScrollPane scrollPane;

  /**
   * Indicates whether the view is currently playing or not.
   */
  boolean playing;

  /**
   * Indicates whether a restart has been triggered by the user using the restart button.
   */
  boolean restartTriggered;


  /**
   * The constructor for a simple GUI View object.
   */
  public GUIView() {
    JButton play;
    JButton restart;

    this.playing = true;
    this.restartTriggered = false;
    this.drawingPanel = new AnimationPanel();
    this.drawingPanel.setBackground(Color.WHITE);
    this.drawingPanel.setSize(700, 700);
    this.drawingPanel.setPreferredSize(new Dimension(700, 700));

    play = new JButton("▶ play ︎ /  ▌▌ pause ");
    restart = new JButton("restart");
    this.scrollPane = new JScrollPane(this.drawingPanel,
                                      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    this.setSize(500, 500);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setLayout( new BorderLayout() );


    this.add(scrollPane);

    this.add(play, BorderLayout.SOUTH);
    this.add(restart, BorderLayout.NORTH);

    this.setVisible(true);

    play.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        playing = !playing;
      }
    });

    restart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        restartTriggered = true;
      }
    });

  }

  @Override
  public void render() throws IOException {
    this.drawingPanel.drawShapes(this.data);

  }

  @Override
  public void setData(List<IReadOnlyShape> readOnlyShapes) {
    return;
  }



  @Override
  public void addData(IViewMotions motion) {
    this.data.add(motion);
  }

  @Override
  public void clearData() {
    this.data = new ArrayList<>();
  }

  @Override
  public List<IReadOnlyShape> getData() {
    return null;
  }

  @Override
  public boolean getPlayState() {
    return this.playing;
  }

  @Override
  public boolean isRestartTriggered() {
    return this.restartTriggered;
  }

  @Override
  public void resetRestart() {
    this.restartTriggered = false;
  }

  @Override
  public void setFps(int fps) {
    return;
  }
}
