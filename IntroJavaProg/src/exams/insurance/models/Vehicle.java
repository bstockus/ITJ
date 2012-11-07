package exams.insurance.models;

public class Vehicle {
	
	public class Coverage {
		
		private Double baseCharge;
		private Double ageCharge;
		private Double genderCharge;
		private Double accidentCharge;
		
		public Coverage(Double baseCharge, Double ageSurcharge, Double genderSurcharge, Double accidentSurcharge) {
			this.baseCharge = baseCharge;
			this.ageCharge = baseCharge * ageSurcharge;
			this.genderCharge = baseCharge * genderSurcharge;
			this.accidentCharge = baseCharge * accidentSurcharge;
		}
		
		public Double getBaseCharge() {
			return this.baseCharge;
		}
		
		public Double getAgeCharge() {
			return this.ageCharge;
		}
		
		public Double getGenderCharge() {
			return this.genderCharge;
		}
		
		public Double getAccidentCharge() {
			return this.accidentCharge;
		}
		
		public Double getTotalCharge() {
			return (this.getBaseCharge() + this.getAgeCharge() + this.getGenderCharge() + this.getAccidentCharge());
		}
		
	}
	
	private static Double[] LIABILITY_BASE_PREMIUMS = {60.0, 70.0, 80.0, 90.0, 100.0};
	private static Double[] COMPREHENSIVE_BASE_PREMIUMS = {45.0, 50.0, 55.0, 60.0, 65.0};
	private static Double[] COLLISION_BASE_PREMIUMS = {50.0, 60.0, 70.0, 80.0, 90.0};
	
	private Integer year;
	private String make;
	
	public Vehicle(Integer year, String make) {
		this.year = year;
		this.make = make;
	}
	
	private Integer getYearTier() {
		Integer year = this.getYear();
		if (year < 1986) {
			return 0;
		} else if (year < 1990) {
			return 1;
		} else if (year < 1995) {
			return 2;
		} else if (year < 2000) {
			return 3;
		} else {
			return 4;
		}
	}
	
	public Integer getYear() {
		return this.year;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public Double getLiabilityBasePremium() {
		return Vehicle.LIABILITY_BASE_PREMIUMS[this.getYearTier()];
	}
	
	public Double getComprehensiveBasePremium() {
		return Vehicle.COMPREHENSIVE_BASE_PREMIUMS[this.getYearTier()];
	}
	
	public Double getCollisionBasePremium() {
		return Vehicle.COLLISION_BASE_PREMIUMS[this.getYearTier()];
	}
	
	public Vehicle.Coverage getLiabilityCoverageForDriver(Driver driver) {
		return (new Vehicle.Coverage(this.getLiabilityBasePremium(), driver.getAgeSurcharge(), driver.getGenderSurcharge(), driver.getAccidentSurcharge()));
	}
	
	public Vehicle.Coverage getComprehensiveCoverageForDriver(Driver driver) {
		return (new Vehicle.Coverage(this.getComprehensiveBasePremium(), driver.getAgeSurcharge(), driver.getGenderSurcharge(), driver.getAccidentSurcharge()));
	}
	
	public Vehicle.Coverage getCollisionCoverageForDriver(Driver driver) {
		return (new Vehicle.Coverage(this.getCollisionBasePremium(), driver.getAgeSurcharge(), driver.getGenderSurcharge(), driver.getAccidentSurcharge()));
	}
	
	public Double getTotalForDriver(Driver driver) {
		return (this.getLiabilityCoverageForDriver(driver).getTotalCharge() +
				this.getComprehensiveCoverageForDriver(driver).getTotalCharge() +
				this.getCollisionCoverageForDriver(driver).getTotalCharge());
	}
	
}
