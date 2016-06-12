package metaRDF.core.model;

import java.io.Serializable;
import java.util.List;

public interface ISemanticGroup extends Serializable{
	ISemanticElement getKeyElement();
	void setKeyElement(ISemanticElement keyElement);
	
	List<ISemanticElement> getValueGroup();
	void setValueGroup(List<ISemanticElement> group);
}
