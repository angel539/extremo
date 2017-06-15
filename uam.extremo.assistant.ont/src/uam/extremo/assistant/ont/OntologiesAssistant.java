package uam.extremo.assistant.ont;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import semanticmanager.Type;
import uam.extremo.extensions.FormatAssistant;
import uam.extremo.extensions.IFormatAssistant;
import uk.ac.manchester.cs.owl.owlapi.mansyntaxrenderer.ManchesterOWLSyntaxPrefixNameShortFormProvider;

public class OntologiesAssistant extends FormatAssistant implements IFormatAssistant {
	public IRI owl_iri = null;
	public File owl_file = null;
	public String path = null;

	OWLDataFactory factory = OWLManager.getOWLDataFactory();
	OWLOntology ontology = null;
	
	semanticmanager.Resource semanticResource = null;
	File file;
	String extension;
	ManchesterOWLSyntaxPrefixNameShortFormProvider prefixManager = null;

	@Override
	public boolean load(Resource semanticResource) {
		this.semanticResource = semanticResource;
		
		if((semanticResource.getUri().startsWith("http://"))
				|| (semanticResource.getUri().startsWith("https://"))){
			this.owl_iri = 
					IRI.create(semanticResource.getUri());
		}
		else{
			this.owl_file = new File(semanticResource.getUri());
			
			if(! this.owl_file.isFile()) 
				return false;
		}
		
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

		if(owl_file == null){
			try {
				ontology = manager.loadOntologyFromOntologyDocument(owl_iri);
			}
			catch (OWLOntologyCreationException e) {
				return false;
			}
		}
		else{
			try {
				ontology = manager.loadOntologyFromOntologyDocument(owl_file);
			}
			catch (OWLOntologyCreationException e) {
				return false;
			}
		}

		prefixManager = new ManchesterOWLSyntaxPrefixNameShortFormProvider(manager, ontology);
		owlClassesToSemanticNodes();
		
		return true;
	}
	
	private void owlClassesToSemanticNodes() {
		if(ontology != null){
			for(OWLClass owlClass : ontology.getClassesInSignature()){
				SemanticNode semanticNode = 
						createSemanticNodeWithoutDescriptor(
								owlClass.getIRI(), //original object as id
								prefixManager.getShortForm(owlClass), 
								"",
								false);
									
				addSemanticNodeToResource(semanticResource, semanticNode);
				
				for(OWLNamedIndividual individual : owlClass.getIndividualsInSignature()){
					SemanticNode individualSemanticNode = 
							createSemanticNode(
									individual.getIRI(), 
									prefixManager.getShortForm(owlClass), 
									"", 
									semanticNode //the element descriptor
							);
					
					addSemanticNodeToResource(semanticResource, individualSemanticNode);
				}
			}
		}
	}

	@Override
	public void toDataProperty(SemanticNode parent) {
		if(ontology != null && parent.getTrace() != null && parent.getTrace() instanceof IRI){
			IRI iriClass = (IRI) parent.getTrace();
			
			if(ontology.containsClassInSignature(iriClass)){
				for(OWLDataProperty property : ontology.getDataPropertiesInSignature()){
					for(OWLClassExpression domain : property.getDomains(ontology)){
						if(! domain.isAnonymous()){
							if(domain.asOWLClass().getIRI().toString().compareTo(iriClass.toString()) == 0){
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
													prefixManager.getShortForm(property), 
													1, 
													1,
													"", 
													type //the type selected from the enum class
											);
														
									addDataPropertyToNode(parent, dataProperty);
								}
								
								if(property.isOWLDataProperty()){
									DataProperty dataProperty = 
											createDataProperty(
													property.asOWLDataProperty().getIRI(), 
													prefixManager.getShortForm(property.asOWLDataProperty()), 
													1, 
													1,
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
		}
	}

	@Override
	public void toObjectProperty(SemanticNode parent) {
		if(ontology != null && parent.getTrace() != null && parent.getTrace() instanceof IRI){
			IRI iriClass = (IRI) parent.getTrace();
			
			if(ontology.containsClassInSignature(iriClass)){
				for(OWLObjectProperty property : ontology.getObjectPropertiesInSignature()){
					for(OWLClassExpression domain : property.getDomains(ontology)){
						if(!domain.isAnonymous()){
							if(domain.asOWLClass().getIRI().toString().compareTo(iriClass.toString()) == 0){
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
														prefixManager.getShortForm(property), 
														1, 
														1, 
														semanticNodeRange);
										
										addObjectPropertyToNode(parent, objectProperty);
									}
								}
							}
						}
					}
				}
			}
		}	
	}

	@Override
	public void toSuper(SemanticNode parent) {
		if(ontology != null && parent.getTrace() != null && parent.getTrace() instanceof IRI){
			IRI iriClass = (IRI) parent.getTrace();
			
			if(ontology.containsClassInSignature(iriClass)){
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
			
			if(ontology.containsObjectPropertyInSignature(iriClass)){
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
			
			if(ontology.containsObjectPropertyInSignature(iriClass)){
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
		// TODO Auto-generated method stub
	}
}
