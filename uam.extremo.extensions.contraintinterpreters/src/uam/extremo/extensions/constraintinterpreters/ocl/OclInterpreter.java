package uam.extremo.extensions.constraintinterpreters.ocl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;

import semanticmanager.impl.ExtensibleConstraintInterpreterImpl;

import org.eclipse.emf.common.util.Diagnostic;

import semanticmanager.Constraint;
import semanticmanager.NamedElement;

public class OclInterpreter extends ExtensibleConstraintInterpreterImpl {	
	@Override
	public boolean eval(Constraint constraint, NamedElement namedElement) {
		if(namedElement.getTrace() instanceof EObject){
			EObject eObject = (EObject) namedElement.getTrace();
			Diagnostic d = Diagnostician.INSTANCE.validate(eObject);
			if(d.getSeverity() != Diagnostic.OK){
				return false;
			}
			return true;
		}
		
		return false;
	}
}
