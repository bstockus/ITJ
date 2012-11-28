package chapter7.memo;

import java.util.Calendar;

import convenience.dialogs.Dialogs;
import convenience.helpers.Input;

public class ErrorRepairShop {
	// Repair Shop Class Variables
	public static String nom = "";
	public static String repairText = "";
	public static double totalBill = 0;
	public static int repairType = 0;
	public static double tax = 0;
	public static double finalCost = 0;
	public static double repairCost;

	public static void main(String[] args) {
		Input input = new Input();
		for (int x = 0; x < 99; ++x) {
			if (x == 0) {
				nom = input.getString("Customer Name:", "JAVA Repair Shop", 3);
			}

			if (nom == ("")) {
				input.writeMessage("Please enter a valid name.", "TRY AGAIN", 1);
				nom = input.getString("Customer Name:", "JAVA Repair Shop", 3);
			} else {
				String[] menuEntries = {"Oil Change", "Balance Tires", "Check Fluids"};
				repairType = Dialogs.displayMenuDialog("REPAIR SERVICE NEEDED", "Services needed for " + nom + ":", menuEntries);

				if (repairType == -1) {
					if (totalBill > 0) {
						input.writeMessage("Exiting Repair Services menu.",
								"EXIT", 1);
						break;
					} else {
						input.writeMessage(
								"No services chosen.  The program will now terminate.",
								"TERMINATE", 0);
						System.exit(0);
					}
				} else {
					if (x == 0)
						printBillHeader();
					repairCost = getRepairCost(repairType + 1);
					repairText = getRepairText(repairType + 1);
					printDetailLine();
					totalBill = totalBill + repairCost;
				}
			}
		}
		tax = totalBill * .055;
		finalCost = totalBill + tax;
		printBillFooter();
	}

	public static void printBillHeader() {
		System.out.println("***     JAVA Repair Shop Bill for " + nom
				+ "   ***");
		
		System.out.printf("Date: ");
		Calendar currentDate = Calendar.getInstance();
		System.out.printf("%02d", (currentDate.get(Calendar.MONTH) + 1));
		System.out.printf("/");
		System.out.printf("%02d", currentDate.get(Calendar.DAY_OF_MONTH));
		System.out.printf("/");
		System.out.printf("%4d", currentDate.get(Calendar.YEAR));
		System.out.println();
		
		System.out.printf("%-20s", "Service");
		System.out.printf("%-21s", "Fee");
		System.out.printf("%-20s", "Time");
		System.out.println();
		System.out.println("-------------------------------------------------");
	}

	public static void printDetailLine() {
		System.out.printf("%-20s", repairText);
		System.out.printf("$%-20.2f", repairCost);
		
		Calendar currentTime = Calendar.getInstance();
		System.out.printf("%02d", currentTime.get(Calendar.HOUR));
		System.out.printf(":");
		System.out.printf("%02d", currentTime.get(Calendar.MINUTE));
		System.out.printf(":");
		System.out.printf("%02d", currentTime.get(Calendar.SECOND));
		if (currentTime.get(Calendar.PM) == 1) {
			System.out.printf("AM");
		} else {
			System.out.printf("PM");
		}
		System.out.println();
	}

	public static void printBillFooter() {
		System.out.println("-------------------------------------------------");
		System.out.printf("%-20s", "Service(s):");
		System.out.printf("$%-20.2f", totalBill);
		System.out.println();

		System.out.printf("%-20s", "Tax (5.5%):");
		System.out.printf("$%-20.2f", tax);
		System.out.println();

		System.out.printf("%-20s", "Total Bill:");
		System.out.printf("$%-20.2f", finalCost);
		System.out.println();
		
		if (totalBill >= 100.00) {
			System.out.println("-------------------------------------------------");
			System.out.println("You saved 10% on your purchase today.");
			
			Double savings = finalCost * 0.10;
			Double discountedTotal = finalCost - savings;
			
			System.out.printf("%-45s", "Previous total amount was:");
			System.out.printf("$%-20.2f", finalCost);
			System.out.println();
			
			System.out.printf("%-45s", "Total with discount applied:");
			System.out.printf("$%-20.2f", discountedTotal);
			System.out.println();
			
			System.out.printf("%-45s", "You saved:");
			System.out.printf("$%-20.2f", savings);
			System.out.println();
		}
		
		System.out.println();
		System.out.println("***     Thank you for your patronage.     ***");
	}

	public static double getRepairCost(int type) {
		if (type == 1) {
			repairCost = 23.50;
		} else if (type == 2) {
			repairCost = 85.75;
		} else if (type == 3) {
			repairCost = 10.25;
		}
		return repairCost;
	}

	public static String getRepairText(int type) {
		if (type == 1) {
			repairText = "oil change";
		} else if (type == 2) {
			repairText = "balance tires";
		} else if (type == 3) {
			repairText = "check fluids";
		}
		return repairText;
	}

}
