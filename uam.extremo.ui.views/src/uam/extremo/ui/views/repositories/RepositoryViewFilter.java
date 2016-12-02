package uam.extremo.ui.views.repositories;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;

public class RepositoryViewFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof RepositoryManager || 
				element instanceof Repository || 
				element instanceof Resource;
	}
}
