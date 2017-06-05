/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.PrimitiveTypeSearchOption;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type Search Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.PrimitiveTypeSearchOptionImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveTypeSearchOptionImpl extends SearchOptionImpl implements PrimitiveTypeSearchOption {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeSearchOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_SEARCH_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return (Type)eGet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_SEARCH_OPTION__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eSet(SemanticmanagerPackage.Literals.PRIMITIVE_TYPE_SEARCH_OPTION__TYPE, newType);
	}

} //PrimitiveTypeSearchOptionImpl
