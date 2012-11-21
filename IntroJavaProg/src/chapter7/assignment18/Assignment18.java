package chapter7.assignment18;

import java.util.Arrays;

import convenience.dialogs.Dialogs;

public class Assignment18 {
	
	public static void main(String[] args) {
		while (true) {
			String[] menuOptions = {"Print Books", "Print Patrons", "Book Info"};
			Integer menuOption = Dialogs.displayMenuDialog("Book Program", "Choose an option", menuOptions);
			switch (menuOption) {
			case 0:
				BookMethods.printBooks();
				break;
			case 1:
				BookMethods.printPatrons();
				break;
			case 2:
				Assignment18.bookInfoAndPrint();
				break;
			default:
				System.exit(0);
				break;
			}
		}
	}
	
	public static void bookInfoAndPrint() {
		// Choose Book
		String[] bookTitles = BookMethods.getBookTitles();
		String[] bookHeaders = BookMethods.BOOKS_HEADER;
		bookHeaders = Arrays.copyOfRange(bookHeaders, 1, bookHeaders.length);
		Integer bookIndex = Dialogs.displayMenuDialog("CHOOSE BOOK", "Choose a book title", bookTitles, "Cancel");
		if (bookIndex == -1) {
			return;
		}
		String bookTitle = bookTitles[bookIndex];
		
		// Choose Column
		Integer headerIndex = Dialogs.displayMenuDialog("WHAT INFO", "What information would you like displayed about " + bookTitle + "?", bookHeaders, "Cancel");
		if (headerIndex == -1) {
			return;
		}
		String headerTitle = bookHeaders[headerIndex];
		String value = BookMethods.BOOKS[bookIndex][headerIndex + 1];
		System.out.println("The " + headerTitle + " of " + bookTitle + " is " + value);
	}
	
}
