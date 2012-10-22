package chapter3;

import convenience.InputModified;

public class Calendar {
	
	public static void main(String[] args) {
		
		InputModified input = new InputModified();
		
		String monthName = "";
		Integer monthDays = 0;
		Boolean leapYear = false;
		
		Integer monthNumber = input.getInteger("MONTH CONVERTER\nPlease enter a number corresponding to the month:\n"
				+ "(1) January\n(2) Feburary\n(3) March\n(4) April\n(5) May\n(6) June\n(7) July\n(8) August\n(9) September\n"
				+ "(10) October\n(11) November\n(12) December", "Enter Month NUMBER", 3);
		
		switch (monthNumber) {
		case 1:
			monthName = "January";
			monthDays = 31;
			break;
		case 2:
			monthName = "Feburary";
			Integer leapYearNumber = input.getInteger("Is this a Leap Year?\n(1) Yes\n(2) No", "Leap Year?", 3);
			switch (leapYearNumber) {
			case 1:
				leapYear = true;
				monthDays = 29;
				break;
			case 2:
				monthDays = 28;
				break;
			default:
				input.writeMessage("You must enter either a 1 or a 2", "ERROR", 0);
				System.exit(0);
			}
			break;
		case 3:
			monthName = "March";
			monthDays = 31;
			break;
		case 4:
			monthName = "April";
			monthDays = 30;
			break;
		case 5:
			monthName = "May";
			monthDays = 31;
			break;
		case 6:
			monthName = "June";
			monthDays = 30;
			break;
		case 7:
			monthName = "July";
			monthDays = 31;
			break;
		case 8:
			monthName = "August";
			monthDays = 31;
			break;
		case 9:
			monthName = "September";
			monthDays = 30;
			break;
		case 10:
			monthName = "October";
			monthDays = 31;
			break;
		case 11:
			monthName = "November";
			monthDays = 30;
			break;
		case 12:
			monthName = "December";
			monthDays = 31;
			break;
		default:
			input.writeMessage("You must enter a number between 1 and 12", "ERROR", 0);
			System.exit(0);
		}
		
		String outputMessage = "There are ";
		outputMessage += monthDays.toString() + " days in the month of " + monthName;
		if (leapYear) {
			outputMessage += " during a Leap Year";
		}
		outputMessage += ".";
		System.out.println(outputMessage);
		
	}
	
}
