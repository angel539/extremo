package metardf.ui.views.properties.entitytab;

import org.eclipse.jface.viewers.IFilter;

import metardf.ui.views.entities.model.AttrFolderParent;
import metardf.ui.views.entities.model.EntityParent;
import metardf.ui.views.entities.model.EntityParentGroup;
import metardf.ui.views.entities.model.FolderParent;
import metardf.ui.views.entities.model.PathParent;
import metardf.ui.views.entities.model.SearchParent;
import metardf.ui.views.entities.model.TreeObject;

public class RepositorySectionFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		if(toTest instanceof EntityParent) return true;
		return false;
	}

}
