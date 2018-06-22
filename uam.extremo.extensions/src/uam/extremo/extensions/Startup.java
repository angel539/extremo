package uam.extremo.extensions;

import org.eclipse.ui.IStartup;

public class Startup implements IStartup {
	@Override
	public void earlyStartup() {
		AssistantFactory.getInstance();
	}
}
