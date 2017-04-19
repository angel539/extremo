/**
 */
package semanticmanager.queries.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import semanticmanager.dataModel.NamedElement;

import semanticmanager.queries.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see semanticmanager.queries.QueriesPackage
 * @generated
 */
public class QueriesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QueriesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueriesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QueriesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueriesSwitch<Adapter> modelSwitch =
		new QueriesSwitch<Adapter>() {
			@Override
			public Adapter caseSearchOption(SearchOption object) {
				return createSearchOptionAdapter();
			}
			@Override
			public Adapter caseSearchResult(SearchResult object) {
				return createSearchResultAdapter();
			}
			@Override
			public Adapter caseSearchResultOptionValue(SearchResultOptionValue object) {
				return createSearchResultOptionValueAdapter();
			}
			@Override
			public Adapter caseSearchConfiguration(SearchConfiguration object) {
				return createSearchConfigurationAdapter();
			}
			@Override
			public Adapter caseSimpleSearchConfiguration(SimpleSearchConfiguration object) {
				return createSimpleSearchConfigurationAdapter();
			}
			@Override
			public Adapter caseCompositeSearchConfiguration(CompositeSearchConfiguration object) {
				return createCompositeSearchConfigurationAdapter();
			}
			@Override
			public Adapter caseService(Service object) {
				return createServiceAdapter();
			}
			@Override
			public Adapter caseCustomSearch(CustomSearch object) {
				return createCustomSearchAdapter();
			}
			@Override
			public Adapter casePredicateBasedSearch(PredicateBasedSearch object) {
				return createPredicateBasedSearchAdapter();
			}
			@Override
			public Adapter caseAtomicSearchResult(AtomicSearchResult object) {
				return createAtomicSearchResultAdapter();
			}
			@Override
			public Adapter caseGroupedSearchResult(GroupedSearchResult object) {
				return createGroupedSearchResultAdapter();
			}
			@Override
			public Adapter caseSemanticGroup(SemanticGroup object) {
				return createSemanticGroupAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.SearchOption <em>Search Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.SearchOption
	 * @generated
	 */
	public Adapter createSearchOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.SearchResult <em>Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.SearchResult
	 * @generated
	 */
	public Adapter createSearchResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.SearchResultOptionValue <em>Search Result Option Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.SearchResultOptionValue
	 * @generated
	 */
	public Adapter createSearchResultOptionValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.SearchConfiguration <em>Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.SearchConfiguration
	 * @generated
	 */
	public Adapter createSearchConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.SimpleSearchConfiguration <em>Simple Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.SimpleSearchConfiguration
	 * @generated
	 */
	public Adapter createSimpleSearchConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.CompositeSearchConfiguration <em>Composite Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.CompositeSearchConfiguration
	 * @generated
	 */
	public Adapter createCompositeSearchConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.Service
	 * @generated
	 */
	public Adapter createServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.CustomSearch <em>Custom Search</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.CustomSearch
	 * @generated
	 */
	public Adapter createCustomSearchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.PredicateBasedSearch <em>Predicate Based Search</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.PredicateBasedSearch
	 * @generated
	 */
	public Adapter createPredicateBasedSearchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.AtomicSearchResult <em>Atomic Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.AtomicSearchResult
	 * @generated
	 */
	public Adapter createAtomicSearchResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.GroupedSearchResult <em>Grouped Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.GroupedSearchResult
	 * @generated
	 */
	public Adapter createGroupedSearchResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.queries.SemanticGroup <em>Semantic Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.queries.SemanticGroup
	 * @generated
	 */
	public Adapter createSemanticGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link semanticmanager.dataModel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see semanticmanager.dataModel.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //QueriesAdapterFactory
