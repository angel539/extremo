package metardf.ui.views.entities.model;

import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.IProperty;

public class PropertyParent extends TreeParent {	
	public PropertyParent(Object object) {	
		super(object);
		
		if(object instanceof IObjectProperty){
			this.name = this.name + " : " + ((IObjectProperty) object).getRangeAsSemanticClass().getName();
		}
		
		if((object instanceof IProperty) && (((IProperty) object).isFromSuper())){
			this.name = this.name + " (super)";
		}
	}	
}
