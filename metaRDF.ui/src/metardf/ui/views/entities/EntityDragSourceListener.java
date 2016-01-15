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
		System.out.println("... hola por aqui 1...");
	    IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
	    System.out.println("... hola por aqui 2...");
	    if(selection.getFirstElement() instanceof IAdaptable){
	    	IAdaptable data = (IAdaptable) selection.getFirstElement();	
		    if (ModelTransfer.getInstance().isSupportedType(event.dataType)) {
		    	System.out.println("... aquí entra...");
		    	event.data = data;
		    }
		    else{
		    	System.out.println("... dice que no es un tipo soportado...");
		    }
	    	
	    	/*if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
		    	event.data = data;
		    }*/
	    }
	}

	@Override
	public void dragFinished(DragSourceEvent event) {	
	}
}
