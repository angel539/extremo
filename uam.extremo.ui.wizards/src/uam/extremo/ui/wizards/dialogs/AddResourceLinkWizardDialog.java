package uam.extremo.ui.wizards.dialogs;

import java.util.List;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;

import semanticmanager.*;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.extensions.IFormatAssistant;
import uam.extremo.ui.wizards.dialogs.newrepository.NewLinkResourceWizardPage;

public class AddResourceLinkWizardDialog extends Wizard {
	NewLinkResourceWizardPage newRepositoryPage;
	private List<IFormatAssistant> assistances;
	
	public AddResourceLinkWizardDialog(List<IFormatAssistant> assistances) {
		super();
		setNeedsProgressMonitor(true);
		this.assistances = assistances;
	}
	
	@Override
	public String getWindowTitle() {
	    return "Resource  List";
	}
	
	public void addPages(){	
		newRepositoryPage = new NewLinkResourceWizardPage(assistances, "Resource Link", "Add a link to a resource on the web");	
		addPage(newRepositoryPage);
	}
	
	@Override
	public boolean performFinish() {
		IFormatAssistant assistant = newRepositoryPage.getAssistantSelected();
		if(assistant != null){
			String repositoryName = newRepositoryPage.getRepositoryName();
			String resourceName = newRepositoryPage.getResourceName();
			String resourceDescription = newRepositoryPage.getResourceDescription();
			String resourceUri = newRepositoryPage.getResourceUri();
			
			Repository repository = AssistantFactory.getInstance().createRepositoryLink(repositoryName, resourceDescription);
			try {
				AssistantFactory.getInstance().createResourceDescriptorLink(repository, resourceName, resourceDescription, resourceUri, assistant);
			}
			catch (CoreException e) {
				MessageDialog.openError(null, "Add Link > Loading resource", e.getMessage());
			}
			return true;
		}
		
		return false;
	}
}