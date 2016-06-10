package metardf.ui.views.repositories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import metaRDF.core.model.IRepository;
import metaRDF.core.model.IRepositoryManager;
import metaRDF.core.model.IResource;
import metaRDF.core.model.impl.RepositoryManager;
import metardf.core.extensions.AssistantFactory;
import metardf.core.extensions.FormatAssistant;
import metardf.core.extensions.IFormatAssistant;
import metardf.ui.Activator;
import metardf.ui.views.repositories.model.RepositoryParent;
import metardf.ui.views.repositories.model.ResourceObject;
import metardf.ui.views.repositories.model.TreeObject;
import metardf.ui.views.repositories.model.TreeParent;
import metardf.ui.wizards.EditResourceWizardDialog;
import metardf.ui.wizards.NewRepositoryWizardDialog;
import metardf.ui.wizards.NewResourceWizardDialog;
import metardf.ui.wizards.ResourceListWizardDialog;
import metardf.ui.wizards.importers.NewFileExportSupportWizardDialog;
import metardf.ui.wizards.importers.NewFileImportSupportWizardDialog;

public class RepositoryViewPart extends ViewPart {
	public static final String ID = "metardf.ui.views.RepositoryView";

	private static CheckboxTreeViewer viewer;
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
				StyledString styledString = new StyledString((String)resourceObject.getResource().getId());
				return styledString;
			}
			
			return null;
		}
	}
	
	class NameSorter extends ViewerSorter {
	}

	public RepositoryViewPart() {
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
				}
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
				RepositoryViewPart.this.fillContextMenu(manager);
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
	
	

	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
