package metardf.core.ecore.assistant.model;

import org.eclipse.emf.ecore.EClass;

import metaRDF.core.model.impl.SemanticClass;

public class EcoreSemanticClass extends SemanticClass{
	//private static final long serialVersionUID = 1L;
	EClass id = null;
	String idString = null;
	
	public EcoreSemanticClass(){
		
	}
	
	public EcoreSemanticClass(EClass id, String name, String description){
		super(id, name, description);
		this.id = id;
	}

	@Override
	public String getIdToString() {
		this.idString = id.getName();
		return this.idString;
	}

	@Override
	public void setIdToString(String idString) {
		this.idString = idString;
	}
}
