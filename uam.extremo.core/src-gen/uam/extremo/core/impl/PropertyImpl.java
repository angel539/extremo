/**
 */
package uam.extremo.core.impl;

import org.eclipse.emf.ecore.EClass;

import uam.extremo.core.Property;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.PropertyImpl#getSemanticNodeFrom <em>Semantic Node From</em>}</li>
 *   <li>{@link uam.extremo.core.impl.PropertyImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link uam.extremo.core.impl.PropertyImpl#getUpperBound <em>Upper Bound</em>}</li>
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
		return (SemanticNode)eGet(SemanticmanagerPackage.Literals.PROPERTY__SEMANTIC_NODE_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticNodeFrom(SemanticNode newSemanticNodeFrom) {
		eSet(SemanticmanagerPackage.Literals.PROPERTY__SEMANTIC_NODE_FROM, newSemanticNodeFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLowerBound() {
		return (Integer)eGet(SemanticmanagerPackage.Literals.PROPERTY__LOWER_BOUND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(int newLowerBound) {
		eSet(SemanticmanagerPackage.Literals.PROPERTY__LOWER_BOUND, newLowerBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpperBound() {
		return (Integer)eGet(SemanticmanagerPackage.Literals.PROPERTY__UPPER_BOUND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(int newUpperBound) {
		eSet(SemanticmanagerPackage.Literals.PROPERTY__UPPER_BOUND, newUpperBound);
	}

} //PropertyImpl
