package uam.extremo.ui.wizards.dialogs;

import org.eclipse.jface.wizard.Wizard;

import uam.extremo.ui.wizards.dialogs.newrepository.NewRepositoryWizardPage;

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
		repositoryNewPage = new NewRepositoryWizardPage("Repository folder", "Charge a folder with semantic resources");
		resourcePage = new RepositoryListWizardPage("Edit Resource", "Edit the resource properties");
		addPage(resourcePage);			
	}

	@Override
	public boolean performFinish() {
		return true;
	}
}
