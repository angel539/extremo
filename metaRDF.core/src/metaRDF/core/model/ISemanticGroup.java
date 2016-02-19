package metaRDF.core.model;

import java.util.List;

public interface ISemanticGroup{
	ISemanticElement getKeyElement();
	void setKeyElement(ISemanticElement keyElement);
	
	List<ISemanticElement> getValueGroup();
	void setValueGroup(List<ISemanticElement> group);
}
