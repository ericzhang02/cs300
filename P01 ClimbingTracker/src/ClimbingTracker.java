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
public class ClimbingTracker {
/*
 * This method adds a successful climb to the oversize array if there is space
 * @return space left in oversize array
 */
	public static int sendClimb(String[] send,int numSend,String grade) {

		if(grade.length() == 2) {
			boolean isValidGrade = false; 
			for (int potentialValidGrade = 0; potentialValidGrade<=8; potentialValidGrade++) {
				String potentialValidGradeString = Integer.toString(potentialValidGrade);
				if(grade.substring(1).equals(potentialValidGradeString)) {
					isValidGrade = true;
				}
			}

			if((send.length-numSend)>0 && grade.charAt(0) == 'V' && isValidGrade == true ) {
				send[numSend] = grade;
				numSend++;
				return numSend;
			}	
		}
		return numSend;
	}
	/*
	 * This method adds an unsuccessful climb to the oversize array if there is space
	 * @return space left in oversize array
	 */
	public static int failClimb(String[] fail,int numFail,String grade) {
		if(grade.length() ==2) {
			boolean isValidGrade = false; 
			for (int potentialValidGrade = 0; potentialValidGrade<=8; potentialValidGrade++) {
				String potentialValidGradeString = Integer.toString(potentialValidGrade);
				if(grade.substring(1).equals(potentialValidGradeString)) {
					isValidGrade = true;
				}
			}

			if((fail.length-numFail)>0 && grade.charAt(0) == 'V' && isValidGrade == true) {
				fail[numFail] = grade;
				numFail++;

				return numFail;
			}	
		}

		return numFail;
	}

/*
 * 
 * @return a formatted string with the average values of fails and sends
 */
	public static String getStats(String[] send,int numSend,String[] fail,int numFail,int historyLength) {

		//doubles we return
		double sendAvg = 0.0;
		double failAvg = 0.0;
		String emptyInput = "--";

		//Establishes if there is a usable send and fail arrays
		boolean isEnoughSend = false;
		boolean isEnoughFail = false;
		if(numSend>0) {
			isEnoughSend=true;
		}
		if(numFail>0) {
			isEnoughFail=true;	
		}

		//calculates avg given different situations
		if(historyLength>0) {
			if (isEnoughSend == true) {
				if (historyLength<numSend) {
					for(int indexSend=numSend-historyLength; indexSend<numSend; indexSend++) {
						String tempsend = send[indexSend];
						String tempsend2 = tempsend.substring(1);
						double val = Double.parseDouble(tempsend2);
						sendAvg = val + sendAvg;
					}
					sendAvg = sendAvg/historyLength;
				}else {
					for(int indexSend=0; indexSend<numSend; indexSend++) {
						String tempsend = send[indexSend];
						String tempsend2 = tempsend.substring(1);
						double val = Double.parseDouble(tempsend2);
						sendAvg = val + sendAvg;
					}
					sendAvg = (double)(sendAvg/numSend);
				}
			}
			if(isEnoughFail == true) {
				if (historyLength<numFail) {
					for(int indexFail=numFail-historyLength; indexFail<numFail; indexFail++) {
						String tempfail = fail[indexFail];
						String tempfail2 = tempfail.substring(1);
						double val = Double.parseDouble(tempfail2);
						failAvg = val + failAvg;
					}
					failAvg = (double)(failAvg/historyLength);
				}else {
					for(int indexFail=0; indexFail<numFail; indexFail++) {
						String tempfail = fail[indexFail];
						String tempfail2 = tempfail.substring(1);
						double val = Double.parseDouble(tempfail2);
						failAvg = val + failAvg;
					}
					failAvg = (double)(failAvg/numFail);
				}
			}
		}

		//returns based upon situation
		if(isEnoughSend && isEnoughFail) {
			String finalOutput = "send: " + Double.toString(sendAvg) + "\nfail: " + Double.toString(failAvg);
			return finalOutput;
		}
		else if(isEnoughSend && !isEnoughFail) {
			String finalOutput = "send: " + Double.toString(sendAvg) + "\nfail: " + emptyInput ;
			return finalOutput;
		}
		else if(!isEnoughSend && isEnoughFail) {
			String finalOutput = "send: " + emptyInput + "\nfail: " + Double.toString(failAvg) ;
			return finalOutput;
		}
		else{
			String finalOutput = "send: " + emptyInput + "\nfail: " + emptyInput ;
			return finalOutput;
		}
	}

	/*
	 * @return a formatted string visualizing the number of sends and fails in each grade
	 */
	public static String getHistogram(String[] send,int numSend,String[] fail,int numFail) {
		//creates return string and largest valid grade integer
		String finalString = "";
		int largestGrade = 0;
		//checks for while arrays are empty
		boolean isEnoughSend = false;
		boolean isEnoughFail = false;
		if(numSend>0) {
			isEnoughSend=true;
		}
		if(numFail>0) {
			isEnoughFail=true;	
		}

		//looks for the largest grade in send and then in fail
		for(int counterSend = 0; counterSend<numSend; counterSend++) {
			String tempsend = send[counterSend];
			String tempsend2 = tempsend.substring(1);
			int val = Integer.parseInt(tempsend2);
			if(val>largestGrade) {
				largestGrade = val;
			}
		}
		for(int counterFail = 0; counterFail<numFail; counterFail++) {
			String tempfail = fail[counterFail];
			String tempfail2 = tempfail.substring(1);
			int val = Integer.parseInt(tempfail2);
			if(val>largestGrade) {
				largestGrade = val;
			}
		}

		//return error message is both arrays are empty
		if(!isEnoughSend && !isEnoughFail) {
			String finalOutput = "Error: no data to display";
			return finalOutput;
		}
		
		//adds to finalString
		for(int numLines = 0; numLines<=largestGrade; numLines++) {
			finalString = finalString + "V" + Integer.toString(numLines)+":";
			for(int potentialGrade = 0; potentialGrade < numFail; potentialGrade ++) {
				String tempfail = fail[potentialGrade];
				String tempfail2 = tempfail.substring(1);
				int val = Integer.parseInt(tempfail2);
				if(val == numLines ) {
					finalString = finalString + " -";
				}	
			}
			for(int potentialGrade = 0; potentialGrade < numSend; potentialGrade ++) {
				String tempsend = send[potentialGrade];
				String tempsend2 = tempsend.substring(1);
				int val = Integer.parseInt(tempsend2);
				if(val == numLines ) {
					finalString = finalString + " +";
				}	
			}

			if(numLines<largestGrade) {
				finalString = finalString + "\n";
			}
		}
		//returns finalString. Do I even need to comment this?
		return finalString;
	}
}