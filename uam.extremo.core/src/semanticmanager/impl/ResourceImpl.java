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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.ResourceImpl#isActive <em>Active</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#isAlive <em>Alive</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getAssistant <em>Assistant</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getDescribes <em>Describes</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getRepositoryFrom <em>Repository From</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceImpl extends NamedElementImpl implements Resource {
	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isAlive() <em>Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAlive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAlive() <em>Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAlive()
	 * @generated
	 * @ordered
	 */
	protected boolean alive = ALIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAssistant() <em>Assistant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssistant()
	 * @generated
	 * @ordered
	 */
	protected static final String ASSISTANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAssistant() <em>Assistant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssistant()
	 * @generated
	 * @ordered
	 */
	protected String assistant = ASSISTANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticNode> nodes;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescribes() <em>Describes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescribes()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> describes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.RESOURCE__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlive(boolean newAlive) {
		boolean oldAlive = alive;
		alive = newAlive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.RESOURCE__ALIVE, oldAlive, alive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAssistant() {
		return assistant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssistant(String newAssistant) {
		String oldAssistant = assistant;
		assistant = newAssistant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.RESOURCE__ASSISTANT, oldAssistant, assistant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<SemanticNode>(SemanticNode.class, this, SemanticmanagerPackage.RESOURCE__NODES, SemanticmanagerPackage.SEMANTIC_NODE__RESOURCE_FROM);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.RESOURCE__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getDescriptor() {
		if (eContainerFeatureID() != SemanticmanagerPackage.RESOURCE__DESCRIPTOR) return null;
		return (Resource)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptor(Resource newDescriptor, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDescriptor, SemanticmanagerPackage.RESOURCE__DESCRIPTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptor(Resource newDescriptor) {
		if (newDescriptor != eInternalContainer() || (eContainerFeatureID() != SemanticmanagerPackage.RESOURCE__DESCRIPTOR && newDescriptor != null)) {
			if (EcoreUtil.isAncestor(this, newDescriptor))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDescriptor != null)
				msgs = ((InternalEObject)newDescriptor).eInverseAdd(this, SemanticmanagerPackage.RESOURCE__DESCRIBES, Resource.class, msgs);
			msgs = basicSetDescriptor(newDescriptor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.RESOURCE__DESCRIPTOR, newDescriptor, newDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getDescribes() {
		if (describes == null) {
			describes = new EObjectContainmentWithInverseEList<Resource>(Resource.class, this, SemanticmanagerPackage.RESOURCE__DESCRIBES, SemanticmanagerPackage.RESOURCE__DESCRIPTOR);
		}
		return describes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepositoryFrom() {
		if (eContainerFeatureID() != SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM) return null;
		return (Repository)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepositoryFrom(Repository newRepositoryFrom, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepositoryFrom, SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryFrom(Repository newRepositoryFrom) {
		if (newRepositoryFrom != eInternalContainer() || (eContainerFeatureID() != SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM && newRepositoryFrom != null)) {
			if (EcoreUtil.isAncestor(this, newRepositoryFrom))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepositoryFrom != null)
				msgs = ((InternalEObject)newRepositoryFrom).eInverseAdd(this, SemanticmanagerPackage.REPOSITORY__RESOURCES, Repository.class, msgs);
			msgs = basicSetRepositoryFrom(newRepositoryFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM, newRepositoryFrom, newRepositoryFrom));
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
			case SemanticmanagerPackage.RESOURCE__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
			case SemanticmanagerPackage.RESOURCE__DESCRIPTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDescriptor((Resource)otherEnd, msgs);
			case SemanticmanagerPackage.RESOURCE__DESCRIBES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDescribes()).basicAdd(otherEnd, msgs);
			case SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepositoryFrom((Repository)otherEnd, msgs);
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
			case SemanticmanagerPackage.RESOURCE__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case SemanticmanagerPackage.RESOURCE__DESCRIPTOR:
				return basicSetDescriptor(null, msgs);
			case SemanticmanagerPackage.RESOURCE__DESCRIBES:
				return ((InternalEList<?>)getDescribes()).basicRemove(otherEnd, msgs);
			case SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM:
				return basicSetRepositoryFrom(null, msgs);
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
			case SemanticmanagerPackage.RESOURCE__DESCRIPTOR:
				return eInternalContainer().eInverseRemove(this, SemanticmanagerPackage.RESOURCE__DESCRIBES, Resource.class, msgs);
			case SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM:
				return eInternalContainer().eInverseRemove(this, SemanticmanagerPackage.REPOSITORY__RESOURCES, Repository.class, msgs);
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
			case SemanticmanagerPackage.RESOURCE__ACTIVE:
				return isActive();
			case SemanticmanagerPackage.RESOURCE__ALIVE:
				return isAlive();
			case SemanticmanagerPackage.RESOURCE__ASSISTANT:
				return getAssistant();
			case SemanticmanagerPackage.RESOURCE__NODES:
				return getNodes();
			case SemanticmanagerPackage.RESOURCE__URI:
				return getUri();
			case SemanticmanagerPackage.RESOURCE__DESCRIPTOR:
				return getDescriptor();
			case SemanticmanagerPackage.RESOURCE__DESCRIBES:
				return getDescribes();
			case SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM:
				return getRepositoryFrom();
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
			case SemanticmanagerPackage.RESOURCE__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case SemanticmanagerPackage.RESOURCE__ALIVE:
				setAlive((Boolean)newValue);
				return;
			case SemanticmanagerPackage.RESOURCE__ASSISTANT:
				setAssistant((String)newValue);
				return;
			case SemanticmanagerPackage.RESOURCE__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends SemanticNode>)newValue);
				return;
			case SemanticmanagerPackage.RESOURCE__URI:
				setUri((String)newValue);
				return;
			case SemanticmanagerPackage.RESOURCE__DESCRIPTOR:
				setDescriptor((Resource)newValue);
				return;
			case SemanticmanagerPackage.RESOURCE__DESCRIBES:
				getDescribes().clear();
				getDescribes().addAll((Collection<? extends Resource>)newValue);
				return;
			case SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM:
				setRepositoryFrom((Repository)newValue);
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
			case SemanticmanagerPackage.RESOURCE__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case SemanticmanagerPackage.RESOURCE__ALIVE:
				setAlive(ALIVE_EDEFAULT);
				return;
			case SemanticmanagerPackage.RESOURCE__ASSISTANT:
				setAssistant(ASSISTANT_EDEFAULT);
				return;
			case SemanticmanagerPackage.RESOURCE__NODES:
				getNodes().clear();
				return;
			case SemanticmanagerPackage.RESOURCE__URI:
				setUri(URI_EDEFAULT);
				return;
			case SemanticmanagerPackage.RESOURCE__DESCRIPTOR:
				setDescriptor((Resource)null);
				return;
			case SemanticmanagerPackage.RESOURCE__DESCRIBES:
				getDescribes().clear();
				return;
			case SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM:
				setRepositoryFrom((Repository)null);
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
			case SemanticmanagerPackage.RESOURCE__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case SemanticmanagerPackage.RESOURCE__ALIVE:
				return alive != ALIVE_EDEFAULT;
			case SemanticmanagerPackage.RESOURCE__ASSISTANT:
				return ASSISTANT_EDEFAULT == null ? assistant != null : !ASSISTANT_EDEFAULT.equals(assistant);
			case SemanticmanagerPackage.RESOURCE__NODES:
				return nodes != null && !nodes.isEmpty();
			case SemanticmanagerPackage.RESOURCE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case SemanticmanagerPackage.RESOURCE__DESCRIPTOR:
				return getDescriptor() != null;
			case SemanticmanagerPackage.RESOURCE__DESCRIBES:
				return describes != null && !describes.isEmpty();
			case SemanticmanagerPackage.RESOURCE__REPOSITORY_FROM:
				return getRepositoryFrom() != null;
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
		result.append(" (active: ");
		result.append(active);
		result.append(", alive: ");
		result.append(alive);
		result.append(", assistant: ");
		result.append(assistant);
		result.append(", uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //ResourceImpl
