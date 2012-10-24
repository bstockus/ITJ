package chapter4;

import convenience.helpers.Input;

public class LoopingDemo1 {
	
	public static void main(String[] args) {
		// declare and initialize variables
		Input input = new Input();
		int choice = 0;
		
		Boolean loop = true;
		
		while (loop) {
			// call method to obtain program input
			choice = LoopingDemo1.getInput();

			// process according to user choice
			if (choice == 1) {
				LoopingDemo1.processChoice1();
			} else if (choice == 2) {
				LoopingDemo1.processChoice2();
			}
			
			loop = input.getBoolean("Would you like to run this program again?", "RUN AGAIN?", 3);
			
		}
		
		

	}
	
	/**
	 * Gets input from the user
	 * @return choice selected by the user
	 */
	public static int getInput() {
		// test for valid entry - if no valid entry, force valid entry
		Input input = new Input();
		Boolean validInput = false;
		Integer choice = 0;
		while (!validInput) {
			choice = input.getInteger("Please enter a choice from the menu below:\n"
					+ "(1) Menu Option 1\n(2) Menu Option 2\n(3) Exit Program",
					"INPUT MENU", 3);

			if (choice == 3) {
				input.writeMessage("Now exiting program.", "Exit", 2);
				System.exit(0);
			} else if ((choice == 1) || (choice == 2)) {
				validInput = true;
			} else {
				input.writeMessage("Invalid Menu Selection", "MENU ERROR", 0);
			}
			
		}
		
		return choice;
		
		
	}

	/**
	 * Performs processing for choice 1
	 */
	public static void processChoice1() {
		Input input = new Input();
		input.writeMessage("............... now processing choice 1 ....................", "PROCESSING", 3);
	}

	/**
	 * Performs processing for choice 2
	 */
	public static void processChoice2() {
		Input input = new Input();
		input.writeMessage("............... now processing choice 2 ....................", "PROCESSING", 3);
	}

}
