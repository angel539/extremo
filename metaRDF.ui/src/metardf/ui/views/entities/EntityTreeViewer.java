package metardf.ui.views.entities;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

public class EntityTreeViewer extends TreeViewer {
	public EntityTreeViewer(Composite parent) {
		super(parent);
		
		/*DragSource ds = new DragSource(getTree(), DND.DROP_COPY);
		ds.setTransfer(new Transfer[] {ExtremoModelTransfer.getInstance()});
		ds.addDragListener(new DragSourceAdapter() {
		     public void dragSetData(DragSourceEvent event) {
		    	 IStructuredSelection selection = (IStructuredSelection) getSelection();
		    	 if(selection.getFirstElement() instanceof IAdaptable){
		 	    	IAdaptable data = (IAdaptable) selection.getFirstElement();	
		 		    if (ExtremoModelTransfer.getInstance().isSupportedType(event.dataType)) {
		 		    	event.data = data;
		 		    }
		 	    }
		     }
		  });*/
	}

	public EntityTreeViewer(Tree tree) {
		super(tree);
		
		/*DragSource ds = new DragSource(getTree(), DND.DROP_COPY);
		ds.setTransfer(new Transfer[] {ExtremoModelTransfer.getInstance()});
		ds.addDragListener(new DragSourceAdapter() {
		     public void dragSetData(DragSourceEvent event) {
		    	 IStructuredSelection selection = (IStructuredSelection) getSelection();
		    	 if(selection.getFirstElement() instanceof IAdaptable){
		 	    	IAdaptable data = (IAdaptable) selection.getFirstElement();	
		 		    if (ExtremoModelTransfer.getInstance().isSupportedType(event.dataType)) {
		 		    	event.data = data;
		 		    }
		 	    }
		     }
		  });*/
	}

	public EntityTreeViewer(Composite parent, int style) {
		super(parent, style);
		
		/*
		 * Para vistas
		 */
		/*
		 * int operations = DND.DROP_COPY | DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
		addDragSupport(operations, transferTypes,  new EntityDragSourceListener(this));
		*/
		
		/*
		 * Para editor
		 */
		/*DragSource ds = new DragSource(getTree(), DND.DROP_COPY);
		ds.setTransfer(new Transfer[] {ExtremoModelTransfer.getInstance()});
		ds.addDragListener(new DragSourceAdapter() {
		     public void dragSetData(DragSourceEvent event) {
		    	 IStructuredSelection selection = (IStructuredSelection) getSelection();
		    	 if(selection.getFirstElement() instanceof IAdaptable){
		 	    	IAdaptable data = (IAdaptable) selection.getFirstElement();	
		 		    if (ExtremoModelTransfer.getInstance().isSupportedType(event.dataType)) {
		 		    	event.data = data;
		 		    }
		 	    }
		    	event.data = getSelection();
		     }
		  });*/
	}
}
