package uam.extremo.extensions.constraintinterpreters.regex;

import semanticmanager.Constraint;
import semanticmanager.NamedElement;
import semanticmanager.impl.ConstraintInterpreterImpl;

public class RegexConstraintInterpreter extends ConstraintInterpreterImpl {
	@Override
	public boolean eval(Constraint constraint, NamedElement namedElement) {
		return true;
	}
}
