package metardf.owl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.io.StreamDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.util.AutoIRIMapper;
import metardf.core.IFormatAssistant;
import metardf.model.DataProperty;
import metardf.model.Datatype;
import metardf.model.ObjectProperty;
import metardf.utils.Wordnet;

public class OwlAssitant implements IFormatAssistant{
	public IRI owl_iri = null;
	public File owl_file = null;
	public String path = null;

	OWLDataFactory factory = OWLManager.getOWLDataFactory();
	OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
	
	OWLOntology ontology = null;

	public OwlAssitant() {
		super();
	}
	
	class DataOWL implements DataProperty{
		String name;
		String uri;
		Datatype range;
		
		DataOWL(String name, String uri, Datatype type){
			this.name = name;
			this.uri = uri;
			this.range = type;
		}
		
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}

		@Override
		public String getURI() {
			// TODO Auto-generated method stub
			return uri;
		}

		@Override
		public Datatype getRange() {
			// TODO Auto-generated method stub
			return range;
		}
		
		@Override
		public String toString() {
			return "[" + name + ", " + uri + ", " + range + "]";
		}
		
	}
	
	class ObjectOWL implements ObjectProperty{
		String name;
		String uri;
		List<String> ranges;
		
		ObjectOWL(String name, String uri, List<String> ranges){
			this.name = name;
			this.uri = uri;
			this.ranges = ranges;	
		}
		
		@Override
		public String getName() {
			return name;
		}

		@Override
		public String getURI() {
			return uri;
		}

		@Override
		public List<String> getRanges() {
			return ranges;
		}
		
		@Override
		public String toString() {
			return "[" + name + ", " + uri + ", " + ranges.toString() + "]";
		}
	}
	
	private OWLOntologyManager create(){
		OWLOntologyManager m = OWLManager.createOWLOntologyManager();
		m.addIRIMapper(new AutoIRIMapper(new File("materializedOntologies"), true));
		return m;
	}
	
	public void createOntology() throws OWLOntologyCreationException{
		OWLOntologyManager m = create();
		ontology = m.createOntology(owl_iri);
	}
	
	public void createOntologyFromFile() throws OWLOntologyCreationException{
		OWLOntologyManager m = create();
		ontology = m.createOntology(owl_iri);
	}
	
	public void saveOntologyOWL() throws OWLOntologyStorageException, IOException{
		OWLOntologyManager m = create();
		OWLOntology ontology = m.getOntology(owl_iri);
		File output = File.createTempFile("copy", "owl");
		IRI documentIRItemp = IRI.create(output);
		m.saveOntology(ontology, new OWLXMLOntologyFormat(), documentIRItemp);
		StreamDocumentTarget target = new StreamDocumentTarget(new ByteArrayOutputStream());
		m.saveOntology(ontology, target);
		m.removeOntology(ontology);
	}
	
	public void saveOntologyRDF() throws IOException, OWLOntologyStorageException{
		OWLOntologyManager m = create();
		OWLOntology ontology = m.getOntology(owl_iri);
		File output = File.createTempFile("copy", "owl");
		IRI documentIRItemp = IRI.create(output);
		m.saveOntology(ontology, documentIRItemp);
		StreamDocumentTarget target = new StreamDocumentTarget(new ByteArrayOutputStream());
		m.saveOntology(ontology, target);
		m.removeOntology(ontology);
	}

	@Override
	public void load(String path) {
		this.path = path;
				
		if((path.startsWith("http://"))||(path.startsWith("https://"))){
			this.owl_iri = IRI.create(path);
		}else{
			this.owl_file = new File(path);
		}
		
		OWLOntologyManager m = create();
		if(owl_file==null){
			try {
				ontology = m.loadOntologyFromOntologyDocument(owl_iri);
			} catch (OWLOntologyCreationException e) {
				e.printStackTrace();
			}
		}else{
			try {
				ontology = m.loadOntologyFromOntologyDocument(owl_file);
			} catch (OWLOntologyCreationException e) {
				e.printStackTrace();
			}
		}
	}

	/*@Override
	public List<Entity> getEntities() {
		List<Entity> entities = new ArrayList<Entity>();
		OWLOntologyManager m = create();
		if(ontology!=null){
			for(OWLClass clazz : ontology.getClassesInSignature()){
				Entity newentity = SemanticsFactory.eINSTANCE.createEntity();
				newentity.setURI(clazz.toString());
				model.getDescriptors().add(newentity);
			}
		}
		
		for(Descriptor descriptor : model.getDescriptors()) if(descriptor instanceof Entity) entities.add((Entity) descriptor);
		return entities;
	}*/


		//old getProperties()
		/*List<Property> properties = new ArrayList<Property>();
		Set<OWLEntity> entities = ontology.getEntitiesInSignature(IRI.create(entity.getURI()));
		
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
		
		for (OWLObjectPropertyExpression prop : ontology.getObjectPropertiesInSignature()) {
            OWLClassExpression restriction = factory.getOWLObjectSomeValuesFrom(prop, factory.getOWLThing());
            
            for(OWLEntity owl_entity : entities){
            	if(owl_entity.isOWLClass()){
            		OWLClassExpression intersection = factory.getOWLObjectIntersectionOf((OWLClass)owl_entity, factory.getOWLObjectComplementOf(restriction));
                    boolean sat = !reasoner.isSatisfiable(intersection);
                    if (sat) {
                    	Property newproperty = SemanticsFactory.eINSTANCE.createProperty();
        				newproperty.setURI(prop.toString());
        				entity.getProperties().add(newproperty);
        				model.getDescriptors().add(newproperty);
                    }
            	}
            }    
        }
		
		ontology.getEntitiesInSignature(IRI.create(entity.getURI()));*/

	
	public void getProperties(OWLClass clazz) {
		/*OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
		for (OWLObjectPropertyExpression prop : ontology.getObjectPropertiesInSignature()) {
            OWLClassExpression restriction = factory.getOWLObjectSomeValuesFrom(prop, factory.getOWLThing());
            OWLClassExpression intersection = factory.getOWLObjectIntersectionOf(clazz, factory.getOWLObjectComplementOf(restriction));
            boolean sat = !reasoner.isSatisfiable(intersection);
            if (sat) {
            	Property newproperty = SemanticsFactory.eINSTANCE.createProperty();
				newproperty.setURI(prop.toString());
				model.getDescriptors().add(newproperty);
				
                System.out.println("Las instancias de  " + clazz + " tienen la propiedad " + prop);
            }
        }*/
	}

	/*private void print(Node<OWLClass> parent, OWLReasoner reasoner, int depth) {
        if (parent.isBottomNode()) {
            return;
        }
        // Print an indent to denote parent-child relationships
        printIndent(depth);
        // Now print the node (containing the child classes)
        printNode(parent);
        for (Node<OWLClass> child : reasoner.getSubClasses(parent.getRepresentativeElement(), true)) {
            assert child != null;
            // Recurse to do the children. Note that we don't have to worry
            // about cycles as there are non in the inferred class hierarchy
            // graph - a cycle gets collapsed into a single node since each
            // class in the cycle is equivalent.
            print(child, reasoner, depth + 1);
        }
    }

    private static void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
    }

    private static void printNode(Node<OWLClass> node) {
        DefaultPrefixManager pm = new DefaultPrefixManager();
        for (Iterator<OWLClass> it = node.getEntities().iterator(); it.hasNext();) {
            OWLClass cls = it.next();
            String shortForm = pm.getShortForm(cls);
        }
    }*/

	@Override
	public List<String> getClassesLike(String... names) {
		List<String> classes = new ArrayList<String>();
		List<String> wordnetProposals = new ArrayList<String>();
		
		//Map<String, List<List<String>>> wordnetProposals = null;

		for(String name : names){
			Wordnet wordnet = new Wordnet();
			if(wordnet.isNoun(name)){
				List<List<String>> synonymsByName = wordnet.getSynonymsProposal(name);
				for(List<String> partial : synonymsByName){
					wordnetProposals.addAll(partial);
				}
			}
		}
		
		HashSet<String> aux = new HashSet<String>(wordnetProposals);
		wordnetProposals.clear();
		wordnetProposals.addAll(aux);
		
		if((!wordnetProposals.isEmpty()) && (wordnetProposals!=null)){
			if(ontology!=null){
				for (String entry : wordnetProposals){
					for(OWLClass clazz : ontology.getClassesInSignature()){
						if(clazz.getIRI().getShortForm().toLowerCase().compareTo(entry.toLowerCase()) == 0){
							classes.add(clazz.getIRI().toString());
						}
					}
				}				
			}
		}
		else{
			System.err.println("Salta classes like null");
			return null;
		}
		
		return classes;
	}
	
	private List<String> allTheProperties(){
		List<String> properties = new ArrayList<String>();
		for(OWLDataProperty property : ontology.getDataPropertiesInSignature()){
			properties.add(property.getIRI().toString());
		}
		return properties;
	}
	
	@Override
	public List<DataProperty> getDataProperties(String name, boolean supers, boolean equivs) {
		List<DataProperty> properties = new ArrayList<DataProperty>();
		IRI iri = IRI.create(name);
		
		if((ontology!=null) && (ontology.containsClassInSignature(iri))){
			for(OWLDataProperty property : ontology.getDataPropertiesInSignature()){
				for(OWLClassExpression domain : property.getDomains(ontology)){
					if(!domain.isAnonymous()){
						if(domain.asOWLClass().getIRI().toString().compareTo(iri.toString()) == 0){
							Set<OWLDataRange> ranges = property.getRanges(ontology);
							List<String> rangeURIs = new ArrayList<String>();
							
							for(OWLDataRange range : ranges){
								rangeURIs.add(range.asOWLDatatype().getIRI().toString());
							}
							
							properties.add(new DataOWL(property.getIRI().getShortForm(), property.getIRI().toString(), null));
						}
					}
				}
			}
			
			//la ontologia está mal formada... no se puede poner un dominio a una anotación.
			/*for(OWLAnnotationProperty property : ontology.getAnnotationPropertiesInSignature()){
				for(OWLClassExpression domain : property.asOWLDataProperty().getDomains(ontology)){
					if(!domain.isAnonymous()){
						//System.err.println(domain.asOWLClass().getIRI().toString());
						if(domain.asOWLClass().getIRI().toString().compareTo(iri.toString()) == 0){
							properties.add(property.getIRI().toString());
						}
					}
				}
			}*/
		}
		else{
			return null;
		}
		
		if(supers){
			List<String> superclasses = getSuper(name, true);
			for(String superclass : superclasses) properties.addAll(getDataProperties(superclass, supers, equivs));
		}
		
		if(equivs){
			List<String> superclasses = equivs(name);
			for(String superclass : superclasses) properties.addAll(getDataProperties(superclass, supers, equivs));
		}
		
		return properties;
	}

	@Override
	public List<ObjectProperty> getObjectProperties(String name, boolean supers, boolean equivs) {
		List<ObjectProperty> properties = new ArrayList<ObjectProperty>();
		IRI iri = IRI.create(name);
		
		if((ontology!=null) && (ontology.containsClassInSignature(iri))){
			for(OWLObjectProperty property : ontology.getObjectPropertiesInSignature()){
				for(OWLClassExpression domain : property.getDomains(ontology)){
					if(!domain.isAnonymous()){
						if(domain.asOWLClass().getIRI().toString().compareTo(iri.toString()) == 0){
							Set<OWLClassExpression> ranges = property.getRanges(ontology);
							List<String> rangeURIs = new ArrayList<String>();
							
							for(OWLClassExpression range : ranges){
								if(!range.isAnonymous()){
									rangeURIs.add(range.asOWLClass().getIRI().toString());
								}
							}
							
							properties.add(new ObjectOWL(property.getIRI().getShortForm(), property.getIRI().toString(), rangeURIs));
						}
					}
				}
			}
		}
		else{
			return null;
		}
		
		if(supers){
			List<String> superclasses = getSuper(name, true);
			for(String superclass : superclasses) properties.addAll(getObjectProperties(superclass, supers, equivs));
		}
		
		if(equivs){
			List<String> superclasses = equivs(name);
			for(String superclass : superclasses) properties.addAll(getObjectProperties(superclass, supers, equivs));
		}
		
		return properties;
	}

	@Override
	public List<String> getRelatedClasses(String name, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSuper(String name, boolean direct) {
		List<String> supers = new ArrayList<String>();
		IRI iri = IRI.create(name);
		if(ontology.containsClassInSignature(iri)){
			OWLClass clazz = factory.getOWLClass(iri);
			Set<OWLClassExpression> superclasses = clazz.getSuperClasses(ontology);
			for(OWLClassExpression superclass : superclasses){
				supers.add(superclass.asOWLClass().getIRI().toString());
				if(!direct){
					supers.addAll(getSuper(superclass.asOWLClass().getIRI().toString(), direct));
				}
			}
			
		}
		else{
			System.err.println("Salta super null");
			return null;
		}
		
		return supers;
	}

	private List<String> equivs(String name){
		List<String> equivs = new ArrayList<String>();
		IRI iri = IRI.create(name);
		if(ontology.containsClassInSignature(iri)){
			OWLClass clazz = factory.getOWLClass(iri);
			Set<OWLClassExpression> equivalents = clazz.getEquivalentClasses(ontology);
			for(OWLClassExpression equivalent : equivalents){
				equivs.add(equivalent.asOWLClass().getIRI().toString());
			}
			
		}
		else{
			return null;
		}
		
		return equivs;
	}
	
	@Override
	public List<String> getSub(String name, boolean direct) {
		List<String> subs = new ArrayList<String>();
		IRI iri = IRI.create(name);
		if(ontology.containsClassInSignature(iri)){
			OWLClass clazz = factory.getOWLClass(iri);
			Set<OWLClassExpression> subclasses = clazz.getSubClasses(ontology);
			for(OWLClassExpression subclass : subclasses){
				subs.add(subclass.asOWLClass().getIRI().toString());
				if(!direct){
					subs.addAll(getSub(subclass.asOWLClass().getIRI().toString(), direct));
				}
			}
			
		}
		else{
			return null;
		}
		
		return subs;
	}

	@Override
	public List<String> getPath(String classA, String classB, boolean indirect) {
		List<String> path = new ArrayList<String>();
		
		if(classA.compareTo(classB) == 0) return path;
		
		IRI iriA = IRI.create(classA);
		IRI iriB = IRI.create(classB);
		
		if((!ontology.containsClassInSignature(iriA))||(!ontology.containsClassInSignature(iriB))) return null;
		
		List<ObjectProperty> objectPropertiesA = getObjectProperties(classA, true, true);
		if(!indirect){
			//List<String> objectPropertiesA = getObjectProperties(classA, true, true);
			HashSet<ObjectProperty> aux = new HashSet<ObjectProperty>(objectPropertiesA);
			objectPropertiesA.clear();
			objectPropertiesA.addAll(aux);
			//for(ObjectProperty object : objectPropertiesA) if(object.compareTo(classB) == 0) path.add(object);
			
			return path;
		}
		else{
			
		}
		
		return path;
	}

	@Override
	public ObjectProperty getInverseProperty(String cl, String property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSiblings(String name) {
		List<String> superclasses = getSuper(name, true);
		List<String> siblings = new ArrayList<String>();
		for(String superclass : superclasses){
			siblings.addAll(getSub(superclass, true));
		}
		
		HashSet<String> aux = new HashSet<String>(siblings);
		siblings.clear();
		siblings.addAll(aux);
		
		return siblings;
	}
}
