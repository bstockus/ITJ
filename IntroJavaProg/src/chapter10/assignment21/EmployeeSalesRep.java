package chapter10.assignment21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

import convenience.Console;

public class EmployeeSalesRep {
	
	private static final String DEFAULT_FILE_NAME = "EmployeeSalesRep.txt";
	private static final String[] FIELD_NAMES = {"Emp#", "Last Name", "First Name", "MI", "Rep", "Commission"};
	private static final String HEADER_SEPERATOR_CHARACTER = "-";
	private static final String FOOTER_SEPERATOR_CHARACTER = "=";
	private static final Integer SORT_BY_FIELD_INDEX = 4;
	private static final Integer SUM_BY_FIELD_INDEX = 5;
	
	public static void main(
			String[] args) {
		
		// TODO: Add code to include the sum by total field column widths in the calculations
		// for the column auto-sizing code.
		
		// Store the number of field for convenience
		Integer fieldCount = EmployeeSalesRep.FIELD_NAMES.length;
		
		// Create Array for storing column widths
		Integer[] columnWidths = new Integer[fieldCount];
		for (Integer columnIndex = 0; columnIndex < fieldCount; columnIndex ++) {
			columnWidths[columnIndex] = EmployeeSalesRep.FIELD_NAMES[columnIndex].length();
		}
		
		// Get the scanner for reading in the file, if no file name is contained in the first argument use the default
		String fileName = "";
		if (args.length < 1) {
			fileName = EmployeeSalesRep.DEFAULT_FILE_NAME;
		} else {
			fileName = args[0];
		}
		Scanner scanner = EmployeeSalesRep.getFileScanner(fileName);
		
		// Create collections for storing records and unique sort values
		ArrayList<String[]> fileRecordsList = new ArrayList<String[]>();
		HashSet<String> uniqueSortValues = new HashSet<String>();
		
		// Read in Records from file
		while (scanner.hasNext()) {
			
			// Create a new array for storing the value of the fields for this record
			String[] record = new String[fieldCount];
			
			// Read in field values for this record
			for (Integer fieldIndex = 0; fieldIndex < fieldCount; fieldIndex ++) {
				
				// Read in Field Value from the file
				String fieldValue = null;
				try {
					fieldValue = scanner.next();
				} catch (NoSuchElementException e) {
					// The file does not contain the correct number of entries
					// Print error and terminate
					Console.printError("Invalid format for the input file!");
					System.exit(0);
				}
				
				// Store field value in the array for the record
				record[fieldIndex] = fieldValue;
				
				// If the field is the Sort By Field add it to the unique sort field set
				if (fieldIndex == EmployeeSalesRep.SORT_BY_FIELD_INDEX) {
					uniqueSortValues.add(fieldValue);
				}
				
				// If column width of this field is greater than the current max column 
				// width, change the max column width to the width of this field
				if (fieldValue.length() > columnWidths[fieldIndex]) {
					columnWidths[fieldIndex] = fieldValue.length();
				}
				
			}
			
			// Store field values for this record to collection
			fileRecordsList.add(record);
		}
		
		// Convert the collection classes to arrays for convenient manipulation
		// TODO: Eliminate this step, as it is unnecessary, wastes CPU time and memory
		String[][] fileRecords = fileRecordsList.toArray(new String[0][0]);
		String[] recordGroups = uniqueSortValues.toArray(new String[0]);
		
		// Calculate Position for Sum By Field
		Integer sumByFieldPosition = -1;
		for (Integer columnIndex = 0; columnIndex < EmployeeSalesRep.SUM_BY_FIELD_INDEX; columnIndex ++) {
			sumByFieldPosition += columnWidths[columnIndex] + 1;
		}
		
		// Generate Group Header and Footer, to speed up execution time
		String headerValue = EmployeeSalesRep.getRecordGroupHeader(columnWidths);
		String footerValue = EmployeeSalesRep.getRecordGroupFooter(columnWidths, sumByFieldPosition);
		
		// Print Header
		EmployeeSalesRep.printHeader(fileName, fileRecords.length, recordGroups.length);
		
		// Print Record Groups and accumulate the total sum
		Double totalSum = 0.0;
		for (String sortByColumnValue: recordGroups) {
			totalSum += EmployeeSalesRep.printRecordsForRecordGroupAndGetSum(fileRecords, sortByColumnValue, columnWidths, sumByFieldPosition, headerValue, footerValue);
		}
		
		// Print Footer
		EmployeeSalesRep.printFooter(String.format("%.2f", totalSum), columnWidths, sumByFieldPosition);
	}
	
	private static Scanner getFileScanner(
			String fileName) {
		
		File file = new File(fileName);
		try {
			Scanner scanner = new Scanner(file);
			return scanner;
		} catch (FileNotFoundException e) {
			Console.printError("File: \'" + fileName + "\' Not Found!");
			System.exit(0);
		}
		return null;
	}
	
