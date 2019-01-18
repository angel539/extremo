package uam.extremo.ui.views.searchtree;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;

public class SemanticNodeDragListener implements DragSourceListener {
	TreeViewer viewer;
	
	public SemanticNodeDragListener(TreeViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void dragStart(DragSourceEvent event) {
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		Object[] dataObjects = selection.toArray();
		event.data = dataObjects;
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
	}
}
