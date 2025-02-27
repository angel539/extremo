/*******************************************************************************
 * Copyright (c) 2018 Universidad Autónoma de Madrid (Spain).
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 3.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-3.0
 *
 * Contributors:
 * 				Ángel Mora Segura - implementation
 ******************************************************************************/
package uam.extremo.ui.views.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import semanticmanager.provider.SemanticmanagerItemProviderAdapterFactory;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.SemanticNode;
import semanticmanager.util.SemanticmanagerAdapterFactory;
import uam.extremo.ui.wizards.importer.AddFolderResourceListWizardDialog;

import org.eclipse.emf.ecore.EObject;

import uam.extremo.extensions.AssistantManager;
import uam.extremo.ui.Activator;
import uam.extremo.ui.extensions.integration.ExtensibleGEFDragAndDropContribution;
import uam.extremo.ui.extensions.integration.ExtensibleViewPartActionContribution;
import uam.extremo.ui.views.searchtree.TreeViewAdapterFactoryLabelProvider;

public class RepositoryViewPart extends ViewPart implements IViewerProvider, ISelectionProvider, ITabbedPropertySheetPageContributor, ISetSelectionTarget{
	public static final String ID = "uam.extremo.ui.views.RepositoryView";
	public static final String NATURE_ID = "uam.extremo.ui.extremonature";

	private static TreeViewer viewer;
	private Action addResourceToExistingRepository;
	private Action addFolder;
	
	private Action changeResourceToDescriptor;
	private Action changeDescriptorToResource;
	
	protected ISelection editorSelection = StructuredSelection.EMPTY;	
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();
	protected List<PropertySheetPage> propertySheetPages = new ArrayList<PropertySheetPage>();
	
	private ISelectionListener pageSelectionListener;
	
	protected ComposedAdapterFactory adapterFactory;
	List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
	
	TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(
            										"uam.extremo.extensions.ExtremoEditingDomain");
	
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/*
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
				return ((Resource) element).getAssistant();
			}
			return null;
		}

		@Override
		protected void setValue(Object element, Object value) {	
        	if(element instanceof Resource){
				Resource resource = (Resource) element;
				
				if((resource.getDescriptors() == null) || (resource.getDescriptors().isEmpty())){
					for(NamedElement namedElement : resource.getDescribes()){
						if (namedElement instanceof Resource) {
							Resource described = (Resource) namedElement;
							described.setAssistant(String.valueOf(value));
							try {
								AssistantFactory.getInstance().changeResourceAssistant(described, String.valueOf(value));
							}
							catch (IOException e) {
								Activator.writeConsole(e.getMessage());
							}
						}
					}
				}

				resource.setAssistant(String.valueOf(value));
				try {
					AssistantFactory.getInstance().changeResourceAssistant(resource, String.valueOf(value));
				}
				catch (IOException e) {
					Activator.writeConsole(e.getMessage());
				}

			}
			
			if(element instanceof Repository){
				for(Resource resource : ((Repository) element).getResources()){
					resource.setAssistant(String.valueOf(value));
					try {
						AssistantFactory.getInstance().changeResourceAssistant(resource, String.valueOf(value));
					}
					catch (IOException e) {
						Activator.writeConsole(e.getMessage());
					}
				}
			}
        }
	}*/

