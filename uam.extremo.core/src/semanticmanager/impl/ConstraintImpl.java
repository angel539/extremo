/**
 */
package semanticmanager.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import semanticmanager.Constraint;
import semanticmanager.ConstraintInterpreter;
import semanticmanager.NamedElement;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.ConstraintImpl#getKey <em>Key</em>}</li>
 *   <li>{@link semanticmanager.impl.ConstraintImpl#getValue <em>Value</em>}</li>
 *   <li>{@link semanticmanager.impl.ConstraintImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link semanticmanager.impl.ConstraintImpl#getInterpreter <em>Interpreter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintImpl extends MinimalEObjectImpl.Container implements Constraint {
	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInterpreter() <em>Interpreter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterpreter()
	 * @generated
	 * @ordered
	 */
	protected ConstraintInterpreter interpreter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.CONSTRAINT__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.CONSTRAINT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getElements() {
		if (eContainerFeatureID() != SemanticmanagerPackage.CONSTRAINT__ELEMENTS) return null;
		return (NamedElement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElements(NamedElement newElements, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newElements, SemanticmanagerPackage.CONSTRAINT__ELEMENTS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElements(NamedElement newElements) {
		if (newElements != eInternalContainer() || (eContainerFeatureID() != SemanticmanagerPackage.CONSTRAINT__ELEMENTS && newElements != null)) {
			if (EcoreUtil.isAncestor(this, newElements))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newElements != null)
				msgs = ((InternalEObject)newElements).eInverseAdd(this, SemanticmanagerPackage.NAMED_ELEMENT__CONSTRAINTS, NamedElement.class, msgs);
			msgs = basicSetElements(newElements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.CONSTRAINT__ELEMENTS, newElements, newElements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintInterpreter getInterpreter() {
		if (interpreter != null && interpreter.eIsProxy()) {
			InternalEObject oldInterpreter = (InternalEObject)interpreter;
			interpreter = (ConstraintInterpreter)eResolveProxy(oldInterpreter);
			if (interpreter != oldInterpreter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SemanticmanagerPackage.CONSTRAINT__INTERPRETER, oldInterpreter, interpreter));
			}
		}
		return interpreter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintInterpreter basicGetInterpreter() {
		return interpreter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterpreter(ConstraintInterpreter newInterpreter, NotificationChain msgs) {
		ConstraintInterpreter oldInterpreter = interpreter;
		interpreter = newInterpreter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.CONSTRAINT__INTERPRETER, oldInterpreter, newInterpreter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpreter(ConstraintInterpreter newInterpreter) {
		if (newInterpreter != interpreter) {
			NotificationChain msgs = null;
			if (interpreter != null)
				msgs = ((InternalEObject)interpreter).eInverseRemove(this, SemanticmanagerPackage.CONSTRAINT_INTERPRETER__CONSTRAINTS, ConstraintInterpreter.class, msgs);
			if (newInterpreter != null)
				msgs = ((InternalEObject)newInterpreter).eInverseAdd(this, SemanticmanagerPackage.CONSTRAINT_INTERPRETER__CONSTRAINTS, ConstraintInterpreter.class, msgs);
			msgs = basicSetInterpreter(newInterpreter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.CONSTRAINT__INTERPRETER, newInterpreter, newInterpreter));
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
			case SemanticmanagerPackage.CONSTRAINT__ELEMENTS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetElements((NamedElement)otherEnd, msgs);
			case SemanticmanagerPackage.CONSTRAINT__INTERPRETER:
				if (interpreter != null)
					msgs = ((InternalEObject)interpreter).eInverseRemove(this, SemanticmanagerPackage.CONSTRAINT_INTERPRETER__CONSTRAINTS, ConstraintInterpreter.class, msgs);
				return basicSetInterpreter((ConstraintInterpreter)otherEnd, msgs);
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
			case SemanticmanagerPackage.CONSTRAINT__ELEMENTS:
				return basicSetElements(null, msgs);
			case SemanticmanagerPackage.CONSTRAINT__INTERPRETER:
				return basicSetInterpreter(null, msgs);
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
			case SemanticmanagerPackage.CONSTRAINT__ELEMENTS:
				return eInternalContainer().eInverseRemove(this, SemanticmanagerPackage.NAMED_ELEMENT__CONSTRAINTS, NamedElement.class, msgs);
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
			case SemanticmanagerPackage.CONSTRAINT__KEY:
				return getKey();
			case SemanticmanagerPackage.CONSTRAINT__VALUE:
				return getValue();
			case SemanticmanagerPackage.CONSTRAINT__ELEMENTS:
				return getElements();
			case SemanticmanagerPackage.CONSTRAINT__INTERPRETER:
				if (resolve) return getInterpreter();
				return basicGetInterpreter();
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
			case SemanticmanagerPackage.CONSTRAINT__KEY:
				setKey((String)newValue);
				return;
			case SemanticmanagerPackage.CONSTRAINT__VALUE:
				setValue(newValue);
				return;
			case SemanticmanagerPackage.CONSTRAINT__ELEMENTS:
				setElements((NamedElement)newValue);
				return;
			case SemanticmanagerPackage.CONSTRAINT__INTERPRETER:
				setInterpreter((ConstraintInterpreter)newValue);
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
			case SemanticmanagerPackage.CONSTRAINT__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case SemanticmanagerPackage.CONSTRAINT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SemanticmanagerPackage.CONSTRAINT__ELEMENTS:
				setElements((NamedElement)null);
				return;
			case SemanticmanagerPackage.CONSTRAINT__INTERPRETER:
				setInterpreter((ConstraintInterpreter)null);
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
			case SemanticmanagerPackage.CONSTRAINT__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case SemanticmanagerPackage.CONSTRAINT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case SemanticmanagerPackage.CONSTRAINT__ELEMENTS:
				return getElements() != null;
			case SemanticmanagerPackage.CONSTRAINT__INTERPRETER:
				return interpreter != null;
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
		result.append(" (key: ");
		result.append(key);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ConstraintImpl
