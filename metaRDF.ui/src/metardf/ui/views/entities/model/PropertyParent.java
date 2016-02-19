package metardf.ui.views.entities.model;

import org.eclipse.ui.views.properties.IPropertySource;

public class PropertyParent extends TreeParent {	
	public PropertyParent(Object object) {	
		super(object);
	}
	
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySource.class)
			return new SemanticElementPropertySource(this);
		return null;
	}
}
