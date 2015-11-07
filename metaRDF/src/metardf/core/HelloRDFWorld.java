package metardf.core;
import java.io.File;
import java.util.List;

import org.apache.jena.rdf.model.Resource;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import metardf.utils.EcoreUtils;
import metardf.utils.Wordnet;

public class HelloRDFWorld {
	public static void main(String[] arguments){	
		org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
		
		EcoreUtils utils = new EcoreUtils();
		utils.create(new File("/Users/angel/git/metaRDF/metaRDF/model/Empty.ecore"));
		List<EClass> classes = utils.getEClasses();
		
		RDFAssistant sparq = new RDFAssistant();
		
		for(EClass clazz : classes){
			List<Resource> candidates = null;
			//List<Resource> candidates = sparq.getProperties(clazz.getName());
			Wordnet wordnet = new Wordnet();
			List<List<String>> proposals = wordnet.getSynonymsProposal(clazz.getName());
			for(List<String> proposal : proposals){
				System.out.println(">>>");
				for(String prop : proposal){
					System.out.println(">>" + prop);
				}
			}
			if(candidates!=null && candidates.size()>0){
				for(Resource candidate : candidates){
					EAttribute newattr = EcoreFactory.eINSTANCE.createEAttribute();
					newattr.setName(candidate.getLocalName());
					newattr.setEType(EcorePackage.eINSTANCE.getEString());
					clazz.getEStructuralFeatures().add(newattr);
				}
			}
		}
		
		utils.save();
	}
}

//import org.apache.jena.datatypes.xsd.XSDDatatype;
//import org.apache.jena.rdf.model.Model;
//import org.apache.jena.rdf.model.ModelFactory;
//import org.apache.jena.rdf.model.Property;
//import org.apache.jena.rdf.model.Resource;

//Para crear un modelo RDF a mano.

//with the logger OFF
//

//Model model = ModelFactory.createDefaultModel();
//String namespace = "http://example.com/test/";

//Resource resource = model.createResource(namespace + "resource");
//Property property = model.createProperty(namespace + "property");

//resource.addProperty(property, "hello world", XSDDatatype.XSDstring);
//model.write(System.out, "Turtle");

//sparq.getSubClasses("one");
