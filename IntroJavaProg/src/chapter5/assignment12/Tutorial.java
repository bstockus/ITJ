package chapter5.assignment12;

import java.util.ArrayList;
import java.util.List;

import convenience.dialogs.Dialogs;


// Main Class

public class Tutorial implements TutorialMenuDelegate, TutorialModuleDelegate, Runnable {
	
	// Constants
	private static Boolean ALLOW_MULTIPLE_EXECUTION = true;
	
	// Instance Variables
	private TutorialMenu tutorialMenu = null;
	private String tutorialMenuTitle = null;
	private String tutorialMenuDescription = null;
	private ArrayList<TutorialModule> tutorialModules = null;
	private ArrayList<String> tutorialModuleNames = null;
	private String lastRunModuleName = "";
	
	public TutorialMenu getTutorialMenu() {
		return this.tutorialMenu;
	}
	
	public String getTutorialMenuTitle() {
		return this.tutorialMenuTitle;
	}
	
	public String getTutorialMenuDescription() {
		return this.tutorialMenuDescription;
	}
	
	public List<TutorialModule> getTutorialModules() {
		return this.tutorialModules;
	}
	
	public List<String> getTutorialModuleNames() {
		return this.tutorialModuleNames;
	}
	
	public String getLastRunModuleName() {
		return this.lastRunModuleName;
	}
	
	public Tutorial(String tutorialMenuTitle, String tutorialMenuDescription, List<TutorialModule> tutorialModules,
			List<String> tutorialModuleNames) {
		// Initialize Instance Variables
		this.tutorialModules = new ArrayList<TutorialModule>(tutorialModules);
		this.tutorialModuleNames = new ArrayList<String>(tutorialModuleNames);
		ArrayList<Runnable> tutorialModuleRunnables = new ArrayList<Runnable>();
		for (TutorialModule tutorialModule: this.getTutorialModules()) {
			tutorialModuleRunnables.add(tutorialModule);
			tutorialModule.setModuleDelegate(this);
		}
		this.tutorialMenu = new TutorialMenu(tutorialMenuTitle, tutorialMenuDescription, this.getTutorialModuleNames(), tutorialModuleRunnables, this);
	}
	
	@Override
	public void tutorialMenuWillSelectItem(TutorialMenu tutorialMenu,
			Integer selectionIndex) {
		
	}
	
	@Override
	public void tutorialMenuDidSelectItem(TutorialMenu tutorialMenu,
			Integer selectionIndex) {
		this.lastRunModuleName = this.getTutorialModuleNames().get(selectionIndex);
	}
	
	@Override
	public void tutorialMenuWillExit(TutorialMenu tutorialMenu) {
		Dialogs.displayInfoDialog("GOOD BYE", "Thank you for using the Tutorial program!");
		System.exit(0);
	}
	
	@Override
	public void tutorialModuleWillStart(TutorialModule tutorialModule) {
		
	}
	
	@Override
	public void tutorialModuleDidFinish(TutorialModule tutorialModule) {
		
	}
	
	@Override
	public void run() {
		for (;;) {
			this.getTutorialMenu().run();
			if (Tutorial.ALLOW_MULTIPLE_EXECUTION) {
				if (!(Dialogs.displayConfirmDialog("TUTORIAL", "Thank you for using our " + this.getLastRunModuleName() + " tutorial.\nWould you like to use another tutorial?"))) {
					return;
				}
			} else {
				Dialogs.displayInfoDialog("TUTORIAL", "Thank you for using our " + this.getLastRunModuleName() + " tutorial.");
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		List<TutorialModule> tutorialModules = new ArrayList<TutorialModule>();
		tutorialModules.add(new TutorialStringsModule(null));
		tutorialModules.add(new TutorialNumbersModule(null));
		List<String> tutorialModuleNames = new ArrayList<String>();
		tutorialModuleNames.add("Strings");
		tutorialModuleNames.add("Numbers");
		Tutorial tutorial = new Tutorial("NUMBERS AND STRING PROGRAM", "This program will work with strings or numbers.<br/>Please indicate your preference below:",
				tutorialModules, tutorialModuleNames);
		tutorial.run();
	}
	
}
