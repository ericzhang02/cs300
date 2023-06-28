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
 * This class models a button and acts as the base class for all other button classes
 */
public class Button implements TankListener{
  private static final int WIDTH = 85; // Width of this Button
  private static final int HEIGHT = 32; // Height of this Button
  protected static FishTank tank; // PApplet object where this button will be displayed
  private float x; // x-position of this button in the display window
  private float y; // y-position of this button in the display window
  protected String label; // text/label which represents this button

  // Creates a new Button at a given position within the display window
  // and sets its label
  public Button(String label, float x, float y) {
    this.label = label;
    this.x = x;
    this.y = y;
  }
  //sets the he PApplet display window where this button is displayed and handled
  public static void setProcessing(FishTank tank) { 
    Button.tank = tank;
  }

  /**
   * Overrides the TankListener.isMouseOver() method
   * Checks whether the mouse is over this button
   * @return true if the mouse is over this button, false otherwise.
   */
  @Override
  public boolean isMouseOver() {
    return tank.mouseX >= x - WIDTH / 2 && tank.mouseX <= x + WIDTH / 2
        && tank.mouseY >= y - HEIGHT / 2 && tank.mouseY <= y + HEIGHT / 2;
  }

  /**
   * Overrides TankListener.draw() method
   * Draws this button to the display window
   */
  @Override
  public void draw() {
    tank.stroke(0);// set line value to black

    // TODO if the mouse is over this button, sets the fill color to dark gray.
    //      Sets the fill color to light gray otherwise
    tank.fill(200);
    if(isMouseOver()) {
      tank.fill(100);
    }

    // draw the button (rectangle with a centered text)
    tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f,
        x + WIDTH / 2.0f, y + HEIGHT / 2.0f);
    tank.fill(0); // set the fill color to black
    tank.text(label, x, y); // display the text of the current button
  }

  /**
   * Overrides the TankListener.mousePressed() method
   * Implements the default behavior of this button when the mouse is pressed. This method must be
   *  overridden in the sub-classes to implement a specific behavior if needed.
   */
  @Override
  public void mousePressed() {
    if(isMouseOver()) {
      System.out.println("A button was pressed.");
    }
  }

  /**
   * Overrides the TankListener.mouseReleased() method
   * Implements the default behavior of this button when the mouse is released. 
   * This method must be overridden in the sub-classes to implement a specific behavior if needed.
   */
  @Override
  public void mouseReleased() { 
    // Leave this method empty
  }
}
