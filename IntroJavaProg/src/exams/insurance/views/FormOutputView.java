package exams.insurance.views;

import javax.swing.SwingUtilities;

import exams.insurance.models.Quote;

public class FormOutputView implements OutputView {
	
	@Override
	public void displayOutputViewForQuote(Quote quote) {
		QuoteOutputFrame quoteOutputFrame = new QuoteOutputFrame(QuoteOutputGenerator.generateOuputForQuote(quote, "\n"));
		SwingUtilities.invokeLater(quoteOutputFrame);
	}

}
