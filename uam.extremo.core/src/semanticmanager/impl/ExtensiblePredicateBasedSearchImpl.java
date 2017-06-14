package semanticmanager.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import semanticmanager.DataModelType;
import semanticmanager.DataModelTypeSearchOption;
import semanticmanager.DataModelTypeSearchResultOptionValue;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.ExtensiblePredicateBasedSearch;
import semanticmanager.PrimitiveTypeSearchOption;
import semanticmanager.PrimitiveTypeSearchResultOptionValue;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.Service;
import semanticmanager.Type;
import semanticmanager.impl.PredicateBasedSearchImpl;

public class ExtensiblePredicateBasedSearchImpl extends PredicateBasedSearchImpl implements ExtensiblePredicateBasedSearch {
	public static final String SERVICE_EXTENSIONS_ID = "extremo.core.extensions.services";
	
	public void addPrimitiveTypeSearchOption(String id, String name, Type type) {
		PrimitiveTypeSearchOption searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createPrimitiveTypeSearchOption();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
	
	public void addDataModelTypeSearchOption(String id, String name, DataModelType type) {
		DataModelTypeSearchOption searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createDataModelTypeSearchOption();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
	
	public Object getOptionValueKey(String key, EList<SearchResultOptionValue> inps) {
		for(SearchResultOptionValue value : inps){
			if (value instanceof PrimitiveTypeSearchResultOptionValue) {
				PrimitiveTypeSearchResultOptionValue stringValue = (PrimitiveTypeSearchResultOptionValue) value;
				
				try{
					if(stringValue.getOption().getId().equals(key)){						
						return stringValue.getValue();
					}
				}
				catch(Exception e){
					return null;
				}
			}
			
			if (value instanceof DataModelTypeSearchResultOptionValue) {
				DataModelTypeSearchResultOptionValue dataModelValue = (DataModelTypeSearchResultOptionValue) value;
				
				try{
					if(dataModelValue.getOption().getId().equals(key)){
						return dataModelValue.getValue();
					}
				}
				catch(Exception e){
					return null;
				}
			}
		}
		return null;
	}
	
	public boolean callService(Service service, String valuefieldString, String name) {
		Service serviceBundle = callServiceExtension(service.getId());
		return serviceBundle.matches(valuefieldString, name);
	}
	
	public SearchResultOptionValue getOptionValue(String key, EList<SearchResultOptionValue> inps) {
		for(SearchResultOptionValue value : inps){
			if (value instanceof PrimitiveTypeSearchResultOptionValue) {
				PrimitiveTypeSearchResultOptionValue stringValue = (PrimitiveTypeSearchResultOptionValue) value;
				
				try{
					if(stringValue.getOption().getId().equals(key)){						
						return stringValue;
					}
				}
				catch(Exception e){
					return null;
				}
			}
			
			if (value instanceof DataModelTypeSearchResultOptionValue) {
				DataModelTypeSearchResultOptionValue dataModelValue = (DataModelTypeSearchResultOptionValue) value;
				
				try{
					if(dataModelValue.getOption().getId().equals(key)){
						return dataModelValue;
					}
				}
				catch(Exception e){
					return null;
				}
			}
		}
		return null;
	}
	
	private Service callServiceExtension(String idService){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(SERVICE_EXTENSIONS_ID);
		
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
			
            if (extension.getAttribute("id").equals(idService)) {
            	Object o;
				try {
					o = extension.createExecutableExtension("class");
					if (o instanceof Service) {
						Service service = (Service) o;
	                    return service;
	                }
				} catch (CoreException e) {
					return null;
				}
            }
		}
		
		return null;
	}
}
