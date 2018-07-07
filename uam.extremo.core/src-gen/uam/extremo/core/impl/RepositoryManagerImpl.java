/**
 */
package uam.extremo.core.impl;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;
import uam.extremo.core.ConstraintInterpreter;
import uam.extremo.core.Repository;
import uam.extremo.core.RepositoryManager;
import uam.extremo.core.SearchConfiguration;
import uam.extremo.core.SemanticmanagerPackage;
import uam.extremo.core.Service;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.RepositoryManagerImpl#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link uam.extremo.core.impl.RepositoryManagerImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link uam.extremo.core.impl.RepositoryManagerImpl#getInterpreters <em>Interpreters</em>}</li>
 *   <li>{@link uam.extremo.core.impl.RepositoryManagerImpl#getServices <em>Services</em>}</li>
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
