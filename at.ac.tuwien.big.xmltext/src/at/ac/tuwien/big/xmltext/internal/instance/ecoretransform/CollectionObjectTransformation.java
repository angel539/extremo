package at.ac.tuwien.big.xmltext.internal.instance.ecoretransform;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.xmltext.internal.instance.ecoretransform.impl.TransformatorImpl;

public interface CollectionObjectTransformation extends ObjectTransformation {


	public Collection<EObject> convertToEcore(Collection<EObject> xml, Transformator transformator);
	
	public Collection<EObject> convertToXml(Collection<EObject> eobject, Transformator transformator);
}
