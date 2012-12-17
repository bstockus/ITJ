package demos.gui;

import javax.swing.JOptionPane;

public class IfElseDemo {

	private int numIn;

	public void main() {
		String numString = JOptionPane.showInputDialog(null,
				"Enter an Integer.", "ENTER NUMBER",
				JOptionPane.QUESTION_MESSAGE);
		numIn = Integer.parseInt(numString);
		evaluateAndPrint();
	}

	public void evaluateAndPrint() {
		// PROCESSING: IF STATEMENTS
		if (numIn == 0)
			System.out.println("You have entered the number 0.");

		if (numIn < 10)
			System.out.println("You have entered a number less than 10.");
		else
			System.out.println("You have entered a number greater than 10.");

		if (numIn % 2 == 0) {
			System.out.println("You have entered an even number.");
			System.out.println("The number you have entered is " + numIn + ".");
			System.out
					.println("If a number is divided by 2 and has no remainder, the number is EVEN.");
		} else {
			System.out.println("You have entered an odd number.");
			System.out.println("The number you have entered is " + numIn + ".");
			System.out
					.println("If a number is divided by 2 and has no remainder, the number is ODD.");
		}

	}
}// end class

