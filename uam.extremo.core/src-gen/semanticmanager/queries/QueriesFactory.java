/**
 */
package semanticmanager.queries;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see semanticmanager.queries.QueriesPackage
 * @generated
 */
public interface QueriesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QueriesFactory eINSTANCE = semanticmanager.queries.impl.QueriesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Search Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Search Option</em>'.
	 * @generated
	 */
	SearchOption createSearchOption();

	/**
	 * Returns a new object of class '<em>Search Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Search Result</em>'.
	 * @generated
	 */
	SearchResult createSearchResult();

	/**
	 * Returns a new object of class '<em>Search Result Option Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Search Result Option Value</em>'.
	 * @generated
	 */
	SearchResultOptionValue createSearchResultOptionValue();

	/**
	 * Returns a new object of class '<em>Composite Search Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Search Configuration</em>'.
	 * @generated
	 */
	CompositeSearchConfiguration createCompositeSearchConfiguration();

	/**
	 * Returns a new object of class '<em>Custom Search</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Search</em>'.
	 * @generated
	 */
	CustomSearch createCustomSearch();

	/**
	 * Returns a new object of class '<em>Predicate Based Search</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predicate Based Search</em>'.
	 * @generated
	 */
	PredicateBasedSearch createPredicateBasedSearch();

	/**
	 * Returns a new object of class '<em>Semantic Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semantic Group</em>'.
	 * @generated
	 */
	SemanticGroup createSemanticGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QueriesPackage getQueriesPackage();

} //QueriesFactory
