package uam.extremo.extensions;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.spi.RegistryContributor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import semanticmanager.NamedElement;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.Type;
import semanticmanager.impl.SemanticmanagerPackageImpl;
import semanticmanager.presentation.SemanticmanagerModelWizard;

public class AssistantFactory implements IResourceChangeListener{
	public static final String ASSISTANT_EXTENSIONS_ID = "extremo.core.extensions.assistant";
	public static final String SEARCH_EXTENSIONS_ID = "extremo.core.extensions.search";
	public static final String NATURE_ID = "uam.extremo.ui.nature.extremonature";
	
	private static AssistantFactory INSTANCE = null;
	private static RepositoryManager repositoryManager;
	private static List<IFormatAssistant> assistants = null;
	
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
							
							System.out.println(extensionsAttribute + " " + extensionsSeparated);
							
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
                }
            }
        }
   }

	public AssistantFactory(){
		//IResourceChangeListener
		ResourcesPlugin.getWorkspace().addResourceChangeListener (this, IResourceChangeEvent.POST_CHANGE);
	}
	
	public static void shutdown() {
		if (INSTANCE != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(INSTANCE);
			INSTANCE.save();
			INSTANCE = null;
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
							//assistant.toDataProperty(node);
							toDataThread(assistant, node);
							
							//assistant.toObjectProperty(node);
							toObjectThread(assistant, node);
							
							//assistant.toSuper(node);
							toSuperThread(assistant, node);
							
							//assistant.toSub(node);
						}
					}
					break loop;
				}
			}
		}
		
		repository.getResources().add(resource);
		return resource;
	}
	
	public Resource createResourceDescriptor(Repository repository, String name, String description, String uri, IFormatAssistant assistant){
		Resource resource = SemanticmanagerFactory.eINSTANCE.createResource();
		resource.setName(name);
		resource.setDescription(description);
		resource.setUri(uri);
		
		resource.setAssistant(((FormatAssistant) assistant).getNameExtension());
		resource.setAlive(assistant.load(resource));
		
		boolean loaded = assistant.load((Resource) resource);
		
		//System.out.println("el descriptor ha sido... " + loaded);
		
		if(loaded){
			for(SemanticNode node : resource.getNodes()){
				//System.out.println("recorriendo descriptores... " + node);

				assistant.toDataProperty(node);
				//toDataThread(assistant, node);
				
				assistant.toObjectProperty(node);
				//toObjectThread(assistant, node);
				
				assistant.toSuper(node);
				//toSuperThread(assistant, node);
				
				//assistant.toSub(node);
			}
		}
		
		repository.getResources().add(resource);
		return resource;
	}

	public void changeResourceAssistant(Resource resource, String newassistant){
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
	
	public Resource createResource(Repository repository, Resource descriptor, String name, String description, String uri){
		Resource resource = SemanticmanagerFactory.eINSTANCE.createResource();
		resource.setName(name);
		resource.setDescription(description);
		resource.setUri(uri);
		resource.setDescriptor(descriptor);
		
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
		
		repository.getResources().add(resource);
		//descriptor.getDescribes().add(resource);
		return resource;
	}
	
	public Resource createResource(Repository repository, Resource descriptor, String name, String description, String uri, IFormatAssistant assistant){
		Resource resource = SemanticmanagerFactory.eINSTANCE.createResource();
		resource.setName(name);
		resource.setDescription(description);
		resource.setUri(uri);
		resource.setDescriptor(descriptor);
		
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
		
		repository.getResources().add(resource);
		return resource;
	}
	
	public void save(){
		WizardDialog wizardDialog = new WizardDialog(null, new SemanticmanagerModelWizard(AssistantFactory.getInstance().getRepositoryManager(), Activator.getDefault().getWorkbench(), new StructuredSelection()));
		if (wizardDialog.open() == Window.OK) {
			System.out.println("todo ok");
		}
		
		
		/*String path = null;
		
		WizardDialog wizardDialog = new WizardDialog(null, new PathSelectorWizardDialog(path));
		if (wizardDialog.open() == Window.OK) {
	        try {
	        	org.eclipse.emf.ecore.resource.Resource.Factory.Registry reg = org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE;
	        	Map<String, Object> m = reg.getExtensionToFactoryMap();
	        	m.put("semanticmanager", new XMIResourceFactoryImpl());
	        	
	        	ResourceSet resSet = new ResourceSetImpl();
	        	
				URI fileURI = URI.createFileURI(path + "/" + "saved.semanticmanager");
	        	
				org.eclipse.emf.ecore.resource.Resource resource = resSet.createResource(fileURI);
		        
				if(repositoryManager != null)
					resource.getContents().add(repositoryManager);
		        
		        String encoding = "UTF-8";
		        Map<Object, Object> options = new HashMap<Object, Object>();
		        options.put(XMLResource.OPTION_ENCODING, encoding);
		        resource.save(options);
		    }
	        catch (IOException e) {
		    	MessageDialog.openError(null, "Save and validate", "The model was not saved properly: " + e.getMessage());
		    } 
		}
		else{
			MessageDialog.openError(null, "Add Repository", "Repository could not be added");
		}*/
	}
	
	private void toDataThread(IFormatAssistant assistant, SemanticNode node){
		Job job = new Job(node.getName() + " : resolving data properties") {
	        @Override
	        protected IStatus run(IProgressMonitor monitor) {
	        	assistant.toDataProperty(node);
	            return Status.OK_STATUS;
	        }
		};
	
		// Start the Job
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
	
		// Start the Job
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
	
		// Start the Job
		job.schedule();
	}

	//from IResourceChangeListener
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		try {
			event.getDelta().accept(new IResourceDeltaVisitor() {
				public boolean visit(IResourceDelta delta) throws CoreException{
					IResource resource = delta.getResource();
					
					if (resource instanceof IFile) {
						IFile file = (IFile) resource;

						if(file.getProject().isNatureEnabled(NATURE_ID)){
							
						}
					}
					
					if (resource instanceof IFolder) {
						IFolder folder = (IFolder) resource;

						if(folder.getProject().isNatureEnabled(NATURE_ID)){
							
						}
					}
					
					if (resource instanceof IProject) {
						IProject project = (IProject) resource;
						
						if(project.isNatureEnabled(NATURE_ID)){

						}
					}
					
					if (resource instanceof IWorkspaceRoot) {
						IWorkspaceRoot workspace = (IWorkspaceRoot) resource;
						
						System.out.println("workspace: " + workspace);
					}
					
					StringBuffer buf = new StringBuffer(80);
					
					switch (delta.getKind()) {
						case IResourceDelta.ADDED:
							buf.append("ADDED");
							break;
							
						case IResourceDelta.REMOVED:
							buf.append("REMOVED");
							break;
							
						case IResourceDelta.CHANGED:
							buf.append("CHANGED");
							break;
							
						default:
							buf.append("[");
							buf.append(delta.getKind());
							buf.append("]");
							break;
					}
		            
					buf.append(" ");
		            buf.append(delta.getResource().getType());
		            System.out.println(buf);
		            return true;
				}
			});
	   }
	   catch (CoreException ex) {
		   System.out.println(ex.getMessage());
	   }
	}
}
