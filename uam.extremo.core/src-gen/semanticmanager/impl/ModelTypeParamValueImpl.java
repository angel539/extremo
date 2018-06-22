/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.ModelTypeParam;
import semanticmanager.ModelTypeParamValue;
import semanticmanager.NamedElement;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Type Param Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.ModelTypeParamValueImpl#getOption <em>Option</em>}</li>
 *   <li>{@link semanticmanager.impl.ModelTypeParamValueImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelTypeParamValueImpl extends SearchParamValueImpl implements ModelTypeParamValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelTypeParamValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.MODEL_TYPE_PARAM_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTypeParam getOption() {
		return (ModelTypeParam)eGet(SemanticmanagerPackage.Literals.MODEL_TYPE_PARAM_VALUE__OPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOption(ModelTypeParam newOption) {
		eSet(SemanticmanagerPackage.Literals.MODEL_TYPE_PARAM_VALUE__OPTION, newOption);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getValue() {
		return (NamedElement)eGet(SemanticmanagerPackage.Literals.MODEL_TYPE_PARAM_VALUE__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(NamedElement newValue) {
		eSet(SemanticmanagerPackage.Literals.MODEL_TYPE_PARAM_VALUE__VALUE, newValue);
	}

} //ModelTypeParamValueImpl
