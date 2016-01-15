package metardf.ui.views.entities;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
//import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.TextTransfer;

import metardf.ui.dnd.ModelTransfer;

public class EntityDragSourceListener implements DragSourceListener {
	private final EntityTreeViewer viewer;
	
	public EntityDragSourceListener(EntityTreeViewer viewer){
		this.viewer = viewer;
	}
	
	@Override
	public void dragStart(DragSourceEvent event) {
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
	    IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
	    if(selection.getFirstElement() instanceof IAdaptable){
	    	IAdaptable data = (IAdaptable) selection.getFirstElement();	
		    if (ModelTransfer.getInstance().isSupportedType(event.dataType)) {
		    	event.data = data;
		    }
	    }
	}

	@Override
	public void dragFinished(DragSourceEvent event) {	
	}
}
