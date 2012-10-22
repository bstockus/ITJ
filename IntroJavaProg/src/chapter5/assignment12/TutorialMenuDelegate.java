package chapter5.assignment12;

public interface TutorialMenuDelegate {
	
	public void tutorialMenuWillSelectItem(TutorialMenu tutorialMenu, Integer selectionIndex);
	
	public void tutorialMenuDidSelectItem(TutorialMenu tutorialMenu, Integer selectionIndex);
	
	public void tutorialMenuWillExit(TutorialMenu tutorialMenu);
	
}
