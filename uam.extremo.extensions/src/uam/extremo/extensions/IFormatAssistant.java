package uam.extremo.extensions;

import semanticmanager.Constraint;
import semanticmanager.DataProperty;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.MetaData;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.Property;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SemanticNode;
import semanticmanager.Type;

public interface IFormatAssistant {
    public boolean load(semanticmanager.Resource semanticResource);
    public void toDataProperty(SemanticNode parent);
    public void toObjectProperty(SemanticNode parent);
    public void toSuper(SemanticNode parent);

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
    	semanticmanager.Resource resource = ExtendedSemanticmanagerFactory.eINSTANCE.createResource();
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
    	constraint.setBody(body);
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
    	//semanticNode.getDescriptors().add(descriptor);
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
    
    default SemanticNode semanticNodeFromName(Resource resource, String name){
    	for(ResourceElement resourceElement : resource.getResourceElements()){
    		if(resourceElement instanceof SemanticNode){
    			SemanticNode node = (SemanticNode) resourceElement;
    			
    			if(node.getName().equals(name)){
        			return node;
        		}
    		}	
    	}
    	return null;
    }
    
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
