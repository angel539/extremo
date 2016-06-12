package metaRDF.core.model;

public interface IObjectProperty extends IProperty, Comparable<IObjectProperty>{
	ISemanticClass getRange();
	void setRange(ISemanticClass range);
}
