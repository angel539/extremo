package metardf.ui.views.entities;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metardf.ui.views.entities.model.SemanticClassTreeParent;
import metardf.ui.views.entities.model.SemanticClassGroupTreeParent;

public class EntityViewViewerComparator extends ViewerComparator{
	@Override
	public int compare(Viewer viewer, Object element1, Object element2) {
		int weight1 = 0;
		int weight2 = 0;
		
		if(element1 instanceof SemanticClassTreeParent){
			ISemanticElement semanticElement1 = ((SemanticClassTreeParent) element1).getSemanticElement();
			if(semanticElement1 instanceof ISemanticClass)
				weight1 = ((ISemanticClass) semanticElement1).getWeight();	
		}
		
		if(element1 instanceof SemanticClassGroupTreeParent){
			weight1 = ((SemanticClassGroupTreeParent) element1).getMax_weight();	
		}
		
		if(element2 instanceof SemanticClassGroupTreeParent){
			weight2 = ((SemanticClassGroupTreeParent) element2).getMax_weight();	
		}
		
		if(element2 instanceof SemanticClassTreeParent){
			ISemanticElement semanticElement2 = ((SemanticClassTreeParent) element2).getSemanticElement();
			if(semanticElement2 instanceof ISemanticClass)
				weight2 = ((ISemanticClass) semanticElement2).getWeight();	
		}
		
		if(weight1 < weight2) return 1;
		if(weight1 == weight2) return 0;
		if(weight1 > weight2) return -1;
		
		return 0;
	}
}
