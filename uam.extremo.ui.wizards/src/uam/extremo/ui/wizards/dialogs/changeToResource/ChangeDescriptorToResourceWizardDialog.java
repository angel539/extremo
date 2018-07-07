package uam.extremo.ui.wizards.dialogs.changeToResource;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

import uam.extremo.core.Resource;

public class ChangeDescriptorToResourceWizardDialog extends Wizard {
	SelectResourceDescriptorForResourceWizardPage selectDescriptorPage;
	Resource resource;
	
	public ChangeDescriptorToResourceWizardDialog(Resource resource) {
		super();
		setNeedsProgressMonitor(true);
		this.resource = resource;
	}
	
	@Override
	public String getWindowTitle() {
	    return "Add resource to repository";
	}
	
	public void addPages(){
		selectDescriptorPage = new SelectResourceDescriptorForResourceWizardPage("Descriptor selection", "Select the descriptor for the resource", resource);
		addPage(selectDescriptorPage);
	}

	@Override
	public boolean performFinish() {		
		Resource descriptor = null;
		
		descriptorCheck:
		for(TableItem item : selectDescriptorPage.getTable().getItems()){
			if(item.getChecked()){
				descriptor = (Resource)item.getData();
				break descriptorCheck;
			}
		}
		
		if(descriptor != null){
			descriptor.getDescribes().add(resource);
		}
		else{
			return false;
		}
		
		return true;
	}
}
