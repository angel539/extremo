package metardf.ui.wizards;

import java.io.File;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import metaRDF.core.model.IResource;
import metardf.ui.Activator;

public class NewResourceWizardPage extends WizardPage {
	private Text name;
	private Text description;
	private Text uri;
	private Composite container;
	private IResource resource = null;
	
	public NewResourceWizardPage(String pageName, String pageDescription) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/entities.png"));
	}
	
	public NewResourceWizardPage(String pageName, String pageDescription, IResource resource) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/entities.png"));
		this.resource = resource;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    layout.numColumns = 2;
	    
	    Label nameLabel = new Label(container, SWT.NONE);
	    nameLabel.setText("Name");
	    
	    name = new Text(container, SWT.BORDER | SWT.SINGLE);
	    if(resource != null){
	    	name.setText(resource.getName());
	    }else{
	    	name.setText("");
	    }
	    name.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		        if (!name.getText().isEmpty()) {
		          setPageComplete(true);
		        }
		      }
	    });
	    
	    Label descriptionLabel = new Label(container, SWT.NONE);
	    descriptionLabel.setText("Description");
	    
	    description = new Text(container, SWT.BORDER | SWT.SINGLE);
	    if(resource != null){
	    	if(description != null) description.setText(resource.getDescription());
	    	else description.setText("");
	    }else{
	    	description.setText("");
	    }
	    description.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		        if (!description.getText().isEmpty()) {
		          setPageComplete(true);
		        }
		      }
	    });
	    
	    Label uriLabel = new Label(container, SWT.NONE);
	    uriLabel.setText("URI");

	    uri = new Text(container, SWT.BORDER | SWT.SINGLE);
	    if(resource != null){
	    	uri.setText(resource.getIdToString());
	    }else{
	    	uri.setText("");
	    }
	    uri.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		        if (!uri.getText().isEmpty()) {
		        	if((uri.getText().startsWith("http://"))||(uri.getText().startsWith("https://"))){
		        		setPageComplete(true);
		        	}
		        	else{
		        		File file = new File(uri.getText());
		        		if(file.canRead() && file.isFile()){
		        			setPageComplete(true);
		        		}
		        		else{
		        			setPageComplete(false);
		        			setDescription("The resource must be a file or a valid URL (starting with http...)");
		        		}
		        	}
		        }
		      }
	    });
	    
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    name.setLayoutData(gd);
	    description.setLayoutData(gd);
	    uri.setLayoutData(gd);
	    setControl(container);
	    setPageComplete(false);
	}
	
	public String getResourceName() {
		 return name.getText();
	 }
	
	public String getResourceDescription() {
		 return description.getText();
	 }
	
	 public String getResourceUri() {
		 return uri.getText();
	 }
}
