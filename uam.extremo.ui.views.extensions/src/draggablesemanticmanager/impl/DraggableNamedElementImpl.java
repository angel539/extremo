/**
 */
package draggablesemanticmanager.impl;

import draggablesemanticmanager.DraggableNamedElement;
import draggablesemanticmanager.DraggablesemanticmanagerPackage;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Draggable Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link draggablesemanticmanager.impl.DraggableNamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link draggablesemanticmanager.impl.DraggableNamedElementImpl#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link draggablesemanticmanager.impl.DraggableNamedElementImpl#getDescribes <em>Describes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DraggableNamedElementImpl extends DefaultPersistentEObject implements DraggableNamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DraggableNamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DraggablesemanticmanagerPackage.Literals.DRAGGABLE_NAMED_ELEMENT;
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
	public String getName() {
		return (String)eGet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_NAMED_ELEMENT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_NAMED_ELEMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DraggableNamedElement> getDescriptors() {
		return (EList<DraggableNamedElement>)eGet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_NAMED_ELEMENT__DESCRIPTORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DraggableNamedElement> getDescribes() {
		return (EList<DraggableNamedElement>)eGet(DraggablesemanticmanagerPackage.Literals.DRAGGABLE_NAMED_ELEMENT__DESCRIBES, true);
	}

} //DraggableNamedElementImpl
