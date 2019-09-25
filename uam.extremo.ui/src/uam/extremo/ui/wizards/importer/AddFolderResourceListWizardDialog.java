package uam.extremo.ui.wizards.importer;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

import semanticmanager.*;
import uam.extremo.extensions.AssistantManager;

public class AddFolderResourceListWizardDialog extends Wizard {
	NewRepositoryWizardPage newRepositoryPage;
	ImportResourceListWizardPage newResourcePage;
	SelectResourceDescriptorWizardPage selectDescriptorPage;
	private List<IProject> projects;
	
	public AddFolderResourceListWizardDialog(List<IProject> projects) {
		super();
		setNeedsProgressMonitor(true);
		this.projects = projects;
	}
	
	@Override
	public String getWindowTitle() {
	    return "Resource  List";
	}
	
	public void addPages(){	
		newRepositoryPage = new NewRepositoryWizardPage(projects, "Repository", "Select a folder with resources");
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
		IProject project = newRepositoryPage.getProjectSelected();
		
		if(project != null){
			String repositoryName = newRepositoryPage.getRepositoryName();
			String repositoryDescription = newRepositoryPage.getRepositoryDescription();

			Repository repository = AssistantManager.getInstance().createRepository(project, repositoryName, repositoryDescription);
			// there is descriptor
			Resource descriptor = null;
			
			descriptorCheck:
			for(TableItem item : selectDescriptorPage.getTable().getItems()){
				if(item.getChecked()){
					String resourceName = ((File)item.getData("file")).getName();
					String resourceDescription = (String) item.getData("description");
					String resourceUri = ((File)item.getData("file")).getAbsolutePath();
					
					FormatAssistant assistant = (FormatAssistant)item.getData("assistant");
					try {
						descriptor = AssistantManager.getInstance().createResourceDescriptor(repository, resourceName, resourceDescription, resourceUri, assistant);
					}
					catch (CoreException e) {
						MessageDialog.openError(null, "Resource creation", e.getMessage());
					}
					
					break descriptorCheck;
				}
			}
			
			if(descriptor != null){
				for(TableItem item : selectDescriptorPage.getTable().getItems()){
					if(!item.getChecked()){
						String resourceName = ((File)item.getData("file")).getName();
						String resourceDescription = (String) item.getData("description");
						String resourceUri = ((File)item.getData("file")).getAbsolutePath();
						
						FormatAssistant assistant = (FormatAssistant)item.getData("assistant");
						try {
							AssistantManager.getInstance().createResource(repository, descriptor, resourceName, resourceDescription, resourceUri, assistant);
						}
						catch (CoreException e) {
							MessageDialog.openError(null, "Resource creation", e.getMessage());
						}
					}
				}
			}
			else{
				for(TableItem item : selectDescriptorPage.getTable().getItems()){
					String resourceName = ((File)item.getData("file")).getName();
					String resourceDescription = (String) item.getData("description");
					String resourceUri = ((File)item.getData("file")).getAbsolutePath();
					
					FormatAssistant assistant = (FormatAssistant)item.getData("assistant");
					try {
						AssistantManager.getInstance().createResource(repository, descriptor, resourceName, resourceDescription, resourceUri, assistant);
					} catch (CoreException e) {
						MessageDialog.openError(null, "Resource creation", e.getMessage());
					}
				}
			}
			
			AssistantManager.getInstance().getRepositoryManager().getRepositories().add(repository);
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean canFinish(){
		if(getContainer().getCurrentPage() == newRepositoryPage || getContainer().getCurrentPage() == newResourcePage)
			return false;
		else
			return true;
	}
}
