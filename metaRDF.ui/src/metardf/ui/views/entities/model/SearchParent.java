package metardf.ui.views.entities.model;

import metaRDF.core.model.impl.Search;

public class SearchParent extends TreeParent{
	private Search searchParameters = null;
	
	public SearchParent(String name, Search searchParameters) {
		super(name);
		this.setSearchParameters(searchParameters);
	}

	public Search getSearchParameters() {
		return searchParameters;
	}

	public void setSearchParameters(Search searchParameters) {
		this.searchParameters = searchParameters;
	}	
}
