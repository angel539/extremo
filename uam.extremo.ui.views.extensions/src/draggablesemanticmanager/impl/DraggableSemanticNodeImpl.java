/**
 */
package draggablesemanticmanager.impl;

import draggablesemanticmanager.DraggableProperty;
import draggablesemanticmanager.DraggableSemanticNode;
import draggablesemanticmanager.DraggablesemanticmanagerPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Draggable Semantic Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link draggablesemanticmanager.impl.DraggableSemanticNodeImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DraggableSemanticNodeImpl extends DraggableNamedElementImpl implements DraggableSemanticNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DraggableSemanticNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DraggablesemanticmanagerPackage.Literals.DRAGGABLE_SEMANTIC_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DraggableProperty> getProperties() {
		return (EList<DraggableProperty>)eGet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_SEMANTIC_NODE__PROPERTIES, true);
	}

} //DraggableSemanticNodeImpl
