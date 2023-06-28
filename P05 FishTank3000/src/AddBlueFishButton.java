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
 * This class is a child of button and models a button that adds BlueFish
 */
public class AddBlueFishButton extends Button {

  public AddBlueFishButton( float x, float y) {
    super("Add Blue", x, y);
  }

  /**
   * Overrides mousePressed to add BlueFish
   */
  @Override
  public void mousePressed() {
    BlueFish temp = new BlueFish();
    tank.addObject(temp); 
  }
}
