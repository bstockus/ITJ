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

public class MultiIntegerInputDialog extends MultiInputDialog {
	
	// Instance Variables
	private ArrayList<Integer> defaultValues = null;
	private ArrayList<Integer> results = null;
	
	public List<Integer> getDefaultValues() {
		return this.defaultValues;
	}
	
	public List<Integer> getResults() {
		return this.results;
	}
	
	// Action Command Handlers
	
	@Override
	protected void dialogSubmitButtonActionHandler() {
		this.results = new ArrayList<Integer>();
		Boolean valid = true;
		for (Integer index = 0; index < this.getInputLabels().size(); index++) {
			String inputTextField = this.getInputTextFieldText(index);
			
			if (inputTextField.length() != 0) {
				if (!(inputTextField.matches("-?\\d+(.\\d+)?"))) {
					valid = false;
					break;
				} else {
					this.results.add(Integer.parseInt(inputTextField));
				}
			} else {
				this.results.add(this.getDefaultValues().get(index));
			}
		}
		if (valid) {
			super.dialogSubmitButtonActionHandler();
		} else {
			Dialogs.displayErrorDialog("INPUT ERROR", "You must enter a valid Integer!");
		}
	}

	public MultiIntegerInputDialog(String title, String inputMessage, List<String> inputLabels, List<Integer> defaultValues) {
		// Call superclass constructor
		super(title, inputMessage, inputLabels);
		
		// Initialize Instance Variables
		this.defaultValues = new ArrayList<Integer>(defaultValues);
		this.results = new ArrayList<Integer>();
	}
	
	@Override
	public void run() {
		// Call superclass method
		super.run();
	}

	@Override
	public String getInitialValueForFieldAtIndex(Integer index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isValidForFieldAtIndex(Integer index) {
		// TODO Auto-generated method stub
		return null;
	}
	
}