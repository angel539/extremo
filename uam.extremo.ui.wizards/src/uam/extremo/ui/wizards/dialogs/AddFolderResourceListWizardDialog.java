package uam.extremo.ui.wizards.dialogs;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

import semanticmanager.Repository;
import semanticmanager.Resource;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.ui.wizards.dialogs.newrepository.NewRepositoryWizardPage;

import java.io.File;

public class AddFolderResourceListWizardDialog extends Wizard {
	NewRepositoryWizardPage newRepositoryPage;
	ImportResourceListWizardPage newResourcePage;
	SelectResourceDescriptorWizardPage selectDescriptorPage;
	
	public AddFolderResourceListWizardDialog() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
	    return "Resource  List";
	}
	
	public void addPages(){	
		newRepositoryPage = new NewRepositoryWizardPage("Repository", "Select a folder with resources");
		newResourcePage = new ImportResourceListWizardPage("Resource list", "Select resources to import", null);	
		selectDescriptorPage = new SelectResourceDescriptorWizardPage("Descriptor", "Select resource that works as descriptor", null);	
		addPage(newRepositoryPage);
		addPage(newResourcePage);
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if(page == newRepositoryPage){
			newResourcePage = new ImportResourceListWizardPage("Resource list", "Select resources to import", newRepositoryPage.getRepositoryUri());
			addPage(newResourcePage);
			return newResourcePage;
		}
		
		if(page == newResourcePage){
			selectDescriptorPage = new SelectResourceDescriptorWizardPage("Descriptor", "Select resource that works as descriptor", newResourcePage.getTable().getSelection());
			addPage(selectDescriptorPage);
			return selectDescriptorPage;
		}
		return null;
	}
	
	@Override
	public boolean performFinish() {
		String repositoryName = newRepositoryPage.getRepositoryName();
		String repositoryDescription = newRepositoryPage.getRepositoryDescription();
		Repository repository = AssistantFactory.getInstance().createRepository(repositoryName, repositoryDescription);
		
		// there is descriptor
		Resource descriptor = null;
		
		descriptorCheck:
		for(TableItem item : selectDescriptorPage.getTable().getItems()){
			if(item.getChecked()){
				String resourceName = ((File)item.getData()).getName();
				String resourceDescription = ((File)item.getData()).getName();
				String resourceUri = ((File)item.getData()).getAbsolutePath();
				descriptor = AssistantFactory.getInstance().createResourceDescriptor(repository, resourceName, resourceDescription, resourceUri);
				break descriptorCheck;
			}
		}
		
		if(descriptor != null){
			for(TableItem item : selectDescriptorPage.getTable().getItems()){
				if(!item.getChecked()){
					String resourceName = ((File)item.getData()).getName();
					String resourceDescription = ((File)item.getData()).getName();
					String resourceUri = ((File)item.getData()).getAbsolutePath();
					AssistantFactory.getInstance().createResource(descriptor, resourceName, resourceDescription, resourceUri);
				}
			}
		}
		else{
			for(TableItem item : selectDescriptorPage.getTable().getItems()){
				String resourceName = ((File)item.getData()).getName();
				String resourceDescription = ((File)item.getData()).getName();
				String resourceUri = ((File)item.getData()).getAbsolutePath();
				AssistantFactory.getInstance().createResourceDescriptor(repository, resourceName, resourceDescription, resourceUri);
			}
		}

		return true;
	}
}
