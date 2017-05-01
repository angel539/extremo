package uam.extremo.constraints.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import semanticmanager.Constraint;
import semanticmanager.impl.ConstraintInterpreterImpl;
import semanticmanager.NamedElement;

public class RegexConstraintInterpreter extends ConstraintInterpreterImpl {
	public RegexConstraintInterpreter() {
	}

	@Override
	public boolean eval(Constraint constraint, NamedElement namedElement) {
		Pattern r = Pattern.compile(constraint.getBody());
		Matcher m = r.matcher(namedElement.getName());
		return m.find();
	}
}
