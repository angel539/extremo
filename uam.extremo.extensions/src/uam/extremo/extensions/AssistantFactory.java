package uam.extremo.extensions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import semanticmanager.NamedElement;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;
import semanticmanager.Search;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.TreeNode;
import semanticmanager.Type;
import semanticmanager.impl.SemanticmanagerPackageImpl;
import uam.extremo.core.utils.LangUtils;
import uam.extremo.extensions.wizard.PathSelectorWizardDialog;

public class AssistantFactory {
	public static final String ASSISTANT_EXTENSIONS_ID = "extremo.core.extensions.assistant";
	public static final String SEARCH_EXTENSIONS_ID = "extremo.core.extensions.search";
	
	private static AssistantFactory INSTANCE = null;
	private static RepositoryManager repositoryManager;
	private static List<IFormatAssistant> assistants = null;
	//private static List<SearchConfiguration> searches = null;
	
	private static NamedElement drawnElement = null;

	public List<IFormatAssistant> getAssistances(){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(ASSISTANT_EXTENSIONS_ID);

		for(IConfigurationElement extension : extensions){
			if(!assistantIsOnTheList(extension.getAttribute("id"))){
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
							
							((FormatAssistant)assistant).setId(extension.getAttribute("id"));
							((FormatAssistant)assistant).setNameExtension(extension.getAttribute("name"));
							
							String extensionsAttribute = StringUtils.deleteWhitespace(extension.getAttribute("extensions"));
							String[] extensionsSeparated = StringUtils.splitByWholeSeparator(extensionsAttribute, ",");
							
							for(String s : extensionsSeparated){
								((FormatAssistant)assistant).addExtension(s);
							}
							
							assistants.add(assistant);
						}
					}
					catch(CoreException e){
					}
				}
			}		
		}
		
		return assistants;
	}
	
	public static void setAssistants(List<IFormatAssistant> assistants) {
		AssistantFactory.assistants = assistants;
	}
	
	private boolean assistantIsOnTheList(String attribute) {
		for(IFormatAssistant assistant : assistants){
			if(assistant instanceof FormatAssistant){
				if(((FormatAssistant) assistant).getId().compareTo(attribute)==0) return true;
			}
		}
		return false;
	}
	
	public List<SearchConfiguration> getSearches() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(SEARCH_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(!searchIsOnTheList(extension.getAttribute("id"))){
				if(extension.getName().compareTo("search") == 0){
					SearchConfiguration searchConfiguration;
					
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
					
					try{
						if(extension.createExecutableExtension("class") instanceof SearchConfiguration){
							searchConfiguration = (SearchConfiguration) extension.createExecutableExtension("class");
							
							((SearchConfiguration)searchConfiguration).setId(extension.getAttribute("id"));
							((SearchConfiguration)searchConfiguration).setName(extension.getAttribute("name"));
							
							for(IConfigurationElement option : extension.getChildren("option")){
								String id = option.getAttribute("id");
								String name = option.getAttribute("name");
								String type = option.getAttribute("type");
								
								searchConfiguration.addSearchOption(id, name, Type.get(type));
							}
							
							repositoryManager.getConfigurations().add(searchConfiguration);
							//searches.add(searchConfiguration);
						}
					}
					catch(CoreException e){
					}
				}
			}		
		}
		
		return repositoryManager.getConfigurations();
	}
	
	private boolean searchIsOnTheList(String attribute) {
		for(SearchConfiguration search : repositoryManager.getConfigurations()){
			if(search instanceof SearchConfiguration){
				if(((SearchConfiguration) search).getId().compareTo(attribute)==0) return true;
			}
		}
		return false;
	}

	private static void createInstance() {
   	 if (INSTANCE == null) {
            synchronized(AssistantFactory.class) {
                if (INSTANCE == null) { 
                    INSTANCE = new AssistantFactory();
                    SemanticmanagerPackageImpl.init();
                    SemanticmanagerPackage.eINSTANCE.getClass();
                    setRepositoryManager(SemanticmanagerFactory.eINSTANCE.createRepositoryManager());
                    setAssistants(new ArrayList<IFormatAssistant>());
                    //setSearches(new ArrayList<SearchConfiguration>());
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

	
	public void putAllResourceToNotActive(){
		for(Repository repository : repositoryManager.getRepositories()){
			for(Resource resource : repository.getResources()){
				resource.setActive(false);
			}
		}
	}
	
	public void putAllNamedElementToNotDrawable(){
		TreeIterator<EObject> iterator = repositoryManager.eAllContents();
		
		while(iterator.hasNext()){
			EObject eobject = iterator.next();
			
			if(eobject instanceof NamedElement){
				((NamedElement) eobject).setDrawn(false);
			}
		}
	}
	
	public void putAllNamedElementToNotDrawable(NamedElement element){
		element.setDrawn(false);
	}
	
	public NamedElement getDrawnElement() {
		return drawnElement;
	}

	public void setDrawnElement(NamedElement drawnElement) {
		AssistantFactory.drawnElement = drawnElement;
	}
	
	public void search(SearchResult search) {
		search.getConfiguration().resolveOptions(search.getValues());
		search.getConfiguration().search(search);
	}

	public RepositoryManager getRepositoryManager() {
		return repositoryManager;
	}

	public static void setRepositoryManager(RepositoryManager repositoryManager) {
		AssistantFactory.repositoryManager = repositoryManager;
	}
	
	public Repository createRepository(String name, String description){
		Repository repository = SemanticmanagerFactory.eINSTANCE.createRepository();
		repository.setName(name);
		repository.setDescription(description);
		
		repositoryManager.getRepositories().add(repository);
		return repository;
	}
	
	public Resource createResourceDescriptor(Repository repository, String name, String description, String uri){
		Resource resource = SemanticmanagerFactory.eINSTANCE.createResource();
		resource.setName(name);
		resource.setDescription(description);
		resource.setUri(uri);
		
		String extensionFile = FilenameUtils.getExtension(uri);
		loop: 
		for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
			for(String ext : ((FormatAssistant) assistant).getExtensions()){
				if(extensionFile.compareTo(ext) == 0){
					resource.setAssistant(((FormatAssistant) assistant).getNameExtension());
					resource.setAlive(assistant.load(resource));
					
					boolean loaded = assistant.load((Resource) resource);
					
					if(loaded){
						for(SemanticNode node : resource.getNodes()){
							assistant.toDataProperty(node);
							assistant.toObjectProperty(node);
							assistant.toSuper(node);
							assistant.toSub(node);
						}
					}
					break loop;
				}
			}
		}
		
		repository.getResources().add(resource);
		return resource;
	}
	
	public Resource createResource(Resource descriptor, String name, String description, String uri){
		Resource resource = SemanticmanagerFactory.eINSTANCE.createResource();
		resource.setName(name);
		resource.setDescription(description);
		resource.setUri(uri);
		
		String extensionFile = FilenameUtils.getExtension(uri);
		loop: 
		for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
			for(String ext : ((FormatAssistant) assistant).getExtensions()){
				if(extensionFile.compareTo(ext) == 0){
					resource.setAssistant(((FormatAssistant) assistant).getNameExtension());
					resource.setAlive(assistant.load(resource));
					
					boolean loaded = assistant.load((Resource) resource);
					
					if(loaded){
						for(SemanticNode node : resource.getNodes()){
							assistant.toDataProperty(node);
							assistant.toObjectProperty(node);
							assistant.toSuper(node);
							assistant.toSub(node);
						}
					}
					break loop;
				}
			}
		}
		
		descriptor.getDescribes().add(resource);
		return resource;
	}
	
	public void save(){
		String path = null;
		
		WizardDialog wizardDialog = new WizardDialog(null, new PathSelectorWizardDialog(path));
		if (wizardDialog.open() == Window.OK) {
			org.eclipse.emf.ecore.resource.Resource.Factory.Registry reg = org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE;
	        Map<String, Object> m = reg.getExtensionToFactoryMap();
	        m.put("extremo", new XMIResourceFactoryImpl());
			
			ResourceSet resSet = new ResourceSetImpl();
	        
	        Diagnostic diagnostic = Diagnostician.INSTANCE.validate(repositoryManager);
			int severity = diagnostic.getSeverity();
			
			if(severity ==  Diagnostic.OK){
				org.eclipse.emf.ecore.resource.Resource resource = resSet.createResource(URI.createURI("Users/angel/Desktop" + "/" + "saved.extremo"));
		        resource.getContents().add(repositoryManager);
		        
		        try {
		        	resource.save(null);
		        } catch (IOException e) {
					MessageDialog.openError(null, "Save and validate", "The model was not saved properly: " + e.getMessage());
		        }
			}
			else{
				MessageDialog.openError(null, "Save and validate", "The model could not be validated");
			}  
		}
		else{
			MessageDialog.openError(null, "Add Repository", "Repository could not be added");
		}
	}
}
