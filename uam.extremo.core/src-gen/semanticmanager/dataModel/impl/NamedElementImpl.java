/**
 */
package semanticmanager.dataModel.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import semanticmanager.constraints.Constraint;

import semanticmanager.dataModel.DataModelPackage;
import semanticmanager.dataModel.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.dataModel.impl.NamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.NamedElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.NamedElementImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.NamedElementImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.NamedElementImpl#isDrawn <em>Drawn</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.NamedElementImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.NamedElementImpl#getDescribes <em>Describes</em>}</li>
 *   <li>{@link semanticmanager.dataModel.impl.NamedElementImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NamedElementImpl extends MinimalEObjectImpl.Container implements NamedElement {
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
		return DataModelPackage.Literals.NAMED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(DataModelPackage.Literals.NAMED_ELEMENT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(DataModelPackage.Literals.NAMED_ELEMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(DataModelPackage.Literals.NAMED_ELEMENT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(DataModelPackage.Literals.NAMED_ELEMENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWeight() {
		return (Integer)eGet(DataModelPackage.Literals.NAMED_ELEMENT__WEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(int newWeight) {
		eSet(DataModelPackage.Literals.NAMED_ELEMENT__WEIGHT, newWeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTrace() {
		return (Object)eGet(DataModelPackage.Literals.NAMED_ELEMENT__TRACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrace(Object newTrace) {
		eSet(DataModelPackage.Literals.NAMED_ELEMENT__TRACE, newTrace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDrawn() {
		return (Boolean)eGet(DataModelPackage.Literals.NAMED_ELEMENT__DRAWN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrawn(boolean newDrawn) {
		eSet(DataModelPackage.Literals.NAMED_ELEMENT__DRAWN, newDrawn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getDescriptor() {
		return (NamedElement)eGet(DataModelPackage.Literals.NAMED_ELEMENT__DESCRIPTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptor(NamedElement newDescriptor) {
		eSet(DataModelPackage.Literals.NAMED_ELEMENT__DESCRIPTOR, newDescriptor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getDescribes() {
		return (EList<NamedElement>)eGet(DataModelPackage.Literals.NAMED_ELEMENT__DESCRIBES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Constraint> getConstraints() {
		return (EList<Constraint>)eGet(DataModelPackage.Literals.NAMED_ELEMENT__CONSTRAINTS, true);
	}

} //NamedElementImpl
