package chapter7.assignment17;

import java.util.ArrayList;
//import java.util.Arrays;

import convenience.dialogs.Dialogs;

public class TempsAboveAverage {

	public static void main(String[] args) {
		Integer numberOfTempValues = Dialogs.displayIntegerInputDialog("Number of Values", "How many temperature values would you like to enter?", 1);
		
		ArrayList<String> labels = new ArrayList<String>();
		ArrayList<Double> defaultValues = new ArrayList<Double>();
		
		for (Integer index = 0; index < numberOfTempValues; index ++) {
			labels.add("Temperature #" + (index + 1) + ": ");
			defaultValues.add(0.0);
		}
		
		ArrayList<Double> results = new ArrayList<Double>(Dialogs.displayMultiDoubleInputDialog("Temperature Values", "Enter temperature values:", labels, defaultValues));
		
		System.out.println(results.toString());
		
	}
	
}
