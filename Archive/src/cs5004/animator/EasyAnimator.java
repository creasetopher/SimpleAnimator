package cs5004.animator;

import java.io.IOException;

import javax.swing.*;

import cs5004.animator.controller.GUIController;
import cs5004.animator.controller.TextController;
import cs5004.animator.model.IModel;
import cs5004.animator.model.Model;
import cs5004.animator.util.AnimationFileReader;
import cs5004.animator.util.TweenModelBuilder;
import cs5004.animator.view.GUIView;
import cs5004.animator.view.IView;
import cs5004.animator.view.TextView;
import cs5004.animator.view.SVGView;
import cs5004.animator.controller.IController;

/**
 * This is the main driver class for the animator.
 */
public class EasyAnimator {

  /**
   * The driver for the animator.
   * @param args a list or string arguments used to configure the animation.
   */
  public static void main(String[] args) throws IOException {
    IModel animationModel;
    IView animationView = null;
    IController animationController;
    String inputFile = "";
    String viewType = "";
    String output = "out";
    int fps = 1;
    AnimationFileReader fileReader = new AnimationFileReader();
    TweenModelBuilder<IModel> builder = new Model.Builder();

    for (int i = 0; i < args.length; ++i) {
      try {
        if (args[i].equals("-if")) {
          inputFile = args[i + 1];
          if (!inputFile.equals("out") && !inputFile.contains("/")) {
            inputFile = "./" + inputFile;
          }
        } else if (args[i].equals("-iv")) {
          viewType = args[i + 1];
        } else if (args[i].equals("-o")) {
          output = args[i + 1];
        } else if (args[i].equals("-speed")) {
          fps = Integer.parseInt(args[i + 1]);
        }
      } catch (Exception e) {
        throw new IllegalArgumentException("Argument flag provided without argument.");
      }

      if (viewType.equalsIgnoreCase("text")) {
        animationView = new TextView(output);
      } else if (viewType.equalsIgnoreCase("svg")) {
        animationView = new SVGView(output);
      }
      else if (viewType.equalsIgnoreCase("visual")) {
        animationView = new GUIView();
      }
    }

    if (inputFile.equals("") || viewType.equals("")) {
      Object errorString = "Input file and/or view type arguments are invalid. Please try again.";
      new JOptionPane(errorString);
    }

    animationModel = fileReader.readFile(inputFile, builder);

    if (animationView instanceof TextView || animationView instanceof SVGView) {
      animationController = new TextController(animationModel, animationView);
      animationController.setFramesPerSecond(fps);
      animationController.getAllShapes();
      animationController.run();
    }

    else if (animationView instanceof GUIView) {
      animationController = new GUIController(animationModel, animationView);
      animationController.setFramesPerSecond(fps);
      animationController.run();
    }


  }
}
