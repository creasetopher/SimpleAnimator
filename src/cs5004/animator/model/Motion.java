package cs5004.animator.model;

/**
 * This is a class representing an animation that can be applied to a shape object.
 * This class implements the IMotion interface.
 */
public class Motion implements IMotion {

  protected String id;
  protected ShapeType shapeType;
  protected int startTime;
  protected int endTime;
  protected float newHeight;
  protected float newWidth;
  protected float oldHeight;
  protected float oldWidth;

  protected float tweenHeight;
  protected float tweenWidth;

  protected float startX;
  protected float startY;
  protected float endX;
  protected float endY;

  protected float tweenX;
  protected float tweenY;

  protected int newSpeed;
  protected int oldSpeed;
  protected AnimationTypes type;
  protected float[] oldRGBarray;
  protected float[] rgbArray;
  protected float[] tweenColor;

  protected boolean visibility;
  protected boolean typeIsSet;

  /**
   * This constructor for an animation object.
   * @param id The ID that will be associated with the animation object.
   */
  public Motion(String id) {
    this.id = id;
    this.shapeType = null;
    this.startTime = 0;
    this.endTime = 0;
    this.oldHeight = 0;
    this.oldWidth = 0;
    this.newHeight = 0;
    this.newWidth = 0;
    this.startX = 0;
    this.startY = 0;
    this.endX = 0;
    this.endY = 0;
    this.oldSpeed = 0;
    this.newSpeed = 0;
    this.type = null;
    this.rgbArray = new float[3];
    this.oldRGBarray = new float[3];
    this.visibility = true;
    this.typeIsSet = false;
  }

  @Override
  public void setShapeType(ShapeType shapeType) {
    if (this.shapeType == null) {
      this.shapeType = shapeType;
    }
  }

  @Override
  public void setStartTime(int t1) {
    this.startTime = t1;
  }

  @Override
  public void setEndTime(int t2) {
    this.endTime = t2;
  }


  @Override
  public void setScaledH(float scaledH) {
    this.newHeight = scaledH;
  }

  @Override
  public void setScaledW(float scaledW) {
    this.newWidth = scaledW;
  }

  @Override
  public void setOldH(float oldH) {
    this.oldHeight = oldH;
  }

  @Override
  public void setOldW(float oldW) {
    this.oldWidth = oldW;
  }

  @Override
  public void setStartX(float x) {
    this.startX = x;
  }

  @Override
  public void setStartY(float y) {
    this.startY = y;
  }

  @Override
  public void setEndX(float x) {
    this.endX = x;
  }

  @Override
  public void setEndY(float y) {
    this.endY = y;
  }

  @Override
  public void setNewSpeed(int speed) {
    this.newSpeed = speed;
  }

  @Override
  public void setOldSpeed(int speed) {
    this.oldSpeed = speed;
  }

  @Override
  public void setType(AnimationTypes type) {
    if (!(this.typeIsSet)) {
      this.type = type;
      this.typeIsSet = true;
    }
  }

  @Override
  public void setColor(float r, float g, float b) {
    this.rgbArray[0] = r;
    this.rgbArray[1] = g;
    this.rgbArray[2] = b;
  }

  @Override
  public void setOldColor(float r, float g, float b) {
    this.oldRGBarray[0] = r;
    this.oldRGBarray[1] = g;
    this.oldRGBarray[2] = b;
  }

  @Override
  public void setVisibility(boolean visibility) {
    this.visibility = visibility;
  }

  @Override
  public String getID() {
    return this.id;
  }

  @Override
  public ShapeType getShapeType() {
    return this.shapeType;
  }


  @Override
  public int getStartTime() {
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }


  @Override
  public float getStartX() {
    return this.startX;
  }

  @Override
  public float getStartY() {
    return this.startY;
  }

  @Override
  public float getScaledH() {
    return this.newHeight;
  }

  @Override
  public float getScaledW() {
    return this.newWidth;
  }

  @Override
  public float getOldH() {
    return this.oldHeight;
  }

  @Override
  public float getOldW() {
    return this.oldWidth;
  }

  @Override
  public float getEndX() {
    return this.endX;
  }

  @Override
  public float getEndY() {
    return this.endY;
  }

