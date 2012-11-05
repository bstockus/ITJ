package exams.insurance.views.input;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import convenience.dialogs.Dialogs;

import exams.insurance.models.input.InsuranceDriverInputEntry;
import exams.insurance.models.input.InsuranceInputModel;
import exams.insurance.models.input.InsuranceVehicleInputEntry;

public class InsuranceInputPrompts implements InsuranceInputView {
	
	// Class Constants
	private static Integer MAXIMUM_NUMBER_OF_DRIVER_ENTRIES = 1;
	private static Integer MAXIMUM_NUMBER_OF_VEHICLE_ENTRIES = 3;
	
	private List<InsuranceDriverInputEntry> getInsuranceDriverInputEntries() {
		Integer index = 1;
		ArrayList<InsuranceDriverInputEntry> driverInputEntries = new ArrayList<InsuranceDriverInputEntry>();
		while (true) {
			driverInputEntries.add(this.getInsuranceDriverInputEntry(index));
			if (index == InsuranceInputPrompts.MAXIMUM_NUMBER_OF_DRIVER_ENTRIES) {
				return driverInputEntries;
			} else if (!(Dialogs.displayConfirmDialog("Add Another Driver?", "Would you like to add another driver to this quote?"))) {
				return driverInputEntries;
			} else {
				index ++;
			}
		}
	}
	
	private InsuranceDriverInputEntry getInsuranceDriverInputEntry(Integer index) {
		String firstName = this.getInsuranceDriverFirstName(index);
		String lastName = this.getInsuranceDriverLastName(firstName);
		Integer age = this.getInsuranceDriverAge(firstName);
		InsuranceDriverInputEntry.Gender gender = this.getInsuranceDriverGender(firstName);
		InsuranceDriverInputEntry.MaritialStatus maritialStatus = this.getInsuranceDriverMaritialStatus(firstName);
		Boolean accidentOrTicketInLastThreeYears = this.getInsuranceDriverAccidentOrTicketInLastThreeYears(firstName);
		return (new InsuranceDriverInputEntry(firstName, lastName, age, gender, maritialStatus, accidentOrTicketInLastThreeYears));
		
	}
	
	private String getInsuranceDriverFirstName(Integer index) {
		return Dialogs.displayStringInputDialog("Driver Information", ("Enter first name for Driver #" + index.toString()), false);
	}
	
	private String getInsuranceDriverLastName(String firstName) {
		return Dialogs.displayStringInputDialog("Driver Information", ("Enter last name for " + firstName), false);
	}
	
	private Integer getInsuranceDriverAge(String firstName) {
		while (true) {
			Integer age = Dialogs.displayIntegerInputDialog("Driver Information", ("Enter age for " + firstName), 18);
			if (age >= 16) {
				return age;
			} else {
				Dialogs.displayErrorDialog("Driver Information", "You must enter a driver age greater than or equal to 16.");
			}
		}
	}
	
	private InsuranceDriverInputEntry.Gender getInsuranceDriverGender(String firstName) {
		while (true) {
			String gender = Dialogs.displayStringInputDialog("Driver Information", ("Enter a gender for " + firstName + " (M/F)"), false);
			if ((gender.equals("M")) || (gender.equals("m"))) {
				return InsuranceDriverInputEntry.Gender.MALE;
			} else if ((gender.equals("F")) || (gender.equals("f"))) {
				return InsuranceDriverInputEntry.Gender.FEMALE;
			} else {
				Dialogs.displayErrorDialog("Driver Information", "Invalid gender input, must be a \'M\' or \'F\'");
			}
		}
	}
	
	private InsuranceDriverInputEntry.MaritialStatus getInsuranceDriverMaritialStatus(String firstName) {
		while (true) {
			String maritialStatus = Dialogs.displayStringInputDialog("Driver Information", ("Enter maritial status for " + firstName + " (M/S)"), false);
			if ((maritialStatus.equals("M")) || (maritialStatus.equals("m"))) {
				return InsuranceDriverInputEntry.MaritialStatus.MARRIED;
			} else if ((maritialStatus.equals("S")) || (maritialStatus.equals("s"))) {
				return InsuranceDriverInputEntry.MaritialStatus.SINGLE;
			} else {
				Dialogs.displayErrorDialog("Driver Information", "Invalid maritial status input, must be a \'M\' or \'S\'");
			}
		}
	}
	
	private Boolean getInsuranceDriverAccidentOrTicketInLastThreeYears(String firstName) {
		
		return Dialogs.displayConfirmDialog("Driver Information", ("Has " + firstName + " been in an accident or received a ticket in the last three years?"));
	}
	
	private List<InsuranceVehicleInputEntry> getInsuranceVehicleInputEntries() {
		Integer index = 1;
		ArrayList<InsuranceVehicleInputEntry> vehicleInputEntries = new ArrayList<InsuranceVehicleInputEntry>();
		while (true) {
			vehicleInputEntries.add(this.getInsuranceVehicleInputEntry(index));
			if (index == InsuranceInputPrompts.MAXIMUM_NUMBER_OF_VEHICLE_ENTRIES) {
				return vehicleInputEntries;
			} else if (!(Dialogs.displayConfirmDialog("Add Another Vehicle?", "Would you like to add another vehicle to this quote?"))) {
				return vehicleInputEntries;
			} else {
				index ++;
			}
		}
	}
	
	private InsuranceVehicleInputEntry getInsuranceVehicleInputEntry(Integer index) {
		Integer year = this.getInsuranceVehicleYear(index);
		String make = this.getInsuranceVehicleMake(index);
		return (new InsuranceVehicleInputEntry(year, make));
	}
	
	private Integer getInsuranceVehicleYear(Integer index) {
		Integer maximumYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
		while (true) {
			Integer year = Dialogs.displayIntegerInputDialog("Vehicle Information", ("Enter the year for Vehicle #" + index.toString()), 2000);
			if ((year <= maximumYear) && (year >= 1900)) {
				return year;
			} else {
				Dialogs.displayErrorDialog("Vehicle Information", ("Year must be between 1900 and " + maximumYear.toString()));
			}
		}
	}
	
	private String getInsuranceVehicleMake(Integer index) {
		return Dialogs.displayStringInputDialog("Vehicle Information", ("Enter the make for Vehicle #" + index.toString()), false);
	}
	
	@Override
	public InsuranceInputModel runInsuranceInputView() {
		return (new InsuranceInputModel(this.getInsuranceDriverInputEntries(), this.getInsuranceVehicleInputEntries()));
	}

}
