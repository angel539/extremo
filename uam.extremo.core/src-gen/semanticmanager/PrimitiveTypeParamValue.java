/**
 */
package semanticmanager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type Param Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.PrimitiveTypeParamValue#getValue <em>Value</em>}</li>
 *   <li>{@link semanticmanager.PrimitiveTypeParamValue#getCalls <em>Calls</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getPrimitiveTypeParamValue()
 * @model
 * @generated
 */
public interface PrimitiveTypeParamValue extends SearchParamValue {
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
	 * @see semanticmanager.SemanticmanagerPackage#getPrimitiveTypeParamValue_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link semanticmanager.PrimitiveTypeParamValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

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
	 * @see semanticmanager.SemanticmanagerPackage#getPrimitiveTypeParamValue_Calls()
	 * @model
	 * @generated
	 */
	Service getCalls();

	/**
	 * Sets the value of the '{@link semanticmanager.PrimitiveTypeParamValue#getCalls <em>Calls</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calls</em>' reference.
	 * @see #getCalls()
	 * @generated
	 */
	void setCalls(Service value);

} // PrimitiveTypeParamValue
