package chapter5.assignment14;

import convenience.helpers.Input;

public class CopyCenterREWRITE {
	
	private static Integer getInput() {
		Input input = new Input();
		for (;;) {
			Integer numberOfCopies = input.getInteger("How many copies would you like?", "Enter # of Copies", 3);
			if (numberOfCopies < 0) {
				input.writeMessage("ERROR: How is it possible to make a negative number of copies?\nNumber of copies must be greater than or equal to 0.",
						"INPUT ERROR", 0);
			} else {
				return numberOfCopies;
			}
		}
	}
	
	private static Double calcCost(Integer numberOfCopies) {
		if (numberOfCopies > 100) {
			return (((numberOfCopies - 100) * 0.03) + 5.00);
		} else {
			return (numberOfCopies * 0.05);
		}
	}
	
	private static void printCost(Integer numberOfCopies, Double cost) {
		Input input = new Input();
		String costString = String.format("$%.2f", cost);
		String numberOfCopiesString = numberOfCopies.toString();
		if (numberOfCopies == 1) {
			numberOfCopiesString += " copy";
		} else {
			numberOfCopiesString += " copies";
		}
		input.writeMessage("The cost for " + numberOfCopiesString + " is " + costString + ".", "Results", 1);
	}
	
	public static void main(String[] args) {
		Integer numberOfCopies = CopyCenterREWRITE.getInput();
		CopyCenterREWRITE.printCost(numberOfCopies, CopyCenterREWRITE.calcCost(numberOfCopies));
	}
}
