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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.mapdb.MapDbPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.mapdb.util.MapDbURI;
import fr.inria.atlanmod.neoemf.option.AbstractPersistenceOptionsBuilder;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

import semanticmanager.Constraint;
import semanticmanager.ConstraintInterpreter;
import semanticmanager.DataModelType;
import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.ExtensibleCustomSearch;
import semanticmanager.ExtensiblePredicateBasedSearch;
import semanticmanager.NamedElement;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchConfiguration;
import semanticmanager.SemanticNode;
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
	
	private static ResourceSet resourceSet = new ResourceSetImpl();
	private static org.eclipse.emf.ecore.resource.Resource resourceDb = null;

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
					}
					else {
						bundle = Platform.getBundle(contributor.getName());          
					}
					
					try{
						if(extension.createExecutableExtension("class") instanceof IFormatAssistant){
							assistant = (IFormatAssistant) extension.createExecutableExtension("class");
							
							((FormatAssistant) assistant).setId(extension.getAttribute("id"));
							((FormatAssistant) assistant).setNameExtension(extension.getAttribute("name"));
							
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
						Activator.writeConsole(e.getMessage());
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
																
								((ExtensibleCustomSearch) customSearch).setDescription(extensions[j].getAttribute("description"));
								((ExtensibleCustomSearch) customSearch).setGrouped(Boolean.valueOf(extensions[j].getAttribute("resultsGrouped")));
								
								DataModelType dataModelType = DataModelType.get(extensions[j].getAttribute("filterBy"));
								((ExtensibleCustomSearch) customSearch).setFilterBy(dataModelType);

								for(IConfigurationElement option : extensions[j].getChildren("option")){
									String id = option.getAttribute("id");
									String name = option.getAttribute("name");
									String type = option.getAttribute("type");
									
									if(type.equals("Resource") || type.equals("SemanticNode") || type.equals("DataProperty") || type.equals("ObjectProperty")){
										customSearch.addDataModelTypeSearchOption(id, name, DataModelType.get(type));
									}
									else{
										customSearch.addPrimitiveTypeSearchOption(id, name, Type.get(type));	
									}
								}
								
								getRepositoryManager().getConfigurations().add(customSearch);
							}
						}
						catch(CoreException e){
							ExtremoLog.logError(e);
							Activator.writeConsole(e.getMessage());
						}
						
						break;
						
					case "predicatebasedsearch":
						ExtensiblePredicateBasedSearch predicateBasedSearch;
						
						try{
							if(extensions[j].createExecutableExtension("class") instanceof ExtensiblePredicateBasedSearch){
								predicateBasedSearch = (ExtensiblePredicateBasedSearch) extensions[j].createExecutableExtension("class");
																
								((ExtensiblePredicateBasedSearch) predicateBasedSearch).setId(extensions[j].getAttribute("id"));
								((ExtensiblePredicateBasedSearch) predicateBasedSearch).setName(extensions[j].getAttribute("name"));
								
								((ExtensiblePredicateBasedSearch) predicateBasedSearch).setDescription(extensions[j].getAttribute("description"));
								
								DataModelType dataModelType = DataModelType.get(extensions[j].getAttribute("filterBy"));
								((ExtensiblePredicateBasedSearch) predicateBasedSearch).setFilterBy(dataModelType);	
								
								for(IConfigurationElement option : extensions[j].getChildren("option")){
									String id = option.getAttribute("id");
									String name = option.getAttribute("name");
									String type = option.getAttribute("type");
									
									if(type.equals("Resource") || type.equals("SemanticNode") || type.equals("DataProperty") || type.equals("ObjectProperty")){
										predicateBasedSearch.addDataModelTypeSearchOption(id, name, DataModelType.get(type));
									}
									else{
										predicateBasedSearch.addPrimitiveTypeSearchOption(id, name, Type.get(type));	
									}
								}
								
								getRepositoryManager().getConfigurations().add(predicateBasedSearch);
							}
						}
						catch(CoreException e){
							ExtremoLog.logError(e);
							Activator.writeConsole(e.getMessage());
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
						if(extension.createExecutableExtension("class") instanceof ConstraintInterpreter){
							constraintInterpreter = (ConstraintInterpreter) extension.createExecutableExtension("class");
							
							((ConstraintInterpreter) constraintInterpreter).setId(extension.getAttribute("id"));
							((ConstraintInterpreter) constraintInterpreter).setName(extension.getAttribute("name"));
							
							getRepositoryManager().getInterpreters().add(constraintInterpreter);
						}
					}
					catch(CoreException e){
						ExtremoLog.logError(e);
						Activator.writeConsole(e.getMessage());
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
			if(!servicesIsOnTheList(extension.getAttribute("id"))){
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
						if(extension.createExecutableExtension("class") instanceof Service){
							extensibleService = (Service) extension.createExecutableExtension("class");
							
							((Service) extensibleService).setId(extension.getAttribute("id"));
							((Service) extensibleService).setName(extension.getAttribute("name"));
							
							getRepositoryManager().getServices().add(extensibleService);
						}
					}
					catch(CoreException e){
						ExtremoLog.logError(e);
						Activator.writeConsole(e.getMessage());
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
		 PersistenceBackendFactoryRegistry.register(MapDbURI.SCHEME,
	                MapDbPersistenceBackendFactory.getInstance());
		 
		 resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
		 		.put(MapDbURI.SCHEME, PersistentResourceFactory.getInstance());
		 
		 resourceDb = resourceSet.createResource(MapDbURI.createFileURI(new File(
	                "models/repositoryManagerDb.mapdb")));
	}
	
	public RepositoryManager getRepositoryManager() {
		RepositoryManager repositoryManager = null;
		
		try {
			resourceDb.load(AbstractPersistenceOptionsBuilder.noOption());
		}
		catch (IOException e) {
			createRepositoryManager();
		}
		
		if(resourceDb.getContents().isEmpty()){
			repositoryManager = ExtendedSemanticmanagerFactory.eINSTANCE.createRepositoryManager();
			repositoryManager.eAdapters().add(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					Activator.writeConsole("Notification (" 
								+ msg.getEventType() 
								+ ") received from " 
								+ msg.getNotifier().getClass().getName());
				}
			});
			
			resourceDb.getContents().add(repositoryManager);
			
			try {
				resourceDb.save(AbstractPersistenceOptionsBuilder.noOption());
			}
			catch (IOException e) {
				ExtremoLog.logError(e);
				Activator.writeConsole(e.getMessage());
			}
		}
		
		return (RepositoryManager) resourceDb.getContents().get(0);
	}
	
	public void save(){	
		try {
			resourceDb.save(AbstractPersistenceOptionsBuilder.noOption());
			
			if (resourceDb instanceof PersistentResource) ((PersistentResource) resourceDb).close();
			else resourceDb.unload();
	    }
        catch (Exception e) {
        	ExtremoLog.logError(e);
			Activator.writeConsole(e.getMessage());
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
	
	public void validateConstraint(Constraint constraint) {
		constraint.getInterpreter().eval(constraint, constraint.getAppliedTo());
	}

	public Repository createRepository(IProject project, String name, String description){
		try{
			Repository repository = ExtendedSemanticmanagerFactory.eINSTANCE.createRepository();
			repository.setName(name);
			repository.setDescription(description);
			repository.setProject(project.getName());
			
			try {
				addVirtualsToProjectStructure(project, name);
			}
			catch (CoreException e) {
				ExtremoLog.logError(e);
				Activator.writeConsole(e.getMessage());
			}
			
			getRepositoryManager().getRepositories().add(repository);
			resourceDb.save(AbstractPersistenceOptionsBuilder.noOption());
			
			return repository;
		}
		catch(Exception e){
			ExtremoLog.logError(e);
			Activator.writeConsole(e.getMessage());
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
    
    public static org.eclipse.emf.ecore.resource.Resource getResource() {
		return resourceDb;
	}

	public static void setResource(org.eclipse.emf.ecore.resource.Resource resource) {
		AssistantFactory.resourceDb = resource;
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
						
						boolean loaded = assistant.load((Resource) resource);
						resource.setAlive(loaded);
						
						if(loaded){
							for(ResourceElement resourceElement : resource.getResourceElements()){
								if(resourceElement instanceof SemanticNode){
									SemanticNode node = (SemanticNode) resourceElement;
									toDataThread(assistant, node);
									toObjectThread(assistant, node);
									toSuperThread(assistant, node);
								}
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
			
			Activator.writeConsole(resource.getName() + " created");
			
			repository.getResources().add(resource);
			resourceDb.save(AbstractPersistenceOptionsBuilder.noOption());
			return resource;	
		}
		catch(Exception e){
			ExtremoLog.logError(e);
			Activator.writeConsole(e.getMessage());
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
			
			boolean loaded = assistant.load((Resource) resource);
			resource.setAlive(loaded);
			
			if(loaded){
				for(ResourceElement resourceElement : resource.getResourceElements()){
					if(resourceElement instanceof SemanticNode){
						SemanticNode node = (SemanticNode) resourceElement;
						toDataThread(assistant, node);
						toObjectThread(assistant, node);
						toSuperThread(assistant, node);
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
					ExtremoLog.logError(e);
					Activator.writeConsole(e.getMessage());
				}
			}
			
			repository.getResources().add(resource);
			resourceDb.save(AbstractPersistenceOptionsBuilder.noOption());
			return resource;
		}
		catch(Exception e){
			ExtremoLog.logError(e);
			Activator.writeConsole(e.getMessage());
			return null;
		}
	}

    public void changeResourceAssistant(Resource resource, String newassistant) throws IOException{
		loop: 
		for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
			if(((FormatAssistant) assistant).getNameExtension().equals(newassistant)){
				resource.getResourceElements().clear();
				
				boolean loaded = assistant.load((Resource) resource);
				resource.setAlive(loaded);
				
				if(loaded){
					for(ResourceElement resourceElement : resource.getResourceElements()){
						if(resourceElement instanceof SemanticNode){
							SemanticNode node = (SemanticNode) resourceElement;
							toDataThread(assistant, node);
							toObjectThread(assistant, node);
							toSuperThread(assistant, node);
						}
					}
				}
				break loop;
			}
		}
	}

    public Resource createResource(Repository repository, Resource descriptor, String name, String description, String uri) throws CoreException{	
		try{
			Resource resource = ExtendedSemanticmanagerFactory.eINSTANCE.createResource();
			resource.setName(name);
			resource.setDescription(description);
			resource.setUri(uri);
			if(descriptor != null)
				resource.getDescriptors().add(descriptor);

			String extensionFile = FilenameUtils.getExtension(uri);
			loop: 
			for(IFormatAssistant assistant : AssistantFactory.getInstance().getAssistances()){
				for(String ext : ((FormatAssistant) assistant).getExtensions()){
					if(extensionFile.compareTo(ext) == 0){
						resource.setAssistant(((FormatAssistant) assistant).getNameExtension());
						
						boolean loaded = assistant.load((Resource) resource);
						resource.setAlive(loaded);
						
						if(loaded){
							for(ResourceElement resourceElement : resource.getResourceElements()){
								if(resourceElement instanceof SemanticNode){
									SemanticNode node = (SemanticNode) resourceElement;
									toDataThread(assistant, node);
									toObjectThread(assistant, node);
									toSuperThread(assistant, node);
								}
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
					ExtremoLog.logError(e);
					Activator.writeConsole(e.getMessage());
				}
			}
			
			repository.getResources().add(resource);
			
			resourceDb.save(AbstractPersistenceOptionsBuilder.noOption());
			
			return resource;
		}
		catch(Exception e){
			ExtremoLog.logError(e);
			Activator.writeConsole(e.getMessage());
			return null;
		}
	}
	
	public Resource createResource(Repository repository, Resource descriptor, String name, String description, String uri, IFormatAssistant assistant) throws CoreException{	
		try{
			Resource resource = ExtendedSemanticmanagerFactory.eINSTANCE.createResource();
			resource.setName(name);
			resource.setDescription(description);
			resource.setUri(uri);	
			if(descriptor != null)
				resource.getDescriptors().add(descriptor);
			
			resource.setAssistant(((FormatAssistant) assistant).getNameExtension());
			
			boolean loaded = assistant.load((Resource) resource);
			resource.setAlive(loaded);
			
			if(loaded){
				for(ResourceElement resourceElement : resource.getResourceElements()){
					if(resourceElement instanceof SemanticNode){
						SemanticNode node = (SemanticNode) resourceElement;
						toDataThread(assistant, node);
						toObjectThread(assistant, node);
						toSuperThread(assistant, node);
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
					ExtremoLog.logError(e);
					Activator.writeConsole(e.getMessage());
				}
			}
			
			repository.getResources().add(resource);
			resourceDb.save(AbstractPersistenceOptionsBuilder.noOption());
			return resource;
		}
		catch(Exception e){
			ExtremoLog.logError(e);
			Activator.writeConsole(e.getMessage());
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

	public void emptyResourceDb() {
		EcoreUtil.delete(getRepositoryManager(), true);
	}
}
