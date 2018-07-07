/**
 */
package uam.extremo.core.impl;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;
import uam.extremo.core.Constraint;
import uam.extremo.core.ConstraintResult;
import uam.extremo.core.NamedElement;
import uam.extremo.core.Resource;
import uam.extremo.core.SemanticmanagerPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.ConstraintResultImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link uam.extremo.core.impl.ConstraintResultImpl#getContext <em>Context</em>}</li>
 *   <li>{@link uam.extremo.core.impl.ConstraintResultImpl#getUnsat <em>Unsat</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintResultImpl extends DefaultPersistentEObject implements ConstraintResult {
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
		return SemanticmanagerPackage.Literals.CONSTRAINT_RESULT;
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
		return (Constraint)eGet(SemanticmanagerPackage.Literals.CONSTRAINT_RESULT__CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraint(Constraint newConstraint) {
		eSet(SemanticmanagerPackage.Literals.CONSTRAINT_RESULT__CONSTRAINT, newConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getContext() {
		return (Resource)eGet(SemanticmanagerPackage.Literals.CONSTRAINT_RESULT__CONTEXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Resource newContext) {
		eSet(SemanticmanagerPackage.Literals.CONSTRAINT_RESULT__CONTEXT, newContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getUnsat() {
		return (EList<NamedElement>)eGet(SemanticmanagerPackage.Literals.CONSTRAINT_RESULT__UNSAT, true);
	}

} //ConstraintResultImpl
