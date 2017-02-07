/**
 */
package semanticmanager;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see semanticmanager.SemanticmanagerPackage
 * @generated
 */
public interface SemanticmanagerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SemanticmanagerFactory eINSTANCE = semanticmanager.impl.SemanticmanagerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Repository Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repository Manager</em>'.
	 * @generated
	 */
	RepositoryManager createRepositoryManager();

	/**
	 * Returns a new object of class '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repository</em>'.
	 * @generated
	 */
	Repository createRepository();

	/**
	 * Returns a new object of class '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource</em>'.
	 * @generated
	 */
	Resource createResource();

	/**
	 * Returns a new object of class '<em>Semantic Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semantic Node</em>'.
	 * @generated
	 */
	SemanticNode createSemanticNode();

	/**
	 * Returns a new object of class '<em>Object Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Property</em>'.
	 * @generated
	 */
	ObjectProperty createObjectProperty();

	/**
	 * Returns a new object of class '<em>Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Property</em>'.
	 * @generated
	 */
	DataProperty createDataProperty();

	/**
	 * Returns a new object of class '<em>Semantic Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semantic Group</em>'.
	 * @generated
	 */
	SemanticGroup createSemanticGroup();

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
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SemanticmanagerPackage getSemanticmanagerPackage();

} //SemanticmanagerFactory
