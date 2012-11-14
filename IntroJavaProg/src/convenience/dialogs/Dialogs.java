/*
 *  (c) Copyright 2012, Bryan Stockus
 *  	Bryan Stockus <bstockus@gmail.com>
 *  
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 3 as
 *  published by the Free Software Foundation.
 */

package convenience.dialogs;

import javax.swing.JOptionPane;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import javax.swing.SwingUtilities;

public class Dialogs {
	
	// Constants
	private static Boolean USE_LEGACY_MENU_DIALOGS = false;
	private static Boolean EXIT_ON_INPUT_ERROR = false;
	
	public static void displayErrorDialog(String title, String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void displayWarningDialog(String title, String warningMessage) {
		JOptionPane.showMessageDialog(null, warningMessage, title, JOptionPane.WARNING_MESSAGE);
	}
	
	public static Boolean displayConfirmDialog(String title, String confirmMessage) {
		Integer results = JOptionPane.showConfirmDialog(null, confirmMessage, title, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (results == null) {
			System.exit(0);
		}
		if (results == JOptionPane.OK_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void displayInfoDialog(String title, String informationMessage) {
		JOptionPane.showMessageDialog(null, informationMessage, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void displayResultsDialog(String title, String resultsMessage) {
		JOptionPane.showMessageDialog(null, resultsMessage, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static Integer displayMenuDialog(String title, String menuHeader, List<String> menuEntries) {
		if (Dialogs.USE_LEGACY_MENU_DIALOGS) {
			for (;;) {
				String inputMessage = "<html>" + menuHeader;
				Integer entryCount = 1;
				for (String menuEntry: menuEntries) {
					inputMessage += "<br/>(" + entryCount.toString() + ") " + menuEntry;
					entryCount++;
				}
				Integer lastMenuEntryIndex = entryCount - 1;
				inputMessage += "<br/>(" + entryCount.toString() + ") EXIT</html>";
				Integer exitMenuEntry = entryCount;
				Integer results = Dialogs.displayIntegerInputDialog(title, inputMessage, 0);
				
				if ((results > 0) && (results <= lastMenuEntryIndex)) {
					return (results - 1);
				} else if (results == exitMenuEntry) {
					return -1;
				} else {
					Dialogs.displayErrorDialog("INPUT ERROR", "You must enter a valid menu choice!");
				}
			}
		} else {
			MenuDialog menuDialog = new MenuDialog(title, "<html>" + menuHeader + "</html>", menuEntries);
			try {
				SwingUtilities.invokeAndWait(menuDialog);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			while (menuDialog.isRunning()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return menuDialog.getResults();
		}
	}
	
	public static Integer displayMenuDialog(String title, String menuHeader, String[] menuEntries) {
		return Dialogs.displayMenuDialog(title, menuHeader, Arrays.asList(menuEntries));
	}
	
	public static String displayStringInputDialog(String title, String inputMessage, Boolean emptyInputAllowed) {
		for (;;) {
			String results = JOptionPane.showInputDialog(null, inputMessage, title, JOptionPane.QUESTION_MESSAGE);
			if (results == null) {
				System.exit(0);
			}
			if (emptyInputAllowed) {
				return results;
			} else {
				if (results.length() > 0) {
					return results;
				} else {
					Dialogs.displayErrorDialog("INPUT ERROR", "Input field can not be empty!");
					if (Dialogs.EXIT_ON_INPUT_ERROR) {
						System.exit(0);
					}
				}
			}
		}
	}
	
	public static List<String> displayMultiStringInputDialog(String title, String inputMessage, List<String> inputLabels,
			Boolean emptyInputAllowed) {
		MultiStringInputDialog multiStringInputDialog = new MultiStringInputDialog(title, inputMessage, inputLabels,
				emptyInputAllowed);
		try {
			SwingUtilities.invokeAndWait(multiStringInputDialog);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		while (multiStringInputDialog.isRunning()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return multiStringInputDialog.getResults();
	}
	
	public static String[] displayMultiStringInputDialog(String title, String inputMessage, String[] inputLabels, Boolean emptyInputAllowed) {
		return (String[])((Dialogs.displayMultiStringInputDialog(title, inputMessage, Arrays.asList(inputLabels), emptyInputAllowed)).toArray());
	}
	
	public static Integer displayIntegerInputDialog(String title, String inputMessage, Integer defaultValue) {
		for (;;) {
			String results = JOptionPane.showInputDialog(null, inputMessage, title, JOptionPane.QUESTION_MESSAGE);
			if (results == null) {
				System.exit(0);
			}
			if (results.length() == 0) {
				return defaultValue;
			} else {
				if (results.matches("-?\\d+(.\\d+)?")) {
					return Integer.parseInt(results);
				} else {
					Dialogs.displayErrorDialog("INPUT ERROR", "You must enter a valid Integer!");
					if (Dialogs.EXIT_ON_INPUT_ERROR) {
						System.exit(0);
					}
				}
			}
		}
	}
	
	public static List<Integer> displayMultiIntegerInputDialog(String title, String inputMessage, List<String> inputLabels,
			List<Integer> defaultValues) {
		MultiIntegerInputDialog multiIntegerInputDialog = new MultiIntegerInputDialog(title, inputMessage, inputLabels,
				defaultValues);
		try {
			SwingUtilities.invokeAndWait(multiIntegerInputDialog);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		while (multiIntegerInputDialog.isRunning()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return multiIntegerInputDialog.getResults();
	}
	
	public static Integer[] displayMultiIntegerInputDialog(String title, String inputMessage, String[] inputLabels, Integer[] defaultValues) {
		return (Integer[])((Dialogs.displayMultiIntegerInputDialog(title, inputMessage, Arrays.asList(inputLabels), Arrays.asList(defaultValues)).toArray()));
	}
	
	public static Double displayDoubleInputDialog(String title, String inputMessage, Double defaultValue) {
		for (;;) {
			String results = JOptionPane.showInputDialog(null, inputMessage, title, JOptionPane.QUESTION_MESSAGE);
			if (results == null) {
				System.exit(0);
			}
			if (results.length() == 0) {
				return defaultValue;
			} else {
				if (results.matches("-?\\d+(.\\d+)?")) {
					return Double.parseDouble(results);
				} else {
					Dialogs.displayErrorDialog("INPUT ERROR", "You must enter a valid Integer!");
					if (Dialogs.EXIT_ON_INPUT_ERROR) {
						System.exit(0);
					}
				}
			}
		}
	}
	
	public static List<Double> displayMultiDoubleInputDialog(String title, String inputMessage, List<String> inputLabels,
			List<Double> defaultValues) {
		MultiDoubleInputDialog multiDoubleInputDialog = new MultiDoubleInputDialog(title, inputMessage, inputLabels,
				defaultValues);
		try {
			SwingUtilities.invokeAndWait(multiDoubleInputDialog);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		while (multiDoubleInputDialog.isRunning()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return multiDoubleInputDialog.getResults();
	}
	
}
