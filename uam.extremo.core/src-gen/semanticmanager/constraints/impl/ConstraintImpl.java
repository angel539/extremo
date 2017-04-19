/**
 */
package semanticmanager.constraints.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import semanticmanager.constraints.Constraint;
import semanticmanager.constraints.ConstraintResult;
import semanticmanager.constraints.ConstraintsPackage;

import semanticmanager.dataModel.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.constraints.impl.ConstraintImpl#getType <em>Type</em>}</li>
 *   <li>{@link semanticmanager.constraints.impl.ConstraintImpl#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.constraints.impl.ConstraintImpl#getBody <em>Body</em>}</li>
 *   <li>{@link semanticmanager.constraints.impl.ConstraintImpl#getAppliedTo <em>Applied To</em>}</li>
 *   <li>{@link semanticmanager.constraints.impl.ConstraintImpl#getEvaluations <em>Evaluations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintImpl extends MinimalEObjectImpl.Container implements Constraint {
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
		return ConstraintsPackage.Literals.CONSTRAINT;
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
	public String getType() {
		return (String)eGet(ConstraintsPackage.Literals.CONSTRAINT__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eSet(ConstraintsPackage.Literals.CONSTRAINT__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(ConstraintsPackage.Literals.CONSTRAINT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(ConstraintsPackage.Literals.CONSTRAINT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBody() {
		return (String)eGet(ConstraintsPackage.Literals.CONSTRAINT__BODY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(String newBody) {
		eSet(ConstraintsPackage.Literals.CONSTRAINT__BODY, newBody);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getAppliedTo() {
		return (NamedElement)eGet(ConstraintsPackage.Literals.CONSTRAINT__APPLIED_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedTo(NamedElement newAppliedTo) {
		eSet(ConstraintsPackage.Literals.CONSTRAINT__APPLIED_TO, newAppliedTo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConstraintResult> getEvaluations() {
		return (EList<ConstraintResult>)eGet(ConstraintsPackage.Literals.CONSTRAINT__EVALUATIONS, true);
	}

} //ConstraintImpl
