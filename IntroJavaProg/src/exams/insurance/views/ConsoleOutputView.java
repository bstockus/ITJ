package exams.insurance.views;

import exams.insurance.models.Driver;
import exams.insurance.models.Quote;
import exams.insurance.models.Vehicle;

public class ConsoleOutputView implements OutputView {

	@Override
	public void displayOutputViewForQuote(Quote quote) {
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
		
		// Driver Information Section
		System.out.println("WTC Insurance Quote for " + driverName);
		System.out.printf("---------------------------------------------------------\nDriver Information\n");
		System.out.printf("%-22s%s\n", "Name", driverName);
		System.out.printf("%-22s%d\n", "Age", driverAge);
		System.out.printf("%-22s%s\n", "Gender", driverGender);
		System.out.printf("%-22s%s\n", "Marital Status", driverMaritalStatus);
		System.out.printf("%-22s%s\n\n", "Accident/Violation?", driverAccident);
		
		// Vehicle Information Section
		System.out.printf("%-25s%-50s%-50s%-50s\n", "", "LIABILITY", "COMPREHENSIVE", "COLLISION");
		System.out.printf("%-25s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-16s\n", "", "Base", "Age Chg", "MF Chg", "Acc Chg", "Total",
				"Base", "Age Chg", "MF Chg", "Acc Chg", "Total", "Base", "Age Chg", "MF Chg", "Acc Chg", "Total", "Total");
		for (Vehicle vehicle: quote.getVehicles()) {
			Vehicle.Coverage liabilityCoverage = vehicle.getLiabilityCoverageForDriver(driver);
			Vehicle.Coverage comprehensiveCoverage = vehicle.getComprehensiveCoverageForDriver(driver);
			Vehicle.Coverage collisionCoverage = vehicle.getCollisionCoverageForDriver(driver);
			System.out.printf("%-25s", (vehicle.getYear().toString() + " " + vehicle.getMake()));
			System.out.printf("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f", liabilityCoverage.getBaseCharge(), liabilityCoverage.getAgeCharge(), 
					liabilityCoverage.getGenderCharge(), liabilityCoverage.getAccidentCharge(), liabilityCoverage.getTotalCharge());
			System.out.printf("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f", comprehensiveCoverage.getBaseCharge(), comprehensiveCoverage.getAgeCharge(), 
					comprehensiveCoverage.getGenderCharge(), comprehensiveCoverage.getAccidentCharge(), comprehensiveCoverage.getTotalCharge());
			System.out.printf("%-10.2f%-10.2f%-10.2f%-10.2f%-10.2f", collisionCoverage.getBaseCharge(), collisionCoverage.getAgeCharge(), 
					collisionCoverage.getGenderCharge(), collisionCoverage.getAccidentCharge(), collisionCoverage.getTotalCharge());
			System.out.printf("%-16.2f\n", vehicle.getTotalForDriver(driver));
		}
		
		// Billing Information Section
		System.out.printf("---------------------------------------------------------\nBilling Information\n");
		System.out.printf("%-25s%s%-10.2f\n", "Annual Premium", "$", quote.getAnnualPremium());
		System.out.printf("%-25s%s%-10.2f\n", "Bi-Annual Premium", "$", quote.getSemiAnnualPremium());
		System.out.printf("%-25s%s%-10.2f\n", "Quarterly Premium", "$", quote.getQuarterlyPremium());
		
		// Surcharge Information Section
		System.out.printf("\n---------------------------------------------------------\nSurcharges on this Policy\n");
		System.out.printf("%-25s%s%f\n", "Age Marital Surcharge", "=", driver.getAgeSurcharge());
		System.out.printf("%-25s%s%f\n", "Accident Surcharge", "=", driver.getAccidentSurcharge());
		System.out.printf("%-25s%s%f\n", "Gender Surcharge", "=", driver.getGenderSurcharge());
		
		// Footer Section
		System.out.printf("\n\nThank you for your patronage.\n");
	}

}
