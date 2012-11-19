package chapter7.assignment17;

import convenience.dialogs.Dialogs;

public class FlowerCounter {
	
	private static String[] FLOWER_TYPES = {"Petunia", "Pansy", "Rose", "Violet", "Carnation"};
	private static Double[] FLOWER_PRICES = {0.50, 0.75, 1.50, 0.50, 0.80};
	
	public static void main(String[] args) {
		Integer flowerType = Dialogs.displayMenuDialog("FLOWER COUNTER", "What kind of flower would you like?", FlowerCounter.FLOWER_TYPES);
		if (flowerType == -1) {
			System.exit(0);
		}
		
		Integer flowerQuantity = 0;
		
		while (true) {
			flowerQuantity = Dialogs.displayIntegerInputDialog("FLOWER COUNTER", "How many " + FlowerCounter.FLOWER_TYPES[flowerType] + "s would you like?", null);
			if (flowerQuantity <= 0) {
				Dialogs.displayErrorDialog("FLOWER COUNTER", "You must enter a quantity greater than 0!");
			} else {
				break;
			}
		}
		
		Double flowerPrice = FlowerCounter.FLOWER_PRICES[flowerType] * flowerQuantity;
		Dialogs.displayResultsDialog("FLOWER QUANTITY", flowerQuantity.toString() + " "
				+ FlowerCounter.FLOWER_TYPES[flowerType] + "s at $" + String.format("%.2f", FlowerCounter.FLOWER_PRICES[flowerType])
				+ " will cost $" + String.format("%.2f", flowerPrice) + ".");
		
	}
	
}
