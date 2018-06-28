package at.ac.tuwien.big.xmltext.internal.instance.ecoretransform;

public interface ValueTransformator<Xml,Ecore> {
	
	public Ecore convertToEcore(Xml xml);
	
	public Xml convertToXml(Ecore eobject);

}
