/**
 */
package uam.extremo.core.impl;

import org.eclipse.emf.ecore.EClass;

import uam.extremo.core.ObjectProperty;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.ObjectPropertyImpl#getRange <em>Range</em>}</li>
 *   <li>{@link uam.extremo.core.impl.ObjectPropertyImpl#getInverseOf <em>Inverse Of</em>}</li>
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
		return SemanticmanagerPackage.Literals.OBJECT_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticNode getRange() {
		return (SemanticNode)eGet(SemanticmanagerPackage.Literals.OBJECT_PROPERTY__RANGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(SemanticNode newRange) {
		eSet(SemanticmanagerPackage.Literals.OBJECT_PROPERTY__RANGE, newRange);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectProperty getInverseOf() {
		return (ObjectProperty)eGet(SemanticmanagerPackage.Literals.OBJECT_PROPERTY__INVERSE_OF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInverseOf(ObjectProperty newInverseOf) {
		eSet(SemanticmanagerPackage.Literals.OBJECT_PROPERTY__INVERSE_OF, newInverseOf);
	}

} //ObjectPropertyImpl
