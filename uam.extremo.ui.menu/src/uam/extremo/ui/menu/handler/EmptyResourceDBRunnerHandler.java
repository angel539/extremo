 package uam.extremo.ui.menu.handler;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Status;

import uam.extremo.extensions.AssistantFactory;

public class EmptyResourceDBRunnerHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		AssistantFactory.getInstance().emptyResourceDb();
		return Status.OK_STATUS;
	}
}
