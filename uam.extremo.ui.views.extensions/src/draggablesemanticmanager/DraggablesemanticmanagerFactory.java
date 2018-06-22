/**
 */
package draggablesemanticmanager;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage
 * @generated
 */
public interface DraggablesemanticmanagerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DraggablesemanticmanagerFactory eINSTANCE = draggablesemanticmanager.impl.DraggablesemanticmanagerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Draggable Object Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Draggable Object Property</em>'.
	 * @generated
	 */
	DraggableObjectProperty createDraggableObjectProperty();

	/**
	 * Returns a new object of class '<em>Draggable Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Draggable Data Property</em>'.
	 * @generated
	 */
	DraggableDataProperty createDraggableDataProperty();

	/**
	 * Returns a new object of class '<em>Draggable Semantic Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Draggable Semantic Node</em>'.
	 * @generated
	 */
	DraggableSemanticNode createDraggableSemanticNode();

	/**
	 * Returns a new object of class '<em>Draggable Named Element Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Draggable Named Element Set</em>'.
	 * @generated
	 */
	DraggableNamedElementSet createDraggableNamedElementSet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DraggablesemanticmanagerPackage getDraggablesemanticmanagerPackage();

} //DraggablesemanticmanagerFactory