  @Override
  public int getNewSpeed() {
    return this.newSpeed;
  }

  @Override
  public int getOldSpeed() {
    return this.oldSpeed;
  }

  @Override
  public AnimationTypes getType() {
    return this.type;
  }

  @Override
  public float[] getColor() {
    float[] colors = new float[3];
    for (int i = 0; i < this.rgbArray.length; i++) {
      colors[i] = this.rgbArray[i];
    }
    return colors;
  }


  @Override
  public float[] getOldColor() {
    float[] oldColors = new float[3];
    for (int i = 0; i < this.oldRGBarray.length; i++) {
      oldColors[i] = this.oldRGBarray[i];
    }
    return oldColors;
  }

  @Override
  public boolean getVisibility() {
    return this.visibility;
  }

  @Override
  public float getTweenX() {
    return this.tweenX;
  }

  @Override
  public float getTweenY() {
    return this.tweenY;
  }

  @Override
  public float getTweenW() {
    return this.tweenWidth;
  }

  @Override
  public float getTweenH() {
    return this.tweenHeight;
  }

  @Override
  public float[] getTweenColor() {
    int i;
    float[] tweenColorCopy = new float[3];
    for (i = 0; i < this.tweenColor.length; i++) {
      tweenColorCopy[i] = this.tweenColor[i];
    }
    return tweenColorCopy;
  }

  @Override
  public void setTweenX(float tick) {
    float animationDuration = this.getEndTime() - this.getStartTime();
    float firstTerm = this.getStartX() * ( (this.getEndTime() - tick) / animationDuration);
    float secondTerm = this.getEndX() * ( (tick - this.getStartTime()) / animationDuration);
    this.tweenX = firstTerm + secondTerm;
  }

  @Override
  public void setTweenY(float tick) {
    float animationDuration = this.getEndTime() - this.getStartTime();
    float firstTerm = this.getStartY() * ( (this.getEndTime() - tick) / animationDuration);
    float secondTerm = this.getEndY() * ( (tick - this.getStartTime()) / animationDuration);
    this.tweenY = firstTerm + secondTerm;
  }

  @Override
  public void setTweenW(float tick) {
    float animationDuration = this.getEndTime() - this.getStartTime();
    float firstTerm = this.getOldW() * ( (this.getEndTime() - tick) / animationDuration);
    float secondTerm = this.getScaledW() * ( (tick - this.getStartTime()) / animationDuration);
    this.tweenWidth = firstTerm + secondTerm;
  }

  @Override
  public void setTweenH(float tick) {
    float animationDuration = this.getEndTime() - this.getStartTime();
    float firstTerm = this.getOldH() * ( (this.getEndTime() - tick) / animationDuration);
    float secondTerm = this.getScaledH() * ( (tick - this.getStartTime()) / animationDuration);
    this.tweenHeight = firstTerm + secondTerm;
  }

  @Override
  public void setTweenColor(float tick) {
    float animationDuration = this.getEndTime() - this.getStartTime();

    int i;
    float[] tweenColor = new float[3];

    for (i = 0; i < 3; i++) {
      float firstTerm = this.getOldColor()[i] * ( (this.getEndTime() - tick) / animationDuration);
      float secondTerm = this.getColor()[i] * ( (tick - this.getStartTime()) / animationDuration);
      tweenColor[i] = firstTerm + secondTerm;
    }

    this.tweenColor = tweenColor;
  }

  @Override
  public boolean doesOverlap(IMotion other) {
    return (
            ( other.getStartTime() == startTime || other.getEndTime() == endTime)

            // existing animation starts after this attempted move starts
            // and ends before attempted move ends -> existing move is sandwiched
            || (other.getStartTime() > startTime
            && other.getEndTime() < endTime)

            // existing animation starts before this attempted move starts
            // and ends after attempted move ends -> attempted move is sandwiched
            || (other.getStartTime() < startTime
            && other.getEndTime() > endTime)

            // existing animation starts before attempted move ends
            || (other.getStartTime() > startTime
            && other.getStartTime() < endTime)

            // attempted move starts before existing move ends
            || (other.getStartTime() < startTime
            && other.getEndTime() > startTime)
      );
  }


}
