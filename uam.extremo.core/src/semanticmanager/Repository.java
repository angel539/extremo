/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.Repository#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getRepository_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<Resource> getResources();

} // Repository