	@Override
	public void createPartControl(Composite parent) {		
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		
    	RepositoryViewFilter filter = new RepositoryViewFilter();
		ViewerFilter[] filters = {filter};
		viewer.setFilters(filters);
		
		viewer.getTree().setHeaderVisible(true);
		
		// Content Provider
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		// Building the content and the label provider from EMF Edit
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new SemanticmanagerItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		
		//adapterFactory = new ComposedAdapterFactory(factories);
		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(adapterFactory);
		viewer.setContentProvider(contentProvider);
		
		// Label Provider
		// Three Columns
		TreeViewerColumn nameColumn = new TreeViewerColumn(viewer, SWT.NONE);
		nameColumn.getColumn().setText("Name");
		nameColumn.getColumn().setWidth(300);
		nameColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new TreeViewAdapterFactoryLabelProvider(adapterFactory)));
		
		TreeViewerColumn assistedByColumn = new TreeViewerColumn(viewer, SWT.NONE);
		assistedByColumn.getColumn().setText("Assistant");
		assistedByColumn.getColumn().setWidth(100);
		assistedByColumn.getColumn().setAlignment(SWT.LEFT);
		assistedByColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnTwoRepositoryViewAdapterFactoryLabelProvider(adapterFactory)));
		
		TreeViewerColumn propertiesColumn = new TreeViewerColumn(viewer, SWT.NONE);
		propertiesColumn.getColumn().setText("Prop.");
		propertiesColumn.getColumn().setWidth(60);
		propertiesColumn.getColumn().setAlignment(SWT.LEFT);
		propertiesColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnPropertiesRepositoryViewAdapterFactoryLabelProvider(adapterFactory)));
		
		TreeViewerColumn refsColumn = new TreeViewerColumn(viewer, SWT.NONE);
		refsColumn.getColumn().setText("Refd By");
		refsColumn.getColumn().setWidth(60);
		refsColumn.getColumn().setAlignment(SWT.LEFT);
		refsColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnReferencesRepositoryViewAdapterFactoryLabelProvider(adapterFactory)));
		
		TreeViewerColumn uriColumn = new TreeViewerColumn(viewer, SWT.NONE);
		uriColumn.getColumn().setText("Uri");
		uriColumn.getColumn().setWidth(400);
		uriColumn.getColumn().setAlignment(SWT.LEFT);
		uriColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new ColumnThreeRepositoryViewAdapterFactoryLabelProvider(adapterFactory)));
		
		
		
		// Input
		
		viewer.setInput(AssistantManager.getInstance().getRepositoryManager());
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "extremo.ui.viewer");
		getSite().setSelectionProvider(viewer);
		getViewSite().setSelectionProvider(viewer);
		
		//int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		//Transfer[] transfers = new Transfer[]{TextTransfer.getInstance()};
		
		//DragSource source = new DragSource(viewer.getTree(), dndOperations);
		//source.setTransfer(transfers);
		//NamedElementDragListener listener = new NamedElementDragListener(viewer);
		//source.addDragListener(listener);
		
		callActions();
		callEditorsDrop();
		callFilters();
		
		makeActions();
		hookDoubleClickAction();
		contributeToActionBars();
	}
	
	private void callActions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.ACTION_EXTENSIONS_ID);
		
		MenuManager menumanager = new MenuManager("#PopupMenu");
		menumanager.setRemoveAllWhenShown(true);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("action") == 0){
				ExtensibleViewPartActionContribution action;
				
				try{
					action = (ExtensibleViewPartActionContribution) extension.createExecutableExtension("class");
					action.setText(extension.getAttribute("name"));
					action.setToolTipText(extension.getAttribute("description"));
					action.setEditorID(extension.getAttribute("editorId"));
					action.setViewer(viewer);
					
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
					
					if(descriptor != null) 
						action.setImageDescriptor(descriptor);
					
					if((action != null) 
							&& (extension.getAttribute("view")).equals("repositories")){
						IActionBars bars = getViewSite().getActionBars();
						
						if(extension.getAttribute("position").equals("toolbar")){
							bars.getToolBarManager().add(action);
						}
						
						if(extension.getAttribute("position").equals("menumanager")){
							IMenuListener listener = new IMenuListener() {
								 public void menuAboutToShow(IMenuManager m) {
									 m.add(action);
								 }
							};
							
							menumanager.addMenuListener(listener);		
						}
					}
				}
				catch(CoreException e){
					Activator.writeConsole(e.getMessage());
				}
			}	
		}
		
		Menu menu = menumanager.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menumanager, viewer);
	}

	private void callEditorsDrop(){
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
					ExtensibleGEFDragAndDropContribution graphityDrop;
					try{
						graphityDrop = (ExtensibleGEFDragAndDropContribution) extension.createExecutableExtension("class");
						graphicalViewer.addDropTargetListener(graphityDrop);
					}
					catch(CoreException e){
						Activator.writeConsole(e.getMessage());
					}
				}	
			}
		 }
	}
	
	private void callFilters() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.FILTER_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("filter") == 0){
				ViewerFilter filter;
				try{
					filter = (ViewerFilter) extension.createExecutableExtension("class");
					
					if((filter != null) && (extension.getAttribute("view")).equals("repositories")){
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
					Activator.writeConsole(e.getMessage());
				}
			}	
		}
	}
	
	private void hookPageSelection() {
		pageSelectionListener = new ISelectionListener() {
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				pageSelectionChanged(part, selection);
			}
		};
		
		getSite().getPage().addPostSelectionListener(pageSelectionListener);
	}
	
	protected void pageSelectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part == this)
			return;
		if (!(selection instanceof IStructuredSelection))
			return;
		
		IStructuredSelection sel = (IStructuredSelection) selection;
		viewer.setSelection(sel, true);
	}

	@Override
	public void dispose() {
		super.dispose();
			
		if (pageSelectionListener != null)
			   getSite().getPage().removePostSelectionListener(
			       pageSelectionListener);
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
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(addResourceToExistingRepository);
		manager.add(changeDescriptorToResource);
		manager.add(changeResourceToDescriptor);
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(addFolder);
		//manager.add(addLinkFromWeb);
	}

	private void makeActions() {
		addFolder = new Action() {
			public void run() {
			    IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			    
			    List<IProject> projectNatures = new ArrayList<IProject>(); 
			    
			    for (IProject project : projects) {
					try {
						if(project.isNatureEnabled(NATURE_ID)){
							projectNatures.add(project);
						}
					}
					catch (CoreException e) {
					}
				}
			    
			    if(projectNatures.isEmpty()){
					MessageDialog.openError(null, "Add Folder", "You have to create first an Extremo project");
			    }
			    else{
			    	WizardDialog wizardDialog = new WizardDialog(null, new AddFolderResourceListWizardDialog(projectNatures));
					if (wizardDialog.open() == Window.OK) {
						MessageDialog.openConfirm(null, "Add Folder", "Resources imported");
					}
					else{
						MessageDialog.openError(null, "Add Folder", "Resources could not be imported");
					}
			    }				
			}
		};
		
		addFolder.setText("Add Folder");
		addFolder.setToolTipText("");
		addFolder.setImageDescriptor(Activator.getImageDescriptor("icons/package.gif"));
		
		/*addLinkFromWeb = new Action() {
			public void run() {
			    List<IFormatAssistant> assistances = AssistantFactory.getInstance().getAssistances();
			    	WizardDialog wizardDialog = new WizardDialog(null, new AddResourceLinkWizardDialog(assistances));
				
			    	if (wizardDialog.open() == Window.OK) {
					MessageDialog.openConfirm(null, "Add Folder", "Resources imported");
				}
				else{
					MessageDialog.openError(null, "Add Link From Web", "Resources could not be imported");
				}
			}				
		};
		
		addLinkFromWeb.setText("Add Link From Web");
		addLinkFromWeb.setToolTipText("");
		addLinkFromWeb.setImageDescriptor(Activator.getImageDescriptor("icons/link-16.png"));*/
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

	private ExtendedPropertySheetPage propertyPage;
	
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IPropertySheetPage.class)) {
			if(propertyPage == null){
				AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(new SemanticmanagerAdapterFactory(), new BasicCommandStack());
				propertyPage = new ExtendedPropertySheetPage(editingDomain);
				propertyPage.setPropertySourceProvider(new AdapterFactoryContentProvider(new SemanticmanagerItemProviderAdapterFactory()));
			}
			
			return propertyPage;
		}
		
		return super.getAdapter(adapter);
	}
	
	@Override
	public Viewer getViewer() {
		return viewer;
	}
	
	@Override
	public void selectReveal(ISelection selection) {
		if (selection != null & selection instanceof IStructuredSelection) {
			Object firstselection = ((IStructuredSelection) selection).getFirstElement();

			if (firstselection != null){
				viewer.collapseAll();
				viewer.reveal(firstselection);
				viewer.setExpandedState(firstselection, true);
			}
		}
	}
	
	public void goToParent(NamedElement namedElement) {		
		if(((EObject) namedElement).eContainer() != null && ((EObject) namedElement).eContainer() instanceof NamedElement){
			viewer.collapseAll();
			NamedElement container = (NamedElement) ((EObject) namedElement).eContainer();
			
			for(NamedElement descriptor : container.getDescriptors()){
				viewer.reveal(descriptor);
				viewer.setExpandedState(descriptor, true);
			}
		}
		else{
			MessageDialog.openInformation(null, "Go To Parent", "There are no other entities containing " + namedElement.getName());
		}
	}
	
	public void goToType(NamedElement namedElement) {
		if(namedElement.getDescriptors().isEmpty()){
			MessageDialog.openInformation(null, "Go To Type", "There are no other entities in the descriptor list " + namedElement.getName());
		}
		else{
			viewer.collapseAll();
			
			for(NamedElement descriptor : namedElement.getDescriptors()){
				viewer.reveal(descriptor);
				viewer.setExpandedState(descriptor, true);
			}
		}
	}
	
	public void goToDomain(SemanticNode semanticNode) {
		if(semanticNode.getDomain().isEmpty()){
			MessageDialog.openInformation(null, "Go To Domain", "There are no other entities refering " + semanticNode.getName());
	    }
		else{
			viewer.collapseAll();
			
			for(ObjectProperty objectProperty : semanticNode.getDomain()){
				viewer.reveal(objectProperty);
				viewer.setExpandedState(objectProperty, true);
			}
	    }
	}
}
