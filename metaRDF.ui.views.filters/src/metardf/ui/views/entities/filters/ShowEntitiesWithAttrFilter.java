package metardf.ui.views.entities.filters;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import metardf.ui.views.entities.model.AttrFolderParent;
import metardf.ui.views.entities.model.DataPropertyObject;
import metardf.ui.views.entities.model.EntityParent;
import metardf.ui.views.entities.model.SearchParent;

public class ShowEntitiesWithAttrFilter extends ViewerFilter {

	public ShowEntitiesWithAttrFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof AttrFolderParent || 
				element instanceof DataPropertyObject || 
				element instanceof EntityParent || 
				element instanceof SearchParent;
	}

}
