/**
 */
package semanticmanager.dataModel.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.dataModel.DataModelPackage;
import semanticmanager.dataModel.Repository;
import semanticmanager.dataModel.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.dataModel.impl.RepositoryImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.RepositoryImpl#getProject <em>Project</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryImpl extends NamedElementImpl implements Repository {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataModelPackage.Literals.REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Resource> getResources() {
		return (EList<Resource>)eGet(DataModelPackage.Literals.REPOSITORY__RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProject() {
		return (String)eGet(DataModelPackage.Literals.REPOSITORY__PROJECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(String newProject) {
		eSet(DataModelPackage.Literals.REPOSITORY__PROJECT, newProject);
	}

} //RepositoryImpl
