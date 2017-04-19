package semanticmanager.constraints;

import semanticmanager.dataModel.NamedElement;

public interface ExtensibleConstraintInterpreter extends ConstraintInterpreter{
	boolean eval(Constraint c, NamedElement n);
}
