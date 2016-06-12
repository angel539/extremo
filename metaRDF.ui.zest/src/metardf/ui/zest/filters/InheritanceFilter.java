package metardf.ui.zest.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import metaRDF.core.model.ISemanticClass;

public class InheritanceFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		/*if (element instanceof ISemanticClass) {
		      ISemanticClass node = (ISemanticClass) element;
		      return node.getName().toLowerCase().contains("process");
		}*/
		return true;
	}

}
