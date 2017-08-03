/**
 */
package epml;

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.CATEGORIZATIONCLASS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link epml.Agent#getOwnedPorts <em>Owned Ports</em>}</li>
 *   <li>{@link epml.Agent#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see epml.EpmlPackage#getAgent()
 * @model abstract="true"
 * @generated
 */
public interface Agent extends CATEGORIZATIONCLASS {
	/**
	 * Returns the value of the '<em><b>Owned Ports</b></em>' containment reference list.
	 * The list contents are of type {@link epml.Port}.
	 * It is bidirectional and its opposite is '{@link epml.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Ports</em>' containment reference list.
	 * @see epml.EpmlPackage#getAgent_OwnedPorts()
	 * @see epml.Port#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Port> getOwnedPorts();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link epml.Application#getOwnedAgents <em>Owned Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Application)
	 * @see epml.EpmlPackage#getAgent_Owner()
	 * @see epml.Application#getOwnedAgents
	 * @model opposite="ownedAgents" required="true" transient="false"
	 * @generated
	 */
	Application getOwner();

	/**
	 * Sets the value of the '{@link epml.Agent#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Application value);

} // Agent
