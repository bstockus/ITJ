package chapter3;

import convenience.InputModified;

public class Day {
	
	public static void main(String[] args) {
		Integer dayOfTheWeek = 0;
		String dayOfTheWeekString = "";
		InputModified input = new InputModified();
		
		dayOfTheWeek = input.getInteger("Enter a day of the week (1-7)", "DAY", 3);
		
		switch (dayOfTheWeek) {
		case 1:
			dayOfTheWeekString = "Sunday";
			break;
		case 2:
			dayOfTheWeekString = "Monday";
			break;
		case 3:
			dayOfTheWeekString = "Tuesday";
			break;
		case 4:
			dayOfTheWeekString = "Wednesday";
			break;
		case 5:
			dayOfTheWeekString = "Thursday";
			break;
		case 6:
			dayOfTheWeekString = "Friday";
			break;
		case 7:
			dayOfTheWeekString = "Saturday";
			break;
		default:
			input.writeMessage("Please enter a number between 1 and 7!", "DAY", 0);
			System.exit(0);
		}
		
		input.writeMessage("Day of the Week for " + dayOfTheWeek.toString() + " is " + dayOfTheWeekString + ".", "DAY", 1);
		
	}
	
}
