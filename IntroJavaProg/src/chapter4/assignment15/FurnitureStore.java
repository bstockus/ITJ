package chapter4.assignment15;

import java.util.Arrays;

import convenience.dialogs.Dialogs;

public class FurnitureStore {
	
	private static String[] tableTypeStrings = {"Pine", "Oak", "Mahogany"};
	private static String[] tableSizeStrings = {"Small", "Medium", "Large"};
	private static Double[][] tablePrices = {{80.00, 100.00, 150.00}, {230.00, 250.00, 300.00}, {280.00, 300.00, 350.00}};
	
	
	private static Integer getTableType() {
		Integer tableType = Dialogs.displayMenuDialog("TABLE COST MENU",
				"Welcome to the Java Furniture Store <br/> Please select the type of your table:",
				Arrays.asList(FurnitureStore.tableTypeStrings));
		if (tableType == -1) {
			FurnitureStore.exit();
		}
		return tableType;
	}
	
	private static Integer getTableSize() {
		Integer tableSize = Dialogs.displayMenuDialog("TABLE COST MENU",
				"Welcome to the Java Furniture Store <br/> Please select the type of your table:",
				Arrays.asList(FurnitureStore.tableSizeStrings));
		if (tableSize == -1) {
			FurnitureStore.exit();
		}
		return tableSize;
	}
	
	private static void displayCost(Integer tableType, Integer tableSize) {
		String tableCostString = String.format("$%.2f", FurnitureStore.tablePrices[tableType][tableSize]);
		String tableTypeString = FurnitureStore.tableTypeStrings[tableType];
		String tableSizeString = FurnitureStore.tableSizeStrings[tableSize];
		
		Dialogs.displayResultsDialog("TABLE IS PRICED", "The cost of your " + tableSizeString + " " + tableTypeString + " table is " + tableCostString + ".");
	}
	
	private static void exit() {
		Dialogs.displayInfoDialog("GOODBYE", "Thanks for shopping!");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		while (true) {
			Integer tableType = FurnitureStore.getTableType();
			Integer tableSize = FurnitureStore.getTableSize();
			
			FurnitureStore.displayCost(tableType, tableSize);
			
			// Ask If User Wants to Run Again
			if(!(Dialogs.displayConfirmDialog("AGAIN?", "Would you like to price another table?"))) {
				FurnitureStore.exit();
			}
			
		}
	}
	
}
