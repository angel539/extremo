package metardf.ui.wizards;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.jface.wizard.Wizard;

import metaRDF.core.model.IResource;
import metaRDF.core.model.impl.Repository;
import metaRDF.core.model.impl.RepositoryManager;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;

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
		Repository repository = RepositoryManager.getInstance().addRepository(newRepositoryPage.getRepositoryUri(), newRepositoryPage.getRepositoryName(), newRepositoryPage.getRepositoryDescription());
		
		IResource resource = repository.createResource(newResourcePage.getResourceUri(), newResourcePage.getResourceName(), newResourcePage.getResourceDescription());
		
		String extensionFile = FilenameUtils.getExtension(newResourcePage.getResourceUri());
		
		loop: 
		for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
			for(String ext : ((FormatAssistant) assistant).getExtensions()){
				if(extensionFile.compareTo(ext) == 0){
					resource.setAssistant(((FormatAssistant) assistant).getNameExtension());
					break loop;
				}
			}
		}
		return true;
	}
}
