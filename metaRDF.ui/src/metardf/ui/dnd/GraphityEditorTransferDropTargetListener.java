package metardf.ui.dnd;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;

import metaRDF.core.model.impl.SemanticClass;

public abstract class GraphityEditorTransferDropTargetListener extends  AbstractTransferDropTargetListener implements IGraphityEditorContribution, IExecutableExtension{	
	protected static EditPartViewer viewer = null;
	
	public GraphityEditorTransferDropTargetListener(GraphicalViewer viewer) {
		super(viewer, ModelTransfer.getInstance());
		//this.viewer = viewer;
		setEnablementDeterminedByCommand(true);
	}
	
	public GraphityEditorTransferDropTargetListener(){
		super(viewer, ModelTransfer.getInstance());
		setEnablementDeterminedByCommand(true);
	}
	
	/*public void init(GraphicalViewer viewer){
		this.viewer = viewer;
		setViewer(viewer);
	}*/
	
	public EditPartViewer getViewer() {
		return viewer;
	}

	public void setViewer(EditPartViewer viewer) {
		this.viewer = viewer;
	}
	
	@Override
	protected void handleDrop() {
		super.handleDrop();
		if (getCurrentEvent().detail == DND.DROP_MOVE) {
			getCurrentEvent().detail = DND.DROP_COPY;
		}
		getViewer().getControl().setFocus();
		System.out.print("Hola 1");
	}

	@Override
	protected void updateTargetRequest() {
		((CreateRequest) getTargetRequest()).setLocation(getDropLocation());
		System.out.print("Hola 2");
	}

	@Override
	protected Request createTargetRequest() {
		CreateRequest request = new CreateRequest();

		request.setFactory(new MetaRDFCreationFactory());
		request.setLocation(getDropLocation());
		System.out.print("Hola 3");
		return request;
	}

	@Override
	protected void handleDragOver() {

		super.handleDragOver();

		Command command = getCommand();
		if (command != null && command.canExecute())
			getCurrentEvent().detail = DND.DROP_COPY;
		System.out.print("Hola 4");
	}

	private class MetaRDFCreationFactory implements CreationFactory {
		public MetaRDFCreationFactory() {
		}

		public Object getNewObject() {
			System.out.print("Hola 5");
			return new SemanticClass("Lo que sea...", "__", "", "");
		}

		public Object getObjectType() {
			System.out.print("Hola 6");
			return SemanticClass.class;
		}
	}
	
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
	}
}
