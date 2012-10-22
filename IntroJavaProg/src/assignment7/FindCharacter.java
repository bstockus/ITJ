package assignment7;

import javax.swing.JOptionPane;

public class FindCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Step 1. JOptionPane to ask user to input a word
		String word = JOptionPane.showInputDialog(null, "Enter a word",
				"FindCharacter",JOptionPane.QUESTION_MESSAGE);
		
		//Step 2. n/a
		
		//Step 3. JOptionPane to ask user to type in an index
		String indexString = JOptionPane.showInputDialog(null, "Enter an index",
				"FindCharacter",JOptionPane.QUESTION_MESSAGE);
		
		//Step 4. Convert string to an integer
		Integer index = Integer.parseInt(indexString);
		
		//Step 5. n/a
		//Step 6. n/a
		
		//Step 7. Use index to get the character at that index
		char charAtIndex = word.charAt(index);
		
		//Step 8. Display results to the user
		JOptionPane.showMessageDialog(null, "The character at that index = '" + charAtIndex + "'", 
				"FindCharacter",JOptionPane.PLAIN_MESSAGE);
		System.out.println("The character at that index = '" + charAtIndex + "'");

	}

}
