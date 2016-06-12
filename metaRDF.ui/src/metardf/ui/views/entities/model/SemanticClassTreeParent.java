package metardf.ui.views.entities.model;

import org.eclipse.ui.views.properties.IPropertySource;

import metaRDF.core.model.ISemanticClass;

public class SemanticClassTreeParent extends TreeParent{
	private static final long serialVersionUID = -2219657201043815668L;

	public SemanticClassTreeParent(ISemanticClass semanticclass) {
		super(semanticclass);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IPropertySource.class)
			return new SemanticElementPropertySource(this);
		return null;
	}
}