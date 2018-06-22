package semanticmanager;

import semanticmanager.ConstraintInterpreter;

public interface ExtensibleConstraintInterpreter extends ConstraintInterpreter{
	boolean eval(Constraint constraint, NamedElement namedElement);
}