	private static Double printRecordsForRecordGroupAndGetSum(
			String[][] fileRecords, 
			String sortByColumnValue, 
			Integer[] columnWidths, 
			Integer sumByFieldPosition,
			String headerValue,
			String footerValue) {
		
		System.out.printf(headerValue);
		Double sum = 0.0;
		for (Integer recordIndex = 0; recordIndex < fileRecords.length; recordIndex ++) {
			if ((fileRecords[recordIndex][EmployeeSalesRep.SORT_BY_FIELD_INDEX]).equals(sortByColumnValue)) {
				EmployeeSalesRep.printRecordAtIndex(fileRecords, recordIndex, columnWidths);
				try {
					sum += Double.parseDouble(fileRecords[recordIndex][EmployeeSalesRep.SUM_BY_FIELD_INDEX]);
				} catch (NumberFormatException e) {
					// The sum by field value is not a proper double numeric value
					// Print error and terminate
					Console.printError("The " + EmployeeSalesRep.FIELD_NAMES[EmployeeSalesRep.SUM_BY_FIELD_INDEX] + 
							" field for the record at line " + (recordIndex + 1) + " does not containe a valid decimal number!");
					System.exit(0);
				}
			}
		}
		System.out.printf(footerValue);
		EmployeeSalesRep.printRecordGroupFooter(sortByColumnValue, String.format("%.2f", sum),columnWidths, sumByFieldPosition);
		return sum;
	}
	
	private static String getRecordGroupHeader(
			Integer[] columnWidths) {
		
		String results = "";
		
		// Print Field Names
		for (Integer index = 0; index < EmployeeSalesRep.FIELD_NAMES.length; index ++) {
			String printfCommandString = "%-" + columnWidths[index].toString() + "s ";
			results += String.format(printfCommandString, EmployeeSalesRep.FIELD_NAMES[index]);
		}
		results += "\n";
		
		// Print Header Dashes
		for (Integer index = 0; index < EmployeeSalesRep.FIELD_NAMES.length; index ++) {
			for (Integer dashIndex = 0; dashIndex < columnWidths[index]; dashIndex ++) {
				results += EmployeeSalesRep.HEADER_SEPERATOR_CHARACTER;
			}
			results += " ";
		}
		
		return results + "\n";
	}
	
	private static String getRecordGroupFooter(
			Integer[] columnWidths,
			Integer sumByFieldPosition) {
		
		String printfCommandString = "%" + sumByFieldPosition.toString() + "s ";
		String results = String.format(printfCommandString, " ");
		for (Integer dashIndex = 0; dashIndex < columnWidths[EmployeeSalesRep.SUM_BY_FIELD_INDEX]; dashIndex ++) {
			results += EmployeeSalesRep.FOOTER_SEPERATOR_CHARACTER;
		}
		return results + "\n";
	}
	
	private static void printRecordAtIndex(
			String[][] fileRecords, 
			Integer recordIndex, 
			Integer[] columnWidths) {
		
		for (Integer index = 0; index < EmployeeSalesRep.FIELD_NAMES.length; index ++) {
			String printfCommandString = "%-" + columnWidths[index].toString() + "s ";
			System.out.printf(printfCommandString, fileRecords[recordIndex][index]);
		}
		System.out.printf("\n");
	}
	
	private static void printRecordGroupFooter(
			String sortByColumnValue, 
			String sumByColumnValue, 
			Integer[] columnWidths, 
			Integer sumByFieldPosition) {
		
		String printfCommandString = "%" + sumByFieldPosition.toString() + "s %-" + columnWidths[EmployeeSalesRep.SUM_BY_FIELD_INDEX].toString() + "s\n\n";
		String leftString = "Total for " + EmployeeSalesRep.FIELD_NAMES[EmployeeSalesRep.SORT_BY_FIELD_INDEX] + " " + sortByColumnValue + ":";
		System.out.printf(printfCommandString, leftString, sumByColumnValue);
	}
	
	private static void printHeader(
			String fileName,
			Integer numberOfRecords,
			Integer numberOfRecordGroups) {
		
		System.out.printf("Results for the file \'%s\' which contains %d records and %d record groups\n", fileName, numberOfRecords, numberOfRecordGroups);
		String sortByFieldName = EmployeeSalesRep.FIELD_NAMES[EmployeeSalesRep.SORT_BY_FIELD_INDEX];
		String sumByFieldName = EmployeeSalesRep.FIELD_NAMES[EmployeeSalesRep.SUM_BY_FIELD_INDEX];
		System.out.printf("Sorted by the \'%s\' field and summed by the \'%s\' field.\n\n", sortByFieldName, sumByFieldName);
	}
	
	private static void printFooter(
			String totalSum, 
			Integer[] columnWidths, 
			Integer sumByFieldPosition) {
		
		String printfCommandString = "%" + sumByFieldPosition.toString() + "s %-" + columnWidths[EmployeeSalesRep.SUM_BY_FIELD_INDEX].toString() + "s\n";
		System.out.printf(printfCommandString, "Total:", totalSum);
	}
	
}
