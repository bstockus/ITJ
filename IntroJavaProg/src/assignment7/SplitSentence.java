package assignment7;

import javax.swing.JOptionPane;

public class SplitSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Step 1. Declare 6 Variables
		String sentence;
		String sentencePart;
		String firstWord;
		String secondWord;
		Boolean firstHello;
		Boolean secondBoy;
		
		//Step 2. Enter a sentence of at least four words
		sentence = JOptionPane.showInputDialog(null, "Enter a sentence of at least four words",
				"SplitSentence",JOptionPane.QUESTION_MESSAGE);
		//System.out.println("Sentence = '" + sentence + "'");
		
		//Step 3. Store the first word in firstWord
		int firstSpaceIndex = sentence.indexOf(" ");
		firstWord = sentence.substring(0, firstSpaceIndex);
		
		//Step 4. Return the remainder of the sentence to the sentencePart variable
		sentencePart = sentence.substring(firstSpaceIndex + 1);
		//System.out.println("Sentence Part = '" + sentencePart + "'");
		
		//Step 5. Return the second word in secondWord
		int secondSpaceIndex = sentencePart.indexOf(" ");
		secondWord = sentencePart.substring(0, secondSpaceIndex);
		
		//Step 6. Display first word
		//JOptionPane.showMessageDialog(null, "First Word = '" + firstWord + "'", "SplitSentence",JOptionPane.PLAIN_MESSAGE);
		System.out.println("First Word = '" + firstWord + "'");
		
		//Step 7. Display second word
		//JOptionPane.showMessageDialog(null, "Second Word = '" + secondWord + "'", "SplitSentence",JOptionPane.PLAIN_MESSAGE);
		System.out.println("Second Word = '" + secondWord + "'");
		
		//Step 8. Determine if the first word is hello
		//Step 9. Store in firstHello
		firstHello = firstWord.equals("hello");
		
		//Step 10. Display firstHello
		//JOptionPane.showMessageDialog(null, "First Hello = '" + firstHello.toString() + "'", "SplitSentence",JOptionPane.PLAIN_MESSAGE);
		System.out.println("First Hello = '" + firstHello.toString() + "'");
		
		//Step 11. Determine if the second word is boy
		//Step 12. Store in secondBoy
		secondBoy = secondWord.equals("boy");
		
		//Step 13. Display secondBoy
		//JOptionPane.showMessageDialog(null, "Second Boy = '" + secondBoy.toString() + "'", "SplitSentence",JOptionPane.PLAIN_MESSAGE);
		System.out.println("Second Boy = '" + secondBoy.toString() + "'");
		
		JOptionPane.showMessageDialog(null, "The sentence entered:" + sentence
				+ "\n The 1st Word is " + firstWord
				+ "\n The 2nd Word is " + secondWord
				+ "\n Is 1st Word hello? " + firstHello.toString()
				+ "\n Is 2nd Word boy? " + secondBoy.toString(),
				"SplitSentence", JOptionPane.PLAIN_MESSAGE);
		
	}

}
