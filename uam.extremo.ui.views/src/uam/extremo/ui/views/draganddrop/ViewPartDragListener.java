package uam.extremo.ui.views.draganddrop;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;

import semanticmanager.NamedElement;

public class ViewPartDragListener implements DragSourceListener {
	private final TreeViewer viewer;

    public ViewPartDragListener(TreeViewer viewer) {
    	this.viewer = viewer;
    	
    	DragSource source = new DragSource(viewer.getControl(), DND.DROP_COPY);
    	
    	source.setTransfer(new Transfer[] {
    			TextTransfer.getInstance(), 
    			NamedElementTransfer.getInstance()
    	});
    	
    	source.addDragListener(this);
    }
	
	
	@Override
	public void dragStart(DragSourceEvent event) {
		event.doit = !viewer.getSelection().isEmpty();
	}

	@Override
	public void dragSetData(DragSourceEvent event) {		
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
	    
	    String data = ((NamedElement) selection.getFirstElement()).getName();	    
	    	    
	    if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
	    	event.data = data;
	    }
	    else{
	    	if(NamedElementTransfer.getInstance().isSupportedType(event.dataType)){
		    	event.data = data;
		    }
	    }  
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
	}
}
