package uam.extremo.performance.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;

import semanticmanager.CustomSearch;
import semanticmanager.FormatAssistant;
import semanticmanager.PredicateBasedSearch;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.SearchResult;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.Service;
import semanticmanager.SimpleSearchConfiguration;
import semanticmanager.Type;
import uam.extremo.extensions.AssistantManager;
import uam.extremo.extensions.assistants.EcoreAssistant;
import uam.extremo.queries.customsearch.HierarchyLimitSearch;
import uam.extremo.queries.customsearch.InRefsOverloadedSearch;
import uam.extremo.queries.customsearch.IsolatedClassesSearch;
import uam.extremo.queries.customsearch.NodesWithoutDescriptionsSearch;
import uam.extremo.queries.customsearch.SplitNodesSearch;

public class PerformanceTest {
	public PerformanceTest(){
		super();
	}
	
	public Repository testRepositoryCreation(String name, String description) throws CoreException{
		System.out.println("========================================================================");
		long startTime = System.nanoTime();
		Repository repository = AssistantManager.getInstanceTest().createRepository(name, description);
		long endTime = System.nanoTime();
		System.out.println("Loaded " + repository.getName() + " " + (endTime - startTime) / 1e6 + " milis.");
		return repository;
	}
	
	public Resource testDescriptorCreation(Repository repository, String name, String description, String uri, FormatAssistant assistant) throws CoreException{
		long startTime = System.nanoTime();
		Resource resource = AssistantManager.getInstanceTest().createResourceDescriptor(repository, name, description, uri, assistant);
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime) / 1e9 + " secs. spend in loading " + resource.getName());
		return resource;
	}
	
	public Resource testResourceCreation(Repository repository, Resource descriptor, String name, String description, String uri, FormatAssistant assistant) throws CoreException{
		long startTime = System.nanoTime();
		Resource resource = AssistantManager.getInstanceTest().createResource(repository, descriptor, name, description, uri, assistant);
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime) / 1e9 + " secs. spend in loading " + resource.getName());
		return resource;
	}
	
	public void testSearchConfiguration(Repository repository, SimpleSearchConfiguration searchConfiguration, SearchResult searchResult){
		long startTime = System.nanoTime();
		AssistantManager.getInstanceTest().search(repository, searchConfiguration, searchResult);
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime) / 1e9 + " secs. spend in performing " + searchConfiguration.getName());
	}
	
	public static void main(String[] args) throws CoreException {
		PerformanceTest performanceTest = new PerformanceTest();
		// Queries
		Map<SimpleSearchConfiguration, SearchResult> configurations = new HashMap<SimpleSearchConfiguration, SearchResult>();
		
		// Query 1
		HierarchyLimitSearch hierarchyLimit = new HierarchyLimitSearch();
		hierarchyLimit.setName("Nodes too deep");
		hierarchyLimit.addPrimitiveTypeSearchOption("maxdepth", "Max Depth", Type.get("Int"));
		
		SearchResult hierarchyLimitResult = SemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
		PrimitiveTypeParamValue hierarchySearchResultOptionValue = SemanticmanagerFactory.eINSTANCE.createPrimitiveTypeParamValue();
		hierarchySearchResultOptionValue.setValue("1");	
		hierarchyLimitResult.getValues().add(hierarchySearchResultOptionValue);
		configurations.put(hierarchyLimit, hierarchyLimitResult);
		
		// Query 2
		InRefsOverloadedSearch refsOverloaded = new InRefsOverloadedSearch();
		refsOverloaded.setName("Nodes referred from too many others");
		hierarchyLimit.addPrimitiveTypeSearchOption("maxrefs", "Max Refs", Type.get("Int"));
		
		SearchResult refsOverloadedResult = SemanticmanagerFactory.eINSTANCE.createAtomicSearchResult();
		PrimitiveTypeParamValue primitiveTypeSearchResultOptionValue = SemanticmanagerFactory.eINSTANCE.createPrimitiveTypeParamValue();
		primitiveTypeSearchResultOptionValue.setValue("1");	
		refsOverloadedResult.getValues().add(primitiveTypeSearchResultOptionValue);
		configurations.put(refsOverloaded, refsOverloadedResult);
		
		// Query 3
		IsolatedClassesSearch isolatedClasses = new IsolatedClassesSearch();
		isolatedClasses.setName("Isolated nodes");
		isolatedClasses.setGrouped(true);
		
		SearchResult isolatedClassesResult = SemanticmanagerFactory.eINSTANCE.createGroupedSearchResult();
		configurations.put(isolatedClasses, isolatedClassesResult);
		
		// Query 4
		NodesWithoutDescriptionsSearch nodesWODescriptions = new NodesWithoutDescriptionsSearch();
		nodesWODescriptions.setName("Nodes without descriptions");
		nodesWODescriptions.setGrouped(true);
		
		SearchResult nodesWODescriptionsResult = SemanticmanagerFactory.eINSTANCE.createGroupedSearchResult();
		configurations.put(nodesWODescriptions, nodesWODescriptionsResult);
		
		// Query 5
		SplitNodesSearch splitNodesSearch = new SplitNodesSearch();
		splitNodesSearch.setName("Nodes Splitter");
		splitNodesSearch.setGrouped(true);
		
		SearchResult splitNodesSearchResult = SemanticmanagerFactory.eINSTANCE.createGroupedSearchResult();
		configurations.put(splitNodesSearch, splitNodesSearchResult);
		
		EcoreAssistant ecoreAssistant = new EcoreAssistant();
		performanceTest.testSetOfModel("petrinets/PetriNet.ecore", 4, ecoreAssistant, configurations);
    }
	
	public void testSetOfModel(String dirEcore, int set, FormatAssistant assistant, Map<SimpleSearchConfiguration, SearchResult> configurations) throws CoreException{
		File ecore = new File("/Users/angel/Desktop/workspace-test/uam.extremo.performance.tests/" + dirEcore);
		List<File> modelSet = getFilesForFolder(new File("/Users/angel/Desktop/workspace-test/uam.extremo.performance.tests/petrinets/model" + set));
		String ecorePath = ecore.getAbsolutePath();
		
		for(File model : modelSet){
			Repository repository = testRepositoryCreation(dirEcore + "/model" + set, dirEcore + "/model" + set);
			Resource descriptorPersons = testDescriptorCreation(repository, dirEcore, dirEcore, ecorePath, assistant);
			String modelName = model.getName();
			String modelUri = model.getAbsolutePath();
			testResourceCreation(repository, descriptorPersons, modelName, modelName, modelUri, assistant);
			
			for(Entry<SimpleSearchConfiguration, SearchResult> conf : configurations.entrySet()){				
				testSearchConfiguration(repository, conf.getKey(), conf.getValue());
			}
			
			AssistantManager.getInstance().getRepositoryManager().getRepositories().add(repository);
		}
	}
	
	private static List<File> getFilesForFolder(final File folder) {
		List<File> files = new ArrayList<File>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				files.addAll(getFilesForFolder(fileEntry));
			}
			else {
				files.add(fileEntry);
			}
		}
		
		return files;
	}
}