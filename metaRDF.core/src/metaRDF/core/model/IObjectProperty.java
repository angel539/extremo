package metaRDF.core.model;

public interface IObjectProperty extends IProperty{
	Object getRange();
	void setRange(Object range);
	ISemanticClass getRangeAsSemanticClass();
	void setRangeAsSemanticClass(ISemanticClass rangeSemanticClass);
}
