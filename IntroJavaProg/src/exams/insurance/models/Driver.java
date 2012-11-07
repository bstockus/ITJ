package exams.insurance.models;

public class Driver {
	
	public enum Gender {
		MALE,
		FEMALE
	}
	
	public enum MaritalStatus {
		MARRIED,
		SINGLE
	}
	
	private static Double[] MARRIED_AGE_SURCHARGE = {0.35, 0.30, 0.25, 0.20, 0.15, 0.10, 0.05};
	private static Double[] SINGLE_AGE_SURCHARGE = {0.40, 0.35, 0.30, 0.25, 0.20, 0.15, 0.10};
	private static Double FEMALE_GENDER_SURCHARGE = 0.08;
	private static Double MALE_GENDER_SURCHARGE = 0.20;
	private static Double ACCIDENT_SURCHARGE = 0.40;
	private static Double NO_ACCIDENT_SURCHARGE = 0.0;
	
	private String name;
	private Integer age;
	private Driver.Gender gender;
	private Driver.MaritalStatus maritalStatus;
	private Boolean accident;
	
	public Driver(String name, Integer age, Driver.Gender gender, Driver.MaritalStatus maritalStatus, Boolean accident) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.accident = accident;
	}
	
	private Integer getAgeTier() {
		Integer age = this.getAge();
		if (age <= 18) {
			return 0;
		} else if (age <= 23) {
			return 1;
		} else if (age <= 27) {
			return 2;
		} else if (age <= 35) {
			return 3;
		} else if (age <= 44) {
			return 4;
		} else if (age <= 65) {
			return 5;
		} else {
			return 6;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public Driver.Gender getGender() {
		return this.gender;
	}
	
	public Driver.MaritalStatus getMaritalStatus() {
		return this.maritalStatus;
	}
	
	public Boolean isAccident() {
		return this.accident;
	}
	
	public Boolean isMale() {
		if (this.getGender() == Driver.Gender.MALE) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isFemale() {
		if (this.getGender() == Driver.Gender.FEMALE) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isMarried() {
		if (this.getMaritalStatus() == Driver.MaritalStatus.MARRIED) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isSingle() {
		if (this.getMaritalStatus() == Driver.MaritalStatus.SINGLE) {
			return true;
		} else {
			return false;
		}
	}
	
	public Double getAgeSurcharge() {
		if (this.isMarried()) {
			return Driver.MARRIED_AGE_SURCHARGE[this.getAgeTier()];
		} else {
			return Driver.SINGLE_AGE_SURCHARGE[this.getAgeTier()];
		}
	}
	
	public Double getGenderSurcharge() {
		if (this.isFemale()) {
			return Driver.FEMALE_GENDER_SURCHARGE;
		} else {
			return Driver.MALE_GENDER_SURCHARGE;
		}
	}
	
	public Double getAccidentSurcharge() {
		if (this.isAccident()) {
			return Driver.ACCIDENT_SURCHARGE;
		} else {
			return Driver.NO_ACCIDENT_SURCHARGE;
		}
	}
	
}
