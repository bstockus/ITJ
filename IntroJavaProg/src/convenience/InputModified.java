package convenience;

import javax.swing.JOptionPane;

/**
 * Class for getting input from a user using {@link javax.swing.JOptionPane}
 */
public class InputModified {

	/**
	 * Gets a string value from the user
	 * @param messageText text to display in the dialog box
	 * @param title title to use for the dialog box
	 * @param type icon to display for the text box
	 * @return the string entered by the user
	 */
	public String getString(String messageText, String title, int type) {
		String answer = JOptionPane.showInputDialog(null,messageText,title,type); 
		
		if (answer.equals("")) {
			return "";
		} else {
			return answer;
		}
	}
	
	/**
	 * Gets an integer from the user
	 * @param messageText text to display in the dialog box
	 * @param title title to use for the dialog box
	 * @param type icon to display for the text box
	 * @return the integer entered by the user
	 */
	public int getInteger(String messageText, String title, int type) {
		String answer = JOptionPane.showInputDialog(null,messageText,title,type); 

		//test for numeric
		boolean isNumber =  answer.matches("-?\\d+(.\\d+)?");

		// test for a numeric value
		if (isNumber==false) {
			//call error message method
			writeMessage("Error.  You have not entered a valid INTEGER.\nThe program will now terminate.","ERROR",0);
			// terminate the program
			System.exit(0);
			return 0;// must have a return statement in accessor method
		} else {
			return Integer.parseInt(answer);
		}
	}
	
	/**
	 * Gets a double from the user
	 * @param messageText text to display in the dialog box
	 * @param title title to use for the dialog box
	 * @param type icon to display for the text box
	 * @return the double entered by the user
	 */
	public double getDouble(String messageText, String title, int type) {
		String answer = JOptionPane.showInputDialog(null,messageText,title,type); 

		//test for numeric
		boolean isNumber =  answer.matches("-?\\d+(.\\d+)?");

		// test for a numeric value
		if (isNumber==false) {
			//call error message method
			writeMessage("Error.  You have not entered a valid number of the type DOUBLE.\nThe program will now terminate.","ERROR",0);
			// terminate the program
			System.exit(0);
			return 0;// must have a return statement in accessor method
		} else {
			return Double.parseDouble(answer);
		}
	}
	
	/**
	 * Gets a float from the user
	 * @param messageText text to display in the dialog box
	 * @param title title to use for the dialog box
	 * @param type icon to display for the text box
	 * @return the float entered by the user
	 */
	public float getFloat(String messageText, String title, int type) {
		String answer = JOptionPane.showInputDialog(null,messageText,title,type);
		//test for numeric
		boolean isNumber =  answer.matches("-?\\d+(.\\d+)?");

		// test for a numeric value
		if (isNumber==false) {
			//call error message method
			writeMessage("Error.  You have not entered a valid number of the type FLOAT.\nThe program will now terminate.","ERROR",0);
			// terminate the program
			System.exit(0);
			return 0;// must have a return statement in accessor method
		} else {
			return Float.parseFloat(answer);
		}
	}
	
	/**
	 * Displays a message dialog to the user
	 * @param messageText text to display in the dialog box
	 * @param title title to use for the dialog box
	 * @param type icon to display for the text box
	 */
	public void writeMessage(String messageText,String title,int type)
	{
		JOptionPane.showMessageDialog(null,messageText,title,type); 
	}

}