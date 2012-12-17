package demos.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PayrollDemo extends JFrame implements  ActionListener, CaretListener // inherits from the JFrame class
{
	// static variables to hold frame dimensions in pixels
	private static final int WIDTH = 450;
	private static final int HEIGHT = 250;
	
	private static final Color INVALID_FOREGROUND_COLOR = Color.WHITE;
	private static final Color INVALID_BACKGROUND_COLOR = Color.RED;
	private static final Color VALID_FOREGROUND_COLOR = Color.BLACK;
	private static final Color VALID_BACKGROUND_COLOR = Color.WHITE;

	private JLabel nameLabel, hoursLabel, wageLabel, earningsLable,
			taxRateLabel, taxLabel, netEarningsLabel;
	private JTextField nameTextField, hoursTextField, wageTextField,
			earningsTextField, taxRateTextField, taxTextField,
			netEarningsTextField;
	private JButton calculateB, clearB;
	
	private Boolean nameValid = false;
	private Boolean hoursValid = false;
	private Boolean wageValid = false;
	
	public PayrollDemo() // constructor method defines frame
	{
		setTitle("Payroll"); // set the title of the frame
		setSize(WIDTH, HEIGHT); // set the frame size

		// prepare the container
		Container pane = getContentPane(); // get content pane
		GridLayout aGrid = new GridLayout(8, 2); // create a 8-row, 2-column
													// layout
		FlowLayout flowRight = new FlowLayout(FlowLayout.RIGHT); // for buttons

		// instantiate JLabel objects
		nameLabel = new JLabel("Enter name:", SwingConstants.RIGHT);
		hoursLabel = new JLabel("Enter hours worked:", SwingConstants.RIGHT);
		wageLabel = new JLabel("Enter hourly wage: $", SwingConstants.RIGHT);
		earningsLable = new JLabel("Total earnings: $", SwingConstants.RIGHT);
		taxRateLabel = new JLabel("Tax rate:", SwingConstants.RIGHT);
		taxLabel = new JLabel("Total tax: $", SwingConstants.RIGHT);
		netEarningsLabel = new JLabel("Net earnings: $", SwingConstants.RIGHT);

		// instantiate JTextField objects
		nameTextField = new JTextField(30);
		hoursTextField = new JTextField(5);
		wageTextField = new JTextField(8);
		earningsTextField = new JTextField(10);
		taxRateTextField = new JTextField(8);
		taxTextField = new JTextField(10);
		netEarningsTextField = new JTextField(10);
		
		// Setup Listeners
		

		// instantiate buttons and register handlers
		calculateB = new JButton("Calculate");
		calculateB.addActionListener(this);

		clearB = new JButton("Clear");
		clearB.addActionListener(this);

		// create panels
		JPanel dataPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		// set layouts for panels
		dataPanel.setLayout(aGrid);
		buttonPanel.setLayout(flowRight);

		// add labels and text fields to panel
		dataPanel.add(nameLabel);
		dataPanel.add(nameTextField);
		dataPanel.add(hoursLabel);
		dataPanel.add(hoursTextField);
		dataPanel.add(wageLabel);
		dataPanel.add(wageTextField);
		dataPanel.add(earningsLable);
		dataPanel.add(earningsTextField);
		dataPanel.add(taxRateLabel);
		dataPanel.add(taxRateTextField);
		dataPanel.add(taxLabel);
		dataPanel.add(taxTextField);
		dataPanel.add(netEarningsLabel);
		dataPanel.add(netEarningsTextField);

		// add buttons to panel
		buttonPanel.add(calculateB);
		buttonPanel.add(clearB);

		// add panels to content pane using BorderLayout
		pane.add(dataPanel, BorderLayout.NORTH);
		pane.add(buttonPanel, BorderLayout.SOUTH);
		
		// Set text fields as invalid
		this.updateValidity();
		
		// Setup TextField Caret and Action Listeners
		this.nameTextField.addActionListener(this);
		this.nameTextField.addCaretListener(this);
		this.hoursTextField.addActionListener(this);
		this.hoursTextField.addCaretListener(this);
		this.wageTextField.addActionListener(this);
		this.wageTextField.addCaretListener(this);

	} // end constructor

	public static void main(String[] args) // declare main method
	{
		JFrame aPayrollWithGUI = new PayrollDemo(); // create the frame object
		aPayrollWithGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aPayrollWithGUI.setVisible(true); // display the frame

	} // end main
	
	public void updateValidity() {
		// Check For Name Field Validity
		if (this.nameTextField.getText().length() > 0) {
			this.nameValid = true;
			this.setTextFieldToValid(this.nameTextField);
		} else {
			this.nameValid = false;
			this.setTextFieldToInvalid(this.nameTextField);
		}
		
		// Check For Hours Field Validity
		String hoursText = this.hoursTextField.getText();
		if ((hoursText.length() > 0) && (hoursText.matches("-?\\d+(.\\d+)?"))) {
			this.hoursValid = true;
			this.setTextFieldToValid(this.hoursTextField);
		} else {
			this.hoursValid = false;
			this.setTextFieldToInvalid(this.hoursTextField);
		}
		
		// Check For Wage Validity
		String wageText = this.wageTextField.getText();
		if ((wageText.length() > 0) && (wageText.matches("-?\\d+(.\\d+)?"))) {
			this.wageValid = true;
			this.setTextFieldToValid(this.wageTextField);
		} else {
			this.wageValid = false;
			this.setTextFieldToInvalid(this.wageTextField);
		}
		
		// Set Calculate Button Validity Status
		if ((this.nameValid) && (this.hoursValid) && (this.wageValid)) {
			this.calculateB.setEnabled(true);
		} else {
			this.calculateB.setEnabled(false);
		}
	}
	
	private void setTextFieldToValid(JTextField textField) {
		textField.setForeground(PayrollDemo.VALID_FOREGROUND_COLOR);
		textField.setBackground(PayrollDemo.VALID_BACKGROUND_COLOR);
	}
	
	private void setTextFieldToInvalid(JTextField textField) {
		textField.setForeground(PayrollDemo.INVALID_FOREGROUND_COLOR);
		textField.setBackground(PayrollDemo.INVALID_BACKGROUND_COLOR);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.clearB) {
			nameTextField.setText("");
			hoursTextField.setText("");
			wageTextField.setText("");
			earningsTextField.setText("");
			taxRateTextField.setText("");
			taxTextField.setText("");
			netEarningsTextField.setText("");
			this.updateValidity();
		} else if ((e.getSource() == this.calculateB) && (this.nameValid) && (this.hoursValid) && (this.wageValid)) {
			double empHours, hourlyWage;
			final double TAX_RATE = .15; // tax is 15%, a named constant
			String taxRateStr = Double.toString(TAX_RATE);
			String grossEarningsStr, taxStr, netEarningsStr;

			// get data from text fields
			empHours = Double.parseDouble(hoursTextField.getText());
			hourlyWage = Double.parseDouble(wageTextField.getText());

			// calculations
			grossEarningsStr = Double.toString(empHours * hourlyWage);
			taxStr = Double.toString(empHours * hourlyWage * TAX_RATE);
			netEarningsStr = Double.toString(empHours * hourlyWage
					* (1 - TAX_RATE));

			earningsTextField.setText(grossEarningsStr);
			taxRateTextField.setText(taxRateStr);
			taxTextField.setText(taxStr);
			netEarningsTextField.setText(netEarningsStr);
		} else {
			this.updateValidity();
		}
		
	}

	@Override
	public void caretUpdate(CaretEvent arg0) {
		this.updateValidity();		
	}

} // end class
