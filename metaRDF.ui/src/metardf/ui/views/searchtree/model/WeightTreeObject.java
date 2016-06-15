package metardf.ui.views.searchtree.model;

public class WeightTreeObject extends TreeObject{
	private int[] weights;
	
	public WeightTreeObject(String word) {
		super(word);
	}
	
	public WeightTreeObject(int[] weights) {
		super(weights);
		this.setWeights(weights);
	}

	public int[] getWeights() {
		return weights;
	}

	public void setWeights(int[] weights) {
		this.weights = weights;
	}
}
