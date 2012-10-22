package convenience.dialog;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MultiDialog implements Runnable, WindowListener, ActionListener {
	
	// Instance Variables
	private String dialogTitle = "";
	private String dialogDescription = "";
	private String exitButtonText = "Exit";
	private String submitButtonText = "Submit";
	private ArrayList<MultiDialogGroup> dialogGroups = new ArrayList<MultiDialogGroup>();
	
	// Status Instance Variables
	private Boolean dialogIsRunning = false;
	private Boolean dialogIsSubmitted = false;
	
	// GUI Instance Variables
	private JFrame dialogFrame;
	private JPanel dialogPanel;
	private JLabel dialogDescriptionLabel;
	private JPanel dialogGroupsPanel;
	private JPanel dialogContentPanel;
	private JPanel dialogHeaderPanel;
	private JPanel dialogButtonsPanel;
	private JPanel dialogLeftButtonPanel;
	private JPanel dialogRightButtonPanel;
	private JButton dialogExitButton;
	private JButton dialogResetButton;
	private JButton dialogSubmitButton;
	
	// Action Command Constants
	private static String EXIT_BUTTON_ACTION_COMMAND = "com.nexgen.MultiDialog.Action.exitButton";
	private static String RESET_BUTTON_ACTION_COMMAND = "com.nexgen.MultiDialog.Action.resetButton";
	private static String SUBMIT_BUTTON_ACTION_COMMAND = "com.nexgen.MultiDialog.Action.submitButton";
	
	// Constants
	private static String DIALOG_RESET_BUTTON_TEXT = "Reset";
	
	public String getDialogTitle() {
		return this.dialogTitle;
	}
	
	public String getDialogDescription() {
		return this.dialogDescription;
	}
	
	public String getExitButtonText() {
		return this.exitButtonText;
	}
	
	public String getSubmitButtonText() {
		return this.submitButtonText;
	}
	
	public ArrayList<MultiDialogGroup> getDialogGroups() {
		return this.dialogGroups;
	}
	
	public void addDialogGroup(MultiDialogGroup dialogGroup) {
		this.dialogGroups.add(dialogGroup);
		this.dialogGroupsPanel.add(dialogGroup.getGroupPanel());
	}
	
	public MultiDialog(String dialogTitle, String dialogDescription, String exitButtonText, String submitButtonText) {
		// Set Instance Variables
		this.dialogTitle = dialogTitle;
		this.dialogDescription = dialogDescription;
		this.exitButtonText = exitButtonText;
		this.submitButtonText = submitButtonText;
		
		// Initialize GUI Instance Variables
		this.dialogFrame = new JFrame(this.dialogTitle);
		this.dialogPanel = new JPanel();
		this.dialogDescriptionLabel = new JLabel(this.dialogDescription);
		this.dialogHeaderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.dialogContentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.dialogGroupsPanel = new JPanel();
		this.dialogButtonsPanel = new JPanel();
		this.dialogLeftButtonPanel = new JPanel();
		this.dialogRightButtonPanel = new JPanel();
		this.dialogExitButton = new JButton(this.exitButtonText);
		this.dialogResetButton = new JButton(MultiDialog.DIALOG_RESET_BUTTON_TEXT);
		this.dialogSubmitButton = new JButton(this.submitButtonText);
		
		// Set Panel Layout Managers
		this.dialogLeftButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.dialogRightButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.dialogPanel.setLayout(new BoxLayout(this.dialogPanel, BoxLayout.Y_AXIS));
		this.dialogGroupsPanel.setLayout(new BoxLayout(this.dialogGroupsPanel, BoxLayout.Y_AXIS));
		this.dialogButtonsPanel.setLayout(new BoxLayout(this.dialogButtonsPanel, BoxLayout.X_AXIS));
		
		// Setup dialogFrame
		this.dialogFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.dialogFrame.addWindowListener(this);
		this.dialogFrame.setResizable(false);
		this.dialogFrame.getContentPane().add(this.dialogPanel);
		
		// Setup dialogExitButton
		this.dialogExitButton.addActionListener(this);
		this.dialogExitButton.setActionCommand(MultiDialog.EXIT_BUTTON_ACTION_COMMAND);
		this.dialogExitButton.setText(this.exitButtonText);
		
		// Setup dialogResetButton
		this.dialogResetButton.addActionListener(this);
		this.dialogResetButton.setActionCommand(MultiDialog.RESET_BUTTON_ACTION_COMMAND);
		
		// Setup dialogSubmitButton
		this.dialogSubmitButton.addActionListener(this);
		this.dialogSubmitButton.setActionCommand(MultiDialog.SUBMIT_BUTTON_ACTION_COMMAND);
		this.dialogSubmitButton.setText(this.submitButtonText);
		
		// Setup dialogButtonsPanel
		this.dialogButtonsPanel.add(this.dialogLeftButtonPanel);
		this.dialogButtonsPanel.add(this.dialogRightButtonPanel);
		this.dialogLeftButtonPanel.add(this.dialogExitButton);
		this.dialogLeftButtonPanel.add(this.dialogResetButton);
		this.dialogRightButtonPanel.add(this.dialogSubmitButton);
		
		// Setup dialogHeaderPanel
		Font dialogDescriptionLabelFont = this.dialogDescriptionLabel.getFont().deriveFont(Font.PLAIN, 12);
		this.dialogDescriptionLabel.setFont(dialogDescriptionLabelFont);
		this.dialogHeaderPanel.add(this.dialogDescriptionLabel);
		
		// Setup dialogContentPanel
		this.dialogContentPanel.add(this.dialogGroupsPanel);
		
		// Add panels to the dialogPanel
		this.dialogPanel.add(this.dialogHeaderPanel);
		this.dialogPanel.add(this.dialogContentPanel);
		this.dialogPanel.add(this.dialogButtonsPanel);
		
	}
	
	public MultiDialogResults runDialog(){
		try {
			SwingUtilities.invokeAndWait(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		this.dialogIsRunning = true;
		this.dialogIsSubmitted = false;
		while (this.dialogIsRunning) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		MultiDialogResults dialogResults;
		if (this.dialogIsSubmitted) {
			// TODO: Return MultiDialogResults to the user
			dialogResults = null;
		} else {
			dialogResults = null;
		}
		this.dialogIsSubmitted = false;
		return dialogResults;
	}
	
	private void closeDialog() {
		this.dialogIsRunning = false;
		this.dialogFrame.dispose();
	}
	
	private void submitDialog() {
		// TODO: Check that dialog is valid
		this.dialogIsSubmitted = true;
		this.closeDialog();
	}
	
	private void exitButtonAction() {
		this.closeDialog();
	}
	
	private void submitButtonAction() {
		this.submitDialog();
	}
	
	private void closeButtonAction() {
		this.closeDialog();
	}
	
	private void resetButtonAction() {
		this.resetDialogGroups();
	}
	
	private void runDialogGroups() {
		for (MultiDialogGroup dialogGroup: this.dialogGroups) {
			dialogGroup.run();
		}
	}
	
	private void resetDialogGroups() {
		for (MultiDialogGroup dialogGroup: this.dialogGroups) {
			dialogGroup.reset();
		}
	}
	
	private void layoutDialogGroups() {
		for (MultiDialogGroup dialogGroup: this.dialogGroups) {
			dialogGroup.layout();
		}
	}
	
	@Override
	public void run() {
		this.layoutDialogGroups();
		this.runDialogGroups();
		this.dialogFrame.pack();
		this.dialogFrame.setVisible(true);
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		this.closeButtonAction();
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals(MultiDialog.EXIT_BUTTON_ACTION_COMMAND)) {
			this.exitButtonAction();
		} else if (actionCommand.equals(MultiDialog.SUBMIT_BUTTON_ACTION_COMMAND)) {
			this.submitButtonAction();
		} else if (actionCommand.equals(MultiDialog.RESET_BUTTON_ACTION_COMMAND)) {
			this.resetButtonAction();
		} else {
			System.out.printf("WARNING: Unrecognized Action Command sent to MultiDialog (actionCommand = '%s'.) Ignoring Action Event", actionCommand);
		}
	}

	public static void main(String[] args) {
		MultiDialog md = new MultiDialog("This is the Dialog Title", "This is the dialog description text.", "Exit", "Submit");
		MultiDialogGroup mdg1 = new MultiDialogGroup("Group 1", "grp1", "This is Group 1's description text");
		md.addDialogGroup(mdg1);
		mdg1.addTextGroupEntry("Entry 1:", "entry1", "Entry Description Text", "HELLO");
		mdg1.addTextGroupEntry("Entry 2:", "entry2", "Entry Description Text", "HELLO");
		mdg1.addIntegerNumberGroupEntry("Entry 3:", "entry3", "Entry Description Text", "Prefix", "Sufix", 2);
		MultiDialogGroup mdg2 = new MultiDialogGroup("Group 2", "grp2", "This is Group 2's description text");
		md.addDialogGroup(mdg2);
		mdg2.addTextGroupEntry("Entry 1:", "entry1", "Entry Description Text", "HELLO");
		mdg2.addTextGroupEntry("Entry 2:", "entry2", "Entry Description Text", "HELLO");
		mdg2.addBooleanGroupEntry("Entry 3:", "entry3", "Entry Description Text", "True", "False", true);
		MultiDialogGroup mdg3 = new MultiDialogGroup("Group 3", "grp3", "This is Group 3's description text");
		md.addDialogGroup(mdg3);
		mdg3.addTextGroupEntry("Entry 1:", "entry1", "Entry Description Text", "HELLO");
		mdg3.addTextGroupEntry("Entry 2:", "entry2", "Entry Description Text", "HELLO");
		mdg3.addTextGroupEntry("Entry 3:", "entry3", "Entry Description Text", "HELLO");
		md.runDialog();
		JOptionPane.showMessageDialog(null, "Done!", "Message", JOptionPane.PLAIN_MESSAGE);
	}
	
}
