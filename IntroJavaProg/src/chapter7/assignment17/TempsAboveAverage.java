package chapter7.assignment17;

import convenience.dialogs.Dialogs;

public class TempsAboveAverage {

	public static void main(String[] args) {
		Integer numberOfTempValues;
		
		while (true) {
			numberOfTempValues = Dialogs.displayIntegerInputDialog("Number of Values", "How many temperature values would you like to enter?", 1);
			if (numberOfTempValues <= 0) {
				Dialogs.displayErrorDialog("INPUT ERROR", "Value must be greater than 0!");
			} else if (numberOfTempValues > 1000) {
				Dialogs.displayErrorDialog("INPUT ERROR", "Value must be less than or equal to 1000!");
			} else {
				break;
			}
		}
		
		String[] labels = new String[numberOfTempValues];
		Double[] defaultValues = new Double[numberOfTempValues];
		
		for (Integer index = 0; index < numberOfTempValues; index ++) {
			labels[index] = "Temperature #" + (index + 1) + ": ";
			defaultValues[index] = null;
		}
		
		Double[] results = Dialogs.displayMultiDoubleInputDialog("Temperatures", "Please enter your temperature values:", labels, defaultValues);
		
		Double sum = 0.0;
		
		for (Double value: results) {
			sum += value;
		}
		
		Double average = sum / numberOfTempValues;
		
		String output = "The average temperature is: " + String.format("%.2f", average) + "\n";
		
		Integer aboveAverage = 0;
		
		for (Integer index = 0; index < numberOfTempValues; index ++) {
			Double value = results[index];
			if (value > average) {
				aboveAverage ++;
				output += "Day " + index.toString() + " had a temperature of " + String.format("%.2f", value) + " which was above average\n";
			}
		}
		
		output += "The number of days with a temperature above average is: " + aboveAverage.toString();
		
		Dialogs.displayResultsDialog("Results", output);
		
	}
	
}
