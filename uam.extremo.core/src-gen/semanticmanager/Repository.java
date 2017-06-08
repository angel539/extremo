/**
 */
package semanticmanager;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;
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
 *   <li>{@link semanticmanager.Repository#getProject <em>Project</em>}</li>
 *   <li>{@link semanticmanager.Repository#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.Repository#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getRepository()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface Repository extends PersistentEObject {
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.Resource}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.Resource#getRepositoryFrom <em>Repository From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getRepository_Resources()
	 * @see semanticmanager.Resource#getRepositoryFrom
	 * @model opposite="repositoryFrom" containment="true"
	 * @generated
	 */
	EList<Resource> getResources();

	/**
	 * Returns the value of the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' attribute.
	 * @see #setProject(String)
	 * @see semanticmanager.SemanticmanagerPackage#getRepository_Project()
	 * @model
	 * @generated
	 */
	String getProject();

	/**
	 * Sets the value of the '{@link semanticmanager.Repository#getProject <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' attribute.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see semanticmanager.SemanticmanagerPackage#getRepository_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link semanticmanager.Repository#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see semanticmanager.SemanticmanagerPackage#getRepository_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link semanticmanager.Repository#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // Repository
