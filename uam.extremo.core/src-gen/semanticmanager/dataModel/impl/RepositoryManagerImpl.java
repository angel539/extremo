/**
 */
package semanticmanager.dataModel.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import semanticmanager.constraints.ConstraintInterpreter;

import semanticmanager.dataModel.DataModelPackage;
import semanticmanager.dataModel.Repository;
import semanticmanager.dataModel.RepositoryManager;

import semanticmanager.queries.SearchConfiguration;
import semanticmanager.queries.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.dataModel.impl.RepositoryManagerImpl#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.RepositoryManagerImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.RepositoryManagerImpl#getInterpreters <em>Interpreters</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.RepositoryManagerImpl#getServices <em>Services</em>}</li>
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
		return DataModelPackage.Literals.REPOSITORY_MANAGER;
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
		return (EList<Repository>)eGet(DataModelPackage.Literals.REPOSITORY_MANAGER__REPOSITORIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SearchConfiguration> getConfigurations() {
		return (EList<SearchConfiguration>)eGet(DataModelPackage.Literals.REPOSITORY_MANAGER__CONFIGURATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConstraintInterpreter> getInterpreters() {
		return (EList<ConstraintInterpreter>)eGet(DataModelPackage.Literals.REPOSITORY_MANAGER__INTERPRETERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Service> getServices() {
		return (EList<Service>)eGet(DataModelPackage.Literals.REPOSITORY_MANAGER__SERVICES, true);
	}

} //RepositoryManagerImpl
