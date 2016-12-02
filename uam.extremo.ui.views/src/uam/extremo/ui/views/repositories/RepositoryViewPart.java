package uam.extremo.ui.views.repositories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.Search;
import semanticmanager.SemanticmanagerFactory;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.extensions.IFormatAssistant;
import uam.extremo.extensions.FormatAssistant;
import uam.extremo.ui.views.Activator;
import uam.extremo.ui.wizards.dialogs.AddFolderResourceListWizardDialog;
import uam.extremo.ui.wizards.dialogs.newrepository.NewRepositoryWizardDialog;
import uam.extremo.ui.wizards.dialogs.newresource.AddAResourceToExistingRepositoryWizardDialog;

public class RepositoryViewPart extends ViewPart {
	public static final String ID = "uam.extremo.ui.views.RepositoryView";

	private static TreeViewer viewer;
	private Action addRepository;
	private Action addResourceToExistingRepository;
	private Action addFolder;
	
	class AssistantEditingSupport extends EditingSupport {
		private ComboBoxViewerCellEditor editor;
		  
		public AssistantEditingSupport() {
			super(viewer);
			
			this.editor = new ComboBoxViewerCellEditor(viewer.getTree());
			this.editor.setContentProvider(new ArrayContentProvider());
			this.editor.setLabelProvider(new ViewLabelProvider());
			
			List<String> strings = new ArrayList<String>();
			for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
				String name = ((FormatAssistant) assistant).getNameExtension();
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
			if(element instanceof Resource){
				return ((Resource) element).getName();
			}
			return null;
		}

		@Override
		protected void setValue(Object element, Object value) {
			if(element instanceof Resource){
				((Resource) element).setAssistant(String.valueOf(value));
			}
			
			if(element instanceof Repository){
				for(Resource resource : ((Repository) element).getResources()){
					resource.setAssistant(String.valueOf(value));
				}
			}
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
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			if (element instanceof Repository) {
				Repository repositoryNode = (Repository) element;
				StyledString styledString = new StyledString(repositoryNode.getName());
				
				if (repositoryNode.getResources() != null) {
					styledString.append(" (" + repositoryNode.getResources().size() + ") ", StyledString.COUNTER_STYLER);
				}
				return styledString;
			}
			
			if (element instanceof Resource) {
				StyledString styledString = new StyledString(((Resource) element).getName());
				return styledString;
			}
			
			return null;
		}
		
		@Override
		public Image getImage(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			
			if(element instanceof Repository) return Activator.getImageDescriptor("icons/folder-icon_16.png").createImage();
        	if(element instanceof Resource){
        		if(((Resource) element).isAlive()) return Activator.getImageDescriptor("icons/3d_objects_16.png").createImage();
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
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			if (element instanceof Resource) {
				Resource resourceObject = (Resource) element;
				if(resourceObject.getAssistant() != null) return new StyledString(resourceObject.getAssistant());
				else new StyledString("");
			}
			
			return new StyledString("");
		}
	}
	
	class ColumnThreeViewLabelProvider extends LabelProvider implements IStyledLabelProvider{
		@Override
		public StyledString getStyledText(Object element) {
			if(element instanceof IStructuredSelection) element = ((IStructuredSelection) element).getFirstElement();
			
			if (element instanceof Repository) {
				Repository repositoryNode = (Repository) element;
				StyledString styledString = new StyledString(repositoryNode.getName());
				return styledString;
			}
			
			if (element instanceof Resource) {
				Resource resourceObject = (Resource) element;
				StyledString styledString = new StyledString((String)resourceObject.getUri());
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
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
	
		RepositoryViewContentProvider provider = new RepositoryViewContentProvider(AssistantFactory.getInstance().getRepositoryManager(), getViewSite());
		viewer.setContentProvider(provider);
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
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
		assistedByColumn.setEditingSupport(new AssistantEditingSupport());
		
		TreeViewerColumn uriColumn = new TreeViewerColumn(viewer, SWT.NONE);
		uriColumn.getColumn().setText("Uri");
		uriColumn.getColumn().setWidth(400);
		uriColumn.getColumn().setAlignment(SWT.LEFT);
		uriColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnThreeViewLabelProvider()));
		
		EContentAdapter adapter = new EContentAdapter() {
            public void notifyChanged(Notification notification) {
           		 super.notifyChanged(notification);
           		 refresh();
            }
    	};
    	
    	AssistantFactory.getInstance().getRepositoryManager().eAdapters().add(adapter);
		
    	RepositoryViewFilter filter = new RepositoryViewFilter();
		ViewerFilter[] filters = {filter};
		viewer.setFilters(filters);
    	
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "extremo.ui.viewer");
		getSite().setSelectionProvider(viewer);
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();		
	}
	
