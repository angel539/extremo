package uam.extremo.ui.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class ExtremoProjectNature implements IProjectNature{
	public static final String NATURE_ID = "uam.extremo.ui.nature.extremonature";
	
	private IProject project;

	@Override
	public void configure() throws CoreException {
		// TODO Configure method in nature?
		
	}

	@Override
	public void deconfigure() throws CoreException {
		// TODO Deconfigure method in nature?
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

}
