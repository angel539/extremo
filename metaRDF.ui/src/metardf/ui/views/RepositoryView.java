package metardf.ui.views;

import java.util.ArrayList;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;

import metaRDF.core.model.Resource;
import metaRDF.core.model.Repository;
import metaRDF.core.repository.MetaRDFRepositoryManager;
import metardf.ui.Activator;
import metardf.ui.wizards.EditResourceWizardDialog;
import metardf.ui.wizards.NewRepositoryWizardDialog;
import metardf.ui.wizards.NewResourceWizardDialog;

import org.eclipse.jface.viewers.*;
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

	private TreeViewer viewer;
	private Action addRepository;
	private Action createResource;
	private Action doubleClickAction;
	private TreeParent invisibleRoot;
	
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
		Resource resource;

		public ResourceObject(Resource resource) {
			super(resource.getName() + " (" + resource.getURI() + ")");
			this.resource = resource;
		}
		
		public Resource getResource() {
			return resource;
		}

		public void setResource(Resource resource) {
			this.resource = resource;
		}
		
		public boolean isAlive(){
			return this.resource.isAlive();
		}
		
		public void changed(){
			setName(resource.getName() + " (" + resource.getURI() + ")");
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
		Repository repository;
		
		public RepositoryParent(Repository repository) {
			super(repository.getName());
			this.repository = repository;
		}	
		
		public void drawResources(){		
			for(Resource resource : repository.getResources()){
				ResourceObject object = new ResourceObject(resource);
				if(!object.getResource().isAlive()) showMessage("Resource + " + object.getName() + " seems not to be at your disposal");
				this.addChild(object);
			}
		}
		
		public void redrawResources(){
			for(TreeObject child : this.getChildren()){
				this.removeChild(child);
			}
			
			for(Resource resource : repository.getResources()){
				ResourceObject object = new ResourceObject(resource);
				if(!object.getResource().isAlive()) showMessage("Resource + " + object.getName() + " seems not to be at your disposal");
				this.addChild(object);
			}
		}
		
		public Repository getRepository() {
			return repository;
		}

		public void setRepository(Repository repository) {
			this.repository = repository;
		}
	}
	
	/*class ViewContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			
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
	}*/
	
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
	
	/*class TableLabelProvider implements ITableLabelProvider{

		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			switch (columnIndex){
	            case 0:
	            	if(element instanceof RepositoryParent) return Activator.getImageDescriptor("icons/folder-icon_16.png").createImage();
	            	if(element instanceof ResourceObject) return Activator.getImageDescriptor("icons/3d_objects_16.png").createImage();
	        }
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex){
	            case 0:
	            	if(element instanceof RepositoryParent) return ((RepositoryParent) element).getRepository().getName();
	            	if(element instanceof ResourceObject) return ((ResourceObject) element).getResource().getName();
	            case 1:
	            	if(element instanceof RepositoryParent) return ((RepositoryParent) element).getRepository().getDescription();
	            	if(element instanceof ResourceObject) return ((ResourceObject) element).getResource().getDescription();
	            case 2: 
	            	if(element instanceof RepositoryParent) return ((RepositoryParent) element).getRepository().getURI();
	            	if(element instanceof ResourceObject) return ((ResourceObject) element).getResource().getURI();
			}
			return null;
		}
	}*/
	
	class NameSorter extends ViewerSorter {
	}

	public RepositoryView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {		
		//invisibleRoot = new TreeParent("");
		//Tree repositoryTree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		//repositoryTree.setHeaderVisible(true);
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		/*viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		Tree repositoryTree = viewer.getTree();
		repositoryTree.setHeaderVisible(true);
		
		TreeColumn nameColumn = new TreeColumn(repositoryTree, SWT.LEFT);
		nameColumn.setText("Name");
		nameColumn.setWidth(200);
		TreeColumn descriptionColumn = new TreeColumn(repositoryTree, SWT.LEFT);
		descriptionColumn.setText("Description");
		descriptionColumn.setWidth(400);
		TreeColumn pathColumn = new TreeColumn(repositoryTree, SWT.LEFT);
		pathColumn.setText("Path");
		pathColumn.setWidth(800);*/
		
		
		new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		

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
					
					for(Repository repository : MetaRDFRepositoryManager.getInstance().getRepositories()){
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
		
		addRepository.setText("Add Repository");
		addRepository.setToolTipText("");
		addRepository.setImageDescriptor(Activator.getImageDescriptor("icons/newfolder_wiz.gif"));
		
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
