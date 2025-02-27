/**
 */
package semanticmanager.impl;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.Constraint;
import semanticmanager.ConstraintInterpreter;
import semanticmanager.ConstraintResult;
import semanticmanager.NamedElement;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Interpreter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.ConstraintInterpreterImpl#getId <em>Id</em>}</li>
 *   <li>{@link semanticmanager.impl.ConstraintInterpreterImpl#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.impl.ConstraintInterpreterImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link semanticmanager.impl.ConstraintInterpreterImpl#getEvals <em>Evals</em>}</li>
 *   <li>{@link semanticmanager.impl.ConstraintInterpreterImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConstraintInterpreterImpl extends DefaultPersistentEObject implements ConstraintInterpreter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintInterpreterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.CONSTRAINT_INTERPRETER;
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
	public String getId() {
		return (String)eGet(SemanticmanagerPackage.Literals.CONSTRAINT_INTERPRETER__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eSet(SemanticmanagerPackage.Literals.CONSTRAINT_INTERPRETER__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(SemanticmanagerPackage.Literals.CONSTRAINT_INTERPRETER__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SemanticmanagerPackage.Literals.CONSTRAINT_INTERPRETER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Constraint> getConstraints() {
		return (EList<Constraint>)eGet(SemanticmanagerPackage.Literals.CONSTRAINT_INTERPRETER__CONSTRAINTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConstraintResult> getEvals() {
		return (EList<ConstraintResult>)eGet(SemanticmanagerPackage.Literals.CONSTRAINT_INTERPRETER__EVALS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return (String)eGet(SemanticmanagerPackage.Literals.CONSTRAINT_INTERPRETER__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eSet(SemanticmanagerPackage.Literals.CONSTRAINT_INTERPRETER__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract boolean eval(Constraint constraint, NamedElement namedElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SemanticmanagerPackage.CONSTRAINT_INTERPRETER___EVAL__CONSTRAINT_NAMEDELEMENT:
				return eval((Constraint)arguments.get(0), (NamedElement)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConstraintInterpreterImpl
