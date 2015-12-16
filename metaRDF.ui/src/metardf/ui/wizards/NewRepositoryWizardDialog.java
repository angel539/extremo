package metardf.ui.wizards;

import org.eclipse.jface.wizard.Wizard;
import metaRDF.core.model.Repository;
import metaRDF.core.repository.MetaRDFRepositoryManager;

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
		Repository repository = MetaRDFRepositoryManager.getInstance().addRepository(newRepositoryPage.getRepositoryName(), newRepositoryPage.getRepositoryDescription(), newRepositoryPage.getRepositoryUri());
		repository.createResource(newResourcePage.getResourceName(), newResourcePage.getResourceDescription(), newResourcePage.getResourceUri());
		return true;
	}
}
