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
 * This class is a child of button and models a button that adds OrangeFish
 */
public class AddOrangeFishButton extends Button {

  public AddOrangeFishButton( float x, float y) {
    super("Add Orange", x, y);
  }

  /**
   * Overrides mousePressed to add OrangeFish
   */
  @Override
  public void mousePressed() {
    Fish temp = new Fish();
    tank.addObject(temp);
  }
}
