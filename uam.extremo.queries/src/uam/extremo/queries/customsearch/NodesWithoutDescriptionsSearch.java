package uam.extremo.queries.customsearch;

import java.util.List;

import semanticmanager.AtomicSearchResult;
import semanticmanager.SearchResult;
import semanticmanager.SemanticNode;
import semanticmanager.impl.ExtensibleCustomSearchImpl;
import semanticmanager.NamedElement;

public class NodesWithoutDescriptionsSearch extends ExtensibleCustomSearchImpl {
	@Override
	public void search(SearchResult result) {
		if (result instanceof AtomicSearchResult) {
			AtomicSearchResult atomicSearchResult = (AtomicSearchResult) result;
			List<NamedElement> nes = atomicSearchResult.getApplyOnElements();

			for(NamedElement ne : nes){
				if(!(ne instanceof SemanticNode)) continue;
				SemanticNode sn = (SemanticNode) ne;

				if((sn.getDescriptors() == null) || (sn.getDescriptors().isEmpty()))
					if(sn.getDescribes() == null || sn.getDescribes().isEmpty())
						atomicSearchResult.getElements().add(sn);
			}
		}
	}
}
