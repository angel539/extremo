package uam.extremo.ui.wizards.dialogs.searchnew.dnd;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import semanticmanager.*;
import semanticmanager.provider.SemanticmanagerItemProviderAdapterFactory;
import uam.extremo.ui.wizards.Activator;

public class DropMetaModelElementTableTreeViewer extends TreeViewer{
	List<NamedElement> elements = new ArrayList<NamedElement>();
	IStructuredSelection selection = null;
	List<Resource> resources = null;
	
	protected ComposedAdapterFactory adapterFactory;
	List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
	
	public void add(NamedElement element) {
		elements.add((NamedElement)element);

		Job job = new Job("Dropping element") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
            	Display.getDefault().asyncExec(new Runnable() {
                    public void run() {
                    	setInput(elements);
                    	refresh();
                    }
        		});
            	
                syncWithUi();
                return Status.OK_STATUS;
            }
	    };
	    job.setUser(true);
	    job.schedule();
	}
	
	private void syncWithUi() {
        try {
        	Thread.sleep(10);
        } catch (InterruptedException e) {
			MessageDialog.openError(null, "Dropping elements", e.getMessage());
        }
	}
	
	public DropMetaModelElementTableTreeViewer(Composite parent, List<NamedElement> namedElements) {	
		super(parent);
		int operations = DND.DROP_COPY | DND.DROP_MOVE;
		
		Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
	    addDropSupport(operations, transferTypes, new NamedElementDropListener(this, namedElements));
	    
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new SemanticmanagerItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		
		adapterFactory = new ComposedAdapterFactory(factories);
	    
	    setContentProvider(ArrayContentProvider.getInstance());
		setLabelProvider(new DelegatingStyledCellLabelProvider(new DragMetamodelElementViewerAdapterFactoryLabelProvider(adapterFactory)));

	    TreeViewFilter filter = new TreeViewFilter();
		ViewerFilter[] filters = {filter};
		setFilters(filters);
	}
	
	class ColumnOneViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			if (element instanceof Resource) {
				StyledString styledString = new StyledString(((Resource) element).getName());
				
				Resource resource = (Resource) element; 
				if((resource.getDescriptors() == null) || (resource.getDescriptors().isEmpty())){
					styledString.append(" describes (" + ((Resource) element).getDescribes().size() + ")", StyledString.COUNTER_STYLER);
				}
				
				return styledString;
			}
			
			if(element instanceof SemanticNode){
				SemanticNode semanticNode = (SemanticNode) element;
				
				if((semanticNode.getDescriptors() == null) || (semanticNode.getDescriptors().isEmpty())){
					StyledString styledString = new StyledString(semanticNode.getName());
					
					if(semanticNode.getDescribes().size() > 0)
						styledString.append(" describes (" + semanticNode.getDescribes().size() + ")", StyledString.COUNTER_STYLER);
					return styledString;
				}
				else{
					StyledString styledString = new StyledString(semanticNode.getName());
					
					for(NamedElement namedElement : semanticNode.getDescriptors())
						styledString.append(" :" + namedElement.getName(), StyledString.COUNTER_STYLER);
					return styledString;
				}
	    	}
			
			if(element instanceof DataProperty){
				DataProperty dataProperty = (DataProperty) element;
				
				if((dataProperty.getDescriptors() == null) || (dataProperty.getDescriptors().isEmpty())){
					StyledString styledString = new StyledString(dataProperty.getName());
					if(dataProperty.getType() != null) styledString.append(": " + dataProperty.getType().getLiteral(), StyledString.COUNTER_STYLER);
					return styledString;
				}
				else{
					StyledString styledString = new StyledString(dataProperty.getValue());
					
					for(NamedElement namedElement : dataProperty.getDescriptors())
						styledString.append(" :" + namedElement.getName(), StyledString.COUNTER_STYLER);
					
					return styledString;
				}
			}
			
			if(element instanceof ObjectProperty){
				ObjectProperty objectProperty = (ObjectProperty) element;
				
				if((objectProperty.getDescriptors() == null) || (objectProperty.getDescriptors().isEmpty())){
					StyledString styledString = new StyledString(objectProperty.getName());
					if(objectProperty.getRange() != null) styledString.append(" ->" + objectProperty.getRange().getName(), StyledString.COUNTER_STYLER);		
					return styledString;
				}
				else{
					StyledString styledString = new StyledString(objectProperty.getName());
					
					for(NamedElement namedElement : objectProperty.getDescriptors())
						styledString.append(" :" + namedElement.getName(), StyledString.COUNTER_STYLER);
					
					return styledString;
				}
			}
			
			return null;
		}
		
		@Override
		public Image getImage(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			
			if(element instanceof Resource){
				Resource resource = (Resource) element;
				if((resource.getDescriptors() == null) || (resource.getDescriptors().isEmpty())){
					return Activator.getImageDescriptor("icons/descriptor.png").createImage();
				}
				else{
					if(((Resource) element).isAlive()) return Activator.getImageDescriptor("icons/description_on.png").createImage();
	        		else{
	        			return Activator.getImageDescriptor("icons/description.png").createImage();
	        		}
				}
	    	}
			
			if(element instanceof SemanticNode){
				SemanticNode semanticNode = (SemanticNode) element;
				if((semanticNode.getDescriptors() == null) || (semanticNode.getDescriptors().isEmpty())){
					return Activator.getImageDescriptor("icons/class_obj.png").createImage();
				}
				else{
	        		return Activator.getImageDescriptor("icons/object.png").createImage();
				}
	    	}

			if(element instanceof ObjectProperty) return Activator.getImageDescriptor("icons/det_pane_right.gif").createImage();
			if(element instanceof DataProperty) return Activator.getImageDescriptor("icons/attribute.png").createImage();
        	
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	
	public List<NamedElement> getSelectedElements(){
		if(elements.isEmpty()) return null;
		return this.elements;
	}
}
