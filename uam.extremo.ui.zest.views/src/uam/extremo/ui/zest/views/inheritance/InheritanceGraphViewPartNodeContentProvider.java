package uam.extremo.ui.zest.views.inheritance;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import semanticmanager.SemanticNode;

public class InheritanceGraphViewPartNodeContentProvider extends ArrayContentProvider  implements IGraphEntityContentProvider {
	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof SemanticNode) {
			return ((SemanticNode) entity).getSupers().toArray();
		}
		
		return null;
	}
}