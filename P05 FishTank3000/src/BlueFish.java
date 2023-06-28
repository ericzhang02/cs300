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
 * This class models a Blue fish so it swims correctly. is a child class o button
 */
public class BlueFish extends Fish{

  public BlueFish(){
    super(2,"images/blue.png");
  }

  /**
   * Ovverides swim so that blueish swims right to left
   */
  @Override
  public void swim() { 
    setX((getX()-speed()+tank.width)%tank.width);
  }
}
