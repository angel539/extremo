package uam.extremo.queries.predicatebasedsearch;

import org.eclipse.emf.common.util.EList;

import semanticmanager.DataProperty;
import semanticmanager.NamedElement;
import semanticmanager.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.SearchParamValue;

public class DataPropertiesValueRangeSearch extends ExtensiblePredicateBasedSearchImpl{
	@Override
	public boolean matches(NamedElement namedElement, EList<SearchParamValue> inps) {
		if (namedElement instanceof DataProperty) {			
			Object minValuefield = getOptionValueKey("minvaluefield", inps);
			Object maxValuefield = getOptionValueKey("maxvaluefield", inps);
			
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
