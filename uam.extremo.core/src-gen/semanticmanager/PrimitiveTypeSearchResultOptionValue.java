/**
 */
package semanticmanager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type Search Result Option Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.PrimitiveTypeSearchResultOptionValue#getValue <em>Value</em>}</li>
 *   <li>{@link semanticmanager.PrimitiveTypeSearchResultOptionValue#getOption <em>Option</em>}</li>
 *   <li>{@link semanticmanager.PrimitiveTypeSearchResultOptionValue#getCalls <em>Calls</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getPrimitiveTypeSearchResultOptionValue()
 * @model
 * @generated
 */
public interface PrimitiveTypeSearchResultOptionValue extends SearchResultOptionValue {
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
	 * @see semanticmanager.SemanticmanagerPackage#getPrimitiveTypeSearchResultOptionValue_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link semanticmanager.PrimitiveTypeSearchResultOptionValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option</em>' reference.
	 * @see #setOption(PrimitiveTypeSearchOption)
	 * @see semanticmanager.SemanticmanagerPackage#getPrimitiveTypeSearchResultOptionValue_Option()
	 * @model
	 * @generated
	 */
	PrimitiveTypeSearchOption getOption();

	/**
	 * Sets the value of the '{@link semanticmanager.PrimitiveTypeSearchResultOptionValue#getOption <em>Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option</em>' reference.
	 * @see #getOption()
	 * @generated
	 */
	void setOption(PrimitiveTypeSearchOption value);

	/**
	 * Returns the value of the '<em><b>Calls</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calls</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calls</em>' reference.
	 * @see #setCalls(Service)
	 * @see semanticmanager.SemanticmanagerPackage#getPrimitiveTypeSearchResultOptionValue_Calls()
	 * @model
	 * @generated
	 */
	Service getCalls();

	/**
	 * Sets the value of the '{@link semanticmanager.PrimitiveTypeSearchResultOptionValue#getCalls <em>Calls</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calls</em>' reference.
	 * @see #getCalls()
	 * @generated
	 */
	void setCalls(Service value);

} // PrimitiveTypeSearchResultOptionValue
