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
	private static final Integer[] FIELD_COLUMN_WIDTHS = {6, 20, 20, 2, 3, 10};
	private static final Integer TOTAL_COLUMN_LEFT_WIDTH = 55;
	private static final Integer TOTAL_COLUMN_RIGHT_WIDTH = 10;
	private static final Integer SORT_BY_FIELD_INDEX = 4;
	private static final Integer SUM_BY_FIELD_INDEX = 5;
	
	public static void main(String[] args) {
		Scanner scanner = EmployeeSalesRep.getFileScanner();
		ArrayList<String[]> fileRecordsList = new ArrayList<String[]>();
		HashSet<String> uniqueSortValues = new HashSet<String>();
		Integer fieldCount = EmployeeSalesRep.FIELD_NAMES.length;
		while (scanner.hasNext()) {
			String[] record = new String[fieldCount];
			for (Integer fieldIndex = 0; fieldIndex < EmployeeSalesRep.FIELD_NAMES.length; fieldIndex ++) {
				record[fieldIndex] = scanner.next();
				if (fieldIndex == EmployeeSalesRep.SORT_BY_FIELD_INDEX) {
					uniqueSortValues.add(record[fieldIndex]);
				}
			}
			fileRecordsList.add(record);
		}
		String[][] fileRecords = fileRecordsList.toArray(new String[0][0]);
		String[] recordGroups = uniqueSortValues.toArray(new String[0]);
		Double totalSum = 0.0;
		for (String sortByColumnValue: recordGroups) {
			totalSum += EmployeeSalesRep.printRecordsForRecordGroupAndGetSum(fileRecords, sortByColumnValue);
		}
		EmployeeSalesRep.printFooter(totalSum);
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
	
	private static Double printRecordsForRecordGroupAndGetSum(String[][] fileRecords, String sortByColumnValue) {
		EmployeeSalesRep.printRecordGroupHeader();
		Double sum = 0.0;
		for (Integer recordIndex = 0; recordIndex < fileRecords.length; recordIndex ++) {
			if ((fileRecords[recordIndex][EmployeeSalesRep.SORT_BY_FIELD_INDEX]).equals(sortByColumnValue)) {
				EmployeeSalesRep.printRecordAtIndex(fileRecords, recordIndex);
				sum += Double.parseDouble(fileRecords[recordIndex][EmployeeSalesRep.SUM_BY_FIELD_INDEX]);
			}
		}
		EmployeeSalesRep.printRecordGroupFooter(sortByColumnValue, sum);
		return sum;
	}
	
	private static void printRecordGroupHeader() {
		// Print Field Names
		for (Integer index = 0; index < EmployeeSalesRep.FIELD_NAMES.length; index ++) {
			String printfCommandString = "%-" + EmployeeSalesRep.FIELD_COLUMN_WIDTHS[index].toString() + "s ";
			System.out.printf(printfCommandString, EmployeeSalesRep.FIELD_NAMES[index]);
		}
		System.out.printf("\n");
		// Print Header Dashes
		for (Integer index = 0; index < EmployeeSalesRep.FIELD_NAMES.length; index ++) {
			for (Integer dashIndex = 0; dashIndex < EmployeeSalesRep.FIELD_COLUMN_WIDTHS[index]; dashIndex ++) {
				System.out.printf("=");
			}
			System.out.printf(" ");
		}
		System.out.printf("\n");
	}
	
	private static void printRecordAtIndex(String[][] fileRecords, Integer recordIndex) {
		for (Integer index = 0; index < EmployeeSalesRep.FIELD_NAMES.length; index ++) {
			String printfCommandString = "%-" + EmployeeSalesRep.FIELD_COLUMN_WIDTHS[index].toString() + "s ";
			System.out.printf(printfCommandString, fileRecords[recordIndex][index]);
		}
		System.out.printf("\n");
	}
	
	private static void printRecordGroupFooter(String sortByColumnValue, Double sumByColumnValue) {
		String printfCommandString = "%" + EmployeeSalesRep.TOTAL_COLUMN_LEFT_WIDTH.toString() + "s %-" + EmployeeSalesRep.TOTAL_COLUMN_RIGHT_WIDTH.toString() + "s\n\n";
		String leftString = "Total for " + EmployeeSalesRep.FIELD_NAMES[EmployeeSalesRep.SORT_BY_FIELD_INDEX] + " " + sortByColumnValue + ":";
		System.out.printf(printfCommandString, leftString, sumByColumnValue);
	}
	
	private static void printFooter(Double totalSum) {
		String printfCommandString = "%" + EmployeeSalesRep.TOTAL_COLUMN_LEFT_WIDTH.toString() + "s %-" + EmployeeSalesRep.TOTAL_COLUMN_RIGHT_WIDTH.toString() + "s\n";
		System.out.printf(printfCommandString, "Total:", totalSum);
	}
	
}
