/**
 */
package semanticmanager.queries;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Result Option Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.SearchResultOptionValue#getOption <em>Option</em>}</li>
 *   <li>{@link semanticmanager.queries.SearchResultOptionValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see semanticmanager.queries.QueriesPackage#getSearchResultOptionValue()
 * @model
 * @generated
 */
public interface SearchResultOptionValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option</em>' reference.
	 * @see #setOption(SearchOption)
	 * @see semanticmanager.queries.QueriesPackage#getSearchResultOptionValue_Option()
	 * @model
	 * @generated
	 */
	SearchOption getOption();

	/**
	 * Sets the value of the '{@link semanticmanager.queries.SearchResultOptionValue#getOption <em>Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option</em>' reference.
	 * @see #getOption()
	 * @generated
	 */
	void setOption(SearchOption value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see semanticmanager.queries.QueriesPackage#getSearchResultOptionValue_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link semanticmanager.queries.SearchResultOptionValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // SearchResultOptionValue
