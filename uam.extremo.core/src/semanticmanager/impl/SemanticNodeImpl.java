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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import semanticmanager.Property;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.SemanticNodeImpl#getSupers <em>Supers</em>}</li>
 *   <li>{@link semanticmanager.impl.SemanticNodeImpl#getSubs <em>Subs</em>}</li>
 *   <li>{@link semanticmanager.impl.SemanticNodeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link semanticmanager.impl.SemanticNodeImpl#getResourceFrom <em>Resource From</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticNodeImpl extends NamedElementImpl implements SemanticNode {
	/**
	 * The cached value of the '{@link #getSupers() <em>Supers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupers()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticNode> supers;

	/**
	 * The cached value of the '{@link #getSubs() <em>Subs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubs()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticNode> subs;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.SEMANTIC_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticNode> getSupers() {
		if (supers == null) {
			supers = new EObjectWithInverseResolvingEList.ManyInverse<SemanticNode>(SemanticNode.class, this, SemanticmanagerPackage.SEMANTIC_NODE__SUPERS, SemanticmanagerPackage.SEMANTIC_NODE__SUBS);
		}
		return supers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticNode> getSubs() {
		if (subs == null) {
			subs = new EObjectWithInverseResolvingEList.ManyInverse<SemanticNode>(SemanticNode.class, this, SemanticmanagerPackage.SEMANTIC_NODE__SUBS, SemanticmanagerPackage.SEMANTIC_NODE__SUPERS);
		}
		return subs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentWithInverseEList<Property>(Property.class, this, SemanticmanagerPackage.SEMANTIC_NODE__PROPERTIES, SemanticmanagerPackage.PROPERTY__SEMANTIC_NODE_FROM);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getResourceFrom() {
		if (eContainerFeatureID() != SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM) return null;
		return (Resource)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceFrom(Resource newResourceFrom, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResourceFrom, SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceFrom(Resource newResourceFrom) {
		if (newResourceFrom != eInternalContainer() || (eContainerFeatureID() != SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM && newResourceFrom != null)) {
			if (EcoreUtil.isAncestor(this, newResourceFrom))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResourceFrom != null)
				msgs = ((InternalEObject)newResourceFrom).eInverseAdd(this, SemanticmanagerPackage.RESOURCE__NODES, Resource.class, msgs);
			msgs = basicSetResourceFrom(newResourceFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM, newResourceFrom, newResourceFrom));
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
			case SemanticmanagerPackage.SEMANTIC_NODE__SUPERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupers()).basicAdd(otherEnd, msgs);
			case SemanticmanagerPackage.SEMANTIC_NODE__SUBS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubs()).basicAdd(otherEnd, msgs);
			case SemanticmanagerPackage.SEMANTIC_NODE__PROPERTIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProperties()).basicAdd(otherEnd, msgs);
			case SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResourceFrom((Resource)otherEnd, msgs);
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
			case SemanticmanagerPackage.SEMANTIC_NODE__SUPERS:
				return ((InternalEList<?>)getSupers()).basicRemove(otherEnd, msgs);
			case SemanticmanagerPackage.SEMANTIC_NODE__SUBS:
				return ((InternalEList<?>)getSubs()).basicRemove(otherEnd, msgs);
			case SemanticmanagerPackage.SEMANTIC_NODE__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM:
				return basicSetResourceFrom(null, msgs);
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
			case SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM:
				return eInternalContainer().eInverseRemove(this, SemanticmanagerPackage.RESOURCE__NODES, Resource.class, msgs);
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
			case SemanticmanagerPackage.SEMANTIC_NODE__SUPERS:
				return getSupers();
			case SemanticmanagerPackage.SEMANTIC_NODE__SUBS:
				return getSubs();
			case SemanticmanagerPackage.SEMANTIC_NODE__PROPERTIES:
				return getProperties();
			case SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM:
				return getResourceFrom();
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
			case SemanticmanagerPackage.SEMANTIC_NODE__SUPERS:
				getSupers().clear();
				getSupers().addAll((Collection<? extends SemanticNode>)newValue);
				return;
			case SemanticmanagerPackage.SEMANTIC_NODE__SUBS:
				getSubs().clear();
				getSubs().addAll((Collection<? extends SemanticNode>)newValue);
				return;
			case SemanticmanagerPackage.SEMANTIC_NODE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM:
				setResourceFrom((Resource)newValue);
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
			case SemanticmanagerPackage.SEMANTIC_NODE__SUPERS:
				getSupers().clear();
				return;
			case SemanticmanagerPackage.SEMANTIC_NODE__SUBS:
				getSubs().clear();
				return;
			case SemanticmanagerPackage.SEMANTIC_NODE__PROPERTIES:
				getProperties().clear();
				return;
			case SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM:
				setResourceFrom((Resource)null);
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
			case SemanticmanagerPackage.SEMANTIC_NODE__SUPERS:
				return supers != null && !supers.isEmpty();
			case SemanticmanagerPackage.SEMANTIC_NODE__SUBS:
				return subs != null && !subs.isEmpty();
			case SemanticmanagerPackage.SEMANTIC_NODE__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM:
				return getResourceFrom() != null;
		}
		return super.eIsSet(featureID);
	}

} //SemanticNodeImpl
