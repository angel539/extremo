package metardf.ui.views.entities;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import metardf.ui.dnd.ModelTransfer;

public class EntityTreeViewer extends TreeViewer {

	public EntityTreeViewer(Composite parent) {
		super(parent);
	}

	public EntityTreeViewer(Tree tree) {
		super(tree);
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
		DragSource ds = new DragSource(getTree(), DND.DROP_COPY);
		ds.setTransfer(new Transfer[] {ModelTransfer.getInstance()});
		ds.addDragListener(new DragSourceAdapter() {
		     public void dragSetData(DragSourceEvent event) {
		    	 IStructuredSelection selection = (IStructuredSelection) getSelection();
		    	 if(selection.getFirstElement() instanceof IAdaptable){
		 	    	IAdaptable data = (IAdaptable) selection.getFirstElement();	
		 		    if (ModelTransfer.getInstance().isSupportedType(event.dataType)) {
		 		    	event.data = data;
		 		    }
		 	    }
		    	 
		    	//event.data = getSelection();
		     }
		  });
	}
}
