package uam.extremo.ui.zest.views;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;

public class GraphViewPartFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		/*
		return (element instanceof RepositoryManager)
				|| (element instanceof Repository && ((Repository) element).isDrawn())
				|| (element instanceof Resource && ((Resource) element).isDrawn())
				|| (element instanceof SemanticNode && ((SemanticNode) element).isDrawn())
				|| (element instanceof DataProperty && ((DataProperty) element).isDrawn())
				|| (element instanceof ObjectProperty && ((ObjectProperty) element).isDrawn());
		*/
		return (element instanceof RepositoryManager)
				|| (element instanceof Repository)
				|| (element instanceof Resource)
				|| (element instanceof SemanticNode)
				|| (element instanceof DataProperty);
				//|| (element instanceof ObjectProperty);
	}
}
