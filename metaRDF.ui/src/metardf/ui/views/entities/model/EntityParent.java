package metardf.ui.views.entities.model;

import org.eclipse.ui.views.properties.IPropertySource;

import metaRDF.core.model.ISemanticClass;

public class EntityParent extends TreeParent{
	public EntityParent(ISemanticClass semanticclass) {
		super(semanticclass);
	}
	
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySource.class)
			return new SemanticElementPropertySource(this);
		return null;
	}
}