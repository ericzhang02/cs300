//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05FishTank3000
// Course:   CS 300 Fall 2021
//
// Author:   Eric Zhang
// Email:    erzhang@wisc.edu
// Lecturer: Hobbes LeGault
//

import processing.core.PImage;

/**
 * This class implements TankListener and is the base class for Fish
 */
public class TankObject implements TankListener  {

  protected static FishTank tank; // PApplet object which represents
  //the display window
  protected PImage image; // image of this tank object
  private float x; // x-position of this tank in the display window
  private float y; // y-position of this tank in the display window
  private boolean isDragging; // indicates whether this tank object
  //is being dragged or not
  private static int oldMouseX; // old x-position of the mouse
  private static int oldMouseY; // old y-position of the mouse

  public TankObject(float x, float y, String imageFileName) {
    this.x = x;
    this.y = y;
    this.image = tank.loadImage(imageFileName);
    this.isDragging = false;
  }

  /**
   * Sets the PApplet graphic display window for all TankObjects
   * @param tank
   */
  public static void setProcessing(FishTank tank) {
    TankObject.tank = tank;
  }

  /**
   * Moves this tank object with dx and dy
   * dx move to the x-position of this tank object
   * dy move to the y-position of this tank object
   * @param dx
   * @param dy
   */
  public void move(int dx, int dy) {
    x = x + dx;
    y = y + dy;    
  }

  /**
   * Returns the x-position of this tank object
   * @return
   */
  public float getX() {
    return x;
  }

  /**
   * Returns the y-position of this tank object
   * @return x
   */
  public float getY() {
    return y;
  }

  /**
   * Sets the x-position of this object
   * @param x
   */
  public void setX(float x) {
    this.x = x;
  }

  /**
   * Sets the y-position of this object
   * @param y
   */
  public void setY(float y) {
    this.y = y;
  }

  /**
   * Returns the image of this tank object
   * @return y
   */
  public PImage getImage() {
    return image;
  }

  /**
   * Getter of the isDragging field.
   * returns true if this object is being dragged, false otherwise
   * @return
   */
  public boolean isDragging() {
    return isDragging; 
  }

  /**
   * Starts dragging this tank object
   */
  public void startDragging() {
    oldMouseX = tank.mouseX;
    oldMouseY = tank.mouseY;
    this.isDragging = true;  }

  /**
   * Stops dragging this tank object
   */
  public void stopDragging() {
    isDragging = false;
  }

  /**
   * draws this object
   */
  @Override
  public void draw() {
    // if this object is dragging, set its position to follow the mouse moves
    if(isDragging) {
      move(tank.mouseX - oldMouseX, tank.mouseY - oldMouseY);
      oldMouseX = (int)getX();
      oldMouseY = (int)getY();
    }
    tank.image(image, getX(), getY());
  }

  /**
   * sets isDragging to true
   */
  @Override
  public void mousePressed() {
    if(isMouseOver()) {
      isDragging = true;
    }
  }

  /**
   * sets isDraggin to false
   */
  @Override
  public void mouseReleased() {
    isDragging = false;
  }

  /**
   * check if mouse is over object
   */
  @Override
  public boolean isMouseOver() {
    // checks if the mouse is over this object
    return tank.mouseX >= x - image.width / 2 && tank.mouseX <= x + image.width / 2
        && tank.mouseY >= y - image.height / 2 && tank.mouseY <= y + image.height / 2;
  }

}
