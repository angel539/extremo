/**
 */
package draggablesemanticmanager.impl;

import draggablesemanticmanager.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DraggablesemanticmanagerFactoryImpl extends EFactoryImpl implements DraggablesemanticmanagerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DraggablesemanticmanagerFactory init() {
		try {
			DraggablesemanticmanagerFactory theDraggablesemanticmanagerFactory = (DraggablesemanticmanagerFactory)EPackage.Registry.INSTANCE.getEFactory(DraggablesemanticmanagerPackage.eNS_URI);
			if (theDraggablesemanticmanagerFactory != null) {
				return theDraggablesemanticmanagerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DraggablesemanticmanagerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggablesemanticmanagerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DraggablesemanticmanagerPackage.DRAGGABLE_OBJECT_PROPERTY: return (EObject)createDraggableObjectProperty();
			case DraggablesemanticmanagerPackage.DRAGGABLE_DATA_PROPERTY: return (EObject)createDraggableDataProperty();
			case DraggablesemanticmanagerPackage.DRAGGABLE_SEMANTIC_NODE: return (EObject)createDraggableSemanticNode();
			case DraggablesemanticmanagerPackage.DRAGGABLE_NAMED_ELEMENT_SET: return (EObject)createDraggableNamedElementSet();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggableObjectProperty createDraggableObjectProperty() {
		DraggableObjectPropertyImpl draggableObjectProperty = new DraggableObjectPropertyImpl();
		return draggableObjectProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggableDataProperty createDraggableDataProperty() {
		DraggableDataPropertyImpl draggableDataProperty = new DraggableDataPropertyImpl();
		return draggableDataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggableSemanticNode createDraggableSemanticNode() {
		DraggableSemanticNodeImpl draggableSemanticNode = new DraggableSemanticNodeImpl();
		return draggableSemanticNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggableNamedElementSet createDraggableNamedElementSet() {
		DraggableNamedElementSetImpl draggableNamedElementSet = new DraggableNamedElementSetImpl();
		return draggableNamedElementSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggablesemanticmanagerPackage getDraggablesemanticmanagerPackage() {
		return (DraggablesemanticmanagerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DraggablesemanticmanagerPackage getPackage() {
		return DraggablesemanticmanagerPackage.eINSTANCE;
	}

} //DraggablesemanticmanagerFactoryImpl
