package chapter3;

import javax.swing.JOptionPane;

import convenience.InputModified;

public class Carpet {
	
	public static void main(String[] args) {
		InputModified input = new InputModified();
		Double roomWidth = 0.0;
		Double roomLength = 0.0;
		Double carpetingUnitCost = 0.0;
		Boolean closetsCarpeted = false;
		Double roomArea = 0.0;
		Double closetArea = 0.0;
		Double totalRoomArea = 0.0;
		Double carpetCost = 0.0;
		
		roomWidth = input.getDouble("Enter the width of the room in feet", "CARPET", 3);
		roomLength = input.getDouble("Enter the length of the room in feet", "CARPET", 3);
		carpetingUnitCost = input.getDouble("Enter the unit cost of the carpeting in $ per square foot", "CARPET", 3);
		
		if ((JOptionPane.showConfirmDialog(null, "Carpet the closeting?", "CARPET", JOptionPane.YES_NO_OPTION))
				== JOptionPane.YES_OPTION) {
			closetsCarpeted = true;
		}
		
		roomArea = roomWidth * roomLength;
		if (closetsCarpeted) {
			closetArea = roomArea * 0.25;
		}
		totalRoomArea = roomArea + closetArea;
		carpetCost = totalRoomArea * carpetingUnitCost;
		
		System.out.println("--- CARPET CALCULATOR ---");
		System.out.printf("Room Width:     %8.2f\n", roomWidth);
		System.out.printf("Room Length:    %8.2f\n", roomLength);
		System.out.printf("Carpet Cost:    %8.2f\n", carpetingUnitCost);
		if (closetsCarpeted) {
			System.out.printf("Include Closets?     yes\n");
		} else {
			System.out.printf("Include Closets?      no\n");
		}
		System.out.println("--------------------------");
		System.out.printf("Room Area:      %8.2f\n", roomArea);
		if (closetsCarpeted) {
			System.out.printf("Closet Area:    %8.2f\n", roomArea);
		}
		System.out.printf("Total Room Area:%8.2f\n", totalRoomArea);
		System.out.println("--------------------------");
		System.out.printf("Total Carpet Cost:%6.2f\n", carpetCost);
		
	}
	
}
