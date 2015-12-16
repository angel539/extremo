package metardf.ui.wizards;

import org.eclipse.jface.wizard.Wizard;

public class RepositoryListWizardDialog extends Wizard {
	RepositoryListWizardPage resourcePage;
	
	public RepositoryListWizardDialog() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
	    return "New Semantic Repository";
	}
	
	public void addPages(){	
		resourcePage = new RepositoryListWizardPage("Edit Resource", "Edit the resource properties");	
		addPage(resourcePage);			
	}

	@Override
	public boolean performFinish() {
		return true;
	}
}
