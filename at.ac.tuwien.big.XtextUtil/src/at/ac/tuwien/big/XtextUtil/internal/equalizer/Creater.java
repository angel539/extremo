package at.ac.tuwien.big.XtextUtil.internal.equalizer;

public interface Creater<T,U> {
	
	public T create(U forValue);

}
