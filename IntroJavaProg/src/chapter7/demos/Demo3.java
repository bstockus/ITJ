package chapter7.demos;

import convenience.helpers.Input;

/**
Single dimension array named dogs holds dog names
Single dimension array named tricks holds corresponding tricks
1) Ask for match
2) use loop to look for match
3) if match is found, use the index # in the trick table
4) control loop asks for another match or exit
 */

public class Demo3 {
	public static void main (String [] args) {
		Input input= new Input();
		String dogName = "";
		String trickName = "";
		boolean matchFound = false;
		boolean again = true;

		// declare a one dimensional array named dogs
		// the array values are data type String
		// there are a maximum of 3 dogs in this array 
		String[] dogs = {"Fido", "Rover", "Duke"};
		// declare a one dimensional array named tricks
		String[] tricks = {"sit", "stay","down"};

		while (again) {// start control loop
			// every time the loop iterates, make sure to set the match found flag to false
			matchFound = false;
			// Ask the user for a dog name
			dogName = input.getString("Please enter the dog name you want to match.", "ENTER DOG NAME", 3);

			// Use a loop to find a match
			for (int index = 0 ; index < dogs.length ; ++ index) {
				if (dogs[index].equalsIgnoreCase(dogName))
				{
					// we have found a match
					trickName = tricks[index];
					matchFound = true;
					break;
				}
			}

			if (!matchFound) {
				System.out.println("No match found for " + dogName + ".");
			} else {
				System.out.println(dogName + " can do the trick named " + trickName + ".");
			}

			// ask if program should be run again  	
			again = input.getBoolean("Enter another match?", "RUN AGAIN?", 3);   	 	
		}    // end control loop



	}	 // end main
}    // end class
