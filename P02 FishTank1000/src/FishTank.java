//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P02 FishTank100
// Course:   CS 300 Fall 2021
//
// Author:   Eric Zhang
// Email:    erzhang2@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         Zayn Khan: told me how to get the width/height of the fish
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class FishTank {

  private static PApplet processing;
  private static PImage backgroundImage;
  private static Fish[] fishes;
  private static Random randGen;

  /**
   * Defines the initial environment properties of this application
   * 
   * @param processingObj a reference to the graphic display window of this application
   */
  public static void setup(PApplet processingObj) {
    processing = processingObj;

    // load the image of the background
    backgroundImage = processing.loadImage("images/background.png");

    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    // width [resp. height]: System variable of the processing library that stores
    // the width [resp. height] of the display window.
    
    randGen = new Random();

    //creates fishes array with size of 8
    fishes = new Fish[8]; 
  }

  /**
   * Draws and updates the application display window.
   * This callback method called in an infinite loop.
   */
  public static void draw() {
    // Draw the background image at the center of the screen
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);    

    //draws fish by looping and checking for null
    for(int whatFish = 0; whatFish < fishes.length; whatFish++) {
      if(fishes[whatFish] != null) {
        fishes[whatFish].draw(); 
      }
    }
  }

  /**
   * Checks if the mouse is over a specific Fish whose reference is provided
   * as input parameter
   *
   * @param Fish reference to a specific fish
   * @return true if the mouse is over the specific Fish object (i.e. over
   * the image of the Fish), false otherwise
   */
  public static boolean isMouseOver(Fish Fish) {
    //defining the borders of the fish as well as booleans for the x and y axis
    double fishLowerBoundX = Fish.getPositionX() - (Fish.getImage().width/2);
    double fishUpperBoundX = Fish.getPositionX() + (Fish.getImage().width/2);
    double fishLowerBoundY = Fish.getPositionY() - (Fish.getImage().height/2);
    double fishUpperBoundY = Fish.getPositionY() + (Fish.getImage().height/2);
    boolean isXGood = false;
    boolean isYGood = false;

    //checks if the mouse is within the x cords
    if(processing.mouseX > fishLowerBoundX && processing.mouseX < fishUpperBoundX) {
      isXGood = true;
    }
    //checks if mouse is within the y cords
    if(processing.mouseY > fishLowerBoundY && processing.mouseY < fishUpperBoundY) {
      isYGood = true;
    }
    //returns false if either are false or else it returns true
    if (!isXGood || !isYGood) {
      return false;
    }
    return true;
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {
    //looks for lowest index fish (non-null) and set it to dragging. If fish is found, stop looking for fish
    for(int whatFish = 0; whatFish <fishes.length; whatFish++) {
      if(fishes[whatFish] != null) {
        if(isMouseOver(fishes[whatFish])) {
          fishes[whatFish].setDragging(true);   
          whatFish = fishes.length;
        }
      }
    }
  }

  /**
   * Callback method called each time the mouse is released
   */
  public static void mouseReleased() {
    //loops over all fish and sets dragging to false as long as fish is not null
    for(int whatFish = 0; whatFish <fishes.length; whatFish++) {
      if(fishes[whatFish] != null) {
        fishes[whatFish].setDragging(false);          
      }
    }
  }

  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed() { 
    //adds fish by checking if 'F' is pressed then checking for the lowest index null to place a fish at mouse location. If fish is placed, stop looking for null.
    if(processing.key == 'f' || processing.key == 'F') {
      float locationX = processing.mouseX;
      float locationY = processing.mouseY;
      for(int whatFish = 0; whatFish <fishes.length; whatFish++) {
        if(fishes[whatFish] == null) {
          fishes[whatFish] = new Fish(processing, locationX, locationY);      
          whatFish = fishes.length;
        }
      }
    }
    
    //removes fish by checking if 'R' is pressed then checking for the lowest index fish that the mouse is above. If fish is deleted, stop looking for fish.
    if(processing.key == 'r' || processing.key == 'R') { 
      for(int whatFish = 0; whatFish <fishes.length; whatFish++) {
        if(fishes[whatFish] != null) {
          if(isMouseOver(fishes[whatFish])) {
            fishes[whatFish] = null;
            whatFish = fishes.length;
          }
        }
      }
    }
  }


  public static void main(String[] args) {
    Utility.startApplication();
  }
}
