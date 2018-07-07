/**
 */
package uam.extremo.core.impl;

import org.eclipse.emf.ecore.EClass;

import uam.extremo.core.DataProperty;
import uam.extremo.core.SemanticmanagerPackage;
import uam.extremo.core.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.DataPropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link uam.extremo.core.impl.DataPropertyImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataPropertyImpl extends PropertyImpl implements DataProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.DATA_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return (Type)eGet(SemanticmanagerPackage.Literals.DATA_PROPERTY__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eSet(SemanticmanagerPackage.Literals.DATA_PROPERTY__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return (String)eGet(SemanticmanagerPackage.Literals.DATA_PROPERTY__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		eSet(SemanticmanagerPackage.Literals.DATA_PROPERTY__VALUE, newValue);
	}

} //DataPropertyImpl
