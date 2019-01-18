/**
 */
package semanticmanager;

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
 *   <li>{@link semanticmanager.RepositoryManager#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link semanticmanager.RepositoryManager#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link semanticmanager.RepositoryManager#getConstraintInterpreters <em>Constraint Interpreters</em>}</li>
 *   <li>{@link semanticmanager.RepositoryManager#getServices <em>Services</em>}</li>
 *   <li>{@link semanticmanager.RepositoryManager#getFormatAssistants <em>Format Assistants</em>}</li>
 *   <li>{@link semanticmanager.RepositoryManager#getModelPersistences <em>Model Persistences</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getRepositoryManager()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface RepositoryManager extends PersistentEObject {
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
	 * If the meaning of the '<em>Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getRepositoryManager_Configurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchConfiguration> getConfigurations();

	/**
	 * Returns the value of the '<em><b>Constraint Interpreters</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.ConstraintInterpreter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Interpreters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Interpreters</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getRepositoryManager_ConstraintInterpreters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintInterpreter> getConstraintInterpreters();

	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.Service}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getRepositoryManager_Services()
	 * @model containment="true"
	 * @generated
	 */
	EList<Service> getServices();

	/**
	 * Returns the value of the '<em><b>Format Assistants</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.FormatAssistant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format Assistants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format Assistants</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getRepositoryManager_FormatAssistants()
	 * @model containment="true"
	 * @generated
	 */
	EList<FormatAssistant> getFormatAssistants();

	/**
	 * Returns the value of the '<em><b>Model Persistences</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.ModelPersistence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Persistences</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Persistences</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getRepositoryManager_ModelPersistences()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelPersistence> getModelPersistences();

} // RepositoryManager
