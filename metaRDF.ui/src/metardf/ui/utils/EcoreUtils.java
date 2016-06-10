package metardf.ui.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jface.viewers.Viewer;

public class EcoreUtils {
	private Resource resource = null;
	
	public void create(File ecore){
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		
		URI fileURI = URI.createFileURI(ecore.getAbsolutePath());
		resource = resourceSet.getResource(fileURI, true);
	}
	
	public List<EClass> getEClasses(){
		List<EClass> classes = new ArrayList<EClass>();
		
		TreeIterator<EObject> ecoreAll = resource.getAllContents();
		while(ecoreAll.hasNext()){
			EObject object = ecoreAll.next();
			if(object instanceof EClass){
				classes.add((EClass) object);
			}
		}
		
		//EcoreEditor editor = new EcoreEditor();
		//Viewer viewer = editor.getViewer();
		//viewer.
		
		return classes;
	}
	
	public void save(){
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
