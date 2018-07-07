package uam.extremo.core;

import uam.extremo.core.Constraint;
import uam.extremo.core.ConstraintInterpreter;
import uam.extremo.core.NamedElement;

public interface ExtensibleConstraintInterpreter extends ConstraintInterpreter{
	boolean eval(Constraint constraint, NamedElement namedElement);
}
