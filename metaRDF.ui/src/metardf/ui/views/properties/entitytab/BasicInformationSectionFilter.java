package metardf.ui.views.properties.entitytab;

import org.eclipse.jface.viewers.IFilter;

import metardf.ui.views.entities.model.AttributeFolderTreeParent;
import metardf.ui.views.entities.model.SemanticClassGroupTreeParent;
import metardf.ui.views.entities.model.FolderTreeParent;
import metardf.ui.views.entities.model.PathSearchTreeParent;
import metardf.ui.views.entities.model.SearchTreeParent;
import metardf.ui.views.entities.model.TreeObject;

public class BasicInformationSectionFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		if(toTest instanceof SearchTreeParent) return false;
		if(toTest instanceof SemanticClassGroupTreeParent) return false;
		if(toTest instanceof AttributeFolderTreeParent) return false;
		if(toTest instanceof FolderTreeParent) return false;
		if(toTest instanceof PathSearchTreeParent) return false;
		if(toTest instanceof TreeObject) return true;
		return false;
	}

}
