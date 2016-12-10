package uam.extremo.ui.wizards.dialogs.newrepository;

import org.eclipse.jface.wizard.Wizard;

import semanticmanager.Repository;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.ui.wizards.dialogs.newresource.NewResourceWizardPage;

public class NewRepositoryWizardDialog extends Wizard {
	NewRepositoryWizardPage newRepositoryPage;
	NewResourceWizardPage newResourcePage;
	
	public NewRepositoryWizardDialog() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
	    return "New Semantic Repository";
	}
	
	public void addPages(){	
		newRepositoryPage = new NewRepositoryWizardPage("New Repository", "A repository is a list of resources. It can be a URL with severals semantic files or a folder hold in your system");
		newResourcePage = new NewResourceWizardPage("New Resource", "Create one resource link");	
	
		addPage(newRepositoryPage);
		addPage(newResourcePage);			
	}

	@Override
	public boolean performFinish() {
		String repositoryName = newRepositoryPage.getRepositoryName();
		String repositoryDescription = newRepositoryPage.getRepositoryDescription();
		Repository repository = AssistantFactory.getInstance().createRepository(repositoryName, repositoryDescription);
		
		String resourceName = newResourcePage.getResourceName();
		String resourceDescription = newResourcePage.getResourceDescription();
		String resourceUri = newResourcePage.getResourceUri();
		//AssistantFactory.getInstance().createResource(repository, resourceName, resourceDescription, resourceUri);
		
		return true;
	}
}
