package uam.extremo.extensions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.option.BlueprintsOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;
import semanticmanager.AtomicSearchResult;
import semanticmanager.CompositeSearchConfiguration;
import semanticmanager.Constraint;
import semanticmanager.ConstraintInterpreter;
import semanticmanager.CustomSearch;
import semanticmanager.DataModelType;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.ExtensibleCustomSearch;
import semanticmanager.ExtensiblePredicateBasedSearch;
import semanticmanager.NamedElement;
import semanticmanager.PredicateBasedSearch;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.Service;
import semanticmanager.Type;

public class AssistantFactory implements IResourceChangeListener{
	public static final String ASSISTANT_EXTENSIONS_ID = "extremo.core.extensions.assistant";
	public static final String SEARCH_EXTENSIONS_ID = "extremo.core.extensions.search";	
	public static final String CONSTRAINT_EXTENSIONS_ID = "extremo.core.extensions.constraintinterpreter";
	public static final String SERVICE_EXTENSIONS_ID = "extremo.core.extensions.services";
	
	public static final String NATURE_ID = "uam.extremo.ui.nature.extremonature";
	
	private static AssistantFactory INSTANCE = null;
	private static List<IFormatAssistant> assistants = null;
	private static NamedElement drawnElement = null;
	private static org.eclipse.emf.ecore.resource.Resource backupResource = null;
	private static RepositoryManager repositoryManager = null;

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
							
							List<String> extensionsCleaned = new ArrayList<String>();
							for(String s : extensionsSeparated){
								String cleans = StringUtils.deleteWhitespace(s);
								extensionsCleaned.add(cleans);
							}
							
							for(String s : extensionsCleaned){
								((FormatAssistant)assistant).addExtension(s);
							}
							
