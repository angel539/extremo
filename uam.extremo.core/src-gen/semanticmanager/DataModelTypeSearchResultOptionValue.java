/**
 */
package semanticmanager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Model Type Search Result Option Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.DataModelTypeSearchResultOptionValue#getOption <em>Option</em>}</li>
 *   <li>{@link semanticmanager.DataModelTypeSearchResultOptionValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getDataModelTypeSearchResultOptionValue()
 * @model
 * @generated
 */
public interface DataModelTypeSearchResultOptionValue extends SearchResultOptionValue {
	/**
	 * Returns the value of the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option</em>' reference.
	 * @see #setOption(DataModelTypeSearchOption)
	 * @see semanticmanager.SemanticmanagerPackage#getDataModelTypeSearchResultOptionValue_Option()
	 * @model
	 * @generated
	 */
	DataModelTypeSearchOption getOption();

	/**
	 * Sets the value of the '{@link semanticmanager.DataModelTypeSearchResultOptionValue#getOption <em>Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option</em>' reference.
	 * @see #getOption()
	 * @generated
	 */
	void setOption(DataModelTypeSearchOption value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(NamedElement)
	 * @see semanticmanager.SemanticmanagerPackage#getDataModelTypeSearchResultOptionValue_Value()
	 * @model
	 * @generated
	 */
	NamedElement getValue();

	/**
	 * Sets the value of the '{@link semanticmanager.DataModelTypeSearchResultOptionValue#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(NamedElement value);

} // DataModelTypeSearchResultOptionValue
