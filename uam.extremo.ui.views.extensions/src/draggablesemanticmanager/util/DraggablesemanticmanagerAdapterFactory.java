/**
 */
package draggablesemanticmanager.util;

import draggablesemanticmanager.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage
 * @generated
 */
public class DraggablesemanticmanagerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DraggablesemanticmanagerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggablesemanticmanagerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DraggablesemanticmanagerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DraggablesemanticmanagerSwitch<Adapter> modelSwitch =
		new DraggablesemanticmanagerSwitch<Adapter>() {
			@Override
			public Adapter caseDraggableNamedElement(DraggableNamedElement object) {
				return createDraggableNamedElementAdapter();
			}
			@Override
			public Adapter caseDraggableProperty(DraggableProperty object) {
				return createDraggablePropertyAdapter();
			}
			@Override
			public Adapter caseDraggableObjectProperty(DraggableObjectProperty object) {
				return createDraggableObjectPropertyAdapter();
			}
			@Override
			public Adapter caseDraggableDataProperty(DraggableDataProperty object) {
				return createDraggableDataPropertyAdapter();
			}
			@Override
			public Adapter caseDraggableSemanticNode(DraggableSemanticNode object) {
				return createDraggableSemanticNodeAdapter();
			}
			@Override
			public Adapter caseDraggableNamedElementSet(DraggableNamedElementSet object) {
				return createDraggableNamedElementSetAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link draggablesemanticmanager.DraggableNamedElement <em>Draggable Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see draggablesemanticmanager.DraggableNamedElement
	 * @generated
	 */
	public Adapter createDraggableNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link draggablesemanticmanager.DraggableProperty <em>Draggable Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see draggablesemanticmanager.DraggableProperty
	 * @generated
	 */
	public Adapter createDraggablePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link draggablesemanticmanager.DraggableObjectProperty <em>Draggable Object Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see draggablesemanticmanager.DraggableObjectProperty
	 * @generated
	 */
	public Adapter createDraggableObjectPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link draggablesemanticmanager.DraggableDataProperty <em>Draggable Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see draggablesemanticmanager.DraggableDataProperty
	 * @generated
	 */
	public Adapter createDraggableDataPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link draggablesemanticmanager.DraggableSemanticNode <em>Draggable Semantic Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see draggablesemanticmanager.DraggableSemanticNode
	 * @generated
	 */
	public Adapter createDraggableSemanticNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link draggablesemanticmanager.DraggableNamedElementSet <em>Draggable Named Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see draggablesemanticmanager.DraggableNamedElementSet
	 * @generated
	 */
	public Adapter createDraggableNamedElementSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DraggablesemanticmanagerAdapterFactory
