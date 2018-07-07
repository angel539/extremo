package uam.extremo.extensions;

import java.util.ArrayList;
import java.util.List;

import uam.extremo.core.Constraint;
import uam.extremo.core.ConstraintInterpreter;
import uam.extremo.core.ConstraintResult;
import uam.extremo.core.DataProperty;
import uam.extremo.core.ExtendedSemanticmanagerFactory;
import uam.extremo.core.MetaData;
import uam.extremo.core.NamedElement;
import uam.extremo.core.ObjectProperty;
import uam.extremo.core.Property;
import uam.extremo.core.Resource;
import uam.extremo.core.ResourceElement;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.Type;

public interface IFormatAssistant {
	public static final String CONSTRAINT_EXTENSIONS_ID = "extremo.core.extensions.constraintinterpreter";
	
    public boolean loadAndValidate(
    		uam.extremo.core.Resource semanticResource, 
    		ConstraintInterpreter interpreter);
    
    public void toDataProperty(SemanticNode parent);
    public void toObjectProperty(SemanticNode parent);
    public void toSuper(SemanticNode parent);
    public void toSuper(DataProperty parent);
    public void toSuper(ObjectProperty parent);
    public void toInverseOf(ObjectProperty parent);

    default SemanticNode searchSemanticNodeByName(Resource resource, String name) {
    	if(resource == null || name == null) return null;
    	
    	for(ResourceElement resourceElement : resource.getResourceElements()){
    		if (resourceElement instanceof SemanticNode) {
				SemanticNode node = (SemanticNode) resourceElement;
				
				if(node.getName().equals(name)){
	    			return node;
	    		}
		}
    	}
    	
    	return null;
    }
    
    default DataProperty searchDataPropertyByName(SemanticNode semanticNode, String name) {
	    	if(semanticNode == null || name == null) return null;
	    	
		for(Property property : semanticNode.getProperties()){
			if(property instanceof DataProperty && property.getName().equals(name)){
	    			return (DataProperty) property;
	    		}
		}
	    	
	    	return null;
    }
    
    default ObjectProperty searchObjectPropertyByName(SemanticNode semanticNode, String name) {
    		if(semanticNode == null || name == null) return null;
    	
		for(Property property : semanticNode.getProperties()){
			if(property instanceof ObjectProperty && property.getName().equals(name)){
    				return (ObjectProperty) property;
    			}
		}
    	
    		return null;
    }
    
    default Resource createResource(String uri, String name, String description, boolean active, boolean alive, Resource descriptor) {
	    	uam.extremo.core.Resource resource = ExtendedSemanticmanagerFactory.eINSTANCE.createResource();
	    	resource.setUri(uri);
	    	resource.setName(name);
	    	resource.setDescription(description);
	    	resource.setActive(active);
	    	resource.setAlive(alive);
	    	resource.getDescriptors().add(descriptor);
	    return resource;
    }
    
    default Constraint createConstraint(String type, String name, String body) {
	    	Constraint constraint = ExtendedSemanticmanagerFactory.eINSTANCE.createConstraint();
	    	constraint.setType(type);
	    	constraint.setName(name);
	    	constraint.setBody(new String(body));
        return constraint;
    }
    
    default boolean addConstraintToElement(NamedElement element, Constraint constraint){
	    	element.getConstraints().add(constraint);
	    	return true;
    }
    
    default SemanticNode createSemanticNodeWithoutDescriptor(Object id, String name, String description, boolean isAbstract) {
	    	SemanticNode semanticNode = ExtendedSemanticmanagerFactory.eINSTANCE.createSemanticNode();
	    	semanticNode.setTrace(id);
	    	semanticNode.setName(name);
	    	semanticNode.setDescription(description);
	    	semanticNode.setAbstract(isAbstract);
	    	return semanticNode;
    }
    
    default SemanticNode createSemanticNode(Object id, String name, String description, SemanticNode descriptor) {
	    	SemanticNode semanticNode = ExtendedSemanticmanagerFactory.eINSTANCE.createSemanticNode();
	    	semanticNode.setTrace(id);
	    	semanticNode.setName(name);
	    	semanticNode.setDescription(description);
	    	semanticNode.getDescriptors().add(descriptor);
	    return semanticNode;
    }
    
