/**
 */
package semanticmanager.dataModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import semanticmanager.constraints.ConstraintInterpreter;

import semanticmanager.queries.SearchConfiguration;
import semanticmanager.queries.Service;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.dataModel.RepositoryManager#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link semanticmanager.dataModel.RepositoryManager#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link semanticmanager.dataModel.RepositoryManager#getInterpreters <em>Interpreters</em>}</li>
 *   <li>{@link semanticmanager.dataModel.RepositoryManager#getServices <em>Services</em>}</li>
 * </ul>
 *
 * @see semanticmanager.dataModel.DataModelPackage#getRepositoryManager()
 * @model
 * @generated
 */
public interface RepositoryManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Repositories</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.dataModel.Repository}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repositories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositories</em>' containment reference list.
	 * @see semanticmanager.dataModel.DataModelPackage#getRepositoryManager_Repositories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Repository> getRepositories();

	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.queries.SearchConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see semanticmanager.dataModel.DataModelPackage#getRepositoryManager_Configurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchConfiguration> getConfigurations();

	/**
	 * Returns the value of the '<em><b>Interpreters</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.constraints.ConstraintInterpreter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpreters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpreters</em>' containment reference list.
	 * @see semanticmanager.dataModel.DataModelPackage#getRepositoryManager_Interpreters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintInterpreter> getInterpreters();

	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.queries.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see semanticmanager.dataModel.DataModelPackage#getRepositoryManager_Services()
	 * @model containment="true"
	 * @generated
	 */
	EList<Service> getServices();

} // RepositoryManager
