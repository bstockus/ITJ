package chapter5.assignment14;

import convenience.Input;

public class CopyCenterREWRITE {
	
	private static Integer getInput() {
		Input input = new Input();
		return input.getInteger("How many copies would you like?", "Enter # of Copies", 3);
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
		input.writeMessage("The cost for " + numberOfCopies.toString() + " is " + costString + ".", "Results", 0);
	}
	
	public static void main(String[] args) {
		Integer numberOfCopies = CopyCenterREWRITE.getInput();
		CopyCenterREWRITE.printCost(numberOfCopies, CopyCenterREWRITE.calcCost(numberOfCopies));
	}
}
