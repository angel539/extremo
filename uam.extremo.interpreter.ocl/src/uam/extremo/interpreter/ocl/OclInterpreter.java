package uam.extremo.interpreter.ocl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.common.util.Diagnostic;

import semanticmanager.Constraint;
import semanticmanager.NamedElement;
import semanticmanager.impl.ExtensibleConstraintInterpreterImpl;

public class OclInterpreter extends ExtensibleConstraintInterpreterImpl {
	public OclInterpreter() {
	}
	
	@Override
	public boolean eval(Constraint constraint, NamedElement namedElement) {
		/*MessageDialog.openInformation(null, 
						"Constraint Interpreter", 
						"Constraint " + constraint.getName() + 
						" of Type " + constraint.getType() + 
						" and Body " + constraint.getBody() +
						" has been called");*/
		
		Diagnostic d = Diagnostician.INSTANCE.validate((EObject) namedElement.getTrace());
		if(d.getSeverity() != Diagnostic.OK)
			return false;
		
		return true;
	}
}
