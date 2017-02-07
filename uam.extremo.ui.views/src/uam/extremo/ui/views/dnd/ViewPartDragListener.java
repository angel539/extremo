package uam.extremo.ui.views.dnd;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;

import semanticmanager.NamedElement;

public class ViewPartDragListener implements DragSourceListener {
	private final TreeViewer viewer;

    public ViewPartDragListener(TreeViewer viewer) {
            this.viewer = viewer;
    }
	
	
	@Override
	public void dragStart(DragSourceEvent event) {
		System.out.println("Start Drag");
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
        IStructuredSelection selection = viewer.getStructuredSelection();
        Object firstElement = (Object) selection.getFirstElement();
        
        if(firstElement instanceof NamedElement){
        	NamedElement namedElement = (NamedElement) firstElement;
        
        	if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
                event.data = namedElement.getName() + " " + namedElement.getDescription();
        	}
        }
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		System.out.println("Finshed Drag");
	}

}
