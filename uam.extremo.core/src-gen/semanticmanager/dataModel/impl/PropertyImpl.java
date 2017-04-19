/**
 */
package semanticmanager.dataModel.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.dataModel.DataModelPackage;
import semanticmanager.dataModel.Property;
import semanticmanager.dataModel.SemanticNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.dataModel.impl.PropertyImpl#getSemanticNodeFrom <em>Semantic Node From</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.PropertyImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.PropertyImpl#getUpperBound <em>Upper Bound</em>}</li>
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
		return DataModelPackage.Literals.PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticNode getSemanticNodeFrom() {
		return (SemanticNode)eGet(DataModelPackage.Literals.PROPERTY__SEMANTIC_NODE_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticNodeFrom(SemanticNode newSemanticNodeFrom) {
		eSet(DataModelPackage.Literals.PROPERTY__SEMANTIC_NODE_FROM, newSemanticNodeFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLowerBound() {
		return (Integer)eGet(DataModelPackage.Literals.PROPERTY__LOWER_BOUND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(int newLowerBound) {
		eSet(DataModelPackage.Literals.PROPERTY__LOWER_BOUND, newLowerBound);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpperBound() {
		return (Integer)eGet(DataModelPackage.Literals.PROPERTY__UPPER_BOUND, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(int newUpperBound) {
		eSet(DataModelPackage.Literals.PROPERTY__UPPER_BOUND, newUpperBound);
	}

} //PropertyImpl
