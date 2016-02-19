package metaRDF.core.model;

public interface IDataProperty extends IProperty, Comparable<IDataProperty>{
	String getType();
	void setType(String type);
}
