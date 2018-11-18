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
package uam.extremo.extensions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;

import semanticmanager.FormatAssistant;
import semanticmanager.ModelPersistence;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.AtomicSearchResult;
import semanticmanager.CompositeSearchConfiguration;
import semanticmanager.ConnectionType;
import semanticmanager.ConstraintInterpreter;
import semanticmanager.CustomSearch;
import semanticmanager.DataModelType;
import semanticmanager.DataProperty;
import semanticmanager.PredicateBasedSearch;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchParamValue;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.Service;
import semanticmanager.SimpleSearchConfiguration;
import semanticmanager.Type;
import uam.extremo.extensions.console.ExtremoLog;
import uam.extremo.extensions.internal.Activator;

public class AssistantManager{
	private static AssistantManager instance = null;
	private static RepositoryManager repositoryManager = null;
	
	public static final String ASSISTANT_EXTENSIONS_ID = "extremo.core.extensions.assistant";
	public static final String SEARCH_EXTENSIONS_ID = "extremo.core.extensions.search";	
	public static final String CONSTRAINT_EXTENSIONS_ID = "extremo.core.extensions.constraintinterpreter";
	public static final String SERVICE_EXTENSIONS_ID = "extremo.core.extensions.services";
	public static final String MODEL_PERSISTENCE_EXTENSIONS_ID = "extremo.core.extensions.modelpersistence";
	
	/*
	 * Thread Safe Singleton
	 */
	public static synchronized AssistantManager getInstance(){
		if (instance == null) {
			instance = new AssistantManager();
			repositoryManager = SemanticmanagerFactory.eINSTANCE.createRepositoryManager();
			
			processConstraintInterpreter();
			processAssistances();
			processSearchConfigurations();
			processServices();
			processModelPersistences();
		}
		return instance;
	}
	
	public RepositoryManager getRepositoryManager() {
		return repositoryManager;
	}
	
	public static void setRepositoryManager(RepositoryManager repositoryManager) {
		AssistantManager.repositoryManager = repositoryManager;
	}
	
