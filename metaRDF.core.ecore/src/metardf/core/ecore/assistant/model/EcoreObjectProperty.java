package metardf.core.ecore.assistant.model;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import metaRDF.core.model.ISemanticClass;
import metaRDF.core.model.impl.ObjectProperty;

public class EcoreObjectProperty extends ObjectProperty{
	EReference id = null;
	EClass range = null;
	
	public EcoreObjectProperty(EReference id, EClass range, String name, boolean isFromSuper, String description) {
		super(id, range, name, isFromSuper, description);
		this.id = id;
		this.range = range;
	}

	@Override
	public String getIdToString() {
		// TODO Auto-generated method stub
		return id.getName();
	}

	@Override
	public Object getRange() {
		return this.range;
	}

	@Override
	public ISemanticClass getRangeAsSemanticClass() {
		return new EcoreSemanticClass((EClass) getRange(), ((EClass) getRange()).getName(), ((EClass) getRange()).getName());
		//classes.add((ISemanticClass) semanticClass);
	}

	@Override
	public void setRange(Object range) {
		if(range instanceof EClass) this.range = (EClass) range;
	}

	@Override
	public void setRangeAsSemanticClass(ISemanticClass rangeSemanticClass) {
		// TODO Auto-generated method stub
		
	}
}
