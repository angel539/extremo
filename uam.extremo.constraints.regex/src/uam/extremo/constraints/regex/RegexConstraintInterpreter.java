package uam.extremo.constraints.regex;

import uam.extremo.core.Constraint;
import uam.extremo.core.NamedElement;
import uam.extremo.core.impl.ConstraintInterpreterImpl;

public class RegexConstraintInterpreter extends ConstraintInterpreterImpl {
	@Override
	public boolean eval(Constraint constraint, NamedElement namedElement) {
		return true;
	}
}
