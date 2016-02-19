package metardf.ui.views.entities.model;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;

public class SemanticElementPropertySource implements IPropertySource {
	protected TreeObject entityParent;
	public static final String PROPERTY_NAME = "Name";
	public static final String PROPERTY_DESCRIPTION = "Description";
	public static final String PROPERTY_REPOSITORY_NAME = "RepositoryName";
	public static final String PROPERTY_REPOSITORY_URI = "RepositoryUri";
	
	public String stringName = "";
	public String stringDescription = "";
	public String stringRepositoryName = "";
	public String stringRepositoryUri = "";

	private final Object PropertiesTable[][] = 
		{
		  {PROPERTY_NAME, new TextPropertyDescriptor(PROPERTY_NAME,"Name")},
		  {PROPERTY_DESCRIPTION, new TextPropertyDescriptor(PROPERTY_DESCRIPTION,"Description")},
		  {PROPERTY_REPOSITORY_NAME, new TextPropertyDescriptor(PROPERTY_REPOSITORY_NAME,"RepositoryName")},
		  {PROPERTY_REPOSITORY_URI, new TextPropertyDescriptor(PROPERTY_REPOSITORY_URI,"RepositoryUri")}
		  //, ...
		};
	
	public SemanticElementPropertySource(TreeObject entityParent) {
		super();
		this.entityParent = entityParent;
		initProperties();
	}
	
	protected void initProperties() {
		ISemanticElement semanticElement = entityParent.getSemanticElement();

		if (semanticElement == null) {
			return;
		}	
		stringName = semanticElement.getName();
		stringDescription = semanticElement.getDescription();
		
		if(semanticElement instanceof ISemanticClass){
			stringRepositoryName = ((ISemanticClass) semanticElement).getResourceFrom().getName();
			stringRepositoryUri = ((ISemanticClass) semanticElement).getResourceFrom().getIdToString();
		}
	}
	
	@Override
	public Object getEditableValue() {
		return this;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		IPropertyDescriptor[] propertyDescriptors = new IPropertyDescriptor[PropertiesTable.length];

		for (int i=0;i<PropertiesTable.length;i++) {				
			PropertyDescriptor descriptor;

			descriptor = (PropertyDescriptor)PropertiesTable[i][1];
			propertyDescriptors[i] = (IPropertyDescriptor)descriptor;
			descriptor.setCategory("Basic");
		}
				
		// Return it.
		return propertyDescriptors;
	}

	@Override
	public Object getPropertyValue(Object id) {
		if (id.equals(PROPERTY_NAME))
			return stringName;
		
		if (id.equals(PROPERTY_DESCRIPTION))
			return stringDescription;

		if (id.equals(PROPERTY_REPOSITORY_NAME))
			return stringRepositoryName;
		
		if (id.equals(PROPERTY_REPOSITORY_URI))
			return stringRepositoryUri;
		
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	@Override
	public void setPropertyValue(Object name, Object value) {
		firePropertyChanged((String)name,value);
		
		if (name.equals(PROPERTY_NAME)) {
			stringName = (String)value;	
			return;
		}
		
		if (name.equals(PROPERTY_DESCRIPTION)) {
			stringDescription = (String)value;	
			return;
		}
		
		if (name.equals(PROPERTY_REPOSITORY_NAME)) {
			stringRepositoryName = (String)value;	
			return;
		}
		
		if (name.equals(PROPERTY_REPOSITORY_URI)) {
			stringRepositoryUri = (String)value;	
			return;
		}
	}
	
	protected void firePropertyChanged(String propName, Object value) {
		ISemanticElement semanticElement = entityParent.getSemanticElement();
		
		if (semanticElement == null) {
			return;
		}
		
		if (propName.equals(PROPERTY_NAME)) {
			semanticElement.setName((String)value);
			entityParent.setName((String) value);
			return;
		}
		
		if (propName.equals(PROPERTY_DESCRIPTION)) {
			semanticElement.setDescription((String)value);
			return;
		}
		
	}

	@Override
	public void resetPropertyValue(Object id) {
	}
}
