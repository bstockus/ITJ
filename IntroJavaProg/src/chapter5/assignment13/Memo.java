package chapter5.assignment13;

public class Memo {
	
	public static String NOM_IN;
	public static Integer MONTH_IN;
	public static Double PERCENT_IN;
	public static String FIRST, LAST, MONTH_NAME, NEXT_MONTH_NAME;
	public static String GRADE, PLURAL_LAST, PLURAL_FIRST;
	public static Double DISCOUNT;
	public static Integer NEXT_MONTH;
	
	public static String getGrade(Double percent) {
		if (percent == 0) {
			return "disconnected";
		} else if ((percent > 0) && (percent < 66)) {
			return "C";
		} else if ((percent >= 66) && (percent < 81)) {
			return "B";
		} else {
			return "A";
		}
	}
	
	public static Double getDiscount(Double percent) {
		if (percent == 0) {
			return 0.0;
		} else if ((percent > 0) && (percent < 66)) {
			return 35.0;
		} else if ((percent >= 66) && (percent < 81)) {
			return 65.0;
		} else {
			return 85.0;
		}
	}
	
	public static void getInput() {
		Input input = new Input();
		
		// Ask user for name
		String name = input.getString("Please enter your name (format first<space>last)", "NAME", 3);
		if (name.indexOf(" ") == -1) {
			input.writeMessage("You have entered an incorrect name format. Program will now abort.", "INPUT ERROR", 0);
			System.exit(0);
		}
		
		// Ask user for month
		Integer month = input.getInteger("Please enter today's numeric month (format 1-12)", "MONTH", 3);
		if ((month < 1) || (month > 12)) {
			input.writeMessage("You have entered an incorrect month. Program will now abort.", "MONTH", 0);
			System.exit(0);
		}
		
		// Ask user for percent
		Double percent = input.getDouble("Please enter your current * Rating (format Decimal)", "* RATING", 3);
		
		Memo.NOM_IN = name;
		Memo.MONTH_IN = month;
		Memo.PERCENT_IN = percent;
	}
	
	public static void processMemo() {
		Strings strings = new Strings();
		Dates dates = new Dates();
		
		// Find first and last name and the plurals of each
		String firstName = strings.getFirstName(Memo.NOM_IN);
		String lastName = strings.getLastName(Memo.NOM_IN);
		String pluralFirstName = strings.getPluralName(firstName);
		String pluralLastName = strings.getPluralName(lastName);
		
		// Find the month name, next month and next month name
		String monthName = dates.getMonthName(Memo.MONTH_IN);
		Integer nextMonth = dates.getNextMonth(Memo.MONTH_IN);
		String nextMonthName = strings.getPluralName(dates.getMonthName(nextMonth));
		
		// Get grade and discount
		String grade = Memo.getGrade(Memo.PERCENT_IN);
		Double discount = Memo.getDiscount(PERCENT_IN);
		
		Memo.FIRST = firstName;
		Memo.LAST = lastName;
		Memo.PLURAL_FIRST = pluralFirstName;
		Memo.PLURAL_LAST = pluralLastName;
		Memo.MONTH_NAME = monthName;
		Memo.NEXT_MONTH = nextMonth;
		Memo.NEXT_MONTH_NAME = nextMonthName;
		Memo.GRADE = grade;
		Memo.DISCOUNT = discount;
	}
	
	public static void printMemo() {
		System.out.printf("To:  %s\n\nDear %s,\n\nBelow is the %s %s Energy Audit:\n",
				Memo.NOM_IN, Memo.FIRST, Memo.PLURAL_LAST, Memo.MONTH_NAME);
		System.out.printf("%1.1f%s = Grade %s\n", Memo.PERCENT_IN, "%", Memo.GRADE);
		System.out.printf("%s Grade %s will give you a %1.1f%s discount on %s bill.\n\nThank you for your business.",
				Memo.PLURAL_FIRST, Memo.GRADE, Memo.DISCOUNT, "%", Memo.NEXT_MONTH_NAME);
	}
	
	public static void main(String[] args) {
		Memo.getInput();
		Memo.processMemo();
		Memo.printMemo();
	}
	
}
