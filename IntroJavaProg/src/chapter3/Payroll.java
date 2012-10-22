// Bryan Stockus, 26 SEPT 2012
package chapter3;

//Intro to JAVA, Chapter 3, Assignment 9, Program A
//PURPOSE: Write a program to calculate hourly payroll.

//Import Convenience Classes
import convenience.Debug;
import convenience.UserInteraction;

public class Payroll {
	
	// Debug Mode Constant (if true debug messages are printed):
	static Boolean DEBUG = false;
	
	// Overtime Multiplier Constant:
	static Double OVERTIME_MULTIPLIER = 1.5;
	
	// Overtime Hours Constant:
	static Double OVERTIME_HOURS = 40.0;
	
	public static void main(String[] args) {
		
		Debug.printDebugDoubleValue(DEBUG, "OVERTIME_MULTIPLIER", OVERTIME_MULTIPLIER);
		Debug.printDebugDoubleValue(DEBUG, "OVERTIME_HOURS", OVERTIME_HOURS);
		
		// Step 0. Declare and initialize variables:
		Double numberOfHoursWorked = 0.0;
		Double hourlyWage = 0.0;
		Double regularHours = 0.0;
		Double overtimeHours = 0.0;
		Double regularWage = 0.0;
		Double overtimeWage = 0.0;
		Double regularPay = 0.0;
		Double overtimePay = 0.0;
		Double totalPay = 0.0;
		
		// Step 1. Ask the user for input:
		// Step 1a. number of hours worked:
		numberOfHoursWorked = UserInteraction.askUserForDouble("PAYROLL - enter hours", 
				"How many hours were worked?");
		Debug.printDebugDoubleValue(DEBUG, "numberOfHoursWorked", numberOfHoursWorked);
		// Step 1b. hourly wage:
		hourlyWage = UserInteraction.askUserForDouble("PAYROLL - enter wage", 
				"What is the hourly pay");
		Debug.printDebugDoubleValue(DEBUG, "hourlyWage", hourlyWage);
		
		// Step 2. Perform calculations:
		if(numberOfHoursWorked < OVERTIME_HOURS) {
			regularHours = numberOfHoursWorked;
			Debug.printDebugDoubleValue(DEBUG, "regularHours", regularHours);
			regularWage = hourlyWage;
			Debug.printDebugDoubleValue(DEBUG, "regularWage", regularWage);
		} else {
			regularHours = OVERTIME_HOURS;
			Debug.printDebugDoubleValue(DEBUG, "regularHours", regularHours);
			regularWage = hourlyWage;
			Debug.printDebugDoubleValue(DEBUG, "regularWage", regularWage);
			overtimeHours = numberOfHoursWorked - OVERTIME_HOURS;
			Debug.printDebugDoubleValue(DEBUG, "overtimeHours", overtimeHours);
			overtimeWage = hourlyWage * OVERTIME_MULTIPLIER;
			Debug.printDebugDoubleValue(DEBUG, "overtimeWage", overtimeWage);
		}
		
		// Step 3. Calculate Pay:
		regularPay = regularHours * regularWage;
		Debug.printDebugDoubleValue(DEBUG, "regularPay", regularPay);
		overtimePay = overtimeHours * overtimeWage;
		Debug.printDebugDoubleValue(DEBUG, "overtimePay", overtimePay);
		totalPay = regularPay + overtimePay;
		Debug.printDebugDoubleValue(DEBUG, "totalPay", totalPay);
		
		// Step 4. Display output to the user:
		System.out.printf("%15s%15s%15s%15s%15s%15s\n","Hours","Wage","OT Hours","OT Wage","OT Pay","Total Pay");
		System.out.printf("%15.2f%15.2f%15.2f%15.2f%15.2f%15.2f", numberOfHoursWorked, hourlyWage,
				overtimeHours, overtimeWage, overtimePay, totalPay);
		
	}

}
