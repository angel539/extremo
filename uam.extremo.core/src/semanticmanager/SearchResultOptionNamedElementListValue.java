/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Result Option Named Element List Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.SearchResultOptionNamedElementListValue#getValue <em>Value</em>}</li>
 *   <li>{@link semanticmanager.SearchResultOptionNamedElementListValue#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getSearchResultOptionNamedElementListValue()
 * @model
 * @generated
 */
public interface SearchResultOptionNamedElementListValue extends SearchResultOptionValue {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSearchResultOptionNamedElementListValue_Value()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getValue();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see semanticmanager.SemanticmanagerPackage#getSearchResultOptionNamedElementListValue_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link semanticmanager.SearchResultOptionNamedElementListValue#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

} // SearchResultOptionNamedElementListValue
