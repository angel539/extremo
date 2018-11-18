
package uam.extremo.core;

import uam.extremo.core.DataProperty;
import uam.extremo.core.GroupedSearchResult;
import uam.extremo.core.NamedElement;
import uam.extremo.core.ObjectProperty;
import uam.extremo.core.Resource;
import uam.extremo.core.SearchConfiguration;
import uam.extremo.core.SemanticGroup;
import uam.extremo.core.SemanticNode;

public interface ExtensibleGroupedSearchResult extends GroupedSearchResult {
	SemanticGroup createSemanticGroup(String name, String description);
	void addSemanticNodeToSemanticGroup(SemanticGroup semanticGroup, SemanticNode semanticNode);
	void addDataPropertyToSemanticGroup(SemanticGroup semanticGroup, DataProperty dataProperty);
	void addObjectPropertyToSemanticGroup(SemanticGroup semanticGroup, ObjectProperty objectProperty);
	Object getOptionValue(String key);
	void addNamedElementToSemanticGroup(SemanticGroup semanticGroup, NamedElement namedElement);
	void addResourceToSemanticGroup(SemanticGroup semanticGroup, Resource resource);
	
	SearchConfiguration getConfiguration();
	void setConfiguration(SearchConfiguration value);
}
