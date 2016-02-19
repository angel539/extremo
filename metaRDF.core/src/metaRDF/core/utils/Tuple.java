package metaRDF.core.utils;

public class Tuple<X, Y> {
	public final X x;
	public final Y y;
	public int weight;
	
	public Tuple(X x, Y y, int weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}
}