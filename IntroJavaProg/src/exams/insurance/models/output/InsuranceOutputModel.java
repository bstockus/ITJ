package exams.insurance.models.output;

import java.util.ArrayList;
import java.util.List;

public class InsuranceOutputModel {
	
	private ArrayList<InsuranceDriverOutputEntry> drivers;
	
	public List<InsuranceDriverOutputEntry> getDrivers() {
		return this.drivers;
	}
	
	private ArrayList<InsuranceVehicleOutputEntry> vehicles;
	
	public List<InsuranceVehicleOutputEntry> getVehicles() {
		return this.vehicles;
	}
	
}
