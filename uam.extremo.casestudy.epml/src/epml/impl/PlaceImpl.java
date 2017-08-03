/**
 */
package epml.impl;

import epml.Application;
import epml.EpmlPackage;
import epml.InputPort;
import epml.NamedElement;
import epml.OutputPort;
import epml.Place;

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.impl.CATEGORIZATIONCLASSImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link epml.impl.PlaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link epml.impl.PlaceImpl#getItsOutputPort <em>Its Output Port</em>}</li>
 *   <li>{@link epml.impl.PlaceImpl#getItsInputPort <em>Its Input Port</em>}</li>
 *   <li>{@link epml.impl.PlaceImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PlaceImpl extends CATEGORIZATIONCLASSImpl implements Place {
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
	 * The cached value of the '{@link #getItsOutputPort() <em>Its Output Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsOutputPort()
	 * @generated
	 * @ordered
	 */
	protected OutputPort itsOutputPort;

	/**
	 * The cached value of the '{@link #getItsInputPort() <em>Its Input Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsInputPort()
	 * @generated
	 * @ordered
	 */
	protected InputPort itsInputPort;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EpmlPackage.Literals.PLACE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EpmlPackage.PLACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort getItsOutputPort() {
		if (itsOutputPort != null && itsOutputPort.eIsProxy()) {
			InternalEObject oldItsOutputPort = (InternalEObject)itsOutputPort;
			itsOutputPort = (OutputPort)eResolveProxy(oldItsOutputPort);
			if (itsOutputPort != oldItsOutputPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EpmlPackage.PLACE__ITS_OUTPUT_PORT, oldItsOutputPort, itsOutputPort));
			}
		}
		return itsOutputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort basicGetItsOutputPort() {
		return itsOutputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsOutputPort(OutputPort newItsOutputPort) {
		OutputPort oldItsOutputPort = itsOutputPort;
		itsOutputPort = newItsOutputPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpmlPackage.PLACE__ITS_OUTPUT_PORT, oldItsOutputPort, itsOutputPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort getItsInputPort() {
		if (itsInputPort != null && itsInputPort.eIsProxy()) {
			InternalEObject oldItsInputPort = (InternalEObject)itsInputPort;
			itsInputPort = (InputPort)eResolveProxy(oldItsInputPort);
			if (itsInputPort != oldItsInputPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EpmlPackage.PLACE__ITS_INPUT_PORT, oldItsInputPort, itsInputPort));
			}
		}
		return itsInputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort basicGetItsInputPort() {
		return itsInputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsInputPort(InputPort newItsInputPort) {
		InputPort oldItsInputPort = itsInputPort;
		itsInputPort = newItsInputPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpmlPackage.PLACE__ITS_INPUT_PORT, oldItsInputPort, itsInputPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application getOwner() {
		if (eContainerFeatureID() != EpmlPackage.PLACE__OWNER) return null;
		return (Application)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Application newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, EpmlPackage.PLACE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Application newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != EpmlPackage.PLACE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, EpmlPackage.APPLICATION__OWNED_PLACES, Application.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EpmlPackage.PLACE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EpmlPackage.PLACE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Application)otherEnd, msgs);
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
			case EpmlPackage.PLACE__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case EpmlPackage.PLACE__OWNER:
				return eInternalContainer().eInverseRemove(this, EpmlPackage.APPLICATION__OWNED_PLACES, Application.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EpmlPackage.PLACE__NAME:
				return getName();
			case EpmlPackage.PLACE__ITS_OUTPUT_PORT:
				if (resolve) return getItsOutputPort();
				return basicGetItsOutputPort();
			case EpmlPackage.PLACE__ITS_INPUT_PORT:
				if (resolve) return getItsInputPort();
				return basicGetItsInputPort();
			case EpmlPackage.PLACE__OWNER:
				return getOwner();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EpmlPackage.PLACE__NAME:
				setName((String)newValue);
				return;
			case EpmlPackage.PLACE__ITS_OUTPUT_PORT:
				setItsOutputPort((OutputPort)newValue);
				return;
			case EpmlPackage.PLACE__ITS_INPUT_PORT:
				setItsInputPort((InputPort)newValue);
				return;
			case EpmlPackage.PLACE__OWNER:
				setOwner((Application)newValue);
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
			case EpmlPackage.PLACE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EpmlPackage.PLACE__ITS_OUTPUT_PORT:
				setItsOutputPort((OutputPort)null);
				return;
			case EpmlPackage.PLACE__ITS_INPUT_PORT:
				setItsInputPort((InputPort)null);
				return;
			case EpmlPackage.PLACE__OWNER:
				setOwner((Application)null);
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
			case EpmlPackage.PLACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EpmlPackage.PLACE__ITS_OUTPUT_PORT:
				return itsOutputPort != null;
			case EpmlPackage.PLACE__ITS_INPUT_PORT:
				return itsInputPort != null;
			case EpmlPackage.PLACE__OWNER:
				return getOwner() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case EpmlPackage.PLACE__NAME: return EpmlPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case EpmlPackage.NAMED_ELEMENT__NAME: return EpmlPackage.PLACE__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(')');
		return result.toString();
	}

} //PlaceImpl
