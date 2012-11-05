package exams.insurance.models.input;

public class InsuranceVehicleInputEntry {
	
	private Integer year;
	
	public Integer getYear() {
		return this.year;
	}
	
	private String make;
	
	public String getMake() {
		return this.make;
	}
	
	public InsuranceVehicleInputEntry(Integer year, String make) {
		this.year = year;
		this.make = make;
	}
	
}
