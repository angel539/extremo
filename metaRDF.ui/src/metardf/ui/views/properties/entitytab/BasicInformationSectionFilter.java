package metardf.ui.views.properties.entitytab;

import org.eclipse.jface.viewers.IFilter;

import metardf.ui.views.entities.model.AttrFolderParent;
import metardf.ui.views.entities.model.EntityParentGroup;
import metardf.ui.views.entities.model.FolderParent;
import metardf.ui.views.entities.model.PathParent;
import metardf.ui.views.entities.model.SearchParent;
import metardf.ui.views.entities.model.TreeObject;

public class BasicInformationSectionFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		if(toTest instanceof SearchParent) return false;
		if(toTest instanceof EntityParentGroup) return false;
		if(toTest instanceof AttrFolderParent) return false;
		if(toTest instanceof FolderParent) return false;
		if(toTest instanceof PathParent) return false;
		if(toTest instanceof TreeObject) return true;
		return false;
	}

}