    default ConstraintResult createConstraintResult(ConstraintInterpreter constraintInterpreter, Resource semanticResource, Constraint constraint) {
	    	ConstraintResult constraintResult = ExtendedSemanticmanagerFactory.eINSTANCE.createConstraintResult();
	    	constraintResult.setContext(semanticResource);
			constraintResult.setConstraint(constraint);
	    	constraintInterpreter.getEvals().add(constraintResult);
	        return constraintResult;
    }
    
    default boolean addNamedElementToConstraintResult(ConstraintResult constraintResult, NamedElement unsat){
    		constraintResult.getUnsat().add(unsat);
    		//System.out.println(unsat.getName());
    		return true;
    }
    
    default boolean addSemanticNodeToResource(Resource resource, SemanticNode node){
    		if(resource == null || node == null) return false;
    		resource.getResourceElements().add(node);
    		node.setResourceFrom(resource);
    		return true;
    }
    
    default boolean addSuperClassToNode(SemanticNode node, SemanticNode superclass){
	    	if(node == null || superclass == null) return false;
	    	node.getSupers().add(superclass);
	    	return true;
    }
    
    default boolean addSubClassToNode(SemanticNode node, SemanticNode subclass){
	    	if(node == null || subclass == null) return false;
	    	node.getSubs().add(subclass);
	    	return true;
    }
    
    default boolean addSuperClassToObjectProperty(ObjectProperty node, ObjectProperty superproperty){
	    	if(node == null || superproperty == null) return false;
	    	node.getSupers().add(superproperty);
	    	return true;
    }
    
    default boolean addInverseOfToObjectProperty(ObjectProperty node, ObjectProperty inverseOf){
	    	if(node == null || inverseOf == null) return false;
	    	node.setInverseOf(inverseOf);
	    	return true;
    }
    
    default boolean addSubClassToObjectProperty(ObjectProperty node, ObjectProperty subproperty){
	    	if(node == null || subproperty == null) return false;
	    	node.getSubs().add(subproperty);
	    	return true;
    }
    
    default boolean addSuperClassToDataProperty(DataProperty node, DataProperty superdataproperty){
	    	if(node == null || superdataproperty == null) return false;
	    	node.getSupers().add(superdataproperty);
	    	return true;
    }
    
    default boolean addSubClassToDataProperty(DataProperty node, DataProperty subdataproperty){
	    	if(node == null || subdataproperty == null) return false;
	    	node.getSubs().add(subdataproperty);
	    	return true;
    }
    
    default DataProperty createDataProperty(Object id, String name, int lowerbound, int upperbound, String description, Type type){
	    	DataProperty dataProperty = ExtendedSemanticmanagerFactory.eINSTANCE.createDataProperty();
	    	dataProperty.setTrace(id);
	    	dataProperty.setName(name);
	    	dataProperty.setDescription(description);
	    	dataProperty.setType(type);
	    	dataProperty.setLowerBound(lowerbound);
	    	dataProperty.setUpperBound(upperbound);
    	
        return dataProperty;
    }
    
    default MetaData createMetaData(String key, String value){
	    	MetaData metadata = ExtendedSemanticmanagerFactory.eINSTANCE.createMetaData();
	    	metadata.setKey(key);
	    	metadata.setValue(value);
        return metadata;
    }
    
    default DataProperty createDataProperty(DataProperty descriptor, String value){
	    	DataProperty dataProperty = ExtendedSemanticmanagerFactory.eINSTANCE.createDataProperty();
	    	dataProperty.setTrace(descriptor.getTrace());
	    	dataProperty.setName(descriptor.getName());
	    	dataProperty.setDescription(descriptor.getDescription());
	    	dataProperty.setType(descriptor.getType());
	    	dataProperty.getDescriptors().add(descriptor);
	    	dataProperty.setValue(value);
    	
        return dataProperty;
    }
    
