/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.CompositeSearchConfiguration#getQueries <em>Queries</em>}</li>
 *   <li>{@link semanticmanager.CompositeSearchConfiguration#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getCompositeSearchConfiguration()
 * @model
 * @generated
 */
public interface CompositeSearchConfiguration extends SearchConfiguration {
	/**
	 * Returns the value of the '<em><b>Queries</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.SearchConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queries</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getCompositeSearchConfiguration_Queries()
	 * @model required="true"
	 * @generated
	 */
	EList<SearchConfiguration> getQueries();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link semanticmanager.ConnectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see semanticmanager.ConnectionType
	 * @see #setType(ConnectionType)
	 * @see semanticmanager.SemanticmanagerPackage#getCompositeSearchConfiguration_Type()
	 * @model
	 * @generated
	 */
	ConnectionType getType();

	/**
	 * Sets the value of the '{@link semanticmanager.CompositeSearchConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see semanticmanager.ConnectionType
	 * @see #getType()
	 * @generated
	 */
	void setType(ConnectionType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void search(SearchResult result);

} // CompositeSearchConfiguration
