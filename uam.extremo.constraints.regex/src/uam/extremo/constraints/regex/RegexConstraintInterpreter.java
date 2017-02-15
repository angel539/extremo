package uam.extremo.constraints.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import semanticmanager.Constraint;
import semanticmanager.NamedElement;
import semanticmanager.impl.ConstraintInterpreterImpl;

public class RegexConstraintInterpreter extends ConstraintInterpreterImpl {

	public RegexConstraintInterpreter() {
	}

	@Override
	public void execute(Constraint constraint) {
		if(constraint.getValue() instanceof String){
			String constraintValue = (String) constraint.getValue();
			
			Pattern r = Pattern.compile(constraintValue);
			for(NamedElement namedElement : constraint.getApplyOnElements()){
				Matcher m = r.matcher(namedElement.getName());
				if (m.find()) {
					constraint.getValidatedElements().add(namedElement);
				}
			}
		}
	}
}
