package uam.extremo.queries.customsearch;

import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.impl.ExtensibleCustomSearchImpl;

import java.util.ArrayList;
import java.util.List;

import semanticmanager.GroupedSearchResult;
import semanticmanager.NamedElement;

public class SplitNodesSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult result) {
		if (result instanceof GroupedSearchResult) {
			GroupedSearchResult groupedSearchResult = (GroupedSearchResult) result;
			
			List<NamedElement> nes = groupedSearchResult.getApplyOnElements();
			
			for(NamedElement ne : nes){
				if(!(ne instanceof SemanticNode)) continue;
				if((ne.getDescriptors() == null) || (ne.getDescriptors().isEmpty())) continue;
				SemanticNode sn = (SemanticNode)ne;

				if(sn.getSupers() == null || sn.getSupers().size() == 0){
					if((sn.getSubs() != null) && (sn.getSubs().size() > 0)){
						SemanticGroup group = SemanticmanagerFactory.eINSTANCE.createSemanticGroup();
						group.getElements().addAll(getAllSubs(sn));
						groupedSearchResult.getGroups().add(group);
					}
				}
			}
		}	
	}
	
	public List<SemanticNode> getAllSubs(SemanticNode node){
		List<SemanticNode> nonvisited = new ArrayList<SemanticNode>();
		List<SemanticNode> subs = new ArrayList<SemanticNode>();
			
		nonvisited.addAll(node.getSubs());
			
		while(!nonvisited.isEmpty()){
			SemanticNode sn = nonvisited.get(0);
			
			if(!subs.contains(sn)){
				subs.add(sn);
				nonvisited.addAll(sn.getSubs());
			}
			nonvisited.remove(sn);
		}
			
		return subs;
	}

}
