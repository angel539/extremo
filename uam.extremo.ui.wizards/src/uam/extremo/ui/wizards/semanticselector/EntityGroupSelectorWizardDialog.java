package uam.extremo.ui.wizards.semanticselector;

import org.eclipse.jface.wizard.Wizard;

import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;

public class EntityGroupSelectorWizardDialog extends Wizard {
	EntityGroupSelectorDNDWizardPage selectorPage;
	SemanticGroup entityParentGroup;
	SemanticNode newSemanticClass;
	
	public EntityGroupSelectorWizardDialog(SemanticGroup entityParentGroup, SemanticNode semanticClass) {
		super();
		setNeedsProgressMonitor(true);
		this.entityParentGroup = entityParentGroup;
		this.newSemanticClass = semanticClass;
	}
	
	@Override
	public String getWindowTitle() {
	    return "Dragging a semantic group";
	}
	
	public void addPages(){	
		selectorPage = new EntityGroupSelectorDNDWizardPage("Semantic Group decomposing", "Select properties", entityParentGroup);	
		addPage(selectorPage);			
	}

	@Override
	public boolean performFinish() {
		//newSemanticClass.setProperties(selectorPage.getPropertiesSelected());
		//newSemanticClass.setReferences(selectorPage.getReferencesSelected());
		return true;
	}
}
