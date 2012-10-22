package assignment7;

import javax.swing.JOptionPane;

public class Replace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Step 2. Use JOptionPane to prompt user to type in a sentence with words using the letters of 'a' or 'A'
		String sentence = JOptionPane.showInputDialog(null, "Enter a sentence containing the letters 'a' or 'A'",
				"Replace", JOptionPane.QUESTION_MESSAGE);
		
		//Step 3. Use replace method to replace all instances of the letters 'a' or 'A' to the letter z
		String newSentence = sentence.replace('a', 'z');
		newSentence = newSentence.replace('A', 'z');
		
		//Step 4. Display output to the user
		JOptionPane.showMessageDialog(null, "\"" + sentence + "\" looks like this (" + newSentence + ") when replacing the 'a' and 'A' with 'z'",
				"Replace", JOptionPane.QUESTION_MESSAGE);
		System.out.println("\"" + sentence + "\" looks like this (" + newSentence + ") when replacing the 'a' and 'A' with 'z'");
	}

}
