package metardf.ui.views.entities.model;

import org.eclipse.ui.views.properties.IPropertySource;

public class ObjectPropertyTreeParent extends TreeParent {	
	private static final long serialVersionUID = 6708641570839080002L;

	public ObjectPropertyTreeParent(Object object) {	
		super(object);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IPropertySource.class)
			return new SemanticElementPropertySource(this);
		return null;
	}
}
