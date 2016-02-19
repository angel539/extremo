package metaRDF.core.model.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import org.apache.commons.lang3.StringUtils;

import metaRDF.core.model.IResource;
import metaRDF.core.model.ISearch;
import metaRDF.core.search.TreeNode;
import metaRDF.core.utils.Tuple;
import metaRDF.core.wordnet.Wordnet;

public class Search implements ISearch {
	String searchField = "";
	String description = "";
	
	boolean isFromSupers;
	boolean isFromEquivs;
	
	boolean onlyDirectSuperclasses;
	boolean onlyDirectSubclasses;
	boolean entitiesCompacted;
	
	TreeNode<String> searchTree;
	/*
	 * kind = 0: busqueda general
	 * kind = 1: busqueda particular.
	 * kind = 2: palabra suelta para buscar en wordnet.
	 * kind = 3: synset de wordnet.
	 */
	List<IResource> resourcesSearched = null;
	
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
	public List<IResource> getResourcesSearched() {
		if(this.resourcesSearched == null) 
			this.resourcesSearched = new ArrayList<IResource>();
		return this.resourcesSearched;
	}

	@Override
	public void setResourcesSearched(List<IResource> resourcesSearched) {
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
		//ejemplo: busqueda: process, Task, DataFlow, flow --> [process; Task; DataFlow; data flow; flow]
		String[] root = StringUtils.splitByWholeSeparator(this.searchField, ",", 0);
		
		this.searchTree = new TreeNode<String>();
		this.searchTree.setData(root); // le asigno al arbol la busqueda completa... compone el nodo root
		this.searchTree.setKind(0); // el peso para llegar aqui es 0. sin esfuerzo
		
		// para cada uno de los datos insertados creamos un hijo...
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
					
					// a partir de aqui construimos la busqueda de wordnet	
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
					// a partir de aqui construimos la busqueda de wordnet	
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
					dataRChild.setKind(-1); // parseado como nodo erroneo
				}
				// a partir de aqui construimos la busqueda de wordnet
			}
			
			//this.searchTree.setKind(1);
			this.searchTree.getChildren().add(dataRChild);
		}
		//ahora tengo un arbol donde:
		//root -> data: process, Task, DataFlow, data flow, flow
		//root -> children: process; Task; Data, Flow; data, flow; flow
		
		//toca podar el arbol en ramas que evaluen lo mismo.
		//...
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
		//if((parent == null) || (child == null)) return;
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
    	
    	//markMaxPointsAsNoValid(this.searchTree, 0);
	}
    
    /*private void markMaxPointsAsNoValid(TreeNode<String> root, int minLimit) {
    	if(root == null) return;
    	
    	for(TreeNode<String> child : root.getChildren()) markMaxPointsAsNoValid(child, minLimit);
    	
    	if((root.getKind() == 3) && (root.getPoints() <= minLimit)){
    		root.setValid(false);
    	}
	}*/

	private void cleanSynsetsWithNoSense(TreeNode<String> parent, TreeNode<String> child){
   	 	if((child == null) || (!child.isValid())) return;
   	 	
   	 	if(child.getKind() == 2){ // it has
	   	 	for(TreeNode<String> sibling : parent.getChildren()){
				if((!sibling.equals(child)) && (sibling.getKind() == 2)){
					for(String data : sibling.getData()){
						// cojo el valor del data de mis hermanos y lo comparo con la lista de sinonimos de mis significados (hijos)
						// comparar tios con sobrinos.
						
						for(TreeNode<String> grandchild : child.getChildren()){
							String[] synsets = grandchild.getData();
							if(synsets != null){
								for(String synset : synsets){
									if(StringUtils.containsIgnoreCase(synset, data)){
										grandchild.addPoints(40);
									}
									
									if(!Wordnet.getInstance().getDerivation(synset, data).isEmpty()){
										grandchild.addPoints(30);
									}
								}
							}
							
							String definition = grandchild.getDefinition();
							if(definition != null){
								String[] sppliteds = StringUtils.split(definition, " ");
								for(String spplited : sppliteds){
									if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
										grandchild.addPoints(20);
									}
								}
							}
							
							String[] examples = grandchild.getUsages();
							for(String example : examples){
								if(example != null){
									String[] sppliteds = StringUtils.split(example, " ");
									for(String spplited : sppliteds){
										if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
											grandchild.addPoints(15);
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
											grandchild.addPoints(30);
										}
										
										if(!Wordnet.getInstance().getDerivation(synset, data).isEmpty()){
											grandchild.addPoints(20);
										}
									}
								}
								
								String definition = grandchild.getDefinition();
								if(definition != null){
									String[] sppliteds = StringUtils.split(definition, " ");
									for(String spplited : sppliteds){
										if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
											grandchild.addPoints(10);
										}
									}
								}
								
								String[] examples = grandchild.getUsages();
								for(String example : examples){
									if(example != null){
										String[] sppliteds = StringUtils.split(example, " ");
										for(String spplited : sppliteds){
											if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
												grandchild.addPoints(5);
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
		//cleanList();
		cleanRepeatedBranch();
		cleanSynsetsWithNoSense();
	}
	
	public synchronized Map<String, Integer> getOrderSearchesListByWeight() {
		Map<String, Integer> searches = new HashMap<String, Integer>();
		
		for(TreeNode<String> child : this.searchTree.getChildren()){
			for(String data : child.getData()){
		    	if(!isOnTheList(searches, data)){
		    		searches.put(data, 1000);
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
		/*Set<String> hs = new HashSet<>();
		hs.addAll(searches);
		searches.clear();
		searches.addAll(hs);*/
		
		return searches;
	}
	
	private boolean isOnTheList(Map<String, Integer> searches, String data) {
		for(Entry<String, Integer> s : searches.entrySet()){
			//if(s.compareTo(data) == 0) return true;
			if(StringUtils.capitalize(s.getKey()).compareTo(StringUtils.capitalize(data)) == 0) return true;
		}
		return false;
	}

	private PriorityQueue<TreeNode<String>> getOrderSearchesListByWeightHelper(TreeNode<String> root){
		TreeNodeSynsetComparator comparator = new TreeNodeSynsetComparator();
		PriorityQueue<TreeNode<String>> queue = new PriorityQueue<TreeNode<String>>(comparator);
		
		if(root == null) return queue;
		if(!root.isValid()) return queue; // devolver la lista vacia
		//List<TreeNode<String>> searches = new ArrayList<TreeNode<String>>();
		/*
		 * kind = 0: busqueda general
		 * kind = 1: busqueda particular.
		 * kind = 2: palabra suelta para buscar en wordnet.
		 * kind = 3: synset de wordnet.
		 */
		if(root.getKind() == 3){ // es un synset con puntos.
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
    /*private int height(TreeNode<String> node) {
        int height = -1;
        if (node != null) {
            Queue<TreeNode<String>> thisLevel = new LinkedList<TreeNode<String>>(),
                            nextLevel = new LinkedList<TreeNode<String>>();
            thisLevel.add(node);
            
            while (null != (node = thisLevel.poll())) {
            	for(TreeNode<String> child : node.getChildren()){
            		if(child != null) nextLevel.add(child);
            	}
            	
                if (thisLevel.isEmpty()) {
                    height++;
                    Queue<TreeNode<String>> swapTemp = thisLevel;
                    thisLevel = nextLevel;
                    nextLevel = swapTemp;
                }
            }
        }
        return height;
    }*/
	
	public static void main(String [] args){
		Search search = new Search("class, instance, reference, association, type, object, feature, concept, relation, relationship", false, false);
		search.expand();
		Map<String, Integer> toSearch = search.getOrderSearchesListByWeight();
		
		for(Entry<String, Integer> miniList : toSearch.entrySet()) System.out.println(miniList.getValue() + "...." + miniList.getKey());
	}
}
