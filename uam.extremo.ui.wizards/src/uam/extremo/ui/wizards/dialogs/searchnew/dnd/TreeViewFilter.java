package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.RepositoryManager;
import semanticmanager.*;

public class TreeViewFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof RepositoryManager || 
				element instanceof Repository || 
				((element instanceof Resource) && ((Resource) element).getDescriptors().isEmpty()) ||
				element instanceof SemanticNode||
				element instanceof DataProperty ||
				element instanceof ObjectProperty;
	}
}
