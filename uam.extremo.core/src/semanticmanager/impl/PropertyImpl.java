/**
 */
package semanticmanager.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import semanticmanager.Property;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.PropertyImpl#getSemanticNodeFrom <em>Semantic Node From</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PropertyImpl extends NamedElementImpl implements Property {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticNode getSemanticNodeFrom() {
		if (eContainerFeatureID() != SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM) return null;
		return (SemanticNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSemanticNodeFrom(SemanticNode newSemanticNodeFrom, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSemanticNodeFrom, SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticNodeFrom(SemanticNode newSemanticNodeFrom) {
		if (newSemanticNodeFrom != eInternalContainer() || (eContainerFeatureID() != SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM && newSemanticNodeFrom != null)) {
			if (EcoreUtil.isAncestor(this, newSemanticNodeFrom))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSemanticNodeFrom != null)
				msgs = ((InternalEObject)newSemanticNodeFrom).eInverseAdd(this, SemanticmanagerPackage.SEMANTIC_NODE__PROPERTIES, SemanticNode.class, msgs);
			msgs = basicSetSemanticNodeFrom(newSemanticNodeFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM, newSemanticNodeFrom, newSemanticNodeFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSemanticNodeFrom((SemanticNode)otherEnd, msgs);
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
			case SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM:
				return basicSetSemanticNodeFrom(null, msgs);
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
			case SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM:
				return eInternalContainer().eInverseRemove(this, SemanticmanagerPackage.SEMANTIC_NODE__PROPERTIES, SemanticNode.class, msgs);
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
			case SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM:
				return getSemanticNodeFrom();
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
			case SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM:
				setSemanticNodeFrom((SemanticNode)newValue);
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
			case SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM:
				setSemanticNodeFrom((SemanticNode)null);
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
			case SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM:
				return getSemanticNodeFrom() != null;
		}
		return super.eIsSet(featureID);
	}

} //PropertyImpl
