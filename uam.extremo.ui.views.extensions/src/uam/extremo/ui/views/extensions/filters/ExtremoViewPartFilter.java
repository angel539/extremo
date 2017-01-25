package uam.extremo.ui.views.extensions.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;

public abstract class ExtremoViewPartFilter extends ViewerFilter implements IExtremoViewPartFilterContribution{		
	/*public void saveState(IMemento memento) {
		if (pattern.length() == 0) return;
		
		IMemento mem = memento.createChild(TAG_TYPE);
		mem.putString(TAG_PATTERN, pattern);
	}
	
	public void init(IMemento memento) {
		IMemento mem = memento.getChild(TAG_TYPE);
		
		if (mem == null) return;
		setPattern(mem.getString(TAG_PATTERN));
	}*/
}
