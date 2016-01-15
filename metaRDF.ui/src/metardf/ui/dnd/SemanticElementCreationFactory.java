package metardf.ui.dnd;

import org.eclipse.gef.requests.CreationFactory;

import metaRDF.core.model.impl.SemanticClass;

public class SemanticElementCreationFactory implements CreationFactory {/*extends SemanticClass*/
	private String name = "";
	private String uri = "";
	
	@Override
	public Object getNewObject() {
		SemanticClass semanticClass = new SemanticClass(name, uri, null, null);
		return semanticClass;
	}

	@Override
	public Object getObjectType() {
		return SemanticClass.class;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setUri(String uri){
		this.uri = uri;
	}
}
