/**
 */
package uam.extremo.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.PrimitiveTypeParam#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getPrimitiveTypeParam()
 * @model
 * @generated
 */
public interface PrimitiveTypeParam extends SearchParam {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link uam.extremo.core.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see uam.extremo.core.Type
	 * @see #setType(Type)
	 * @see uam.extremo.core.SemanticmanagerPackage#getPrimitiveTypeParam_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link uam.extremo.core.PrimitiveTypeParam#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see uam.extremo.core.Type
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // PrimitiveTypeParam
