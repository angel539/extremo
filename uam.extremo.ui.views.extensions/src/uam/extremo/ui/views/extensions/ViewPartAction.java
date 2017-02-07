package uam.extremo.ui.views.extensions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import uam.extremo.ui.views.extensions.dnd.actions.ViewPartDropListener;

public abstract class ViewPartAction extends Action implements IExtremoViewPartActionContribution{
	private StructuredViewer viewer;
	private IEditorPart editorPart;
	private static String viewPartTargetId;
	
	public ViewPartAction(){}
	
	@Override
	public final void run(){
		setCurrentEditorPart();
		execute(editorPart, viewer.getSelection(), viewPartTargetId);
	}
	
	private static void setCurrentEditorPart(){		
		IWorkbench workbench = PlatformUI.getWorkbench();
		IViewPart part = workbench.getActiveWorkbenchWindow().getActivePage().findView(viewPartTargetId);
		
		if (part instanceof StructuredViewer) {
			StructuredViewer structuredViewer = (StructuredViewer) part;
			
			int operations = DND.DROP_COPY | DND.DROP_MOVE;
            Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
            
            structuredViewer.addDropSupport(operations, transferTypes, new ViewPartDropListener(structuredViewer));
		}		
	}

	public String getViewPartTargetId() {
		return this.viewPartTargetId;
	}

	public void setViewPartTargetId(String viewPartTargetId) {
		this.viewPartTargetId = viewPartTargetId;
	}
}
