package chapter9.assignment21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import convenience.Console;

public class EmployeeSalesRep {
	
	private static final String FILE_NAME = "EmployeeSalesRep.txt";
	private static final String[] FIELD_NAMES = {"Emp#", "Last Name", "First Name", "MI", "Rep", "Commission"};
	private static final String HEADER_SEPERATOR_CHARACTER = "-";
	private static final String FOOTER_SEPERATOR_CHARACTER = "=";
	private static final Integer SORT_BY_FIELD_INDEX = 4;
	private static final Integer SUM_BY_FIELD_INDEX = 5;
	
	public static void main(
			String[] args) {
		
		Integer fieldCount = EmployeeSalesRep.FIELD_NAMES.length;
		
		// Create Array for storing column widths
		Integer[] columnWidths = new Integer[fieldCount];
		for (Integer columnIndex = 0; columnIndex < fieldCount; columnIndex ++) {
			columnWidths[columnIndex] = EmployeeSalesRep.FIELD_NAMES[columnIndex].length();
		}
		
		// Read in Records from file
		Scanner scanner = EmployeeSalesRep.getFileScanner();
		ArrayList<String[]> fileRecordsList = new ArrayList<String[]>();
		HashSet<String> uniqueSortValues = new HashSet<String>();
		while (scanner.hasNext()) {
			String[] record = new String[fieldCount];
			for (Integer fieldIndex = 0; fieldIndex < fieldCount; fieldIndex ++) {
				String fieldValue = scanner.next();
				record[fieldIndex] = fieldValue;
				if (fieldIndex == EmployeeSalesRep.SORT_BY_FIELD_INDEX) {
					uniqueSortValues.add(fieldValue);
				}
				if (fieldValue.length() > columnWidths[fieldIndex]) {
					columnWidths[fieldIndex] = fieldValue.length();
				}
			}
			fileRecordsList.add(record);
		}
		String[][] fileRecords = fileRecordsList.toArray(new String[0][0]);
		String[] recordGroups = uniqueSortValues.toArray(new String[0]);
		
		// Calculate Position for Sum By Field
		Integer sumByFieldPosition = -1;
		for (Integer columnIndex = 0; columnIndex < EmployeeSalesRep.SUM_BY_FIELD_INDEX; columnIndex ++) {
			sumByFieldPosition += columnWidths[columnIndex] + 1;
		}
		
		// Generate Group Header and Footer
		String headerValue = EmployeeSalesRep.getRecordGroupHeader(columnWidths);
		String footerValue = EmployeeSalesRep.getRecordGroupFooter(columnWidths, sumByFieldPosition);
		
		// Print Record Groups
		Double totalSum = 0.0;
		for (String sortByColumnValue: recordGroups) {
			totalSum += EmployeeSalesRep.printRecordsForRecordGroupAndGetSum(fileRecords, sortByColumnValue, columnWidths, sumByFieldPosition, headerValue, footerValue);
		}
		
		// Print Total Sum
		EmployeeSalesRep.printFooter(String.format("%.2f", totalSum), columnWidths, sumByFieldPosition);
	}
	
	private static Scanner getFileScanner() {
		File file = new File(EmployeeSalesRep.FILE_NAME);
		try {
			Scanner scanner = new Scanner(file);
			return scanner;
		} catch (FileNotFoundException e) {
			Console.printError("File Not Found!");
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
				sum += Double.parseDouble(fileRecords[recordIndex][EmployeeSalesRep.SUM_BY_FIELD_INDEX]);
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
	
	private static void printFooter(
			String totalSum, 
			Integer[] columnWidths, 
			Integer sumByFieldPosition) {
		
		String printfCommandString = "%" + sumByFieldPosition.toString() + "s %-" + columnWidths[EmployeeSalesRep.SUM_BY_FIELD_INDEX].toString() + "s\n";
		System.out.printf(printfCommandString, "Total:", totalSum);
	}
	
}
