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
import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class defines all the uses of a Fish such a swimming
 *
 */
public class Fish {

  static private PApplet processing;
  private PImage image;
  private float x;
  private float y;
  private int speed;
  private boolean isDragging;
  private boolean isSwimming;
  static private int oldMouseX;
  static private int oldMouseY;

  //Creates a new fish object located at a specific (x, y) position of the display window
  public Fish(PApplet processing, float x, float y, int speed, String fishImageFileName) {
    this.processing = processing;
    this.x = x;
    this.y = y;
    this.speed = speed;
    this.isDragging = false;
    this.isSwimming = false;
    this.image = processing.loadImage(fishImageFileName);
  }

  //Creates a new fish object positioned at the center of the display window.
  public Fish(PApplet processing) {
    this.processing = processing;
    this.image = processing.loadImage("images/orange.png");
    this.speed = 5;
    this.x = processing.width / 2;
    this.y = processing.height / 2;
    this.isDragging = false;
    this.isSwimming = false;
  }

  //Returns the image of type PImage of this fish
  public PImage getImage() {
    return image;
  }
  //Returns the x-position of this fish in the display window
  public float getPositionX() {
    return x;
  }
  //Returns the y-position of this fish in the display window
  public float getPositionY() {
    return y;
  }
  //Moves this fish with dx and dy
  public void move(int dx, int dy) {
    x = x + dx;
    y = y + dy;
  }
  //Checks whether this fish is being dragged
  public boolean isDragging() {
    return isDragging;
  }
  //Starts dragging this fish
  public void startDragging() {
    oldMouseX = processing.mouseX;
    oldMouseY = processing.mouseY;
    isDragging = true;
  }
  //Stops dragging this fish
  public void stopDragging() {
    isDragging = false;
  }

  //Starts swimming this fish
  public void startSwimming() {
    stopDragging();
    isSwimming = true;
  }
  // Stops swimming this fish
  public void stopSwimming() {
    isSwimming = false;
  }
  // Moves horizontally the fish one speed step from left to right
  public void swim() {  
    x = (x+speed)%processing.width;
  }

  /**
   * Checks if the mouse is over a given fish whose reference is provided as input parameter
   * 
   * @param fish reference to a given fish object
   * @return true if the mouse is over the given fish object (i.e. over the image of the fish),
   *         false otherwise
   */
  public boolean isMouseOver() {
    int fishWidth = getImage().width;
    int fishHeight = getImage().height;

    // checks if the mouse is over the provided fish
    return processing.mouseX >= getPositionX() - fishWidth / 2
        && processing.mouseX <= getPositionX() + fishWidth / 2
        && processing.mouseY >= getPositionY() - fishHeight / 2
        && processing.mouseY <= getPositionY() + fishHeight / 2;
  }

  //Draws this fish to the display window.
  //This method sets also the position of this fish to follow the moves of the
  //mouse if it is being dragged
  public void draw(){
    if(isDragging) {
      move(processing.mouseX - oldMouseX, processing.mouseY - oldMouseY);
      oldMouseX = (int)getPositionX();
      oldMouseY = (int)getPositionY();
    }
    if(isSwimming) {
      swim();
    }
    processing.image(image, getPositionX(), getPositionY());
  }
  
}