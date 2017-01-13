package uam.extremo.startup;

import org.eclipse.core.resources.ISaveContext;
import org.eclipse.core.resources.ISaveParticipant;
import org.eclipse.core.resources.ISavedState;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import uam.extremo.extensions.AssistantFactory;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements IStartup{

	// The plug-in ID
	public static final String PLUGIN_ID = "uam.extremo.startup"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	@Override
	public void earlyStartup() {
		ISaveParticipant saveParticipant = new ISaveParticipant(){
		      public void saving(ISaveContext context)
		         throws CoreException
		      {
		         context.needDelta();
		      }
		      public void doneSaving(ISaveContext context) {}
		      public void prepareToSave(ISaveContext context)
		         throws CoreException {}
		      public void rollback(ISaveContext context) {}
		   };

		   ISavedState savedState;
		   try {
		      savedState = ResourcesPlugin
		         .getWorkspace()
		         .addSaveParticipant  (
		            Activator.getDefault(),
		            saveParticipant);
		   }
		   catch (CoreException e) {
			   System.out.println(e.getMessage());
		      return;
		   }

		   if (savedState != null)
		      savedState.processResourceChangeEvents(AssistantFactory.getInstance());
	}

}
