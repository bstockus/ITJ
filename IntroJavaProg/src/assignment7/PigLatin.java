package assignment7;

import javax.swing.JOptionPane;

public class PigLatin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Step 1. Create and set variables
		String name;
		String first;
		String rest;
		String special = "ay";
		String result;
		
		//Step 2. Ask for user's first name
		name = JOptionPane.showInputDialog(null, "Enter your first name",
				"PigLatin",JOptionPane.QUESTION_MESSAGE);
		
		//Step 3. Store first letter of name in first
		first = name.substring(0,1);
		
		//Step 4. Store all characters after the first in rest
		rest = name.substring(1);
		
		//Step 5. rest + first + special
		result = rest + first + special;
		
		//Step 6. Display the final result
		JOptionPane.showMessageDialog(null, "Your name in Pig Latin = '" + result + "'", "PigLatin",JOptionPane.PLAIN_MESSAGE);
		System.out.println("Your name in Pig Latin = '" + result + "'");
		
	}

}
