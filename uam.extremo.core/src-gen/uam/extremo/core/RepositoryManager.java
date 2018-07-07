/**
 */
package uam.extremo.core;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.RepositoryManager#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link uam.extremo.core.RepositoryManager#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link uam.extremo.core.RepositoryManager#getInterpreters <em>Interpreters</em>}</li>
 *   <li>{@link uam.extremo.core.RepositoryManager#getServices <em>Services</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getRepositoryManager()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface RepositoryManager extends PersistentEObject {
	/**
	 * Returns the value of the '<em><b>Repositories</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.Repository}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repositories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositories</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getRepositoryManager_Repositories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Repository> getRepositories();

	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.SearchConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getRepositoryManager_Configurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchConfiguration> getConfigurations();

	/**
	 * Returns the value of the '<em><b>Interpreters</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.ConstraintInterpreter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpreters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpreters</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getRepositoryManager_Interpreters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintInterpreter> getInterpreters();

	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getRepositoryManager_Services()
	 * @model containment="true"
	 * @generated
	 */
	EList<Service> getServices();

} // RepositoryManager
