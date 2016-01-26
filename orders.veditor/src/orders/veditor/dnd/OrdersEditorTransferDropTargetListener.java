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
		if(getCurrentEvent().data instanceof ISemanticClass[]){
			System.out.println("soy un semanticclass ..." + ((ISemanticClass[])getCurrentEvent().data)[0].getName());
		}
		if(getCurrentEvent().data instanceof ISemanticClass){
			System.out.println("soy un unico semanticclass ..." + ((ISemanticClass)getCurrentEvent().data).getName());
		}
		
		if(getCurrentEvent().data instanceof IObjectProperty[]){
			System.out.println("soy un OBJECT ..." + ((IObjectProperty[])getCurrentEvent().data)[0].getName());
		}
		if(getCurrentEvent().data instanceof IObjectProperty){
			System.out.println("soy un unico OBJECT ..." + ((IObjectProperty)getCurrentEvent().data).getName());
		}
		
		if(getCurrentEvent().data instanceof IDataProperty[]){
			System.out.println("soy un data    ..." + ((IDataProperty[])getCurrentEvent().data)[0].getName());
		}
		if(getCurrentEvent().data instanceof IDataProperty){
			System.out.println("soy un unico data    ..." + ((IDataProperty)getCurrentEvent().data).getName());
		}
		super.handleDrop();
	}
}
