package uam.extremo.ui.wizards.dialogs.searchnew;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import semanticmanager.Repository;
import semanticmanager.SimpleSearchConfiguration;
import uam.extremo.ui.wizards.dialogs.searchnew.dnd.RepositoryTreeViewer;

public class NamedElementSelectionWizardPage extends WizardPage{
	Composite containerArea;
	RepositoryTreeViewer repositoryTreeViewer;
	
	Repository repository = null;
	
	public NamedElementSelectionWizardPage(
			String pageName, 
			String description, 
			Repository repository) {
		super(pageName);
		
		setTitle(pageName);
		setDescription(description);
		this.repository = repository;
	}

	@Override
	public void createControl(Composite parent) {
		containerArea = new Composite(parent, SWT.NONE);
		FillLayout container = new FillLayout(SWT.HORIZONTAL);
		container.marginHeight = 0;
		container.marginWidth = 0;
		containerArea.setLayout(container);
		
		if(repository != null){
			repositoryTreeViewer = new RepositoryTreeViewer(containerArea, repository);
		}
		
		containerArea.moveAbove(null);
		setControl(containerArea);
	}
	
	public Composite getContainerArea() {
		return containerArea;
	}

	public void setContainerArea(Composite containerArea) {
		this.containerArea = containerArea;
	}
	
	@Override
	public IWizardPage getNextPage() {
		return super.getNextPage();
	}
}
