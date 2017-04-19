/**
 */
package semanticmanager.queries.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import semanticmanager.queries.QueriesPackage;
import semanticmanager.queries.SearchOption;
import semanticmanager.queries.SearchResultOptionValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Result Option Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.impl.SearchResultOptionValueImpl#getOption <em>Option</em>}</li>
 *   <li>{@link semanticmanager.queries.impl.SearchResultOptionValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchResultOptionValueImpl extends MinimalEObjectImpl.Container implements SearchResultOptionValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchResultOptionValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QueriesPackage.Literals.SEARCH_RESULT_OPTION_VALUE;
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
	public SearchOption getOption() {
		return (SearchOption)eGet(QueriesPackage.Literals.SEARCH_RESULT_OPTION_VALUE__OPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOption(SearchOption newOption) {
		eSet(QueriesPackage.Literals.SEARCH_RESULT_OPTION_VALUE__OPTION, newOption);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return (String)eGet(QueriesPackage.Literals.SEARCH_RESULT_OPTION_VALUE__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		eSet(QueriesPackage.Literals.SEARCH_RESULT_OPTION_VALUE__VALUE, newValue);
	}

} //SearchResultOptionValueImpl
