package metardf.ui.views.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.IRepository;
import metaRDF.core.model.IResource;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.RepositoryManager;
import metaRDF.core.model.impl.SemanticResource;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;
import metardf.ui.Activator;
import metardf.ui.dnd.GraphityEditorTransferDropTargetListener;
import metardf.ui.dnd.ModelTransfer;
import metardf.ui.dnd.ResourceViewAction;
import metardf.ui.views.entities.filters.EntityFilter;
import metardf.ui.views.entities.filters.ShowAllFilter;
import metardf.ui.views.entities.model.AttrFolderParent;
import metardf.ui.views.entities.model.DataPropertyObject;
import metardf.ui.views.entities.model.EntityParent;
import metardf.ui.views.entities.model.FolderParent;
import metardf.ui.views.entities.model.PropertyParent;
import metardf.ui.views.entities.model.SearchParent;
import metardf.ui.views.entities.model.TreeObject;
import metardf.ui.views.entities.model.TreeParent;
import metardf.ui.wizards.WordnetLocationWizardDialog;

public class EntityView extends ViewPart {
	public static final String ID = "metardf.ui.views.EntityView";
	private List<String> entities = new ArrayList<String>();

	private static TreeViewer viewer;
	private Action searchAction;
	private Action expandAction;
	
	private Action wordnetLocation;
	private Action filterEntities;
	private Action filterShowAll;
	//private Action filterEntitiesWithAttrs;
	
	private static TreeParent invisibleRoot = new TreeParent("");
	
	public TreeParent getRoot() {
		return invisibleRoot;
	}

	public void setRoot(TreeParent root) {
		this.invisibleRoot = root;
	}

	class NameSorter extends ViewerSorter {
	}

	public EntityView() {
	}

	public void createPartControl(Composite parent) {
		
		entities.addAll(Arrays.asList());
		
		PatternFilter filter = new PatternFilter();
		FilteredTree tree = new FilteredTree(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL, filter, true);
		
		//viewer = new EntityTreeViewer(tree);
		viewer = tree.getViewer();
		//viewer = new EntityTreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new EntityTreeViewContentProvider(invisibleRoot, getViewSite()));
		viewer.setLabelProvider(new EntityTreeViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "metaRDF.ui.viewer");
		getSite().setSelectionProvider(viewer);
		
		DragSource ds = new DragSource(viewer.getTree(), DND.DROP_COPY);
		ds.setTransfer(new Transfer[] {ModelTransfer.getInstance()});
		ds.addDragListener(new DragSourceAdapter() {
		     public void dragSetData(DragSourceEvent event) {
		    	 IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		    	 ISemanticElement[] data = new ISemanticElement[selection.size()];
		    	 
		    	 for(int i=0; i<selection.size(); i++){
		    		 if(selection.toArray()[i] instanceof TreeObject){
		    			 data[i] = ((TreeObject) selection.toArray()[i]).getSemanticElement();
		    		 }
		    	 }
		    	 
		    	 if(!theyAreMixed(data)){
		    		 event.data = data;
		    	 }
		    	 
		     }

			private boolean theyAreMixed(ISemanticElement[] data) {
				if(data.length > 0){
					Object firstData = data[0];
					for(int i=0; i<data.length; i++){
						if(!data[i].getClass().equals(firstData.getClass())){
							return true;
						}
					}
				}
				else return true;
				
				return false;
			}
		  });
		
		defaultFilteringActions();
		invokeActions();
		invokeFilters();
		invokeEditors();
		makeActions();
		hookDoubleClickAction();
		contributeToActionBars();	
	}
	
	private void defaultFilteringActions() {
		filterShowAll = new Action() {
			public void run() {
				ViewerFilter[] filters = {new ShowAllFilter()};
				viewer.setFilters(filters);
				viewer.refresh();
			}
		};
		
		filterShowAll.setText("Show all");
		filterShowAll.setToolTipText("");
		filterShowAll.setImageDescriptor(Activator.getImageDescriptor("icons/alpha_mode.gif"));
		
		filterEntities = new Action() {
			public void run() {
				ViewerFilter[] filters = {new EntityFilter()};
				viewer.setFilters(filters);
				viewer.refresh();
			}
		};
		
		filterEntities.setText("Show main entities only");
		filterEntities.setToolTipText("");
		filterEntities.setImageDescriptor(Activator.getImageDescriptor("icons/filter_top_level.gif"));
		
		/*filterEntitiesWithAttrs = new Action() {
			public void run() {
				ViewerFilter[] filters = {new EntityWithAttrsFilter()};
				viewer.setFilters(filters);
				viewer.refresh();
			}
		};
		
		filterEntitiesWithAttrs.setText("Show entities with attrs");
		filterEntitiesWithAttrs.setToolTipText("");
		filterEntitiesWithAttrs.setImageDescriptor(Activator.getImageDescriptor("icons/filter_properties.gif"));*/
	}
	
