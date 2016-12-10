package uam.extremo.extensions;

import java.util.List;

import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Property;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.Type;

public interface IFormatAssistant {
    public boolean load(semanticmanager.Resource semanticResource);
    public void toDataProperty(SemanticNode parent);
    public void toObjectProperty(SemanticNode parent);
    public void toDataProperty(SemanticNode parent, boolean supers, boolean equivs);
    public void toObjectProperty(SemanticNode parent, boolean supers, boolean equivs);
    public List<SemanticNode> getSiblings(SemanticNode parent);
    public List<SemanticNode> getRelatedClasses(SemanticNode parent, boolean supers, boolean equivs);
    public void toSuper(SemanticNode parent);
    public void toSub(SemanticNode parent);
    public void toSuper(SemanticNode parent, boolean direct);
    public void toSub(SemanticNode parent, boolean direct);
    public List<ObjectProperty> getPath(SemanticNode entityA, SemanticNode entityB);
    public ObjectProperty getInverseProperty (SemanticNode parent, ObjectProperty property);
    
    default Resource createResource(String uri, String name, String description, boolean active, boolean alive, Resource descriptor) {
    	Resource resource = SemanticmanagerFactory.eINSTANCE.createResource();
    	resource.setUri(uri);
    	resource.setName(name);
    	resource.setDescription(description);
    	resource.setActive(active);
    	resource.setAlive(alive);
    	resource.setDescriptor(descriptor);
        return resource;
    }
    
    default SemanticNode createSemanticNode(Object id, String name, String description, boolean isInstanceOf, SemanticNode instanceOf) {
    	SemanticNode semanticNode = SemanticmanagerFactory.eINSTANCE.createSemanticNode();
    	semanticNode.setId(id);
    	semanticNode.setName(name);
    	semanticNode.setDescription(description);
    	semanticNode.setWeight(1);
    	semanticNode.setInstanceOf(isInstanceOf);
    	semanticNode.setInstanceOfNode(instanceOf);
        return semanticNode;
    }
    
    default SemanticNode createSemanticNode(Object id, String name, String description, int weight, boolean isInstanceOf, SemanticNode instanceOf) {
    	SemanticNode semanticNode = SemanticmanagerFactory.eINSTANCE.createSemanticNode();
    	semanticNode.setId(id);
    	semanticNode.setName(name);
    	semanticNode.setDescription(description);
    	semanticNode.setWeight(weight);
    	semanticNode.setInstanceOf(isInstanceOf);
    	semanticNode.setInstanceOfNode(instanceOf);
    	
        return semanticNode;
    }
    
    default boolean addSemanticNodeToResource(Resource resource, SemanticNode node){
    	if(resource == null || node == null) return false;
    	resource.getNodes().add(node);
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
    
    default DataProperty createDataProperty(Object id, String name, String description, Type type){
    	DataProperty dataProperty = SemanticmanagerFactory.eINSTANCE.createDataProperty();
    	dataProperty.setId(id);
    	dataProperty.setName(name);
    	dataProperty.setDescription(description);
    	dataProperty.setType(type);
        return dataProperty;
    }
    
    default boolean addDataPropertyToNode(SemanticNode node, DataProperty property){
    	if(node == null || property == null) return false;
    	node.getProperties().add((Property) property);
    	property.setSemanticNodeFrom(node);
    	return true;
    }
    
    default ObjectProperty createObjectProperty(Object id, String name, SemanticNode range){
    	ObjectProperty objectProperty = SemanticmanagerFactory.eINSTANCE.createObjectProperty();
    	objectProperty.setId(id);
    	objectProperty.setName(name);
    	objectProperty.setRange(range);
        return objectProperty;
    }
    
    default boolean addObjectPropertyToNode(SemanticNode node, ObjectProperty property){
    	if(node == null || property == null) return false;
    	node.getProperties().add((Property) property);
    	property.setSemanticNodeFrom(node);
    	return true;
    }
    
    default SemanticNode semanticNodeFromId(Resource resource, Object id){
    	for(SemanticNode node : resource.getNodes()) if(node.getId().equals(id)) return node;
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
