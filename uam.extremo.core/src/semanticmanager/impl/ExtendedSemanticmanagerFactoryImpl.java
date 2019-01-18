package semanticmanager.impl;

import org.eclipse.emf.ecore.EDataType;
import semanticmanager.impl.SemanticmanagerFactoryImpl;

public class ExtendedSemanticmanagerFactoryImpl extends SemanticmanagerFactoryImpl {
	@Override
	public final Object createJavaObjectFromString(EDataType eDataType, String initialValue) {
		return new Object();
	}

	@Override
	public final String convertJavaObjectToString(EDataType eDataType, Object instanceValue) {
		String serialize = eDataType.getName() + "/" + eDataType.getInstanceClassName();
		return serialize;	
	}
}
