package chapter2;

import javax.swing.JOptionPane;

public class Lunch {
	
	// declare a static variable (aka constant) as shown in the line below
		// static variable names use UPPER CASE letters
		public static final double WITAX = .055;
		public static final int DAYS  = 5;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declare and initialize variables 
		double mon=0;
		double tue=0;
		double wed=0;
		double thu=0;
		double fri=0;
		
		String monIn="";
		String tueIn="";
		String wedIn="";
		String thuIn="";
		String friIn="";
		
		double weekly = 0;
		double tax = 0;
		double weeklyWithTax = 0;
		double average = 0;

		// J Option Pane INPUT - SYNTAX in below line
		//String response = JOptionPane.showInputDialog(null,"What is your name?",  "Enter your name",JOptionPane.QUESTION_MESSAGE);  
		
		// welcome box
		JOptionPane.showMessageDialog(null, 
				"This program will calculate your lunch costs.\n " +
				"You will need to enter your lunch costs for:\n-  " +
				"Monday\n-  Tuesday\n-  Wednesday\n-  Thursday\n-  Friday",
				"WHAT'S FOR LUNCH?",JOptionPane.PLAIN_MESSAGE);
		
		// INPUT 1 - Monday
		monIn = JOptionPane.showInputDialog(null, 
				"How much did Monday's lunch cost?",
				"Monday Lunch Cost - Enter Price",
				JOptionPane.QUESTION_MESSAGE);
		mon = Double.parseDouble(monIn);

		// INPUT 2 - Tuesday
		tueIn = JOptionPane.showInputDialog(null, 
				"How much did Tuesday's lunch cost?",
				"Tuesday Lunch Cost - Enter Price",
				JOptionPane.QUESTION_MESSAGE);
		tue = Double.parseDouble(tueIn);

		// INPUT 3 - Wednesday
		wedIn = JOptionPane.showInputDialog(null, 
				"How much did Wednesday's lunch cost?",
				"Wednesday Lunch Cost - Enter Price",
				JOptionPane.QUESTION_MESSAGE);
		wed = Double.parseDouble(wedIn);
		
		// INPUT 4- Thursday
		thuIn = JOptionPane.showInputDialog(null, 
				"How much did Thursday's lunch cost?",
				"Thursday Lunch Cost - Enter Price",
				JOptionPane.QUESTION_MESSAGE);
		thu = Double.parseDouble(thuIn);
				
		// INPUT 4- Friday
		friIn = JOptionPane.showInputDialog(null, 
				"How much did Friday's lunch cost?",
				"Friday Lunch Cost - Enter Price",
				JOptionPane.QUESTION_MESSAGE);
		fri = Double.parseDouble(friIn);		

		
		//PROCESSING - calculations
		weekly = mon + tue + wed + thu + fri;
		tax = weekly * WITAX;
		weeklyWithTax = weekly + tax;
		average = weeklyWithTax / DAYS;
		
		
		
		//OUTPUT - console output
		JOptionPane.showMessageDialog(null, "The weekly total is $" 
		+ weeklyWithTax,"Weekly Lunch Total",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "The weekly average $" + average,"Average Lunch Total",JOptionPane.INFORMATION_MESSAGE);
		
		// printed output
//		System.out.println("*****   What's For Lunch?   *****");
//		System.out.println("Monday:              " + mon);
//		System.out.println("Tuesday:             " + tue);
//		System.out.println("Wednesday:           " + wed);
//		System.out.println("Thursday:            " + thu);
//		System.out.println("Friday:              " + fri);
//		System.out.println("---------------------------------");
//		System.out.println("Total:               $ " + weekly);
//		System.out.println("Wisconsin tax:       $ " + tax);
//		System.out.println("Weekly Total:        $ " + weeklyWithTax);
//		System.out.println("Daily Average:       $ " + average);
		

		System.out.printf("%21c*** What's For Lunch? ***\n",' ');
		//System.out.printf("1234567890123456789012345678901235678901234567890123456789012345678901234567890\n");
		
		System.out.printf("Day%13cMonday   Tuesday Wednesday  Thursday    Friday\n",' ');
		//System.out.printf("1234567890123456789012345678901235678901234567890123456789012345678901234567890\n");
		
		System.out.printf("%16c%6.2f %9.2f %9.2f %9.2f %9.2f\n",' ',mon,tue,wed,thu,fri);
		//System.out.printf("1234567890123456789012345678901235678901234567890123456789012345678901234567890\n");
		
		System.out.printf("%52c----------\n",' ');
		//System.out.printf("1234567890123456789012345678901235678901234567890123456789012345678901234567890\n");
		
		System.out.printf("M-F Total%43c %9.2f\n",' ',weekly);
		//System.out.printf("1234567890123456789012345678901235678901234567890123456789012345678901234567890\n");
		
		System.out.printf("Tax%49c %9.2f\n",' ',tax);
		//System.out.printf("1234567890123456789012345678901235678901234567890123456789012345678901234567890\n");
		
		System.out.printf("Pay This Amount%37c$%9.2f\n",' ',weeklyWithTax);
		//System.out.printf("1234567890123456789012345678901235678901234567890123456789012345678901234567890\n");
		
		System.exit(0);
	}

}
