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
public class PasswordHacker {

  private LockBox toPick;
  private int passwordLength;

  /**
   * Constructor of PasswordHacker
   * creates a LockBox to pick with the param passwordLength
   * @param passwordLength
   */
  public PasswordHacker(int passwordLength) {
    this.passwordLength = passwordLength;
    this.toPick = new LockBox(passwordLength);
  }

  /**
   * First resets the LockBox
   * Gets the password of the LockBox and opens the LockBox
   */
  /** Complexity: O(1) */
  public void hack() {
    toPick.reset();
    String temp;
    temp = toPick.hackMe();
    toPick.authenticate(temp);

  }

  /**
   * First resets the LockBox
   * generates guess by counting upwards until password is eventually hit
   */
  /** Complexity: O(N) */
  public void bruteForce() {
    toPick.reset();
    int i = 0; //the counter
    //keeps generating guesses until the passwords is hit and the LockBox is open 
    //using the counter to keep track of number of guesses
    while(!toPick.isOpen()){
      toPick.authenticate(generateGuess(i));
      i++;
    }
  }

  /**
   * generates a string of numbers of passwordLength given the current guess
   * @param count
   * @return a generated guess given the count "guess"
   */
  public String generateGuess(int count) {
    String guess = "";
    //loops through count and adds the last digit of count 
    //then removes last digit and then loops again
    //adds 0 if there is no value there
    for ( int i = 0; i < passwordLength; i++ ) {
      guess = (count % 10) + guess;
      count = count / 10;
    }
    return guess;
  }
}
