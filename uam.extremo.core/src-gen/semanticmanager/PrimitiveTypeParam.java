/**
 */
package semanticmanager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.PrimitiveTypeParam#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getPrimitiveTypeParam()
 * @model
 * @generated
 */
public interface PrimitiveTypeParam extends SearchParam {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link semanticmanager.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see semanticmanager.Type
	 * @see #setType(Type)
	 * @see semanticmanager.SemanticmanagerPackage#getPrimitiveTypeParam_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link semanticmanager.PrimitiveTypeParam#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see semanticmanager.Type
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // PrimitiveTypeParam
