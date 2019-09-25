package at.ac.tuwien.big.xmltext.internal.instance.ecoretransform;

import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.xmltext.internal.instance.ecoretransform.impl.TransformatorImpl;

public interface PartialObjectCopier {
	
	public void copyFrom(TransformatorImpl transformator, EObject from, EObject to);

}
