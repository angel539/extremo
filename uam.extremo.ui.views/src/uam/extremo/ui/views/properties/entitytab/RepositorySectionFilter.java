package uam.extremo.ui.views.properties.entitytab;

import org.eclipse.jface.viewers.IFilter;

import semanticmanager.SemanticNode;

public class RepositorySectionFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		if(toTest instanceof SemanticNode) return true;
		return false;
	}

}
