// Bryan Stockus, 26 SEPT 2012
package chapter3;

// Intro to JAVA, Chapter 3, Assignment 9, Program A
// PURPOSE: Write a program to calculate copy costs.

// Import Convenience Classes
import convenience.Debug;
import convenience.UserInteraction;

public class CopyCenter {
	
	// Debug Mode Constant (if true debug messages are printed):
	static Boolean DEBUG = false;
	
	// Copy center charge constants:
	static Double COST_PER_COPY_FIRST = 0.05;
	static Double COST_PER_COPY_ADDITIONAL = 0.03;
	
	public static void main(String[] args) {
		
		Debug.printDebugDoubleValue(DEBUG, "COST_PER_COPY_FIRST", COST_PER_COPY_FIRST);
		Debug.printDebugDoubleValue(DEBUG, "COST_PER_COPY_ADDITIONAL", COST_PER_COPY_ADDITIONAL);
		
		// Step 0. Declare and initialize variables:
		Integer numberOfCopies = 0;
		Double totalCost = 0.0;
		
		// Step 1. Request the number of copies from the user:
		numberOfCopies = UserInteraction.askUserForInteger("Enter # of Copies", 
				"How many copies would you like?");
		Debug.printDebugIntegerValue(DEBUG, "numberOfCopies", numberOfCopies);
		
		// Step 2. Calculate the total cost of copies:
		if(numberOfCopies <= 100) {
			totalCost = numberOfCopies * COST_PER_COPY_FIRST;
			Debug.printDebugDoubleValue(DEBUG, "totalCost", totalCost);
		} else {
			totalCost = (COST_PER_COPY_FIRST * 100) + ((numberOfCopies - 100) * COST_PER_COPY_ADDITIONAL);
			Debug.printDebugDoubleValue(DEBUG, "totalCost", totalCost);
		}
		
		// Step 3. Display the number of copies desired and the total cost to the user:
		String numberOfCopiesString = numberOfCopies.toString();
		String totalCostString = "$" + String.format("%.2f", totalCost);
		String resultsString = "The cost for " + numberOfCopiesString + " copies is "
				+ totalCostString + ".";
		UserInteraction.showUserMessage("Results", resultsString);
		System.out.println(resultsString);
		
	}

}
