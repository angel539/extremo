package uam.extremo.ui.wizards.dialogs;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

import semanticmanager.Repository;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.ui.wizards.dialogs.newrepository.NewRepositoryWizardPage;

import java.io.File;

public class AddFolderResourceListWizardDialog extends Wizard {
	NewRepositoryWizardPage newRepositoryPage;
	ResourceListWizardPage newResourcePage;
	
	public AddFolderResourceListWizardDialog() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
	    return "Resource  List";
	}
	
	public void addPages(){	
		newRepositoryPage = new NewRepositoryWizardPage("Repository", "Charge a list of semantic resources from a folder");
		newResourcePage = new ResourceListWizardPage("Edit Resource", "Edit the resource properties", null);	
		addPage(newRepositoryPage);
		addPage(newResourcePage);
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if(page == newRepositoryPage){
			newResourcePage = new ResourceListWizardPage("Resources List", "Select the resources you want to import", newRepositoryPage.getRepositoryUri());
			addPage(newResourcePage);
			return newResourcePage;
		}
		return null;
	}
	
	@Override
	public boolean performFinish() {
		String repositoryName = newRepositoryPage.getRepositoryName();
		String repositoryDescription = newRepositoryPage.getRepositoryDescription();
		Repository repository = AssistantFactory.getInstance().createRepository(repositoryName, repositoryDescription);
		
		//System.out.println("creacion" + repository.toString());
		for(TableItem item : newResourcePage.getTable().getSelection()){
			String resourceName = ((File)item.getData()).getName();
			String resourceDescription = ((File)item.getData()).getName();
			String resourceUri = ((File)item.getData()).getAbsolutePath();
			AssistantFactory.getInstance().createResource(repository, resourceName, resourceDescription, resourceUri);
		}

		return true;
	}
}
