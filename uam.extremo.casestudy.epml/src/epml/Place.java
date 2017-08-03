/**
 */
package epml;

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.CATEGORIZATIONCLASS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link epml.Place#getItsOutputPort <em>Its Output Port</em>}</li>
 *   <li>{@link epml.Place#getItsInputPort <em>Its Input Port</em>}</li>
 *   <li>{@link epml.Place#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see epml.EpmlPackage#getPlace()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='matchRates'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot matchRates='if byteSize &gt; 0 then byteSize &gt;= itsOutputPort.byteRate and byteSize &gt;= itsInputPort.byteRate else true endif'"
 * @generated
 */
public interface Place extends CATEGORIZATIONCLASS, NamedElement {
	/**
	 * Returns the value of the '<em><b>Its Output Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Its Output Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Its Output Port</em>' reference.
	 * @see #setItsOutputPort(OutputPort)
	 * @see epml.EpmlPackage#getPlace_ItsOutputPort()
	 * @model required="true"
	 * @generated
	 */
	OutputPort getItsOutputPort();

	/**
	 * Sets the value of the '{@link epml.Place#getItsOutputPort <em>Its Output Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Its Output Port</em>' reference.
	 * @see #getItsOutputPort()
	 * @generated
	 */
	void setItsOutputPort(OutputPort value);

	/**
	 * Returns the value of the '<em><b>Its Input Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Its Input Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Its Input Port</em>' reference.
	 * @see #setItsInputPort(InputPort)
	 * @see epml.EpmlPackage#getPlace_ItsInputPort()
	 * @model required="true"
	 * @generated
	 */
	InputPort getItsInputPort();

	/**
	 * Sets the value of the '{@link epml.Place#getItsInputPort <em>Its Input Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Its Input Port</em>' reference.
	 * @see #getItsInputPort()
	 * @generated
	 */
	void setItsInputPort(InputPort value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link epml.Application#getOwnedPlaces <em>Owned Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Application)
	 * @see epml.EpmlPackage#getPlace_Owner()
	 * @see epml.Application#getOwnedPlaces
	 * @model opposite="ownedPlaces" required="true" transient="false"
	 * @generated
	 */
	Application getOwner();

	/**
	 * Sets the value of the '{@link epml.Place#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Application value);

} // Place
