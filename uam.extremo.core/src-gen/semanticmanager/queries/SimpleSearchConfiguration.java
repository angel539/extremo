/**
 */
package semanticmanager.queries;

import org.eclipse.emf.common.util.EList;

import semanticmanager.dataModel.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.SimpleSearchConfiguration#getOptions <em>Options</em>}</li>
 *   <li>{@link semanticmanager.queries.SimpleSearchConfiguration#getFilterBy <em>Filter By</em>}</li>
 * </ul>
 *
 * @see semanticmanager.queries.QueriesPackage#getSimpleSearchConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface SimpleSearchConfiguration extends SearchConfiguration {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.queries.SearchOption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see semanticmanager.queries.QueriesPackage#getSimpleSearchConfiguration_Options()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchOption> getOptions();

	/**
	 * Returns the value of the '<em><b>Filter By</b></em>' attribute.
	 * The literals are from the enumeration {@link semanticmanager.queries.DataModelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter By</em>' attribute.
	 * @see semanticmanager.queries.DataModelType
	 * @see #setFilterBy(DataModelType)
	 * @see semanticmanager.queries.QueriesPackage#getSimpleSearchConfiguration_FilterBy()
	 * @model
	 * @generated
	 */
	DataModelType getFilterBy();

	/**
	 * Sets the value of the '{@link semanticmanager.queries.SimpleSearchConfiguration#getFilterBy <em>Filter By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter By</em>' attribute.
	 * @see semanticmanager.queries.DataModelType
	 * @see #getFilterBy()
	 * @generated
	 */
	void setFilterBy(DataModelType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSearchOption(String id, String name, Type type);

} // SimpleSearchConfiguration
