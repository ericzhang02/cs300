//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 BenchmarkingHacks
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
import java.util.Random;

/**
 * This class models a LockBox with a password of a random string of numbers
 */
public class LockBox {

  protected static Random randGen;
  private String password;
  private boolean isOpen;
  
  /**
   * Constructor for LockBox that initializes randGen, makes sure passwordLength is valid and
   * creates a string of random numbers as the password
   * @param passwordLength
   * @throws IllegalArgumentException
   */
  public LockBox(int passwordLength) throws IllegalArgumentException{
    if(randGen == null) {
      randGen = new Random();
    }
    if(passwordLength <= 0) {
      throw new IllegalArgumentException("Invalid password length");
    }
    this.password = "";
    //Loops through the passwordLength and adds a random integer to password
    for (int i = 0; i < passwordLength; i++) {
      this.password += Integer.toString(randGen.nextInt(10));
    }
  }
  
  /**
   * takes in guess and checks if it equals the password
   * if equivalent the LockBox is opened
   * @param guess
   */
  public void authenticate(String guess) {
    if(guess.equals(password)) {
      isOpen = true;
    }
  }
  
  /**
   * Returns the password
   * @return password
   */
  public String hackMe() {
    return password;
  }
  
  /**
   * returns whether the LockBox is open or not
   * @return isOpen
   */
  public boolean isOpen() {
    return isOpen;
  }
  
  /**
   * resets the LockBox: sets isOpen to false
   */
  public void reset() {
    isOpen = false;
  }

}
