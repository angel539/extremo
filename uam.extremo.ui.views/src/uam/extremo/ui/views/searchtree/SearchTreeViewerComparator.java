package uam.extremo.ui.views.searchtree;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import semanticmanager.SemanticNode;

public class SearchTreeViewerComparator extends ViewerComparator{
	@Override
	public int compare(Viewer viewer, Object element1, Object element2) {
		int weight1 = 0;
		int weight2 = 0;
		
		if(element1 instanceof SemanticNode){
			SemanticNode semanticElement1 = (SemanticNode) element1;
			weight1 = semanticElement1.getWeight();	
		}
		
		if(element2 instanceof SemanticNode){
			SemanticNode semanticElement2 = (SemanticNode) element2;
			weight2 = semanticElement2.getWeight();	
		}
		
		if(weight1 < weight2) return 1;
		if(weight1 == weight2) return 0;
		if(weight1 > weight2) return -1;
		
		return 0;
	}
}
