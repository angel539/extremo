package metardf.core.rdf.assistant.model;

import org.apache.jena.rdf.model.Resource;

import metaRDF.core.model.impl.SemanticClass;

public class RDFDataSemanticClass extends SemanticClass {
	Resource id;
	
	public RDFDataSemanticClass(Resource id, String name, String description){
		super(id, name, description);
		this.id = id;
	}
	
	@Override
	public String getIdToString() {
		// TODO Auto-generated method stub
		return id.getURI();
	}

	@Override
	public void setIdToString(String idString) {
		
	}

	@Override
	public String toString() {
		return getIdToString();
	}
}
