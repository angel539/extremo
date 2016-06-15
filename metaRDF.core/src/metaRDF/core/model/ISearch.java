package metaRDF.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import metaRDF.core.search.TreeNode;

public interface ISearch extends Serializable{
	String getName();
	void setName(String name);
	
	TreeNode<String> getSearchTree();
	void setSearchTree(TreeNode<String> searchTree);
	
	boolean isFromEquivs();
	void setIsFromEquivs(boolean isFromEquivs);
	
	boolean isOnlyDirectSuperclasses();
	void setOnlyDirectSuperclasses(boolean onlyDirectSuperclasses);
	
	boolean isOnlyDirectSubclasses();
	void setOnlyDirectSubclasses(boolean onlyDirectSubclasses);
	
	boolean areEntitiesCompacted();
	void setEntitiesCompacted(boolean entitiesCompacted);
	
	String getDescription();
	void setDescription(String description);
	
	boolean isFromSupers();
	void setIsFromSupers(boolean isFromSupers);
	
	List<IResource> getResourcesSearched();
	void setResourcesSearched(List<IResource> repositoriesSearched);
	
	String getStrategyApplied();
	void setStrategyApplied(String strategy);
	
	Map<String, Integer> getOrderSearchesListByWeight();
	
	int[] getWeights();

	void setWeights(int[] weights);
	
	int getRelevanceR1();
	void setRelevanceR1(int relevanceR1);

	int getRelevanceR2();

	void setRelevanceR2(int relevanceR2);

	int getRelevanceR3();

	void setRelevanceR3(int relevanceR3);

	int getRelevanceR4();

	void setRelevanceR4(int relevanceR4);

	int getRelevanceR5();

	void setRelevanceR5(int relevanceR5);

	int getMaxWeight();

	void setMaxWeight(int maxWeight);
}
