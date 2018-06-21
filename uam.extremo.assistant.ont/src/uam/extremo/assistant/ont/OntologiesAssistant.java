package uam.extremo.assistant.ont;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.util.AutoIRIMapper;

import semanticmanager.ConstraintInterpreter;
import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import semanticmanager.Type;
import uam.extremo.extensions.FormatAssistant;
import uam.extremo.extensions.IFormatAssistant;

public class OntologiesAssistant extends FormatAssistant implements IFormatAssistant {
	public IRI owl_iri = null;
	public File owl_file = null;
	public String path = null;

	OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
	OWLDataFactory factory = OWLManager.getOWLDataFactory();
	OWLOntology ontology = null;
    
	File file;
	String extension;
	ConstraintInterpreter constraintInterpreter = null;
	semanticmanager.Resource semanticResource = null;
	
	OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
	OWLReasoner reasoner = null;
	
	Map<OWLObject, SemanticNode> correspondance = new HashMap<OWLObject, SemanticNode>();
	
	@Override
	public boolean loadAndValidate(Resource semanticResource, ConstraintInterpreter constraintInterpreter) {
		this.semanticResource = semanticResource;
		this.constraintInterpreter = constraintInterpreter;
		
		if((semanticResource.getUri().startsWith("http://"))
				|| (semanticResource.getUri().startsWith("https://"))){
			owl_iri = IRI.create(semanticResource.getUri());
			
			try {
				ontology = manager.loadOntology(owl_iri);
			}
			catch (OWLOntologyCreationException e) {
				return false;
			}
		}
		else{
			owl_file = new File(semanticResource.getUri());
			File file = this.owl_file.getParentFile();
			AutoIRIMapper autoIRIMapper = new AutoIRIMapper(file, true);
	        manager.addIRIMapper(autoIRIMapper);
			
	        if(!owl_file.isFile()){
	        		return false;
	        }
	        else{
	        		try {
					ontology = manager.loadOntologyFromOntologyDocument(owl_file);
				}
				catch (OWLOntologyCreationException e) {
					return false;
				}
	        }
		}
		
		reasoner = reasonerFactory.createReasoner(ontology);
		owlClassesToSemanticNodes();
		return true;
	}
	
	private void owlClassesToSemanticNodes() {
		if(ontology != null){
			for(OWLClass owlClass : ontology.getClassesInSignature(true)){
				SemanticNode semanticNode = 
						createSemanticNodeWithoutDescriptor(
								owlClass.getIRI(), //original object as id
								owlClass.getIRI().getFragment(), 
								"",
								false);
									
				addSemanticNodeToResource(semanticResource, semanticNode);
				correspondance.put(owlClass, semanticNode);
				
				NodeSet<OWLNamedIndividual> individualsNodeSet = reasoner.getInstances(owlClass, true);
				Set<OWLNamedIndividual> individuals = individualsNodeSet.getFlattened();

				for (OWLNamedIndividual ind : individuals) {
					SemanticNode individualSemanticNode = 
							createSemanticNode(
									ind.getIRI(), 
									ind.getIRI().getFragment(),
									"", 
									semanticNode //the element descriptor
							);
					addSemanticNodeToResource(semanticResource, individualSemanticNode);
					correspondance.put(ind, individualSemanticNode);
				}
			}
		}
	}

