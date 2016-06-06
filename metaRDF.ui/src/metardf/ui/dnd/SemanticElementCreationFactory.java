package metardf.ui.dnd;

import org.eclipse.gef.requests.CreationFactory;

import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.impl.SemanticClass;

public class SemanticElementCreationFactory implements CreationFactory {/*extends SemanticClass*/
	private String name = "";
	private String uri = "";
	
	@Override
	public Object getNewObject() {
		Class<? extends SemanticClass> c;
		try {
			c = Class.forName("metaRDF.core.model.impl").asSubclass(SemanticClass.class);
			SemanticClass semanticClass = c.newInstance();
			semanticClass.setName(new String(name));
			semanticClass.setId(new String(uri));
			//semanticClass.setDescription(null);
			return semanticClass;
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		} catch (InstantiationException e) {
			//e.printStackTrace();
		} catch (IllegalAccessException e) {
			//e.printStackTrace();
		}  
		return null;
		
	}

	@Override
	public Object getObjectType() {
		return ISemanticClass.class;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setUri(String uri){
		this.uri = uri;
	}
}
