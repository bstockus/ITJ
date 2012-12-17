package demos.gui;

import javax.swing.JOptionPane;

public class GetGross {
	private static double wage;
	private static double hours;
	private static double gross;

	public void main() {

		String wageString = JOptionPane.showInputDialog(null, "Enter Wage:",
				"ENTER WAGE", JOptionPane.QUESTION_MESSAGE);
		wage = Double.parseDouble(wageString);
		String hoursString = JOptionPane.showInputDialog(null, "Enter Hours:",
				"ENTER HOURS", JOptionPane.QUESTION_MESSAGE);
		hours = Double.parseDouble(hoursString);
		gross = 0.0;

		// call methods
		calcGross();
		printCheck();
	}

	// calc gross pay
	public static double calcGross() {
		double OTwage;
		double OThours;
		double OTamount;
		double regAmount;
		if (hours <= 40)
			return gross = wage * hours;
		else {
			OTwage = wage * 1.5;
			OThours = hours - 40;
			OTamount = OThours * OTwage;
			regAmount = 40 * wage;
			return gross = regAmount + OTamount;
		}
	}

	public static void printCheck() {
		// Simulate the printing of a ticket.
		System.out.println("##################");
		System.out.println("wage is " + wage);
		System.out.println("hours are " + hours);

		System.out.println("#Gross Pay is");
		System.out.println("# " + gross);
		System.out.println("##################");
		System.out.println();
	}

}
