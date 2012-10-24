package chapter5.assignment12;

import java.util.ArrayList;
import java.util.List;

import convenience.dialogs.Dialogs;


public class TutorialMenu implements Runnable {
	
	// Instance Variables
	private String menuTitle = "";
	private String menuDescription = "";
	private ArrayList<String> menuEntryTitles = null;
	private ArrayList<Runnable> menuEntryRunnables = null;
	private TutorialMenuDelegate menuDelegate = null;
	
	public String getMenuTitle() {
		return this.menuTitle;
	}
	
	public String getMenuDescription() {
		return this.menuDescription;
	}
	
	public List<String> getMenuEntryTitles() {
		return this.menuEntryTitles;
	}
	
	public List<Runnable> getMenuEntryRunnables() {
		return this.menuEntryRunnables;
	}
	
	public TutorialMenuDelegate getMenuDelegate() {
		return this.menuDelegate;
	}
	
	// Delegate Methods
	
	private void tellDelegateTutorialMenuWillSelectItem(Integer selectionIndex) {
		if (this.getMenuDelegate() != null) {
			this.getMenuDelegate().tutorialMenuWillSelectItem(this, selectionIndex);
		}
	}
	
	private void tellDelegateTutorialMenuDidSelectItem(Integer selectionIndex) {
		if (this.getMenuDelegate() != null) {
			this.getMenuDelegate().tutorialMenuDidSelectItem(this, selectionIndex);
		}
	}
	
	private void tellDelegateTutorialMenuWillExit() {
		if (this.getMenuDelegate() != null) {
			this.getMenuDelegate().tutorialMenuWillExit(this);
		}
	}
	
	public TutorialMenu(String menuTitle, String menuDescription, List<String> menuEntryTitles, List<Runnable> menuEntryRunnables,
			TutorialMenuDelegate menuDelegate) {
		// Initialize Instance Variables
		this.menuTitle = menuTitle;
		this.menuDescription = menuDescription;
		this.menuEntryTitles = new ArrayList<String>(menuEntryTitles);
		this.menuEntryRunnables = new ArrayList<Runnable>(menuEntryRunnables);
		this.menuDelegate = menuDelegate;
	}
	
	@Override
	public void run() {
		// Display Menu Dialog
		Integer menuSelection = Dialogs.displayMenuDialog(this.getMenuTitle(), this.getMenuDescription(), this.getMenuEntryTitles());
		if (menuSelection == -1) {
			this.tellDelegateTutorialMenuWillExit();
		} else {
			this.tellDelegateTutorialMenuWillSelectItem(menuSelection);
			this.getMenuEntryRunnables().get(menuSelection).run();
			this.tellDelegateTutorialMenuDidSelectItem(menuSelection);
		}
	}
	
}
