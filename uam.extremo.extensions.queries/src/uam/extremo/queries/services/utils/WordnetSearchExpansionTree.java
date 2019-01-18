package uam.extremo.queries.services.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import uam.extremo.queries.services.utils.Wordnet;

public class WordnetSearchExpansionTree {
	Wordnet wordnet = null;
	
	int[] weights;
	
	int relevanceR1;
	int relevanceR2;
	int relevanceR3;
	int relevanceR4;
	int maxWeight;
	
	int variance;
	TreeNode<String> searchTree;
	
	public WordnetSearchExpansionTree(int variance, int relevanceR1, int relevanceR2, int relevanceR3, int relevanceR4) {
		super();
		this.relevanceR1 = relevanceR1;
		this.relevanceR2 = relevanceR2;
		this.relevanceR3 = relevanceR3;
		this.relevanceR4 = relevanceR4;
		
		this.wordnet = new Wordnet();
	}

	public void expand(String searchField){
		expandLanguageTree(searchField);
		cleanRepeatedBranch();
		cleanSynsetsWithNoSense();
	}
	
	public void expandLanguageTree(String searchField){
		String[] root = StringUtils.splitByWholeSeparator(searchField, ",", 0);
		
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
					
					Map<String, Tuple<String[], String[]>> wordnetSynsetMap = wordnet.getSynonymsProposal(s);
					
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
					
					Map<String, Tuple<String[], String[]>> wordnetSynsetMap = wordnet.getSynonymsProposal(dataRChild.getData()[0]);
					
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
	
	synchronized void cleanRepeatedBranch(){
		for(TreeNode<String> child : this.searchTree.getChildren()) 
			cleanRepeatedBranch(this.searchTree, child);
	}
	
	void cleanRepeatedBranch(TreeNode<String> parent, TreeNode<String> child) {
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
	

	synchronized void cleanSynsetsWithNoSense() {
    	for(TreeNode<String> child : this.searchTree.getChildren()) 
    		cleanSynsetsWithNoSense(this.searchTree, child);
	}
    
	void cleanSynsetsWithNoSense(TreeNode<String> parent, TreeNode<String> child){
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
									
									if(!wordnet.getDerivation(synset, data).isEmpty()){
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
										
										if(!wordnet.getDerivation(synset, data).isEmpty()){
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
	
	public Map<String, Integer> getOrderSearchesListByWeight() {
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
	
	boolean isOnTheList(Map<String, Integer> searches, String data) {
		for(Entry<String, Integer> s : searches.entrySet()){
			if(StringUtils.capitalize(s.getKey()).compareTo(StringUtils.capitalize(data)) == 0) return true;
		}
		return false;
	}

	PriorityQueue<TreeNode<String>> getOrderSearchesListByWeightHelper(TreeNode<String> root){
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
	
	public void calculateWeights() {
		weights = new int[4];
		weights[0] = (relevanceR1 * maxWeight) / 10;
		weights[1] = (relevanceR2 * maxWeight) / 10;
		weights[2] = (relevanceR3 * maxWeight) / 10;
		weights[3] = (relevanceR4 * maxWeight) / 10;
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
}
