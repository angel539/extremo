/**
 */
package semanticmanager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Type Param Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.ModelTypeParamValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getModelTypeParamValue()
 * @model
 * @generated
 */
public interface ModelTypeParamValue extends SearchParamValue {
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
	 * @see semanticmanager.SemanticmanagerPackage#getModelTypeParamValue_Value()
	 * @model
	 * @generated
	 */
	NamedElement getValue();

	/**
	 * Sets the value of the '{@link semanticmanager.ModelTypeParamValue#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(NamedElement value);

} // ModelTypeParamValue
