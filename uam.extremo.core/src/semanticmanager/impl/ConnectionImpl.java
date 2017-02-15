/**
 */
package semanticmanager.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import semanticmanager.Connection;
import semanticmanager.ConnectionType;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.SimpleSearchConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.ConnectionImpl#getType <em>Type</em>}</li>
 *   <li>{@link semanticmanager.impl.ConnectionImpl#getSearchConfiguration <em>Search Configuration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionImpl extends MinimalEObjectImpl.Container implements Connection {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ConnectionType TYPE_EDEFAULT = ConnectionType.OR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ConnectionType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSearchConfiguration() <em>Search Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchConfiguration()
	 * @generated
	 * @ordered
	 */
	protected SimpleSearchConfiguration searchConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ConnectionType newType) {
		ConnectionType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.CONNECTION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleSearchConfiguration getSearchConfiguration() {
		if (searchConfiguration != null && searchConfiguration.eIsProxy()) {
			InternalEObject oldSearchConfiguration = (InternalEObject)searchConfiguration;
			searchConfiguration = (SimpleSearchConfiguration)eResolveProxy(oldSearchConfiguration);
			if (searchConfiguration != oldSearchConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SemanticmanagerPackage.CONNECTION__SEARCH_CONFIGURATION, oldSearchConfiguration, searchConfiguration));
			}
		}
		return searchConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleSearchConfiguration basicGetSearchConfiguration() {
		return searchConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearchConfiguration(SimpleSearchConfiguration newSearchConfiguration) {
		SimpleSearchConfiguration oldSearchConfiguration = searchConfiguration;
		searchConfiguration = newSearchConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.CONNECTION__SEARCH_CONFIGURATION, oldSearchConfiguration, searchConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SemanticmanagerPackage.CONNECTION__TYPE:
				return getType();
			case SemanticmanagerPackage.CONNECTION__SEARCH_CONFIGURATION:
				if (resolve) return getSearchConfiguration();
				return basicGetSearchConfiguration();
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
			case SemanticmanagerPackage.CONNECTION__TYPE:
				setType((ConnectionType)newValue);
				return;
			case SemanticmanagerPackage.CONNECTION__SEARCH_CONFIGURATION:
				setSearchConfiguration((SimpleSearchConfiguration)newValue);
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
			case SemanticmanagerPackage.CONNECTION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SemanticmanagerPackage.CONNECTION__SEARCH_CONFIGURATION:
				setSearchConfiguration((SimpleSearchConfiguration)null);
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
			case SemanticmanagerPackage.CONNECTION__TYPE:
				return type != TYPE_EDEFAULT;
			case SemanticmanagerPackage.CONNECTION__SEARCH_CONFIGURATION:
				return searchConfiguration != null;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ConnectionImpl
