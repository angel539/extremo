package metardf.core.ecore.assistant.model;

import org.eclipse.emf.ecore.EClass;

import metaRDF.core.model.impl.SemanticClass;

public class EcoreSemanticClass extends SemanticClass{
	EClass id = null;
			
	public EcoreSemanticClass(EClass id, String name, String description){
		super(id, name, description);
		this.id = id;
	}

	@Override
	public String getIdToString() {
		// TODO Auto-generated method stub
		return id.getName();
	}
}
