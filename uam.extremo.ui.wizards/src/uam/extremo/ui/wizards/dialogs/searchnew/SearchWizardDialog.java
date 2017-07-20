package uam.extremo.ui.wizards.dialogs.searchnew;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import semanticmanager.AtomicSearchResult;
import semanticmanager.CustomSearch;
import semanticmanager.DataProperty;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.ModelTypeParam;
import semanticmanager.ModelTypeParamValue;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.PredicateBasedSearch;
import semanticmanager.PrimitiveTypeParam;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.Property;
import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchParam;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.Service;
import semanticmanager.SimpleSearchConfiguration;
import uam.extremo.extensions.AssistantFactory;

public class SearchWizardDialog extends Wizard{
	public static final String SEARCH_EXTENSIONS_ID = "extremo.core.extensions.search";	
	
	SearchConfigurationSelectorWizardPage searchPage = null;
	
	List<SimpleSearchConfiguration> searchConfigurations;
	List<Service> services;
	
	SearchResult searchResult;
	NamedElement namedElement;
	Repository repositoryFrom;
	
	public SearchWizardDialog(Repository repositoryFrom, NamedElement namedElement){
		super();
		setNeedsProgressMonitor(true);
		this.repositoryFrom = repositoryFrom; 
		this.namedElement = namedElement;
		this.searchConfigurations = AssistantFactory.getInstance().getSearches()
											.stream().filter(ssc -> ssc instanceof SimpleSearchConfiguration)
										    .map (ssc -> (SimpleSearchConfiguration) ssc)
										    .collect(Collectors.toList());
		this.services = AssistantFactory.getInstance().getServices();		
		searchPage = new SearchConfigurationSelectorWizardPage("Search", "Select a search configuration from the query catalogue", searchConfigurations, services, repositoryFrom, namedElement);
	}
	
	@Override
	public String getWindowTitle() {
	    return "Searching...";
	}
	
	public void addPages(){
		addPage(searchPage);
	}
	
