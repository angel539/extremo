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
package uam.extremo.ui.views.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import semanticmanager.provider.SemanticmanagerItemProviderAdapterFactory;
import semanticmanager.util.SemanticmanagerAdapterFactory;
import uam.extremo.ui.views.searchtree.TreeViewAdapterFactoryLabelProvider;
import uam.extremo.extensions.AssistantManager;
import uam.extremo.ui.Activator;
import uam.extremo.ui.extensions.integration.ExtensibleGEFDragAndDropContribution;
import uam.extremo.ui.extensions.integration.ExtensibleViewPartActionContribution;

public class ConstraintValidationViewPart extends ViewPart implements IViewerProvider, ISelectionProvider, ITabbedPropertySheetPageContributor, ISetSelectionTarget{
	public static final String ID = "uam.extremo.ui.views.ConstraintInterpreters";
	
	public static TreeViewer viewer;
	protected ISelection editorSelection = StructuredSelection.EMPTY;
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();
	protected List<PropertySheetPage> propertySheetPages = new ArrayList<PropertySheetPage>();
	protected ComposedAdapterFactory adapterFactory;
	List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
	
	TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(
            "uam.extremo.extensions.ExtremoEditingDomain");
	
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	@Override
	public void createPartControl(Composite parent) {		
		PatternFilter patternfilter = new PatternFilter();
		FilteredTree tree = new FilteredTree(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL, patternfilter, true);
		
		viewer = tree.getViewer();	
		
		ConstraintValidationViewFilter filter = new ConstraintValidationViewFilter();
		ViewerFilter[] filters = {filter};
		viewer.setFilters(filters);
		
		new DrillDownAdapter(viewer);
		
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new SemanticmanagerItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		
		adapterFactory = new ComposedAdapterFactory(factories);
		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(adapterFactory);
		viewer.setContentProvider(contentProvider);
		
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new TreeViewAdapterFactoryLabelProvider(adapterFactory)));		  
		viewer.setInput(AssistantManager.getInstance().getRepositoryManager());

		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "extremo.ui.viewer");
		getSite().setSelectionProvider(viewer);
		getViewSite().setSelectionProvider(viewer);
		//int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		//Transfer[] transfers = new Transfer[]{TextTransfer.getInstance()};
		
		//DragSource source = new DragSource(viewer.getTree(), dndOperations);
		//source.setTransfer(transfers);	
		callActions();
		callEditorsDrop();
		callFilters();
	}
	
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException(); 
	}
	
	private void callActions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(Activator.ACTION_EXTENSIONS_ID);
		
		MenuManager menumanager = new MenuManager("#PopupMenu");
		menumanager.setRemoveAllWhenShown(true);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("action")==0){
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
							&& (extension.getAttribute("view")).equals("constraints")){
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
			if(extension.getName().compareTo("filter")==0){
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
}
