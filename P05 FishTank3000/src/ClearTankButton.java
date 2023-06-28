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
 * This class is a child class of Button and models a clear button
 */
public class ClearTankButton extends Button {

  public ClearTankButton( float x, float y) {
    super("clear", x, y);
  }

  /**
   * Overrides mousePressed to clear
   */
  @Override
  public void mousePressed() {
    tank.clear();
  }
}
