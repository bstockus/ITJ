package convenience.dialog;

import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiDialogEntry_Text extends MultiDialogEntry implements FocusListener {
	
	// Instance Variables
	private String defaultValue;
	
	// GUI Instance Variables
	private JPanel entryValuePanel;
	private JTextField entryValueTextField;
	
	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	public MultiDialogEntry_Text(String entryTitle, String entryIdentifier, String entryDescription, String defaultValue) {
		// Call the superclass constructor
		super(entryTitle, entryIdentifier, entryDescription);
		
		// Set Instance Variables
		this.defaultValue = defaultValue;
		
		// Initialize GUI Instance Variables
		this.entryValueTextField = new JTextField(this.defaultValue);
		this.entryValuePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		// Setup entryValueTextField
		this.entryValueTextField.setColumns(30);
		this.entryValueTextField.setToolTipText(this.getEntryDescription());
		this.entryValueTextField.addFocusListener(this);
		
		// Setup entryValuePanel
		this.entryValuePanel.add(this.entryValueTextField);
	}
	
	@Override
	public JPanel getEntryValuePanel() {
		return this.entryValuePanel;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		this.entryValueTextField.selectAll();
		
	}
	
	@Override
	public void focusLost(FocusEvent arg0) {
		
	}

	@Override
	public void run() {
		this.entryValueTextField.setText(this.defaultValue);
	}

	@Override
	public Boolean valid() {
		
		return true;
	}

	@Override
	public Object getValue() {
		return (String)this.entryValueTextField.getText();
	}
	
	@Override
	public void reset() {
		this.entryValueTextField.setText(this.defaultValue);
	}
	
	@Override
	public void layout() {
		super.layout();
	}
	
}
