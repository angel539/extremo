package uam.extremo.ui.views.constraints;

import org.eclipse.jface.viewers.Viewer;

import org.eclipse.jface.viewers.ViewerFilter;

import semanticmanager.*;

public class ConstraintValidationViewFilter extends ViewerFilter {
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return element instanceof RepositoryManager
				|| element instanceof ConstraintInterpreter
				|| element instanceof Constraint
				|| element instanceof Resource
				|| element instanceof SemanticNode 
				|| element instanceof Property
				|| element instanceof ObjectProperty
				|| element instanceof DataProperty;
	}
}
