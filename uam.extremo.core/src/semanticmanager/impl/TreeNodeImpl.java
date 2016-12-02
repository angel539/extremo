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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.TreeNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.TreeNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link semanticmanager.impl.TreeNodeImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link semanticmanager.impl.TreeNodeImpl#getUsages <em>Usages</em>}</li>
 *   <li>{@link semanticmanager.impl.TreeNodeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link semanticmanager.impl.TreeNodeImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link semanticmanager.impl.TreeNodeImpl#getPoints <em>Points</em>}</li>
 *   <li>{@link semanticmanager.impl.TreeNodeImpl#getCountWordnet <em>Count Wordnet</em>}</li>
 *   <li>{@link semanticmanager.impl.TreeNodeImpl#getData <em>Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TreeNodeImpl extends MinimalEObjectImpl.Container implements TreeNode {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<TreeNode> children;

	/**
	 * The default value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFINITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected String definition = DEFINITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsages() <em>Usages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<String> usages;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final int KIND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected int kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #isValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALID_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isValid() <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValid()
	 * @generated
	 * @ordered
	 */
	protected boolean valid = VALID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPoints() <em>Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoints()
	 * @generated
	 * @ordered
	 */
	protected static final int POINTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPoints() <em>Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoints()
	 * @generated
	 * @ordered
	 */
	protected int points = POINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCountWordnet() <em>Count Wordnet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountWordnet()
	 * @generated
	 * @ordered
	 */
	protected static final int COUNT_WORDNET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCountWordnet() <em>Count Wordnet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountWordnet()
	 * @generated
	 * @ordered
	 */
	protected int countWordnet = COUNT_WORDNET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EList<String> data;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.TREE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TreeNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<TreeNode>(TreeNode.class, this, SemanticmanagerPackage.TREE_NODE__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(String newDefinition) {
		String oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.TREE_NODE__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getUsages() {
		if (usages == null) {
			usages = new EDataTypeUniqueEList<String>(String.class, this, SemanticmanagerPackage.TREE_NODE__USAGES);
		}
		return usages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(int newKind) {
		int oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.TREE_NODE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValid(boolean newValid) {
		boolean oldValid = valid;
		valid = newValid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.TREE_NODE__VALID, oldValid, valid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoints(int newPoints) {
		int oldPoints = points;
		points = newPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.TREE_NODE__POINTS, oldPoints, points));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCountWordnet() {
		return countWordnet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountWordnet(int newCountWordnet) {
		int oldCountWordnet = countWordnet;
		countWordnet = newCountWordnet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.TREE_NODE__COUNT_WORDNET, oldCountWordnet, countWordnet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getData() {
		if (data == null) {
			data = new EDataTypeUniqueEList<String>(String.class, this, SemanticmanagerPackage.TREE_NODE__DATA);
		}
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticmanagerPackage.TREE_NODE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case SemanticmanagerPackage.TREE_NODE__CHILDREN:
				return getChildren();
			case SemanticmanagerPackage.TREE_NODE__DEFINITION:
				return getDefinition();
			case SemanticmanagerPackage.TREE_NODE__USAGES:
				return getUsages();
			case SemanticmanagerPackage.TREE_NODE__KIND:
				return getKind();
			case SemanticmanagerPackage.TREE_NODE__VALID:
				return isValid();
			case SemanticmanagerPackage.TREE_NODE__POINTS:
				return getPoints();
			case SemanticmanagerPackage.TREE_NODE__COUNT_WORDNET:
				return getCountWordnet();
			case SemanticmanagerPackage.TREE_NODE__DATA:
				return getData();
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
			case SemanticmanagerPackage.TREE_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends TreeNode>)newValue);
				return;
			case SemanticmanagerPackage.TREE_NODE__DEFINITION:
				setDefinition((String)newValue);
				return;
			case SemanticmanagerPackage.TREE_NODE__USAGES:
				getUsages().clear();
				getUsages().addAll((Collection<? extends String>)newValue);
				return;
			case SemanticmanagerPackage.TREE_NODE__KIND:
				setKind((Integer)newValue);
				return;
			case SemanticmanagerPackage.TREE_NODE__VALID:
				setValid((Boolean)newValue);
				return;
			case SemanticmanagerPackage.TREE_NODE__POINTS:
				setPoints((Integer)newValue);
				return;
			case SemanticmanagerPackage.TREE_NODE__COUNT_WORDNET:
				setCountWordnet((Integer)newValue);
				return;
			case SemanticmanagerPackage.TREE_NODE__DATA:
				getData().clear();
				getData().addAll((Collection<? extends String>)newValue);
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
			case SemanticmanagerPackage.TREE_NODE__CHILDREN:
				getChildren().clear();
				return;
			case SemanticmanagerPackage.TREE_NODE__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case SemanticmanagerPackage.TREE_NODE__USAGES:
				getUsages().clear();
				return;
			case SemanticmanagerPackage.TREE_NODE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case SemanticmanagerPackage.TREE_NODE__VALID:
				setValid(VALID_EDEFAULT);
				return;
			case SemanticmanagerPackage.TREE_NODE__POINTS:
				setPoints(POINTS_EDEFAULT);
				return;
			case SemanticmanagerPackage.TREE_NODE__COUNT_WORDNET:
				setCountWordnet(COUNT_WORDNET_EDEFAULT);
				return;
			case SemanticmanagerPackage.TREE_NODE__DATA:
				getData().clear();
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
			case SemanticmanagerPackage.TREE_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case SemanticmanagerPackage.TREE_NODE__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case SemanticmanagerPackage.TREE_NODE__USAGES:
				return usages != null && !usages.isEmpty();
			case SemanticmanagerPackage.TREE_NODE__KIND:
				return kind != KIND_EDEFAULT;
			case SemanticmanagerPackage.TREE_NODE__VALID:
				return valid != VALID_EDEFAULT;
			case SemanticmanagerPackage.TREE_NODE__POINTS:
				return points != POINTS_EDEFAULT;
			case SemanticmanagerPackage.TREE_NODE__COUNT_WORDNET:
				return countWordnet != COUNT_WORDNET_EDEFAULT;
			case SemanticmanagerPackage.TREE_NODE__DATA:
				return data != null && !data.isEmpty();
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
		result.append(" (definition: ");
		result.append(definition);
		result.append(", usages: ");
		result.append(usages);
		result.append(", kind: ");
		result.append(kind);
		result.append(", valid: ");
		result.append(valid);
		result.append(", points: ");
		result.append(points);
		result.append(", countWordnet: ");
		result.append(countWordnet);
		result.append(", data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} //TreeNodeImpl
