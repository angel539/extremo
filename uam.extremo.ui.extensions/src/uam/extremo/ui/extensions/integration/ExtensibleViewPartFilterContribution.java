package uam.extremo.ui.extensions.integration;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public abstract class ExtensibleViewPartFilterContribution 
							extends ViewerFilter {
	public abstract boolean filter(Viewer viewer, Object parentElement, Object element);
}
