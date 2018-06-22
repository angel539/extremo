package uam.extremo.extensions.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Text;

public class PathSelectorWizardPage extends WizardPage {
	private Text path;
	private Composite container;
	
	public PathSelectorWizardPage(String pageName, String pageDescription) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
	}

	@Override
	public void createControl(Composite parent) {		
		container = new Composite(parent, SWT.NONE);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    layout.numColumns = 2;
	    
	    Button folderDialog = new Button(container, SWT.PUSH);
	    folderDialog.setText("Path");
	    folderDialog.addSelectionListener(new SelectionAdapter() {
	    	  @Override
	    	  public void widgetSelected(SelectionEvent e) {
	    		  DirectoryDialog pathSelection = new DirectoryDialog(getShell());
	    		  String pathString = pathSelection.open();
	    		  path.setText(pathString);
	    	  }
	    	}); 


	    path = new Text(container, SWT.BORDER | SWT.SINGLE);
	    path.setText("");
	    
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    path.setLayoutData(gd);
	    setControl(container);
	    setPageComplete(true);
	}
	
	 public String getPath() {
		 return path.getText();
	 }
}
