/**
 */
package draggablesemanticmanager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Draggable Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link draggablesemanticmanager.DraggableProperty#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link draggablesemanticmanager.DraggableProperty#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link draggablesemanticmanager.DraggableProperty#getSemanticNodeFrom <em>Semantic Node From</em>}</li>
 * </ul>
 *
 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableProperty()
 * @model abstract="true"
 * @generated
 */
public interface DraggableProperty extends DraggableNamedElement {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableProperty_LowerBound()
	 * @model
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link draggablesemanticmanager.DraggableProperty#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(int)
	 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableProperty_UpperBound()
	 * @model
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link draggablesemanticmanager.DraggableProperty#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>Semantic Node From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link draggablesemanticmanager.DraggableSemanticNode#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Node From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantic Node From</em>' container reference.
	 * @see #setSemanticNodeFrom(DraggableSemanticNode)
	 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableProperty_SemanticNodeFrom()
	 * @see draggablesemanticmanager.DraggableSemanticNode#getProperties
	 * @model opposite="properties" transient="false"
	 * @generated
	 */
	DraggableSemanticNode getSemanticNodeFrom();

	/**
	 * Sets the value of the '{@link draggablesemanticmanager.DraggableProperty#getSemanticNodeFrom <em>Semantic Node From</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantic Node From</em>' container reference.
	 * @see #getSemanticNodeFrom()
	 * @generated
	 */
	void setSemanticNodeFrom(DraggableSemanticNode value);

} // DraggableProperty
