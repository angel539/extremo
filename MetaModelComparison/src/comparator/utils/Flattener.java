package comparator.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.xml.XMLLayout;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class Flattener {
	private File model;
	private List<EClass> flattenedClasses;
	
	Map<EClassifier, EClassifier> correspondanceOldWithNew = new HashMap<EClassifier, EClassifier>();
	
	public Flattener() throws IOException{
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		BasicConfigurator.configure(new FileAppender(new XMLLayout(), "log.xml"));
		
		this.setModel(model);
	}
	
	public void flatten(File model, File targetFolder){
		TreeIterator<EObject> modelAll = loadModel(model, null).getAllContents();
		
	    EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
	    EPackage mainPackage = ecoreFactory.createEPackage();
	    
	    /*set EPackage properties*/
	    String fileNameWithoutExtension = FilenameUtils.removeExtension(model.getName());  
	    
	    mainPackage.setName("main");
	    mainPackage.setNsPrefix("main");
	    mainPackage.setNsURI("http://com.extremo/" + fileNameWithoutExtension + "/");
		
		if(modelAll != null){
			while(modelAll.hasNext()){
				EObject obj = modelAll.next();
				
				if((obj != null) && (obj instanceof EClassifier)){
					if(obj instanceof EClass){
						EClass eClass = (EClass) obj;
						
						if(!eClass.isAbstract()){
							EClass newEClass = flattenEClass(ecoreFactory, mainPackage, eClass); // without references and attributes with type enum
							correspondanceOldWithNew.put(eClass, newEClass);
						}
					}
					
					if(obj instanceof EEnum){
						EEnum eEnum = (EEnum) obj;
						
						EEnum newEEnum = flattenEEnum(ecoreFactory, mainPackage, eEnum);
						correspondanceOldWithNew.put(eEnum, newEEnum);
					}
				}
			}
			
			for(Entry<EClassifier, EClassifier> entry : correspondanceOldWithNew.entrySet()){
				EClassifier eClassifierOld = entry.getKey();
				EClassifier eClassifierNew = entry.getValue();
				
				if(eClassifierOld instanceof EClass && eClassifierNew instanceof EClass){
					EClass eClassOld = (EClass) eClassifierOld;
					EClass eClassNew = (EClass) eClassifierNew;
					
					for(EAttribute eAttribute : eClassOld.getEAllAttributes()){
						if(eAttribute.getEType() instanceof EEnum){
							EAttribute newEAttribute = EcoreUtil.copy(eAttribute);
							
							if(correspondanceOldWithNew.get(eAttribute.getEType()) instanceof EEnum)
								newEAttribute.setEType(correspondanceOldWithNew.get(eAttribute.getEType()));
							
							eClassNew.getEStructuralFeatures().add(newEAttribute);	
						}
					}
					
					for(EReference eReference : eClassOld.getEAllReferences()){	
						EClassifier range = correspondanceOldWithNew.get(eReference.getEType());
						
						if(range != null && range instanceof EClass){
							EReference newEReference = EcoreUtil.copy(eReference);
							newEReference.setEType(range);		
							eClassNew.getEStructuralFeatures().add(newEReference);
						}
						else{
							if(range == null){ //
								EClassifier oldRange = eReference.getEType();
								
								if(oldRange instanceof EClass){
									EClass oldRangeEClass = (EClass) oldRange;
									List<EClass> oldRangeEClassChildren = correspondanceOldWithNew.keySet().stream().
																	filter(eClassifier -> (eClassifier instanceof EClass) && oldRangeEClass.isSuperTypeOf((EClass) eClassifier)).
																	map(EClass.class::cast).collect(Collectors.toList());
									
									for(EClass child : oldRangeEClassChildren){
										EReference newEReference = EcoreUtil.copy(eReference);
										
										EClassifier childRange = correspondanceOldWithNew.get(child);
										newEReference.setEType(childRange);		
										eClassNew.getEStructuralFeatures().add(newEReference);
									}							
								}
							}
						}
					}
				}	
			}
		}
		
	    ResourceSet resSet = new ResourceSetImpl();
		Resource resource = null;
	    try {
	        resource = resSet.createResource(URI.createFileURI(targetFolder.getAbsolutePath() + "/" + fileNameWithoutExtension +".ecore"));
	    }
	    catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    resource.getContents().add(mainPackage);
	    
	    try {
	        resource.save(Collections.EMPTY_MAP);
	    }
	    catch (IOException e) {
	    	 e.printStackTrace();
	    }
	}
	
	private EClass flattenEClass(EcoreFactory ecoreFactory, EPackage ePackage, EClass eClass){
		EClass newEClass = ecoreFactory.createEClass();
		newEClass.setName(eClass.getName());
		
		for(EAttribute eAttribute : eClass.getEAllAttributes()){
			if(!(eAttribute.getEType() instanceof EEnum)){
				EAttribute newEAttribute = EcoreUtil.copy(eAttribute);
				newEClass.getEStructuralFeatures().add(newEAttribute);
			}		
		}
		
		ePackage.getEClassifiers().add(newEClass);
		return newEClass;
	}
	
	private EEnum flattenEEnum(EcoreFactory ecoreFactory, EPackage ePackage, EEnum eEnum){
		EEnum newEEnum = ecoreFactory.createEEnum();
		newEEnum.setName(eEnum.getName());
		
		for(EEnumLiteral enumLiteral : eEnum.getELiterals()){
			EEnumLiteral newEnumLiteral = EcoreUtil.copy(enumLiteral);
			newEEnum.getELiterals().add(newEnumLiteral);
		}
		
		ePackage.getEClassifiers().add(newEEnum);
		return newEEnum;
	}

	private Resource loadModel(File model, EPackage p) {		
		URI uri = URI.createFileURI(model.getPath());
		ResourceSet rs = new ResourceSetImpl();
		if (p!=null) {
			rs.getPackageRegistry().put(p.getNsURI(), p);
		}
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());
		Resource resource = rs.getResource(uri, true);
		return resource;
	}

	public File getModel() {
		return model;
	}

	public void setModel(File model) {
		this.model = model;
	}

	public List<EClass> getFlattenedClasses() {
		return flattenedClasses;
	}

	public void setFlattenedClasses(List<EClass> flattenedClasses) {
		this.flattenedClasses = flattenedClasses;
	}
	
	protected static List<File> getFilesForFolder(final File folder) {
		List<File> files = new ArrayList<File>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				files.addAll(getFilesForFolder(fileEntry));
			}
			else {
				if(fileEntry.getName().endsWith(".ecore"))
					files.add(fileEntry);
			}
		}
		return files;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Flattener flattener = new Flattener();
		File mm000 = new File("ecores/000.ecore");
		flattener.flatten(mm000, new File("ecores/flattened/"));
		
		List<File> controlGroup = getFilesForFolder(new File("ecores/Control-Group-Ecores/"));
		for(File mmControl : controlGroup){
			flattener.flatten(mmControl, new File("ecores/flattened/"));
		}
		
		List<File> experimentGroup = getFilesForFolder(new File("ecores/Experiment-Group-Ecores/"));
		for(File mmExperiment : experimentGroup){
			flattener.flatten(mmExperiment, new File("ecores/flattened/"));
		}
	}
}
