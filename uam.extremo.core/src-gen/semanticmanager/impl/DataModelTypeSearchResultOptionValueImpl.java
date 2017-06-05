/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.DataModelTypeSearchOption;
import semanticmanager.DataModelTypeSearchResultOptionValue;
import semanticmanager.NamedElement;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Model Type Search Result Option Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.DataModelTypeSearchResultOptionValueImpl#getOption <em>Option</em>}</li>
 *   <li>{@link semanticmanager.impl.DataModelTypeSearchResultOptionValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataModelTypeSearchResultOptionValueImpl extends SearchResultOptionValueImpl implements DataModelTypeSearchResultOptionValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataModelTypeSearchResultOptionValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.DATA_MODEL_TYPE_SEARCH_RESULT_OPTION_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataModelTypeSearchOption getOption() {
		return (DataModelTypeSearchOption)eGet(SemanticmanagerPackage.Literals.DATA_MODEL_TYPE_SEARCH_RESULT_OPTION_VALUE__OPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOption(DataModelTypeSearchOption newOption) {
		eSet(SemanticmanagerPackage.Literals.DATA_MODEL_TYPE_SEARCH_RESULT_OPTION_VALUE__OPTION, newOption);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getValue() {
		return (NamedElement)eGet(SemanticmanagerPackage.Literals.DATA_MODEL_TYPE_SEARCH_RESULT_OPTION_VALUE__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(NamedElement newValue) {
		eSet(SemanticmanagerPackage.Literals.DATA_MODEL_TYPE_SEARCH_RESULT_OPTION_VALUE__VALUE, newValue);
	}

} //DataModelTypeSearchResultOptionValueImpl
