//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ExceptionalClimbing
// Course:   CS 300 Fall 2021
//
// Author:   Eric Zhang
// Email:    erzhang2@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  stackoverflow.com: Example of Catch-Throw blocks
//
//////////////////////////////////////////////////////////////////////////////
import java.util.zip.DataFormatException;
/**
 * This class tests ExceeptionalClimbing
 */

public class ExceptionalClimbingTester {

  public static void main(String[] args) {
    runAllTests();
  }

  /**
   * This method tests the sendClimb method in the main class
   * @return true if sendClimb works the way its intended to
   * @return false if sendClimb does not work
   */
  public static boolean testSendClimb() {
    
    //creating return value as well as different arrays
    boolean doesWork = true;
    String[] goodArray = new String[] {"V4", "V5", "V2", "V1", null};
    String[] badArray = new String[] {null, "V4", "V5", "V2", "V1"};
    String[] emptyArray = new String[] {null, null, null, null, null};
    String[] fullArray = new String[] {"V4", "V5", "V2", "V1", "V1"};

    try {
      //tests valid sendClimb for the expected value 
      if(!(ExceptionalClimbing.sendClimb(emptyArray, 0, "V3")==1)) {
        return false;
      }
      if(!(ExceptionalClimbing.sendClimb(goodArray, 4, "V3") == 5)) {
        return false;
      }
      
      //calls sendClimb with exceptions 
      ExceptionalClimbing.sendClimb(fullArray, 5, "V3");
      ExceptionalClimbing.sendClimb(goodArray, 4, "V13");
      ExceptionalClimbing.sendClimb(emptyArray, -2, "V3");
    }
    catch(IllegalArgumentException iae) {
      //changes return boolean to false if the expected iae error message does not match
      if(!iae.getMessage().equals("cannot add new value to full length 5 array") 
          && !iae.getMessage().equals("V13 is not a valid grade")) {
        doesWork = false;
      }
    }
    catch(DataFormatException dfe){
      //changes return boolean to false if the expected dfe error message does not match
      if(!dfe.getMessage().equals("invalid oversize array")) {
        doesWork = false;
      }
    }
    return doesWork;
  }
  /**
   * This method tests the failClimb method in the main class
   * @return true if failClimb works the way its intended to
   * @return false if failClimb does not work
   */
  public static boolean testFailClimb() {

    //creating return value as well as different arrays
    boolean doesWork = true;
    String[] goodArray = new String[] {"V4", "V5", "V2", "V1", null};
    String[] badArray = new String[] {null, "V4", "V5", "V2", "V1"};
    String[] emptyArray = new String[] {null, null, null, null, null};
    String[] fullArray = new String[] {"V4", "V5", "V2", "V1", "V1"};

    try {
      //tests valid failClimb for the expected value
      if(!(ExceptionalClimbing.failClimb(emptyArray, 0, "V3")==1)) {
        return false;
      }
      if(!(ExceptionalClimbing.failClimb(goodArray, 4, "V3") == 5)) {
        return false;
      }
      //calls failClimb with exceptions 
      ExceptionalClimbing.sendClimb(fullArray, 5, "V3");
      ExceptionalClimbing.sendClimb(goodArray, 4, "V13");
      ExceptionalClimbing.sendClimb(emptyArray, -2, "V3");
    }
    catch(IllegalArgumentException iae) {
      //changes return boolean to false if the expected iae error message does not match
      if(!iae.getMessage().equals("cannot add new value to full length 5 array") 
          && !iae.getMessage().equals("V13 is not a valid grade")) {
        doesWork = false;
      }
    }
    catch(DataFormatException dfe){
      //changes return boolean to false if the expected dfe error message does not match
      if(!dfe.getMessage().equals("invalid oversize array")) {
        doesWork = false;
      }
    }
    return doesWork;
  }
  /**
   * This method tests the getStats method in the main class
   * @return true if getStats works the way its intended to
   * @return false if getStats does not work
   */
  public static boolean testGetStats() {
    
    //creating return value as well as different arrays
    boolean doesWork = true;
    String[] emptyArray = new String[] {null, null, null, null, null};
    String[] goodArray = new String[] {"V4", "V5", "V2", "V1", null};

    try {
      //tests valid testGetStats for the expected value
      if(!ExceptionalClimbing.getStats(emptyArray, 0, goodArray, 4, 3)
          .equals("send: --\nfail: 2.6666666666666665")){
        return false;
      }
      //calls testGetStats with exceptions 
      ExceptionalClimbing.getStats(emptyArray, 0, goodArray, 4, -1);
      ExceptionalClimbing.getStats(emptyArray, 0, emptyArray, 0, 3);
    }
    catch(IllegalArgumentException iae) {
      //changes return boolean to false if the expected iae error message does not match
      if(!iae.getMessage().equals("-1 is not a valid history length")) {
        doesWork = false;
      }
    }
    catch(RuntimeException re) {
      //changes return boolean to false if the expected re error message does not match
      if(!re.getMessage().equals("no climbs provided"))
        doesWork = false;
    }
    return doesWork;
  }
  /**
   * This method tests the getHistogram method in the main class
   * @return true if getHistogram works the way its intended to
   * @return false if getHistogram does not work
   */
  public static boolean testGetHistogram() {
    
    //creating return value as well as different arrays
    boolean doesWork = true;
    String[] sendArray = new String[] {"V4", "V5", "V2", "V1", null};
    String[] failArray = new String[] {"V4", "V5", "V2", "V1", "V1"};
    String[] emptyArray = new String[] {null, null, null, null, null};

    try {
      //tests valid testGetHistogram for the expected value
      if(!(ExceptionalClimbing.getHistogram(sendArray, 4, failArray, 5)
          .equals("V0:\nV1: - - +\nV2: - +\nV3:\nV4: - +\nV5: - +"))) {
        return false;
      }
      //calls testGetHistogram with exceptions 
      ExceptionalClimbing.getHistogram(emptyArray, 0, emptyArray, 0);
    }
    catch(RuntimeException re) {
      //changes return boolean to false if the expected re error message does not match
      if(!re.getMessage().equals("no climbs provided"))
        doesWork = false;
    }
    return doesWork;
  }
  public static boolean runAllTests() {
    boolean isWorking = false;
    //tests all methods
    //return true if working and false if not working
    try {
      if (testSendClimb() && testFailClimb() && testGetStats() && testGetHistogram()) {
        isWorking = true;
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return isWorking;
  }
}
