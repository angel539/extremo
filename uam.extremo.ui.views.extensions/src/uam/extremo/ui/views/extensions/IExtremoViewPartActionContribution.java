package uam.extremo.ui.views.extensions;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

public interface IExtremoViewPartActionContribution {
	public void execute(IEditorPart editorInput, ISelection selection, String editorID);
}
