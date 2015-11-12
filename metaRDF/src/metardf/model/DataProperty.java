package metardf.model;

public interface DataProperty extends Property{
	Datatype getRange();
	String toString();
}
