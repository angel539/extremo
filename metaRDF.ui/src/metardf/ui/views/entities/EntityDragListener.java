package metardf.ui.views.entities;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;

public class EntityDragListener implements DragSourceListener {
	TreeViewer viewer;
	
	public EntityDragListener(TreeViewer viewer) {
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
