package metardf.core.ecore.assistant.model;
import org.eclipse.emf.ecore.EReference;

import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.impl.ObjectProperty;

public class EcoreObjectProperty extends ObjectProperty{
	private static final long serialVersionUID = -487348587126061637L;
	private transient EReference id = null;
	private ISemanticClass range = null;
	
	public EcoreObjectProperty(){
		super();
	}
	
	public EcoreObjectProperty(EReference id, ISemanticClass range, String name, boolean isFromSuper, String description) {
		super(id, range, name, isFromSuper, description);
		this.setId(id);
		this.range = range;
	}

	@Override
	public ISemanticClass getRange() {
		return this.range;
	}

	@Override
	public void setRange(ISemanticClass range) {
		this.range = range;
	}

	public EReference getId() {
		return id;
	}

	public void setId(EReference id) {
		this.id = id;
	}
}
