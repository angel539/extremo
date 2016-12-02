package metaRDF.core.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;

import metaRDF.core.model.ISemanticResource;
import metaRDF.core.model.ISearch;
import metaRDF.core.search.TreeNode;
import metaRDF.core.wordnet.Wordnet;

public class Search implements ISearch {
	private static final long serialVersionUID = 6601600129626661060L;
	String searchField = "";
	String description = "";
	
	boolean isFromSupers;
	boolean isFromEquivs;
	
	boolean onlyDirectSuperclasses;
	boolean onlyDirectSubclasses;
	boolean entitiesCompacted;
	
	private int relevanceR1;
	private int relevanceR2;
	private int relevanceR3;
	private int relevanceR4;
	private int relevanceR5;
	
	private int maxWeight;
	private int[] weights;
	private int variance;
	
	private String name;
	private String strategyApplied;
	
	TreeNode<String> searchTree;
	
	/*
	 * kind = 0: busqueda general
	 * kind = 1: busqueda particular.
	 * kind = 2: palabra suelta para buscar en wordnet.
	 * kind = 3: synset de wordnet.
	 */
	List<ISemanticResource> resourcesSearched = null;
	
	public Search(){
		super();
	}
	
	public Search(String searchField, boolean isFromSupers, boolean isFromEquivs) {
		super();
		this.searchField = searchField;
		this.isFromSupers = isFromSupers;
		this.isFromEquivs = isFromEquivs;
	}
	
	public Search(String searchField, boolean isFromSupers, boolean isFromEquivs, boolean onlyDirectSuperclasses, boolean onlyDirectSubclasses) {
		super();
		this.searchField = searchField;
		this.isFromSupers = isFromSupers;
		this.isFromEquivs = isFromEquivs;
		this.onlyDirectSuperclasses = onlyDirectSuperclasses;
		this.onlyDirectSubclasses = onlyDirectSubclasses;
	}
	
