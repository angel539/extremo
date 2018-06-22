package uam.extremo.ui.views.draganddrop;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;

import semanticmanager.NamedElement;

public class NamedElementDragListener implements DragSourceListener {
	private final TreeViewer viewer;

    public NamedElementDragListener(TreeViewer viewer) {
    	this.viewer = viewer;
    }
	
	@Override
	public void dragStart(DragSourceEvent event) {
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		
		String data = ((NamedElement) selection.getFirstElement()).getName();	    
	    
	    if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
	    	event.data = data;
	    }
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
	}
}
