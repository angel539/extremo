package metardf.ui.zest.views.inheritance;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;

public class InheritanceGraphViewPartNodeContentProvider extends ArrayContentProvider  implements IGraphEntityContentProvider {
	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof ISemanticClass) {
			List<ISemanticClass> connections = new ArrayList<ISemanticClass>();
			
			for(ISemanticClass superC : ((ISemanticClass) entity).getSuperclasses()){
				connections.add(superC);
			}
			return connections.toArray();
		}
		
		throw new RuntimeException("Type not supported");
	}
}