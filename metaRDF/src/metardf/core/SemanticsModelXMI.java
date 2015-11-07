package metardf.core;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import metardf.model.semantics.SemanticDescription;
import metardf.model.semantics.SemanticsPackage;

public class SemanticsModelXMI {	
	public static boolean save(SemanticDescription model) {
		String extension = "semantics";
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> modelMap = reg.getExtensionToFactoryMap();
		modelMap.put(extension, new XMIResourceFactoryImpl());
		
	    ResourceSet resSet = new ResourceSetImpl();
	    Resource resource = resSet.createResource(URI.createURI("semantics/" + model.getName() + "." + extension));
	    resource.getContents().add(model);
	    
	    try {
	      resource.save(Collections.EMPTY_MAP);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		return true;
	}
	
	public static SemanticDescription load(String resource_path) {
	    SemanticsPackage.eINSTANCE.eClass();
	    
	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("semantics", new XMIResourceFactoryImpl());

	    ResourceSet resSet = new ResourceSetImpl();

	    //Resource resource = resSet.getResource(URI.createURI("website/My.website"), true);
	    Resource resource = resSet.getResource(URI.createURI(resource_path), true);

	    SemanticDescription description = (SemanticDescription) resource.getContents().get(0);
	    return description;
	  }
}
