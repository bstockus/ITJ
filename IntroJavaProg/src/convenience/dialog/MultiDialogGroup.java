package convenience.dialog;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MultiDialogGroup {
	
	// Instance Variables
	private String groupTitle = "";
	private String groupIdentifier = "";
	private String groupDescription = "";
	private ArrayList<MultiDialogEntry> groupEntries = new ArrayList<MultiDialogEntry>();
	
	// GUI Instance Variables
	private JPanel groupPanel;
	private JPanel groupDescriptionPanel;
	private JLabel groupDescriptionLabel;
	private JPanel groupEntriesPanel;
	private GroupLayout groupEntriesPanelLayout;
	
	public String getGroupTitle() {
		return this.groupTitle;
	}
	
	public String getGroupIdentifier() {
		return this.groupIdentifier;
	}
	
	public String getGroupDescription() {
		return this.groupDescription;
	}
	
	public ArrayList<MultiDialogEntry> getGroupEntries() {
		return this.groupEntries;
	}
	
	public void addGroupEntry(MultiDialogEntry groupEntry) {
		this.groupEntries.add(groupEntry);
		this.groupEntriesPanel.add(groupEntry.getEntryTitlePanel());
		this.groupEntriesPanel.add(groupEntry.getEntryValuePanel());
	}
	
	public void addTextGroupEntry(String entryTitle, String entryIdentifier, String entryDescription, String defaultValue) {
		this.addGroupEntry(new MultiDialogEntry_Text(entryTitle, entryIdentifier, entryDescription, defaultValue));
	}
	
	public void addIntegerNumberGroupEntry(String entryTitle, String entryIdentifier, String entryDescription, String prefixText,
			String sufixText, Integer defaultValue) {
		this.addGroupEntry(new MultiDialogEntry_Number_Integer(entryTitle, entryIdentifier, entryDescription, prefixText, sufixText,
				defaultValue));
	}
	
	public void addBooleanGroupEntry(String entryTitle, String entryIdentifier, String entryDescription,
			String trueText, String falseText, Boolean defaultValue) {
		this.addGroupEntry(new MultiDialogEntry_Boolean(entryTitle, entryIdentifier, entryDescription,
				trueText, falseText, defaultValue));
	}

	public JPanel getGroupPanel() {
		return this.groupPanel;
	}

	public MultiDialogGroup(String groupTitle, String groupIdentifier, String groupDescription) {
		// Set Instance Variables
		this.groupTitle = groupTitle;
		this.groupIdentifier = groupIdentifier;
		this.groupDescription = groupDescription;
		
		// Initialize GUI Instance Variables
		this.groupPanel = new JPanel();
		this.groupDescriptionPanel = new JPanel();
		this.groupDescriptionLabel = new JLabel(this.groupDescription);
		this.groupEntriesPanel = new JPanel();
		
		
		// Setup groupDescriptionPanel
		this.groupDescriptionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		Font groupDescriptionLabelFont = this.groupEntriesPanel.getFont().deriveFont(Font.PLAIN, 10);
		this.groupDescriptionLabel.setFont(groupDescriptionLabelFont);
		this.groupPanel.add(this.groupDescriptionLabel);
		
		// Setup groupPanel
		this.groupPanel.setLayout(new BoxLayout(this.groupPanel, BoxLayout.Y_AXIS));
		Font groupPanelTitleFont = this.groupEntriesPanel.getFont().deriveFont(Font.BOLD, 16);
		this.groupPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), 
				this.groupTitle, TitledBorder.LEFT, TitledBorder.TOP, groupPanelTitleFont));
		
		// Setup groupEntriesPanelLayout
		
		// Setup groupEntriesPanel
		this.groupPanel.add(this.groupEntriesPanel);
	}
	
	public void run() {
		for (MultiDialogEntry groupEntry: this.groupEntries) {
			groupEntry.run();
		}
	}
	
	public void reset() {
		for (MultiDialogEntry groupEntry: this.groupEntries) {
			groupEntry.reset();
		}
	}
	
	public void layout() {
		// Layout Group: Create Layout Manager
		this.groupEntriesPanelLayout = new GroupLayout(this.groupEntriesPanel);
		this.groupEntriesPanelLayout.setAutoCreateGaps(true);
		this.groupEntriesPanelLayout.setAutoCreateContainerGaps(true);
		this.groupEntriesPanel.setLayout(this.groupEntriesPanelLayout);
		
		// Layout Group: Horizantial Layout
		GroupLayout.ParallelGroup entryTitleHorizantialGroup = this.groupEntriesPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING);
		GroupLayout.ParallelGroup entryValueHorizantialGroup = this.groupEntriesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
		for (MultiDialogEntry groupEntry: this.groupEntries) {
			entryTitleHorizantialGroup.addComponent(groupEntry.getEntryTitlePanel());
			entryValueHorizantialGroup.addComponent(groupEntry.getEntryValuePanel());
		}
		GroupLayout.SequentialGroup entryHorizantialGroup = this.groupEntriesPanelLayout.createSequentialGroup();
		entryHorizantialGroup.addGroup(entryTitleHorizantialGroup);
		entryHorizantialGroup.addGroup(entryValueHorizantialGroup);
		this.groupEntriesPanelLayout.setHorizontalGroup(entryHorizantialGroup);
		
		// Layout Group: Vertical Layout
		GroupLayout.SequentialGroup entryVerticalGroup = this.groupEntriesPanelLayout.createSequentialGroup();
		for (MultiDialogEntry groupEntry: this.groupEntries) {
			GroupLayout.ParallelGroup entryGroup = this.groupEntriesPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);
			entryGroup.addComponent(groupEntry.getEntryTitlePanel());
			entryGroup.addComponent(groupEntry.getEntryValuePanel());
			entryVerticalGroup.addGroup(entryGroup);
		}
		this.groupEntriesPanelLayout.setVerticalGroup(entryVerticalGroup);
		
		// Layout Entries
		for (MultiDialogEntry groupEntry: this.groupEntries) {
			groupEntry.layout();
		}
	}
	
}
