/**
 */
package draggablesemanticmanager;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Draggable Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link draggablesemanticmanager.DraggableNamedElement#getName <em>Name</em>}</li>
 *   <li>{@link draggablesemanticmanager.DraggableNamedElement#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link draggablesemanticmanager.DraggableNamedElement#getDescribes <em>Describes</em>}</li>
 * </ul>
 *
 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableNamedElement()
 * @model abstract="true"
 * @extends PersistentEObject
 * @generated
 */
public interface DraggableNamedElement extends PersistentEObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableNamedElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link draggablesemanticmanager.DraggableNamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Descriptors</b></em>' reference list.
	 * The list contents are of type {@link draggablesemanticmanager.DraggableNamedElement}.
	 * It is bidirectional and its opposite is '{@link draggablesemanticmanager.DraggableNamedElement#getDescribes <em>Describes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors</em>' reference list.
	 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableNamedElement_Descriptors()
	 * @see draggablesemanticmanager.DraggableNamedElement#getDescribes
	 * @model opposite="describes"
	 * @generated
	 */
	EList<DraggableNamedElement> getDescriptors();

	/**
	 * Returns the value of the '<em><b>Describes</b></em>' reference list.
	 * The list contents are of type {@link draggablesemanticmanager.DraggableNamedElement}.
	 * It is bidirectional and its opposite is '{@link draggablesemanticmanager.DraggableNamedElement#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Describes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Describes</em>' reference list.
	 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#getDraggableNamedElement_Describes()
	 * @see draggablesemanticmanager.DraggableNamedElement#getDescriptors
	 * @model opposite="descriptors"
	 * @generated
	 */
	EList<DraggableNamedElement> getDescribes();

} // DraggableNamedElement
