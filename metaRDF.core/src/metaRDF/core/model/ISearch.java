package metaRDF.core.model;

import java.io.Serializable;
import java.util.List;
import metaRDF.core.search.TreeNode;

public interface ISearch extends Serializable{
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
}
