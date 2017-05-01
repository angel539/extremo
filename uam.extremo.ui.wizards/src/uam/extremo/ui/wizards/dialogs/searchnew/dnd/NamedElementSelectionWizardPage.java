package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class NamedElementSelectionWizardPage extends WizardPage{
	Composite containerArea;
	
	DragMetaModelElementViewer dragView;
	DropMetaModelElementTableTreeViewer dropView;
	
	//private Map<String, List<NamedElement>> namedElementsByType;
	
	public NamedElementSelectionWizardPage(String pageName, String description) {
		super(pageName);
		setTitle(pageName);
		setDescription(description);
		//this.namedElementsByType = namedElementsByType;
	}

	@Override
	public void createControl(Composite parent) {
		containerArea = new Composite(parent, SWT.NONE);
		FillLayout container = new FillLayout(SWT.HORIZONTAL);
		container.marginHeight = 0;
		container.marginWidth = 0;
		containerArea.setLayout(container);
		
		//dragView = new DragMetaModelElementViewer(containerArea, namedElementsByType.get("Resource"));
		//dropView = new DropMetaModelElementTableTreeViewer(containerArea, namedElementsByType.get("Resource"));
		//dropView.refresh();
		
		containerArea.moveAbove(null);
		setControl(containerArea);
	}
	
	public Composite getContainerArea() {
		return containerArea;
	}

	public void setContainerArea(Composite containerArea) {
		this.containerArea = containerArea;
	}

	/*public void setDatamodel(String key, Map<String, List<NamedElement>> namedElementsByType){
		dragView.addElements(namedElementsByType.get(key));
	}
	
	public List<NamedElement> getSelectedElements(){
		return dropView.getSelectedElements();
	}*/
	
	@Override
	public IWizardPage getNextPage() {
		return super.getNextPage();
	}
}
