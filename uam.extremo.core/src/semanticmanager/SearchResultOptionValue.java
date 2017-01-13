/**
 */
package semanticmanager;

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
 *   <li>{@link semanticmanager.SearchResultOptionValue#getOption <em>Option</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getSearchResultOptionValue()
 * @model abstract="true"
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
	 * @see semanticmanager.SemanticmanagerPackage#getSearchResultOptionValue_Option()
	 * @model
	 * @generated
	 */
	SearchOption getOption();

	/**
	 * Sets the value of the '{@link semanticmanager.SearchResultOptionValue#getOption <em>Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option</em>' reference.
	 * @see #getOption()
	 * @generated
	 */
	void setOption(SearchOption value);

} // SearchResultOptionValue
