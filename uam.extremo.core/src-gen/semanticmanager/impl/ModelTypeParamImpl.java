/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.DataModelType;
import semanticmanager.ModelTypeParam;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Type Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.ModelTypeParamImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelTypeParamImpl extends SearchParamImpl implements ModelTypeParam {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelTypeParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.MODEL_TYPE_PARAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataModelType getType() {
		return (DataModelType)eGet(SemanticmanagerPackage.Literals.MODEL_TYPE_PARAM__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DataModelType newType) {
		eSet(SemanticmanagerPackage.Literals.MODEL_TYPE_PARAM__TYPE, newType);
	}

} //ModelTypeParamImpl
