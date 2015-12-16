package metardf.ui.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
//import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import metaRDF.core.model.DataProperty;
import metaRDF.core.model.ObjectProperty;
import metaRDF.core.model.Property;
import metaRDF.core.model.Repository;
import metaRDF.core.model.Resource;
import metaRDF.core.model.SemanticClass;
import metaRDF.core.owl.OwlAssistant;
import metaRDF.core.repository.MetaRDFRepositoryManager;
import metardf.ui.Activator;
import metardf.ui.extensions.ResourceViewAction;

public class EntityView extends ViewPart {
	public static final String ID = "metardf.ui.views.EntityView";
	private List<String> entities = new ArrayList<String>();

	private TreeViewer viewer;

	//private Action searchEntityAction;
	private Action expandAction;
	//private Action defineAction;
	
	private TreeParent invisibleRoot;
	
	class TreeObject implements IAdaptable {
		private String name;
		private TreeParent parent;
		
		public TreeObject(Object object) {
			if(object instanceof DataProperty){
				if(((DataProperty) object).isFromSuper()){
					if(((DataProperty) object).getRange() == null) this.name = ((Property) object).getName() + " (super)";
					else this.name = ((Property) object).getName() + " : " + ((DataProperty) object).getRange().toString() + " (super)";
				}
				else{
					this.name = ((Property) object).getName();
				}	
			}else{
				if(object instanceof ObjectProperty){
					if(((ObjectProperty) object).isFromSuper()){
						this.name = ((Property) object).getName() + " : " + ((ObjectProperty) object).getRanges() + " (super)";
					}
					else{
						this.name = ((Property) object).getName() + " : " + ((ObjectProperty) object).getRanges();
					}	
				}
				else{
					this.name = object.toString();
				}
			}		
		}
		
		public String getName() {
			return name;
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
	
	class FolderParent extends TreeParent{
		public FolderParent(String name) {
			super(name);
		}	
	}
	
	class EntityParent extends TreeParent{
		SemanticClass semanticclass;
		
		public SemanticClass getSemanticclass() {
			return semanticclass;
		}

		public void setSemanticclass(SemanticClass semanticclass) {
			this.semanticclass = semanticclass;
		}

		public EntityParent(SemanticClass semanticclass) {
			super(semanticclass.getName());
			this.semanticclass = semanticclass;
		}
		
		public void drawSuperClasses(){
			FolderParent supersChild = new FolderParent("supers"  + " (" + semanticclass.getSuperclasses().size() + ")");
			
			for(SemanticClass superClass : semanticclass.getSuperclasses()){
				EntityParent entitySuper;
				if((superClass.getLabel()==null)||(superClass.getLabel().compareTo("")==0)) entitySuper = new EntityParent(superClass);
				else entitySuper = new EntityParent(superClass);
				supersChild.addChild(entitySuper);
			}
			
			this.addChild(supersChild);
		}
		public void drawSubclasses(){
			FolderParent subsChild = new FolderParent("subs"  + " (" + semanticclass.getSubclasses().size() + ")");
			
			for(SemanticClass subClass : semanticclass.getSubclasses()){
				EntityParent entitySuper;
				if((subClass.getLabel()==null)||(subClass.getLabel().compareTo("")==0)) entitySuper = new EntityParent(subClass);
				else entitySuper = new EntityParent(subClass);
				subsChild.addChild(entitySuper);
			}
			
			this.addChild(subsChild);
		}
		public void drawReferences(){
			FolderParent referencesChild = new FolderParent("references" + " (" + semanticclass.getReferences().size() + ")");
			
			for(ObjectProperty reference : semanticclass.getReferences()){
				String name = "";
				
				if(reference.isFromSuper()) name = reference.getName();
				else name = reference.getName() + " (super)";
				
				PropertyParent entitySuper = new PropertyParent(name, reference.getURI(), reference.isFromSuper());
				referencesChild.addChild(entitySuper);
			}
			
			this.addChild(referencesChild);
		}
		public void drawProperties(){
			FolderParent referencesChild = new FolderParent("attributes" + " (" + semanticclass.getProperties().size() + ")");
			
			for(DataProperty attribute : semanticclass.getProperties()){
				TreeObject entitySuper = new TreeObject(attribute);
				referencesChild.addChild(entitySuper);
			}
			
			this.addChild(referencesChild);
		}
	}

	class PropertyParent extends TreeParent {
		boolean isFromSuper = false;
		
		public PropertyParent(String name, String uri, boolean isFromSuper) {
			super(name);
			this.isFromSuper = isFromSuper;
		}	
	}
	
	class ViewContentProvider implements IStructuredContentProvider, 
										   ITreeContentProvider {	
		ViewContentProvider(){
			super();
		}
		
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot==null) initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
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
			if(obj instanceof PropertyParent) return Activator.getImageDescriptor("icons/method.png").createImage();
			if(obj instanceof EntityParent) return Activator.getImageDescriptor("icons/class_obj.png").createImage();
			if(obj instanceof FolderParent) return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
			if(obj instanceof TreeObject) return Activator.getImageDescriptor("icons/attribute.png").createImage();
			
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	
	class NameSorter extends ViewerSorter {
	}

	public EntityView() {
	}

	public void createPartControl(Composite parent) {
		entities.addAll(Arrays.asList());
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "metaRDF.ui.viewer");
		getSite().setSelectionProvider(viewer);
		invokeActions();
		//hookContextMenu();
		//hookDoubleClickAction();
		//contributeToActionBars();
	}
	
