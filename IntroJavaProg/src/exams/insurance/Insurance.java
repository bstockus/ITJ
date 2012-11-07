package exams.insurance;

import exams.insurance.models.Quote;
import exams.insurance.views.ConsoleOutputView;
import exams.insurance.views.FormOutputView;
import exams.insurance.views.InputView;
import exams.insurance.views.OutputView;
import exams.insurance.views.PromptInputView;

public class Insurance {
	
	public static void main(String[] args) {
		InputView inputView = new PromptInputView();
		OutputView outputView = new FormOutputView();
		Quote quote = inputView.getQuote();
		outputView.displayOutputViewForQuote(quote);
	}
	
}