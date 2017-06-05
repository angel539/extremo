/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.PrimitiveTypeSearchOption;
import semanticmanager.PrimitiveTypeSearchResultOptionValue;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type Search Result Option Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.PrimitiveTypeSearchResultOptionValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link semanticmanager.impl.PrimitiveTypeSearchResultOptionValueImpl#getOption <em>Option</em>}</li>
 *   <li>{@link semanticmanager.impl.PrimitiveTypeSearchResultOptionValueImpl#getCalls <em>Calls</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveTypeSearchResultOptionValueImpl extends SearchResultOptionValueImpl implements PrimitiveTypeSearchResultOptionValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeSearchResultOptionValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_SEARCH_RESULT_OPTION_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return (String)eGet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_SEARCH_RESULT_OPTION_VALUE__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		eSet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_SEARCH_RESULT_OPTION_VALUE__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeSearchOption getOption() {
		return (PrimitiveTypeSearchOption)eGet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_SEARCH_RESULT_OPTION_VALUE__OPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOption(PrimitiveTypeSearchOption newOption) {
		eSet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_SEARCH_RESULT_OPTION_VALUE__OPTION, newOption);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getCalls() {
		return (Service)eGet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_SEARCH_RESULT_OPTION_VALUE__CALLS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalls(Service newCalls) {
		eSet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_SEARCH_RESULT_OPTION_VALUE__CALLS, newCalls);
	}

} //PrimitiveTypeSearchResultOptionValueImpl
