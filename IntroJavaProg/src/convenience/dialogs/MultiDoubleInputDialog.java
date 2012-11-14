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

public class MultiDoubleInputDialog extends MultiInputDialog {
	
	// Instance Variables
	private ArrayList<Double> defaultValues = null;
	private ArrayList<Double> results = null;
	
	public List<Double> getDefaultValues() {
		return this.defaultValues;
	}
	
	public List<Double> getResults() {
		return this.results;
	}
	
	// Action Command Handlers
	
	@Override
	protected void dialogSubmitButtonActionHandler() {
		this.results = new ArrayList<Double>();
		Boolean valid = true;
		for (Integer index = 0; index < this.getInputLabels().size(); index++) {
			String inputTextField = this.getInputTextFieldText(index);
			
			if (inputTextField.length() != 0) {
				if (!(inputTextField.matches("-?\\d+(.\\d+)?"))) {
					valid = false;
					break;
				} else {
					this.results.add(Double.parseDouble(inputTextField));
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

	public MultiDoubleInputDialog(String title, String inputMessage, List<String> inputLabels, List<Double> defaultValues) {
		// Call superclass constructor
		super(title, inputMessage, inputLabels);
		
		// Initialize Instance Variables
		this.defaultValues = new ArrayList<Double>(defaultValues);
		this.results = new ArrayList<Double>();
	}
	
	@Override
	public void run() {
		// Call superclass method
		super.run();
	}
	
}