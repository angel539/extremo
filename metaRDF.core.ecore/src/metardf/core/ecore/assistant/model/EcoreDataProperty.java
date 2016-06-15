package metardf.core.ecore.assistant.model;

import org.eclipse.emf.ecore.EAttribute;

import metaRDF.core.model.impl.DataProperty;

public class EcoreDataProperty extends DataProperty{
	private static final long serialVersionUID = -683290629760597196L;
	private transient EAttribute id = null;
	
	public EcoreDataProperty(){
		super();
	}
	
	public EcoreDataProperty(EAttribute id, String name, String type, boolean isFromSuper, String description) {
		super(id, name, type, isFromSuper, description);
		this.setId(id);
	}

	@Override
	public String toString() {
		return "[" + getName() + ", " + getId() + "]";
	}

	public EAttribute getId() {
		return id;
	}

	public void setId(EAttribute id) {
		this.id = id;
	}	
}