package uam.extremo.core.impl;

import org.eclipse.emf.ecore.EDataType;

import uam.extremo.core.ExtendedSemanticmanagerFactory;
import uam.extremo.core.ExtensibleAtomicSearchResult;
import uam.extremo.core.ExtensibleGroupedSearchResult;
import uam.extremo.core.impl.ExtensibleAtomicSearchResultImpl;
import uam.extremo.core.impl.ExtensibleGroupedSearchResultImpl;
import uam.extremo.core.impl.SemanticmanagerFactoryImpl;

public class ExtendedSemanticmanagerFactoryImpl extends SemanticmanagerFactoryImpl implements ExtendedSemanticmanagerFactory {
	@Override
	public Object createJavaObjectFromString(EDataType eDataType, String initialValue) {
		return new Object();
	}

	@Override
	public String convertJavaObjectToString(EDataType eDataType, Object instanceValue) {
		String serialize = eDataType.getName() + "/" + eDataType.getInstanceClassName();
		return serialize;	
	}

	/*@Override
	public ExtensibleCustomSearch createCustomSearch() {
		ExtensibleCustomSearchImpl customSearch = new ExtensibleCustomSearchImpl();
		return customSearch;
	}*/

	/*@Override
	public ExtensiblePredicateBasedSearch createPredicateBasedSearch() {
		ExtensiblePredicateBasedSearchImpl predicateBasedSearch = new ExtensiblePredicateBasedSearchImpl();
		return predicateBasedSearch;
	}*/

	/*@Override
	public ExtensibleService createService() {
		ExtensibleServiceImpl service = new ExtensibleServiceImpl();
		return service;
	}

	@Override
	public ExtensibleConstraintInterpreter createConstraintInterpreter() {
		ExtensibleConstraintInterpreterImpl constraintInterpreter = new ExtensibleConstraintInterpreterImpl();
		return constraintInterpreter;
	}*/
	
	@Override
	public ExtensibleAtomicSearchResult createAtomicSearchResult() {
		ExtensibleAtomicSearchResultImpl atomicSearchResult = new ExtensibleAtomicSearchResultImpl();
		return atomicSearchResult;
	}
	
	@Override
	public ExtensibleGroupedSearchResult createGroupedSearchResult() {
		ExtensibleGroupedSearchResultImpl groupedSearchResult = new ExtensibleGroupedSearchResultImpl();
		return groupedSearchResult;
	}
}