	public Search(String searchField, boolean isFromSupers, boolean isFromEquivs, boolean onlyDirectSuperclasses, boolean onlyDirectSubclasses, boolean entitiesCompacted) {
		super();
		this.searchField = searchField;
		this.isFromSupers = isFromSupers;
		this.isFromEquivs = isFromEquivs;
		this.onlyDirectSuperclasses = onlyDirectSuperclasses;
		this.onlyDirectSubclasses = onlyDirectSubclasses;
		this.entitiesCompacted = entitiesCompacted;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	
	@Override
	public TreeNode<String> getSearchTree() {
		return searchTree;
	}

	@Override
	public void setSearchTree(TreeNode<String> searchTree) {
		this.searchTree = searchTree;
	}
	
	@Override
	public boolean isFromSupers() {
		return this.isFromSupers;
	}

	@Override
	public void setIsFromSupers(boolean isFromSupers) {
		this.isFromSupers = isFromSupers;
	}

	@Override
	public boolean isFromEquivs() {
		return this.isFromEquivs;
	}

	@Override
	public void setIsFromEquivs(boolean isFromEquivs) {
		this.isFromEquivs = isFromEquivs;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public List<ISemanticResource> getResourcesSearched() {
		if(this.resourcesSearched == null) 
			this.resourcesSearched = new ArrayList<ISemanticResource>();
		return this.resourcesSearched;
	}

	@Override
	public void setResourcesSearched(List<ISemanticResource> resourcesSearched) {
		this.resourcesSearched = resourcesSearched;
	}

	@Override
	public boolean isOnlyDirectSuperclasses() {
		return this.onlyDirectSuperclasses;
	}

	@Override
	public void setOnlyDirectSuperclasses(boolean onlyDirectSuperclasses) {
		this.onlyDirectSuperclasses = onlyDirectSuperclasses; 
	}

	@Override
	public boolean isOnlyDirectSubclasses() {
		return this.onlyDirectSubclasses;
	}

	@Override
	public void setOnlyDirectSubclasses(boolean onlyDirectSubclasses) {
		this.onlyDirectSubclasses = onlyDirectSubclasses;
	}

	@Override
	public boolean areEntitiesCompacted() {
		return this.entitiesCompacted;
	}

	@Override
	public void setEntitiesCompacted(boolean entitiesCompacted) {
		this.entitiesCompacted = entitiesCompacted;
	}
	
	private void expandLanguageTree(){
		String[] root = StringUtils.splitByWholeSeparator(this.searchField, ",", 0);
		
		this.searchTree = new TreeNode<String>();
		this.searchTree.setData(root);
		this.searchTree.setKind(0);
		
		for(String dataR : root){
			TreeNode<String> dataRChild = new TreeNode<String>();
			String[] dataRSeparated = StringUtils.splitByCharacterTypeCamelCase(dataR);
			
			List<String> dataRSeparatedNoBlank = new ArrayList<String>();
			for(String dataRSep : dataRSeparated){
				if((!StringUtils.isWhitespace(dataRSep)) && (!StringUtils.isBlank(dataRSep))){
					dataRSeparatedNoBlank.add(StringUtils.capitalize(dataRSep));
				}
			}	
			
			dataRChild.setData(dataRSeparatedNoBlank.toArray(new String[dataRSeparatedNoBlank.size()]));
			dataRChild.setKind(1);
			
			if(dataRChild.getData().length > 1){
				for(String s : dataRChild.getData()){
					TreeNode<String> atomicWordNode = new TreeNode<String>();
					atomicWordNode.setData(new String[]{s});
					atomicWordNode.setKind(2);
					dataRChild.getChildren().add(atomicWordNode);
					
					Map<String, Tuple<String[], String[]>> wordnetSynsetMap = Wordnet.getInstance().getSynonymsProposal(s);
					
					for(Entry<String, Tuple<String[], String[]>> entry : wordnetSynsetMap.entrySet()){
						TreeNode<String> synsetWordnetNode = new TreeNode<String>();
						synsetWordnetNode.setDefinition(entry.getKey());
						
						synsetWordnetNode.setData(entry.getValue().x);
						synsetWordnetNode.setUsages(entry.getValue().y);
						
						synsetWordnetNode.setCountWordnet(entry.getValue().weight);
						
						synsetWordnetNode.setKind(3);
						atomicWordNode.getChildren().add(synsetWordnetNode);
					}
				}
			}
			else{
				if(dataRChild.getData().length > 0){
					dataRChild.setKind(2);
					Map<String, Tuple<String[], String[]>> wordnetSynsetMap = Wordnet.getInstance().getSynonymsProposal(dataRChild.getData()[0]);
					
					for(Entry<String, Tuple<String[], String[]>> entry : wordnetSynsetMap.entrySet()){
						TreeNode<String> synsetWordnetNode = new TreeNode<String>();
						synsetWordnetNode.setDefinition(entry.getKey());
						synsetWordnetNode.setData(entry.getValue().x);
						synsetWordnetNode.setUsages(entry.getValue().y);
						synsetWordnetNode.setCountWordnet(entry.getValue().weight);
						
						synsetWordnetNode.setKind(3);
						dataRChild.getChildren().add(synsetWordnetNode);
					}
				}
				else{
					dataRChild.setKind(-1);
				}
			}

			this.searchTree.getChildren().add(dataRChild);
		}
	}
	
	/*private synchronized void cleanList(){
		cleanListPostHelper(this.searchTree);
	}*/
	
	//metodo recursivo para recorrido en preorden
    /*private void cleanListPostHelper(TreeNode<String> root){
    	 if(root == null) return;
    	 
    	 for(TreeNode<String> child : root.getChildren()) cleanListPostHelper(child);
    	 
    	 if(root.getKind() == 2){
    		 //eliminar las palabras repetidas de las listas
			 for(TreeNode<String> child : root.getChildren()){
					 for(String s : child.getData()){
						 String string1 = StringUtils.capitalize(s);
						 String string2 = StringUtils.capitalize(root.getData()[0]);
						 
						 if(string1.compareTo(string2)==0){
							 String[] cleaned = ArrayUtils.removeElement(child.getData(), s);
							 child.setData(cleaned);
						 }
					 }
			 }
    	 }
    }*/
	
	private synchronized void cleanRepeatedBranch(){
		for(TreeNode<String> child : this.searchTree.getChildren()) 
			cleanRepeatedBranch(this.searchTree, child);
	}
	
	private void cleanRepeatedBranch(TreeNode<String> parent, TreeNode<String> child) {
		if((child.getKind() == 1) || (child.getKind() == 2)){
			for(TreeNode<String> sibling : parent.getChildren()){
				if(!sibling.equals(child)){
					if(Arrays.equals(sibling.getData(), child.getData())){
						sibling.setValid(false);
						child.setValid(true);
					}
				}
				
				for(TreeNode<String> nephew : sibling.getChildren()){
					if(Arrays.equals(nephew.getData(), child.getData())){
						child.setValid(false);
						nephew.setValid(true);
					}
				}
			}
		}
		
		for(TreeNode<String> grandchild : child.getChildren()) cleanRepeatedBranch(child, grandchild);
	}
    
    private synchronized void cleanSynsetsWithNoSense() {
    	for(TreeNode<String> child : this.searchTree.getChildren()) 
    		cleanSynsetsWithNoSense(this.searchTree, child);
	}
    

	private void cleanSynsetsWithNoSense(TreeNode<String> parent, TreeNode<String> child){
   	 	if((child == null) || (!child.isValid())) return;
   	 	
   	 	calculateWeights();
   	 	
   	 	if(child.getKind() == 2){
	   	 	for(TreeNode<String> sibling : parent.getChildren()){
				if((!sibling.equals(child)) && (sibling.getKind() == 2)){
					for(String data : sibling.getData()){

						for(TreeNode<String> grandchild : child.getChildren()){
							String[] synsets = grandchild.getData();
							if(synsets != null){
								for(String synset : synsets){
									if(StringUtils.containsIgnoreCase(synset, data)){
										grandchild.addPoints(weights[0]);
									}
									
									if(!Wordnet.getInstance().getDerivation(synset, data).isEmpty()){
										grandchild.addPoints(weights[1]);
									}
								}
							}
							
							String definition = grandchild.getDefinition();
							if(definition != null){
								String[] sppliteds = StringUtils.split(definition, " ");
								for(String spplited : sppliteds){
									if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
										grandchild.addPoints(weights[2]);
									}
								}
							}
							
							String[] examples = grandchild.getUsages();
							for(String example : examples){
								if(example != null){
									String[] sppliteds = StringUtils.split(example, " ");
									for(String spplited : sppliteds){
										if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
											grandchild.addPoints(weights[3]);
										}
									}
								}
							}
						}
					}
					for(TreeNode<String> cousin : sibling.getChildren()){
						for(String data : cousin.getData()){
							for(TreeNode<String> grandchild : child.getChildren()){
								String[] synsets = grandchild.getData();
								if(synsets != null){
									for(String synset : synsets){
										if(StringUtils.containsIgnoreCase(synset, data)){
											grandchild.addPoints(weights[0]*(variance/100));
										}
										
										if(!Wordnet.getInstance().getDerivation(synset, data).isEmpty()){
											grandchild.addPoints(weights[1]*(variance/100));
										}
									}
								}
								
								String definition = grandchild.getDefinition();
								if(definition != null){
									String[] sppliteds = StringUtils.split(definition, " ");
									for(String spplited : sppliteds){
										if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
											grandchild.addPoints(weights[2]*(variance/100));
										}
									}
								}
								
								String[] examples = grandchild.getUsages();
								for(String example : examples){
									if(example != null){
										String[] sppliteds = StringUtils.split(example, " ");
										for(String spplited : sppliteds){
											if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
												grandchild.addPoints(weights[3]*(variance/100));
											}
										}
									}
								}
							}
						}
					}
				}
			}
   	 	}
   	 	
   	 	for(TreeNode<String> grandchild : child.getChildren()) cleanSynsetsWithNoSense(child, grandchild);
   }

	public void expand(){
		expandLanguageTree();
		cleanRepeatedBranch();
		cleanSynsetsWithNoSense();
	}
	
	public synchronized Map<String, Integer> getOrderSearchesListByWeight() {
		Map<String, Integer> searches = new TreeMap<String, Integer>();
		
		for(TreeNode<String> child : this.searchTree.getChildren()){
			for(String data : child.getData()){
		    	if(!isOnTheList(searches, data)){
		    		searches.put(data, maxWeight*10);
		    	}
		    }
		}
		
		PriorityQueue<TreeNode<String>> queue = getOrderSearchesListByWeightHelper(this.searchTree);
		Iterator<TreeNode<String>> iter = queue.iterator();
		
		while (iter.hasNext()) {
		    TreeNode<String> current = iter.next();
		    for(String data : current.getData()){
		    	if(!isOnTheList(searches, data)){
		    		searches.put(data, current.getPoints());
		    	}
		    }
		}
		
		return searches;
	}
	
	private boolean isOnTheList(Map<String, Integer> searches, String data) {
		for(Entry<String, Integer> s : searches.entrySet()){
			if(StringUtils.capitalize(s.getKey()).compareTo(StringUtils.capitalize(data)) == 0) return true;
		}
		return false;
	}

	private PriorityQueue<TreeNode<String>> getOrderSearchesListByWeightHelper(TreeNode<String> root){
		TreeNodeSynsetComparator comparator = new TreeNodeSynsetComparator();
		PriorityQueue<TreeNode<String>> queue = new PriorityQueue<TreeNode<String>>(comparator);
		
		if(root == null) return queue;
		if(!root.isValid()) return queue;
		if(root.getKind() == 3){
			if((root.getCountWordnet() > 0) || (root.getPoints() > 0)){
				queue.add(root); 
			}
		}
		
		for(TreeNode<String> child : root.getChildren()) queue.addAll(getOrderSearchesListByWeightHelper(child));
		
		return queue;
	}
	
	class TreeNodeSynsetComparator implements Comparator<TreeNode<String>>{
		@Override
		public int compare(TreeNode<String> node1, TreeNode<String> node2) {
			if(node1.getPoints() > node2.getPoints()){
				return 1;
			}
			if(node1.getPoints() < node2.getPoints()){
				return -1;
			}
			if(node1.getPoints() == node2.getPoints()){
				if(node1.getCountWordnet() > node2.getCountWordnet()){
					return 1;
				}
				if(node1.getCountWordnet() < node2.getCountWordnet()){
					return -1;
				}
			}
		
			return 0;
		}
		
	}
	
	public List<String[]> getLimitedOrderSearchesListByWeight(int limit){
		List<String[]> searches = new ArrayList<String[]>();
		return searches;
	}
	
	public void calculateWeights() {
		weights = new int[4];
		weights[0] = (relevanceR1 * maxWeight) / 10;
		weights[1] = (relevanceR2 * maxWeight) / 10;
		weights[2] = (relevanceR3 * maxWeight) / 10;
		weights[3] = (relevanceR4 * maxWeight) / 10;
	}
	
	public static void main(String [] args){
		Search search = new Search("process, activity, task", false, false);
		
		search.setMaxWeight(100);
		search.setRelevanceR1(8);
		search.setRelevanceR2(2);
		search.setRelevanceR3(10);
		search.setRelevanceR4(2);
		search.setRelevanceR5(10);
		search.calculateWeights();
		search.expand();
		
		Map<String, Integer> toSearch = search.getOrderSearchesListByWeight();
		Map<String, Integer> map = sortByValues(toSearch); 
		
		List<String> lines = new ArrayList<String>();
		lines.add("Weights " + Arrays.toString(search.getWeights()));
		for(Entry<String, Integer> entry : map.entrySet()){
			lines.add("[" + entry.getValue() + "]		" + entry.getKey());
		}
		
		List<String> reverseLines = Lists.reverse(lines);
		
		Path file = Paths.get("sample.txt");
		try {
			Files.write(file, reverseLines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static HashMap<String, Integer> sortByValues(Map<String, Integer> toSearch) { 
	       List list = new LinkedList(toSearch.entrySet());
	       
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });

	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	}
	
	public int[] getWeights() {
		return weights;
	}

	public void setWeights(int[] weights) {
		this.weights = weights;
	}
	
	public int getRelevanceR1() {
		return relevanceR1;
	}

	public void setRelevanceR1(int relevanceR1) {
		this.relevanceR1 = relevanceR1;
	}

	public int getRelevanceR2() {
		return relevanceR2;
	}

	public void setRelevanceR2(int relevanceR2) {
		this.relevanceR2 = relevanceR2;
	}

	public int getRelevanceR3() {
		return relevanceR3;
	}

	public void setRelevanceR3(int relevanceR3) {
		this.relevanceR3 = relevanceR3;
	}

	public int getRelevanceR4() {
		return relevanceR4;
	}

	public void setRelevanceR4(int relevanceR4) {
		this.relevanceR4 = relevanceR4;
	}

	public int getRelevanceR5() {
		return relevanceR5;
	}

	public void setRelevanceR5(int relevanceR5) {
		this.relevanceR5 = relevanceR5;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getStrategyApplied() {
		return this.strategyApplied;
	}

	@Override
	public void setStrategyApplied(String strategyApplied) {
		this.strategyApplied = strategyApplied;
	}

	/*public ProbabilisticDistribution getDistribution() {
		return distribution;
	}

	public void setDistribution(ProbabilisticDistribution distribution) {
		this.distribution = distribution;
	}*/
}
