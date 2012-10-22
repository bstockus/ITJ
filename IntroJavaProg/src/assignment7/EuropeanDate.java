package assignment7;

import javax.swing.JOptionPane;

public class EuropeanDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Step 1. Prompt the user input the date in the format mm/dd/yy
		String americanDate = JOptionPane.showInputDialog(null, "Enter a date in the format mm/dd/yy",
				"EuropeanDate",JOptionPane.QUESTION_MESSAGE);
		
		//Step 6. Use substring to find the month
		String month = americanDate.substring(0, 2);
		
		//Step 7. Use substring to find the day
		String day = americanDate.substring(3, 5);
		
		//Step 8. Use substring to find the year
		String year = americanDate.substring(6);
		
		//Step 10. Concatanate the string and display to the user
		String europeanDate = day + "." + month + "." + year;
		JOptionPane.showMessageDialog(null, "The European Date for " + americanDate + " is " + europeanDate + ".",
				"EuropeanDate", JOptionPane.PLAIN_MESSAGE);
		System.out.println("The European Date for " + americanDate + " is " + europeanDate + ".");

	}

}
