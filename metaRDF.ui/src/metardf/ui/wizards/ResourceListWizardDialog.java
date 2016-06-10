package metardf.ui.wizards;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

import metaRDF.core.model.IResource;
import metaRDF.core.model.impl.Repository;
import metaRDF.core.model.impl.RepositoryManager;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.IFormatAssistant;
import metardf.core.extensions.FormatAssistant;

public class ResourceListWizardDialog extends Wizard {
	NewRepositoryWizardPage repositoryPage;
	ResourceListWizardPage resourcePage;
	
	public ResourceListWizardDialog() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
	    return "Resource  List";
	}
	
	public void addPages(){	
		repositoryPage = new NewRepositoryWizardPage("Repository", "Charge a list of semantic resources from a folder");
		resourcePage = new ResourceListWizardPage("Edit Resource", "Edit the resource properties", null);	
		addPage(repositoryPage);
		addPage(resourcePage);
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if(page == repositoryPage){
			resourcePage = new ResourceListWizardPage("Resources List", "Select the resources you want to import", repositoryPage.getRepositoryUri());
			addPage(resourcePage);
			return resourcePage;
		}
		return null;
	}
	
	@Override
	public boolean performFinish() {
		Repository repository = RepositoryManager.getInstance().addRepository(repositoryPage.getRepositoryUri(), repositoryPage.getRepositoryName(), repositoryPage.getRepositoryDescription());
		for(TableItem item : resourcePage.getTable().getSelection()){
			IResource resource = repository.createResource(((File)item.getData()).getAbsolutePath(), ((File)item.getData()).getName(), ((File)item.getData()).getParent());
			String extensionFile = FilenameUtils.getExtension(((File)item.getData()).getAbsolutePath());
			
			loop: 
			for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
				for(String ext : ((FormatAssistant) assistant).getExtensions()){
					if(extensionFile.compareTo(ext) == 0){
						resource.setAssistant(((FormatAssistant) assistant).getNameExtension());
						break loop;
					}
				}
			}
			
		}
		
		return true;
	}
}
