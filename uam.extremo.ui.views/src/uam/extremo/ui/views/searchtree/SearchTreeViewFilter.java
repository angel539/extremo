package uam.extremo.ui.views.searchtree;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.*;

public class SearchTreeViewFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof RepositoryManager
				|| element instanceof CustomSearch
				|| element instanceof PredicateBasedSearch
				|| element instanceof CompositeSearchConfiguration
				
				|| element instanceof AtomicSearchResult
				|| element instanceof GroupedSearchResult
				
				|| element instanceof SemanticGroup
				|| element instanceof Constraint
				|| element instanceof MetaData
				|| element instanceof SemanticNode 
				|| element instanceof Property
				|| element instanceof ObjectProperty
				|| element instanceof DataProperty
				
				|| element instanceof PrimitiveTypeParam
				|| element instanceof ModelTypeParam
				|| element instanceof PrimitiveTypeParamValue
				|| element instanceof ModelTypeParamValue;
	}
}
