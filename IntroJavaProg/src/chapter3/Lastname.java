package chapter3;

import convenience.InputModified;

public class Lastname {

	public static void main(String[] args) {
		// Declare and Initialize Variables
		String lastName = "";
		String pluralLastName = "";
		InputModified input = new InputModified();
		
		// Step 1. Using the input class, ask the user for a last name
		lastName = input.getString("Enter your last name", "LASTNAME", 3);
		
		// Step 2. Find the plural last name
		if ((lastName.endsWith("s")) || (lastName.endsWith("S"))) {
			pluralLastName = lastName + "'";
		} else {
			pluralLastName = lastName + "'s";
		}
		
		// Step 3. Use the message box method to output the answer
		input.writeMessage("The plural of " + lastName + " is " + pluralLastName + "." , "LASTNAME", 1);
	}

}
