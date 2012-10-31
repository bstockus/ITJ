package chapter4.assignment16;

import convenience.dialogs.Dialogs;
import convenience.helpers.Strings;

public class SentenceFacts {
	
	private static String getInput() {
		return Dialogs.displayStringInputDialog("ENTER SENTENCE", "Please enter a sentence and I will tell you \ninteresting facts about your sentence!", false);
	}
	
	private static void processAndPrint(String string) {
		Strings strings = new Strings();
		
		System.out.println("Here are your sentence facts:");
		System.out.println("Sentence entered: " + string);
		System.out.println("Sentence length: " + string.length());
		System.out.println("The first letter in the sentence is upper case (true or false): " + strings.isFirstLetterUpperCase(string));
		System.out.println("Is the last letter in the sentence ?.! (true or false): " + strings.isLastCharacterASymbol(string));
		System.out.println("How many /'s/' characters are in the sentence? " + strings.getLetterCount('s', string));
		System.out.println("How many /'S/' characters are in the sentence? " + strings.getLetterCount('S', string));
		System.out.println("How many /'a/' characters are in the sentence? " + strings.getLetterCount('a', string));
		System.out.println("How many /'A/' characters are in the sentence? " + strings.getLetterCount('A', string));
		System.out.println("How many commas are in the sentence? " + strings.getLetterCount(',', string));
	}
	
	public static void main(String[] args) {
		for (;;) {
			SentenceFacts.processAndPrint(SentenceFacts.getInput());
			if (!(Dialogs.displayConfirmDialog("AGAIN?", "Would you like to enter another sentence?"))) {
				return;
			}
		}
	}
	
}
