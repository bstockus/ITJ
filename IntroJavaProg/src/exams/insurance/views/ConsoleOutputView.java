package exams.insurance.views;

import exams.insurance.models.Quote;

public class ConsoleOutputView implements OutputView {

	@Override
	public void displayOutputViewForQuote(Quote quote) {
		System.out.print(QuoteOutputGenerator.generateOuputForQuote(quote, "\n"));
	}

}
