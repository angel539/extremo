package uam.extremo.ui.views.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
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
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
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
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.provider.SemanticmanagerItemProviderAdapterFactory;
import uam.extremo.extensions.AssistantFactory;
import uam.extremo.extensions.IFormatAssistant;
import uam.extremo.extensions.FormatAssistant;
import uam.extremo.ui.views.Activator;
import uam.extremo.ui.wizards.dialogs.AddFolderResourceListWizardDialog;
import uam.extremo.ui.wizards.dialogs.changeToResource.ChangeDescriptorToResourceWizardDialog;
import uam.extremo.ui.wizards.dialogs.newrepository.NewRepositoryWizardDialog;
import uam.extremo.ui.wizards.dialogs.newresource.AddAResourceToExistingRepositoryWizardDialog;

public class RepositoryViewPart extends ViewPart implements IViewerProvider, ISelectionProvider, IEditingDomainProvider, ITabbedPropertySheetPageContributor{
	public static final String ID = "uam.extremo.ui.views.RepositoryView";

	private static TreeViewer viewer;
	private Action addRepository;
	private Action addResourceToExistingRepository;
	private Action addFolder;
	
	private Action changeResourceToDescriptor;
	private Action changeDescriptorToResource;
	
	protected ISelection editorSelection = StructuredSelection.EMPTY;	
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();
	protected AdapterFactoryEditingDomain editingDomain;
	protected ComposedAdapterFactory adapterFactory;
	protected List<PropertySheetPage> propertySheetPages = new ArrayList<PropertySheetPage>();
	
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
					styledString.append(" (" + repositoryNode.getResources().size() + ") ", StyledString.QUALIFIER_STYLER);
				}
				return styledString;
			}
			
			if (element instanceof Resource) {
				StyledString styledString = new StyledString(((Resource) element).getName());
				
				if(((Resource) element).getDescriptor() == null){
					styledString.append(" describes (" + ((Resource) element).getDescribes().size() + ") resources", StyledString.COUNTER_STYLER);
				}
				
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
				if(((Resource) element).getDescriptor() == null){
					return Activator.getImageDescriptor("icons/schema16.png").createImage();
				}
				else{
					if(((Resource) element).isAlive()) return Activator.getImageDescriptor("icons/3d_objects_16.png").createImage();
	        		else{
	        			return Activator.getImageDescriptor("icons/3d_objects_off_16.png").createImage();
	        		}
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

	public void createPartControl(Composite parent) {		
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
	
		RepositoryViewContentProvider provider = new RepositoryViewContentProvider(AssistantFactory.getInstance().getRepositoryManager(), getViewSite());
		viewer.setContentProvider(provider);
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		viewer.getTree().setHeaderVisible(true);
		
		
		
		viewer.setSelection(new StructuredSelection(AssistantFactory.getInstance().getRepositoryManager()), true);
		new AdapterFactoryTreeEditor(viewer.getTree(), adapterFactory);
		
		
		
		
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
		
		
		
		
		initializeEditingDomain();
		
		
		
		
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
		
		//Connection with properties view
		getSite().setSelectionProvider(viewer);
		getViewSite().setSelectionProvider(viewer);
		
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
		
		manager.add(changeDescriptorToResource);
		manager.add(changeResourceToDescriptor);
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(addRepository);
		manager.add(addFolder);
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
				
				if (selection != null & selection instanceof IStructuredSelection) {
					IStructuredSelection strucSelection = (IStructuredSelection) selection;
					Object element = strucSelection.getFirstElement();
					
					if(element instanceof Repository){
						WizardDialog wizardDialog = new WizardDialog(null, new AddAResourceToExistingRepositoryWizardDialog((Repository) element));
						if (wizardDialog.open() == Window.OK) {
							MessageDialog.openConfirm(null, "Add resource to repository", "Resource has been added");
						}
						else{
							MessageDialog.openError(null, "Add resource to repository", "Resource could not be added");
						}
					}
					else{
						MessageDialog.openError(null, "Add resource to repository", "Repository must be selected");
					}
				}	
			}
		};
		
		addResourceToExistingRepository.setText("Add resource to repository");
		addResourceToExistingRepository.setImageDescriptor(Activator.getImageDescriptor("icons/3d_objects_16.png"));
		
		changeResourceToDescriptor = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				
				if (selection != null & selection instanceof IStructuredSelection) {
					IStructuredSelection strucSelection = (IStructuredSelection) selection;
					Object element = strucSelection.getFirstElement();
					
					if(element instanceof Resource){
						Resource resource = (Resource) element;
						
						if(resource.getDescriptor() != null){
							resource.getDescriptor().getRepositoryFrom().getResources().add(resource);
						}		
					}
					else{
						MessageDialog.openError(null, "Change descriptor to resource", "Resource must be selected");
					}
				}	
			}
		};
		
		changeResourceToDescriptor.setText("Change resource to descriptor");
		changeResourceToDescriptor.setImageDescriptor(Activator.getImageDescriptor("icons/left16.png"));
		
		changeDescriptorToResource = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				
				if (selection != null & selection instanceof IStructuredSelection) {
					IStructuredSelection strucSelection = (IStructuredSelection) selection;
					Object element = strucSelection.getFirstElement();
					
					if(element instanceof Resource){
						Resource resource = (Resource) element;
						
						if(resource.getDescriptor() == null){
							WizardDialog wizardDialog = new WizardDialog(null, new ChangeDescriptorToResourceWizardDialog(resource));
							if (wizardDialog.open() == Window.OK) {
								MessageDialog.openConfirm(null, "Add resource to repository", "Resource has been added");
							}
							else{
								MessageDialog.openError(null, "Add resource to repository", "Resource could not be added");
							}
						}
						else{
							MessageDialog.openError(null, "Change descriptor to resource", "Resource is not a descriptor. It cannot be changed");
						}
					}
					else{
						MessageDialog.openError(null, "Change descriptor to resource", "Resource must be selected");
					}
				}	
			}
		};
		
		changeDescriptorToResource.setText("Change descriptor to resource");
		changeDescriptorToResource.setImageDescriptor(Activator.getImageDescriptor("icons/right16.png"));
	}

	private void hookDoubleClickAction() {
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
  
    @Override
	public String getContributorId() {
		return ID;
	}

    //ISelectionProvider
    
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	@Override
	public ISelection getSelection() {
		return editorSelection;
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		editorSelection = selection;

		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}
	}

	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	protected void initializeEditingDomain() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SemanticmanagerItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		//
		/*commandStack.addCommandStackListener
			(new CommandStackListener() {
				 public void commandStackChanged(final EventObject event) {
					 viewer.getDisplay().asyncExec
						 (new Runnable() {
							  public void run() {
								  firePropertyChange(IEditorPart.PROP_DIRTY);

								  // Try to select the affected objects.
								  //
								  Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
								  if (mostRecentCommand != null) {
									  setSelectionToViewer(mostRecentCommand.getAffectedObjects());
								  }
								  for (Iterator<PropertySheetPage> i = propertySheetPages.iterator(); i.hasNext(); ) {
									  PropertySheetPage propertySheetPage = i.next();
									  if (propertySheetPage.getControl().isDisposed()) {
										  i.remove();
									  }
									  else {
										  propertySheetPage.refresh();
									  }
								  }
							  }
						  });
				 }
			 });*/
		
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<org.eclipse.emf.ecore.resource.Resource, Boolean>());
	}
	
	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		
		if (theSelection != null && !theSelection.isEmpty()) {
			Runnable runnable =
				new Runnable() {
					public void run() {
						if (viewer != null) {
							viewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
						}
					}
				};
			getSite().getShell().getDisplay().asyncExec(runnable);
		}
	}
	
	public IPropertySheetPage getPropertySheetPage() {
		PropertySheetPage propertySheetPage =
			new ExtendedPropertySheetPage(editingDomain) {
				@Override
				public void setSelectionToViewer(List<?> selection) {
					setSelectionToViewer(selection);
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
				}
			};
		propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
		propertySheetPages.add(propertySheetPage);

		return propertySheetPage;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}
		else {
			return super.getAdapter(key);
		}
	}

	
	
	@Override
	public Viewer getViewer() {
		return viewer;
	}
}
