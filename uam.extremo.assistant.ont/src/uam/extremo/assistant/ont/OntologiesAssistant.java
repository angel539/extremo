package uam.extremo.assistant.ont;

import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import uam.extremo.extensions.FormatAssistant;
import uam.extremo.extensions.IFormatAssistant;

public class OntologiesAssistant extends FormatAssistant implements IFormatAssistant {
	public IRI owl_iri = null;
	public File owl_file = null;
	public String path = null;

	OWLDataFactory factory = OWLManager.getOWLDataFactory();
	OWLOntology ontology = null;
	
	semanticmanager.Resource semanticResource = null;
	File file;
	String extension;
	
	public OntologiesAssistant() {
		// TODO Auto-generated constructor stub
	}

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

		owlClassesToSemanticNodes();
		
		return true;
	}
	
	private void owlClassesToSemanticNodes() {
		if(ontology != null){
			for(OWLClass owlClass : ontology.getClassesInSignature()){
				SemanticNode semanticNode = 
						createSemanticNodeWithoutDescriptor(
								owlClass.getIRI().toString(), //original object as id
								owlClass.getIRI().getShortForm(), 
								""); // the name is used as a description label too.
								//it is actually a descriptor element
									
				addSemanticNodeToResource(semanticResource, semanticNode);
				
				for(OWLNamedIndividual individual : owlClass.getIndividualsInSignature()){
					SemanticNode individualSemanticNode = 
							createSemanticNode(
									individual.getIRI().toString(), 
									individual.getIRI().getShortForm(), 
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
		// TODO Auto-generated method stub

	}

	@Override
	public void toObjectProperty(SemanticNode parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toSuper(SemanticNode parent) {
		// TODO Auto-generated method stub

	}

}
