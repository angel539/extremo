package metardf.ui.wizards.semanticselector;

import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metardf.ui.Activator;
import metardf.ui.views.entities.model.EntityParentGroup;

public class EntityGroupSelectorDNDWizardPage extends WizardPage{	
	EntityParentGroup entityParentGroup;
	//Composite container;
	
	Composite containerArea;
	Composite containerDownArea;
	
	DragPropertiesView dragPropertiesView;
    DropPropertiesView dropPropertiesView;
    
    DragPropertiesView dragReferencesView;
    DropPropertiesView dropReferencesView;
	
	class DragPropertiesView extends TreeViewer{
		public DragPropertiesView(Composite parent) {
			super(parent);
			
			//int operations = DND.DROP_COPY| DND.DROP_MOVE;
			//Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
			//addDragSupport(operations, transferTypes , new MetaModelElementDragListener(this));
			
			//setContentProvider(new TreeContentProvider());
			//setLabelProvider(new DelegatingStyledCellLabelProvider(new EntityTreeViewLabelProvider()));
			//setInput(metamodel);
			//refresh(metamodel);
			//expandAll();
		}
	}
	
	class DropPropertiesView extends TreeViewer{
		public DropPropertiesView(Composite parent) {
			super(parent);
		}

		/*private List<DataPropertyObject> drawPropertiesRecursiveHelper(TreeObject root) {
			List<DataPropertyObject> properties = new ArrayList<DataPropertyObject>();
			if(root == null) return null;
			
			if(root instanceof DataPropertyObject){
				properties.add((DataPropertyObject) root);
			}
			
			if(root instanceof TreeParent){
				for(TreeObject child : ((TreeParent) root).getChildren()){
					properties.addAll(drawPropertiesRecursiveHelper(child));
				}
			}
			
			return properties;
		}*/
	}
	
	protected EntityGroupSelectorDNDWizardPage(String pageName, String pageDescription, EntityParentGroup entityParentGroup) {
		super(pageName);
		setTitle(pageName);
		setDescription(pageDescription);
		setImageDescriptor(Activator.getImageDescriptor("icons/Crop-48.png"));
		this.entityParentGroup = entityParentGroup;
	}

	@Override
	public void createControl(Composite parent) {
		//container = new Composite(parent, SWT.NONE);
		containerArea = new Composite(parent, SWT.NONE);
	    
		
		//FillLayout container = new FillLayout(SWT.HORIZONTAL);
		//container.marginHeight = 0;
		//container.marginWidth = 0;
		GridLayout layout = new GridLayout(SWT.HORIZONTAL, false);
		layout.numColumns = 2;
		layout.makeColumnsEqualWidth = true;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		containerArea.setLayout(layout);
		
	    dragPropertiesView = new DragPropertiesView(containerArea);
	    dropPropertiesView = new DropPropertiesView(containerArea);
	    
	    
	    dragReferencesView = new DragPropertiesView(containerArea);
	    dropReferencesView = new DropPropertiesView(containerArea);
	    /*FillLayout containerBottom = new FillLayout(SWT.HORIZONTAL);
		containerBottom.marginHeight = 5;
		containerBottom.marginWidth = 0;
		containerArea.setLayout(container);*/
		
	    
	    //dragReferencesView = new DragPropertiesView(containerArea);
	    //dropReferencesView = new DropPropertiesView(containerArea);
	    
	    containerArea.moveAbove(null);
		setControl(containerArea);
	}

	public List<IDataProperty> getPropertiesSelected() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IObjectProperty> getReferencesSelected() {
		// TODO Auto-generated method stub
		return null;
	}
}
