package orders.veditor.dnd;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import metaRDF.core.model.impl.SemanticClass;
import metardf.ui.dnd.GraphityEditorTransferDropTargetListener;
import metardf.ui.dnd.ModelTransfer;

public class OrdersEditorTransferDropTargetListener extends GraphityEditorTransferDropTargetListener {
	GraphicalViewer graphicalViewer = null;
	
	public OrdersEditorTransferDropTargetListener() {
		super();
		setViewer(getGraphicalViewer());
		getViewer().addDropTargetListener(this);
	}
	
	public OrdersEditorTransferDropTargetListener(GraphicalViewer graphicalViewer) {
		super(graphicalViewer);
		setViewer(getGraphicalViewer());
		getViewer().addDropTargetListener(this);
	}
	
	
	@Override
	public void drop(DropTargetEvent event) {
		System.out.println("hace drop una p vez" + event.data);
		super.drop(event);
	}
	
	@Override
	public void dropAccept(DropTargetEvent event) {
		System.out.println("hace drop una p vez en el accept" + event.data);
		super.dropAccept(event);
	}

	@Override
	public void setGraphicalViewer(GraphicalViewer viewer) {
		this.graphicalViewer = viewer;
	}

	@Override
	public GraphicalViewer getGraphicalViewer() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IEditorPart editor = window.getActivePage().getActiveEditor();
		
		IDiagramContainerUI diagramEditor =  (IDiagramContainerUI) editor;
		return diagramEditor.getGraphicalViewer();
	}
	
	@Override
	public void validate() {
		
	}

	@Override
	public void addElement() {
		
	}
	
	@Override
	protected void handleDrop() {
		System.out.println("Paso por handle drop" + getCurrentEvent().data.getClass());
		if(getCurrentEvent().data instanceof SemanticClass[]){
			System.out.println("soy un semanticclass ..." + ((SemanticClass[])getCurrentEvent().data)[0].getName());
		}
		if(getCurrentEvent().data instanceof SemanticClass){
			System.out.println("soy un unico semanticclass ..." + ((SemanticClass)getCurrentEvent().data).getName());
		}
		super.handleDrop();
	}

	/*@Override
	protected void handleDrop() {
		if(getCurrentEvent().data instanceof SemanticClass[]){
			SemanticClass aux = ((SemanticClass[])getCurrentEvent().data)[0];
			System.out.println("objeto nuevo... " + aux.getName() + "..." + aux.getURI());
		}

		System.out.println("---- la clase es: " + getCurrentEvent().data.getClass() + ">>> " + getCurrentEvent().data.toString());
		super.handleDrop();
	}*/
}
