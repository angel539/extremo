package metardf.core.rdf.assistant.model;

import org.apache.jena.rdf.model.Resource;

import metaRDF.core.model.impl.SemanticClass;

public class RDFDataSemanticClass extends SemanticClass {
	private static final long serialVersionUID = -5127435167642788009L;
	Resource id;
	
	public RDFDataSemanticClass(Resource id, String name, String description, boolean isExplored){
		super(id, name, description);
		this.id = id;
	}
}
