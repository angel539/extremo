/**
 */
package draggablesemanticmanager.impl;

import draggablesemanticmanager.DraggableObjectProperty;
import draggablesemanticmanager.DraggableSemanticNode;
import draggablesemanticmanager.DraggablesemanticmanagerPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Draggable Object Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link draggablesemanticmanager.impl.DraggableObjectPropertyImpl#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DraggableObjectPropertyImpl extends DraggablePropertyImpl implements DraggableObjectProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DraggableObjectPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DraggablesemanticmanagerPackage.Literals.DRAGGABLE_OBJECT_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggableSemanticNode getRange() {
		return (DraggableSemanticNode)eGet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_OBJECT_PROPERTY__RANGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(DraggableSemanticNode newRange) {
		eSet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_OBJECT_PROPERTY__RANGE, newRange);
	}

} //DraggableObjectPropertyImpl
