package at.ac.tuwien.big.XtextUtil.internal.equalizer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import at.ac.tuwien.big.XtextUtil.internal.equalizer.InstanceCreator;
import at.ac.tuwien.big.xmltext.util.MyEcoreUtil;

public class MyEcoreUtilInstanceCreator implements InstanceCreator {

	@Override
	public EObject createInstance(EObject cont, EClass cl) {
		return MyEcoreUtil.newInstance(cl);
	}

}
