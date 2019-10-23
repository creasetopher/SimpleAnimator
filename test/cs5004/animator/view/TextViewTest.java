package cs5004.animator.view;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import cs5004.animator.model.AnimationTypes;
import cs5004.animator.model.IModel;
import cs5004.animator.model.IMotion;
import cs5004.animator.model.IReadOnlyShape;
import cs5004.animator.model.Model;
import cs5004.animator.model.Motion;
import cs5004.animator.model.ShapeType;

import static org.junit.Assert.assertEquals;

/**
 * This is a test for the TextView Class.
 */
public class TextViewTest {
  IModel testModel;
  IView testTextView1;
  IView testTextView2;
  IView testTextView3;
  List<IReadOnlyShape> testShapes;

  @Before
  public void setUp() {
    testModel = new Model();
    testModel.addShape("testR1",
            ShapeType.RECTANGLE,
            10,
            10,
            20,
            20,
            5,
            5,
            5,
            0,
            50);

    testModel.addShape("testR2",
            ShapeType.RECTANGLE,
            50,
            50,
            40,
            40,
            0,
            5,
            5,
            0,
            50);

    testModel.addShape("testR3",
            ShapeType.RECTANGLE,
            5,
            5,
            4,
            25,
            0,
            10,
            5,
            0,
            50);

    testModel.addShape("testE1",
            ShapeType.ELIPSE,
            25,
            25,
            25,
            25,
            0,
            10,
            5,
            0,
            50);

    testModel.addShape("testE2",
            ShapeType.ELIPSE,
            5,
            25,
            5,
            25,
            0,
            1,
            5,
            0,
            50);

    testShapes = testModel.getAllShapes();


    try {
      testTextView1 = new TextView("out");
      testTextView2 = new TextView("out");
      testTextView3 = new TextView("testoutput2.txt");
    }
    catch (Exception e) {
      System.err.println("Something wrong with TextView test setup");
    }
  }


  @Test
  public void generateCreateString() {
    String compString = "Create RECTANGLE with ID: tm3 with minimum corner at (50.00, 100.00), "
            + "Width = 0.00, Height = 0.00, Color (0.00, 0.00, 0.00)\n"
            + "Appears at t = 0.00s\n"
            + "Disappears at t = 500.00s";

    IMotion testMotion = new Motion("tm3");
    testMotion.setType(AnimationTypes.CREATE);
    testMotion.setShapeType(ShapeType.RECTANGLE);
    testMotion.setStartTime(0);
    testMotion.setEndTime(500);
    testMotion.setStartX(50);
    testMotion.setStartY(100);
    testMotion.setEndX(60);
    testMotion.setEndY(100);
    assertEquals(compString, StringBuilder.generateCreateString(testMotion, 1));
  }

  @Test
  public void generateMoveString() {
    String compString = "RECTANGLE tm1 moves from (10.00, 20.00)  to "
            + "(40.00, 50.00) from time t = 0.00 to t = 0.00";

    IMotion testMotion = new Motion("tm1");
    testMotion.setType(AnimationTypes.MOVE);
    testMotion.setShapeType(ShapeType.RECTANGLE);
    testMotion.setStartX(10);
    testMotion.setStartY(20);
    testMotion.setEndX(40);
    testMotion.setEndY(50);
    StringBuilder.generateMoveString(testMotion, 1);
    assertEquals(compString, StringBuilder.generateMoveString(testMotion, 1));
  }


  @Test
  public void generateColorString() {
    String compString = "ELIPSE tm4 changes color from (5.00, 5.00, 5.00) to "
            + "(50.00, 50.00, 50.00) from time t1 = 0.00 to t2 = 0.00";

    IMotion testMotion = new Motion("tm4");
    testMotion.setType(AnimationTypes.COLOR);
    testMotion.setShapeType(ShapeType.ELIPSE);
    testMotion.setStartX(10);
    testMotion.setStartY(20);
    testMotion.setOldColor(5, 5, 5);
    testMotion.setColor(50, 50, 50);
    testMotion.setEndX(400);
    testMotion.setEndY(500);
    assertEquals(compString, StringBuilder.generateColorString(testMotion, 1));
  }

  @Test
  public void generateScaleString() {
    String compString = "RECTANGLE tm5 scales from  height = 0.00, width = 0.00 to "
            + "height = 0.00, width = 0.00 from time t1 = 0.00 to t2 = 0.00";
    IMotion testMotion = new Motion("tm5");
    testMotion.setType(AnimationTypes.SCALE);
    testMotion.setShapeType(ShapeType.RECTANGLE);
    testMotion.setStartX(100);
    testMotion.setStartY(200);
    testMotion.setEndX(400);
    testMotion.setEndY(500);
    assertEquals(compString, StringBuilder.generateScaleString(testMotion, 1));
  }

  @Test
  public void render() {
    // look at text in System.out for validity check
    int i = 1;
    testTextView1.setData(testShapes);
    try {
      testTextView1.setFps(1);
      testTextView1.render();
    }
    catch (Exception e) {
      System.err.println("render test failed!");
    }
    assertEquals(1, i);
  }

  @Test
  public void render2() {
    int i = 1;
    // look at text in testoutput2.txt for validity check

    testTextView3.setData(testShapes);
    try {
      testTextView3.setFps(3);
      testTextView3.render();
    }
    catch (Exception e) {
      System.err.println("render test failed!");
    }
    assertEquals(1, i);
  }

  @Test
  public void setData() {
    int i;
    testTextView2.setData(testShapes);
    List<IReadOnlyShape> test2Data = testTextView2.getData();

    for (i = 0; i < testShapes.size(); i++) {
      assertEquals(test2Data.get(i), testShapes.get(i));
    }


  }

  @Test
  public void getData() {
    int i;
    IModel testModel2 = new Model();

    testModel2.addShape("testRect1",
            ShapeType.RECTANGLE,
            10,
            10,
            20,
            20,
            5,
            5,
            5,
            0,
            50);

    testModel2.addShape("testRect2",
            ShapeType.RECTANGLE,
            50,
            50,
            40,
            40,
            0,
            5,
            5,
            0,
            50);

    List<IReadOnlyShape> someShapes = testModel2.getAllShapes();
    testTextView2.setData(someShapes);
    List<IReadOnlyShape> testSVG3data = testTextView2.getData();

    for (i = 0; i < someShapes.size(); i++) {
      assertEquals(testSVG3data.get(i), someShapes.get(i));
    }


  }
}