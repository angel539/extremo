package uam.extremo.extensions;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;

import uam.extremo.extensions.console.ExtremoConsole;

public class ExtremoConsoleFactory implements IConsoleFactory {
	@Override
	public void openConsole() {
		IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
		ExtremoConsole console = new ExtremoConsole();
		consoleManager.addConsoles( new IConsole[] {console});
		consoleManager.showConsoleView( console );
	}
}
