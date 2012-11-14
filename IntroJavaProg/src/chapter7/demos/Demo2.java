package chapter7.demos;

import convenience.helpers.Input;

/*
 * Single dimension array named cost
 * user enters the length of the array
 * enter values in loop
 * print values in loop
 */

public class Demo2 {


	public static void main (String [] args) {

		// THIS TIME, ask the user for the size of the array
		Input input= new Input();
		int size = input.getInteger("How many costs do you want to enter?", "HOW MANY?", 3);


		// use the variable size to declare the array
		double [] cost = new double [size];
		// declare a one dimensional array named cost
		// the array values are data type double

		//  Load array
		//  Note: the loop will start at zero and iterate while the counter
		//  is LESS THAN cost.length
		double sum = 0;
		for (int index = 0 ; index < cost.length ; ++ index) {
			cost[index] = input.getDouble("Enter cost # "+ (index+1), "Enter Cost", 3);
			sum = sum + cost [index];
		}


		double average = sum / cost.length;
		System.out.println ("The average cost is " + average);

		// using a loop, print the values in the array
		for (int index = 0 ; index < cost.length ; ++ index) {
			System.out.println ("Cost # "+ (index+1) + " is " + cost[index] );
		}

		System.out.println ("Program Done.");


	}

}
