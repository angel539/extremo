package metardf.ui.wizards;

import org.eclipse.jface.wizard.Wizard;

public class RepositoryListWizardDialog extends Wizard {
	NewRepositoryWizardPage repositoryNewPage;
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
		repositoryNewPage = new NewRepositoryWizardPage("Repository", "...");
		resourcePage = new RepositoryListWizardPage("Edit Resource", "Edit the resource properties");	
		addPage(resourcePage);			
	}

	@Override
	public boolean performFinish() {
		return true;
	}
}
