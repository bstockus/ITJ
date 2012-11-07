package exams.insurance.models;

import java.util.ArrayList;
import java.util.List;

public class Quote {
	
	private Driver driver;
	private ArrayList<Vehicle> vehicles;
	
	public Quote(Driver driver, List<Vehicle> vehicles) {
		this.driver = driver;
		this.vehicles = new ArrayList<Vehicle>(vehicles);
	}
	
	public Driver getDriver() {
		return this.driver;
	}
	
	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}
	
	public Integer getNumberOfVehicles() {
		return this.getVehicles().size();
	}
	
	public Vehicle getVehicleAtIndex(Integer index) {
		return this.getVehicles().get(index);
	}
	
	private Double getPremium() {
		Double premium = 0.0;
		for (Vehicle vehicle: this.getVehicles()) {
			premium += vehicle.getTotalForDriver(this.getDriver());
		}
		return premium;
	}
	
	public Double getAnnualPremium() {
		return this.getPremium();
	}
	
	public Double getSemiAnnualPremium() {
		return (this.getPremium() / 2.0);
	}
	
	public Double getQuarterlyPremium() {
		return (this.getPremium() / 4.0);
	}
	
	public Double getWeeklyPremium() {
		return (this.getPremium() / 52.0);
	}
	
	public Double getMonthlyPremium() {
		return (this.getPremium() / 12.0);
	}
	
	public Double getDailyPremium() {
		return (this.getPremium() / 365.0);
	}
	
}
