package semanticmanager.impl;

import org.eclipse.emf.ecore.EDataType;

import semanticmanager.ExtendedSemanticmanagerFactory;
import semanticmanager.constraints.ExtensibleConstraintInterpreter;
import semanticmanager.constraints.impl.ExtensibleConstraintInterpreterImpl;
import semanticmanager.queries.ExtensibleAtomicSearchResult;
import semanticmanager.queries.ExtensibleCustomSearch;
import semanticmanager.queries.ExtensibleGroupedSearchResult;
import semanticmanager.queries.ExtensiblePredicateBasedSearch;
import semanticmanager.queries.ExtensibleService;
import semanticmanager.queries.impl.ExtensibleAtomicSearchResultImpl;
import semanticmanager.queries.impl.ExtensibleCustomSearchImpl;
import semanticmanager.queries.impl.ExtensibleGroupedSearchResultImpl;
import semanticmanager.queries.impl.ExtensiblePredicateBasedSearchImpl;
import semanticmanager.queries.impl.ExtensibleServiceImpl;

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

	@Override
	public ExtensibleCustomSearch createCustomSearch() {
		ExtensibleCustomSearchImpl customSearch = new ExtensibleCustomSearchImpl();
		return customSearch;
	}

	@Override
	public ExtensiblePredicateBasedSearch createPredicateBasedSearch() {
		ExtensiblePredicateBasedSearchImpl predicateBasedSearch = new ExtensiblePredicateBasedSearchImpl();
		return predicateBasedSearch;
	}

	@Override
	public ExtensibleService createService() {
		ExtensibleServiceImpl service = new ExtensibleServiceImpl();
		return service;
	}

	@Override
	public ExtensibleConstraintInterpreter createConstraintInterpreter() {
		ExtensibleConstraintInterpreterImpl constraintInterpreter = new ExtensibleConstraintInterpreterImpl();
		return constraintInterpreter;
	}
	
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
