package metardf.ui.zest.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class RelationFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		//if (element instanceof MyNode) {
		//      MyNode node = (MyNode) element;
		//      return node.getName().toLowerCase().contains("a");
		//}
		return true;
	}

}
