package metardf.core.rdf.assistant.model;

import metaRDF.core.model.impl.SemanticResource;

public class RDFDataSemanticResource extends SemanticResource {
	private static final long serialVersionUID = 4524312679839828133L;

	public RDFDataSemanticResource(Object id, String name) {
		super(id, name);
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
