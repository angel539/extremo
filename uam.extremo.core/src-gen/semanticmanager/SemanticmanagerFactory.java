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
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>Constraint Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint Result</em>'.
	 * @generated
	 */
	ConstraintResult createConstraintResult();

	/**
	 * Returns a new object of class '<em>Composite Search Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Search Configuration</em>'.
	 * @generated
	 */
	CompositeSearchConfiguration createCompositeSearchConfiguration();

	/**
	 * Returns a new object of class '<em>Atomic Search Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atomic Search Result</em>'.
	 * @generated
	 */
	AtomicSearchResult createAtomicSearchResult();

	/**
	 * Returns a new object of class '<em>Grouped Search Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grouped Search Result</em>'.
	 * @generated
	 */
	GroupedSearchResult createGroupedSearchResult();

	/**
	 * Returns a new object of class '<em>Semantic Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semantic Group</em>'.
	 * @generated
	 */
	SemanticGroup createSemanticGroup();

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
	 * Returns a new object of class '<em>Meta Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Data</em>'.
	 * @generated
	 */
	MetaData createMetaData();

	/**
	 * Returns a new object of class '<em>Primitive Type Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type Param</em>'.
	 * @generated
	 */
	PrimitiveTypeParam createPrimitiveTypeParam();

	/**
	 * Returns a new object of class '<em>Model Type Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Type Param</em>'.
	 * @generated
	 */
	ModelTypeParam createModelTypeParam();

	/**
	 * Returns a new object of class '<em>Model Type Param Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Type Param Value</em>'.
	 * @generated
	 */
	ModelTypeParamValue createModelTypeParamValue();

	/**
	 * Returns a new object of class '<em>Primitive Type Param Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type Param Value</em>'.
	 * @generated
	 */
	PrimitiveTypeParamValue createPrimitiveTypeParamValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SemanticmanagerPackage getSemanticmanagerPackage();

} //SemanticmanagerFactory
