package convenience.dialog;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class MultiDialogEntry {
	
	// Instance Variables
	private String entryTitle = "";
	private String entryIdentifier = "";
	private String entryDescription = "";
	
	// GUI Instance Variables
	private JPanel entryTitlePanel;
	private JLabel entryTitleLabel;
	
	public String getEntryTitle() {
		return this.entryTitle;
	}
	
	public String getEntryIdentifier() {
		return this.entryIdentifier;
	}
	
	public String getEntryDescription() {
		return this.entryDescription;
	}
	
	public JPanel getEntryTitlePanel() {
		return this.entryTitlePanel;
	}
	
	public abstract JPanel getEntryValuePanel();
	
	public abstract void run();
	
	public abstract void reset();
	
	public void layout() {
		
	}
	
	public abstract Boolean valid();
	
	public abstract Object getValue();
	
	public MultiDialogEntry(String entryTitle, String entryIdentifier, String entryDescription) {
		// Initialize Instance Variables
		this.entryTitle = entryTitle;
		this.entryIdentifier = entryIdentifier;
		this.entryDescription = entryDescription;
		
		// Initialize GUI Instance Variables
		this.entryTitlePanel = new JPanel();
		this.entryTitleLabel = new JLabel(this.entryTitle);
		
		// Setup entryTitlePanel
		FlowLayout entryTitlePanelLayout = new FlowLayout(FlowLayout.RIGHT);
		entryTitlePanelLayout.setAlignOnBaseline(true);
		this.entryTitlePanel.setLayout(entryTitlePanelLayout);
		this.entryTitlePanel.add(this.entryTitleLabel);
		
		// Setup entryTitleLabel
		this.entryTitleLabel.setText(this.entryTitle);
	}
	
}
