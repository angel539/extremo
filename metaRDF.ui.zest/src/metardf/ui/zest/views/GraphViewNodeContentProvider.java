package metardf.ui.zest.views;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import metaRDF.core.model.ISemanticClass;

public class GraphViewNodeContentProvider extends ArrayContentProvider  implements IGraphEntityContentProvider {
	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof ISemanticClass) {
			return ((ISemanticClass) entity).getReferences().toArray();
		}
		
		return null;
	}
}
