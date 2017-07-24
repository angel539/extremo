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
 *   <li>{@link semanticmanager.ObjectProperty#getInverseOf <em>Inverse Of</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getObjectProperty()
 * @model
 * @generated
 */
public interface ObjectProperty extends Property {
	/**
	 * Returns the value of the '<em><b>Range</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.SemanticNode#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' reference.
	 * @see #setRange(SemanticNode)
	 * @see semanticmanager.SemanticmanagerPackage#getObjectProperty_Range()
	 * @see semanticmanager.SemanticNode#getDomain
	 * @model opposite="domain"
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

	/**
	 * Returns the value of the '<em><b>Inverse Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inverse Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inverse Of</em>' reference.
	 * @see #setInverseOf(ObjectProperty)
	 * @see semanticmanager.SemanticmanagerPackage#getObjectProperty_InverseOf()
	 * @model
	 * @generated
	 */
	ObjectProperty getInverseOf();

	/**
	 * Sets the value of the '{@link semanticmanager.ObjectProperty#getInverseOf <em>Inverse Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverse Of</em>' reference.
	 * @see #getInverseOf()
	 * @generated
	 */
	void setInverseOf(ObjectProperty value);

} // ObjectProperty
