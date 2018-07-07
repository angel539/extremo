package uam.extremo.extensions.internal.wizard;

import org.eclipse.jface.wizard.Wizard;


public class PathSelectorWizardDialog extends Wizard {
	PathSelectorWizardPage newRepositoryPage;
	String path = null;
	
	public PathSelectorWizardDialog(String path) {
		super();
		setNeedsProgressMonitor(true);
		this.path = path;
	}
	
	@Override
	public String getWindowTitle() {
	    return "Path Selector";
	}
	
	public void addPages(){	
		newRepositoryPage = new PathSelectorWizardPage("Path Selector", "Select the path to save the data export");
		addPage(newRepositoryPage);			
	}

	@Override
	public boolean performFinish() {
		path = newRepositoryPage.getPath();
		return true;
	}
}