	/*private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
						menuMgr.setRemoveAllWhenShown(true);
						menuMgr.addMenuListener(new IMenuListener() {
							public void menuAboutToShow(IMenuManager manager) {
								manager.add(action);
							}
						});
						Menu menu = menuMgr.createContextMenu(viewer.getControl());
						viewer.getControl().setMenu(menu);
						getSite().registerContextMenu(menuMgr, viewer);
	}*/

	/*private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}*/

	/*private void fillLocalPullDown(IMenuManager manager) {
		manager.add(searchEntityAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(defineAction);
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(searchEntityAction);
	}*/

	private void invokeActions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			ResourceViewAction action;
			try{
				action = (ResourceViewAction) extension.createExecutableExtension("class");
				action.setText(extension.getAttribute("name"));
				action.setToolTipText(extension.getAttribute("description"));
				action.setView(this);
				
				String namespace = extension.getDeclaringExtension().getNamespaceIdentifier();
				
				ImageDescriptor descriptor = null;
				while((descriptor == null) && (!namespace.isEmpty())){
					descriptor = Activator.getImageDescriptor(namespace, extension.getAttribute("icon"));
					
					if(descriptor == null){
						if(namespace.contains(".")){
							namespace = namespace.substring(0, namespace.lastIndexOf("."));
						}
						else{
							namespace = "";
						}
					}
				}
				
				if(descriptor != null) action.setImageDescriptor(descriptor);
				
				if((action != null) && (extension.getAttribute("view")).equals("entities")){
					IActionBars bars = getViewSite().getActionBars();
					if(extension.getAttribute("position").equals("toolbar")){
						bars.getToolBarManager().add(action);
					}
					if(extension.getAttribute("position").equals("menumanager")){
						MenuManager menuMgr = new MenuManager("#PopupMenu");
						menuMgr.setRemoveAllWhenShown(true);
						menuMgr.addMenuListener(new IMenuListener() {
							public void menuAboutToShow(IMenuManager manager) {
								manager.add(action);
							}
						});
						Menu menu = menuMgr.createContextMenu(viewer.getControl());
						viewer.getControl().setMenu(menu);
						getSite().registerContextMenu(menuMgr, viewer);
					}	
				}
			}
			catch(CoreException e){
				System.out.println("Creating action in view exception");
			}
		}
		
