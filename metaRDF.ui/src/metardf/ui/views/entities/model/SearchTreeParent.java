package metardf.ui.views.entities.model;

import metaRDF.core.utils.Search;

public class SearchTreeParent extends TreeParent{
	private static final long serialVersionUID = 2855575125618775861L;
	private Search searchParameters = null;
	
	public SearchTreeParent(String name, Search searchParameters) {
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
