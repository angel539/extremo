package uam.extremo.ui.views.repositories;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.Constraint;
import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;

public class RepositoryViewFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof RepositoryManager || 
				element instanceof Repository || 
				element instanceof Resource ||
				element instanceof Constraint ||
				element instanceof SemanticNode||
				element instanceof DataProperty ||
				element instanceof ObjectProperty
				;
	}
}
