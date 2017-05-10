package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import semanticmanager.SimpleSearchConfiguration;

public class NamedElementSelectionWizardPage extends WizardPage{
	Composite containerArea;
	DragMetaModelElementViewer dragView;
	DropMetaModelElementTableTreeViewer dropView;
	SimpleSearchConfiguration simpleSearchConfigurationSelected;
	
	IStructuredSelection strucSelection = null;
	
	public NamedElementSelectionWizardPage(String pageName, String description, SimpleSearchConfiguration simpleSearchConfigurationSelected, IStructuredSelection strucSelection) {
		super(pageName);
		setTitle(pageName);
		setDescription(description);
		this.simpleSearchConfigurationSelected = simpleSearchConfigurationSelected;
		this.strucSelection = strucSelection;
	}

	@Override
	public void createControl(Composite parent) {
		containerArea = new Composite(parent, SWT.NONE);
		FillLayout container = new FillLayout(SWT.HORIZONTAL);
		container.marginHeight = 0;
		container.marginWidth = 0;
		containerArea.setLayout(container);
		
		List<NamedElement> namedElements = new ArrayList<NamedElement>();
		
		if((strucSelection != null) && (!strucSelection.isEmpty())){
			Iterator iterator = strucSelection.iterator();
			String filterBy = simpleSearchConfigurationSelected.getFilterBy().getLiteral();
			
			switch (filterBy) {
				case "Resource":
					while(iterator.hasNext()){
						Object object = (Object) iterator.hasNext();
						
						if (object instanceof Resource) {
							Resource resource = (Resource) object;	
						}
					}
					break;
					
				case "SemanticNode":
					while(iterator.hasNext()){
						Object object = (Object) iterator.hasNext();
						
						if (object instanceof SemanticNode) {
							SemanticNode semanticNode = (SemanticNode) object;
							
						}
					}
					break;
				
				case "ObjectProperty":
					while(iterator.hasNext()){
						Object object = (Object) iterator.hasNext();
						
						if (object instanceof ObjectProperty) {
							ObjectProperty objectProperty = (ObjectProperty) object;
							
						}
					}
					break;
				
				case "DataProperty":
					Object object = (Object) iterator.hasNext();
					
					if (object instanceof DataProperty) {
						DataProperty dataProperty = (DataProperty) object;
						
					}
					break;

				default:
					break;
			}
		}
		
		dragView = new DragMetaModelElementViewer(containerArea, namedElements);
		dropView = new DropMetaModelElementTableTreeViewer(containerArea, namedElements);
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

	public void setDatamodel(String key, Map<String, List<NamedElement>> namedElementsByType){
		dragView.addElements(namedElementsByType.get(key));
	}
	
	public List<NamedElement> getSelectedElements(){
		return dropView.getSelectedElements();
	}
	
	@Override
	public IWizardPage getNextPage() {
		return super.getNextPage();
	}
}
