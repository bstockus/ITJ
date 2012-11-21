package chapter7.assignment18;

import convenience.Console;

public class BookMethods {
	
	public static String[][] BOOKS = { 
		{"Blue River", "John Jones", "10/12/2009", "11", "Elmer Fudd"}, 
		{"One Life", "Susan Smith", "04/02/2007", "22", "Buggs Bunny"},
		{"The Heart", "Howard Black", "07/14/2003", "", ""},
		{"Two Again", "Wanda Dith", "12/31/2009", "11", "Elmer Fudd"}
	};
	
	public static String[] BOOKS_HEADER = {"Title", "Author", "Pub Date", "Patron ID", "Patron Name"};
	
	public static String[][] PATRONS = {
		{"Elmer Fudd", "11", "123 State Street", "La Crosse, WI 54601"},
		{"Buggs Bunny", "22", "123 Carrot Way", "Onalaska, WI 54650"},
		{"Donald Duck", "33", "123 Quacker Court", "Holmen, WI 54636"}
	};
	
	public static String[] PATRONS_HEADER = {"Patron Name", "Patron Code", "Address", "City State Zip"};
	
	public static String[] getBookTitles() {
		String[] bookTitles = new String[BookMethods.BOOKS.length];
		for (Integer index = 0; index < BookMethods.BOOKS.length; index ++) {
			bookTitles[index] = BookMethods.BOOKS[index][0];
		}
		return bookTitles;
	}
	
	public static void printBooks() {
		Console.printArrayWithHeaders(BookMethods.BOOKS_HEADER, BookMethods.BOOKS, -20);
	}
	
	public static void printPatrons() {
		Console.printArrayWithHeaders(BookMethods.PATRONS_HEADER, BookMethods.PATRONS, -20);
	}
	
}
