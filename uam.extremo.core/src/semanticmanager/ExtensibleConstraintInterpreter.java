package semanticmanager;

import semanticmanager.NamedElement;

public interface ExtensibleConstraintInterpreter extends ConstraintInterpreter{
	boolean eval(Constraint c, NamedElement n);
}
