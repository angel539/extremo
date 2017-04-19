/**
 */
package semanticmanager.dataModel.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.dataModel.DataModelPackage;
import semanticmanager.dataModel.DataProperty;
import semanticmanager.dataModel.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.dataModel.impl.DataPropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.DataPropertyImpl#getValue <em>Value</em>}</li>
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
		return DataModelPackage.Literals.DATA_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return (Type)eGet(DataModelPackage.Literals.DATA_PROPERTY__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		eSet(DataModelPackage.Literals.DATA_PROPERTY__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return (String)eGet(DataModelPackage.Literals.DATA_PROPERTY__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		eSet(DataModelPackage.Literals.DATA_PROPERTY__VALUE, newValue);
	}

} //DataPropertyImpl
