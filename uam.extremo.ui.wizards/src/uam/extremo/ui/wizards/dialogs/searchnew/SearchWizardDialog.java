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
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import semanticmanager.AtomicSearchResult;
import semanticmanager.CustomSearch;
import semanticmanager.DataModelTypeSearchOption;
import semanticmanager.DataModelTypeSearchResultOptionValue;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.NamedElement;
import semanticmanager.PredicateBasedSearch;
import semanticmanager.PrimitiveTypeSearchOption;
import semanticmanager.PrimitiveTypeSearchResultOptionValue;
import semanticmanager.Repository;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchOption;
import semanticmanager.SearchResult;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.Service;
import semanticmanager.SimpleSearchConfiguration;
import uam.extremo.extensions.AssistantFactory;

public class SearchWizardDialog extends Wizard{
	public static final String SEARCH_EXTENSIONS_ID = "extremo.core.extensions.search";	
	
	SearchConfigurationSelectorWizardPage searchPage = null;
	
	NamedElementSelectionWizardPage namedElementSelectionPage;
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
			if(searchPage.getDescriptor() != null) ((AtomicSearchResult) searchResult).setDescriptor(searchPage.getDescriptor());
		}
		else{
			// Custom Search
			CustomSearch customSearch = (CustomSearch) searchConfigurationSelected;
			
			if(customSearch.isGrouped()){
				searchResult = ExtendedSemanticmanagerFactory.eINSTANCE.createGroupedSearchResult();
				searchResult.setConfiguration(customSearch);
				
				/*EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(searchConfigurationSelected);
				Command command = AddCommand.create(editingDomain, customSearch,
						SemanticmanagerPackage.eINSTANCE.getSearchConfiguration_Results(), searchResult);
				editingDomain.getCommandStack().execute(command);*/
			}
			else{
				searchResult = ExtendedSemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
				searchResult.setConfiguration(customSearch);
				
				/*EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(searchConfigurationSelected);
				Command command = AddCommand.create(editingDomain, customSearch,
				SemanticmanagerPackage.eINSTANCE.getSearchConfiguration_Results(), searchResult);
				editingDomain.getCommandStack().execute(command);*/
			}
		}
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					Map<SearchOption, Object> searchOptionStringValues = searchPage.getValues();
					for(java.util.Map.Entry<SearchOption, Object> entry : searchOptionStringValues.entrySet()){
						if (entry.getKey() instanceof PrimitiveTypeSearchOption) {
							PrimitiveTypeSearchOption primitiveTypeSearchOption = (PrimitiveTypeSearchOption) entry.getKey();
							
							PrimitiveTypeSearchResultOptionValue primitiveTypeSearchResultOptionValue = ExtendedSemanticmanagerFactory.eINSTANCE.createPrimitiveTypeSearchResultOptionValue();
							primitiveTypeSearchResultOptionValue.setOption(primitiveTypeSearchOption);
							primitiveTypeSearchResultOptionValue.setValue(entry.getValue().toString());
							searchResult.getValues().add(primitiveTypeSearchResultOptionValue);
						}
						
						if (entry.getKey() instanceof DataModelTypeSearchOption) {
							DataModelTypeSearchOption dataModelTypeSearchOption = (DataModelTypeSearchOption) entry.getKey();
							
							DataModelTypeSearchResultOptionValue dataModelTypeSearchResultOptionValue = ExtendedSemanticmanagerFactory.eINSTANCE.createDataModelTypeSearchResultOptionValue();
							dataModelTypeSearchResultOptionValue.setOption(dataModelTypeSearchOption);
							dataModelTypeSearchResultOptionValue.setValue((NamedElement) entry.getValue());
							searchResult.getValues().add(dataModelTypeSearchResultOptionValue);
						}
					}
					
					doFinish(monitor, searchResult, searchConfigurationSelected);									
				}
				finally {
					monitor.done();
				}
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
		
		return true;
	}
	
	public void doFinish(IProgressMonitor monitor, 
			SearchResult searchResult, 
			SearchConfiguration searchConfigurationSelected){
		
		if (searchConfigurationSelected instanceof CustomSearch) {
			CustomSearch customSearch = (CustomSearch) searchConfigurationSelected;
			CustomSearch customSearchBundle = callCustomSearchExtension(customSearch.getId());
			customSearchBundle.search(searchResult);
		}
			
		if (searchConfigurationSelected instanceof PredicateBasedSearch) {
			PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfigurationSelected;
			
			if (searchResult instanceof AtomicSearchResult) {
				AtomicSearchResult atomicSearchResult = (AtomicSearchResult) searchResult;				
				atomicSearchResult.getApplyOnElements().addAll(atomicSearchResult.getDescriptor().getDescribes());
				
				PredicateBasedSearch predicateBasedSearchBundle = callPredicateBasedSearchExtension(predicateBasedSearch.getId());
				for(NamedElement namedElement : atomicSearchResult.getApplyOnElements()){
					boolean matches = predicateBasedSearchBundle.matches(namedElement, atomicSearchResult.getValues());
					
					if(matches){
						atomicSearchResult.getElements().add(namedElement);
					}
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
