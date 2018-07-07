package uam.extremo.core.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import uam.extremo.core.DataModelType;
import uam.extremo.core.ExtendedSemanticmanagerFactory;
import uam.extremo.core.ExtensiblePredicateBasedSearch;
import uam.extremo.core.ModelTypeParam;
import uam.extremo.core.ModelTypeParamValue;
import uam.extremo.core.PrimitiveTypeParam;
import uam.extremo.core.PrimitiveTypeParamValue;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.Service;
import uam.extremo.core.Type;
import uam.extremo.core.impl.PredicateBasedSearchImpl;

public class ExtensiblePredicateBasedSearchImpl extends PredicateBasedSearchImpl implements ExtensiblePredicateBasedSearch {
	public static final String SERVICE_EXTENSIONS_ID = "extremo.core.extensions.services";
	
	public void addPrimitiveTypeSearchOption(String id, String name, Type type) {
		PrimitiveTypeParam searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createPrimitiveTypeParam();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
	
	public void addDataModelTypeSearchOption(String id, String name, DataModelType type) {
		ModelTypeParam searchOption = ExtendedSemanticmanagerFactory.eINSTANCE.createModelTypeParam();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		
		getOptions().add(searchOption);
	}
	
	public Object getOptionValueKey(String key, EList<SearchParamValue> inps) {
		for(SearchParamValue value : inps){
			if (value instanceof PrimitiveTypeParamValue) {
				PrimitiveTypeParamValue stringValue = (PrimitiveTypeParamValue) value;
				
				try{
					if(stringValue.getOption().getId().equals(key)){						
						return stringValue.getValue();
					}
				}
				catch(Exception e){
					return null;
				}
			}
			
			if (value instanceof ModelTypeParamValue) {
				ModelTypeParamValue dataModelValue = (ModelTypeParamValue) value;
				
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
		if(name == null) return false;
		Service serviceBundle = callServiceExtension(service.getId());
		if(serviceBundle != null) return serviceBundle.matches(valuefieldString, name);
		else return false;
	}
	
	public SearchParamValue getOptionValue(String key, EList<SearchParamValue> inps) {
		for(SearchParamValue value : inps){
			if (value instanceof PrimitiveTypeParamValue) {
				PrimitiveTypeParamValue stringValue = (PrimitiveTypeParamValue) value;
				
				try{
					if(stringValue.getOption().getId().equals(key)){						
						return stringValue;
					}
				}
				catch(Exception e){
					return null;
				}
			}
			
			if (value instanceof ModelTypeParamValue) {
				ModelTypeParamValue dataModelValue = (ModelTypeParamValue) value;
				
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
