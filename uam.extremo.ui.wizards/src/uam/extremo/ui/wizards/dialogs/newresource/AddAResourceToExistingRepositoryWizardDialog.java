package uam.extremo.ui.wizards.dialogs.newresource;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

import semanticmanager.Repository;
import semanticmanager.Resource;
import uam.extremo.extensions.AssistantFactory;

public class AddAResourceToExistingRepositoryWizardDialog extends Wizard {
	NewResourceWizardPage resourcePage;
	SelectResourceDescriptorForResourceWizardPage selectDescriptorPage;
	
	Repository repository;
	
	public AddAResourceToExistingRepositoryWizardDialog(Repository repository) {
		super();
		setNeedsProgressMonitor(true);
		this.repository = repository;
	}
	
	@Override
	public String getWindowTitle() {
	    return "Add resource to repository";
	}
	
	public void addPages(){	
		resourcePage = new NewResourceWizardPage("Add Resource", "Add a resource to an existing repository");
		selectDescriptorPage = new SelectResourceDescriptorForResourceWizardPage("Descriptor", "Select resource that works as descriptor", null);
		addPage(resourcePage);
		addPage(selectDescriptorPage);
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if(page == resourcePage){
			selectDescriptorPage = new SelectResourceDescriptorForResourceWizardPage("Descriptor", "Select resource that works as descriptor", repository.getResources());
			addPage(selectDescriptorPage);
			return selectDescriptorPage;
		}
		
		return null;
	}

	@Override
	public boolean performFinish() {
		String resourceName = resourcePage.getResourceName();
		String resourceDescription = resourcePage.getResourceDescription();
		String resourceUri = resourcePage.getResourceUri();
		
		Resource descriptor = null;
		
		descriptorCheck:
		for(TableItem item : selectDescriptorPage.getTable().getItems()){
			if(item.getChecked()){
				descriptor = (Resource)item.getData();
				break descriptorCheck;
			}
		}
		
		if(descriptor != null){
			AssistantFactory.getInstance().createResource(repository, descriptor, resourceName, resourceDescription, resourceUri);
		}
		else{
			AssistantFactory.getInstance().createResourceDescriptor(repository, resourceName, resourceDescription, resourceUri);
		}
		
		return true;
	}
}
