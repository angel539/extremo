/**
 */
package draggablesemanticmanager.impl;

import draggablesemanticmanager.DraggableProperty;
import draggablesemanticmanager.DraggableSemanticNode;
import draggablesemanticmanager.DraggablesemanticmanagerPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Draggable Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link draggablesemanticmanager.impl.DraggablePropertyImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link draggablesemanticmanager.impl.DraggablePropertyImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link draggablesemanticmanager.impl.DraggablePropertyImpl#getSemanticNodeFrom <em>Semantic Node From</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DraggablePropertyImpl extends DraggableNamedElementImpl implements DraggableProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DraggablePropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DraggablesemanticmanagerPackage.Literals.DRAGGABLE_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLowerBound() {
		return (Integer)eGet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_PROPERTY__LOWER_BOUND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(int newLowerBound) {
		eSet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_PROPERTY__LOWER_BOUND, newLowerBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpperBound() {
		return (Integer)eGet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_PROPERTY__UPPER_BOUND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(int newUpperBound) {
		eSet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_PROPERTY__UPPER_BOUND, newUpperBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggableSemanticNode getSemanticNodeFrom() {
		return (DraggableSemanticNode)eGet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_PROPERTY__SEMANTIC_NODE_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticNodeFrom(DraggableSemanticNode newSemanticNodeFrom) {
		eSet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_PROPERTY__SEMANTIC_NODE_FROM, newSemanticNodeFrom);
	}

} //DraggablePropertyImpl
