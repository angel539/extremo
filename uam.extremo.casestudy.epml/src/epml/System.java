/**
 */
package epml;

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.DICTIONARY;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link epml.System#getOwnedApplication <em>Owned Application</em>}</li>
 * </ul>
 *
 * @see epml.EpmlPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends DICTIONARY, NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Application</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Application</em>' containment reference.
	 * @see #setOwnedApplication(Application)
	 * @see epml.EpmlPackage#getSystem_OwnedApplication()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Application getOwnedApplication();

	/**
	 * Sets the value of the '{@link epml.System#getOwnedApplication <em>Owned Application</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Application</em>' containment reference.
	 * @see #getOwnedApplication()
	 * @generated
	 */
	void setOwnedApplication(Application value);

} // System