	@Override
	public void toDataProperty(SemanticNode parent) {
		if(ontology != null && parent.getTrace() != null && parent.getTrace() instanceof IRI){			
			reasoner = reasonerFactory.createReasoner(ontology);
		
			IRI iri = (IRI) parent.getTrace();
			
			if(ontology.containsClassInSignature(iri, true)){
				for(OWLDataProperty property : ontology.getDataPropertiesInSignature(true)){
					for(OWLClassExpression domain : property.getDomains(ontology)){
						if(! domain.isAnonymous()){
							if(domain.asOWLClass().getIRI().toString().compareTo(iri.toString()) == 0){
								Collection<OWLDataRange> ranges = property.getRanges(ontology);
								
								List<String> rangeURIs = new ArrayList<String>();
								
								for(OWLDataRange range : ranges){
									rangeURIs.add(range.asOWLDatatype().getIRI().toString());
								}
								
								Type type = defineStringType();
								
								if(property.isOWLDatatype()){
									if(property.asOWLDatatype().isBoolean()) 
										type = defineBooleanType();
									if(property.asOWLDatatype().isDouble()) 
										type = defineDoubleType();
									if(property.asOWLDatatype().isFloat()) 
										type = defineFloatType();
									if(property.asOWLDatatype().isInteger()) 
										type = defineIntType();
									
									DataProperty dataProperty = 
											createDataProperty(
													property.getIRI(), 
													property.getIRI().getFragment(),
													0, 
													manager.getOWLDataFactory().getOWLDataExactCardinality(1, property).getCardinality(),
													"", 
													type //the type selected from the enum class
											);
														
									addDataPropertyToNode(parent, dataProperty);
								}
								
								if(property.isOWLDataProperty()){
									DataProperty dataProperty = 
											createDataProperty(
													property.asOWLDataProperty().getIRI(),
													property.getIRI().getFragment(),
													0, 
													manager.getOWLDataFactory().getOWLDataExactCardinality(1, property).getCardinality(),
													"", 
													type //the type selected from the enum class
											);
														
									addDataPropertyToNode(parent, dataProperty);
								}	
							}
						}
					}
				}
			}
			
			if(ontology.containsIndividualInSignature(iri, true)){
				OWLDataFactory factory = manager.getOWLDataFactory();
				OWLNamedIndividual individual = factory.getOWLNamedIndividual(iri);
				
				Set<OWLDataPropertyAssertionAxiom> properties = ontology.getDataPropertyAssertionAxioms(individual);
				for (OWLDataPropertyAssertionAxiom axiom : properties) {
					OWLDataProperty dataPropertyExpression = axiom.getProperty().asOWLDataProperty();
					
					for(NamedElement descriptor : parent.getDescriptors()){
						if(descriptor instanceof SemanticNode){
							SemanticNode semanticNodeDescriptor = (SemanticNode) descriptor;
							
							DataProperty dataPropertyDescriptor = 
									searchDataPropertyByName(
											semanticNodeDescriptor,
											dataPropertyExpression.getIRI().getFragment()
									);
							
							if(dataPropertyDescriptor != null){									
								DataProperty dataPropertyDescription = 
										createDataProperty(
												dataPropertyDescriptor, //descriptor
												axiom.getObject().getLiteral() //value
										);
								
								addDataPropertyToNode(parent, dataPropertyDescription);
							}	
						}
					}
				}
			}
		}
	}

	@Override
	public void toObjectProperty(SemanticNode parent) {
		if(ontology != null && parent.getTrace() != null && parent.getTrace() instanceof IRI){
			IRI iri = (IRI) parent.getTrace();
			
			if(ontology.containsClassInSignature(iri, true)){
				for(OWLObjectProperty property : ontology.getObjectPropertiesInSignature(true)){
					for(OWLClassExpression domain : property.getDomains(ontology)){
						if(!domain.isAnonymous()){
							if(domain.asOWLClass().getIRI().toString().compareTo(iri.toString()) == 0){
								Collection<OWLClassExpression> ranges = property.getRanges(ontology);
								List<IRI> rangeURIs = new ArrayList<IRI>();
								
								for(OWLClassExpression range : ranges){
									if(!range.isAnonymous()){
										rangeURIs.add(range.asOWLClass().getIRI());
									}
								}
								
								for(IRI rangeURI : rangeURIs){
									NamedElement range = namedElementFromId(semanticResource, rangeURI);

									if(range != null && range instanceof SemanticNode){
										SemanticNode semanticNodeRange = (SemanticNode) range;
										
										ObjectProperty objectProperty = 
												createObjectProperty(
														property.getIRI(), 
														//prefixManager.getShortForm(property),
														property.getIRI().getFragment(),
														0, 
														manager.getOWLDataFactory().getOWLObjectExactCardinality(1, property).getCardinality(), 
														semanticNodeRange);
										
										addObjectPropertyToNode(parent, objectProperty);
									}
								}
							}
						}
					}
				}
			}
			
			if(ontology.containsIndividualInSignature(iri, true)){
				OWLDataFactory factory = manager.getOWLDataFactory();
				OWLNamedIndividual individual = factory.getOWLNamedIndividual(iri);
				
				Set<OWLObjectPropertyAssertionAxiom> properties = ontology.getObjectPropertyAssertionAxioms(individual);
				
				for (OWLObjectPropertyAssertionAxiom axiom : properties) {
					OWLObjectProperty objectPropertyExpression = axiom.getProperty().asOWLObjectProperty();
					
					ObjectProperty descriptor = 
							searchObjectPropertyByName(
									(SemanticNode) parent.getDescriptors().get(parent.getDescriptors().size() - 1),
									objectPropertyExpression.getIRI().getFragment()
							);
					
					NodeSet<OWLNamedIndividual> values = reasoner.getObjectPropertyValues(individual, objectPropertyExpression);
					Iterator<org.semanticweb.owlapi.reasoner.Node<OWLNamedIndividual>> iteratorValues = values.iterator();
					
					iteratorValues.forEachRemaining(
						element -> {
							org.semanticweb.owlapi.reasoner.Node<OWLNamedIndividual> node = element;
							
							if(descriptor != null){	
								SemanticNode range = correspondance.get(node.getRepresentativeElement());
								
								ObjectProperty objectPropertyDescription = 
										createObjectProperty(
												objectPropertyExpression.getIRI(), 
												objectPropertyExpression.getIRI().getFragment(),
												descriptor, //descriptor
												range
										);
								
								addObjectPropertyToNode(parent, objectPropertyDescription);
							}
						}
					);
				}
			}		
		}	
		//}
	}

