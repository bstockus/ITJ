package convenience.dialog;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MultiDialogEntry_Boolean extends MultiDialogEntry {
	
	// Instance Variables
	private String trueText = "";
	private String falseText = "";
	private Boolean defaultValue = true;
	
	// GUI Instance Variables
	private JPanel entryValuePanel;
	private JRadioButton entryTrueRadioButton;
	private JRadioButton entryFalseRadioButton;
	private ButtonGroup entryButtonGroup;
	
	public String getTrueText() {
		return this.trueText;
	}
	
	public String getFalseText() {
		return this.falseText;
	}
	
	public Boolean getDefaultValue() {
		return this.defaultValue;
	}
	
	public MultiDialogEntry_Boolean(String entryTitle, String entryIdentifier,
			String entryDescription, String trueText, String falseText, Boolean defaultValue) {
		// Call the superclass constructor
		super(entryTitle, entryIdentifier, entryDescription);
		
		// Set Instance Variables
		this.trueText = trueText;
		this.falseText = falseText;
		this.defaultValue = defaultValue;
		
		// Initialize GUI Instance Variables
		this.entryValuePanel = new JPanel();
		this.entryTrueRadioButton = new JRadioButton(this.getTrueText());
		this.entryFalseRadioButton = new JRadioButton(this.getFalseText());
		this.entryButtonGroup = new ButtonGroup();
		
		// Initialize entryTrueRadioButton
		this.entryButtonGroup.add(this.entryTrueRadioButton);
		
		// Initialize entryFalseRadioButton
		this.entryButtonGroup.add(this.entryFalseRadioButton);
		
		// Initialize entryValuePanel
		FlowLayout entryValuePanelFlowLayout = new FlowLayout(FlowLayout.LEFT);
		entryValuePanelFlowLayout.setAlignOnBaseline(true);
		this.entryValuePanel.setLayout(entryValuePanelFlowLayout);
		this.entryValuePanel.add(this.entryTrueRadioButton);
		this.entryValuePanel.add(this.entryFalseRadioButton);
	}

	@Override
	public JPanel getEntryValuePanel() {
		return this.entryValuePanel;
	}

	@Override
	public void run() {
		if (this.getDefaultValue()) {
			this.entryTrueRadioButton.setSelected(true);
		} else {
			this.entryFalseRadioButton.setSelected(true);
		}
	}

	@Override
	public void reset() {
		if (this.getDefaultValue()) {
			this.entryTrueRadioButton.setSelected(true);
		} else {
			this.entryFalseRadioButton.setSelected(true);
		}
	}

	@Override
	public Boolean valid() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValue() {
		if (this.entryTrueRadioButton.isSelected()) {
			return true;
		} else {
			return false;
		}
	}
}
