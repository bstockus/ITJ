/*
 *  (c) Copyright 2012, Bryan Stockus
 *  	Bryan Stockus <bstockus@gmail.com>
 *  
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 3 as
 *  published by the Free Software Foundation.
 */

package convenience.dialogs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class MultiInputDialog implements Runnable, ActionListener, WindowListener, FocusListener {
	
	// Constants
	private static final String DIALOG_SUBMIT_BUTTON_TEXT = "Submit";
	private static final String DIALOG_SUBMIT_BUTTON_ACTION_COMMAND = "dialogSubmitButtonActionCommand";
	private static final String DIALOG_INPUT_TEXT_FIELD_ACTION_COMMAND = "dialogInputTextFieldActionCommand";
	private static final Integer DIALOG_MAXIMUM_FRAME_SIZE_HEIGHT = 600;
	
	// Instance Variables
	private String title = "";
	private String inputMessage = "";
	private ArrayList<String> inputLabels = null;
	private Boolean running = false;
	
	public String getTitle() {
		return this.title;
	}
	
	public String getInputMessage() {
		return this.inputMessage;
	}
	
	public List<String> getInputLabels() {
		return this.inputLabels;
	}
	
	public Boolean isRunning() {
		return this.running;
	}
	
	// GUI Variables
	private JFrame dialogFrame;
	private JLabel dialogInputMessageLabel;
	private JButton dialogSubmitButton;
	private JPanel dialogInputPanel;
	private JScrollPane dialogInputScrollPane;
	private ArrayList<JTextField> dialogInputTextFields;
	private ArrayList<JLabel> dialogInputLabels;
	
	protected String getInputTextFieldText(Integer index) {
		return this.dialogInputTextFields.get(index).getText();
	}
	
	// Action Command Handlers
	
	protected void dialogSubmitButtonActionHandler() {
		this.dialogFrame.dispose();
		this.running = false;
	}
	
	public MultiInputDialog(String title, String inputMessage, List<String> inputLabels) {
		// Initialize Instance Variables
		this.title = title;
		this.inputMessage = inputMessage;
		this.inputLabels = new ArrayList<String>(inputLabels);
		this.running = false;
		
		// Initialize GUI Variables
		this.dialogFrame = new JFrame();
		this.dialogInputMessageLabel = new JLabel();
		this.dialogSubmitButton = new JButton();
		this.dialogInputTextFields = new ArrayList<JTextField>();
		this.dialogInputLabels = new ArrayList<JLabel>();
		this.dialogInputPanel = new JPanel();
		
		// Setup dialogInputTextFields and dialogInputLabels
		for (String inputLabel: inputLabels) {
			JLabel dialogInputLabel = new JLabel();
			JTextField dialogInputTextField = new JTextField();
			dialogInputTextField.setColumns(20);
			dialogInputTextField.setActionCommand(MultiInputDialog.DIALOG_INPUT_TEXT_FIELD_ACTION_COMMAND);
			dialogInputTextField.addActionListener(this);
			dialogInputLabel.setText(inputLabel);
			this.dialogInputTextFields.add(dialogInputTextField);
			this.dialogInputLabels.add(dialogInputLabel);
			this.dialogInputPanel.add(dialogInputLabel);
			this.dialogInputPanel.add(dialogInputTextField);
		}
					
		// Setup dialogInputMessageLabels
		this.dialogInputMessageLabel.setText(inputMessage);
		this.dialogFrame.getContentPane().add(this.dialogInputMessageLabel);
		
		// Setup dialogSubmitButton
		this.dialogSubmitButton.setText(MultiInputDialog.DIALOG_SUBMIT_BUTTON_TEXT);
		this.dialogSubmitButton.addActionListener(this);
		this.dialogSubmitButton.setActionCommand(MultiInputDialog.DIALOG_SUBMIT_BUTTON_ACTION_COMMAND);
		this.dialogFrame.getContentPane().add(this.dialogSubmitButton);
		
		// Setup dialogFrame
		this.dialogFrame.setTitle(title);
		this.dialogFrame.addWindowListener(this);
		this.dialogFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		// Setup dialogInputPanel
		
		
		// Setup dialogInputScrollPane
		this.dialogInputScrollPane = new JScrollPane(this.dialogInputPanel);
		this.dialogInputScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.dialogFrame.getContentPane().add(this.dialogInputScrollPane);
		
		// Layout dialogInputPanel
		GroupLayout dialogInputPanelGroupLayout = new GroupLayout(this.dialogInputPanel);
		dialogInputPanelGroupLayout.setAutoCreateContainerGaps(true);
		GroupLayout.ParallelGroup dialogInputPanelHorizantialLayout = dialogInputPanelGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
		GroupLayout.SequentialGroup dialogInputPanelSequentialLayout = dialogInputPanelGroupLayout.createSequentialGroup();
		JTextField firstTextField = null;
		JLabel firstLabel = null;
		for (Integer index = 0; index < this.dialogInputLabels.size(); index++) {
			JTextField dialogInputTextField = this.dialogInputTextFields.get(index);
			JLabel dialogInputLabel = this.dialogInputLabels.get(index);
			GroupLayout.SequentialGroup dialogInputSequentialGroup = dialogInputPanelGroupLayout.createSequentialGroup();
			dialogInputSequentialGroup.addComponent(dialogInputLabel);
			dialogInputSequentialGroup.addComponent(dialogInputTextField);
			dialogInputSequentialGroup.addGap(20);
			GroupLayout.ParallelGroup dialogInputParallelGroup = 
					dialogInputPanelGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);
			dialogInputParallelGroup.addComponent(dialogInputLabel);
			dialogInputParallelGroup.addComponent(dialogInputTextField);
			dialogInputPanelHorizantialLayout.addGroup(dialogInputSequentialGroup);
			dialogInputPanelSequentialLayout.addGroup(dialogInputParallelGroup);
			if (firstTextField != null) {
				dialogInputPanelGroupLayout.linkSize(SwingConstants.HORIZONTAL, firstTextField, dialogInputTextField);
			} else {
				firstTextField = dialogInputTextField;
			}
			if (firstLabel != null) {
				dialogInputPanelGroupLayout.linkSize(SwingConstants.HORIZONTAL, firstLabel, dialogInputLabel);
			} else {
				firstLabel = dialogInputLabel;
			}
		}
		dialogInputPanelGroupLayout.setHorizontalGroup(dialogInputPanelHorizantialLayout);
		dialogInputPanelGroupLayout.setVerticalGroup(dialogInputPanelSequentialLayout);
		this.dialogInputPanel.setLayout(dialogInputPanelGroupLayout);
		
		// Layout dialogFrame
		GroupLayout dialogFrameGroupLayout = new GroupLayout(this.dialogFrame.getContentPane());
		dialogFrameGroupLayout.setAutoCreateContainerGaps(true);
		GroupLayout.ParallelGroup dialogFrameGroupHorizantialLayout = 
				dialogFrameGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
		GroupLayout.SequentialGroup dialogFrameGroupVerticalLayout = dialogFrameGroupLayout.createSequentialGroup();
		dialogFrameGroupHorizantialLayout.addComponent(this.dialogInputMessageLabel);
		dialogFrameGroupVerticalLayout.addComponent(this.dialogInputMessageLabel);
		dialogFrameGroupVerticalLayout.addGap(10);
	
		dialogFrameGroupVerticalLayout.addComponent(this.dialogInputScrollPane);
		dialogFrameGroupHorizantialLayout.addComponent(this.dialogInputScrollPane);
		
		dialogFrameGroupVerticalLayout.addGap(10);
		dialogFrameGroupHorizantialLayout.addComponent(this.dialogSubmitButton, GroupLayout.Alignment.TRAILING);
		dialogFrameGroupVerticalLayout.addComponent(this.dialogSubmitButton);
		dialogFrameGroupLayout.setHorizontalGroup(dialogFrameGroupHorizantialLayout);
		dialogFrameGroupLayout.setVerticalGroup(dialogFrameGroupVerticalLayout);
		this.dialogFrame.getContentPane().setLayout(dialogFrameGroupLayout);
	}
	
	public abstract String getInitialValueForFieldAtIndex(Integer index);
	
	public abstract Boolean isValidForFieldAtIndex(Integer index);
	
	@Override
	public void run() {
		// Set dialogInputTextFields to default value
		Integer index = 0;
		for (JTextField dialogInputTextField: this.dialogInputTextFields) {
			dialogInputTextField.setText(this.getInitialValueForFieldAtIndex(index ++));
		}
		
		// Set status as running
		this.running = true;
		
		// Display dialogFrame
		this.dialogFrame.pack();
		Dimension frameSize = this.dialogFrame.getSize(null);
		if (frameSize.height > MultiInputDialog.DIALOG_MAXIMUM_FRAME_SIZE_HEIGHT) {
			this.dialogFrame.setSize(new Dimension(frameSize.width, MultiInputDialog.DIALOG_MAXIMUM_FRAME_SIZE_HEIGHT));
		}
		this.dialogFrame.setLocationRelativeTo(null);
		this.dialogFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String actionCommand = actionEvent.getActionCommand();
		if (actionCommand.equals(MultiInputDialog.DIALOG_SUBMIT_BUTTON_ACTION_COMMAND)) {
			this.dialogSubmitButtonActionHandler();
		} else if (actionCommand.equals(MultiInputDialog.DIALOG_INPUT_TEXT_FIELD_ACTION_COMMAND)) {
			this.dialogSubmitButtonActionHandler();
		} else {
			System.out.println("ERROR: Unrecognized action command sent!");
		}
	}
	
	@Override
	public void windowActivated(WindowEvent windowEvent) {
		
	}

	@Override
	public void windowClosed(WindowEvent windowEvent) {
		
	}

	@Override
	public void windowClosing(WindowEvent windowEvent) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent windowEvent) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent windowEvent) {
		
	}

	@Override
	public void windowIconified(WindowEvent windowEvent) {
		
	}

	@Override
	public void windowOpened(WindowEvent windowEvent) {
		
	}
	
	@Override
	public void focusGained(FocusEvent focusEvent) {
		
	}

	@Override
	public void focusLost(FocusEvent focusEvent) {
		
	}
	
}
