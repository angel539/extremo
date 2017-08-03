/**
 */
package epml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link epml.Port#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see epml.EpmlPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link epml.Agent#getOwnedPorts <em>Owned Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Agent)
	 * @see epml.EpmlPackage#getPort_Owner()
	 * @see epml.Agent#getOwnedPorts
	 * @model opposite="ownedPorts" required="true" transient="false"
	 * @generated
	 */
	Agent getOwner();

	/**
	 * Sets the value of the '{@link epml.Port#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Agent value);

} // Port
