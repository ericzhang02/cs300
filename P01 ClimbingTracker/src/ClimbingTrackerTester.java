//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 Climbing Tracker
// Course:   CS 300 Fall 2021
//
// Author:   Eric Zhang
// Email:    erzhang2@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Anish Singh
// Partner Email:   singh255@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X__ Write-up states that pair programming is allowed for this assignment.
//   _X__ We have both read and understand the course Pair Programming Policy.
//   _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  stackoverflow.com
//
///////////////////////////////////////////////////////////////////////////////
public class ClimbingTrackerTester {

	public static void main(String[] args) {
		runAllTests();
	}

/**
 * This method tests the sendClimb method in the main class
 * @return true if sendClimb works the way its intended to
 * 
 */
	public static boolean testSendClimb() {
		String[] testerArray = new String[10];
		int numSend = 0;

		//tests sendClimb where the array had 0 grades
		if(ClimbingTracker.sendClimb(testerArray, numSend, "V6") != 1) {
			return false;
		}

		//tests for invalid grade inputs
		numSend = 3;
		if(ClimbingTracker.sendClimb(testerArray, numSend, "V11") == 4) {
			return false;
		}
		if(ClimbingTracker.sendClimb(testerArray, numSend, "66") == 4) {
			return false;
		}
		if(ClimbingTracker.sendClimb(testerArray, numSend, "A6") == 4) {
			return false;
		}
		if(ClimbingTracker.sendClimb(testerArray, numSend, "BB") == 4) {
			return false;
		}
		if(ClimbingTracker.sendClimb(testerArray, numSend, "V") == 4) {
			return false;
		}
		if(ClimbingTracker.sendClimb(testerArray, numSend, "6") == 4) {
			return false;
		}
		if(ClimbingTracker.sendClimb(testerArray, numSend, "") == 4) {
			return false;
		}

		//tests upper edge cases
		numSend = 10;
		if(ClimbingTracker.sendClimb(testerArray, numSend, "V6") == 11) {
			return false;
		}else {
			numSend++;
		}
		numSend = 9;
		if(ClimbingTracker.sendClimb(testerArray, numSend, "V6") != 10) {
			return false;
		}else {
			numSend++;
		}
		if(ClimbingTracker.sendClimb(testerArray, numSend, "V6") != 10) {
			return false;
		}else {
			numSend++;
		}
		//returns true if everything is correctly checked
		return true;
	}
	/**
	 * This method tests the failClimb method in the main class
	 * @return true if failClimb works the way its intended to
	 * 
	 */
	public static boolean testFailClimb() {
		String[] testerArray = new String[10];
		int numFail = 0;

		//tests failClimb where the array had 0 grades
		if(ClimbingTracker.failClimb(testerArray, numFail, "V6") != 1) {
			return false;
		}

		//tests for invalid grade inputs
		numFail = 3;
		if(ClimbingTracker.failClimb(testerArray, numFail, "V11") == 4) {
			return false;
		}
		if(ClimbingTracker.failClimb(testerArray, numFail, "66") == 4) {
			return false;
		}
		if(ClimbingTracker.failClimb(testerArray, numFail, "A6") == 4) {
			return false;
		}
		if(ClimbingTracker.failClimb(testerArray, numFail, "BB") == 4) {
			return false;
		}
		if(ClimbingTracker.failClimb(testerArray, numFail, "V") == 4) {
			return false;
		}
		if(ClimbingTracker.failClimb(testerArray, numFail, "6") == 4) {
			return false;
		}
		if(ClimbingTracker.failClimb(testerArray, numFail, "") == 4) {
			return false;
		}

		//tests upper edge cases
		numFail = 10;
		if(ClimbingTracker.failClimb(testerArray, numFail, "V6") == 11) {
			return false;
		}
		numFail = 9;
		if(ClimbingTracker.sendClimb(testerArray, numFail, "V6") != 10) {
			return false;
		}
		//returns true if everything is correctly checked
		return true;
	}
	/**
	 * This method tests the getStats method in the main class
	 * @return true if getStats works the way its intended to
	 * 
	 */
	public static boolean testGetStats() {

		//creating and filling arrays 
		String[] sendArray = new String[10];
		int numSend = 0;
		sendArray[0] = "V2";
		numSend++;
		sendArray[1] = "V7";
		numSend++;
		sendArray[2] = "V8";
		numSend++;
		sendArray[3] = "V6";
		numSend++;

		String[] failArray = new String[10];
		int numFail = 0;
		failArray[0] = "V7";
		numFail++;
		failArray[1] = "V1";
		numFail++;
		failArray[2] = "V2";
		numFail++;
		failArray[3] = "V3";
		numFail++;

		//tests if getStats works where both arrays are larger than historyLength
		String test1 = ClimbingTracker.getStats(sendArray, numSend, failArray, numFail, 3);
		if (!test1.equals("send: 7.0\nfail: 2.0")) {
			return false;
		}

		//tests if getStats works where only sendArray is larger than historyLength
		numFail=2;
		String test2 = ClimbingTracker.getStats(sendArray, numSend, failArray, numFail, 3);
		if (!test2.equals("send: 7.0\nfail: 4.0")) {
			return false;
		}

		//tests if getStats works where both arrays are smaller than historyLength
		numSend=2;
		String test3 = ClimbingTracker.getStats(sendArray, numSend, failArray, numFail, 3);
		if (!test3.equals("send: 4.5\nfail: 4.0")) {
			return false;
		}

		//tests if getStats works where only failArray is larger than historyLength
		numFail=4;
		String test4 = ClimbingTracker.getStats(sendArray, numSend, failArray, numFail, 3);
		if (!test4.equals("send: 4.5\nfail: 2.0")) {
			return false;
		}

		//tests if getStats works where sendArray is not there
		numSend=0;
		String test5 = ClimbingTracker.getStats(sendArray, numSend, failArray, numFail, 3);
		if (!test5.equals("send: --\nfail: 2.0")) {
			return false;
		}

		//tests if getStats works where both sendArray and failArray is not there
		numFail=0;
		String test6 = ClimbingTracker.getStats(sendArray, numSend, failArray, numFail, 3);
		if (!test6.equals("send: --\nfail: --")) {
			return false;
		}

		//tests if getStats works where failArray is not there
		numSend=4;
		String test7 = ClimbingTracker.getStats(sendArray, numSend, failArray, numFail, 3);
		
		if (!test7.equals("send: 7.0\nfail: --")) {
			return false;
		}
		return true;
	}
	/**
	 * This method tests the getHistogram method in the main class
	 * @return true if getHistogram works the way its intended to
	 * 
	 */
	public static boolean testGetHistogram() {

		//creating and filling arrays 
		String[] testerSendArray = new String[10];
		int numSend = 0;
		testerSendArray[0] = "V2";
		numSend++;
		testerSendArray[1] = "V1";
		numSend++;
		testerSendArray[2] = "V0";
		numSend++;
		testerSendArray[3] = "V5";
		numSend++;

		String[] testerFailArray = new String[10];
		int numFail = 0;
		testerFailArray[0] = "V0";
		numFail++;
		testerFailArray[1] = "V1";
		numFail++;
		testerFailArray[2] = "V2";
		numFail++;
		testerFailArray[3] = "V0";
		numFail++;

		//tests getHistogram 
		String test1 = ClimbingTracker.getHistogram(testerSendArray, numSend, testerFailArray, numFail);
		if(!test1.equals("V0: - - +\nV1: - +\nV2: - +\nV3:\nV4:\nV5: +")) {
			return false;
		}

		//tests get histogram where only sendArray are valid
		numFail = 0;
		String test2 = ClimbingTracker.getHistogram(testerSendArray, numSend, testerFailArray, numFail);
		if(!test2.equals("V0: +\nV1: +\nV2: +\nV3:\nV4:\nV5: +")) {
			return false;
		}
		//tests get histogram where both sendArray and failArray are invalid
		numSend = 0;
		String test3 = ClimbingTracker.getHistogram(testerSendArray, numSend, testerFailArray, numFail);
		if(!test3.equals("Error: no data to display")) {
			return false;
		}
		//tests get histogram where only failArray are valid
		numFail = 4;
		String test4 = ClimbingTracker.getHistogram(testerSendArray, numSend, testerFailArray, numFail);
		if(!test4.equals("V0: - -\nV1: -\nV2: -")) {
			return false;
		}
		return true;
	}
	/**
	 * This method tests all the methods in the main classes by running all the test methods in the testing class
	 * @return true if everything works as intendedo
	 * 
	 */
	public static boolean runAllTests() {
		if (testSendClimb() && testFailClimb() && testGetStats() && testGetHistogram()) {
			return true;
		}
		else {
			return false;
		}
	}

}

