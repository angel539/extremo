/**
 */
package uam.extremo.core;

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
 *   <li>{@link uam.extremo.core.CompositeSearchConfiguration#getType <em>Type</em>}</li>
 *   <li>{@link uam.extremo.core.CompositeSearchConfiguration#getChildren <em>Children</em>}</li>
 *   <li>{@link uam.extremo.core.CompositeSearchConfiguration#getInputSearchResults <em>Input Search Results</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getCompositeSearchConfiguration()
 * @model
 * @generated
 */
public interface CompositeSearchConfiguration extends SearchConfiguration {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link uam.extremo.core.ConnectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see uam.extremo.core.ConnectionType
	 * @see #setType(ConnectionType)
	 * @see uam.extremo.core.SemanticmanagerPackage#getCompositeSearchConfiguration_Type()
	 * @model
	 * @generated
	 */
	ConnectionType getType();

	/**
	 * Sets the value of the '{@link uam.extremo.core.CompositeSearchConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see uam.extremo.core.ConnectionType
	 * @see #getType()
	 * @generated
	 */
	void setType(ConnectionType value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.CompositeSearchConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getCompositeSearchConfiguration_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<CompositeSearchConfiguration> getChildren();

	/**
	 * Returns the value of the '<em><b>Input Search Results</b></em>' reference list.
	 * The list contents are of type {@link uam.extremo.core.SearchResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Search Results</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Search Results</em>' reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getCompositeSearchConfiguration_InputSearchResults()
	 * @model
	 * @generated
	 */
	EList<SearchResult> getInputSearchResults();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void search(SearchResult result);

} // CompositeSearchConfiguration
