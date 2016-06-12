package metardf.ui.zest.views.relations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;

public class RelationshipViewPartNodeContentProvider extends ArrayContentProvider  implements IGraphEntityContentProvider {
	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof ISemanticClass) {
			List<ISemanticClass> connections = new ArrayList<ISemanticClass>();
			for(IObjectProperty reference : ((ISemanticClass) entity).getReferences()){
				//reference.getRange().setSuper(false);
				connections.add(reference.getRange());
			}
			
			return connections.toArray();
		}
		
		throw new RuntimeException("Type not supported");
	}
}