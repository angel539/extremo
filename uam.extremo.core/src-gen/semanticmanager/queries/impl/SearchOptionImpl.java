/**
 */
package semanticmanager.queries.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import semanticmanager.dataModel.Type;

import semanticmanager.queries.QueriesPackage;
import semanticmanager.queries.SearchOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.impl.SearchOptionImpl#getType <em>Type</em>}</li>
 *   <li>{@link semanticmanager.queries.impl.SearchOptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.queries.impl.SearchOptionImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchOptionImpl extends MinimalEObjectImpl.Container implements SearchOption {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QueriesPackage.Literals.SEARCH_OPTION;
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
	public Type getType() {
		return (Type)eGet(QueriesPackage.Literals.SEARCH_OPTION__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eSet(QueriesPackage.Literals.SEARCH_OPTION__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(QueriesPackage.Literals.SEARCH_OPTION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(QueriesPackage.Literals.SEARCH_OPTION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return (String)eGet(QueriesPackage.Literals.SEARCH_OPTION__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eSet(QueriesPackage.Literals.SEARCH_OPTION__ID, newId);
	}

} //SearchOptionImpl
