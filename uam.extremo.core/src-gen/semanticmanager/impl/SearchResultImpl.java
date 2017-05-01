/**
 */
package semanticmanager.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import semanticmanager.NamedElement;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchResult;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.SearchResultImpl#getValues <em>Values</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchResultImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchResultImpl#getApplyOnElements <em>Apply On Elements</em>}</li>
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
		return SemanticmanagerPackage.Literals.SEARCH_RESULT;
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
		return (EList<SearchResultOptionValue>)eGet(SemanticmanagerPackage.Literals.SEARCH_RESULT__VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchConfiguration getConfiguration() {
		return (SearchConfiguration)eGet(SemanticmanagerPackage.Literals.SEARCH_RESULT__CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(SearchConfiguration newConfiguration) {
		eSet(SemanticmanagerPackage.Literals.SEARCH_RESULT__CONFIGURATION, newConfiguration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getApplyOnElements() {
		return (EList<NamedElement>)eGet(SemanticmanagerPackage.Literals.SEARCH_RESULT__APPLY_ON_ELEMENTS, true);
	}

} //SearchResultImpl
