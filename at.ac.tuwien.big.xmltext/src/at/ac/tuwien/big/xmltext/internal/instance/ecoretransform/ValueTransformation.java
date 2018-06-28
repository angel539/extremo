package at.ac.tuwien.big.xmltext.internal.instance.ecoretransform;

public interface ValueTransformation<Xml,Ecore> {
	
	public Class<Xml> getXmlClass();
	
	public Class<Ecore> getEcoreClass();
}
