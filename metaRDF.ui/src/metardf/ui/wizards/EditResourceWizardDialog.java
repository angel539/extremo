package metardf.ui.wizards;

import org.eclipse.jface.wizard.Wizard;

import metaRDF.core.model.IResource;

public class EditResourceWizardDialog extends Wizard {
	NewResourceWizardPage resourcePage;
	IResource resource;
	
	public EditResourceWizardDialog(IResource resource) {
		super();
		setNeedsProgressMonitor(true);
		this.resource = resource;
	}
	
	@Override
	public String getWindowTitle() {
	    return "New Semantic Repository";
	}
	
	public void addPages(){	
		resourcePage = new NewResourceWizardPage("Edit Resource", "Edit the resource properties", resource);	
		addPage(resourcePage);			
	}

	@Override
	public boolean performFinish() {
		resource.setName(resourcePage.getResourceName());
		resource.setComment(resourcePage.getResourceDescription());
		resource.setUri(resourcePage.getResourceUri());
		return true;
	}
}
