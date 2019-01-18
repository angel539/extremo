package uam.extremo.ui.wizards.newproject;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import uam.extremo.ui.Activator;

public class ExtremoNewProjectWizardPage extends WizardPage {
	private Text folderText;

	public ExtremoNewProjectWizardPage() {
		super("wizardPage");
		setTitle("New Project");
		setDescription("This wizard creates a new project with the Extremo nature");
		setImageDescriptor(Activator.getImageDescriptor("icons/extremoIcon_margin.png"));
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		
		Label label = new Label(container, SWT.NULL);
		label.setText("&Project name:");

		folderText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		folderText.setLayoutData(gd);
		
		setControl(container);
		setPageComplete(true);
	}

	public String getProjectName() {
		return folderText.getText();
	}
}
