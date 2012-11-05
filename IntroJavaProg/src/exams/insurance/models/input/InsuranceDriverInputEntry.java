package exams.insurance.models.input;

public class InsuranceDriverInputEntry {
	
	public enum Gender {
		MALE,
		FEMALE
	}
	
	public enum MaritialStatus {
		MARRIED,
		SINGLE
	}
	
	private String firstName;
	
	public String getFirstName() {
		return this.firstName;
	}
	
	private String lastName;
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getFullName() {
		return (this.firstName + " " + this.lastName);
	}
	
	private Integer age;
	
	public Integer getAge() {
		return this.age;
	}
	
	private InsuranceDriverInputEntry.Gender gender;
	
	public InsuranceDriverInputEntry.Gender getGender() {
		return this.gender;
	}
	
	public Boolean isMale() {
		if (this.getGender() == InsuranceDriverInputEntry.Gender.MALE) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isFemale() {
		if (this.getGender() == InsuranceDriverInputEntry.Gender.FEMALE) {
			return true;
		} else {
			return false;
		}
	}
	
	private InsuranceDriverInputEntry.MaritialStatus maritialStatus;
	
	public InsuranceDriverInputEntry.MaritialStatus getMaritialStatus() {
		return this.maritialStatus;
	}
	
	public Boolean isMarried() {
		if (this.getMaritialStatus() == InsuranceDriverInputEntry.MaritialStatus.MARRIED) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isSingle() {
		if (this.getMaritialStatus() == InsuranceDriverInputEntry.MaritialStatus.SINGLE) {
			return true;
		} else {
			return false;
		}
	}
	
	private Boolean accidentOrTicketInLastThreeYears;
	
	public Boolean isAccidentOrTicketInLastThreeYears() {
		return this.accidentOrTicketInLastThreeYears;
	}
	
	public InsuranceDriverInputEntry(String firstName, String lastName, Integer age, InsuranceDriverInputEntry.Gender gender,
			InsuranceDriverInputEntry.MaritialStatus maritialStatus, Boolean accidentOrTicketInLastThreeYears) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.maritialStatus = maritialStatus;
		this.accidentOrTicketInLastThreeYears = accidentOrTicketInLastThreeYears;
	}
	
}
