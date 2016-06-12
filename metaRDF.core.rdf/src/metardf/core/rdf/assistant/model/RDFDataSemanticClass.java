package metardf.core.rdf.assistant.model;

import org.apache.jena.rdf.model.Resource;

import metaRDF.core.model.impl.SemanticClass;

public class RDFDataSemanticClass extends SemanticClass {
	Resource id;
	
	public RDFDataSemanticClass(Resource id, String name, String description, boolean isExplored){
		super(id, name, description);
		this.id = id;
	}
}
