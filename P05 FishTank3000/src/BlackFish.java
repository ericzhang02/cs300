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
 * This class models a BlackFish to it swims between two destinations. a child class of Fish
 */
public class BlackFish extends Fish{

  private TankObject source;
  private TankObject destination;

  public BlackFish(TankObject source, TankObject destination){
    super(2,"images/black.png");
    this.source = source;
    this.destination = destination;
  }

  /**
   * makes one speed move towards destination
   */
  public void moveTowardsDestination() {
    float dx = (destination.getX()-super.getX());
    float dy = (destination.getY()-super.getY());
    int d = (int)Math.sqrt(dx*dx+dy*dy);

    super.setX((float)((super.getX()+(speed()*dx)/d)));
    super.setY((float)(super.getY()+(speed()*dy)/d));
  }

  /**
   * returns true if this black fish is over another tank object, and false otherwise
   * see hints below
   * @param other
   * @return if images overlap
   */
  public boolean isOver(TankObject other) {
    int x1 = (int) this.getX();
    int x2 = (int) this.getX();
    int x3 = (int) other.getX()-other.image.width;
    int x4 = (int) other.getX()+other.image.width;
    int y1 = (int) this.getY();
    int y2 = (int) this.getY();
    int y3 = (int) other.getY()+other.image.height;
    int y4 = (int) other.getY()-other.image.height;
    return (x1 < x4) && (x3 < x2) && (y1 > y4) && (y3 > y2);
  }

  /**
   * move the fish towards its destination
   * if destination is reached (meaning this fish is over its destination,
   * switch source and destination
   */
  @Override
  public void swim() {
    if(isOver(destination)) {
      TankObject temp = destination;
      destination = source;
      source = temp;
    }
    moveTowardsDestination();
  }

}
