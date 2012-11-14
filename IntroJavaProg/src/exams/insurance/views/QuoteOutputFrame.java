package exams.insurance.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.RepaintManager;

import convenience.dialogs.Dialogs;

public class QuoteOutputFrame implements Runnable, ActionListener, Printable {
	
	private static String PRINT_BUTTON_ACTION_COMMAND = "print";
	private static String EXIT_BUTTON_ACTION_COMMAND = "exit";
	private static String SAVE_BUTTON_ACTION_COMMAND = "save";
	
	private String quoteOutput;
	private String quotePrintOutput;
	private JFrame frame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton printButton;
	private JButton exitButton;
	private JButton saveButton;
	
	public QuoteOutputFrame(String quoteOutput, String quotePrintOutput) {
		GraphicsEnvironment.getLocalGraphicsEnvironment().preferProportionalFonts();
		
		this.quoteOutput = quoteOutput;
		this.quotePrintOutput = quotePrintOutput;
		
		this.textArea = new JTextArea(this.quoteOutput);
		this.scrollPane = new JScrollPane(this.textArea);
		this.textArea.setEditable(false);
		this.textArea.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 11));
		
		this.printButton = new JButton("Print");
		this.printButton.setActionCommand(QuoteOutputFrame.PRINT_BUTTON_ACTION_COMMAND);
		this.printButton.addActionListener(this);
		
		this.exitButton = new JButton("Exit");
		this.exitButton.setActionCommand(QuoteOutputFrame.EXIT_BUTTON_ACTION_COMMAND);
		this.exitButton.addActionListener(this);
		
		this.saveButton = new JButton("Save");
		this.saveButton.setActionCommand(QuoteOutputFrame.SAVE_BUTTON_ACTION_COMMAND);
		this.saveButton.addActionListener(this);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		buttonsPanel.add(this.exitButton);
		buttonsPanel.add(this.printButton);
		buttonsPanel.add(this.saveButton);
		
		this.frame = new JFrame("Quote Output");
		this.frame.setLayout(new BoxLayout(this.frame.getContentPane(), BoxLayout.PAGE_AXIS));
		this.frame.getContentPane().add(this.scrollPane);
		this.frame.getContentPane().add(buttonsPanel);
	}

	@Override
	public void run() {
		this.frame.pack();
		this.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String actionCommand = actionEvent.getActionCommand();
		if (actionCommand.equals(QuoteOutputFrame.PRINT_BUTTON_ACTION_COMMAND)) {
			this.actionPerformedOnPrintButton();
		} else if (actionCommand.equals(QuoteOutputFrame.EXIT_BUTTON_ACTION_COMMAND)) {
			this.actionPerformedOnExitButton();
		} else if (actionCommand.equals(QuoteOutputFrame.SAVE_BUTTON_ACTION_COMMAND)) {
			this.actionPerformedOnSaveButton();
		}
		
	}
	
	private void actionPerformedOnPrintButton() {
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
	
	private void actionPerformedOnExitButton() {
		System.exit(0);
	}
	
	private void actionPerformedOnSaveButton() {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				file.createNewFile();
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(this.quotePrintOutput);
				fileWriter.close();
			} catch (IOException e) {
				Dialogs.displayErrorDialog("I/O Error", "An I/O Exception has occurued while trying to save this file. \nTerminating save operation.");
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
			JFrame printFrame = new JFrame();
			JLabel printLabel = new JLabel(this.quotePrintOutput);
			printFrame.getContentPane().add(printLabel);
			printFrame.getContentPane().setBackground(Color.WHITE);
			printFrame.pack();
			printFrame.setVisible(true);
			printLabel.printAll(g2d);
			printFrame.setVisible(false);
			currentManager.setDoubleBufferingEnabled(true);
			return (PAGE_EXISTS);
		}
	}
	
}
