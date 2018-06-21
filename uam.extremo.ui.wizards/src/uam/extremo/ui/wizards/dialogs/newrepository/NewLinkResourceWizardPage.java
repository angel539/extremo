package uam.extremo.ui.wizards.dialogs.newrepository;

import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import uam.extremo.extensions.FormatAssistant;
import uam.extremo.extensions.IFormatAssistant;
import uam.extremo.ui.wizards.Activator;

public class NewLinkResourceWizardPage extends WizardPage {
	public static final String NATURE_ID = "uam.extremo.ui.nature.extremonature";
	
	private Text name;
	private Text resourceName;
	private Text description;
	private Text path;
	private Composite container;
	private CCombo comboAssistant;
	private List<IFormatAssistant> assistances;
	
	public NewLinkResourceWizardPage(List<IFormatAssistant> assistances, String pageName, String pageDescription) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/link96.png"));
		
		this.assistances = assistances;
	}

	@Override
	public void createControl(Composite parent) {		
	    container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
	    
	    Label nameLabel = new Label(container, SWT.NONE);
	    nameLabel.setText("Repository Name");
	    
	    name = new Text(container, SWT.BORDER | SWT.SINGLE);
	    name.setText("");
	    name.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  if ((!name.getText().isEmpty())) {
			          setPageComplete(true);
			        }
		      }
	    });
	    
	    Label resourceNameLabel = new Label(container, SWT.NONE);
	    resourceNameLabel.setText("Resource Name");
	    
	    resourceName = new Text(container, SWT.BORDER | SWT.SINGLE);
	    resourceName.setText("");
	    resourceName.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  if ((!name.getText().isEmpty())) {
			          setPageComplete(true);
			        }
		      }
	    });
	    
	    Label descriptionLabel = new Label(container, SWT.NONE);
	    descriptionLabel.setText("Description");
	    
	    description = new Text(container, SWT.BORDER | SWT.SINGLE);
	    description.setText("");
	    description.addKeyListener(new KeyListener() {
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		    	  if ((!description.getText().isEmpty())) {
			          setPageComplete(true);
			        }
		      }
	    });
	    
	    Label pathLabel = new Label(container, SWT.NONE);
	    pathLabel.setText("Path");

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
	    
	    Label assistantLabel = new Label(container, SWT.NONE);
	    assistantLabel.setText("Assistant");  
	    
	    comboAssistant = new CCombo(container, SWT.NONE);
	    for (IFormatAssistant assistant : assistances) {
			comboAssistant.add(((FormatAssistant) assistant).getNameExtension());
			comboAssistant.setData(((FormatAssistant) assistant).getNameExtension(), assistant);
		}
	    
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    name.setLayoutData(gd);
	    resourceName.setLayoutData(gd);
	    description.setLayoutData(gd);
	    path.setLayoutData(gd);
	    comboAssistant.setLayoutData(gd);
	    
	    setControl(container);
	    setPageComplete(false);
	}
	
	public String getRepositoryName() {
		 return name.getText();
	 }
	
	public String getResourceName() {
		 return resourceName.getText();
	 }
	
	public String getResourceDescription() {
		 return description.getText();
	 }
	
	 public String getResourceUri() {
		 return path.getText();
	 }
	 
	 public IFormatAssistant getAssistantSelected(){
		 Object object = comboAssistant.getData(comboAssistant.getText());
		 
		 if (object instanceof IFormatAssistant) {
			IFormatAssistant formatAssistant = (IFormatAssistant) object;
			return formatAssistant;
		}
		 
		return null;
	 }
}
