/**
 */
package semanticmanager.queries.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import semanticmanager.dataModel.NamedElement;

import semanticmanager.queries.QueriesPackage;
import semanticmanager.queries.SearchConfiguration;
import semanticmanager.queries.SearchResult;
import semanticmanager.queries.SearchResultOptionValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.impl.SearchResultImpl#getValues <em>Values</em>}</li>
 *   <li>{@link semanticmanager.queries.impl.SearchResultImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link semanticmanager.queries.impl.SearchResultImpl#getApplyOnElements <em>Apply On Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchResultImpl extends MinimalEObjectImpl.Container implements SearchResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QueriesPackage.Literals.SEARCH_RESULT;
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
	public EList<SearchResultOptionValue> getValues() {
		return (EList<SearchResultOptionValue>)eGet(QueriesPackage.Literals.SEARCH_RESULT__VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchConfiguration getConfiguration() {
		return (SearchConfiguration)eGet(QueriesPackage.Literals.SEARCH_RESULT__CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(SearchConfiguration newConfiguration) {
		eSet(QueriesPackage.Literals.SEARCH_RESULT__CONFIGURATION, newConfiguration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getApplyOnElements() {
		return (EList<NamedElement>)eGet(QueriesPackage.Literals.SEARCH_RESULT__APPLY_ON_ELEMENTS, true);
	}

} //SearchResultImpl
