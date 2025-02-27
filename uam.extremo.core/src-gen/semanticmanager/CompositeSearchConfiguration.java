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
 *   <li>{@link semanticmanager.CompositeSearchConfiguration#getType <em>Type</em>}</li>
 *   <li>{@link semanticmanager.CompositeSearchConfiguration#getSearchConfigurations <em>Search Configurations</em>}</li>
 *   <li>{@link semanticmanager.CompositeSearchConfiguration#getInputSearchResults <em>Input Search Results</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getCompositeSearchConfiguration()
 * @model
 * @generated
 */
public interface CompositeSearchConfiguration extends SearchConfiguration {
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
	 * Returns the value of the '<em><b>Search Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.SearchConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Search Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search Configurations</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getCompositeSearchConfiguration_SearchConfigurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchConfiguration> getSearchConfigurations();

	/**
	 * Returns the value of the '<em><b>Input Search Results</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.SearchResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Search Results</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Search Results</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getCompositeSearchConfiguration_InputSearchResults()
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
