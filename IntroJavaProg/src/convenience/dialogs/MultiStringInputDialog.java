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

public class MultiStringInputDialog extends MultiInputDialog {
	
	// Instance Variables
	private Boolean emptyInputAllowed = true;
	private ArrayList<String> results = null;
	
	public Boolean isEmptyInputAllowed() {
		return this.emptyInputAllowed;
	}
	
	public List<String> getResults() {
		return this.results;
	}
	
	// Action Command Handlers
	
	@Override
	protected void dialogSubmitButtonActionHandler() {
		if (this.isEmptyInputAllowed()) {
			this.generateResults();
			super.dialogSubmitButtonActionHandler();
		} else {
			Boolean valid = true;
			for (Integer index = 0; index < this.getInputLabels().size(); index++) {
				if (this.getInputTextFieldText(index).length() == 0) {
					valid = false;
					break;
				}
			}
			if (valid) {
				this.generateResults();
				super.dialogSubmitButtonActionHandler();
			} else {
				Dialogs.displayErrorDialog("INPUT ERROR", "No fields may be empty!");
			}
		}
	}
	
	private void generateResults() {
		for (Integer index = 0; index < this.getInputLabels().size(); index++) {
			this.results.add(this.getInputTextFieldText(index));
		}
	}
	
	public MultiStringInputDialog(String title, String inputMessage, List<String> inputLabels, Boolean emptyInputAllowed) {
		// Call superclass constructor
		super(title, inputMessage, inputLabels);
		
		// Initialize Instance Variables
		this.emptyInputAllowed = emptyInputAllowed;
		this.results = new ArrayList<String>();
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