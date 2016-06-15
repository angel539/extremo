package metardf.core.ecore.assistant.model;

import org.eclipse.emf.ecore.EClass;

import metaRDF.core.model.impl.SemanticClass;

public class EcoreSemanticClass extends SemanticClass{
	private static final long serialVersionUID = 60635544113911255L;
	private transient EClass id = null;
	
	public EcoreSemanticClass(EClass obj, String name, String description){
		super(obj, name, description);
		this.setId(obj);
	}

	public EClass getId() {
		return id;
	}

	public void setId(EClass id) {
		this.id = id;
	}
}
