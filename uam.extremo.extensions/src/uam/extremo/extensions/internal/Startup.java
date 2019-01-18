package uam.extremo.extensions.internal;

import org.eclipse.ui.IStartup;

import uam.extremo.extensions.AssistantManager;

public class Startup implements IStartup {
	@Override
	public void earlyStartup() {
		AssistantManager.getInstance();
	}
}
