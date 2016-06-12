package metardf.ui.wizards.semanticselector;

import org.eclipse.jface.wizard.Wizard;

import metaRDF.core.model.ISemanticClass;
import metardf.ui.views.entities.model.SemanticClassGroupTreeParent;

public class EntityGroupSelectorWizardDialog extends Wizard {
	EntityGroupSelectorDNDWizardPage selectorPage;
	SemanticClassGroupTreeParent entityParentGroup;
	ISemanticClass newSemanticClass;
	
	public EntityGroupSelectorWizardDialog(SemanticClassGroupTreeParent entityParentGroup, ISemanticClass semanticClass) {
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
		newSemanticClass.setProperties(selectorPage.getPropertiesSelected());
		newSemanticClass.setReferences(selectorPage.getReferencesSelected());
		
		return true;
	}
}
