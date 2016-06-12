package metardf.core.extensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import metaRDF.core.model.IDataProperty;
import metaRDF.core.model.IObjectProperty;
import metaRDF.core.model.IRepository;
import metaRDF.core.model.IResource;
import metaRDF.core.model.ISearch;
import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.ISemanticElement;
import metaRDF.core.model.impl.RepositoryManager;
import metaRDF.core.model.impl.Search;
import metaRDF.core.model.impl.SemanticResource;

public class AssistantFactory {
	private List<IFormatAssistant> assistants = null;
	private List<ISearch> searches = null;
	
	private static AssistantFactory INSTANCE = null;
	
	public static final String ASSISTANT_EXTENSIONS_ID = "metardf.core.extensions.assistant";
	
	Map<Bundle, List<Class<? extends ISemanticElement>>> registeredTypes = null;

	public List<IFormatAssistant> getAssistances(){
		if (this.assistants == null) {
			this.assistants = new ArrayList<IFormatAssistant>();
			this.searches = new ArrayList<ISearch>();
			this.registeredTypes = new HashMap<Bundle, List<Class<? extends ISemanticElement>>>();
		}
		
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(ASSISTANT_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(!isOnTheList(extension.getAttribute("id"))){
				if(extension.getName().compareTo("assistant") == 0){
					IFormatAssistant assistant;
					
					Bundle bundle = null;
					IContributor contributor = extension.getContributor();

					if (contributor instanceof RegistryContributor) {
					  long id = Long.parseLong(((RegistryContributor) contributor).getActualId());
					  Bundle thisBundle = FrameworkUtil.getBundle(getClass());
					  bundle = thisBundle.getBundleContext().getBundle(id);
					} else {
					  bundle = Platform.getBundle(contributor.getName());          
					}
					
					try{
						if(extension.createExecutableExtension("class") instanceof IFormatAssistant){
							assistant = (IFormatAssistant) extension.createExecutableExtension("class");
							
							if (assistant instanceof IFormatAssistant) {
						        callToRegisterTypes(bundle, assistant);
						    }
							
							((FormatAssistant)assistant).setId(extension.getAttribute("id"));
							((FormatAssistant)assistant).setNameExtension(extension.getAttribute("name"));
							
							String extensionsAttribute = StringUtils.deleteWhitespace(extension.getAttribute("extensions"));
							String[] extensionsSeparated = StringUtils.splitByWholeSeparator(extensionsAttribute, ",");
							
							for(String s : extensionsSeparated){
								((FormatAssistant)assistant).addExtension(s);
							}
							
							this.assistants.add(assistant);
						}
					}
					catch(CoreException e){
					}
				}
			}		
		}
		
		return this.assistants;
	}
	
	private boolean isOnTheList(String attribute) {
		for(IFormatAssistant assistant : assistants){
			if(assistant instanceof FormatAssistant){
				if(((FormatAssistant) assistant).getId().compareTo(attribute)==0) return true;
			}
		}
		return false;
	}

	private static void createInstance() {
   	 if (INSTANCE == null) {
            synchronized(AssistantFactory.class) {
                if (INSTANCE == null) { 
                    INSTANCE = new AssistantFactory();
                }
            }
        }
   }

   public static AssistantFactory getInstance() {
       if (INSTANCE == null){
       	createInstance();
       }
       return INSTANCE;
   }
   
   public Object clone() throws CloneNotSupportedException {
   	throw new CloneNotSupportedException(); 
   }
   
   private void callToRegisterTypes(final Bundle bundle, final Object o) {
	   ISafeRunnable runnable = new ISafeRunnable() {
		   @Override
		   public void handleException(Throwable e) {
			   System.out.println("Exception in client saferunnable");
		   }
		   
		   @Override
		   public void run() throws Exception {
			   List<Class<? extends ISemanticElement>> types = ((IFormatAssistant) o).getRegisteredTypes();
			   if(types != null) addRegisteredTypes(bundle, types);
		   }
		};
		SafeRunner.run(runnable);
	}
   
   public boolean addRegisteredTypes(Bundle bundle, List<Class<? extends ISemanticElement>> registeredTypes){
	   if(registeredTypes != null){
		   this.registeredTypes.put(bundle, registeredTypes);
		   return true;
	   }
	   return false;
   }
   
	public Map<Bundle, List<Class<? extends ISemanticElement>>> getRegisteredTypes() {
		return registeredTypes;
	}
	
	public void setRegisteredTypes(Map<Bundle, List<Class<? extends ISemanticElement>>> registeredTypes) {
		this.registeredTypes = registeredTypes;
	}
	
	public List<ISearch> getSearches() {
		return searches;
	}

	public void setSearches(List<ISearch> searches) {
		this.searches = searches;
	}
	
	private void addSearch(ISearch search){
		if(this.searches == null) this.searches = new ArrayList<ISearch>();
		this.searches.add(search);
	}

	public static void completeSemanticClassProperties(IFormatAssistant assistant, ISemanticClass entity){
		List<ISemanticClass> superclasses = assistant.getSuper(entity, false);
		((ISemanticClass) entity).setSuperclasses(superclasses);
		List<ISemanticClass> subclasses = assistant.getSub(entity, false);
		((ISemanticClass) entity).setSubclasses(subclasses);
		List<IObjectProperty> references = assistant.getObjectProperties(entity, true, true);
		((ISemanticClass) entity).setReferences(references);
		List<IDataProperty> properties = assistant.getDataProperties(entity, true, true);
		((ISemanticClass) entity).setProperties(properties);
	}
	
	public static void completeSemanticClassProperties(IFormatAssistant assistant, ISemanticClass entity, ISearch search){
		List<ISemanticClass> superclasses = assistant.getSuper(entity, false);
		((ISemanticClass) entity).setSuperclasses(superclasses);
		List<ISemanticClass> subclasses = assistant.getSub(entity, false);
		((ISemanticClass) entity).setSubclasses(subclasses);
		List<IObjectProperty> references = assistant.getObjectProperties(entity, search.isFromSupers(), search.isFromEquivs());
		((ISemanticClass) entity).setReferences(references);
		List<IDataProperty> properties = assistant.getDataProperties(entity, search.isFromSupers(), search.isFromEquivs());
		((ISemanticClass) entity).setProperties(properties);
	}

	
	public List<ISemanticClass> search(RepositoryManager repositoryManager, Search search) {
		addSearch(search);	
		search.expand();
		
		Map<String, Integer> searchList = search.getOrderSearchesListByWeight();
		List<ISemanticClass> semanticClasses = new ArrayList<ISemanticClass>();
		
		for(IRepository repository : repositoryManager.getRepositories()){
			for(IResource resource : repository.getResources()){
				if((resource instanceof SemanticResource) && (resource.isActive())){
					search.getResourcesSearched().add(resource);
					
					for(IFormatAssistant assistant : assistants){
						if((resource.isAlive()) && (resource.getAssistant() != null)){
							if(((FormatAssistant)assistant).getNameExtension().compareTo(resource.getAssistant())==0){
								if((resource != null) && (resource instanceof SemanticResource) && (assistant.load((SemanticResource) resource))){	
									assistant.getAllClasses();
									List<ISemanticClass> entities = assistant.getClassesLike(searchList);
									
									for(ISemanticClass entity : entities){
										AssistantFactory.completeSemanticClassProperties(assistant, entity, search);
										semanticClasses.add(entity);
									}
								}
							}
						}
					}
				}	
			}		
		}
		
		return semanticClasses;
	}
}
