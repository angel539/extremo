/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.PrimitiveTypeParam;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.PrimitiveTypeParamImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveTypeParamImpl extends SearchParamImpl implements PrimitiveTypeParam {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_PARAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return (Type)eGet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_PARAM__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eSet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_PARAM__TYPE, newType);
	}

} //PrimitiveTypeParamImpl
