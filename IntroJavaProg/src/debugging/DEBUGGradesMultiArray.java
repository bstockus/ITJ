package debugging;

import javax.swing.JOptionPane;

public class DEBUGGradesMultiArray {
	public static void main(String[] args) {
		String inputMessage = "";

		// declares the variable grades to be of the array type String
		String[][] grades;

		// Ask how many students to enter
		String numStudentsIn = JOptionPane.showInputDialog(null,
				"How many students would you like to enter?",
				"HOW MANY STUDENTS?", JOptionPane.QUESTION_MESSAGE);
		int numStudents = Integer.parseInt(numStudentsIn);

		// creates a 2 X 4 array of type String
		grades = new String[numStudents][4];

		// load the array with values
		for (int rowIndex = 0; rowIndex < grades.length; ++rowIndex) {// outer
																		// loop

			for (int colIndex = 0; colIndex <= 3; ++colIndex) {// inner loop

				// determine which message to display in the message box
				if (colIndex == 0)
					inputMessage = "Enter name for student #" + (rowIndex + 1);
				else if (colIndex == 1)
					inputMessage = "Enter a RPG Score for student #"
							+ (rowIndex + 1);
				else if (colIndex == 2)
					inputMessage = "Enter a Java Score for student #"
							+ (rowIndex + 1);
				else if (colIndex == 3)
					inputMessage = "Enter a VB Score for student #"
							+ (rowIndex + 1);

				// use the message box to place a value into the array
				grades[rowIndex][colIndex] = JOptionPane.showInputDialog(null,
						inputMessage, "LOAD ARRAY",
						JOptionPane.QUESTION_MESSAGE);

			}// end inner loop

		}// end outer loop

		// print the heading line
		System.out.println();
		System.out.printf("%-20s", "Name");
		System.out.printf("%-20s", "RPG Score");
		System.out.printf("%-20s", "Java Score");
		System.out.printf("%-20s", "VB Score");
		System.out.printf("%-20s", "Total");
		System.out.println();

		// use a loop to print the detail lines
		double studentTotal = 0;
		double classTotal = 0;
		for (int rowIndex = 0; rowIndex < grades.length; ++rowIndex) {// outer
																		// loop

			for (int colIndex = 0; colIndex <= 3; ++colIndex) {// inner loop
																// make entry
																// numeric
				if (colIndex > 0) {
					double numGrade = Double
							.parseDouble(grades[rowIndex][colIndex]);
					System.out.printf("%-20.2f", numGrade);
					studentTotal = studentTotal + numGrade;
				} else
					System.out.printf("%-20s", grades[rowIndex][colIndex]);
			}// end inner loop

			System.out.printf("%-20.2f", studentTotal);
			System.out.println();
			classTotal = classTotal + studentTotal;
			studentTotal = 0;
		}// end outer loop

		System.out.println();
		System.out.printf("%20s", "Class Total = ");
		System.out.printf("%10.2f", classTotal);
		System.out.println();
		System.out.printf("%20s", "Class Average = ");
		double classAverage = classTotal / numStudents;
		System.out.printf("%10.2f", classAverage);
	}
}
