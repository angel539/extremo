/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EClass;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type Param Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.PrimitiveTypeParamValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link semanticmanager.impl.PrimitiveTypeParamValueImpl#getCalls <em>Calls</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveTypeParamValueImpl extends SearchParamValueImpl implements PrimitiveTypeParamValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeParamValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_PARAM_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return (String)eGet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_PARAM_VALUE__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		eSet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_PARAM_VALUE__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getCalls() {
		return (Service)eGet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_PARAM_VALUE__CALLS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalls(Service newCalls) {
		eSet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_PARAM_VALUE__CALLS, newCalls);
	}

} //PrimitiveTypeParamValueImpl
