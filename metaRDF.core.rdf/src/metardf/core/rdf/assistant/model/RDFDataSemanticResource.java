package metardf.core.rdf.assistant.model;

import metaRDF.core.model.impl.SemanticResource;

public class RDFDataSemanticResource extends SemanticResource {
	public RDFDataSemanticResource(Object id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String repositoryString = "resource";
		repositoryString = repositoryString + " @name=" + getName();
		repositoryString = repositoryString + " @description=" + getDescription();
		repositoryString = repositoryString + " @uri=" + getId();
		return repositoryString;
	}
}
