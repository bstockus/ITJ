package debugging;

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
				repairType = input.getInteger("Services needed for " + nom
						+ ":\n(1) Oil Change\n(2) Balance Tires\n(3)"
						+ " Check Fluids\n(4) EXIT/No service needed",
						"REPAIR SERVICE NEEDED", 3);

				if (repairType == 4) {
					if (totalBill > 0) {
						input.writeMessage("Exiting Repair Services menu.",
								"EXIT", 1);

					} else {
						input.writeMessage(
								"No services chosen.  The program will now terminate.",
								"TERMINATE", 0);
						System.exit(0);
					}
				}

				if (repairType < 1 && repairType > 4) {
					input.writeMessage(
							"Invalid Entry:  You must enter 1,2,3 or 4.  Please try again!",
							"TRY AGAIN", 1);
					x = 0;
				} else {
					if (x == 0)
						printBillHeader();
					repairCost = getRepairCost(repairType);
					repairText = getRepairText(repairType);
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
		System.out.printf("%-20s", "Service");
		System.out.printf("%-20s", "Fee");
		System.out.println();
		System.out.println("-------------------------------------------------");
	}

	public static void printDetailLine() {
		System.out.printf("%-20s", repairText);
		System.out.printf("$%-20.2f", repairCost);
		System.out.println();
	}

	public static void printBillFooter() {
		System.out.println("-------------------------------------------------");
		System.out.printf("%-20s", "Service(s):");
		System.out.printf("$%-20.2s", totalBill);
		System.out.println();

		System.out.printf("%-20s", "Tax (5.5%):");
		System.out.printf("$%-20.2f", tax);
		System.out.println();

		System.out.printf("%-20s", "Total Bill:");
		System.out.printf("$%-20.2s", finalCost);
		System.out.println();
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
