package uam.extremo.assistant.owl;

import java.util.List;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import semanticmanager.*;
import uam.extremo.extensions.FormatAssistant;
import uam.extremo.extensions.IFormatAssistant;

public class OwlAssistant extends FormatAssistant implements IFormatAssistant {
	public IRI owl_iri = null;
	public File owl_file = null;
	public String path = null;

	OWLDataFactory factory = OWLManager.getOWLDataFactory();
	OWLOntology ontology = null;	
	
	private OWLOntologyManager create(){
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		return manager;
	}

	@Override
	public boolean load(Resource resource) {
		this.path = (String) resource.getUri();
				
		if((path.startsWith("http://"))||(path.startsWith("https://"))){
			this.owl_iri = IRI.create(path);
		}else{
			this.owl_file = new File(path);
			if(!this.owl_file.isFile()) return false;
		}
		
		OWLOntologyManager m = create();
		if(owl_file==null){
			try {
				ontology = m.loadOntologyFromOntologyDocument(owl_iri);
			} catch (OWLOntologyCreationException e) {
				return false;
			}
		}else{
			try {
				ontology = m.loadOntologyFromOntologyDocument(owl_file);
			}
			catch (OWLOntologyCreationException e) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public List<SemanticNode> toSemanticNode() {
		if(ontology == null) return null;
		
		/*List<ISemanticClass> semanticClasses = new ArrayList<ISemanticClass>();
		
		for(OWLClass owlclass : ontology.getClassesInSignature()){
			owlclass.get
		}*/
		return null;
	}
	
	/*@Override
	public List<ISemanticClass> getClassesLike(String... names) {
		List<ISemanticClass> classes = new ArrayList<ISemanticClass>();
		
		if(ontology!=null){			
			for (String entry : names){
				for(OWLClass clazz : ontology.getClassesInSignature()){
					String description = "";

					for (OWLAnnotation annotation : clazz.getAnnotations(ontology, factory.getRDFSComment())) {
						if (annotation.getValue() instanceof OWLLiteral) {
							OWLLiteral val = (OWLLiteral) annotation.getValue();
							description = val.getLiteral();
						}
					}
					
					boolean labeled = false;
					for (OWLAnnotation annotation : clazz.getAnnotations(ontology, factory.getRDFSLabel())) {
						if (annotation.getValue() instanceof OWLLiteral) {
							OWLLiteral val = (OWLLiteral) annotation.getValue();
							if(val.toString().contains(entry.toLowerCase())){
								String id = clazz.getIRI().getShortForm();
								String name = clazz.getIRI().toString();
								OWLSemanticClass semanticClass = new OWLSemanticClass(id, name, description, true);
								classes.add(semanticClass);
								labeled = true;
							}
						}
					}
					
					if((!labeled) && (clazz.getIRI().getShortForm().toLowerCase().compareTo(entry.toLowerCase()) == 0)){
						String id = clazz.getIRI().getShortForm();
						String name = clazz.getIRI().toString();
						OWLSemanticClass semanticClass = new OWLSemanticClass(id, name, description, true);
						classes.add(semanticClass);	
					}
				}
			}		
		}
		return classes;
	}*/
	
	@Override
	public List<SemanticNode> toSemanticNode(Map<String, Integer> namesByRelevance) {
		if(ontology == null) return null;
		else
		{
			List<SemanticNode> semanticNodes = new ArrayList<SemanticNode>();
			for(OWLClass owlclass : ontology.getClassesInSignature())
			{
				SemanticNode semanticNode = createSemanticNode(owlclass.getIRI(), owlclass.getIRI().getShortForm(), false, null);
				semanticNodes.add(semanticNode);
				
				Set<OWLNamedIndividual> individualsInSignature = owlclass.getIndividualsInSignature();
				for(OWLNamedIndividual individual : individualsInSignature){
					SemanticNode individualSemanticNode = createSemanticNode(individual.getIRI(), individual.getIRI().getShortForm(), true, semanticNode);
					semanticNodes.add(individualSemanticNode);
				}
			}
			
			return semanticNodes;
		}
		
		/*if(ontology != null){			
			for (Entry<String, Integer> entry : namesByRelevance.entrySet()){
				for(OWLClass clazz : ontology.getClassesInSignature()){
					cla
					
					for (OWLAnnotation annotation : clazz.getAnnotations(ontology, factory.getRDFSComment())) {
						if (annotation.getValue() instanceof OWLLiteral) {
							OWLLiteral val = (OWLLiteral) annotation.getValue();
							description = val.getLiteral();
						}
					}
					
					boolean labeled = false;
					for (OWLAnnotation annotation : clazz.getAnnotations(ontology, factory.getRDFSLabel())) {
						if (annotation.getValue() instanceof OWLLiteral) {
							OWLLiteral val = (OWLLiteral) annotation.getValue();
							if(val.toString().contains(entry.getKey().toLowerCase())){
								String id = clazz.getIRI().getShortForm();
								String name = clazz.getIRI().toString();
								
								//createSemanticNode(id, name, isInstanceOf, instanceOf)
								
								OWLSemanticClass semanticClass = new OWLSemanticClass(id, name, description, true);
								classes.add(semanticClass);
								labeled = true;
							}
						}
					}
					
					if((!labeled) && (clazz.getIRI().getShortForm().toLowerCase().compareTo(entry.getKey().toLowerCase()) == 0)){
						String id = clazz.getIRI().getShortForm();
						String name = clazz.getIRI().toString();
						OWLSemanticClass semanticClass = new OWLSemanticClass(id, name, description, true);
						classes.add(semanticClass);	
					}
					
					
					for(OWLIndividual individual : clazz.getIndividuals(ontology)){
						
					}
				}
				
				
			}		
		}
		return classes;*/
	}
	
	
	@Override
	public List<DataProperty> toDataProperty(SemanticNode parent, boolean supers, boolean equivs) {
		/*
		if(parent.getId() instanceof String){
			if((parent == null) || ((String) parent.getId()).compareTo("") == 0) return null;
			
			List<DataProperty> properties = new ArrayList<DataProperty>();
			IRI iri = IRI.create((String)parent.getId());
			
			if((ontology!=null) && (ontology.containsClassInSignature(iri))){
				for(OWLDataProperty property : ontology.getDataPropertiesInSignature()){
					for(OWLClassExpression domain : property.getDomains(ontology)){
						if(!domain.isAnonymous()){
							if(domain.asOWLClass().getIRI().toString().compareTo(iri.toString()) == 0){
								Collection<OWLDataRange> ranges = property.getRanges(ontology);
								List<String> rangeURIs = new ArrayList<String>();
								
								for(OWLDataRange range : ranges){
									rangeURIs.add(range.asOWLDatatype().getIRI().toString());
								}
								
								if(property.isOWLDatatype()){
									Datatype datatype = Datatype.string;
									if(property.asOWLDatatype().isBoolean()) datatype = Datatype.bool;
									if(property.asOWLDatatype().isDouble()) datatype = Datatype.real;
									if(property.asOWLDatatype().isFloat()) datatype = Datatype.real;
									if(property.asOWLDatatype().isInteger()) datatype = Datatype.integer;
									properties.add(new OWLSemanticDataProperty(property.getIRI().getShortForm(), property.getIRI().toString(), datatype.name(), property.getIRI().getShortForm()));
								}
								
								if(property.isOWLDataProperty()){
									properties.add(new OWLSemanticDataProperty(property.getIRI().getShortForm(), property.getIRI().toString(), property.asOWLDataProperty().getIRI().toString(), property.getIRI().getShortForm()));
								}	
							}
						}
					}
				}
			}
			else{
				return null;
			}
			
			return properties;
		}
		return null;*/
		return null;	
	}
	
	@Override
	public List<ObjectProperty> toObjectProperty(SemanticNode parent, boolean supers, boolean equivs) {
		/*if((parent == null) || ((String) parent.getId()).compareTo("") == 0) return null;
		
		List<IObjectProperty> properties = new ArrayList<IObjectProperty>();
		IRI iri = IRI.create((String) parent.getId());
		
		if((ontology!=null) && (ontology.containsClassInSignature(iri))){
			for(OWLObjectProperty property : ontology.getObjectPropertiesInSignature()){
				for(OWLClassExpression domain : property.getDomains(ontology)){
					if(!domain.isAnonymous()){
						if(domain.asOWLClass().getIRI().toString().compareTo(iri.toString()) == 0){
							Collection<OWLClassExpression> ranges = property.getRanges(ontology);
							List<String> rangeURIs = new ArrayList<String>();
							
							for(OWLClassExpression range : ranges){
								if(!range.isAnonymous()){
									rangeURIs.add(range.asOWLClass().getIRI().toString());
								}
							}		
							properties.add(new OWLSemanticObjectProperty(property.getIRI().getShortForm(), null, property.getIRI().toString(), property.getIRI().getShortForm()));
						}
					}
				}
			}
		}
		else{
			return null;
		}*/
		
		/*if(supers){
			List<ISemanticClass> superclasses = getSuper(parent, true);
			for(ISemanticClass superclass : superclasses) properties.addAll(getObjectProperties(superclass.getId(), supers, equivs));
		}
		
		if(equivs){
			List<ISemanticClass> superclasses = equivs((String) parent.getId());
			for(ISemanticClass superclass : superclasses) properties.addAll(getObjectProperties(superclass.getId(), supers, equivs));
		}*/
		
		return null;
	}

	@Override
	public List<SemanticNode> getRelatedClasses(SemanticNode name, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SemanticNode> getSuper(SemanticNode parent, boolean direct) {
		/*if(parent.getId() instanceof String){
			if((parent == null) || ((String) parent.getId()).compareTo("") == 0) return null;
			
			List<ISemanticClass> supers = new ArrayList<ISemanticClass>();
			
			IRI iri = IRI.create((String)parent.getId());
			if(ontology.containsClassInSignature(iri)){
				OWLClass clazz = factory.getOWLClass(iri);
				Set<OWLClassExpression> superclasses = clazz.getSuperClasses(ontology);
				
				for(OWLClassExpression superclass : superclasses){
					if(!superclass.isAnonymous()){
						String id = superclass.asOWLClass().getIRI().getShortForm();
						String name = superclass.asOWLClass().getIRI().toString();
						OWLSemanticClass semanticClass = new OWLSemanticClass(id, name, false);
						supers.add(semanticClass);
					}	
				}
				
			}
			else{
				return null;
			}
			
			return supers;
		}*/
		return null;
		
	}

	/*private List<ISemanticClass> equivs(String parent){
		if((parent == null) || parent.compareTo("") == 0) return null;
		
		List<ISemanticClass> equivs = new ArrayList<ISemanticClass>();
		IRI iri = IRI.create(parent);
		if(ontology.containsClassInSignature(iri)){
			OWLClass clazz = factory.getOWLClass(iri);
			Set<OWLClassExpression> equivalents = clazz.getEquivalentClasses(ontology);
			//Collection<OWLClassExpression> equivalents = EntitySearcher.getEquivalentClasses(clazz, ontology);
			for(OWLClassExpression equivalent : equivalents){
				if(!equivalent.isAnonymous()){
					String id = equivalent.asOWLClass().getIRI().getShortForm();
					String name = equivalent.asOWLClass().getIRI().toString();
					
					OWLSemanticClass semanticClass = new OWLSemanticClass(id, name, false);
					equivs.add(semanticClass);
				}	
			}
			
		}
		else{
			return null;
		}
		
		return equivs;
	}*/
	
	@Override
	public List<SemanticNode> getSub(SemanticNode parent, boolean direct) {
		/*if((parent == null) || ((String) parent.getId()).compareTo("") == 0) return null;
		
		List<ISemanticClass> subs = new ArrayList<ISemanticClass>();
		IRI iri = IRI.create((String) parent.getId());
		if(ontology.containsClassInSignature(iri)){
			OWLClass clazz = factory.getOWLClass(iri);
			Set<OWLClassExpression> subclasses = clazz.getSubClasses(ontology);
			
			for(OWLClassExpression subclass : subclasses){
				if(!subclass.isAnonymous()){
					String id = subclass.asOWLClass().getIRI().getShortForm();
					String name = subclass.asOWLClass().getIRI().toString();
					
					OWLSemanticClass semanticClass = new OWLSemanticClass(id, name, false);
					subs.add(semanticClass);
				}	
			}
			
		}
		else{
			return null;
		}*/
		
		return null;
	}

	@Override
	public ObjectProperty getInverseProperty(SemanticNode cl, ObjectProperty property) {
		return null;
	}

	@Override
	public List<SemanticNode> getSiblings(SemanticNode name) {
		/*List<ISemanticClass> siblings = new ArrayList<ISemanticClass>();
		
		HashSet<ISemanticClass> aux = new HashSet<ISemanticClass>(siblings);
		siblings.clear();
		siblings.addAll(aux);*/
		
		return null;
	}
	
	@Override
	public List<ObjectProperty> getPath(SemanticNode start, SemanticNode finish) {
		/*if((start.getId() instanceof String) && (finish.getId() instanceof String)){
			List<IObjectProperty> path = new LinkedList<IObjectProperty>();
			
			if(((String) start.getId()).compareTo((String) finish.getId()) == 0) return path;
			
			IRI iriA = IRI.create((String) start.getId());
			IRI iriB = IRI.create((String) finish.getId());
			
			if((!ontology.containsClassInSignature(iriA))||(!ontology.containsClassInSignature(iriB))) return null;
			
			List<IObjectProperty> objectPropertiesA = getObjectProperties(start, true, true);
			
			for(IObjectProperty property : objectPropertiesA){
				if(((String) property.getId()).compareTo(iriB.toString())==0){
					path.clear();
					path.add(property);
					return path;
				}
			}
			
			Map<String, Boolean> visited = new HashMap<String, Boolean>();
		
			
		    Queue<String> q = new LinkedList<String>();
		    String current = (String) start.getId();
		    q.add(current);
		    visited.put(current, true);
		    
		    while(!q.isEmpty()){
		        current = q.remove();
		        if (current.equals(finish)){
		            break;
		        }
		        else{
		        }
		    }
		    if (!current.equals(finish)){
		        System.out.println("can't reach destination");
		    }
		    
			return path;
		}*/
		return null;
		
	}

	/*@Override
	public List<Class<? extends INamedElement>> getRegisteredTypes() {
		List<Class<? extends INamedElement>> types = new ArrayList<Class<? extends INamedElement>>();
		types.add(OWLSemanticClass.class);
		types.add(OWLSemanticDataProperty.class);
		types.add(OWLSemanticObjectProperty.class);
		return types;
	}*/
}