	@Override
	public boolean performFinish() {
		SimpleSearchConfiguration searchConfigurationSelected = searchPage.getSearchConfigurationSelected();
		
		if (searchConfigurationSelected instanceof PredicateBasedSearch) {
			PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfigurationSelected;
			searchResult = ExtendedSemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
			searchResult.setConfiguration(predicateBasedSearch);
		}
		else{
			// Custom Search
			CustomSearch customSearch = (CustomSearch) searchConfigurationSelected;
			
			if(customSearch.isGrouped()){
				searchResult = ExtendedSemanticmanagerFactory.eINSTANCE.createGroupedSearchResult();
				searchResult.setConfiguration(customSearch);
			}
			else{
				searchResult = ExtendedSemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
				searchResult.setConfiguration(customSearch);
			}
		}
		
		Map<SearchParam, Object> searchOptionStringValues = searchPage.getValues();
		Map<SearchParam, Service> searchOptionServiceCalling = searchPage.getServiceCalls();
		
		for(java.util.Map.Entry<SearchParam, Object> entry : searchOptionStringValues.entrySet()){
			if (entry.getKey() instanceof PrimitiveTypeParam) {
				PrimitiveTypeParam primitiveTypeSearchOption = (PrimitiveTypeParam) entry.getKey();
				
				PrimitiveTypeParamValue primitiveTypeSearchResultOptionValue = ExtendedSemanticmanagerFactory.eINSTANCE.createPrimitiveTypeParamValue();
				primitiveTypeSearchResultOptionValue.setOption(primitiveTypeSearchOption);
				primitiveTypeSearchResultOptionValue.setValue(entry.getValue().toString());
				
				Service service = searchOptionServiceCalling.get(entry.getKey());
				primitiveTypeSearchResultOptionValue.setCalls(service);
				
				searchResult.getValues().add(primitiveTypeSearchResultOptionValue);
			}
			
			if (entry.getKey() instanceof ModelTypeParam) {
				ModelTypeParam dataModelTypeSearchOption = (ModelTypeParam) entry.getKey();
				
				ModelTypeParamValue dataModelTypeSearchResultOptionValue = ExtendedSemanticmanagerFactory.eINSTANCE.createModelTypeParamValue();
				dataModelTypeSearchResultOptionValue.setOption(dataModelTypeSearchOption);
				dataModelTypeSearchResultOptionValue.setValue((NamedElement) entry.getValue());
				searchResult.getValues().add(dataModelTypeSearchResultOptionValue);
			}
		}
		
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
					doFinish(monitor, searchResult, searchConfigurationSelected);		
					monitor.done();
			}
		};
		try {
			getContainer().run(true, false, op);
		}
		catch (InterruptedException e) {
			return false;
		}
		catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		
		IViewPart view = page.findView("uam.extremo.ui.views.SearchTree");
		
		if (view instanceof ISetSelectionTarget) {
			ISelection selection = new StructuredSelection(searchResult);
			((ISetSelectionTarget) view).selectReveal(selection);
		}
					
		
		return true;
	}
	
	public void doFinish(IProgressMonitor monitor, 
			SearchResult searchResult, 
			SearchConfiguration searchConfigurationSelected){
		
		if (searchConfigurationSelected instanceof CustomSearch) {
			CustomSearch customSearch = (CustomSearch) searchConfigurationSelected;
			CustomSearch customSearchBundle = callCustomSearchExtension(customSearch.getId());
			
			composeApplyOnElementsList(customSearch.getFilterBy().getLiteral(), searchResult);
			customSearchBundle.search(searchResult);
		}
			
		if (searchConfigurationSelected instanceof PredicateBasedSearch) {
			PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfigurationSelected;
			
			if (searchResult instanceof AtomicSearchResult) {
				AtomicSearchResult atomicSearchResult = (AtomicSearchResult) searchResult;
				PredicateBasedSearch predicateBasedSearchBundle = callPredicateBasedSearchExtension(predicateBasedSearch.getId());
				
				composeApplyOnElementsList(predicateBasedSearch.getFilterBy().getLiteral(), searchResult);	
				
				try {
					for(NamedElement e : atomicSearchResult.getApplyOnElements()){
						if(e != null){
							boolean matches = predicateBasedSearchBundle.matches(e, atomicSearchResult.getValues());
							
							if(matches){
								atomicSearchResult.getElements().add(e);
							}
						}
					}
				} catch (Exception e) {
					System.out.println("aqui se mete por una excepcion...");
					e.printStackTrace();
				}
			}	
		}
	}
	
	private void composeApplyOnElementsList(String filterBy, SearchResult searchResult){
		for(Resource resource : repositoryFrom.getResources())
			preorder(filterBy, resource, searchResult);
	}
	
	public synchronized void preorder(String filterBy, Resource resource, SearchResult searchResult){
		switch(filterBy){
			case "Resource":
				preorderHelperResource(resource, searchResult);
				break;
			case "SemanticNode":
				preorderHelperSemanticNode(resource, searchResult);
				break;
			case "DataProperty":
				preorderHelperDataProperty(resource, searchResult);
				break;
			case "ObjectProperty":
				preorderHelperObjectProperty(resource, searchResult);
				break;
			default:
				break;
		}
    }
     
    private void preorderHelperResource(ResourceElement node, SearchResult searchResult)
    {
        if(node == null)
            return;
        
        if(node instanceof Resource){
        	searchResult.getApplyOnElements().add(node);
        	
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelperResource(resourceElement, searchResult);
        }
    }
    
    private void preorderHelperSemanticNode(ResourceElement node, SearchResult searchResult)
    {
        if(node == null)
            return;
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelperSemanticNode(resourceElement, searchResult);
        }
        
        if(node instanceof SemanticNode){
			searchResult.getApplyOnElements().add(node);
        }
    }
    
    private void preorderHelperDataProperty(ResourceElement node, SearchResult searchResult)
    {
        if(node == null)
            return;
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelperDataProperty(resourceElement, searchResult);
        }
        
        if(node instanceof SemanticNode){
        	for(Property property : ((SemanticNode) node).getProperties()){
        		if (property instanceof DataProperty) {
					DataProperty dataProperty = (DataProperty) property;
					searchResult.getApplyOnElements().add(dataProperty);
				}
        	}
        }
    }
    
    private void preorderHelperObjectProperty(ResourceElement node, SearchResult searchResult)
    {
        if(node == null)
            return;
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelperObjectProperty(resourceElement, searchResult);
        }
        
        if(node instanceof SemanticNode){
        	for(Property property : ((SemanticNode) node).getProperties()){
        		if (property instanceof ObjectProperty) {
					ObjectProperty dataProperty = (ObjectProperty) property;
					searchResult.getApplyOnElements().add(dataProperty);
				}
        	}
        }
    }
	
	private PredicateBasedSearch callPredicateBasedSearchExtension(String idPredicateBasedSearch){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(SEARCH_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			Bundle bundle = null;
			IContributor contributor = extension.getContributor();
			
			if (contributor instanceof RegistryContributor) {
				long id = Long.parseLong(((RegistryContributor) contributor).getActualId());
				Bundle thisBundle = FrameworkUtil.getBundle(getClass());
				bundle = thisBundle.getBundleContext().getBundle(id);
			}
			else {
				bundle = Platform.getBundle(contributor.getName());          
			}
			
            if (extension.getAttribute("id").equals(idPredicateBasedSearch)) {
            	Object o;
				try {
					o = extension.createExecutableExtension("class");
					if (o instanceof PredicateBasedSearch) {
	                    PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) o;
	                    return predicateBasedSearch;
	                }
				} catch (CoreException e) {
					return null;
				}
            }
		}
		
		return null;
	}
	
	private CustomSearch callCustomSearchExtension(String idCustomSearch){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(SEARCH_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			Bundle bundle = null;
			IContributor contributor = extension.getContributor();
			
			if (contributor instanceof RegistryContributor) {
				long id = Long.parseLong(((RegistryContributor) contributor).getActualId());
				Bundle thisBundle = FrameworkUtil.getBundle(getClass());
				bundle = thisBundle.getBundleContext().getBundle(id);
			}
			else {
				bundle = Platform.getBundle(contributor.getName());          
			}
			
            if (extension.getAttribute("id").equals(idCustomSearch)) {
            	Object o;
				try {
					o = extension.createExecutableExtension("class");
					if (o instanceof CustomSearch) {
	                    CustomSearch customSearch = (CustomSearch) o;
	                    return customSearch;
	                }
				} catch (CoreException e) {
					return null;
				}
            }
		}
		
		return null;
	}
}