	public void refresh() {
		Job job = new Job("Refreshing Repository View") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                doLongThing();
                syncWithUi();
                return Status.OK_STATUS;
            }
	    };
	    job.setUser(true);
	    job.schedule();
	}
	
	private void syncWithUi() {
        try {
        	Thread.sleep(100);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
	}

	private void doLongThing() {
		Display.getDefault().asyncExec(new Runnable() {
            public void run() {
            	   viewer.setInput(AssistantFactory.getInstance().getRepositoryManager());
            }
		});
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
		manager.add(addResourceToExistingRepository);
		//manager.add(searchAction);
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(addRepository);
		manager.add(addFolder);
		//manager.add(searchAction);
	}

	private void makeActions() {
		addRepository = new Action() {
			public void run() {
				WizardDialog wizardDialog = new WizardDialog(null, new NewRepositoryWizardDialog());
				if (wizardDialog.open() == Window.OK) {
					MessageDialog.openConfirm(null, "Add Repository", "Repository has been added");
				}
				else{
					MessageDialog.openError(null, "Add Repository", "Repository could not be added");
				}
			}
		};
		
		addRepository.setText("Add Repository");
		addRepository.setToolTipText("");
		addRepository.setImageDescriptor(Activator.getImageDescriptor("icons/newfolder_wiz.gif"));
		
		addFolder = new Action() {
			public void run() {
				WizardDialog wizardDialog = new WizardDialog(null, new AddFolderResourceListWizardDialog());
				if (wizardDialog.open() == Window.OK) {
					MessageDialog.openConfirm(null, "Add Folder", "Resources imported");
				}
				else{
					MessageDialog.openError(null, "Add Folder", "Resources could not be imported");
				}
			}
		};
		
		addFolder.setText("Add Folder");
		addFolder.setToolTipText("");
		addFolder.setImageDescriptor(Activator.getImageDescriptor("icons/package.gif"));
		
		addResourceToExistingRepository = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				
				for(Object obj : ((IStructuredSelection)selection).toArray()){
					if(obj instanceof Repository){
						WizardDialog wizardDialog = new WizardDialog(null, new AddAResourceToExistingRepositoryWizardDialog((Repository) obj));
						if (wizardDialog.open() == Window.OK) {
							MessageDialog.openConfirm(null, "Add resource to repository", "Resource has been added");
						}
						else{
							MessageDialog.openError(null, "Add resource to repository", "Resource could not be added");
						}
					}
				}	
			}
		};
		
		addResourceToExistingRepository.setText("Add resource to repository");
		addResourceToExistingRepository.setImageDescriptor(Activator.getImageDescriptor("icons/3d_objects_16.png"));
		
		/*searchAction = new Action(){
			public void run(){
				executeSearchAction();
			}
		};
		searchAction.setText("Search");
		searchAction.setToolTipText("Open the search action wizard");
		searchAction.setImageDescriptor(Activator.getImageDescriptor("icons/search.png"));*/
	}
	
	/*private void executeSearchAction() {
		RepositoryManager repositoryManager = AssistantFactory.getInstance().getRepositoryManager();
		
		if((repositoryManager!=null) && (repositoryManager.getRepositories()!=null) && (repositoryManager.getRepositories().size() > 0)){
			Search searchOptions = SemanticmanagerFactory.eINSTANCE.createSearch();
			
			searchOptions.setStrategyApplied(Activator.getDefault().getPreferenceStore().getString("PRESETS"));
			searchOptions.setRelevanceR1(Activator.getDefault().getPreferenceStore().getInt("RELEVANCE_R1"));
			searchOptions.setRelevanceR2(Activator.getDefault().getPreferenceStore().getInt("RELEVANCE_R2"));
			searchOptions.setRelevanceR3(Activator.getDefault().getPreferenceStore().getInt("RELEVANCE_R3"));
			searchOptions.setRelevanceR4(Activator.getDefault().getPreferenceStore().getInt("RELEVANCE_R4"));
			searchOptions.setRelevanceR5(Activator.getDefault().getPreferenceStore().getInt("RELEVANCE_R5"));
			searchOptions.setMaxWeight(Activator.getDefault().getPreferenceStore().getInt("MAX_WEIGHT"));
			
			System.out.println("before wizard " + searchOptions);
			
			WizardDialog wizardDialog = new WizardDialog(null, new SearchSemanticNodesWizardDialog(searchOptions));
			if (wizardDialog.open() == Window.OK) {
				if(searchOptions != null){
					searchAndRefreshView(searchOptions);
				}
			}
			else{
				MessageDialog.openError(null, "Search entities", "Searching could not be called");
			}
		}  
	}*/
	
	/*private static boolean searchAndRefreshView(Search search){
		AssistantFactory.getInstance().search(search);
		return true;
	}*/
	
	/*public static boolean searchAndRefreshView(String candidate){
		Search search = SemanticmanagerFactory.eINSTANCE.createSearch();
		search.setSearchField(candidate);
		return searchAndRefreshView(search);
	}*/

	private void hookDoubleClickAction() {
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
