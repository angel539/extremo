/**
 */
package semanticmanager.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import semanticmanager.Constraint;
import semanticmanager.NamedElement;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#isDrawn <em>Drawn</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getDescribes <em>Describes</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NamedElementImpl extends MinimalEObjectImpl.Container implements NamedElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final int WEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected int weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated NOT
	 * @ordered
	 */
	transient protected static final Object ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated NOT
	 * @ordered
	 */
	transient protected Object id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isDrawn() <em>Drawn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDrawn()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DRAWN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDrawn() <em>Drawn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDrawn()
	 * @generated
	 * @ordered
	 */
	protected boolean drawn = DRAWN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptor()
	 * @generated
	 * @ordered
	 */
	protected NamedElement descriptor;

	/**
	 * The cached value of the '{@link #getDescribes() <em>Describes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescribes()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> describes;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.NAMED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.NAMED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(int newWeight) {
		int oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.NAMED_ELEMENT__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(Object newId) {
		Object oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.NAMED_ELEMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDrawn() {
		return drawn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrawn(boolean newDrawn) {
		boolean oldDrawn = drawn;
		drawn = newDrawn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.NAMED_ELEMENT__DRAWN, oldDrawn, drawn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getDescriptor() {
		if (descriptor != null && descriptor.eIsProxy()) {
			InternalEObject oldDescriptor = (InternalEObject)descriptor;
			descriptor = (NamedElement)eResolveProxy(oldDescriptor);
			if (descriptor != oldDescriptor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTOR, oldDescriptor, descriptor));
			}
		}
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetDescriptor() {
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptor(NamedElement newDescriptor, NotificationChain msgs) {
		NamedElement oldDescriptor = descriptor;
		descriptor = newDescriptor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTOR, oldDescriptor, newDescriptor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptor(NamedElement newDescriptor) {
		if (newDescriptor != descriptor) {
			NotificationChain msgs = null;
			if (descriptor != null)
				msgs = ((InternalEObject)descriptor).eInverseRemove(this, SemanticmanagerPackage.NAMED_ELEMENT__DESCRIBES, NamedElement.class, msgs);
			if (newDescriptor != null)
				msgs = ((InternalEObject)newDescriptor).eInverseAdd(this, SemanticmanagerPackage.NAMED_ELEMENT__DESCRIBES, NamedElement.class, msgs);
			msgs = basicSetDescriptor(newDescriptor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTOR, newDescriptor, newDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getDescribes() {
		if (describes == null) {
			describes = new EObjectWithInverseResolvingEList<NamedElement>(NamedElement.class, this, SemanticmanagerPackage.NAMED_ELEMENT__DESCRIBES, SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTOR);
		}
		return describes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentWithInverseEList<Constraint>(Constraint.class, this, SemanticmanagerPackage.NAMED_ELEMENT__CONSTRAINTS, SemanticmanagerPackage.CONSTRAINT__ELEMENTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTOR:
				if (descriptor != null)
					msgs = ((InternalEObject)descriptor).eInverseRemove(this, SemanticmanagerPackage.NAMED_ELEMENT__DESCRIBES, NamedElement.class, msgs);
				return basicSetDescriptor((NamedElement)otherEnd, msgs);
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIBES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDescribes()).basicAdd(otherEnd, msgs);
			case SemanticmanagerPackage.NAMED_ELEMENT__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTOR:
				return basicSetDescriptor(null, msgs);
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIBES:
				return ((InternalEList<?>)getDescribes()).basicRemove(otherEnd, msgs);
			case SemanticmanagerPackage.NAMED_ELEMENT__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SemanticmanagerPackage.NAMED_ELEMENT__NAME:
				return getName();
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTION:
				return getDescription();
			case SemanticmanagerPackage.NAMED_ELEMENT__WEIGHT:
				return getWeight();
			case SemanticmanagerPackage.NAMED_ELEMENT__ID:
				return getId();
			case SemanticmanagerPackage.NAMED_ELEMENT__DRAWN:
				return isDrawn();
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTOR:
				if (resolve) return getDescriptor();
				return basicGetDescriptor();
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIBES:
				return getDescribes();
			case SemanticmanagerPackage.NAMED_ELEMENT__CONSTRAINTS:
				return getConstraints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SemanticmanagerPackage.NAMED_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__WEIGHT:
				setWeight((Integer)newValue);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__ID:
				setId(newValue);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__DRAWN:
				setDrawn((Boolean)newValue);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTOR:
				setDescriptor((NamedElement)newValue);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIBES:
				getDescribes().clear();
				getDescribes().addAll((Collection<? extends NamedElement>)newValue);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SemanticmanagerPackage.NAMED_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__DRAWN:
				setDrawn(DRAWN_EDEFAULT);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTOR:
				setDescriptor((NamedElement)null);
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIBES:
				getDescribes().clear();
				return;
			case SemanticmanagerPackage.NAMED_ELEMENT__CONSTRAINTS:
				getConstraints().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SemanticmanagerPackage.NAMED_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SemanticmanagerPackage.NAMED_ELEMENT__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case SemanticmanagerPackage.NAMED_ELEMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SemanticmanagerPackage.NAMED_ELEMENT__DRAWN:
				return drawn != DRAWN_EDEFAULT;
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIPTOR:
				return descriptor != null;
			case SemanticmanagerPackage.NAMED_ELEMENT__DESCRIBES:
				return describes != null && !describes.isEmpty();
			case SemanticmanagerPackage.NAMED_ELEMENT__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", weight: ");
		result.append(weight);
		result.append(", id: ");
		result.append(id);
		result.append(", drawn: ");
		result.append(drawn);
		result.append(')');
		return result.toString();
	}

} //NamedElementImpl
