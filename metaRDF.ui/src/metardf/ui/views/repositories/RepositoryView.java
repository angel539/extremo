package metardf.ui.views.repositories;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;

import metaRDF.core.model.IResource;
import metaRDF.core.model.impl.RepositoryManager;
import metaRDF.core.model.IRepository;
import metaRDF.core.model.IRepositoryManager;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.IFormatAssistant;
import metardf.core.extensions.FormatAssistant;
import metardf.ui.Activator;
import metardf.ui.wizards.EditResourceWizardDialog;
import metardf.ui.wizards.NewRepositoryWizardDialog;
import metardf.ui.wizards.NewResourceWizardDialog;
import metardf.ui.wizards.ResourceListWizardDialog;
import metardf.ui.wizards.importers.NewFileExportSupportWizardDialog;
import metardf.ui.wizards.importers.NewFileImportSupportWizardDialog;

import org.eclipse.jface.viewers.*;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.core.runtime.IAdaptable;

public class RepositoryView extends ViewPart {
	public static final String ID = "metardf.ui.views.RepositoryView";

	private CheckboxTreeViewer viewer;
	private Action addRepository;
	private Action createResource;
	private Action doubleClickAction;
	private TreeParent invisibleRoot;
	
	private Action importRepositories;
	private Action exportRepositories;
	private Action addFolder;
	
	class AssistantEditingSupport extends EditingSupport {
		private TreeViewer viewer;
		private ComboBoxViewerCellEditor editor;
		  
		public AssistantEditingSupport(TreeViewer viewer) {
			super(viewer);
			this.viewer = viewer;
			
			this.editor = new ComboBoxViewerCellEditor(viewer.getTree());
			this.editor.setContentProvider(new ArrayContentProvider());
			this.editor.setLabelProvider(new ViewLabelProvider());
			List<String> strings = new ArrayList<String>();
			for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
				String name = ((FormatAssistant)assistant).getNameExtension();
				strings.add(name);
			}
			
			this.editor.setInput(strings.toArray());
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return editor;
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected Object getValue(Object element) {
			if(element instanceof ResourceObject){
				return ((ResourceObject) element).getName();
			}
			return null;
		}

		@Override
		protected void setValue(Object element, Object value) {
			if(element instanceof ResourceObject){
				((ResourceObject) element).getResource().setAssistant(String.valueOf(value));
			    viewer.update(element, null);
			}
			
			if(element instanceof RepositoryParent){
				for(IResource resource : ((RepositoryParent) element).getRepository().getResources()){
					resource.setAssistant(String.valueOf(value));
				}
			    viewer.update(element, null);
			}
		}
	}
	
	class TreeObject implements IAdaptable {
		private String name;
		private TreeParent parent;
		
		public TreeObject(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}
		public TreeParent getParent() {
			return parent;
		}
		public String toString() {
			return getName();
		}
		public <T> T getAdapter(Class<T> key) {
			return null;
		}
	}
	
	class ResourceObject extends TreeObject{
		IResource resource;

		public ResourceObject(IResource resource) {
			super(resource.getName());
			this.resource = resource;
		}
		
		public IResource getResource() {
			return resource;
		}

		public void setResource(IResource resource) {
			this.resource = resource;
		}
		
		public boolean isAlive(){
			return this.resource.isAlive();
		}
		
		public void changed(){
			setName(resource.getName());
		}
	}
	
	class TreeParent extends TreeObject {
		private ArrayList<TreeObject> children;
		public TreeParent(String name) {
			super(name);
			children = new ArrayList<TreeObject>();
		}
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}
		public TreeObject [] getChildren() {
			return (TreeObject [])children.toArray(new TreeObject[children.size()]);
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
	}

	class RepositoryParent extends TreeParent{
		IRepository repository;
		
		public RepositoryParent(IRepository repository) {
			super(repository.getName());
			this.repository = repository;
		}	
		
		public void drawResources(){		
			for(IResource resource : repository.getResources()){
				ResourceObject object = new ResourceObject(resource);
				if(!object.getResource().isAlive()) showMessage("Resource + " + object.getName() + " seems not to be at your disposal");
				this.addChild(object);
			}
		}
		
		public void redrawResources(){
			for(TreeObject child : this.getChildren()){
				this.removeChild(child);
			}
			
			for(IResource resource : repository.getResources()){
				ResourceObject object = new ResourceObject(resource);
				if(!object.getResource().isAlive()) showMessage("Resource + " + object.getName() + " seems not to be at your disposal");
				this.addChild(object);
			}
		}
		
		public IRepository getRepository() {
			return repository;
		}

		public void setRepository(IRepository repository) {
			this.repository = repository;
		}
	}
	
