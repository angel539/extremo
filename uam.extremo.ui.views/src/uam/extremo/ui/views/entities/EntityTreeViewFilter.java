package uam.extremo.ui.views.entities;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.RepositoryManager;
import semanticmanager.Search;
import semanticmanager.SemanticGroup;

public class EntityTreeViewFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof RepositoryManager || 
				element instanceof Search || 
				element instanceof SemanticGroup;
			//	element instanceof Repository ||
			//	element instanceof Resource || 
			//	element instanceof SemanticNode;
			//	element instanceof DataProperty || 
			//	element instanceof ObjectProperty;
	}
}
