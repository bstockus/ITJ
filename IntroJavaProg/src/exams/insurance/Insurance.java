package exams.insurance;

import exams.insurance.models.input.InsuranceInputModel;
import exams.insurance.views.input.InsuranceInputPrompts;
import exams.insurance.views.input.InsuranceInputView;

public class Insurance {
	
	private static InsuranceInputView inputView = new InsuranceInputPrompts();
	
	public void run() {
		InsuranceInputModel inputModel = Insurance.inputView.runInsuranceInputView();
	}
	
	public static void main(String[] args) {
		Insurance insurance = new Insurance();
		insurance.run();
	}
	
}