	class ViewContentProvider implements IStructuredContentProvider,  ITreeContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot==null){
					initialize();
				}
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			if (child instanceof ResourceObject) {
				return ((ResourceObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			if (parent instanceof RepositoryParent) {
				return ((RepositoryParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			if (parent instanceof RepositoryParent)
				return ((RepositoryParent)parent).hasChildren();
			return false;
		}
		
		private void initialize() {
			invisibleRoot = new TreeParent("");
		}
	}
	
	class ViewLabelProvider extends LabelProvider {
		public String getText(Object obj) {
			return obj.toString();
		}
	}

	class ColumnOneViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if (element instanceof RepositoryParent) {
				RepositoryParent repositoryNode = (RepositoryParent) element;
				StyledString styledString = new StyledString(repositoryNode.getName());
				
				if (repositoryNode.getChildren() != null) {
					styledString.append(" (" + repositoryNode.getChildren().length + ") ", StyledString.COUNTER_STYLER);
				}
				return styledString;
			}
			
			if (element instanceof ResourceObject) {
				StyledString styledString = new StyledString(((ResourceObject) element).getName());
				return styledString;
			}
			
			return null;
		}
		
		@Override
		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			
			if(obj instanceof RepositoryParent) return Activator.getImageDescriptor("icons/folder-icon_16.png").createImage();
        	if(obj instanceof ResourceObject){
        		if(((ResourceObject) obj).isAlive()) return Activator.getImageDescriptor("icons/3d_objects_16.png").createImage();
        		else{
        			return Activator.getImageDescriptor("icons/3d_objects_off_16.png").createImage();
        		}
        	}
        	
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	
	class ColumnTwoViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if (element instanceof ResourceObject) {
				ResourceObject resourceObject = (ResourceObject) element;
				if(resourceObject.getResource().getAssistant() != null) return new StyledString(resourceObject.getResource().getAssistant());
				else new StyledString("");
			}
			
			return new StyledString("");
		}
	}
	
	class ColumnThreeViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if (element instanceof RepositoryParent) {
				RepositoryParent repositoryNode = (RepositoryParent) element;
				StyledString styledString = new StyledString(repositoryNode.getRepository().getUri());
				return styledString;
			}
			
			if (element instanceof ResourceObject) {
				ResourceObject resourceObject = (ResourceObject) element;
				StyledString styledString = new StyledString(resourceObject.getResource().getIdToString());
				return styledString;
			}
			
			return null;
		}
	}
	
	class NameSorter extends ViewerSorter {
	}

	public RepositoryView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {		
		viewer = new CheckboxTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
	
		ViewContentProvider provider = new ViewContentProvider();
		new DrillDownAdapter(viewer);
		viewer.setContentProvider(provider);
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		
		/**/
		viewer.getTree().setHeaderVisible(true);
		
		TreeViewerColumn nameColumn = new TreeViewerColumn(viewer, SWT.NONE);
		nameColumn.getColumn().setText("Name");
		nameColumn.getColumn().setWidth(300);
		nameColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnOneViewLabelProvider()));
		
		TreeViewerColumn assistedByColumn = new TreeViewerColumn(viewer, SWT.NONE);
		assistedByColumn.getColumn().setText("Assistant");
		assistedByColumn.getColumn().setWidth(100);
		assistedByColumn.getColumn().setAlignment(SWT.LEFT);
		assistedByColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnTwoViewLabelProvider()));
		assistedByColumn.setEditingSupport(new AssistantEditingSupport(viewer));
		
		TreeViewerColumn uriColumn = new TreeViewerColumn(viewer, SWT.NONE);
		uriColumn.getColumn().setText("Uri");
		uriColumn.getColumn().setWidth(400);
		uriColumn.getColumn().setAlignment(SWT.LEFT);
		uriColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnThreeViewLabelProvider()));
		
		//final Map<TreeObject, Boolean> checks = new HashMap<>();
		viewer.addCheckStateListener(new ICheckStateListener() {
	        @Override
	        public void checkStateChanged(CheckStateChangedEvent event) {
	        	if(event.getElement() instanceof ResourceObject){
					((ResourceObject) event.getElement()).getResource().setActive(event.getChecked());
					viewer.update(event.getElement(), null);
	        	}
				
				if(event.getElement() instanceof RepositoryParent){
		            for (Object child : provider.getChildren(event.getElement())) {
		            	viewer.setChecked(child, event.getChecked());
		            }
					
					for(IResource resource : ((RepositoryParent) event.getElement()).getRepository().getResources()){
						resource.setActive(event.getChecked());
					}
					
				    viewer.update(event.getElement(), null);
				    
				    //System.out.println("por el checked RepositoryParent..." + event.getElement() + event.getChecked());
				}
	        	//System.out.println("por el checked..." + event.getElement() + event.getChecked());
	        }
	    });
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "metaRDF.ui.viewer");
		getSite().setSelectionProvider(viewer);
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();		
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				RepositoryView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(addRepository);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(createResource);
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(addRepository);
		manager.add(importRepositories);
		manager.add(exportRepositories);
		manager.add(addFolder);
	}

	private void makeActions() {
		addRepository = new Action() {
			public void run() {
				WizardDialog wizardDialog = new WizardDialog(null, new NewRepositoryWizardDialog());
				if (wizardDialog.open() == Window.OK) {
					if(invisibleRoot.hasChildren()){
						for(TreeObject treeobject : invisibleRoot.getChildren()){
							invisibleRoot.removeChild(treeobject);
						}
					}
					//System.out.println("en repository " + MetaRDFRepositoryManager.getInstance());
					Class<? extends IRepositoryManager> c;
					try {
						c = Class.forName("metardf.core").asSubclass(IRepositoryManager.class);
						IRepositoryManager repositoryManager = c.newInstance();
						List<IRepository> repositories = repositoryManager.getRepositories();
						
						for(IRepository repository : repositories){
							RepositoryParent repositoryParent = new RepositoryParent(repository);
							repositoryParent.drawResources();
							invisibleRoot.addChild(repositoryParent);
						}
						viewer.refresh();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
					
				}
				else{
				}
			}
		};
		
		addRepository.setText("Add Repository");
		addRepository.setToolTipText("");
		addRepository.setImageDescriptor(Activator.getImageDescriptor("icons/newfolder_wiz.gif"));
		
		importRepositories = new Action() {
			public void run() {
				WizardDialog wizardDialog = new WizardDialog(null, new NewFileImportSupportWizardDialog());
				if (wizardDialog.open() == Window.OK) {
					if(invisibleRoot.hasChildren()){
						for(TreeObject treeobject : invisibleRoot.getChildren()){
							invisibleRoot.removeChild(treeobject);
						}
					}
					
					List<IRepository> repositories = RepositoryManager.getInstance().getRepositories();
						
					for(IRepository repository : repositories){
						RepositoryParent repositoryParent = new RepositoryParent(repository);
						repositoryParent.drawResources();
						invisibleRoot.addChild(repositoryParent);
					}
					viewer.refresh();	
				}
				else{
				}
			}
		};
		
		importRepositories.setText("Import Repositories");
		importRepositories.setToolTipText("");
		importRepositories.setImageDescriptor(Activator.getImageDescriptor("icons/import_wiz.gif"));
		
		exportRepositories = new Action() {
			public void run() {
				WizardDialog wizardDialog = new WizardDialog(null, new NewFileExportSupportWizardDialog());
				wizardDialog.open();
			}
		};
		
		exportRepositories.setText("Export Repositories");
		exportRepositories.setToolTipText("");
		exportRepositories.setImageDescriptor(Activator.getImageDescriptor("icons/export_wiz.gif"));
		
		addFolder = new Action() {
			public void run() {
				WizardDialog wizardDialog = new WizardDialog(null, new ResourceListWizardDialog());
				if (wizardDialog.open() == Window.OK) {
					if(invisibleRoot.hasChildren()){
						for(TreeObject treeobject : invisibleRoot.getChildren()){
							invisibleRoot.removeChild(treeobject);
						}
					}
					
					List<IRepository> repositories = RepositoryManager.getInstance().getRepositories();
						
					for(IRepository repository : repositories){
						RepositoryParent repositoryParent = new RepositoryParent(repository);
						repositoryParent.drawResources();
						invisibleRoot.addChild(repositoryParent);
					}
					viewer.refresh();
				}
				else{
				}
			}
		};
		
		addFolder.setText("Add Folder");
		addFolder.setToolTipText("");
		addFolder.setImageDescriptor(Activator.getImageDescriptor("icons/package.gif"));
		
		createResource = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				
				for(Object obj : ((IStructuredSelection)selection).toArray()){
					if(obj instanceof RepositoryParent){
						WizardDialog wizardDialog = new WizardDialog(null, new NewResourceWizardDialog(((RepositoryParent) obj).getRepository()));
						if (wizardDialog.open() == Window.OK) {
							((RepositoryParent) obj).redrawResources();
							viewer.refresh();
						}
					}
				}	
			}
		};
		
		createResource.setText("Add Resource");
		createResource.setImageDescriptor(Activator.getImageDescriptor("icons/3d_objects_16.png"));
		
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				
				if(obj instanceof ResourceObject){
					WizardDialog wizardDialog = new WizardDialog(null, new EditResourceWizardDialog(((ResourceObject) obj).getResource()));
					if (wizardDialog.open() == Window.OK) {
						((ResourceObject) obj).changed();
						viewer.refresh();
					}
				}
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(), "Repositories", message);
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
