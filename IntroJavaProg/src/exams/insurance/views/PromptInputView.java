package exams.insurance.views;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import convenience.dialogs.Dialogs;

import exams.insurance.models.Driver;
import exams.insurance.models.Quote;
import exams.insurance.models.Vehicle;

public class PromptInputView implements InputView {

	private static Integer MAXIMUM_NUMBER_OF_VEHICLES = 3;
	private static Integer MINIMUM_DRIVER_AGE = 16;
	private static Integer MINIMUM_VEHICLE_YEAR = 1900;
	private static Integer MAXIMUM_VEHICLE_YEAR = PromptInputView.getMaximumVehicleYear();
	
	private static Integer getMaximumVehicleYear() {
		return (Calendar.getInstance().get(Calendar.YEAR) + 1);
	}
	
	@Override
	public Quote getQuote() {
		Driver driver = this.getDriver();
		List<Vehicle> vehicles = this.getVehicles();
		return (new Quote(driver, vehicles));
	}
	
	private Driver getDriver() {
		String name = this.getDriverName();
		Integer age = this.getDriverAge();
		Driver.Gender gender = this.getDriverGender();
		Driver.MaritalStatus maritalStatus = this.getDriverMaritalStatus();
		Boolean accident = this.getDriverAccident();
		return (new Driver(name, age, gender, maritalStatus, accident));
	}
	
	private String getDriverName() {
		return Dialogs.displayStringInputDialog("DRIVER INPUT", "Enter Driver's first and last name", false);
	}
	
	private Integer getDriverAge() {
		while (true) {
			Integer age = Dialogs.displayIntegerInputDialog("DRIVER INPUT", "Enter Driver's current age", 16);
			if (age < PromptInputView.MINIMUM_DRIVER_AGE) {
				Dialogs.displayErrorDialog("DRIVER INPUT ERROR", "ERROR: You must enter a value that is greater than or equal to " + PromptInputView.MINIMUM_DRIVER_AGE.toString() + ".");
			} else {
				return age;
			}
		}
		
	}
	
	private Driver.Gender getDriverGender() {
		while (true) {
			String input = Dialogs.displayStringInputDialog("DRIVER INPUT", "Enter Driver's gender (\'M\'/\'F\')", false);
			if (input.equalsIgnoreCase("M")) {
				return Driver.Gender.MALE;
			} else if (input.equalsIgnoreCase("F")) {
				return Driver.Gender.FEMALE;
			} else {
				Dialogs.displayErrorDialog("DRIVER INPUT ERROR", "ERROR: You must enter a: \'M\', \'m\', \'F\', or \'f\'.");
			}
		}
	}
	
	private Driver.MaritalStatus getDriverMaritalStatus() {
		while (true) {
			String input = Dialogs.displayStringInputDialog("DRIVER INPUT", "Enter Driver's marital status (\'M\'/\'S\')", false);
			if (input.equalsIgnoreCase("M")) {
				return Driver.MaritalStatus.MARRIED;
			} else if (input.equalsIgnoreCase("S")) {
				return Driver.MaritalStatus.SINGLE;
			} else {
				Dialogs.displayErrorDialog("DRIVER INPUT ERROR", "ERROR: You must enter a: \'M\', \'m\', \'S\', or \'s\'.");
			}
		}
	}
	
	private Boolean getDriverAccident() {
		if (Dialogs.displayConfirmDialog("DRIVER INPUT", "Has the Driver been involved in an accident or received a ticket within the last three years?")) {
			return true;
		} else {
			return false;
		}
	}
	
	private List<Vehicle> getVehicles() {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		for (Integer index = 1; index <= PromptInputView.MAXIMUM_NUMBER_OF_VEHICLES; index ++) {
			vehicles.add(this.getVehicle(index));
			if (index != PromptInputView.MAXIMUM_NUMBER_OF_VEHICLES) {
				if (this.isNoMoreVehiclesToAdd()) {
					return vehicles;
				}
			}
		}
		return vehicles;
	}
	
	private Boolean isNoMoreVehiclesToAdd() {
		if (Dialogs.displayConfirmDialog("QUOTE INPUT", "Would you like to add another vehicle to this quote?")) {
			return false;
		} else {
			return true;
		}
	}
	
	private Vehicle getVehicle(Integer index) {
		Integer year = this.getVehicleYear(index);
		String make = this.getVehicleMake(index);
		return (new Vehicle(year, make));
	}
	
	private Integer getVehicleYear(Integer index) {
		while (true) {
			Integer year = Dialogs.displayIntegerInputDialog("VEHICLE #" + index.toString() + " INPUT", "Enter the year of Vehicle #" + index.toString(), 2000);
			if ((year < PromptInputView.MINIMUM_VEHICLE_YEAR) || (year > PromptInputView.MAXIMUM_VEHICLE_YEAR)) {
				Dialogs.displayErrorDialog("VEHICLE #" + index.toString() + " INPUT ERROR", "You must enter a year between " + PromptInputView.MINIMUM_VEHICLE_YEAR.toString() +
						" and " + PromptInputView.MAXIMUM_VEHICLE_YEAR.toString());
			} else {
				return year;
			}
		}
	}
	
	private String getVehicleMake(Integer index) {
		return Dialogs.displayStringInputDialog("VEHICLE #" + index.toString() + " INPUT", "Enter the make of Vehicle #" + index.toString(), false);
	}

}
