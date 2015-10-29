package metardf.core;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.io.StreamDocumentTarget;
import org.semanticweb.owlapi.io.StringDocumentSource;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.util.AutoIRIMapper;

public class OWLQueryManager {
	public IRI owl_iri;
	OWLDataFactory factory = OWLManager.getOWLDataFactory();
	OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();

	public OWLQueryManager() {
		super();
	}
	
	public OWLQueryManager(String owlpath) {
		super();
		this.owl_iri = IRI.create(owlpath);
	}
	
	@SuppressWarnings("deprecation")
	public OWLOntologyManager create(){
		OWLOntologyManager m = OWLManager.createOWLOntologyManager();
		m.addIRIMapper(new AutoIRIMapper(new File("materializedOntologies"), true));
		return m;
	}
	
	public void loading() throws Exception {
		OWLOntologyManager m = create();
		OWLOntology o = m.loadOntologyFromOntologyDocument(owl_iri);
	}
	
	public void loadFromFilePath(String filepath) throws Exception {
		File fileBase = new File(filepath);
		OWLOntologyManager m = create();
		OWLOntology o = m.loadOntologyFromOntologyDocument(fileBase);
	}
	
	public void showClasses(){
		OWLOntologyManager m = create();
		OWLOntology ontology;
		try {
			ontology = m.loadOntologyFromOntologyDocument(owl_iri);
			StringDocumentTarget target = new StringDocumentTarget();
			m.saveOntology(ontology, target);
			m.removeOntology(ontology);
			OWLOntology o2 = m.loadOntologyFromOntologyDocument(new StringDocumentSource(target.toString()));
			for(OWLClass clazz : ontology.getClassesInSignature()) System.out.println(clazz);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		} catch (OWLOntologyStorageException e) {
			e.printStackTrace();
		}
	}
	
	public void showClassesFromFile(String filepath){
		File fileBase = new File(filepath);
		OWLOntologyManager m = create();
		OWLOntology ontology;
		try {
			ontology = m.loadOntologyFromOntologyDocument(fileBase);

			StringDocumentTarget target = new StringDocumentTarget();
			m.saveOntology(ontology, target);
			m.removeOntology(ontology);
			OWLOntology o2 = m.loadOntologyFromOntologyDocument(new StringDocumentSource(target.toString()));

			for(OWLClass clazz : ontology.getClassesInSignature()) System.out.println(clazz);
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		} catch (OWLOntologyStorageException e) {
			e.printStackTrace();
		}
	}
	
	public void createOntology() throws OWLOntologyCreationException{
		OWLOntologyManager m = create();
		OWLOntology ontology = m.createOntology(owl_iri);
	}
	
	public void createOntologyFromFile() throws OWLOntologyCreationException{
		OWLOntologyManager m = create();
		OWLOntology ontology = m.createOntology(owl_iri);
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
}
