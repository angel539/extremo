/**
 */
package semanticmanager;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.Connection#getType <em>Type</em>}</li>
 *   <li>{@link semanticmanager.Connection#getSearchConfiguration <em>Search Configuration</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject {
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
	 * @see semanticmanager.SemanticmanagerPackage#getConnection_Type()
	 * @model
	 * @generated
	 */
	ConnectionType getType();

	/**
	 * Sets the value of the '{@link semanticmanager.Connection#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see semanticmanager.ConnectionType
	 * @see #getType()
	 * @generated
	 */
	void setType(ConnectionType value);

	/**
	 * Returns the value of the '<em><b>Search Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Search Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search Configuration</em>' reference.
	 * @see #setSearchConfiguration(SimpleSearchConfiguration)
	 * @see semanticmanager.SemanticmanagerPackage#getConnection_SearchConfiguration()
	 * @model
	 * @generated
	 */
	SimpleSearchConfiguration getSearchConfiguration();

	/**
	 * Sets the value of the '{@link semanticmanager.Connection#getSearchConfiguration <em>Search Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search Configuration</em>' reference.
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	void setSearchConfiguration(SimpleSearchConfiguration value);

} // Connection
