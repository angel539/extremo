/**
 */
package semanticmanager.dataModel.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.dataModel.DataModelPackage;
import semanticmanager.dataModel.ObjectProperty;
import semanticmanager.dataModel.SemanticNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.dataModel.impl.ObjectPropertyImpl#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectPropertyImpl extends PropertyImpl implements ObjectProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataModelPackage.Literals.OBJECT_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticNode getRange() {
		return (SemanticNode)eGet(DataModelPackage.Literals.OBJECT_PROPERTY__RANGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(SemanticNode newRange) {
		eSet(DataModelPackage.Literals.OBJECT_PROPERTY__RANGE, newRange);
	}

} //ObjectPropertyImpl
