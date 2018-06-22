/**
 */
package draggablesemanticmanager.impl;

import draggablesemanticmanager.DraggableNamedElementSet;
import draggablesemanticmanager.DraggableSemanticNode;
import draggablesemanticmanager.DraggablesemanticmanagerPackage;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Draggable Named Element Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link draggablesemanticmanager.impl.DraggableNamedElementSetImpl#getDraggableSemanticNodes <em>Draggable Semantic Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DraggableNamedElementSetImpl extends DefaultPersistentEObject implements DraggableNamedElementSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DraggableNamedElementSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DraggablesemanticmanagerPackage.Literals.DRAGGABLE_NAMED_ELEMENT_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DraggableSemanticNode> getDraggableSemanticNodes() {
		return (EList<DraggableSemanticNode>)eGet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_NAMED_ELEMENT_SET__DRAGGABLE_SEMANTIC_NODES, true);
	}

} //DraggableNamedElementSetImpl
