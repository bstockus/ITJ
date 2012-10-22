package convenience;

import javax.swing.JOptionPane;

/**
 * Convenience class for interacting with the user via {@link javax.swing.JOptionPane}.
 * This is a static class, and should never be instantiated.
 */
public class UserInteraction {
	
	/**
	 * Asks the user to input a string
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 * @param emptyStringAllowed
	 * @return string user entered
	 */
	public static String askUserForString(String title, String text, Boolean emptyStringAllowed) {
		for(;;) {
			String input = JOptionPane.showInputDialog(null, text, title, JOptionPane.QUESTION_MESSAGE);
			if(input == null) {
				System.exit(-1);
				return "";
			} else {
				if(emptyStringAllowed == false) {
					if(input.length() <= 0) {
						UserInteraction.showUserErrorMessage("INPUT ERROR", "You must enter some text");
					} else {
						return input;
					}
				} else {
					return input;
				}
			}
		}
	}
	
	/**
	 * Asks user to input a string or empty value
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 * @return string user entered
	 */
	public static String askUserForString(String title, String text) {
		return UserInteraction.askUserForString(title, text, true);
	}
	
	/**
	 * Asks the user to input an integer
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 * @param defaultValue
	 * @return integer user entered or defaultValue if empty entry
	 */
	public static Integer askUserForInteger(String title, String text, Integer defaultValue) {
		for(;;) {
			String input = JOptionPane.showInputDialog(null, text, title, JOptionPane.QUESTION_MESSAGE);
			if(input == null) {
				System.exit(-1);
				return 0;
			} else {
				if(input.length() <= 0) {
					return defaultValue;
				} else {
					try {
						Integer value = Integer.parseInt(input);
						return value;
					}  catch (java.lang.NumberFormatException e) {
						UserInteraction.showUserErrorMessage("INPUT ERROR", "You must enter a valid whole number");
					}
				}
			}
		}
	}
	
	/**
	 * Asks user to input an integer
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 * @return integer user entered or 0 if empty entry
	 */
	public static Integer askUserForInteger(String title, String text) {
		return UserInteraction.askUserForInteger(title, text, 0);
	}
	
	/**
	 * Asks user to input a double
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 * @param defaultValue
	 * @return double user entered or defaultValue if empty entry
	 */
	public static Double askUserForDouble(String title, String text, Double defaultValue) {
		for(;;) {
			String input = JOptionPane.showInputDialog(null, text, title, JOptionPane.QUESTION_MESSAGE);
			if(input == null) {
				System.exit(-1);
				return 0.0;
			} else {
				if(input.length() <= 0) {
					return defaultValue;
				} else {
					try {
						Double value = Double.parseDouble(input);
						return value;
					}  catch (java.lang.NumberFormatException e) {
						UserInteraction.showUserErrorMessage("INPUT ERROR", "You must enter a valid decimal number");
					}
				}
			}
		}
	}
	
	/**
	 * Asks user to input a double
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 * @return double user entered or 0.0 if empty entry
	 */
	public static Double askUserForDouble(String title, String text) {
		return UserInteraction.askUserForDouble(title, text, 0.0);
	}
	
	/**
	 * Asks user to input a float
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 * @param defaultValue
	 * @return float user entered or defaultValue if empty entry
	 */
	public static Float askUserForFloat(String title, String text, Float defaultValue) {
		for(;;) {
			String input = JOptionPane.showInputDialog(null, text, title, JOptionPane.QUESTION_MESSAGE);
			if(input == null) {
				System.exit(-1);
				return 0.0f;
			} else {
				if(input.length() <= 0) {
					return defaultValue;
				} else {
					try {
						Float value = Float.parseFloat(input);
						return value;
					}  catch (java.lang.NumberFormatException e) {
						UserInteraction.showUserErrorMessage("INPUT ERROR", "You must enter a valid decimal number");
					}
				}
			}
		}
	}
	
	/**
	 * Asks user to input a float
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 * @return float user entered or 0.0 if empty entry
	 */
	public static Float askUserForFloat(String title, String text) {
		return UserInteraction.askUserForFloat(title, text, 0.0f);
	}
	
	/**
	 * Asks user to input a boolean
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 * @return boolean user entered
	 */
	public static Boolean askUserForBoolean(String title, String text) {
		Integer input = JOptionPane.showConfirmDialog(null, text, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(input == JOptionPane.YES_OPTION) {
			return true;
		} else if(input == JOptionPane.NO_OPTION) {
			return false;
		} else {
			System.exit(-1);
			return false;
		}
	}
	
	/**
	 * Shows a message to the user
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 * @param type message type of the dialog box displayed to the user
	 */
	public static void showUserMessage(String title, String text, Integer type) {
		JOptionPane.showMessageDialog(null, text, title, type);
	}
	
	/**
	 * Shows an error message to the user
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 */
	public static void showUserErrorMessage(String title, String text) {
		UserInteraction.showUserMessage(title, text, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Shows an information message to the user
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 */
	public static void showUserInformationMessage(String title, String text) {
		UserInteraction.showUserMessage(title, text, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Shows a warning message to the user
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 */
	public static void showUserWarningMessage(String title, String text) {
		UserInteraction.showUserMessage(title, text, JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Shows a plain message to the user
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 */
	public static void showUserPlainMessage(String title, String text) {
		UserInteraction.showUserMessage(title, text, JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * Shows a plain message to the user
	 * @param title message title of the dialog box displayed to the user
	 * @param text message content of the dialog box displayed to the user
	 */
	public static void showUserMessage(String title, String text) {
		UserInteraction.showUserPlainMessage(title, text);
	}
	
	public static void main(String[] args) {
		UserInteraction.showUserErrorMessage("ERROR", "This is an error message");
		UserInteraction.showUserInformationMessage("INFORMATION", "This is an information message");
		UserInteraction.showUserWarningMessage("WARNING", "This is a warning message");
		UserInteraction.showUserPlainMessage("PLAIN", "This is a plain message");
	}

}
