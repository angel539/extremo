/**
 */
package semanticmanager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Type Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.ModelTypeParam#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getModelTypeParam()
 * @model
 * @generated
 */
public interface ModelTypeParam extends SearchParam {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link semanticmanager.DataModelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see semanticmanager.DataModelType
	 * @see #setType(DataModelType)
	 * @see semanticmanager.SemanticmanagerPackage#getModelTypeParam_Type()
	 * @model
	 * @generated
	 */
	DataModelType getType();

	/**
	 * Sets the value of the '{@link semanticmanager.ModelTypeParam#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see semanticmanager.DataModelType
	 * @see #getType()
	 * @generated
	 */
	void setType(DataModelType value);

} // ModelTypeParam
