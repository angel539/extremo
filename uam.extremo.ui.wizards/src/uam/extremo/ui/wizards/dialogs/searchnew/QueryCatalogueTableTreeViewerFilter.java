package uam.extremo.ui.wizards.dialogs.searchnew;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.*;

public class QueryCatalogueTableTreeViewerFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof RepositoryManager
				|| element instanceof ExtensibleCustomSearch
				|| element instanceof ExtensiblePredicateBasedSearch
				|| element instanceof CompositeSearchConfiguration;
	}
}