    default boolean addDataPropertyToNode(SemanticNode node, DataProperty property){
	    	if(node == null || property == null) return false;
	    	node.getProperties().add((Property) property);
	    	return true;
    }
    
    default boolean addMetaDataToNamedElement(NamedElement namedElement, MetaData metaData){
	    	if(namedElement == null || metaData == null) return false;
	    	namedElement.getMetadata().add((MetaData) metaData);
	    	return true;
    }
    
    default ObjectProperty createObjectProperty(Object id, String name, int lowerbound, int upperbound, SemanticNode range){
	    	ObjectProperty objectProperty = ExtendedSemanticmanagerFactory.eINSTANCE.createObjectProperty();
	    	objectProperty.setTrace(id);
	    	objectProperty.setName(name);
	    	objectProperty.setLowerBound(lowerbound);
	    	objectProperty.setUpperBound(upperbound);
	    	
	    	objectProperty.setRange(range);
        return objectProperty;
    }
    
    default ObjectProperty createObjectProperty(Object id, String name, ObjectProperty descriptor, SemanticNode range){
	    	ObjectProperty objectProperty = ExtendedSemanticmanagerFactory.eINSTANCE.createObjectProperty();
	    	objectProperty.setTrace(id);
	    	objectProperty.setName(name);
	    	objectProperty.setRange(range);
	    	objectProperty.getDescriptors().add(descriptor);
        return objectProperty;
    }
    
    default boolean addObjectPropertyToNode(SemanticNode node, ObjectProperty property){
	    	if(node == null || property == null) return false;
	    	
	    	node.getProperties().add((Property) property);
	    	
	    	return true;
    }
    
    default NamedElement namedElementFromName(Resource resource, String name){
	    	List<NamedElement> returnNamedElements = new ArrayList<>();
	    	
	    	resource.eAllContents().forEachRemaining(
	    			element -> {
	    				if (element instanceof NamedElement) {
							NamedElement namedElement = (NamedElement) element;
							if(namedElement.getName().compareTo(name) == 0){
								returnNamedElements.add(namedElement);
								return;
							}
						}
	    			}
	    	);
    	
	    	if(returnNamedElements.isEmpty()) return null;
	    	return returnNamedElements.get(0);
	    }
	    
	    default NamedElement namedElementFromId(Resource resource, Object id){
	    	List<NamedElement> returnNamedElements = new ArrayList<>();
	    	
	    	resource.eAllContents().forEachRemaining(
	    			element -> {
	    				if (element instanceof NamedElement) {
							NamedElement namedElement = (NamedElement) element;
							if(namedElement.getTrace().equals(id)){
								returnNamedElements.add(namedElement);
								return;
							}
						}
	    			}
	    	);
	    	
	    	if(returnNamedElements.isEmpty()) return null;
	    	return returnNamedElements.get(0);
    }
    
    /*default ConstraintInterpreter callConstraintExtension(String typeConstraint){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(CONSTRAINT_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			Bundle bundle = null;
			IContributor contributor = extension.getContributor();
			
			if (contributor instanceof RegistryContributor) {
				long id = Long.parseLong(((RegistryContributor) contributor).getActualId());
				Bundle thisBundle = FrameworkUtil.getBundle(getClass());
				bundle = thisBundle.getBundleContext().getBundle(id);
			}
			else {
				bundle = Platform.getBundle(contributor.getName());          
			}
			
            if (extension.getAttribute("type").equals(typeConstraint)) {
            	Object o;
				try {
					o = extension.createExecutableExtension("class");
					if (o instanceof ConstraintInterpreter) {
						ConstraintInterpreter constraintInterpreter = (ConstraintInterpreter) o;
	                    return constraintInterpreter;
	                }
				} catch (CoreException e) {
					return null;
				}
            }
		}
		
		return null;
	}*/
    
    default Type defineIntType(){
    		return Type.INT;
    }
    
    default Type defineBooleanType(){
    		return Type.BOOLEAN;
    }
    
    default Type defineDoubleType(){
    		return Type.DOUBLE;
    }
    
    default Type defineFloatType(){
    		return Type.FLOAT;
    }
    
    default Type defineStringType(){
    		return Type.STRING;
    }
}
