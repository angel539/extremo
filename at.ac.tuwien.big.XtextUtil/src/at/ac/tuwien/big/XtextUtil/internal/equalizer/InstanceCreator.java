package at.ac.tuwien.big.XtextUtil.internal.equalizer;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.xmltext.util.MyEcoreUtil;

public interface InstanceCreator  {
	
	InstanceCreator DEFAULT = new InstanceCreator() {
		
		@Override
		public EObject createInstance(EObject container, EClass cl) {
			return MyEcoreUtil.createInstanceStatic(cl);
		}
	};

	public EObject createInstance(EObject container, EClass cl);
	
	
	public default EObject create(EObject container, EClass cl) {
		return createInstance(container,cl);
	}

	public default EObject copyBasic(EObject targetObject) {
		EObject ret = createInstance(targetObject.eContainer(),targetObject.eClass());
		for (EStructuralFeature esf: targetObject.eClass().getEAllStructuralFeatures()) {
			if (esf.isMany()) {
				ret.eSet(esf, new BasicEList((Collection)targetObject.eGet(esf)));
			} else {
				if (targetObject.eIsSet(esf)) {
					ret.eSet(esf, targetObject.eGet(esf));
				} else {
					ret.eUnset(esf);
				}
			}
		}
		return ret;
	}

}
