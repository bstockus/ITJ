package exams;

import javax.swing.JOptionPane;

public class Exam1 {
	
	//Output String Constants
	static String OUTPUT_PART_A = ", although it is ";
	static String OUTPUT_PART_B = " degrees in ";
	static String OUTPUT_PART_C = ", it will be ";
	static String OUTPUT_PART_D = " degrees Celsius when the ";
	static String OUTPUT_PART_E = " family arrives in Europe.";
	
	//Debug Printing Toggle Constant
	static Boolean DEBUG = false; //Set to true to enable printDebug<type>Value methods
	
	/**
	 * Convenience function for printing the name and value of a string for debugging
	 * @param args
	 */
	private static void printDebugStringValue(String name, String value) {
		if(DEBUG) {
			System.out.printf("***DEBUG*** %s: value=\'%s\', length=%d\n",name,value,value.length());
		}
	}
	
	/**
	 * Convenience function for printing the name and value of a double for debugging
	 * @param args
	 */
	private static void printDebugDoubleValue(String name, Double value) {
		if(DEBUG) {
			System.out.printf("***DEBUG*** %s: %f\n",name,value);
		}
	}
	
	/**
	 * Convenience function for printing the name and value of an integer for debugging
	 * @param args
	 */
	private static void printDebugIntegerValue(String name, Integer value) {
		if(DEBUG) {
			System.out.printf("***DEBUG*** %s: %d\n",name,value);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Step 2. Declare and initialize all variables
		// Temperature Conversion Variables:
		String fahrenheitTemperatureString = "";
		Double fahrenheitTemperature = 0.0;
		Double celsiusTemperature = 0.0;
		// Name Splitter Variables:
		String firstAndLastNameString = "";
		Integer spaceIndex = 0;
		String firstNameString = "";
		String lastNameString = "";
		// State Capitalizer Variables:
		String stateString = "";
		String stateAbbreviationString = "";
		// Output Variables:
		String fahrenheitTemperatureOutputString = "";
		String celsiusTemperatureOutputString = "";
		String outputString = "";
		
		//Step 6. Use JOptionPane to ask the user for
		// Step 6a. the Fahrenheit temperature
		fahrenheitTemperatureString = JOptionPane.showInputDialog(null,"Please enter a fahrenheit temperature.\n"
				+ "This temperature can be either a whole number or a decimal number.", "ENTER FAHRENHEIT TEMP",
				JOptionPane.QUESTION_MESSAGE);
		printDebugStringValue("fahrenheitTemperatureString", fahrenheitTemperatureString);
		fahrenheitTemperature = Double.parseDouble(fahrenheitTemperatureString);
		printDebugDoubleValue("fahrenheitTemperature", fahrenheitTemperature);
		// Step 6b. a first and last name
		firstAndLastNameString = JOptionPane.showInputDialog(null,"Please enter a first and last name seperated by a space.\n"
				+ "Format: Firstname<space>Lastname","ENTER WHOLE NAME", JOptionPane.QUESTION_MESSAGE);
		printDebugStringValue("firstAndLastNameString", firstAndLastNameString);
		// Step 6c. a state
		stateString = JOptionPane.showInputDialog(null,"Please enter an UNabbreviated state.\nFormat: Wisconsin",
				"ENTER STATE", JOptionPane.QUESTION_MESSAGE);
		printDebugStringValue("stateString", stateString);
		
		//Step 7. Convert the Fahrenheit temperature to Celsius
		celsiusTemperature = (fahrenheitTemperature - 32.0) * 0.55;
		printDebugDoubleValue("celsiusTemperature", celsiusTemperature);
		
		//Step 8. Using String Methods, Separate the whole name into first name and last names
		spaceIndex = firstAndLastNameString.indexOf(" ");
		printDebugIntegerValue("spaceIndex", spaceIndex);
		firstNameString = firstAndLastNameString.substring(0, spaceIndex);
		printDebugStringValue("firstNameString", firstNameString);
		lastNameString = firstAndLastNameString.substring(spaceIndex + 1);
		printDebugStringValue("lastNameString", lastNameString);
		
		//Step 9. Using String Methods, find the first 2 characters of the state entered
		stateAbbreviationString = stateString.substring(0, 2);
		printDebugStringValue("stateAbbreviationString (Step 9)",stateAbbreviationString);
		
		//Step 10. Using String Methods, make the first 2 characters of the state UPPER CASE
		stateAbbreviationString = stateAbbreviationString.toUpperCase();
		printDebugStringValue("stateAbbreviationString (Step 10)",stateAbbreviationString);
		
		//Step 11. Format and display output to user on the console
		fahrenheitTemperatureOutputString = String.format("%3.2f", fahrenheitTemperature);
		printDebugStringValue("fahrenheitTemperatureOutputString", fahrenheitTemperatureOutputString);
		celsiusTemperatureOutputString = String.format("%3.2f", celsiusTemperature);
		printDebugStringValue("celsiusTemperatureOutputString", celsiusTemperatureOutputString);
		outputString = firstNameString + OUTPUT_PART_A + fahrenheitTemperatureOutputString + OUTPUT_PART_B
				+ stateAbbreviationString + OUTPUT_PART_C + celsiusTemperatureOutputString + OUTPUT_PART_D
				+ lastNameString + OUTPUT_PART_E;
		System.out.println(outputString);
	}

}
