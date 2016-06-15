package metardf.ui.views.searchtree.model;

import metaRDF.core.model.ISearch;

public class SearchWordTreeParent extends TreeParent{
	ISearch search;
	
	public ISearch getSearch() {
		return search;
	}

	public void setSearch(ISearch search) {
		this.search = search;
	}

	public SearchWordTreeParent(ISearch search) {
		super(search);
		this.search = search;
	}
}
