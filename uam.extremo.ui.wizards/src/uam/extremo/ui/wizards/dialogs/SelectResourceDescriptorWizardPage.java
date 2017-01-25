package uam.extremo.ui.wizards.dialogs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import uam.extremo.extensions.AssistantFactory;
import uam.extremo.extensions.FormatAssistant;
import uam.extremo.extensions.IFormatAssistant;
import uam.extremo.ui.wizards.*;

public class SelectResourceDescriptorWizardPage extends WizardPage {
	private Composite container;
	private Table table = null;
	private TableItem[] tableItems = null;
	
	public SelectResourceDescriptorWizardPage(String pageName, String pageDescription, TableItem[] tableItems) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/folder.png"));
		this.tableItems = tableItems;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    
	    final ScrolledComposite composite = new ScrolledComposite(container, SWT.MULTI | SWT.V_SCROLL);
	    composite.setLayout(layout);
	    composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    
		table = new Table(composite, SWT.CHECK | SWT.FULL_SELECTION | SWT.MULTI);
		composite.setContent(table);
	    composite.setExpandHorizontal(true);
	    composite.setExpandVertical(true);
	    composite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
	    tc1.setText("Name");
	    tc1.setWidth(200);
	    
	    TableColumn tc2 = new TableColumn(table, SWT.LEFT);
	    tc2.setText("Assistant");
	    tc2.setWidth(100);
	    
	    TableColumn tc3 = new TableColumn(table, SWT.LEFT);
	    tc3.setText("Description");
	    tc3.setWidth(200);
	    
	    List<IFormatAssistant> assistancesList = AssistantFactory.getInstance().getAssistances();
	    IFormatAssistant[] assistances = new IFormatAssistant[assistancesList.size()];
	    assistances = assistancesList.toArray(assistances);
	    
	    if(tableItems != null){
	    	for(TableItem item : tableItems){    		
	    		TableItem itemNew = new TableItem(table, SWT.CHECK);
	    		
	    		itemNew.setData("file", item.getData("file"));
	    		itemNew.setData("description", item.getData("description"));
	    		itemNew.setData("assistant", item.getData("assistant"));
	    		
	    		itemNew.setChecked(false);
	    		
	    		String resourceName = ((File)item.getData("file")).getName();
	    		
	    		Text name = new Text(table, SWT.NONE);
	    	    name.setText(resourceName);
	    		
	    		TableEditor editor = new TableEditor(table);
	    		editor.grabHorizontal = true;
	    	    editor.setEditor(name, itemNew, 0);
	    		
	    		editor = new TableEditor(table);

	    	    CCombo comboAssistant = new CCombo(table, SWT.NONE);
	    	    comboAssistant.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
	    	    
    			for(IFormatAssistant assistant : assistances){
    				String nameAssistant = ((FormatAssistant) assistant).getNameExtension();
    				comboAssistant.add(nameAssistant);
    				comboAssistant.setData(nameAssistant, assistant);
    			}
    			
    			
    			String resourceUri = ((File)item.getData("file")).getAbsolutePath();
    			String extensionFile = FilenameUtils.getExtension(resourceUri);
    			
    			loop:
    			for(int i = 0; i < assistances.length; i++){
    				for(String ext : ((FormatAssistant) assistances[i]).getExtensions()){
    					if(extensionFile.compareTo(ext) == 0){
    						comboAssistant.select(i);
    	    				itemNew.setData("assistant", assistances[i]);
    						break loop;
    					}
    				}
    			}
    			
    			ModifyListener listener = new ModifyListener() {
	    		    public void modifyText(ModifyEvent e) {
	    		        CCombo combo = (CCombo) e.widget;
	    		        IFormatAssistant assistantSelected = (IFormatAssistant) combo.getData(combo.getText());
	    		        itemNew.setData("assistant", assistantSelected);
	    		    }
	    		};

	    		comboAssistant.addModifyListener(listener);
    			
    			editor.grabHorizontal = true;
	    	    editor.setEditor(comboAssistant, itemNew, 1);
	    	    
	    	    
	    	    Text description = new Text(table, SWT.NONE);
	    	    description.setText("");
	    	    
	    	    ModifyListener listenerDescription = new ModifyListener() {
	    		    public void modifyText(ModifyEvent e) {
	    		        Text text = (Text) e.widget;
	    		        itemNew.setData("description", text.getText());
	    		    }
	    		};

	    	    description.addModifyListener(listenerDescription);
	    	    
	    	    editor = new TableEditor(table);
	    	    editor.grabHorizontal = true;
	    	    editor.setEditor(description, itemNew, 2);
	    	}			
	    }
	    
	    /*table.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				for(TableItem item : table.getItems()){
					if(!table.getItem(event.index).equals(item)){
						item.setChecked(false);
					}
				}
			}
	    });*/
	    
	    table.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                   for(TableItem item : table.getItems()){
                          if (!Objects.equals(item, event.item)) {//TODO: event.index seems to always return 0, used event.item thus
                                item.setChecked(false);
                          }
                   }
            }
	    });
		
	    table.setSortColumn(tc1);
	    table.setTouchEnabled(true);
    	table.setHeaderVisible(true);
	    
	    setControl(container);
	    setPageComplete(true);
	}
	
	public List<File> getFilesForFolder(final File folder) {
		List<File> files = new ArrayList<File>();
	    
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            files.addAll(getFilesForFolder(fileEntry));
	        } else {
	        	files.add(fileEntry);
	        }
	    }
		
		return files;
	}

	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
