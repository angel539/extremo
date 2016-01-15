package metardf.ui.wizards.importers;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

import metardf.ui.Activator;

public class NewFileImportSupportWizardPage extends WizardPage {
	private Text path;
	private Composite container;
	
	public NewFileImportSupportWizardPage(String pageName, String pageDescription) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/folder.png"));
	}

	@Override
	public void createControl(Composite parent) {		
		container = new Composite(parent, SWT.NONE);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    layout.numColumns = 2;
	    
	    Button folderDialog = new Button(container, SWT.PUSH);
	    folderDialog.setText("File");
	    folderDialog.addSelectionListener(new SelectionAdapter() {
	    	  @Override
	    	  public void widgetSelected(SelectionEvent e) {
	    		  FileDialog pathSelection = new FileDialog(getShell());
	    		  String pathString = pathSelection.open();
	    		  System.out.println(pathString);
	    		  path.setText(pathString);
	    	  }
	    	}); 


	    path = new Text(container, SWT.BORDER | SWT.SINGLE);
	    path.setText("");
	    path.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  if ((!path.getText().isEmpty())) {
			          setPageComplete(true);
			        }
		      }
	    });

	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    path.setLayoutData(gd);
	    setControl(container);
	    setPageComplete(true);
	}
	
	 public String getFilePath() {
		 return path.getText();
	 }
}
