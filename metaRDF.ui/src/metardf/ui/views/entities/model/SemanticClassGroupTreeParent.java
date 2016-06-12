package metardf.ui.views.entities.model;

import java.util.Comparator;
import java.util.List;
import org.eclipse.ui.views.properties.IPropertySource;

import metaRDF.core.model.ISemanticClass;

public class SemanticClassGroupTreeParent extends TreeParent{
	private static final long serialVersionUID = -1795561332548997268L;
	
	private List<ISemanticClass> semanticClasses;

	public List<ISemanticClass> getSemanticClasses() {
		return semanticClasses;
	}

	public void setSemanticClasses(List<ISemanticClass> semanticClasses) {
		this.semanticClasses = semanticClasses;
	}

	public SemanticClassGroupTreeParent(String name, List<ISemanticClass> semanticClasses) {
		super(name);
		this.semanticClasses = semanticClasses;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IPropertySource.class)
			return new SemanticElementPropertySource(this);
		return null;
	}
	
	public int getMax_weight() {
		return this.semanticClasses.stream()
	        .max(Comparator.comparing(item -> item.getWeight()))
	        .get().getWeight();
	}
}