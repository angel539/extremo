/**
 */
package semanticmanager.impl;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.ConstraintInterpreter;
import semanticmanager.FormatAssistant;
import semanticmanager.ModelPersistence;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.SearchConfiguration;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.RepositoryManagerImpl#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link semanticmanager.impl.RepositoryManagerImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link semanticmanager.impl.RepositoryManagerImpl#getConstraintInterpreters <em>Constraint Interpreters</em>}</li>
 *   <li>{@link semanticmanager.impl.RepositoryManagerImpl#getServices <em>Services</em>}</li>
 *   <li>{@link semanticmanager.impl.RepositoryManagerImpl#getFormatAssistants <em>Format Assistants</em>}</li>
 *   <li>{@link semanticmanager.impl.RepositoryManagerImpl#getModelPersistences <em>Model Persistences</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryManagerImpl extends DefaultPersistentEObject implements RepositoryManager {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.REPOSITORY_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Repository> getRepositories() {
		return (EList<Repository>)eGet(SemanticmanagerPackage.Literals.REPOSITORY_MANAGER__REPOSITORIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SearchConfiguration> getConfigurations() {
		return (EList<SearchConfiguration>)eGet(SemanticmanagerPackage.Literals.REPOSITORY_MANAGER__CONFIGURATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConstraintInterpreter> getConstraintInterpreters() {
		return (EList<ConstraintInterpreter>)eGet(SemanticmanagerPackage.Literals.REPOSITORY_MANAGER__CONSTRAINT_INTERPRETERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Service> getServices() {
		return (EList<Service>)eGet(SemanticmanagerPackage.Literals.REPOSITORY_MANAGER__SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<FormatAssistant> getFormatAssistants() {
		return (EList<FormatAssistant>)eGet(SemanticmanagerPackage.Literals.REPOSITORY_MANAGER__FORMAT_ASSISTANTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ModelPersistence> getModelPersistences() {
		return (EList<ModelPersistence>)eGet(SemanticmanagerPackage.Literals.REPOSITORY_MANAGER__MODEL_PERSISTENCES, true);
	}

} //RepositoryManagerImpl
