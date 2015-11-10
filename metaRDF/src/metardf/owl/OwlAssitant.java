package metardf.owl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.io.StreamDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.util.AutoIRIMapper;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

import metardf.core.DataProperty;
import metardf.core.IFormatAssistant;
import metardf.core.ObjectProperty;
import metardf.core.Property;

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
	
	public OWLOntologyManager create(){
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

	@Override
	public void getProperties(Entity entity) {
		
		List<Property> properties = new ArrayList<Property>();
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
		
		ontology.getEntitiesInSignature(IRI.create(entity.getURI()));
	}
	
	public void getProperties(OWLClass clazz) {
		OWLReasonerConfiguration config = new SimpleConfiguration();
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
        }
	}

	@Override
	public List<Entity> getSuper(Entity entity) {
		// TODO Auto-generated method stub	
		return null;
	}

	@Override
	public boolean getRelation(Entity entityA, Entity entityB) {
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public String getDescription(Descriptor descriptor) {
		// TODO Auto-generated method stub
		return null;
	}

	private void print(Node<OWLClass> parent, OWLReasoner reasoner, int depth) {
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
    }
	
	@Override
	public List<Entity> getSub(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Entity, Entity> getSubRecursivelly(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getClassesLike(String... names) {
		List<String> classes = new ArrayList<String>();
		OWLOntologyManager m = create();
		if(ontology!=null){
			for(OWLClass clazz : ontology.getClassesInSignature()){
				for(String s : names){
					if(clazz.toString().compareTo(s) == 0){
						classes.add(clazz.toString());
					}
				}
			}
		}
		
		return classes;
	}

	@Override
	public List<DataProperty> getDataProperties(String name, boolean supers, boolean equivs) {
		List<DataProperty> properties = new ArrayList<DataProperty>();
		
		OWLReasonerConfiguration config = new SimpleConfiguration();
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
		for (OWLObjectPropertyExpression prop : ontology.getObjectPropertiesInSignature()) {
            OWLClassExpression restriction = factory.getOWLObjectSomeValuesFrom(prop, factory.getOWLThing());
            OWLClassExpression intersection = factory.getOWLObjectIntersectionOf(clazz, factory.getOWLObjectComplementOf(restriction));
            boolean sat = !reasoner.isSatisfiable(intersection);
            if (sat) {
            	//properties.add(prop.toString());
            }
        }
		return properties;
	}

	@Override
	public List<ObjectProperty> getObjectProperties(String name, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getRelatedClasses(String name, boolean supers, boolean equivs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSuper(String name, boolean direct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSub(String entity, boolean direct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ObjectProperty> getPath(String entityA, String entityB, boolean indirect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectProperty getInverseProperty(String cl, String property) {
		// TODO Auto-generated method stub
		return null;
	}
}
