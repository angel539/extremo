package uam.extremo.ui.views.extensions.filters;

import org.eclipse.jface.viewers.Viewer;

public interface IExtremoViewPartFilterContribution {
	public boolean filter(Viewer viewer, Object parentElement, Object element);
}
