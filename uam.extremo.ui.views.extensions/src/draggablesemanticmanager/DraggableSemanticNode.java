/**
 */
package draggablesemanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Draggable Semantic Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link draggablesemanticmanager.DraggableSemanticNode#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableSemanticNode()
 * @model
 * @generated
 */
public interface DraggableSemanticNode extends DraggableNamedElement {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link draggablesemanticmanager.DraggableProperty}.
	 * It is bidirectional and its opposite is '{@link draggablesemanticmanager.DraggableProperty#getSemanticNodeFrom <em>Semantic Node From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableSemanticNode_Properties()
	 * @see draggablesemanticmanager.DraggableProperty#getSemanticNodeFrom
	 * @model opposite="semanticNodeFrom" containment="true"
	 * @generated
	 */
	EList<DraggableProperty> getProperties();

} // DraggableSemanticNode
