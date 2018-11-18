package uam.extremo.extensions;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.part.IPageBookViewPage;
import org.osgi.framework.Bundle;

import uam.extremo.extensions.internal.Activator;

public class ExtremoConsole implements IConsole {
	public static final String CONSOLE_ID = "extremo.core.console";
	
	@Override
	public String getName() {
		return CONSOLE_ID;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		if(bundle == null) return null;
		
		IPath ipath  = new Path("icons/Console-16.png");
		URL url = FileLocator.find(bundle, ipath, null);
		ImageDescriptor descriptor = ImageDescriptor.createFromURL(url);
		return descriptor;
	}

	@Override
	public IPageBookViewPage createPage(IConsoleView view) {
		return null;
	}

	@Override
	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