		/*
		defineAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if(obj instanceof EntityParent){
					if(!(((EntityParent) obj).getSemanticclass().getComment()==null) && (((EntityParent) obj).getSemanticclass().getComment().compareTo("")!=0)){
						showMessage("Entity " + ((EntityParent)obj).getName() + " is described as " + ((EntityParent) obj).getSemanticclass().getComment());
					}	
				}
			}
		};
		
		defineAction.setText("Define entity");
		defineAction.setImageDescriptor(Activator.getImageDescriptor("icons/details_view.gif"));*/
		
		expandAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if(obj instanceof EntityParent){
					if(!isOnTheTree((EntityParent) obj)){
						expandEntity(((EntityParent) obj));
						viewer.refresh();
					}
					else{
						showMessage("Entity " + ((EntityParent)obj).getName() + " is already expanded on the list");
					}
				}
			}
		};
	}

	private boolean isOnTheTree(EntityParent obj){
		boolean onTheTree = false;
		Object element = obj;
		
		while((((TreeParent) element).getParent() != invisibleRoot) && (!onTheTree)){
			for(TreeObject child : ((TreeParent) element).getParent().getChildren()){
				if((child instanceof EntityParent) && (child!=obj)){
					if(((EntityParent) child).getSemanticclass().getUri().compareTo(((EntityParent) obj).getSemanticclass().getUri())==0){
						onTheTree = true;
					}	
				}
			}
			element = ((TreeParent) element).getParent();
		}
		
		if(((TreeParent)element).getParent() == invisibleRoot){
			for(TreeObject child : ((TreeParent) element).getParent().getChildren()){
				if((child instanceof EntityParent) && (child!=obj)){
					if(((EntityParent) child).getSemanticclass().getUri().compareTo(((EntityParent) obj).getSemanticclass().getUri())==0){
						onTheTree = true;
					}
				}		
			}
		}
		
		return onTheTree;
	}
	
	public void defineEntity(SemanticClass semanticclass){
		EntityParent entityParent;
		
		if((semanticclass.getLabel()==null)||(semanticclass.getLabel().compareTo("")==0)) entityParent = new EntityParent(semanticclass);
		else entityParent = new EntityParent(semanticclass);
		
		List<SemanticClass> superclasses = OwlAssistant.getInstance().getSuper(semanticclass.getUri(), false);
		semanticclass.setSuperclasses(superclasses);
		entityParent.drawSuperClasses();
		
		List<SemanticClass> subclasses = OwlAssistant.getInstance().getSub(semanticclass.getUri(), false);
		semanticclass.setSubclasses(subclasses);
		entityParent.drawSubclasses();
		
		List<ObjectProperty> references = OwlAssistant.getInstance().getObjectProperties(semanticclass.getUri(), true, true);
		semanticclass.setReferences(references);
		entityParent.drawReferences();
		
		List<DataProperty> properties = OwlAssistant.getInstance().getDataProperties(semanticclass.getUri(), true, true);
		semanticclass.setProperties(properties);
		entityParent.drawProperties();
		
		invisibleRoot.addChild(entityParent);
		viewer.refresh();
	}
	
	private void expandEntity(EntityParent entity){
		entity.getSemanticclass().addProperties(OwlAssistant.getInstance().getDataProperties(entity.getSemanticclass().getUri(), true, true));
		entity.drawProperties();
		entity.getSemanticclass().addReferences(OwlAssistant.getInstance().getObjectProperties(entity.getSemanticclass().getUri(), true, true));
		entity.drawReferences();
		entity.getSemanticclass().addSuperclasses(OwlAssistant.getInstance().getSuper(entity.getSemanticclass().getUri(), false));
		entity.drawSuperClasses();
		entity.getSemanticclass().addSubclasses(OwlAssistant.getInstance().getSub(entity.getSemanticclass().getUri(), false));
		entity.drawSubclasses();
	}
	
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				expandAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Entities",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public TreeViewer getViewer() {
		return viewer;
	}

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}
}
