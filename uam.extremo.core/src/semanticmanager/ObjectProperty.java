/**
 */
package semanticmanager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.ObjectProperty#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getObjectProperty()
 * @model
 * @generated
 */
public interface ObjectProperty extends Property {
	/**
	 * Returns the value of the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' reference.
	 * @see #setRange(SemanticNode)
	 * @see semanticmanager.SemanticmanagerPackage#getObjectProperty_Range()
	 * @model
	 * @generated
	 */
	SemanticNode getRange();

	/**
	 * Sets the value of the '{@link semanticmanager.ObjectProperty#getRange <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(SemanticNode value);

} // ObjectProperty
