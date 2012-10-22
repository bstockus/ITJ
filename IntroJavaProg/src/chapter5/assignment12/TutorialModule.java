package chapter5.assignment12;

public abstract class TutorialModule implements Runnable {
	
	// Instance Variables
	private TutorialModuleDelegate moduleDelegate = null;
	
	public TutorialModuleDelegate getModuleDelegate() {
		return this.moduleDelegate;
	}
	
	public void setModuleDelegate(TutorialModuleDelegate moduleDelegate) {
		this.moduleDelegate = moduleDelegate;
	}
	
	// Delegate Methods
	
	private void tellDelegateTutorialModuleWillStart() {
		if (this.getModuleDelegate() != null) {
			this.getModuleDelegate().tutorialModuleWillStart(this);
		}
	}
	
	private void tellDelegateTutorialModuleDidFinish() {
		if (this.getModuleDelegate() != null) {
			this.getModuleDelegate().tutorialModuleDidFinish(this);
		}
	}
	
	public TutorialModule(TutorialModuleDelegate moduleDelegate) {
		// Initialize Instance Variables
		this.moduleDelegate = moduleDelegate;
	}
	
	protected abstract void runModule();
	
	@Override
	public final void run() {
		this.tellDelegateTutorialModuleWillStart();
		this.runModule();
		this.tellDelegateTutorialModuleDidFinish();
	}
	
}
