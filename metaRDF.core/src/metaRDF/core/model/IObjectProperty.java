package metaRDF.core.model;

public interface IObjectProperty extends IProperty, Comparable<IObjectProperty>{
	Object getRange();
	void setRange(Object range);
	ISemanticClass getRangeAsSemanticClass();
	void setRangeAsSemanticClass(ISemanticClass rangeSemanticClass);
}
