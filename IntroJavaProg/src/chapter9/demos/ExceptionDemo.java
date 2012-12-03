package chapter9.demos;

import java.util.Scanner;

/*
 * this program demonstrates exception handling
 * the program asks for a number of doughnuts, and a number of glasses of milk
 * if glasses of milk is less than 1, an exception occurs
 */
public class ExceptionDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		try {
			System.out.println("How many donuts do you have?");
			int donutCount = keyboard.nextInt();
			System.out.println("How many glasses of milk do you have?");
			int milkCount = keyboard.nextInt();

			// ***** here is where we test for the exception (<1 entry in
			// variable milkCount)
			if (milkCount < 1)
				throw new Exception("Exception: You have no milk.");
			// ***** if milkCount <1, the code below will not execute
			// ***** if milkCount <1, program execution goes to the catch code

			double donutsPerGlass = donutCount / (double) milkCount;
			System.out.println(donutCount + " donuts.");
			System.out.println(milkCount + " glasses of milk.");
			System.out.println("You have " + donutsPerGlass
					+ " donuts for each glass of milk.");
		} catch (Exception e) {
			// e.getMessage (below) returns the message we defined above
			System.out.println(e.getMessage());

			// PRINTS SYSTEM MESSAGE AND PROGRAM MESSAGE
			// this message is often more confusing than helpful
			System.out.println(e);

		}

		System.out.println("End of program.");
	}
}
