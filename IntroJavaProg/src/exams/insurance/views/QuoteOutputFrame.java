package exams.insurance.views;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.RepaintManager;

public class QuoteOutputFrame implements Runnable, ActionListener, Printable {
	
	private String quoteOutput;
	private JFrame frame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton printButton;
	
	public QuoteOutputFrame(String quoteOutput) {
		this.quoteOutput = quoteOutput;
		
		this.textArea = new JTextArea(this.quoteOutput);
		this.scrollPane = new JScrollPane(this.textArea);
		this.textArea.setEditable(false);
		this.textArea.setFont(new Font("Lucidia Console", Font.PLAIN, 11));
		
		this.printButton = new JButton("Print");
		this.printButton.addActionListener(this);
		
		this.frame = new JFrame("Quote Output");
		this.frame.setLayout(new BoxLayout(this.frame.getContentPane(), BoxLayout.PAGE_AXIS));
		this.frame.getContentPane().add(this.scrollPane);
		this.frame.getContentPane().add(this.printButton);
	}

	@Override
	public void run() {
		this.frame.pack();
		this.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(this);
		if (printJob.printDialog()) {
			try { 
				printJob.print();
			} catch(PrinterException pe) {
				System.out.println("Error printing: " + pe);
			}
		}
	}

	@Override
	public int print(Graphics g, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		if (pageIndex > 0) {
			return (NO_SUCH_PAGE);
		} else {
			Graphics2D g2d = (Graphics2D) g;
			g2d.translate(pageFormat.getImageableX(),
					pageFormat.getImageableY());
			RepaintManager currentManager = RepaintManager.currentManager(this.textArea);
			currentManager.setDoubleBufferingEnabled(false);
			//this.textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 8));
			this.textArea.printAll(g);
			//this.textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
			currentManager.setDoubleBufferingEnabled(true);
			return (PAGE_EXISTS);
		}
	}
	
}
