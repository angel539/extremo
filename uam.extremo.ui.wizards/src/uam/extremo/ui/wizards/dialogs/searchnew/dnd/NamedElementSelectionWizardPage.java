package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import java.util.List;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import semanticmanager.NamedElement;
import semanticmanager.Resource;

public class NamedElementSelectionWizardPage extends WizardPage{
	Composite containerArea;
	
	DragMetaModelElementViewer dragView;
	DropMetaModelElementTableTreeViewer dropView;
	
	private List<Resource> resources;

	public NamedElementSelectionWizardPage(String pageName, String description, List<Resource> resources) {
		super(pageName);
		setTitle(pageName);
		setDescription(description);
		
		this.resources = resources;
	}

	@Override
	public void createControl(Composite parent) {
		containerArea = new Composite(parent, SWT.NONE);
		FillLayout container = new FillLayout(SWT.HORIZONTAL);
		container.marginHeight = 0;
		container.marginWidth = 0;
		containerArea.setLayout(container);
		
		dragView = new DragMetaModelElementViewer(containerArea, resources);
		dropView = new DropMetaModelElementTableTreeViewer(containerArea, resources);
		dropView.refresh();
		
		containerArea.moveAbove(null);
		setControl(containerArea);
	}
	
	public Composite getContainerArea() {
		return containerArea;
	}

	public void setContainerArea(Composite containerArea) {
		this.containerArea = containerArea;
	}

	public void setDatamodel(List<Resource> resources){
		this.resources = resources;
		
		dragView.refresh(resources);
		dropView.refresh(resources);
	}
	
	public List<NamedElement> getSelectedElements(){
		return dropView.getSelectedElements();
	}
	
	@Override
	public IWizardPage getNextPage() {
		return super.getNextPage();
	}
}
