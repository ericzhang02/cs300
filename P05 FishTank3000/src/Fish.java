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
/**
 * This class the the child class of TankObject and is the base class for BlackFish and BlueFish
 */
public class Fish extends TankObject implements TankListener{

  private int speed;
  private boolean isSwimming;

  public Fish(int speed, String fishImageFileName) throws IllegalArgumentException{
    super((float)tank.randGen.nextInt(tank.width),
        (float)tank.randGen.nextInt(tank.height), fishImageFileName);
    if(speed <= 0) {
      throw new IllegalArgumentException("Warning: speed cannot be negative");
    }
    this.speed = speed;
  }

  public Fish(){
    this(5,"images/orange.png");
  }

  /**
   * Overrides the draw() method implemented in the parent class.
   *This method sets the position of this fish to follow the
   *mouse moves if it is dragging, calls its swim() method
   *if it is swimming, and draws it to the display window.
   *You can use a partial overriding (call draw() method of
   *the super class and adds the behavior specific to drawing a fish.
   */
  @Override
  public void draw() {
    if(isSwimming) {
      swim();
    }
    super.draw();

  }

  /**
   * Checks whether this fish is swimming
   * @return isSwimming
   */
  public boolean isSwimming() {
    return isSwimming;
  }

  /**
   * Starts swimming this fish
   */
  public void startSwimming() {
    isSwimming = true;
  }

  /**
   * Stops swimming this fish
   */
  public void stopSwimming() {
    isSwimming = false;
  }

  /**
   * Gets the speed of this fish
   * @return speed
   */
  public int speed() { 
    return speed;
  }

  /**
   * Moves horizontally the fish one speed step from left to right.
   */
  public void swim() { 
    setX((getX()+speed)%tank.width);
  }

}
