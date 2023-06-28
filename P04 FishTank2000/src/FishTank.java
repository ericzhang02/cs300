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
 * This class creates the fish tank and applies the use of fish and decoration
 */

public class FishTank {
  private static PApplet processing; // PApplet object which represents the graphic interface
  // of the Fish Tank application
  private static PImage backgroundImage; // PImage object which represents the background image
  private static Fish[] fishes; // array storing the current fishes present in the tank
  private static Random randGen; // Generator of random numbers
  //circular indexed array of fish images names
  private static String[] images =
      new String[] {"orange.png", "blue.png", "yellow.png", "black.png"};
  //index of next fish image index in the circular array images
  private static int nextImageIndex;
  private static int fishSpeed;
  //array storing the decoration objects present in the tank
  private static Decoration[] decorations;

  /**
   * Defines initial environment properties such as screen size and to load background images and
   * fonts as the program starts. It also initializes all data fields.
   * 
   * @param processingObj a PApplet object that represents the display window of the Fish Tank
   *                      application
   */
  public static void setup(PApplet processingObj) {
    processing = processingObj;
    backgroundImage = processing.loadImage("images" + File.separator + "background.png");
    fishes = new Fish[8];
    decorations = new Decoration[4];
    randGen = new Random();
    fishSpeed = 3;
    decorations[0] = new Decoration(processingObj, 430, 60, "images/flower.png");
    decorations[1] = new Decoration(processingObj, 580, 470, "images/log.png");
    decorations[2] = new Decoration(processingObj, 65, 520, "images/shell.png");
    decorations[3] = new Decoration(processingObj, 280, 535, "images/ship.png");
  }

  /**
   * Continuously draws and updates the application display window
   */
  public static void draw() {
    // clear the display window by drawing the background image
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    // traverse the decorations array and draw each of the decorations
    for (int i = 0; i < decorations.length; i++) {
      decorations[i].draw();
    }
    // traverse the fishes array and draw each of the fish present in the tank
    for (int i = 0; i < fishes.length; i++)
      if (fishes[i] != null)
        fishes[i].draw();
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {
    // traverse the fishes array and start dragging a fish if the mouse is over it
    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] != null && fishes[i].isMouseOver()) {
        fishes[i].startDragging();
        break; // only the fish at the lowest index will start dragging if there are fishes
        // overlapping
      }
    }
    // traverse the decorations array and start dragging a decoration if the mouse is over it
    for (int i = 0; i < decorations.length; i++) {
      if (decorations[i].isMouseOver()) {
        decorations[i].startDragging();
        break; // only the fish at the lowest index will start dragging if there are fishes
        // overlapping
      }
    }
  }

  /**
   * Callback method called each time the mouse is released
   */
  public static void mouseReleased() {
    // traverse the fishes array and stop dragging any fish
    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] != null)
        fishes[i].stopDragging();;
    }
    // traverse the fishes array and stop dragging any fish
    for (int i = 0; i < decorations.length; i++) {
      decorations[i].stopDragging();
    }
  }

  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed() {
    // add a new fish if the maximum numbers of fish allowed to be
    // present in the tank is not reached
    switch (Character.toUpperCase(processing.key)) {
      case 'F': // add a new fish if the maximum numbers of fish allowed to be
        // present in the tank is not reached
        for (int i = 0; i < fishes.length; i++) {
          if (fishes[i] == null) {
            fishes[i] = new Fish(processing, (float)randGen.nextInt(processing.width),
                (float)randGen.nextInt(processing.height), fishSpeed,
                "images/"+images[nextImageIndex]);
            nextImageIndex = (nextImageIndex + 1) % images.length;
            break;
          }
        }
        break;
    }
    //   mouse is above. If fish is deleted, stop looking for fish.
    if(processing.key == 'r' || processing.key == 'R') { 
      for(int whatFish = 0; whatFish <fishes.length; whatFish++) {
        if(fishes[whatFish] != null && fishes[whatFish].isMouseOver()) {
          fishes[whatFish] = null;
          whatFish = fishes.length;
        }
      }
    }
    //loops through all fish and sets them in motion if 's' is pressed
    if(processing.key == 's' || processing.key == 'S') { 
      for(int whatFish = 0; whatFish <fishes.length; whatFish++) {
        if(fishes[whatFish] != null) {
          fishes[whatFish].startSwimming();
        }
      }
    }
    if(processing.key == 'x' || processing.key == 'X') { 
      for(int whatFish = 0; whatFish <fishes.length; whatFish++) {
        if(fishes[whatFish] != null) {
          fishes[whatFish].stopSwimming();
        }
      }
    }
  }

  /**
   * This main method starts the application
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    // starts the application
    Utility.startApplication();
  }

}