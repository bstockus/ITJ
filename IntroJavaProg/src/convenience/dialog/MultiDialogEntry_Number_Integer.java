package convenience.dialog;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiDialogEntry_Number_Integer extends MultiDialogEntry implements FocusListener {
	
	// Constants
	private static Integer ENTRY_VALUE_TEXT_FIELD_COLUMNS = 10;
	
	// Instance Variables
	private String prefixText = "";
	private String sufixText = "";
	private Integer defaultValue = 0;
	
	// GUI Instance Variables
	private JPanel entryValuePanel;
	private JLabel entryPrefixLabel;
	private JLabel entrySufixLabel;
	private JTextField entryValueTextField;
	
	public String getPrefixText() {
		return this.prefixText;
	}
	
	public String getSufixText() {
		return this.sufixText;
	}
	
	public MultiDialogEntry_Number_Integer(String entryTitle, String entryIdentifier, String entryDescription, 
			String prefixText, String sufixText, Integer defaultValue) {
		// Call the superclass constructor
		super(entryTitle, entryIdentifier, entryDescription);
		
		// Set Instance Variables
		this.prefixText = prefixText;
		this.sufixText = sufixText;
		this.defaultValue = defaultValue;
		
		// Initialize GUI Instance Variables
		this.entryValuePanel = new JPanel();
		this.entryPrefixLabel = new JLabel();
		this.entrySufixLabel = new JLabel();
		this.entryValueTextField = new JTextField();
		
		// Setup entryValuePanel
		FlowLayout entryValuePanelFlowLayout = new FlowLayout(FlowLayout.LEFT);
		entryValuePanelFlowLayout.setAlignOnBaseline(true);
		this.entryValuePanel.setLayout(entryValuePanelFlowLayout);
		
		// Create font
		Font entryLabelsFont = this.entryPrefixLabel.getFont().deriveFont(Font.PLAIN);
		
		// Setup entryPrefixLabel
		this.entryPrefixLabel.setText(this.prefixText);
		this.entryPrefixLabel.setFont(entryLabelsFont);
		this.entryValuePanel.add(this.entryPrefixLabel);
		
		// Setup entryValueTextField
		this.entryValueTextField.setText(this.defaultValue.toString());
		this.entryValueTextField.setColumns(MultiDialogEntry_Number_Integer.ENTRY_VALUE_TEXT_FIELD_COLUMNS);
		this.entryValueTextField.setHorizontalAlignment(JTextField.RIGHT);
		this.entryValueTextField.setToolTipText(this.getEntryDescription());
		this.entryValueTextField.addFocusListener(this);
		this.entryValuePanel.add(this.entryValueTextField);
		
		// Setup entrySufixLabel
		this.entrySufixLabel.setText(this.sufixText);
		this.entrySufixLabel.setFont(entryLabelsFont);
		this.entryValuePanel.add(this.entrySufixLabel);
		
	}
	
	@Override
	public JPanel getEntryValuePanel() {
		return this.entryValuePanel;
	}
	
	@Override
	public void run() {
		this.entryValueTextField.setText(this.defaultValue.toString());
	}
	
	@Override
	public Boolean valid() {
		return true;
	}
	
	@Override
	public Object getValue() {
		return (Integer)Integer.parseInt(this.entryValueTextField.getText());
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		this.entryValueTextField.selectAll();
	}
	
	@Override
	public void focusLost(FocusEvent arg0) {
		
	}
	
	@Override
	public void reset() {
		this.entryValueTextField.setText(this.defaultValue.toString());
	}
	
	@Override
	public void layout() {
		super.layout();
	}
	
}
