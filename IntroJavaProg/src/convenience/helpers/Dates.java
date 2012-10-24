package convenience.helpers;

public class Dates {
	
	public String getMonthName(Integer month) {
		switch (month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			System.exit(0);
			return null;
		}
	}
	
	public Integer getNextMonth(Integer month) {
		if (month == 12) {
			return 1;
		} else {
			return (month + 1);
		}
	}
	
	public Integer getPreviousMonth(Integer month) {
		if (month == 1) {
			return 12;
		} else {
			return (month - 1);
		}
	}
	
}
