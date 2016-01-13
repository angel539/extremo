package metardf.ui.wizards;

import org.eclipse.jface.wizard.Wizard;
import metaRDF.core.model.IRepository;
import metaRDF.core.model.impl.RepositoryManager;

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
		IRepository repository = RepositoryManager.getInstance().addRepository(newRepositoryPage.getRepositoryName(), newRepositoryPage.getRepositoryDescription(), newRepositoryPage.getRepositoryUri());
		repository.createResource(newResourcePage.getResourceName(), newResourcePage.getResourceDescription(), newResourcePage.getResourceUri());
		return true;
	}
}
