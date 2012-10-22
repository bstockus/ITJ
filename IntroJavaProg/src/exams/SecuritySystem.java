// Bryan Stockus, Intro to Java, Section 1, Fall 2012
// Exam 2, 08 OCT 2012
package exams;

public class SecuritySystem {
	
	// CONSTANTS
	private static Integer RESIDENCE_TYPE_HOUSE = 1;
	private static Integer RESIDENCE_TYPE_APARTMENT = 2;
	private static Double COST_HOUSE_18_PLUS = 600.00;
	private static Double COST_HOUSE_10_TO_17 = 500.00;
	private static Double COST_HOUSE_10_MINUS = 300.00;
	private static Double COST_APARTMENT_10_PLUS = 200.00;
	private static Double COST_APARTMENT_10_MINUS = 100.00;
	
	public static void main(String[] args) {
		// Initialize Input class instance
		Input input = new Input();
		
		// Declare and Initialize Method Variables
		String firstName = "";
		Integer residenceType = 0;
		Integer hoursHome = 0;
		Double cost = 0.00;
		String residenceTypeString = "";
		String hoursHomeString = "";
		
		// Ask the user to enter their FIRST name
		firstName = input.getString("Please enter your FIRST name.", "ENTER FIRST NAME", 3);
		
		// Display welcome message using the name entered in the message text
		input.writeMessage("Thank you for giving us an opportunity to recommend a security system for your home "
				+ firstName + ".\nPlease answer the following questions.", "WELCOME", 1);
		
		// Ask the user to enter a number (1,2) corresponding to their type of residence
		residenceType = input.getInteger("What Kind of Security System Do You Need?"
				+ "\nEnter your type of residence:\n(1) house\n(2) apartment", "HOUSE OR APARTMENT?", 3);
		
		
		// If the entry is valid, according to the residence type chosen, ask the user to enter the number of hours
		// they spend at their house or their apartment
		if (residenceType == SecuritySystem.RESIDENCE_TYPE_HOUSE) {
			residenceTypeString = "House";
			
			hoursHome = input.getInteger("Now, enter the total hours you are at home."
					+ "\n(1) 18 or more\n(2) 10 through 17\n(3) Fewer than 10", "HOURS AT YOUR HOME", 3);
			
			switch (hoursHome) {
			case 1:
				hoursHomeString = "18 or more";
				cost = SecuritySystem.COST_HOUSE_18_PLUS;
				break;
			case 2:
				hoursHomeString = "10 through 17";
				cost = SecuritySystem.COST_HOUSE_10_TO_17;
				break;
			case 3:
				hoursHomeString = "Fewer than 10";
				cost = SecuritySystem.COST_HOUSE_10_MINUS;
				break;
			default:
				input.writeMessage("Incorrect Hours Entry. Must enter 1, 2 or 3.\n Program will now terminate.",
						"INCORRECT HOURS ENTRY", 0);
				System.exit(0);
			}
		} else if (residenceType == SecuritySystem.RESIDENCE_TYPE_APARTMENT) {
			residenceTypeString = "Apartment";
			
			hoursHome = input.getInteger("Now, enter the total hours you are at your apartment."
					+ "\n(1) 10 or more\n(2) Fewer than 10", "HOURS AT APARTMENT", 3);
			
			switch (hoursHome) {
			case 1:
				hoursHomeString = "10 or more";
				cost = SecuritySystem.COST_APARTMENT_10_PLUS;
				break;
			case 2:
				hoursHomeString = "Fewer than 10";
				cost = SecuritySystem.COST_APARTMENT_10_MINUS;
				break;
			default:
				input.writeMessage("Incorrect Hours Entry. Must enter 1 or 2.\n Program will now terminate.",
						"INCORRECT HOURS ENTRY", 0);
				System.exit(0);
			}
		} else {
			// If invalid entry, message user and terminate program
			input.writeMessage("Incorrect Residence Type Entry. Must enter 1 or 2.\nProgram will now terminate.",
					"INCORRECT RESIDENCE TYPE", 0);
			System.exit(0);
		}
		
		// Print the output to the console
		System.out.println("SECURITY SYSTEM QUOTE FOR " + firstName);
		System.out.printf("%-20s%-20s%-20s\n","Residence Type", "Hours Home", "Cost");
		System.out.printf("%-20s%-20s%-20s\n","--------------","--------------","--------------");
		System.out.printf("%-20s%-20s%.2f\n",residenceTypeString,hoursHomeString,cost);
		
	}
	
}
