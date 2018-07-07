/**
 */
package uam.extremo.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Type Param Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.ModelTypeParamValue#getOption <em>Option</em>}</li>
 *   <li>{@link uam.extremo.core.ModelTypeParamValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getModelTypeParamValue()
 * @model
 * @generated
 */
public interface ModelTypeParamValue extends SearchParamValue {
	/**
	 * Returns the value of the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option</em>' reference.
	 * @see #setOption(ModelTypeParam)
	 * @see uam.extremo.core.SemanticmanagerPackage#getModelTypeParamValue_Option()
	 * @model
	 * @generated
	 */
	ModelTypeParam getOption();

	/**
	 * Sets the value of the '{@link uam.extremo.core.ModelTypeParamValue#getOption <em>Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option</em>' reference.
	 * @see #getOption()
	 * @generated
	 */
	void setOption(ModelTypeParam value);

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
	 * @see uam.extremo.core.SemanticmanagerPackage#getModelTypeParamValue_Value()
	 * @model
	 * @generated
	 */
	NamedElement getValue();

	/**
	 * Sets the value of the '{@link uam.extremo.core.ModelTypeParamValue#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(NamedElement value);

} // ModelTypeParamValue
