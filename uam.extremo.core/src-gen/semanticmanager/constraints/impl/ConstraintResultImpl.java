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
import semanticmanager.dataModel.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.constraints.impl.ConstraintResultImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link semanticmanager.constraints.impl.ConstraintResultImpl#getContext <em>Context</em>}</li>
 *   <li>{@link semanticmanager.constraints.impl.ConstraintResultImpl#getUnsat <em>Unsat</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintResultImpl extends MinimalEObjectImpl.Container implements ConstraintResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConstraintsPackage.Literals.CONSTRAINT_RESULT;
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
	public Constraint getConstraint() {
		return (Constraint)eGet(ConstraintsPackage.Literals.CONSTRAINT_RESULT__CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraint(Constraint newConstraint) {
		eSet(ConstraintsPackage.Literals.CONSTRAINT_RESULT__CONSTRAINT, newConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getContext() {
		return (Resource)eGet(ConstraintsPackage.Literals.CONSTRAINT_RESULT__CONTEXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Resource newContext) {
		eSet(ConstraintsPackage.Literals.CONSTRAINT_RESULT__CONTEXT, newContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getUnsat() {
		return (EList<NamedElement>)eGet(ConstraintsPackage.Literals.CONSTRAINT_RESULT__UNSAT, true);
	}

} //ConstraintResultImpl