							assistants.add(assistant);
						}
					}
					catch(CoreException e){
						ExtremoLog.logError(e);
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
		if(assistants == null) return false;
		
		for(IFormatAssistant assistant : assistants){
			if(assistant instanceof FormatAssistant){
				if(((FormatAssistant) assistant).getId().compareTo(attribute) == 0) 
					return true;
			}
		}
		return false;
	}
	
	public List<SearchConfiguration> getSearches() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(SEARCH_EXTENSIONS_ID);
		
		for (int j = 0; j < extensions.length; j++){
			if(!searchIsOnTheList(extensions[j].getAttribute("id"))){
				Bundle bundle = null;
				IContributor contributor = extensions[j].getContributor();
				
				if (contributor instanceof RegistryContributor) {
					long id = Long.parseLong(((RegistryContributor) contributor).getActualId());
					Bundle thisBundle = FrameworkUtil.getBundle(getClass());
					bundle = thisBundle.getBundleContext().getBundle(id);
				}
				else {
					bundle = Platform.getBundle(contributor.getName());          
				}
				
				String extensionName = extensions[j].getName();
				
				switch (extensionName) {
					case "customsearch":
						ExtensibleCustomSearch customSearch;
						
						try{
							if(extensions[j].createExecutableExtension("class") instanceof ExtensibleCustomSearch){
								customSearch = (ExtensibleCustomSearch) extensions[j].createExecutableExtension("class");
								
								((ExtensibleCustomSearch) customSearch).setId(extensions[j].getAttribute("id"));
								((ExtensibleCustomSearch) customSearch).setName(extensions[j].getAttribute("name"));
								
								//System.out.println(">> one custom search " + extensions[j].getAttribute("name"));
								
								DataModelType dataModelType = DataModelType.get(extensions[j].getAttribute("filterBy"));
								((ExtensibleCustomSearch) customSearch).setFilterBy(dataModelType);
								
								for(IConfigurationElement option : extensions[j].getChildren("option")){
									String id = option.getAttribute("id");
									String name = option.getAttribute("name");
									String type = option.getAttribute("type");
									
									customSearch.addSearchOption(id, name, Type.get(type));
								}
								
								getRepositoryManager().getConfigurations().add(customSearch);
							}
						}
						catch(CoreException e){
							System.out.println(e.getMessage());
						}
						
						break;
						
					case "predicatebasedsearch":
						ExtensiblePredicateBasedSearch predicateBasedSearch;
						
						try{
							if(extensions[j].createExecutableExtension("class") instanceof ExtensiblePredicateBasedSearch){
								predicateBasedSearch = (ExtensiblePredicateBasedSearch) extensions[j].createExecutableExtension("class");
								
								((ExtensiblePredicateBasedSearch) predicateBasedSearch).setId(extensions[j].getAttribute("id"));
								((ExtensiblePredicateBasedSearch) predicateBasedSearch).setName(extensions[j].getAttribute("name"));
								
								System.out.println(">> one predicate based search " + extensions[j].getAttribute("name"));
								
								DataModelType dataModelType = DataModelType.get(extensions[j].getAttribute("filterBy"));
								((ExtensiblePredicateBasedSearch) predicateBasedSearch).setFilterBy(dataModelType);
								
								for(IConfigurationElement option : extensions[j].getChildren("option")){
									String id = option.getAttribute("id");
									String name = option.getAttribute("name");
									String type = option.getAttribute("type");
									
									predicateBasedSearch.addSearchOption(id, name, Type.get(type));
								}
								
								getRepositoryManager().getConfigurations().add(predicateBasedSearch);
							}
						}
						catch(CoreException e){
							System.out.println(e.getMessage());
						}
						
						break;
						
					default:
						break;
				}
			}
		}
		
		return getRepositoryManager().getConfigurations();
	}
	
	private boolean searchIsOnTheList(String attribute) {
		List<SearchConfiguration> configurations = getRepositoryManager().getConfigurations();
		
		for(SearchConfiguration search : configurations){
			if(search instanceof SearchConfiguration){
				if(((SearchConfiguration) search).getId().compareTo(attribute)==0) return true;
			}
		}
		return false;
	}
	
	public List<ConstraintInterpreter> getConstraintInterpreter() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(CONSTRAINT_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(! constraintInterpreterIsOnTheList(extension.getAttribute("id"))){
				if(extension.getName().compareTo("constraintinterpreter") == 0){
					ConstraintInterpreter constraintInterpreter;
					
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
							constraintInterpreter = (ConstraintInterpreter) extension.createExecutableExtension("class");
							
							((ConstraintInterpreter) constraintInterpreter).setId(extension.getAttribute("id"));
							((ConstraintInterpreter) constraintInterpreter).setName(extension.getAttribute("name"));
							
							getRepositoryManager().getInterpreters().add(constraintInterpreter);
						}
					}
					catch(CoreException e){
						ExtremoLog.logError(e);
					}
				}
			}		
		}
		
		return getRepositoryManager().getInterpreters();
	}
	
	private boolean constraintInterpreterIsOnTheList(String attribute) {
		List<ConstraintInterpreter> interpreters = getRepositoryManager().getInterpreters();
		
		if(interpreters == null)
			return false;
		
		for(ConstraintInterpreter interpreter : interpreters){
			if(interpreter instanceof ConstraintInterpreter){
				if(((ConstraintInterpreter) interpreter).getId().compareTo(attribute)==0) return true;
			}
		}
		
		return false;
	}
	
	public List<Service> getServices() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(SERVICE_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(! servicesIsOnTheList(extension.getAttribute("id"))){
				if(extension.getName().compareTo("service") == 0){
					Service extensibleService;
					
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
							extensibleService = (Service) extension.createExecutableExtension("class");
							
							((Service) extensibleService).setId(extension.getAttribute("id"));
							((Service) extensibleService).setName(extension.getAttribute("name"));
							
							getRepositoryManager().getServices().add(extensibleService);
						}
					}
					catch(CoreException e){
						ExtremoLog.logError(e);
					}
				}
			}		
		}
		
		return getRepositoryManager().getServices();
	}
	
	private boolean servicesIsOnTheList(String attribute) {
		List<Service> services = getRepositoryManager().getServices();
		
		if(services == null) return false;
		
		for(Service service : services){
			if(service instanceof Service){
				if(((Service) service).getId().compareTo(attribute)==0) return true;
			}
		}
		return false;
	}
	
	private static void createInstance(){
   	 if (INSTANCE == null) {
            synchronized(AssistantFactory.class) {
                if (INSTANCE == null) { 
                    INSTANCE = new AssistantFactory();

                    assistants = new ArrayList<IFormatAssistant>();
                    createRepositoryManager();
                }
            }
        }
   }

	public AssistantFactory(){
		ResourcesPlugin.getWorkspace().addResourceChangeListener (this, IResourceChangeEvent.POST_CHANGE);
	}
	
	public static void shutdown() {
		if (INSTANCE != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(INSTANCE);
			INSTANCE.save();
			INSTANCE = null;
		}
	}
	
	public static void createRepositoryManager(){
		SemanticmanagerPackage.eINSTANCE.eClass();
		SemanticmanagerFactory factory = SemanticmanagerFactory.eINSTANCE;
		
		repositoryManager = factory.createRepositoryManager();
		
		/*repositoryManager.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				NeoLogger.info("Notification (type {0}) received from {1}", msg.getEventType(),
						msg.getNotifier().getClass().getName());
			}
		});*/
		
		/*PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());
		
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(BlueprintsURI.SCHEME,
				PersistentResourceFactory.getInstance());
		
		try (PersistentResource resource = (PersistentResource) rSet
				.getResource(BlueprintsURI.createFileURI(new File("models/repositoryManager.neodb")), true)) {
			
			List<Object> storeOptions = new ArrayList<Object>();
		    storeOptions.add(BlueprintsStoreOptions.AUTOCOMMIT);
			
		    //NEO4J -> NeoDB // TinkerGraph is not available
			Map<Object,Object> options = new HashMap<Object,Object>();
		    options.put(
		        BlueprintsResourceOptions.GRAPH_TYPE,
		        BlueprintsNeo4jResourceOptions.GRAPH_TYPE_NEO4J);
		    options.put(PersistentResourceOptions.STORE_OPTIONS, storeOptions);*/
		    
			/*RepositoryManager repositoryManager = factory.createRepositoryManager();
			
			repositoryManager.eAdapters().add(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					NeoLogger.info("Notification (type {0}) received from {1}", msg.getEventType(),
							msg.getNotifier().getClass().getName());
				}
			});*/
			
			//resource.getContents().add(repositoryManager);
			
			/*List<Object> storeOptions = new ArrayList<Object>();
		    storeOptions.add(BlueprintsStoreOptions.AUTOCOMMIT);
			
			Map<Object,Object> options = new HashMap<Object,Object>();
		    options.put(
		        BlueprintsResourceOptions.GRAPH_TYPE,
		        BlueprintsNeo4jResourceOptions.GRAPH_TYPE_NEO4J);
		    options.put(PersistentResourceOptions.STORE_OPTIONS, storeOptions);*/
		    
		    //resource.save(options);
		/*}
		catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	private static void checkModel(org.eclipse.emf.ecore.resource.Resource resource) {
		if (resource.getContents().size() == 0) {
			throw new IllegalStateException(
					"The content of the resource is empty, make sure you have created it using (Efficient)BlueprintsImporter");
		}
	}
	
	public void save(){	
		try {
			backupResource.save(BlueprintsOptionsBuilder.noOption());
			
			if (backupResource instanceof PersistentResource) ((PersistentResource) backupResource).close();
			else backupResource.unload();
	    }
        catch (Exception e) {
        	System.out.println(e.getMessage());
	    } 
	}

	public static AssistantFactory getInstance(){
		if (INSTANCE == null){
			createInstance();
		}
		
		return INSTANCE;
	}
   
	public Object clone() throws CloneNotSupportedException {
	   throw new CloneNotSupportedException(); 
    }
	
	public void putAllResourceToNotActive(){
		List<Repository> repositories = getRepositoryManager().getRepositories();
		
		for(Repository repository : repositories){
			for(Resource resource : repository.getResources()){
				resource.setActive(false);
			}
		}
	}
	
	public void putAllNamedElementToNotDrawable(){
		TreeIterator<EObject> iterator = getRepositoryManager().eAllContents();
		
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
	
	public void search(SearchResult result) {
		SearchConfiguration searchConfiguration = result.getConfiguration();
		
		if(searchConfiguration instanceof CompositeSearchConfiguration){
			CompositeSearchConfiguration compositeSearchConfiguration = (CompositeSearchConfiguration) searchConfiguration;
			compositeSearchConfiguration.search(result);
		}
		
		if (searchConfiguration instanceof CustomSearch) {
			CustomSearch customSearch = (CustomSearch) searchConfiguration;
			customSearch.search(result);
		}
		
		if (searchConfiguration instanceof PredicateBasedSearch) {
			PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch) searchConfiguration;
			
			result.getApplyOnElements().forEach(
					element -> {
						if((predicateBasedSearch.matches(element, result.getValues())) && (result instanceof AtomicSearchResult)){
							AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
							atomicSearchResult.getElements().add(element);
						}
					}
			);	
		}
	}
	
	public void validateConstraint(Constraint constraint) {
		constraint.getInterpreter().eval(constraint, constraint.getAppliedTo());
	}
	
	public RepositoryManager getRepositoryManager() {
		return repositoryManager;
		
		/*SemanticmanagerPackage.eINSTANCE.eClass();

		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());

		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(BlueprintsURI.SCHEME,
				PersistentResourceFactory.getInstance());
		
		try (PersistentResource resource = (PersistentResource) rSet
				.getResource(BlueprintsURI.createFileURI(new File("models/repositoryManager.neodb")), true)) {
			
			resource.load(BlueprintsOptionsBuilder.noOption());
			checkModel(resource);
			
			RepositoryManager model = (RepositoryManager) resource.getContents().get(0);*/
			
			
			
			//resource.
			/*model.eAdapters().add(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					NeoLogger.info("Notification (type {0}) received from {1}", msg.getEventType(),
							msg.getNotifier().getClass().getName());
				}
			});*/
			
			//List<Object> storeOptions = new ArrayList<Object>();
		    //storeOptions.add(BlueprintsStoreOptions.AUTOCOMMIT);
			
		    //NEO4J -> NeoDB // TinkerGraph is not available
			/*Map<Object,Object> options = new HashMap<Object,Object>();
		    options.put(
		        BlueprintsResourceOptions.GRAPH_TYPE,
		        BlueprintsNeo4jResourceOptions.GRAPH_TYPE_NEO4J);
		    options.put(PersistentResourceOptions.STORE_OPTIONS, storeOptions);
			
			resource.save(options);*/

			// Unload the resource and shutdown the database engine
			
		
		
			/*if (resource instanceof PersistentResource) ((PersistentResource) resource).close();
			else resource.unload();
			
			return model;
		}
		catch (IOException e) {
			return null;
		}*/		
	}
	
	public PersistentResource getResource(){
		SemanticmanagerPackage.eINSTANCE.eClass();

		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());

		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(BlueprintsURI.SCHEME,
				PersistentResourceFactory.getInstance());
		
		try (PersistentResource resource = (PersistentResource) rSet
				.getResource(BlueprintsURI.createFileURI(new File("models/repositoryManager.neodb")), true)) {
			return resource;
		}		
	}
	
	public Repository createRepository(IProject project, String name, String description){
		try{
			Repository repository = ExtendedSemanticmanagerFactory.eINSTANCE.createRepository();
			repository.setName(name);
			repository.setDescription(description);
			repository.setProject(project.getName());
			
			try {
				addVirtualsToProjectStructure(project, name);
			} catch (CoreException e) {
				ExtremoLog.logError(e);
			}
			
			getRepositoryManager().getRepositories().add(repository);
			return repository;
		}
		catch(Exception fileNotFound){
			ExtremoLog.logError(fileNotFound);
			return null;
		}
	}

    private static void addVirtualsToProjectStructure(IProject project, String path) throws CoreException {
    	IFolder repoFolder = project.getFolder(path);
    	createVirtualFolder(repoFolder);
    }
    
    private static void createVirtualFolder(IFolder folder) throws CoreException {
        IContainer parent = folder.getParent();
        
        if (parent instanceof IFolder) {
            createVirtualFolder((IFolder) parent);
        }
        if (!folder.exists()) {
            folder.create(IResource.VIRTUAL, true, null);
        }
    }
	
    public Resource createResourceDescriptor(Repository repository, String name, String description, String uri) throws CoreException{
		try{
			Resource resource = ExtendedSemanticmanagerFactory.eINSTANCE.createResource();
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
								toDataThread(assistant, node);
								toObjectThread(assistant, node);
								toSuperThread(assistant, node);
							}
						}
						break loop;
					}
				}
			}
			
			String projectName = repository.getProject();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			
			if(project != null){
				IFolder folder = project.getFolder(repository.getName());
				IFile child = folder.getFile(name);
				
				IPath location = new Path(uri);
				child.createLink(location, IResource.FILE, null);
			}
			
			//BasicCommandStack commandStack = new BasicCommandStack();
			//AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(new DataModelItemProviderAdapterFactory(), commandStack);
			
			//org.eclipse.emf.common.command.Command command = AddCommand.create(editingDomain, repository, SemanticmanagerPackage.eINSTANCE.getRepository_Resources(), resource);
			//editingDomain.getCommandStack().execute(command);
			
			//((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
			
			repository.getResources().add(resource);
			
			return resource;	
		}
		catch(Exception fileNotFound){
			ExtremoLog.logError(fileNotFound);
			return null;
		}		
	}
	
    public Resource createResourceDescriptor(Repository repository, String name, String description, String uri, IFormatAssistant assistant) throws CoreException{
		try{
			Resource resource = ExtendedSemanticmanagerFactory.eINSTANCE.createResource();
			resource.setName(name);
			resource.setDescription(description);
			resource.setUri(uri);
			
			resource.setAssistant(((FormatAssistant) assistant).getNameExtension());
			resource.setAlive(assistant.load(resource));
			
			boolean loaded = assistant.load((Resource) resource);
		
			if(loaded){
				for(SemanticNode node : resource.getNodes()){
					assistant.toDataProperty(node);
					assistant.toObjectProperty(node);
					assistant.toSuper(node);
				}
			}
			
			String projectName = repository.getProject();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			
			if(project != null){
				IFolder folder = project.getFolder(repository.getName());
				IFile child = folder.getFile(name);
				
				IPath location = new Path(uri);
				
				try{
					child.createLink(location, IResource.FILE, null);
				}
				catch(Exception e){
					MessageDialog.openInformation(null, "Repository creation", e.getMessage());
				}
			}
			
			//long before = System.nanoTime();
			
			/*org.eclipse.emf.common.command.Command command = AddCommand.create(editingDomain, repository, SemanticmanagerPackage.eINSTANCE.getRepository_Resources(), resource);
			editingDomain.getCommandStack().execute(command);
			
			((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();*/
			
			repository.getResources().add(resource);
			
			//long after = System.nanoTime();
			
			//System.out.println("R1 Time: " + (after - before));
			
			return resource;
		}
		catch(Exception fileNotFound){
			ExtremoLog.logError(fileNotFound);
			return null;
		}
	}

    public void changeResourceAssistant(Resource resource, String newassistant) throws IOException{
		loop: 
		for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
			if(((FormatAssistant) assistant).getNameExtension().equals(newassistant)){
				resource.getNodes().clear();
				resource.setAlive(assistant.load(resource));
				
				boolean loaded = assistant.load((Resource) resource);
				if(loaded){
					for(SemanticNode node : resource.getNodes()){
						assistant.toDataProperty(node);
						assistant.toObjectProperty(node);
						assistant.toSuper(node);
					}
				}
				break loop;
			}
		}
	}

    public Resource createResource(Repository repository, Resource descriptor, String name, String description, String uri) throws CoreException{	
		try{
			//System.out.println("repo3");
			Resource resource = ExtendedSemanticmanagerFactory.eINSTANCE.createResource();
			resource.setName(name);
			resource.setDescription(description);
			resource.setUri(uri);
			//resource.setDescriptor(descriptor);
			resource.getDescriptors().add(descriptor);

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
							}
						}
						break loop;
					}
				}
			}
			
			String projectName = repository.getProject();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			
			if(project != null){
				IFolder folder = project.getFolder(repository.getName());
				IFile child = folder.getFile(name);
				
				IPath location = new Path(uri);
				try{
					child.createLink(location, IResource.FILE, null);
				}
				catch(Exception e){
					MessageDialog.openInformation(null, "Repository creation", e.getMessage());
				}
			}
			
			//BasicCommandStack commandStack = new BasicCommandStack();
			//AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(new DataModelItemProviderAdapterFactory(), commandStack);
			
			//org.eclipse.emf.common.command.Command command = AddCommand.create(editingDomain, repository, SemanticmanagerPackage.eINSTANCE.getRepository_Resources(), resource);
			//editingDomain.getCommandStack().execute(command);
			
			//((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
			
			repository.getResources().add(resource);
			
			return resource;
		}
		catch(Exception fileNotFound){
			ExtremoLog.logError(fileNotFound);
			return null;
		}
	}
	
	public Resource createResource(Repository repository, Resource descriptor, String name, String description, String uri, IFormatAssistant assistant) throws CoreException{	
		try{
			//System.out.println("repo4");
			Resource resource = ExtendedSemanticmanagerFactory.eINSTANCE.createResource();
			resource.setName(name);
			resource.setDescription(description);
			resource.setUri(uri);
			resource.getDescriptors().add(descriptor);
			
			resource.setAssistant(((FormatAssistant) assistant).getNameExtension());
			resource.setAlive(assistant.load(resource));
			
			boolean loaded = assistant.load((Resource) resource);
				
			if(loaded){
				for(SemanticNode node : resource.getNodes()){
					assistant.toDataProperty(node);
					assistant.toObjectProperty(node);
					assistant.toSuper(node);
				}
			}
			
			String projectName = repository.getProject();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			
			if(project != null){
				IFolder folder = project.getFolder(repository.getName());
				IFile child = folder.getFile(name);
				
				IPath location = new Path(uri);
				try{
					child.createLink(location, IResource.FILE, null);
				}
				catch(Exception e){
					MessageDialog.openInformation(null, "Repository creation", e.getMessage());
				}
			}
			
			//long before = System.nanoTime();
			
			//BasicCommandStack commandStack = new BasicCommandStack();
			//AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(itemProvider, commandStack);
			
			/*org.eclipse.emf.common.command.Command command = AddCommand.create(editingDomain, repository, SemanticmanagerPackage.eINSTANCE.getRepository_Resources(), resource);
			editingDomain.getCommandStack().execute(command);
			
			((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();*/
			
			repository.getResources().add(resource);
			
			//long after = System.nanoTime();
			
			//System.out.println("R2 Time: " + (after - before));
			
			return resource;
		}
		catch(Exception fileNotFound){
			ExtremoLog.logError(fileNotFound);
			return null;
		}
	}

	private void toDataThread(IFormatAssistant assistant, SemanticNode node){
		Job job = new Job(node.getName() + " : resolving data properties") {
	        @Override
	        protected IStatus run(IProgressMonitor monitor) {
	        	assistant.toDataProperty(node);
	            return Status.OK_STATUS;
	        }
		};
	
		job.schedule();
	}
	
	private void toObjectThread(IFormatAssistant assistant, SemanticNode node){
		Job job = new Job(node.getName() + " : resolving object properties") {
	        @Override
	        protected IStatus run(IProgressMonitor monitor) {
	        	assistant.toObjectProperty(node);
	            return Status.OK_STATUS;
	        }
		};
	
		job.schedule();
	}
	
	private void toSuperThread(IFormatAssistant assistant, SemanticNode node){
		Job job = new Job(node.getName() + " : resolving parenthood properties") {
	        @Override
	        protected IStatus run(IProgressMonitor monitor) {
	        	assistant.toSuper(node);
	        	return Status.OK_STATUS;
	        }
		};
	
		job.schedule();
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
	}
	
	public NamedElement searchNamedElement(EObject node, Object data){
    	NamedElement found = null;
    	
		if((node instanceof NamedElement) && (((NamedElement) node).getName().equals(data))){
           found = (NamedElement) node;
        }
		else {
			for(EObject content : node.eContents()){
				if(content instanceof NamedElement){
					found = searchNamedElement((NamedElement) content, data);	
					if(found != null) break;
				}	
			}
         }
    	
        return found;
    }
}
