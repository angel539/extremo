package uam.extremo.ui.wizards.dialogs.newresource;

import org.eclipse.jface.wizard.Wizard;

import semanticmanager.Repository;
import uam.extremo.extensions.AssistantFactory;

public class AddAResourceToExistingRepositoryWizardDialog extends Wizard {
	NewResourceWizardPage resourcePage;
	Repository repository;
	
	public AddAResourceToExistingRepositoryWizardDialog(Repository repository) {
		super();
		setNeedsProgressMonitor(true);
		this.repository = repository;
		//System.out.println("wizard de actualizacion " + repository.toString());
	}
	
	@Override
	public String getWindowTitle() {
	    return "Add resource to repository";
	}
	
	public void addPages(){	
		resourcePage = new NewResourceWizardPage("New Resource", "Import a resource to a repository");	
		addPage(resourcePage);			
	}

	@Override
	public boolean performFinish() {
		AssistantFactory.getInstance().createResource(repository, resourcePage.getResourceName(), resourcePage.getResourceDescription(), resourcePage.getResourceUri());
		return true;
	}
}
