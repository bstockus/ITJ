package chapter9.demos;

import convenience.helpers.Input;

public class Demo2CopyCenter {
	/*
	 * Exception Handling DEMO program
	 * 
	 * program tests for ZERO number of copies entered and throws exception if
	 * zero is entered
	 */
	public static void main(String[] args) {
		Input input = new Input();
		int numCopies = 0;
		double totalCost = 0;
		double costFor100 = 0;
		double costForExtra = 0;

		// message box variables
		String messageText = null;
		String title = null;
		int type = 3;

		try {// start try
			messageText = "Please enter the number of copies you want.";
			title = "ENTER NUMBER OF COPIES WANTED";
			numCopies = input.getInteger(messageText, title, type);

			// PROCESSING: IF STATEMENTS
			if (numCopies <= 0)
				throw new Exception(
						"Program defined message is Exception: Zero Entered");

			// we can assume here that the number of copies
			// was > 0 because the if the exception "threw"
			// this code below would not be executed
			if (numCopies <= 100)
				totalCost = numCopies * .05;
			else {
				costFor100 = 100 * .05;
				costForExtra = (numCopies - 100) * .03;
				totalCost = costFor100 + costForExtra;
			}

			System.out.printf("The cost for " + numCopies
					+ " copies is $%4.2f.", totalCost);
		} // end try

		catch (Exception e) {// start catch
			// PRINTS SYSTEM MESSAGE AND PROGRAM MESSAGE
			// The system message is helpful to programmers,
			// but confusing to users.
			messageText = "System Message e = " + e;
			title = "CATCH ERROR";
			type = 0;
			input.writeMessage(messageText, title, type);

			// JUST PRINTS MESSAGE defined above by the programmer
			messageText = e.getMessage();
			title = "CATCH ERROR";
			type = 0;
			input.writeMessage(messageText, title, type);
		}// end catch

	}// end main method

}
