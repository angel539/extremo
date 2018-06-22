/**
 */
package draggablesemanticmanager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Draggable Object Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link draggablesemanticmanager.DraggableObjectProperty#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableObjectProperty()
 * @model
 * @generated
 */
public interface DraggableObjectProperty extends DraggableProperty {
	/**
	 * Returns the value of the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' reference.
	 * @see #setRange(DraggableSemanticNode)
	 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableObjectProperty_Range()
	 * @model
	 * @generated
	 */
	DraggableSemanticNode getRange();

	/**
	 * Sets the value of the '{@link draggablesemanticmanager.DraggableObjectProperty#getRange <em>Range</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(DraggableSemanticNode value);

} // DraggableObjectProperty
