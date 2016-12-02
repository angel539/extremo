package uam.extremo.ui.zest.views.relations;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import semanticmanager.SemanticNode;

public class RelationshipViewPartNodeContentProvider extends ArrayContentProvider  implements IGraphEntityContentProvider {
	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof SemanticNode) {
			if(((SemanticNode) entity).getProperties() != null){
				return ((SemanticNode) entity).getProperties().toArray();
			}	
		}
		
		return null;
	}
}