	private void invokeFilters() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.FILTER_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("filter")==0){
				ViewerFilter filter;
				try{
					filter = (ViewerFilter) extension.createExecutableExtension("class");
					
					if((filter != null) && (extension.getAttribute("view")).equals("entities")){
						Action extensionFilterAction = new Action() {
							public void run() {
								ViewerFilter[] filters = {filter};
								viewer.setFilters(filters);
								viewer.refresh();
							}
						};
						
						extensionFilterAction.setText(extension.getAttribute("name"));
						extensionFilterAction.setToolTipText(extension.getAttribute("description"));
						
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
						
						if(descriptor != null) extensionFilterAction.setImageDescriptor(descriptor);
						
						IActionBars bars = getViewSite().getActionBars();
						bars.getMenuManager().add(extensionFilterAction);
					}
				}
				catch(CoreException e){
				}
			}	
		}
	}
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(searchAction);
		manager.add(wordnetLocation);
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(filterShowAll);
		manager.add(filterEntities);
		//manager.add(filterEntitiesWithAttrs);
	}
	
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				expandAction.run();
			}
		});
	}
	
	private void invokeEditors(){
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IEditorPart editor = window.getActivePage().getActiveEditor();
		
		if (editor instanceof IDiagramContainerUI){
			IDiagramContainerUI diagramEditor =  (IDiagramContainerUI) editor;
			GraphicalViewer graphicalViewer = diagramEditor.getGraphicalViewer();

			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.EDITOR_EXTENSIONS_ID);
			
			for(IConfigurationElement extension : extensions){
				if(extension.getName().compareTo("editordrop") == 0){
					//System.out.println("hemos llegado a la extension..." + extension.getAttribute("class"));
					GraphityEditorTransferDropTargetListener graphityDrop;
					try{
						graphityDrop = (GraphityEditorTransferDropTargetListener) extension.createExecutableExtension("class");
						graphicalViewer.addDropTargetListener(graphityDrop);
					}
					catch(CoreException e){
						//System.out.println("Creating action in editor exception");
					}
				}	
			}
		 }
	}
	
	private void invokeActions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("action")==0){
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
				}
			}	
		}
	}

	private void makeActions() {		
		wordnetLocation = new Action() {
			public void run() {
				WizardDialog wizardDialog = new WizardDialog(null, new WordnetLocationWizardDialog());
				wizardDialog.open();
			}
		};
		
		wordnetLocation.setText("Wordnet Location");
		wordnetLocation.setToolTipText("");
		wordnetLocation.setImageDescriptor(Activator.getImageDescriptor("icons/wn.png"));
		
		searchAction = new Action(){
			public void run(){
				executeSearchAction();
			}
		};
		searchAction.setText("Search");
		searchAction.setToolTipText("");
		searchAction.setImageDescriptor(Activator.getImageDescriptor("icons/search.png"));
		
		expandAction = new Action(){
			public void run(){
				executeExpandAction();
			}
		};
		expandAction.setText("Expand");
		expandAction.setToolTipText("");
		expandAction.setImageDescriptor(Activator.getImageDescriptor("icons/details_view.gif"));
	}
	
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public static TreeViewer getViewer() {
		return viewer;
	}

	public void setViewer(EntityTreeViewer viewer) {
		this.viewer = viewer;
	}

	public static TreeParent getInvisibleRoot() {
		return invisibleRoot;
	}
	
	private void executeSearchAction() {
		RepositoryManager repositoryManager = RepositoryManager.getInstance();
		
		if((repositoryManager!=null) && (repositoryManager.getRepositories()!=null) && (repositoryManager.getRepositories().size() > 0)){
			String candidate = null;
			
			InputDialog inputDialog = new InputDialog(null, "Search", "Enter a list of words", "", null);
			if (inputDialog.open() == Window.OK){
				candidate = inputDialog.getValue();
			}
			
			if(candidate != null) searchAndRefreshView(candidate);
		}  
	}
	
	public static boolean searchAndRefreshView(String candidate){
		SearchParent search = createSearchParent(candidate);
		
		List<ISemanticClass> searchResults = searchInAssistances(candidate);
		for(ISemanticClass entity : searchResults){
			EntityParent parent = new EntityParent(entity);
			drawEntityParentContent(parent);
			search.addChild(parent);
		}
		
		getInvisibleRoot().addChild(search);
		getViewer().refresh();
		
		return true;
	}
	
	private static List<ISemanticClass> searchInAssistances(String candidate) {
		List<ISemanticClass> searchResults = new ArrayList<ISemanticClass>();
		
		RepositoryManager repositoryManager = RepositoryManager.getInstance();
		List<IFormatAssistant> assistances = AssistantFactory.getInstance().getAssistances();
		//searching
		for(IRepository repository : repositoryManager.getRepositories()){    
			for(IResource resource : repository.getResources()){
				if((resource instanceof SemanticResource) && (resource.isActive())){			
					for(IFormatAssistant assistant : assistances){
						if((resource.isAlive()) && (resource.getAssistant() != null)){
							if(((FormatAssistant)assistant).getNameExtension().compareTo(resource.getAssistant())==0){
								if((resource != null) && (resource instanceof SemanticResource) && (assistant.load((SemanticResource) resource))){	
									List<ISemanticClass> entities = assistant.getClassesLike(candidate);
									for(ISemanticClass entity : entities){
										defineEntity(assistant, entity);
										searchResults.add(entity);
									}
								}
							}
						}
					}
				}	
			}		
		}
		
		return searchResults;
	}

	private static SearchParent createSearchParent(String search) {
		SearchParent searchParent = new SearchParent(search);
		return searchParent;
	}
	
	private static void defineEntity(IFormatAssistant assistant, ISemanticElement entity){
		if(entity instanceof ISemanticClass){
			List<ISemanticClass> superclasses = assistant.getSuper(entity.getId(), false);
			((ISemanticClass) entity).setSuperclasses(superclasses);
			List<ISemanticClass> subclasses = assistant.getSub(entity.getId(), false);
			((ISemanticClass) entity).setSubclasses(subclasses);
			List<IObjectProperty> references = assistant.getObjectProperties(entity.getId(), true, true);
			((ISemanticClass) entity).setReferences(references);
			List<IDataProperty> properties = assistant.getDataProperties(entity.getId(), true, true);
			((ISemanticClass) entity).setProperties(properties);
		}
	}
	
	private static void drawEntityParentContent(EntityParent entityParent) {
		drawSuperClasses(entityParent);
		drawSubclasses(entityParent);
		drawReferences(entityParent);
		drawProperties(entityParent);
	}
	
	private static void drawSuperClasses(EntityParent parent){
		int superClassesCount = 0;
		
		if(parent.getSemanticElement() instanceof ISemanticClass){
			superClassesCount = superClassesCount + ((ISemanticClass) parent.getSemanticElement()).getSuperclasses().size();
		}
		if(superClassesCount > 0){
			FolderParent supersChild = new FolderParent("supers"  + " (" + superClassesCount + ")");
			
			if(parent.getSemanticElement() instanceof ISemanticClass){
				for(ISemanticClass superClass : ((ISemanticClass) parent.getSemanticElement()).getSuperclasses()){
					EntityParent entitySuperClass = new EntityParent(superClass);
					supersChild.addChild(entitySuperClass);
				}
			}
			
			parent.addChild(supersChild);
		}
	}
	
	private static void drawSubclasses(EntityParent parent){
		int subClassesCount = 0;

		if(parent.getSemanticElement() instanceof ISemanticClass){
			subClassesCount = subClassesCount + ((ISemanticClass) parent.getSemanticElement()).getSubclasses().size();
		}
		if(subClassesCount > 0){
			FolderParent subsChild = new FolderParent("subs"  + " (" + subClassesCount + ")");
			
			if(parent.getSemanticElement() instanceof ISemanticClass){
				for(ISemanticClass subClass : ((ISemanticClass) parent.getSemanticElement()).getSubclasses()){
					EntityParent entitySubClass = new EntityParent(subClass);
					subsChild.addChild(entitySubClass);
				}
			}
			
			parent.addChild(subsChild);
		}
		
	}
	
	private static void drawReferences(EntityParent parent){
		int referencesCount = 0;
		
		if(parent.getSemanticElement() instanceof ISemanticClass){
			referencesCount = referencesCount + ((ISemanticClass) parent.getSemanticElement()).getReferences().size();
		}
		if(referencesCount > 0 ){
			FolderParent referencesChild = new FolderParent("references" + " (" + referencesCount + ")");
			
			if(parent.getSemanticElement() instanceof ISemanticClass){
		
				for(IObjectProperty reference : ((ISemanticClass) parent.getSemanticElement()).getReferences()){
					PropertyParent entitySuper = new PropertyParent(reference);
					referencesChild.addChild(entitySuper);
					
					EntityParent entityReference = new EntityParent(reference.getRangeAsSemanticClass());
					entitySuper.addChild(entityReference);
				}
			}
			
			parent.addChild(referencesChild);
		}
		
	}
	
	private static void drawProperties(EntityParent parent){
		int propertiesCount = 0;
		
		if(parent.getSemanticElement() instanceof ISemanticClass){
			propertiesCount = propertiesCount + ((ISemanticClass) parent.getSemanticElement()).getProperties().size();
		}
		if(propertiesCount > 0){
			AttrFolderParent referencesChild = new AttrFolderParent("attributes" + " (" + propertiesCount + ")");
			
			if(parent.getSemanticElement() instanceof ISemanticClass){
				for(IDataProperty attribute : ((ISemanticClass) parent.getSemanticElement()).getProperties()){
					DataPropertyObject entitySuper = new DataPropertyObject(attribute);
					referencesChild.addChild(entitySuper);
				}
			}
			
			parent.addChild(referencesChild);
		}
	}
	
	private void executeExpandAction() {
		ISelection selection = getViewer().getSelection();
		Object obj = ((IStructuredSelection)selection).getFirstElement();
		
		if(obj instanceof EntityParent){
			if(!isOnTheTree((EntityParent) obj)){
				RepositoryManager repositoryManager = RepositoryManager.getInstance();
				List<IFormatAssistant> assistances = AssistantFactory.getInstance().getAssistances();
				//searching
				for(IRepository repository : repositoryManager.getRepositories()){    
					for(IResource resource : repository.getResources()){
						if(resource instanceof SemanticResource){			
							for(IFormatAssistant assistant : assistances){
								if((resource.isAlive()) && (resource.getAssistant() != null)){
									if(((FormatAssistant)assistant).getNameExtension().compareTo(resource.getAssistant())==0){
										if((resource instanceof SemanticResource) && (assistant.load((SemanticResource) resource))){	
											defineEntity(assistant, ((EntityParent) obj).getSemanticElement());
										}
									}
								}
							}
						}	
					}		
				}
				
				drawEntityParentContent((EntityParent) obj);
				getViewer().refresh();
			}
			else{
				showMessage("Entity " + ((EntityParent)obj).getName() + " is already expanded on the list");
			}
		}
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(
			getViewer().getControl().getShell(),
			"Entities",
			message);
	}
	
	private boolean isOnTheTree(EntityParent obj){
		boolean onTheTree = false;
		Object element = obj;
		
		while((((TreeParent) element).getParent() != getRoot()) && (!onTheTree)){
			for(TreeObject child : ((TreeParent) element).getParent().getChildren()){
				if((child instanceof EntityParent) && (child!=obj)){
					if(((EntityParent) child).getSemanticElement().getIdToString().compareTo(((EntityParent) obj).getSemanticElement().getIdToString())==0){
						onTheTree = true;
					}	
				}
			}
			element = ((TreeParent) element).getParent();
		}
		
		if(((TreeParent)element).getParent() == getRoot()){
			for(TreeObject child : ((TreeParent) element).getParent().getChildren()){
				if((child instanceof EntityParent) && (child!=obj)){
					if(((String) ((EntityParent) child).getSemanticElement().getId()).compareTo((String) ((EntityParent) obj).getSemanticElement().getId())==0){
						onTheTree = true;
					}
				}		
			}
		}
		
		return onTheTree;
	}
}
