package comparator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.xml.XMLLayout;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import comparator.exact.emfcompare.*;
import comparator.exact.flattened.*;
import comparator.inexact.flattened.*;
import comparator.inexact.own.*;
import comparator.utils.LangUtils;

public abstract class MMComparator {
	public MMComparator() throws IOException { 	
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		BasicConfigurator.configure(new FileAppender(new XMLLayout(), "log.xml"));
	}
	
	public abstract void match() throws IOException;
	protected abstract void compare(File x, File y);
	protected abstract void generateStatsMatches() throws IOException;
	protected abstract void generateFilesMatches() throws IOException;
	protected abstract void generateMatchEntry(File x, File y) throws IOException;
	
	protected Resource loadModel(File model, EPackage p) {		
		URI uri = URI.createFileURI(model.getPath());
		ResourceSet rs = new ResourceSetImpl();
		if (p!=null) {
			rs.getPackageRegistry().put(p.getNsURI(), p);
		}
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());
		Resource resource = rs.getResource(uri, true);
		return resource;
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
	
	public boolean inexactMatch(String expression, String value) {
		if(expression.compareTo(value) == 0) return true;
		else{
			List<String> expressionList = LangUtils.cleanAndSeparateWords(expression);
			
			for(String e : expressionList){	
				if(e.compareToIgnoreCase(value) == 0){
					return true;
				}
				else{
					if(LangUtils.haveTheSameStem(e, value)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{	
		(new MMComparatorMatchesModelZero()).match();
		(new MMComparatorUnmatchesModelZero()).match();
		(new MMComparatorMatchesMatrix()).match();
		(new MMComparatorUnmatchesMatrix()).match();
		
		(new FlattenedMMComparatorMatchesModelZero()).match();
		(new FlattenedMMComparatorUnmatchesModelZero()).match();
		(new FlattenedMMComparatorMatchesMatrix()).match();
		(new FlattenedMMComparatorUnmatchesMatrix()).match();
		
		(new FlattenedMMComparatorInexactMatchesModelZero()).match();
		(new FlattenedMMComparatorInexactUnmatchesModelZero()).match();
		(new FlattenedMMComparatorInexactMatchesMatrix()).match();
		(new FlattenedMMComparatorInexactUnmatchesMatrix()).match();
		
		(new NonFlattenedMMComparatorInexactMatchesModelZero()).match();
		(new NonFlattenedMMComparatorInexactUnmatchesModelZero()).match();
		(new NonFlattenedMMComparatorInexactMatchesMatrix()).match();
		(new NonFlattenedMMComparatorInexactUnmatchesMatrix()).match();
	}
}
