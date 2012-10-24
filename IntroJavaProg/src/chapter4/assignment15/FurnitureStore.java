package chapter4.assignment15;

import java.util.ArrayList;
import java.util.List;

import convenience.dialogs.Dialogs;

public class FurnitureStore {
	
	public static void main(String[] args) {
		while (true) {
			List<String> typeMenuEntries = new ArrayList<String>();
			typeMenuEntries.add("PINE");
			typeMenuEntries.add("OAK");
			typeMenuEntries.add("MAHOGANY");
			Integer tableType = Dialogs.displayMenuDialog("TABLE COST MENU", "Welcome to the Java Furniture Store <br/> Please select the type of your table:", 
					typeMenuEntries);
			if (tableType == -1) {
				Dialogs.displayInfoDialog("GOODBYE", "Thanks for shopping!");
				System.exit(0);
			}
			
			List<String> sizeMenuEntries = new ArrayList<String>();
			sizeMenuEntries.add("SMALL");
			sizeMenuEntries.add("MEDIUM");
			sizeMenuEntries.add("LARGE");
			Integer tableSize = Dialogs.displayMenuDialog("TABLE COST MENU", "Welcome to the Java Furniture Store <br/> Please select the type of your table:", 
					sizeMenuEntries);
			if (tableSize == -1) {
				Dialogs.displayInfoDialog("GOODBYE", "Thanks for shopping!");
				System.exit(0);
			}
			
			String[] tableTypeTable = {"Pine", "Oak", "Mahogany"};
			String[] tableSizeTable = {"Small", "Medium", "Large"};
			Double[][] tableCostTable = {{80.00, 100.00, 150.00}, {230.00, 250.00, 300.00}, {280.00, 300.00, 350.00}};
			Double tableCost = tableCostTable[tableType][tableSize];
			
			Dialogs.displayResultsDialog("TABLE IS PRICED", "The cost of your " + tableSizeTable[tableSize] + " " + tableTypeTable[tableType] + " table is $" + String.format("%.2f", tableCost) + ".");
			
			if(!(Dialogs.displayConfirmDialog("AGAIN?", "Would you like to price another table?"))) {
				Dialogs.displayInfoDialog("GOODBYE", "Thanks for shopping!");
				System.exit(0);
			}
			
		}
	}
	
}
