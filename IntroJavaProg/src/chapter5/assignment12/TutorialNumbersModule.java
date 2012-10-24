package chapter5.assignment12;

import java.util.ArrayList;
import java.util.List;

import convenience.dialogs.Dialogs;

import chapter5.assignment12.helpers.NumbersHelper;

public class TutorialNumbersModule extends TutorialModule {
	
	public TutorialNumbersModule(TutorialModuleDelegate moduleDelegate) {
		// Call Superclass Constructor
		super(moduleDelegate);
	}
	
	private void doEvenOdd() {
		Integer number = Dialogs.displayIntegerInputDialog("NUMBERS PROGRAM - EVEN OR ODD", "Please enter a number:", 0);
		if (NumbersHelper.isEven(number)) {
			Dialogs.displayResultsDialog("NUMBERS PROGRAM - EVEN OR ODD", "The number " + number.toString() + " is even.");
		} else {
			Dialogs.displayResultsDialog("NUMBERS PROGRAM - EVEN OR ODD", "The number " + number.toString() + " is odd.");
		}
	}
	
	private void doAddition() {
		List<String> inputLabels = new ArrayList<String>();
		inputLabels.add("First Number:");
		inputLabels.add("Second Number:");
		List<Integer> defaultValues = new ArrayList<Integer>();
		defaultValues.add(0);
		defaultValues.add(0);
		List<Integer> results = Dialogs.displayMultiIntegerInputDialog("NUMBERS PROGRAM - ADDITION", "Please enter two numbers:", inputLabels, defaultValues);
		Integer firstNumber = results.get(0);
		Integer secondNumber = results.get(1);
		Integer answer = firstNumber + secondNumber;
		Dialogs.displayResultsDialog("NUMBERS PROGRAM - ADDITION", firstNumber.toString() + " + " + secondNumber.toString() + " = " + answer.toString());
	}
	
	private void doMultiplication() {
		List<String> inputLabels = new ArrayList<String>();
		inputLabels.add("First Number:");
		inputLabels.add("Second Number:");
		List<Integer> defaultValues = new ArrayList<Integer>();
		defaultValues.add(0);
		defaultValues.add(0);
		List<Integer> results = Dialogs.displayMultiIntegerInputDialog("NUMBERS PROGRAM - MULTIPLICATION", "Please enter two numbers:", inputLabels, defaultValues);
		Integer firstNumber = results.get(0);
		Integer secondNumber = results.get(1);
		Integer answer = firstNumber * secondNumber;
		Dialogs.displayResultsDialog("NUMBERS PROGRAM - MULTIPLICATION", firstNumber.toString() + " * " + secondNumber.toString() + " = " + answer.toString());
	}
	
	@Override
	protected void runModule() {
		// Display the Menu
		List<String> menuEntries = new ArrayList<String>();
		menuEntries.add("Is number even or odd?");
		menuEntries.add("Add two numbers.");
		menuEntries.add("Multiply two numbers");
		Integer results = Dialogs.displayMenuDialog("NUMBERS PROGRAM", "Please enter a choice from the menu below:", menuEntries);
		switch (results) {
		case 0:
			this.doEvenOdd();
			break;
		case 1:
			this.doAddition();
			break;
		case 2:
			this.doMultiplication();
			break;
		}
	}
	
}
