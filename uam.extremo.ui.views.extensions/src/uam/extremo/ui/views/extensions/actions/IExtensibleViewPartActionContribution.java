package uam.extremo.ui.views.extensions.actions;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

public interface IExtensibleViewPartActionContribution {
	public void execute(IEditorPart editorInput, ISelection selection, String editorID);
}
