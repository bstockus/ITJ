package exams.insurance.views;

import exams.insurance.models.Driver;
import exams.insurance.models.Quote;
import exams.insurance.models.Vehicle;

public class QuoteOutputGenerator {
	
	public static String generateOuputForQuote(Quote quote, String lineSeperator) {
		Driver driver = quote.getDriver();
		String driverName = driver.getName();
		Integer driverAge = driver.getAge();
		String driverGender;
		if (driver.isMale()) {
			driverGender = "M";
		} else {
			driverGender = "F";
		}
		String driverMaritalStatus;
		if (driver.isMarried()) {
			driverMaritalStatus = "M";
		} else {
			driverMaritalStatus = "S";
		}
		String driverAccident;
		if (driver.isAccident()) {
			driverAccident = "Y";
		} else {
			driverAccident = "N";
		}
		
		String results = "WTC Insurance Quote for " + driverName + lineSeperator;
		
		// Driver Information Section
		results += "---------------------------------------------------------" + lineSeperator + "Driver Information" + lineSeperator;
		results += String.format("%-22s%s", "Name", driverName) + lineSeperator;
		results += String.format("%-22s%d", "Age", driverAge) + lineSeperator;
		results += String.format("%-22s%s", "Gender", driverGender) + lineSeperator;
		results += String.format("%-22s%s", "Marital Status", driverMaritalStatus) + lineSeperator;
		results += String.format("%-22s%s", "Accident/Violation?", driverAccident) + lineSeperator + lineSeperator;
		
		// Vehicle Information Section
		results += String.format("%-20s%-50s%-50s%-50s", "", "LIABILITY", "COMPREHENSIVE", "COLLISION") + lineSeperator;
		results += String.format("%-20s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-16s", "", "Base", "Age Chg", "MF Chg", "Acc Chg", "Total",
				"Base", "Age Chg", "MF Chg", "Acc Chg", "Total", "Base", "Age Chg", "MF Chg", "Acc Chg", "Total", "Total") + lineSeperator;
		for (Vehicle vehicle: quote.getVehicles()) {
			Vehicle.Coverage liabilityCoverage = vehicle.getLiabilityCoverageForDriver(driver);
			Vehicle.Coverage comprehensiveCoverage = vehicle.getComprehensiveCoverageForDriver(driver);
			Vehicle.Coverage collisionCoverage = vehicle.getCollisionCoverageForDriver(driver);
			results += String.format("%-20s", (vehicle.getYear().toString() + " " + vehicle.getMake()));
			results += String.format("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f", liabilityCoverage.getBaseCharge(), liabilityCoverage.getAgeCharge(), 
					liabilityCoverage.getGenderCharge(), liabilityCoverage.getAccidentCharge(), liabilityCoverage.getTotalCharge());
			results += String.format("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f", comprehensiveCoverage.getBaseCharge(), comprehensiveCoverage.getAgeCharge(), 
					comprehensiveCoverage.getGenderCharge(), comprehensiveCoverage.getAccidentCharge(), comprehensiveCoverage.getTotalCharge());
			results += String.format("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f", collisionCoverage.getBaseCharge(), collisionCoverage.getAgeCharge(), 
					collisionCoverage.getGenderCharge(), collisionCoverage.getAccidentCharge(), collisionCoverage.getTotalCharge());
			results += String.format("%-16.2f", vehicle.getTotalForDriver(driver)) + lineSeperator;
		}
		
		// Billing Information Section
		results += "---------------------------------------------------------" + lineSeperator + "Billing Information" + lineSeperator;
		results += String.format("%-25s%s%-10.2f", "Annual Premium", "$", quote.getAnnualPremium()) + lineSeperator;
		results += String.format("%-25s%s%-10.2f", "Bi-Annual Premium", "$", quote.getSemiAnnualPremium()) + lineSeperator;
		results += String.format("%-25s%s%-10.2f", "Quarterly Premium", "$", quote.getQuarterlyPremium()) + lineSeperator;
		
		// Surcharge Information Section
		results += lineSeperator + "---------------------------------------------------------" + lineSeperator + "Surcharges on this Policy" + lineSeperator;
		results += String.format("%-25s%s%.2f", "Age Marital Surcharge", "=", driver.getAgeSurcharge()) + lineSeperator;
		results += String.format("%-25s%s%.2f", "Accident Surcharge", "=", driver.getAccidentSurcharge()) + lineSeperator;
		results += String.format("%-25s%s%.2f", "Gender Surcharge", "=", driver.getGenderSurcharge()) + lineSeperator;
		
		// Footer Section
		results += lineSeperator + lineSeperator + String.format("Thank you for your patronage.") + lineSeperator;
		
		return results;
	}
	
}
