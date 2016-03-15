package metardf.ui.views.properties.entitytab;

import org.eclipse.jface.viewers.IFilter;

import metardf.ui.views.entities.model.EntityParent;

public class RepositorySectionFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		if(toTest instanceof EntityParent) return true;
		return false;
	}

}
