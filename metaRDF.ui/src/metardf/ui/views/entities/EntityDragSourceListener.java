package metardf.ui.views.entities;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;

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
		    	System.out.println("es un supported type en el drag..." + data.getClass());
		    	event.data = data;
		    }else{
		    	System.out.println("no esta soportado..." + event.data + ":" + event.dataType.getClass());
		    }
	    }
	}

	@Override
	public void dragFinished(DragSourceEvent event) {	
	}
}
