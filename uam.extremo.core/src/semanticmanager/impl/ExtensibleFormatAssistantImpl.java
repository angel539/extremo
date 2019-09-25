package semanticmanager.impl;

import semanticmanager.impl.FormatAssistantImpl;
import semanticmanager.*;

public abstract class ExtensibleFormatAssistantImpl extends FormatAssistantImpl{
	public final void guardSemanticNode(Resource resource, SemanticNode semanticNode){
		resource.getGuardSemanticNodes().add(semanticNode);
	}
	
	public final SemanticNode searchSemanticNodeByName(Resource resource, String name) {
		return resource.getGuardSemanticNodes().stream()
				.filter(item -> item.getName().equals(name))
					.findAny()
					.orElse(null);
    }
	
	public final DataProperty searchDataPropertyByName(SemanticNode semanticNode, String name) {
		return (DataProperty) semanticNode.getProperties().stream()
				.filter(item -> item.getName().equals(name) && item instanceof DataProperty)
				.findAny()
				.orElse(null);
    }
	
	public final ObjectProperty searchObjectPropertyByName(SemanticNode semanticNode, String name) {
		return (ObjectProperty) semanticNode.getProperties().stream()
				.filter(item -> item.getName().equals(name) && item instanceof ObjectProperty)
				.findAny()
				.orElse(null);
    }
	
	public final SemanticNode searchSemanticNodeById(Resource resource, Object id) {
		return resource.getGuardSemanticNodes().stream()
				.filter(item -> item.getTrace().equals(id))
					.findAny()
					.orElse(null);
    }
	
	public final Property searchPropertyById(Resource resource, Object id) {
		for(SemanticNode semanticNode : resource.getGuardSemanticNodes()){
			for(Property property : semanticNode.getProperties()){
				if(property.getTrace().equals(id))
					return property;
			}
		}
		
		return null;
    }
	
	public final Resource createResource(String uri, String name, String description, Resource descriptor) {
    	semanticmanager.Resource resource = SemanticmanagerFactory.eINSTANCE.createResource();
    	resource.setUri(uri);
    	resource.setName(name);
    	resource.setDescription(description);
    	resource.getDescriptors().add(descriptor);
	    return resource;
    }
    
	public final Constraint createConstraint(String type, String name, String body) {
    	Constraint constraint = SemanticmanagerFactory.eINSTANCE.createConstraint();
    	constraint.setType(type);
    	constraint.setName(name);
    	constraint.setBody(new String(body));
        return constraint;
    }
    
	public final boolean addConstraintToElement(NamedElement element, Constraint constraint){
    	element.getConstraints().add(constraint);
    	return true;
    }
    
	public final SemanticNode createSemanticNodeWithoutDescriptor(Object id, String name, String description, boolean isAbstract) {
    	SemanticNode semanticNode = SemanticmanagerFactory.eINSTANCE.createSemanticNode();
    	semanticNode.setTrace(id);
    	semanticNode.setName(name);
    	semanticNode.setDescription(description);
    	semanticNode.setAbstract(isAbstract);
    	return semanticNode;
    }
    
	public final SemanticNode createSemanticNode(Object id, String name, String description, SemanticNode descriptor) {
	    SemanticNode semanticNode = SemanticmanagerFactory.eINSTANCE.createSemanticNode();
	    semanticNode.setTrace(id);
	    semanticNode.setName(name);
	    semanticNode.setDescription(description);
	    semanticNode.getDescriptors().add(descriptor);
	    return semanticNode;
    }
    
	public final ConstraintResult createConstraintResult(ConstraintInterpreter constraintInterpreter, Resource semanticResource, Constraint constraint) {
	    ConstraintResult constraintResult = SemanticmanagerFactory.eINSTANCE.createConstraintResult();
	    constraintResult.setContext(semanticResource);
		constraintResult.setConstraint(constraint);
	    constraintInterpreter.getEvals().add(constraintResult);
	    return constraintResult;
    }
    
	public final boolean addNamedElementToConstraintResult(ConstraintResult constraintResult, NamedElement unsat){
    	constraintResult.getUnsat().add(unsat);
    	return true;
    }
    
	public final boolean addSemanticNodeToResource(Resource resource, SemanticNode node){
    	if(resource == null || node == null) return false;
    	resource.getResourceElements().add(node);
    	node.setResourceFrom(resource);
    	return true;
    }
    
	public final synchronized boolean addSuperClassToNode(SemanticNode node, SemanticNode superclass){
	    if(node == null || superclass == null) return false;
	    node.getSupers().add(superclass);
	    return true;
    }
    
