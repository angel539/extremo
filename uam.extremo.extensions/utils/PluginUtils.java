package metaRDF.core.utils;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class PluginUtils {
	public static final String PLUGIN_ID = "metaRDF.core";
	
	public PluginUtils() {
	}

	public static String getPluginPath(String path) {
		if(path != null){
			Bundle bundle = Platform.getBundle(PLUGIN_ID);
			if(bundle == null) return null;
			
			IPath ipath  = new Path(path);
			URL url = FileLocator.find(bundle, ipath, null);
			return url.getPath();
		}
		
		return null;
	}
}
