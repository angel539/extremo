package uam.extremo.ui.nature.newprojectwizard;

import java.net.URI;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

public class ExtremoNewProjectWizard extends Wizard implements INewWizard, IExecutableExtension {
	private IConfigurationElement _configurationElement;
	private ExtremoNewProjectWizardPage _pageOne;
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		_pageOne = new ExtremoNewProjectWizardPage();
		addPage(_pageOne);
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		_configurationElement = config;
	}

	@Override
	public boolean performFinish() {
		String name = _pageOne.getProjectName();
	    URI location = null;
	 
	    ExtremoProjectSupport.createProject(name, location);
	    BasicNewProjectResourceWizard.updatePerspective(_configurationElement);
	    return true;
	}

}
