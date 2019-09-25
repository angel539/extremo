package at.ac.tuwien.big.xmltext.internal.instance.ecoretransform;

public interface CollectionValueTransformation<Xml,Ecore> extends ValueTransformation<Xml,Ecore> {
	
	
	public CollectionValueTransformator<Xml, Ecore> getTransformator();
}
