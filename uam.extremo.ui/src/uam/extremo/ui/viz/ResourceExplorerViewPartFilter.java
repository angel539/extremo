package uam.extremo.ui.viz;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.*;
public class ResourceExplorerViewPartFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return (element instanceof RepositoryManager)
				|| (element instanceof Repository)
				|| (element instanceof Resource)
				|| (element instanceof SemanticNode)
				|| (element instanceof DataProperty)
				|| (element instanceof ObjectProperty);
	}
}
