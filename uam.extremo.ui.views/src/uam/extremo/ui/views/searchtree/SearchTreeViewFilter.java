package uam.extremo.ui.views.searchtree;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.ExtensibleAtomicSearchResult;
import semanticmanager.ExtensibleCustomSearch;
import semanticmanager.ExtensibleGroupedSearchResult;
import semanticmanager.ExtensiblePredicateBasedSearch;
import semanticmanager.RepositoryManager;
import semanticmanager.*;

public class SearchTreeViewFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof RepositoryManager
				|| element instanceof ExtensibleCustomSearch
				|| element instanceof ExtensiblePredicateBasedSearch
				|| element instanceof CompositeSearchConfiguration
				
				|| element instanceof ExtensibleAtomicSearchResult
				|| element instanceof ExtensibleGroupedSearchResult
				
				|| element instanceof SearchResultOptionValue
				|| element instanceof SearchOption
				|| element instanceof SemanticGroup
				|| element instanceof Constraint
				|| element instanceof SemanticNode 
				|| element instanceof Property
				|| element instanceof ObjectProperty
				|| element instanceof DataProperty;
	}
}
