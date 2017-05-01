/**
 */
package semanticmanager.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import semanticmanager.ConstraintInterpreter;
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
 *   <li>{@link semanticmanager.impl.RepositoryManagerImpl#getInterpreters <em>Interpreters</em>}</li>
 *   <li>{@link semanticmanager.impl.RepositoryManagerImpl#getServices <em>Services</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryManagerImpl extends MinimalEObjectImpl.Container implements RepositoryManager {
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
	public EList<ConstraintInterpreter> getInterpreters() {
		return (EList<ConstraintInterpreter>)eGet(SemanticmanagerPackage.Literals.REPOSITORY_MANAGER__INTERPRETERS, true);
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

} //RepositoryManagerImpl
