package chapter9.assignment21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import convenience.Console;

public class EmployeeSalesRep_Old {
	
	private static final String[] FIELD_NAMES = {"Emp #", "Last Name", "First Name", "MI", "Sales Rep", "Commission"};
	private static final Integer SORT_BY_FIELD_INDEX = 4;
	private static final Integer SUM_BY_FIELD_INDEX = 5;
	
	public static void main(String[] args) {
		File file = new File("EmployeeSalesRep.txt");
		
		try {
			Scanner scanner = new Scanner(file);
			
			// Get the length of the file
			Integer lineCounter = 0;
			while (scanner.hasNextLine()) {
				lineCounter ++;
				scanner.nextLine();
			}
			
			//System.out.println(lineCounter);
			
			scanner.close();
			scanner = new Scanner(file);
			
			String[][] fields = new String[lineCounter][EmployeeSalesRep_Old.FIELD_NAMES.length];
			
			for (Integer recordIndex = 0; recordIndex < lineCounter; recordIndex ++) {
				for (Integer fieldIndex = 0; fieldIndex < EmployeeSalesRep_Old.FIELD_NAMES.length; fieldIndex ++) {
					fields[recordIndex][fieldIndex] = scanner.next();
				}
			}
			
			scanner.close();
			
			//Console.printArrayWithHeaders(EmployeeSalesRep.FIELD_NAMES, fields, 20);
			
			// Determine the number of different Sales Rep Codes
			ArrayList<String> salesRepCodes = new ArrayList<String>();
			for (Integer index = 0; index < fields.length; index ++) {
				String salesRepForRecord = fields[index][EmployeeSalesRep_Old.SORT_BY_FIELD_INDEX];
				Boolean foundMatch = false;
				for (String salesRepCode: salesRepCodes) {
					if (salesRepCode.equals(salesRepForRecord)) {
						foundMatch = true;
						break;
					}
				}
				if (!foundMatch) {
					salesRepCodes.add(salesRepForRecord);
				}
			}
			
			//System.out.print(salesRepCodes.size());
			
			// Create And Populate Array for holding subtotals
			Double[] subtotals = new Double[salesRepCodes.size()];
			for (Integer index = 0; index < subtotals.length; index ++) {
				subtotals[index] = 0.0;
			}
			for (Integer index = 0; index < fields.length; index ++) {
				Integer salesRepCodeIndex = salesRepCodes.indexOf(fields[index][EmployeeSalesRep_Old.SORT_BY_FIELD_INDEX]);
				Double comission = Double.parseDouble(fields[index][EmployeeSalesRep_Old.SUM_BY_FIELD_INDEX]);
				subtotals[salesRepCodeIndex] += comission;
			}
			
			// Print each column
			for (Integer index = 0; index < salesRepCodes.size(); index ++) {
				String salesRepCode = salesRepCodes.get(index);
				// Print Header
				for (String header: EmployeeSalesRep_Old.FIELD_NAMES) {
					System.out.printf("%20s", header);
				}
				System.out.printf("\n");
				// Enumerate Data Columns
				for (Integer recordIndex = 0; recordIndex < fields.length; recordIndex ++) {
					if (salesRepCode.equals(fields[recordIndex][EmployeeSalesRep_Old.SORT_BY_FIELD_INDEX])) {
						for (Integer fieldIndex = 0; fieldIndex < EmployeeSalesRep_Old.FIELD_NAMES.length; fieldIndex ++) {
							System.out.printf("%20s", fields[recordIndex][fieldIndex]);
						}
						System.out.printf("\n");
					}
				}
				System.out.printf("Subtotal: %.2f\n\n", subtotals[index]);
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Could not find the file!");
		}
		
		
	}
	
}