	@Override
	public void toSuper(SemanticNode parent) {
		if(ontology != null && parent.getTrace() != null && parent.getTrace() instanceof IRI){
			IRI iriClass = (IRI) parent.getTrace();
			
			if(ontology.containsClassInSignature(iriClass, true)){
				OWLClass clazz = factory.getOWLClass(iriClass);
				Set<OWLClassExpression> superclasses = clazz.getSuperClasses(ontology);
				
				for(OWLClassExpression superclass : superclasses){
					if(! superclass.isAnonymous()){
						NamedElement range = namedElementFromId(semanticResource, superclass.asOWLClass().getIRI());
						
						if(range != null && range instanceof SemanticNode){
							SemanticNode superSemanticNode = (SemanticNode) range;
							addSuperClassToNode(parent, superSemanticNode);
						}
					}	
				}
			}
		}
	}

	@Override
	public void toSuper(DataProperty parent) {
		if(ontology != null && parent.getTrace() != null && parent.getTrace() instanceof IRI){
			IRI iriClass = (IRI) parent.getTrace();
			
			if(ontology.containsObjectPropertyInSignature(iriClass, true)){
				OWLDataProperty dataProperty = factory.getOWLDataProperty(iriClass);
				Set<OWLDataPropertyExpression> superproperties = dataProperty.getSuperProperties(ontology);
				
				for(OWLDataPropertyExpression superproperty : superproperties){
					if(! superproperty.isAnonymous()){
						NamedElement namedId = namedElementFromId(semanticResource, superproperty.asOWLDataProperty().getIRI());
						
						if(namedId != null && namedId instanceof DataProperty){
							DataProperty superDataProperty = (DataProperty) namedId;
							addSuperClassToDataProperty(parent, superDataProperty);
						}
					}	
				}
			}
		}
	}

	@Override
	public void toSuper(ObjectProperty parent) {
		if(ontology != null && parent.getTrace() != null && parent.getTrace() instanceof IRI){
			IRI iriClass = (IRI) parent.getTrace();
			
			if(ontology.containsObjectPropertyInSignature(iriClass, true)){
				OWLObjectProperty objectProperty = factory.getOWLObjectProperty(iriClass);
				Set<OWLObjectPropertyExpression> superproperties = objectProperty.getSuperProperties(ontology);
				
				for(OWLObjectPropertyExpression superproperty : superproperties){
					if(! superproperty.isAnonymous()){
						NamedElement namedId = namedElementFromId(semanticResource, superproperty.asOWLObjectProperty().getIRI());
						
						if(namedId != null && namedId instanceof ObjectProperty){
							ObjectProperty superObjectProperty = (ObjectProperty) namedId;
							addSuperClassToObjectProperty(parent, superObjectProperty);
						}
					}	
				}
			}
		}
	}

	@Override
	public void toInverseOf(ObjectProperty parent) {
		if(ontology != null && parent.getTrace() != null && parent.getTrace() instanceof IRI){
			IRI iriClass = (IRI) parent.getTrace();
			if(ontology.containsObjectPropertyInSignature(iriClass, true)){
				OWLObjectProperty objectProperty = factory.getOWLObjectProperty(iriClass);
				OWLObjectPropertyExpression inverseOf = objectProperty.getInverseProperty();
				
				if(inverseOf != null){
					NamedElement namedId = namedElementFromId(semanticResource, inverseOf.asOWLObjectProperty().getIRI());
					
					if(namedId != null && namedId instanceof ObjectProperty){
						ObjectProperty inverseOfObjectProperty = (ObjectProperty) namedId;
						addInverseOfToObjectProperty(parent, inverseOfObjectProperty);
					}
				}
			}
		}
	}
}
