package uam.extremo.ui.views.searchtree;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.Constraint;
import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Property;
import semanticmanager.RepositoryManager;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchOption;
import semanticmanager.SearchResult;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;

public class SearchTreeViewFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof RepositoryManager
				|| element instanceof SearchConfiguration
				|| element instanceof SearchResult
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
