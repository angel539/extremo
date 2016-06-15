package metardf.ui.views.searchtree.model;

public class StrategyTreeParent extends TreeParent{
	String strategy;
	
	public String getStrategy() {
		return strategy;
	}

	public void setPointSettings(String strategy) {
		this.strategy = strategy;
	}

	public StrategyTreeParent(String strategy) {
		super(strategy);
		this.strategy = strategy;
	}
}