	public final boolean addSubClassToNode(SemanticNode node, SemanticNode subclass){
	    if(node == null || subclass == null) return false;
	    node.getSubs().add(subclass);
	    return true;
    }
    
	public final boolean addSuperClassToObjectProperty(ObjectProperty node, ObjectProperty superproperty){
	    if(node == null || superproperty == null) return false;
	    node.getSupers().add(superproperty);
	    return true;
    }
    
	public final boolean addInverseOfToObjectProperty(ObjectProperty node, ObjectProperty inverseOf){
	    if(node == null || inverseOf == null) return false;
	    node.setInverseOf(inverseOf);
	    return true;
    }
    
	public final boolean addSubClassToObjectProperty(ObjectProperty node, ObjectProperty subproperty){
	    if(node == null || subproperty == null) return false;
	    node.getSubs().add(subproperty);
	    return true;
    }
    
	public final boolean addSuperClassToDataProperty(DataProperty node, DataProperty superdataproperty){
	    if(node == null || superdataproperty == null) return false;
	    node.getSupers().add(superdataproperty);
	    return true;
    }
    
	public final boolean addSubClassToDataProperty(DataProperty node, DataProperty subdataproperty){
	    if(node == null || subdataproperty == null) return false;
	    node.getSubs().add(subdataproperty);
	    return true;
    }
    
	public final DataProperty createDataProperty(Object id, String name, int lowerbound, int upperbound, String description, Type type){
	    DataProperty dataProperty = SemanticmanagerFactory.eINSTANCE.createDataProperty();
	    dataProperty.setTrace(id);
	    dataProperty.setName(name);
	    dataProperty.setDescription(description);
	    dataProperty.setType(type);
	    dataProperty.setLowerBound(lowerbound);
	    dataProperty.setUpperBound(upperbound);
	    return dataProperty;
    }
    
	public final MetaData createMetaData(String key, String value){
	    MetaData metadata = SemanticmanagerFactory.eINSTANCE.createMetaData();
	    metadata.setKey(key);
	    metadata.setValue(value);
	    return metadata;
    }
    
	public final DataProperty createDataProperty(DataProperty descriptor, String value){
	    DataProperty dataProperty = SemanticmanagerFactory.eINSTANCE.createDataProperty();
	    dataProperty.setTrace(descriptor.getTrace());
	    dataProperty.setName(descriptor.getName());
	    dataProperty.setDescription(descriptor.getDescription());
	    dataProperty.setType(descriptor.getType());
	    dataProperty.getDescriptors().add(descriptor);
	    dataProperty.setValue(value);	
        return dataProperty;
    }
    
	public final synchronized boolean addDataPropertyToNode(SemanticNode node, DataProperty property){
	    if(node == null || property == null) return false;
	    node.getProperties().add((Property) property);
	    
	    return true;
    }
    
	public final boolean addMetaDataToNamedElement(NamedElement namedElement, MetaData metaData){
	    if(namedElement == null || metaData == null) return false;
	    namedElement.getMetadata().add((MetaData) metaData);  
	    return true;
    }
    
	public final ObjectProperty createObjectProperty(Object id, String name, int lowerbound, int upperbound, SemanticNode range){
	    ObjectProperty objectProperty = SemanticmanagerFactory.eINSTANCE.createObjectProperty();
	    objectProperty.setTrace(id);
	    objectProperty.setName(name);
	    objectProperty.setLowerBound(lowerbound);
	    objectProperty.setUpperBound(upperbound);	
	    objectProperty.setRange(range);
	    return objectProperty;
    }
    
	public final ObjectProperty createObjectProperty(Object id, String name, ObjectProperty descriptor, SemanticNode range){
	    ObjectProperty objectProperty = SemanticmanagerFactory.eINSTANCE.createObjectProperty();
	    objectProperty.setTrace(id);
	    objectProperty.setName(name);
	    objectProperty.setRange(range);
	    objectProperty.getDescriptors().add(descriptor);
	    return objectProperty;
    }
    
	public final synchronized boolean addObjectPropertyToNode(SemanticNode node, ObjectProperty property){
	    if(node == null || property == null) return false;	
	    node.getProperties().add((Property) property);	
	    return true;
    }
    
	public final Type defineIntType(){
    	return Type.INT;
    }
    
	public final Type defineBooleanType(){
    	return Type.BOOLEAN;
    }
    
	public final Type defineDoubleType(){
    	return Type.DOUBLE;
    }
    
	public final Type defineFloatType(){
    	return Type.FLOAT;
    }
    
	public final Type defineStringType(){
    	return Type.STRING;
    }
}