	private static void processAssistances(){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(ASSISTANT_EXTENSIONS_ID);

		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("assistant") == 0){
				FormatAssistant assistant;
				
				try{
					if(extension.createExecutableExtension("class") instanceof FormatAssistant){
						assistant = (FormatAssistant) extension.createExecutableExtension("class");
						
						((FormatAssistant) assistant).setId(extension.getAttribute("id"));
						((FormatAssistant) assistant).setName(extension.getAttribute("name"));
						
						String extensionsAttribute = StringUtils.deleteWhitespace(extension.getAttribute("extensions"));
						String[] extensionsSeparated = StringUtils.splitByWholeSeparator(extensionsAttribute, ",");
						
						String eval = extension.getAttribute("eval");
						
						if(eval != null && eval.compareTo("") != 0){
							ConstraintInterpreter constraintInterpreter = repositoryManager.getConstraintInterpreters().
																					stream().filter(e -> e.getName().compareTo(eval) == 0).findFirst().orElse(null);
							if(constraintInterpreter != null){
								((FormatAssistant) assistant).setInterpreter(eval);
								((FormatAssistant) assistant).setConstraintInterpreter(constraintInterpreter);
								repositoryManager.getFormatAssistants().add(assistant);
							}	
						}
						
						List<String> extensionsCleaned = new ArrayList<String>();
						for(String s : extensionsSeparated){
							String cleans = StringUtils.deleteWhitespace(s);
							extensionsCleaned.add(cleans);
						}
						
						for(String s : extensionsCleaned){
							((FormatAssistant) assistant).getExtensions().add(s);
						}
						repositoryManager.getFormatAssistants().add(assistant);
					}
				}
				catch(CoreException e){
					ExtremoLog.logError(e);
					Activator.writeConsole(e.getMessage());
				}
			}
		}
	}
	
	private static void processModelPersistences(){
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(MODEL_PERSISTENCE_EXTENSIONS_ID);

		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("modelpersistence") == 0){
				ModelPersistence modelPersistence;
		
				try{
					if(extension.createExecutableExtension("class") instanceof ModelPersistence){
						modelPersistence = (ModelPersistence) extension.createExecutableExtension("class");
						
						((ModelPersistence) modelPersistence).setId(extension.getAttribute("id"));
						((ModelPersistence) modelPersistence).setName(extension.getAttribute("name"));
						repositoryManager.getModelPersistences().add(modelPersistence);
					}
				}
				catch(CoreException e){
					ExtremoLog.logError(e);
					Activator.writeConsole(e.getMessage());
				}
			}
		}		
	}

	private static void processConstraintInterpreter() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(CONSTRAINT_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("constraintinterpreter") == 0){
				ConstraintInterpreter constraintInterpreter;
				
				try{
					if(extension.createExecutableExtension("class") instanceof ConstraintInterpreter){
						constraintInterpreter = (ConstraintInterpreter) extension.createExecutableExtension("class");
						
						((ConstraintInterpreter) constraintInterpreter).setId(extension.getAttribute("id"));
						((ConstraintInterpreter) constraintInterpreter).setName(extension.getAttribute("name"));
						((ConstraintInterpreter) constraintInterpreter).setType(extension.getAttribute("type"));
						
						repositoryManager.getConstraintInterpreters().add(constraintInterpreter);
					}
				}
				catch(CoreException e){
					ExtremoLog.logError(e);
					Activator.writeConsole(e.getMessage());
				}
			}	
		}
	}
	
	private static void processSearchConfigurations() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(SEARCH_EXTENSIONS_ID);
		
		for (int j = 0; j < extensions.length; j++){
			String extensionName = extensions[j].getName();
			
			switch (extensionName) {
				case "customsearch":
					CustomSearch customSearch;
					
					try{
						if(extensions[j].createExecutableExtension("class") instanceof CustomSearch){
							customSearch = (CustomSearch) extensions[j].createExecutableExtension("class");
															
							((CustomSearch) customSearch).setId(extensions[j].getAttribute("id"));
							((CustomSearch) customSearch).setName(extensions[j].getAttribute("name"));
															
							((CustomSearch) customSearch).setDescription(extensions[j].getAttribute("description"));
							((CustomSearch) customSearch).setGrouped(Boolean.valueOf(extensions[j].getAttribute("resultsGrouped")));

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
							
							repositoryManager.getConfigurations().add(customSearch);
						}
					}
					catch(CoreException e){
						ExtremoLog.logError(e);
						Activator.writeConsole(e.getMessage());
					}
					
					break;
					
				case "predicatebasedsearch":
					PredicateBasedSearch predicateBasedSearch;
					
					try{
						if(extensions[j].createExecutableExtension("class") instanceof PredicateBasedSearch){
							predicateBasedSearch = (PredicateBasedSearch) extensions[j].createExecutableExtension("class");
															
							((PredicateBasedSearch) predicateBasedSearch).setId(extensions[j].getAttribute("id"));
							((PredicateBasedSearch) predicateBasedSearch).setName(extensions[j].getAttribute("name"));
							
							((PredicateBasedSearch) predicateBasedSearch).setDescription(extensions[j].getAttribute("description"));
							
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
							repositoryManager.getConfigurations().add(predicateBasedSearch);
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
	
	private static void processServices() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] extensions = registry.getConfigurationElementsFor(SERVICE_EXTENSIONS_ID);
		
		for(IConfigurationElement extension : extensions){
			if(extension.getName().compareTo("service") == 0){
				Service extensibleService;

				try{
					if(extension.createExecutableExtension("class") instanceof Service){
						extensibleService = (Service) extension.createExecutableExtension("class");
						((Service) extensibleService).setId(extension.getAttribute("id"));
						((Service) extensibleService).setName(extension.getAttribute("name"));
						repositoryManager.getServices().add(extensibleService);
					}
				}
				catch(CoreException e){
					ExtremoLog.logError(e);
					Activator.writeConsole(e.getMessage());
				}
			}
		}
	}
	
	public Repository createRepository(IProject project, String name, String description){
		try{
			Repository repository = SemanticmanagerFactory.eINSTANCE.createRepository();
			repository.setName(name);
			repository.setDescription(description);
			repository.setProject(project.getName());
			return repository;
		}
		catch(Exception e){
			ExtremoLog.logError(e);
			Activator.writeConsole(e.getMessage());
			return null;
		}
	}
	
    public Resource createResourceDescriptor(Repository repository, String name, String description, String uri, FormatAssistant assistant) throws CoreException{
		try{
			long startTime = System.nanoTime();
			Resource resource = SemanticmanagerFactory.eINSTANCE.createResource();
			resource.setName(name);
			resource.setDescription(description);
			resource.setUri(uri);
			resource.setAssistant(assistant);
			
			ConstraintInterpreter constraintInterpreter = ((FormatAssistant) assistant).getConstraintInterpreter();
			boolean loaded = assistant.loadAndValidate((Resource) resource, constraintInterpreter);
			if(loaded){
				preorder(assistant, resource);
				repository.getResources().add(resource);
			}
			
			long endTime = System.nanoTime();
			Activator.writeConsole("Loaded " + resource.getName() + " " + (endTime - startTime) / 1e6 + " milis.");
			
			return resource;
		}
		catch(Exception e){
			ExtremoLog.logError(e);
			Activator.writeConsole(e.getMessage());
			return null;
		}
	}
	
	public Resource createResource(Repository repository, Resource descriptor, String name, String description, String uri, FormatAssistant assistant) throws CoreException{	
		try {
			long startTime = System.nanoTime();
			Resource resource = SemanticmanagerFactory.eINSTANCE.createResource();
			resource.setName(name);
			resource.setDescription(description);
			resource.setUri(uri);	
			resource.setAssistant(assistant);
			
			if(descriptor != null)
				resource.getDescriptors().add(descriptor);
			
			ConstraintInterpreter constraintInterpreter = ((FormatAssistant) assistant).getConstraintInterpreter();
			boolean loaded = assistant.loadAndValidate((Resource) resource, constraintInterpreter);
			if(loaded){
				preorder(assistant, resource);
				repository.getResources().add(resource);
			}
			
			long endTime = System.nanoTime();
			Activator.writeConsole("Loaded " + resource.getName() + " " + (endTime - startTime) / 1e6 + " milis.");
			
			return resource;
		}
		catch(Exception e){
			ExtremoLog.logError(e);
			Activator.writeConsole(e.getMessage());
			return null;
		}
	}
	
	public boolean load(IProject project, ModelPersistence modelPersistence){
		return modelPersistence.load(null);
	}
	
	public RepositoryManager getContentFromModelPersistence(ModelPersistence modelPersistence){
		return modelPersistence.getContent();
	}
	
	public boolean save(ModelPersistence modelPersistence, RepositoryManager repositoryManager){
		modelPersistence.addContent(repositoryManager);
		return modelPersistence.save();
	}

	public void search(Repository repository, SimpleSearchConfiguration searchConfiguration, SearchResult searchResult) { // searchResult reified
		long startTime = System.nanoTime();
		
		((SimpleSearchConfiguration) searchConfiguration).init(new BasicEList<SearchParamValue>(searchResult.getValues()));
		
		if(searchConfiguration instanceof PredicateBasedSearch){		
			repository.eAllContents().forEachRemaining(e -> {
				if (e instanceof NamedElement){
					boolean matches = ((PredicateBasedSearch) searchConfiguration).matches((NamedElement) e);
					
					if(matches)
						((AtomicSearchResult) searchResult).getElements().add((NamedElement) e);
				}
			});
		}
		else{
			((CustomSearch) searchConfiguration).search(repository, searchResult);
		}
		
		searchConfiguration.getResults().add(searchResult);
		
		long endTime = System.nanoTime();
		Activator.writeConsole("Searching..." + searchConfiguration.getName() + " " + (endTime - startTime) / 1e6 + " milis.");
	}
	
	// we need the original repository
	public void compute(CompositeSearchConfiguration compositeSearchConfiguration){
		SearchResult searchResult = SemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
		
		List<SearchConfiguration> flattenedModel = new ArrayList<SearchConfiguration>();
		compositeSearchConfiguration.eAllContents().forEachRemaining(
				e -> {
					if(e instanceof SearchConfiguration){
						flattenedModel.add((SearchConfiguration) e);
					}
				}
		);
		
		ListIterator<SearchConfiguration> listIteratorFlattenedModel = flattenedModel.listIterator(flattenedModel.size());
		while(listIteratorFlattenedModel.hasPrevious()){
			SearchConfiguration searchConfiguration = listIteratorFlattenedModel.previous();
			if(searchConfiguration instanceof CompositeSearchConfiguration){
				CompositeSearchConfiguration innerCompositeSearchConfiguration = (CompositeSearchConfiguration) searchConfiguration;
				
				switch(innerCompositeSearchConfiguration.getType().getValue()){
					case ConnectionType.AND_VALUE:
						computeAndCompositeSearch(innerCompositeSearchConfiguration, null); // define children
						break;
						
					case ConnectionType.OR_VALUE:
						computeOrCompositeSearch(innerCompositeSearchConfiguration, null); // define children
						break;
						
					case ConnectionType.NOT_VALUE:
						computeNotCompositeSearch(innerCompositeSearchConfiguration, null); // define children
						break;
						
					default:
						break;
				}				
			}
		}
		
		compositeSearchConfiguration.getResults().add(searchResult);
	}
	
	private List<NamedElement> computeAndCompositeSearch(CompositeSearchConfiguration root, List<SearchResult> searchResults){
		 List<NamedElement> setIntersection = new ArrayList<NamedElement>();
		 /*for(int i = 0; i < searchResults.size(); i++){
			 SearchResult searchResult = searchResults.get(i);
			 if(i == 0){
				 if(searchResult instanceof AtomicSearchResult){
					 setIntersection.addAll(((AtomicSearchResult) searchResult).getElements());
				 }
				 else{
					 GroupedSearchResult groupedSearchResult = (GroupedSearchResult) searchResult;
					 for(SemanticGroup semanticGroup : groupedSearchResult.getGroups()){
						 setIntersection.addAll(semanticGroup.getElements());
					 }
				 }
			 }
			 else{
				 if(searchResult instanceof AtomicSearchResult){
					 setIntersection.addAll(((AtomicSearchResult) searchResult).getElements());
				 }
				 else{
					 GroupedSearchResult groupedSearchResult = (GroupedSearchResult) searchResult;
					 for(SemanticGroup semanticGroup : groupedSearchResult.getGroups()){
						 setIntersection.addAll(semanticGroup.getElements());
					 }
				 }
				 
			            if(list2.contains(t)) {
			                list.add(t);
			            }
			        }
			 }
		 }*/
		 return setIntersection;
	}
	
	private List<NamedElement> computeOrCompositeSearch(CompositeSearchConfiguration root, List<SearchResult> searchResults){
		Set<NamedElement> setUnion = new HashSet<NamedElement>();
		
		for(SearchResult searchResult : searchResults){
			if(searchResult instanceof AtomicSearchResult){
				setUnion.addAll(((AtomicSearchResult) searchResult).getElements());
			}
		}
		
        return new ArrayList<NamedElement>(setUnion);
	}
	
	private void computeNotCompositeSearch(CompositeSearchConfiguration root, SimpleSearchConfiguration child){
	}
	
	
	
	/*private void transform(FormatAssistant assistant, Resource resource){ // containing the semanticnodes
		resource.eAllContents().forEachRemaining(
				e -> {
					if(e instanceof SemanticNode){
						assistant.toDataProperty((SemanticNode) e);
						assistant.toObjectProperty((SemanticNode) e);
						assistant.toSuper((SemanticNode) e);
					}
				}
		);
		
		resource.getGuardSemanticNodes().forEach(
			e -> {
				assistant.toDataProperty((SemanticNode) e);
				assistant.toObjectProperty((SemanticNode) e);
				assistant.toSuper((SemanticNode) e);
			}
		);
		resource.getGuardDataProperties().forEach(e -> assistant.toSuper((DataProperty) e));
		resource.getGuardObjectProperties().forEach(
			e -> {
				assistant.toSuper((ObjectProperty) e);
				assistant.toInverseOf((ObjectProperty) e);
			}
		);
	}*/
	
	/*private void transform(FormatAssistant assistant, Resource resource){
		TreeIterator<EObject> modelIterator = resource.eAllContents();
		
		modelIterator.forEachRemaining(
				e -> {
					if(e instanceof SemanticNode){
						assistant.toDataProperty((SemanticNode) e);
						assistant.toObjectProperty((SemanticNode) e);
						assistant.toSuper((SemanticNode) e);
					}
				}
		);
	}*/
	
	/*private void transform(FormatAssistant assistant, Resource resource){
		List<SemanticNode> semanticNodesFlattened = new ArrayList<SemanticNode>();
		resource.eAllContents().forEachRemaining(
				e -> {
					if(e instanceof SemanticNode){
						semanticNodesFlattened.add((SemanticNode) e);
					}
				}
		);
		
		ForkAssistant fb = new ForkAssistant(assistant, semanticNodesFlattened, 0, semanticNodesFlattened.size());
		ForkJoinPool pool = new ForkJoinPool();
		long startTime = System.currentTimeMillis();
        pool.invoke(fb);
        long endTime = System.currentTimeMillis();
        System.out.println("Image blur took " + (endTime - startTime) + 
                " milliseconds.");
	}*/
	
	private synchronized void preorder(FormatAssistant assistant, Resource resource) {
        preorderHelper(assistant, resource);
        preorderHelperSuperProperties(assistant, resource);
    }
     
    private void preorderHelper(FormatAssistant assistant, ResourceElement node) {
        if(node == null)
            return;
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelper(assistant, resourceElement);
        }
        
        if(node instanceof SemanticNode){
			SemanticNode semanticNode = (SemanticNode) node;
			assistant.toDataProperty(semanticNode);
			assistant.toObjectProperty(semanticNode);
			assistant.toSuper(semanticNode);
        }
    }
    
    private void preorderHelperSuperProperties(FormatAssistant assistant, ResourceElement node) {
        if(node == null)
            return;
        
        if(node instanceof ObjectProperty){
        	ObjectProperty objectProperty = (ObjectProperty) node;
			assistant.toSuper(objectProperty);
			assistant.toInverseOf(objectProperty);
        }
        
        if(node instanceof DataProperty){
        	DataProperty dataProperty = (DataProperty) node;
			assistant.toSuper(dataProperty);
        }
        
        if(node instanceof Resource){
        	for(ResourceElement resourceElement : ((Resource) node).getResourceElements())
        		preorderHelperSuperProperties(assistant, resourceElement);
        }
    }
    
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException(); 
	}

}