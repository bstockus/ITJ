package exams.insurance.models.input;

import java.util.ArrayList;
import java.util.List;

public class InsuranceInputModel {
	
	private ArrayList<InsuranceDriverInputEntry> drivers;
	
	public List<InsuranceDriverInputEntry> getDrivers() {
		return this.drivers;
	}
	
	private ArrayList<InsuranceVehicleInputEntry> vehicles;
	
	public List<InsuranceVehicleInputEntry> getVehicles() {
		return this.vehicles;
	}
	
	public InsuranceInputModel(List<InsuranceDriverInputEntry> drivers, List<InsuranceVehicleInputEntry> vehicles) {
		this.drivers = new ArrayList<InsuranceDriverInputEntry>(drivers);
		this.vehicles = new ArrayList<InsuranceVehicleInputEntry>(vehicles);
	}
	
}
