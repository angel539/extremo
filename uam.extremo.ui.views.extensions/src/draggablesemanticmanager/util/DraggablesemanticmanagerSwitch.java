/**
 */
package draggablesemanticmanager.util;

import draggablesemanticmanager.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage
 * @generated
 */
public class DraggablesemanticmanagerSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DraggablesemanticmanagerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggablesemanticmanagerSwitch() {
		if (modelPackage == null) {
			modelPackage = DraggablesemanticmanagerPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DraggablesemanticmanagerPackage.DRAGGABLE_NAMED_ELEMENT: {
				DraggableNamedElement draggableNamedElement = (DraggableNamedElement)theEObject;
				T result = caseDraggableNamedElement(draggableNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DraggablesemanticmanagerPackage.DRAGGABLE_PROPERTY: {
				DraggableProperty draggableProperty = (DraggableProperty)theEObject;
				T result = caseDraggableProperty(draggableProperty);
				if (result == null) result = caseDraggableNamedElement(draggableProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DraggablesemanticmanagerPackage.DRAGGABLE_OBJECT_PROPERTY: {
				DraggableObjectProperty draggableObjectProperty = (DraggableObjectProperty)theEObject;
				T result = caseDraggableObjectProperty(draggableObjectProperty);
				if (result == null) result = caseDraggableProperty(draggableObjectProperty);
				if (result == null) result = caseDraggableNamedElement(draggableObjectProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DraggablesemanticmanagerPackage.DRAGGABLE_DATA_PROPERTY: {
				DraggableDataProperty draggableDataProperty = (DraggableDataProperty)theEObject;
				T result = caseDraggableDataProperty(draggableDataProperty);
				if (result == null) result = caseDraggableProperty(draggableDataProperty);
				if (result == null) result = caseDraggableNamedElement(draggableDataProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DraggablesemanticmanagerPackage.DRAGGABLE_SEMANTIC_NODE: {
				DraggableSemanticNode draggableSemanticNode = (DraggableSemanticNode)theEObject;
				T result = caseDraggableSemanticNode(draggableSemanticNode);
				if (result == null) result = caseDraggableNamedElement(draggableSemanticNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DraggablesemanticmanagerPackage.DRAGGABLE_NAMED_ELEMENT_SET: {
				DraggableNamedElementSet draggableNamedElementSet = (DraggableNamedElementSet)theEObject;
				T result = caseDraggableNamedElementSet(draggableNamedElementSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Draggable Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Draggable Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDraggableNamedElement(DraggableNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Draggable Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Draggable Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDraggableProperty(DraggableProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Draggable Object Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Draggable Object Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDraggableObjectProperty(DraggableObjectProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Draggable Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Draggable Data Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDraggableDataProperty(DraggableDataProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Draggable Semantic Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Draggable Semantic Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDraggableSemanticNode(DraggableSemanticNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Draggable Named Element Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Draggable Named Element Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDraggableNamedElementSet(DraggableNamedElementSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DraggablesemanticmanagerSwitch
