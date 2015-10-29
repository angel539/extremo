package metardf.core;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;

public class RDF2EClassFinder extends RDF2EcoreElementFinder {
	String literal;
	Iterator<RDFEntity> iterator;
	RDFEntity selectedEntity;
	
	
	public RDF2EClassFinder(String literal, SearchType type) {
		super(type);
		this.literal = literal;
	}


	public String getLiteral() {
		return literal;
	}


	public void setLiteral(String literal) {
		this.literal = literal;
	}
	
	public EClass getEClass(){
		EClass eclass = null;
		return eclass;
	}
	
	public RDFEntity nextEntity(){
		return iterator.next();
	}
	
	
}
