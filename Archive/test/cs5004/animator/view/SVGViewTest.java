package cs5004.animator.view;

import org.junit.Before;

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
 * This is a test for the SVGView Class.
 */
public class SVGViewTest {
  IModel testModel;
  IModel testModel2;
  List<IReadOnlyShape> testShapes;
  IView testSVG1;
  IView testSVG2;
  IView testSVG3;

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
      testSVG1 = new SVGView("out");
      testSVG2 = new SVGView("out");
      testSVG3 = new SVGView("testoutput.txt");
    }
    catch (Exception e) {
      System.err.println("Problem with SVGTest setup!");
    }
  }



  @org.junit.Test
  public void render() {

    // look at text in System.out for validity check

    testSVG1.setData(testShapes);
    try {
      testSVG1.setFps(1);
      testSVG1.render();
    }
    catch (Exception e) {
      System.err.println("render test failed!");
    }
    assertEquals("", "");
  }

  @org.junit.Test
  public void render2() {

    // look at text in testoutput.txt for validity check

    testSVG3.setData(testShapes);
    try {
      testSVG3.setFps(3);
      testSVG3.render();
    }
    catch (Exception e) {
      System.err.println("render test failed!");
    }
    assertEquals("", "");
  }


  @org.junit.Test
  public void setData() {
    int i;
    testSVG2.setData(testShapes);
    List<IReadOnlyShape> test2Data = testSVG2.getData();

    for (i = 0; i < testShapes.size(); i++) {
      assertEquals(test2Data.get(i), testShapes.get(i));
    }
  }

  @org.junit.Test
  public void getData() {
    int i;
    testModel2 = new Model();

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
    testSVG3.setData(someShapes);
    List<IReadOnlyShape> testSVG3data = testSVG3.getData();

    for (i = 0; i < someShapes.size(); i++) {
      assertEquals(testSVG3data.get(i), someShapes.get(i));
    }
  }

  @org.junit.Test
  public void generateMoveString() {
    String compString = "<!-- starting at time=0.0s, move the rectangle from "
            + "(10, 20) to (40, 50) during t=0.0 to t=0.0 -->\n"
            + "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" "
            + "from=\"10\" to=\"40\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" "
            + "from=\"20\" to=\"50\" fill=\"freeze\" />\n";
    IMotion testMotion = new Motion("tm1");
    testMotion.setType(AnimationTypes.MOVE);
    testMotion.setShapeType(ShapeType.RECTANGLE);
    testMotion.setStartX(10);
    testMotion.setStartY(20);
    testMotion.setEndX(40);
    testMotion.setEndY(50);
    SVGBuilder.generateMoveString(testMotion, 1);
    assertEquals(compString, SVGBuilder.generateMoveString(testMotion, 1));
  }


  @org.junit.Test
  public void generateCreateString() {
    String compString = "<!--A rectangle named tm3 with rgb values (0.00, 0.00, 0.00) and "
            + "lower left corner (50.00, 100.00), width 0.0 and height 0.0-->\n"
            + "<rect id=\"tm3\" x=\"50\" y=\"100\" width=\"0\" height=\"0\" fill=\"rgb(0,0,0)\" "
            + "visibility=\"visible\" >";

    IMotion testMotion = new Motion("tm3");
    testMotion.setType(AnimationTypes.CREATE);
    testMotion.setShapeType(ShapeType.RECTANGLE);
    testMotion.setStartTime(0);
    testMotion.setEndTime(500);
    testMotion.setStartX(50);
    testMotion.setStartY(100);
    testMotion.setEndX(60);
    testMotion.setEndY(100);
    assertEquals(compString, SVGBuilder.generateCreateString(testMotion, 1));
  }

  @org.junit.Test
  public void generateColorString() {
    String compString = "<!-- starting at time=0.0s, change the "
            + "color from (5, 5, 5) to (50, 50, 50) during t=0.0 to t=0.0 -->\n"
            + "<animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" "
            + "attributeName=\"fill\" from=\"rgb(5,5,5)\" to=\"rgb(50,50,50)\" />\n";

    IMotion testMotion = new Motion("tm4");
    testMotion.setType(AnimationTypes.COLOR);
    testMotion.setShapeType(ShapeType.ELIPSE);
    testMotion.setStartX(10);
    testMotion.setStartY(20);
    testMotion.setOldColor(5, 5, 5);
    testMotion.setColor(50, 50, 50);
    testMotion.setEndX(400);
    testMotion.setEndY(500);
    assertEquals(compString, SVGBuilder.generateColorString(testMotion, 1));
  }

  @org.junit.Test
  public void generateScaleString() {
    String compString = "<!-- starting at time=0.0s, scale the rectangle from height 0.0, "
            + "width 0.0 to height 0.0, width 0.0 during t=0.0 to t=0.0 -->\n"
            + "animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" "
            + "attributeName=\"x\" from=\"100\" to=\"400\" fill=\"freeze\" />\n"
            + "animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" "
            + "attributeName=\"y\" from=\"200\" to=\"500\" fill=\"freeze\" />\n"
            + "animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" "
            + "attributeName=\"height\" from=\"0\" to=\"0\" fill=\"freeze\" />\n"
            + "animate attributeType=\"xml\" begin=\"0ms\" dur=\"0ms\" "
            + "attributeName=\"width\" from=\"0\" to=\"0\" fill=\"freeze\" />\n";

    IMotion testMotion = new Motion("tm5");
    testMotion.setType(AnimationTypes.SCALE);
    testMotion.setShapeType(ShapeType.RECTANGLE);
    testMotion.setStartX(100);
    testMotion.setStartY(200);
    testMotion.setEndX(400);
    testMotion.setEndY(500);
    assertEquals(compString, SVGBuilder.generateScaleString(testMotion, 1));
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void illegalGenerateScaleString() {
    IMotion testMotion = new Motion("tm5");
    testMotion.setStartX(100);
    testMotion.setStartY(200);
    testMotion.setEndX(400);
    testMotion.setEndY(500);
    assertEquals("", SVGBuilder.generateScaleString(testMotion, 1));
  }

  @org.junit.Test(expected = IllegalArgumentException.class)
  public void illegalGenerateColorString() {
    IMotion testMotion = null;
    assertEquals("", SVGBuilder.generateColorString(testMotion, 1));
  }

}