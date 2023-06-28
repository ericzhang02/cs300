//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05FishTank3000
// Course:   CS 300 Fall 2021
//
// Author:   Eric Zhang
// Email:    erzhang@wisc.edu
// Lecturer: Hobbes LeGault
//

///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         Zayn Kahn: explained moveTowardDestination
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * This class acts as our main and add utilities such as keyPressed
 */
public class FishTank extends PApplet{

  private PImage backgroundImage; // PImage object which represents the background image
  protected ArrayList<TankListener> objects; // list storing interactive objects
  protected Random randGen; // Generator of random numbers
  private TankObject flower;
  private TankObject log;
  private TankObject ship;
  private TankObject shell; 

  /**
   * sets the size of this PApplet to 800 width x 600 height
   */
  @Override
  public void settings() {
    size(800, 600);
  }

  /**Defines initial environment properties such as screen size and
   loads the background image and fonts as the program starts.
   It also initializes all data fields.
   */
  @Override
  public void setup() {
    // Set and display the title of the display window
    this.getSurface().setTitle("Fish Tank 3000");
    // Set the location from which images are drawn to CENTER
    this.imageMode(PApplet.CENTER);
    // Set the location from which rectangles are drawn.
    this.rectMode(PApplet.CORNERS);
    // rectMode(CORNERS) interprets the first two parameters of rect() method
    // as the location of one corner, and the third and fourth parameters as
    // the location of the opposite corner.
    // rect() method draws a rectangle to the display window

    this.focused = true; // Confirms that our Processing program is focused,
    // meaning that it is active and will accept mouse or keyboard input.

    // sets the text alignment to center
    this.textAlign(PApplet.CENTER, PApplet.CENTER);

    backgroundImage = loadImage("images" + File.separator + "background.png");
    objects = new ArrayList<TankListener>();
    randGen = new Random();
    TankObject.setProcessing(this);
    Button.setProcessing(this);

    flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
    log = new TankObject(580, 470, "images" + File.separator + "log.png");
    shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
    ship = new TankObject(280, 535, "images" + File.separator + "ship.png");    
    BlackFish blackFish1 = new BlackFish(log, flower);
    BlackFish blackFish2 = new BlackFish(shell, flower);
    AddBlueFishButton buttonBlue = new AddBlueFishButton(43, 16);
    AddOrangeFishButton buttonOrange = new AddOrangeFishButton(129, 16);
    AddYellowFishButton buttonYellow = new AddYellowFishButton(215, 16);
    ClearTankButton buttonClear = new ClearTankButton(301, 16);
    addObject(flower);
    addObject(log);
    addObject(ship);
    addObject(shell);
    addObject(blackFish1);
    addObject(blackFish2);
    addObject(buttonBlue);
    addObject(buttonOrange);
    addObject(buttonYellow);
    addObject(buttonClear);
  }

  /**
   *  Continuously draws and updates the application display window
   */
  @Override
  public void draw() {
    // clear the display window by drawing the background image
    image(backgroundImage, width / 2, height / 2);
    // traverse the objects array and draw each of the objects
    for (int i = 0; i < objects.size(); i++) {
      objects.get(i).draw();
    }
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  @Override
  public void mousePressed() {
    for (int i = 0; i < objects.size(); i++) {
      if (objects.get(i).isMouseOver()) {
        objects.get(i).mousePressed();
        break; // only the fish/decoration at the lowest index will start dragging if there are 
        //fishes overlapping
      }
    }
  }

  /**
   *  Callback method called each time the mouse is released
   */
  @Override
  public void mouseReleased() {
    for (int i = 0; i < objects.size(); i++) {
      objects.get(i).mouseReleased();
    }
  }

  /**
   * adds an instance of TankListener passed as input to the objects arraylist
   * @param object
   */
  public void addObject(TankListener object) {
    objects.add(object);
  }

  /**
   * Removes instances of the class Fish from this tank
   */
  public void clear() {
    for(int i = objects.size()-1; i >= 0; i--) {
      if(objects.get(i) instanceof Fish) {
        objects.remove(i);
      }
    }
  }

  /**
   * Callback method called each time the user presses a key
   */
  @Override
  public void keyPressed() {
    //adds OrangeFish
    if(key == 'o' || key == 'O') { 
      Fish temp = new Fish();
      addObject(temp);
    }
    //adds YellowFish
    if(key == 'y' || key == 'Y') { 
      Fish temp = new Fish(2, "images/yellow.png");
      addObject(temp);
    }
    //adds BlueFish
    if(key == 'b' || key == 'B') { 
      BlueFish temp = new BlueFish();
      addObject(temp);
    }
    //removes a fish
    if(key == 'r' || key == 'R') { 
      for(int i = 0; i < objects.size(); i++) {
        if(objects.get(i) instanceof Fish && objects.get(i).isMouseOver()) {
          objects.remove(i);
          break;
        } 
      }
    }
    //startSwimming for all fish
    if(key == 's' || key == 'S') { 
      for(int i = 0; i < objects.size(); i++ ) {
        if(objects.get(i) instanceof Fish) {
          ((Fish)objects.get(i)).startSwimming();
        }
      }
    }
    //stopSwimming for all fish
    if(key == 'x' || key == 'X') { 
      for(int i = 0; i < objects.size(); i++ ) {
        if(objects.get(i) instanceof Fish) {
          ((Fish)objects.get(i)).stopSwimming();
        }
      }
    }
    //clears all fish
    if(key == 'c' || key == 'C') { 
      clear();
    }
  }

  public static void main(String[] args) {
    PApplet.main("FishTank"); // do not add any other statement to the main method
    //The PApplet.main() method takes a String input parameter which represents
    //the name of your PApplet class.  
  }

}
