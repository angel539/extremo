package orders.veditor.dnd;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.ISemanticClass;
import metardf.ui.dnd.GraphityEditorTransferDropTargetListener;

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
		super.drop(event);
	}
	
	@Override
	public void dropAccept(DropTargetEvent event) {
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
		System.out.println(getCurrentEvent().data.getClass());
		
		if(getCurrentEvent().data instanceof ISemanticClass[]){
			System.out.println("soy un semanticclass ..." + ((ISemanticClass[])getCurrentEvent().data)[0].getName());
		}
	
		super.handleDrop();
	}
}
