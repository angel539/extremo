package uam.extremo.ui.views.extensions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public abstract class ExtremoViewPartAction extends Action implements IExtremoViewPartActionContribution{
	private Viewer viewer;
	private static IEditorPart editorPart;
	private String editorID;
	
	public ExtremoViewPartAction(){}
	
	@Override
	public final void run(){
		setCurrentEditorPart();
		execute(editorPart, viewer.getSelection(), editorID);
	}

	public Viewer getViewer() {
		return viewer;
	}

	public void setViewer(Viewer viewer) {
		this.viewer = viewer;
	}
	
	private static void setCurrentEditorPart(){
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = 
		        workbench == null ? null : workbench.getActiveWorkbenchWindow();
		IWorkbenchPage activePage = 
		        window == null ? null : window.getActivePage();
		
		editorPart = 
		        activePage == null ? null : activePage.getActiveEditor();
	}

	public String getEditorID() {
		return editorID;
	}

	public void setEditorID(String editorID) {
		this.editorID = editorID;
	}
}
