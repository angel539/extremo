package semanticmanager;

import semanticmanager.Constraint;
import semanticmanager.ConstraintInterpreter;
import semanticmanager.NamedElement;

public interface ExtensibleConstraintInterpreter extends ConstraintInterpreter{
	boolean eval(Constraint c, NamedElement n);
}
