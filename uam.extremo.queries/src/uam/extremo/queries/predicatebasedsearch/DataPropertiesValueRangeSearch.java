package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import uam.extremo.core.DataProperty;
import uam.extremo.core.NamedElement;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.impl.ExtensiblePredicateBasedSearchImpl;

public class DataPropertiesValueRangeSearch extends ExtensiblePredicateBasedSearchImpl{
	Object minValuefield = null;
	Object maxValuefield = null;
	
	@Override
	public void init(EList<SearchParamValue> inputs) {
		minValuefield = getOptionValueKey("minvaluefield", inputs);
		maxValuefield = getOptionValueKey("maxvaluefield", inputs);
	}
	
	@Override
	public boolean matches(NamedElement namedElement) {
		if (namedElement instanceof DataProperty) {
			if((minValuefield != null) 
					&& (minValuefield instanceof String) 
					&& (maxValuefield != null) 
					&& (maxValuefield instanceof String)){
				int min = Integer.parseInt((String) minValuefield);
				int max = Integer.parseInt((String) maxValuefield);

				int value = Integer.parseInt(((DataProperty) namedElement).getValue());
				
				if((min <= value) && (value <= max))
					return true;
				else
					return false;
			}
			return false;
		}
		return false;
	}
}
