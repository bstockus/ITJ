package chapter5.assignment12;

import java.util.ArrayList;
import java.util.List;

import chapter5.assignment12.dialogs.Dialogs;
import chapter5.assignment12.helpers.StringsHelper;

public class TutorialStringsModule extends TutorialModule {
	
	public TutorialStringsModule(TutorialModuleDelegate moduleDelegate) {
		// Call Superclass constructor
		super(moduleDelegate);
		
	}
	
	private void doGetLength() {
		String string = Dialogs.displayStringInputDialog("STRINGS PROGRAM - LENGTH", "Please enter a string:", false);
		Integer stringLength = StringsHelper.getLength(string);
		Dialogs.displayResultsDialog("STRINGS PROGRAM - LENGTH", "The string \'" + string + "\' is " + stringLength.toString() + " charcters in length.");
	}
	
	private void doGetFirstChar() {
		String string = Dialogs.displayStringInputDialog("STRINGS PROGRAM - FIRST CHAR", "Please enter a string:", false);
		Character firstChar = StringsHelper.getFirstChar(string);
		Dialogs.displayResultsDialog("STRINGS PROGRAM - FIRST CHAR", "The first character of the string \'" + string + "\' is \'" + firstChar.toString() + "\'.");
	}
	
	private void doChangeToUppercase() {
		String string = Dialogs.displayStringInputDialog("STRINGS PROGRAM - UPPERCASE", "Please enter a string:", false);
		String uppercaseString = StringsHelper.getUppercase(string);
		Dialogs.displayResultsDialog("STRINGS PROGRAM - UPPERCASE", "The uppercase string of \'" + string + "\' is \'" + uppercaseString + "\'.");
	}
	
	private void doCompareWords() {
		List<String> inputLabels = new ArrayList<String>();
		inputLabels.add("First String:");
		inputLabels.add("Second String:");
		List<String> results = Dialogs.displayMultiStringInputDialog("STRINGS PROGRAM - COMPARE", "Please enter two strings:", inputLabels, false);
		String firstString = results.get(0);
		String secondString = results.get(1);
		if (StringsHelper.compareStrings(firstString, secondString)) {
			Dialogs.displayResultsDialog("STRINGS PROGRAM - COMPARE", "The strings \'" + firstString + "\' and \'" + secondString + "\' are equal.");
		} else {
			Dialogs.displayResultsDialog("STRINGS PROGRAM - COMPARE", "The strings \'" + firstString + "\' and \'" + secondString + "\' are not equal.");
		}
	}
	
	@Override
	protected void runModule() {
		// Display the Menu
		List<String> menuEntries = new ArrayList<String>();
		menuEntries.add("Get length.");
		menuEntries.add("Get first character.");
		menuEntries.add("Change to all UPPER CASE.");
		menuEntries.add("Compare words.");
		Integer results = Dialogs.displayMenuDialog("STRINGS PROGRAM", "Please enter a choice from the menu below:", menuEntries);
		switch (results) {
		case 0:
			this.doGetLength();
			break;
		case 1:
			this.doGetFirstChar();
			break;
		case 2:
			this.doChangeToUppercase();
			break;
		case 3:
			this.doCompareWords();
			break;
		}
	}
	
}
