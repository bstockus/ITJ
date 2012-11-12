package exams.insurance.views;

import javax.swing.SwingUtilities;

import exams.insurance.models.Quote;

public class FormOutputView implements OutputView {
	
	@Override
	public void displayOutputViewForQuote(Quote quote) {
		QuoteOutputFrame quoteOutputFrame = new QuoteOutputFrame(QuoteOutputGenerator.generateOuputForQuote(quote, "\n"), 
				"<html><body><pre style=\'font-size:6pt; font-weight:normal\'>" + QuoteOutputGenerator.generateOuputForQuote(quote, "<br/>") + "</pre></body></html>");
		SwingUtilities.invokeLater(quoteOutputFrame);
	}

}
