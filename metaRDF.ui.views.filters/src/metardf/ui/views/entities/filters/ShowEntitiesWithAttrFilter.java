package metardf.ui.views.entities.filters;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import metardf.ui.views.entities.model.AttributeFolderTreeParent;
import metardf.ui.views.entities.model.DataPropertyTreeObject;
import metardf.ui.views.entities.model.SemanticClassTreeParent;
import metardf.ui.views.entities.model.SearchTreeParent;

public class ShowEntitiesWithAttrFilter extends ViewerFilter {

	public ShowEntitiesWithAttrFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof AttributeFolderTreeParent || 
				element instanceof DataPropertyTreeObject || 
				element instanceof SemanticClassTreeParent || 
				element instanceof SearchTreeParent;
	}

}
