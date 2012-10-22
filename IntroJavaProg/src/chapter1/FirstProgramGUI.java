package chapter1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FirstProgramGUI implements Runnable, ActionListener {
	
	private JFrame panel;
	private JLabel resultsLabel;
	private JTextField n1TextBox;
	private JTextField n2TextBox;
	private JButton calculateButton;
	private JComboBox operationComboBox;
	
	private static String[] OPERATION_COMBO_BOX_STRINGS = {"+", "-", "*", "/", "%", "^"};
	
	public void run() {
        this.panel = new JFrame ("Hello, World!");
        this.panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel.setLayout(new FlowLayout());
        
        this.n1TextBox = new JTextField("0");
        this.n1TextBox.setColumns(5);
        this.n1TextBox.addActionListener(this);
        this.panel.getContentPane().add(this.n1TextBox);
        
        this.operationComboBox = new JComboBox(OPERATION_COMBO_BOX_STRINGS);
        this.operationComboBox.setSelectedIndex(0);
        this.operationComboBox.addActionListener(this);
        this.panel.getContentPane().add(this.operationComboBox);
        
        this.n2TextBox = new JTextField("0");
        this.n2TextBox.setColumns(5);
        this.n2TextBox.addActionListener(this);
        this.panel.getContentPane().add(this.n2TextBox);
        
        this.resultsLabel = new JLabel("= 0");
        this.panel.getContentPane().add(this.resultsLabel);
        
        this.calculateButton = new JButton("Calculate");
        this.calculateButton.addActionListener(this);
        this.panel.getContentPane().add(this.calculateButton);
        
        this.panel.pack();
        this.panel.setVisible(true);
    }
 
    public static void main(String[] args) {
    	FirstProgramGUI fp = new FirstProgramGUI();
        SwingUtilities.invokeLater(fp);
    }
    
    private static Integer power(Integer a, Integer b) {
    	Integer product = 1;
    	for(Integer count = 0; count < b; count++) {
    		product *= a;
    	}
    	return product;
    }
    
    public void actionPerformed(ActionEvent e) {
    	Integer n1, n2;
    	try {
    		n1 = new Integer(this.n1TextBox.getText());
    		n2 = new Integer(this.n2TextBox.getText());
    		Integer result = 0;
    		switch(this.operationComboBox.getSelectedIndex()) {
    		case(0):
    			result = n1 + n2;
    			break;
    		case(1):
    			result = n1 - n2;
    			break;
    		case(2):
    			result = n1 * n2;
    			break;
    		case(3):
    			result = n1 / n2;
    			break;
    		case(4):
    			result = n1 % n2;
    			break;
    		case(5):
    			result = FirstProgramGUI.power(n1, n2);
    			break;
    		}
    		this.resultsLabel.setText("= " + result);
    	} catch(NumberFormatException numberFormatException) {
    		this.resultsLabel.setText("= Invalid");
    	} catch(ArithmeticException arithmeticException) {
    		this.resultsLabel.setText("= Invalid");
    	}
    	this.panel.pack();
    }

}
