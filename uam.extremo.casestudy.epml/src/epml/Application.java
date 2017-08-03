/**
 */
package epml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link epml.Application#getOwnedAgents <em>Owned Agents</em>}</li>
 *   <li>{@link epml.Application#getOwnedPlaces <em>Owned Places</em>}</li>
 * </ul>
 *
 * @see epml.EpmlPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Agents</b></em>' containment reference list.
	 * The list contents are of type {@link epml.Agent}.
	 * It is bidirectional and its opposite is '{@link epml.Agent#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Agents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Agents</em>' containment reference list.
	 * @see epml.EpmlPackage#getApplication_OwnedAgents()
	 * @see epml.Agent#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Agent> getOwnedAgents();

	/**
	 * Returns the value of the '<em><b>Owned Places</b></em>' containment reference list.
	 * The list contents are of type {@link epml.Place}.
	 * It is bidirectional and its opposite is '{@link epml.Place#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Places</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Places</em>' containment reference list.
	 * @see epml.EpmlPackage#getApplication_OwnedPlaces()
	 * @see epml.Place#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Place> getOwnedPlaces();

} // Application
