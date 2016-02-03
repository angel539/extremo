package metardf.ui.views.entities.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import metardf.ui.views.entities.model.EntityParent;
import metardf.ui.views.entities.model.SearchParent;

public class EntityFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof EntityParent || element instanceof SearchParent;
	}
}
