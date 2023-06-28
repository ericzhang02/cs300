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

public class Benchmarker {

  /**
   * asks for initial time before running bruteForce
   * asks for time after running bruteForce
   * calculates the difference to find the time it takes to run bruteForce
   * @param ph
   * @return time it takes for bruteForce to run
   */
  public static long timeBruteForce(PasswordHacker ph) {
    long timeBefore = System.currentTimeMillis(); //time before
    ph.bruteForce();
    long timeAfter = System.currentTimeMillis(); //time after
    return (timeAfter - timeBefore); //difference in time
  }

  /**
   * asks for initial time before running hack
   * asks for time after running hack
   * calculates the difference to find the time it takes to run hack
   * @param ph
   * @return the time it takes to run hack
   */
  public static long timeHack(PasswordHacker ph) {
    long timeBefore = System.currentTimeMillis(); //time before
    ph.hack();
    long timeAfter = System.currentTimeMillis(); //time after
    return (timeAfter - timeBefore); //difference in time
  }

  /**
   * calculates the avg time given the num of runs 
   * and the password length between hack and BruteForce
   * @param passwordLength
   * @param numRuns
   * @return a string with the avg time for bruteForce and Hack
   */
  public static String race(int passwordLength, int numRuns) {
    long bruteForceAvg = 0; //long for the bruteForce avg
    long hackAvg = 0; //long for the hack avg
    //loops through given numRums and adds the time it takes for 
    //both hack and BruteForce to their respective variables
    for(int i = 0; i < numRuns; i++) {
      PasswordHacker temp = new PasswordHacker(passwordLength);
      bruteForceAvg += timeBruteForce(temp); //adds timeBruteForce to respective var
      hackAvg += timeHack(temp); //adds timeHack to respective var
    }
    bruteForceAvg = bruteForceAvg/numRuns; //avgs the time for bruteForce
    hackAvg = hackAvg/numRuns; //avgs the time for hack
    //return statement
    return "Brute force " + passwordLength + ": "+ bruteForceAvg +"\nHack "
    + passwordLength + ": " + hackAvg;    
  }

  public static void main(String args[]) {
    //runs race
    System.out.println(race(7, 10));
  }
}
