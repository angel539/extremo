/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.RepositoryManager#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link semanticmanager.RepositoryManager#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getRepositoryManager()
 * @model
 * @generated
 */
public interface RepositoryManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Repositories</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.Repository}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repositories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositories</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getRepositoryManager_Repositories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Repository> getRepositories();

	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.SearchConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getRepositoryManager_Configurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchConfiguration> getConfigurations();

} // RepositoryManager
