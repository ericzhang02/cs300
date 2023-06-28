//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P04 FishTank2000
// Course:   CS 300 Fall 2021
//
// Author:   Eric Zhang
// Email:    erzhang2@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class defines all the uses of a decoration
 *
 */
public class Decoration {

  static private PApplet processing;
  private PImage image;
  private float x;
  private float y;
  private boolean isDragging;
  static private int oldMouseX;
  static private int oldMouseY;

  public Decoration(PApplet processing, float x, float y, String imageFileName){
    this.processing = processing;
    this.x = x;
    this.y = y;
    this.image = processing.loadImage(imageFileName);
  }
  //Returns the image of this decoration object
  public PImage getImage() {
    return image;
  }
  //Returns the x-position of this decoration object
  public float getPositionX() {
    return x;
  }
  //Returns the y-position of this decoration object
  public float getPositionY() {
    return y;
  }
  //Checks whether this decoration object is being dragged
  //returns true if the object is being dragged, false otherwise
  public boolean isDragging() {
    return isDragging;
  }
  //Starts dragging this decoration object
  //Sets the oldMouseX and oldMouseY to the current position of the mouse
  public void startDragging() {
    oldMouseX = (int) x;
    oldMouseY = (int) y;
    isDragging = true;
  }
  //Stops dragging this decoration object
  public void stopDragging() {
    isDragging = false;
  }
  //Checks whether the mouse is over this decoration object
  public boolean isMouseOver() {
    int fishWidth = getImage().width;
    int fishHeight = getImage().height;

    // checks if the mouse is over the provided decoration
    return processing.mouseX >= getPositionX() - fishWidth / 2
        && processing.mouseX <= getPositionX() + fishWidth / 2
        && processing.mouseY >= getPositionY() - fishHeight / 2
        && processing.mouseY <= getPositionY() + fishHeight / 2;
  }
  //Moves this decoration object with dx and dy
  public void move(int dx, int dy) {
    x = x + dx;
    y = y + dy;
  }
  //Draws this decoration object to the display window.
  //This method sets also the position of this object to follow the moves of the
  //mouse if it is being dragged
  public void draw(){
    if(isDragging) {
      move(processing.mouseX - oldMouseX, processing.mouseY - oldMouseY);
      oldMouseX = (int)getPositionX();
      oldMouseY = (int)getPositionY();
    }
    processing.image(image, getPositionX(), getPositionY());
  }


}

