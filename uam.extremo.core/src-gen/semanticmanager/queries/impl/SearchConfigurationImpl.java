/**
 */
package semanticmanager.queries.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import semanticmanager.queries.QueriesPackage;
import semanticmanager.queries.SearchConfiguration;
import semanticmanager.queries.SearchResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.impl.SearchConfigurationImpl#getId <em>Id</em>}</li>
 *   <li>{@link semanticmanager.queries.impl.SearchConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.queries.impl.SearchConfigurationImpl#getResults <em>Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SearchConfigurationImpl extends MinimalEObjectImpl.Container implements SearchConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QueriesPackage.Literals.SEARCH_CONFIGURATION;
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
	public String getId() {
		return (String)eGet(QueriesPackage.Literals.SEARCH_CONFIGURATION__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eSet(QueriesPackage.Literals.SEARCH_CONFIGURATION__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(QueriesPackage.Literals.SEARCH_CONFIGURATION__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(QueriesPackage.Literals.SEARCH_CONFIGURATION__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SearchResult> getResults() {
		return (EList<SearchResult>)eGet(QueriesPackage.Literals.SEARCH_CONFIGURATION__RESULTS, true);
	}

} //SearchConfigurationImpl
