/**
 */
package draggablesemanticmanager;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Draggable Named Element Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link draggablesemanticmanager.DraggableNamedElementSet#getDraggableSemanticNodes <em>Draggable Semantic Nodes</em>}</li>
 * </ul>
 *
 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableNamedElementSet()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface DraggableNamedElementSet extends PersistentEObject {
	/**
	 * Returns the value of the '<em><b>Draggable Semantic Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link draggablesemanticmanager.DraggableSemanticNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Draggable Semantic Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Draggable Semantic Nodes</em>' containment reference list.
	 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableNamedElementSet_DraggableSemanticNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DraggableSemanticNode> getDraggableSemanticNodes();

} // DraggableNamedElementSet
