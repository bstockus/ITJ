package debugging;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter;
import javax.swing.JOptionPane;

public class DEBUGEmployees {
	public static void main(String[] args) {
		// declare and initialize variables
		int numberMales = 0, numberFemales = 0;
		String gender, outputStr;
		String formatStr = "The number of male and female employees is:\n\n"
				+ "Males:    %d\n\n" + "Females:  %d\n\n";

		Scanner input = null;

		File empFile = new File("employees.txt");

		try {
			input = new Scanner(empFile);

			while (input.hasNext()) {
				for (int i = 0; i < 4; i++)
					input.next();

				gender = input.next();

				if (gender.equals("m"))
					numberMales++;
				else
					numberFemales++;

			} // end loop

			outputStr = String.format(formatStr, numberMales, numberFemales);

			// output
			JOptionPane.showMessageDialog(null, outputStr);

		} // end try

		catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}

		finally {
			input.close();
		}

	} // end main

} // end class
