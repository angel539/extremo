/**
 */
package semanticmanager.constraints;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see semanticmanager.constraints.ConstraintsFactory
 * @model kind="package"
 * @generated
 */
public interface ConstraintsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "constraints";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "constraints";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "constraints";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConstraintsPackage eINSTANCE = semanticmanager.constraints.impl.ConstraintsPackageImpl.init();

	/**
	 * The meta object id for the '{@link semanticmanager.constraints.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.constraints.impl.ConstraintImpl
	 * @see semanticmanager.constraints.impl.ConstraintsPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__BODY = 2;

	/**
	 * The feature id for the '<em><b>Applied To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__APPLIED_TO = 3;

	/**
	 * The feature id for the '<em><b>Evaluations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__EVALUATIONS = 4;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.constraints.impl.ConstraintInterpreterImpl <em>Constraint Interpreter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.constraints.impl.ConstraintInterpreterImpl
	 * @see semanticmanager.constraints.impl.ConstraintsPackageImpl#getConstraintInterpreter()
	 * @generated
	 */
	int CONSTRAINT_INTERPRETER = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INTERPRETER__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INTERPRETER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INTERPRETER__CONSTRAINTS = 2;

	/**
	 * The feature id for the '<em><b>Evals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INTERPRETER__EVALS = 3;

	/**
	 * The number of structural features of the '<em>Constraint Interpreter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INTERPRETER_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Eval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INTERPRETER___EVAL__CONSTRAINT_NAMEDELEMENT = 0;

	/**
	 * The number of operations of the '<em>Constraint Interpreter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INTERPRETER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link semanticmanager.constraints.impl.ConstraintResultImpl <em>Constraint Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.constraints.impl.ConstraintResultImpl
	 * @see semanticmanager.constraints.impl.ConstraintsPackageImpl#getConstraintResult()
	 * @generated
	 */
	int CONSTRAINT_RESULT = 2;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_RESULT__CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_RESULT__CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Unsat</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_RESULT__UNSAT = 2;

	/**
	 * The number of structural features of the '<em>Constraint Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_RESULT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Constraint Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_RESULT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link semanticmanager.constraints.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see semanticmanager.constraints.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.constraints.Constraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see semanticmanager.constraints.Constraint#getType()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Type();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.constraints.Constraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.constraints.Constraint#getName()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Name();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.constraints.Constraint#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see semanticmanager.constraints.Constraint#getBody()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Body();

	/**
	 * Returns the meta object for the container reference '{@link semanticmanager.constraints.Constraint#getAppliedTo <em>Applied To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Applied To</em>'.
	 * @see semanticmanager.constraints.Constraint#getAppliedTo()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_AppliedTo();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.constraints.Constraint#getEvaluations <em>Evaluations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Evaluations</em>'.
	 * @see semanticmanager.constraints.Constraint#getEvaluations()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Evaluations();

	/**
	 * Returns the meta object for class '{@link semanticmanager.constraints.ConstraintInterpreter <em>Constraint Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Interpreter</em>'.
	 * @see semanticmanager.constraints.ConstraintInterpreter
	 * @generated
	 */
	EClass getConstraintInterpreter();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.constraints.ConstraintInterpreter#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.constraints.ConstraintInterpreter#getId()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EAttribute getConstraintInterpreter_Id();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.constraints.ConstraintInterpreter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.constraints.ConstraintInterpreter#getName()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EAttribute getConstraintInterpreter_Name();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.constraints.ConstraintInterpreter#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see semanticmanager.constraints.ConstraintInterpreter#getConstraints()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EReference getConstraintInterpreter_Constraints();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.constraints.ConstraintInterpreter#getEvals <em>Evals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Evals</em>'.
	 * @see semanticmanager.constraints.ConstraintInterpreter#getEvals()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EReference getConstraintInterpreter_Evals();

	/**
	 * Returns the meta object for the '{@link semanticmanager.constraints.ConstraintInterpreter#eval(semanticmanager.constraints.Constraint, semanticmanager.dataModel.NamedElement) <em>Eval</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Eval</em>' operation.
	 * @see semanticmanager.constraints.ConstraintInterpreter#eval(semanticmanager.constraints.Constraint, semanticmanager.dataModel.NamedElement)
	 * @generated
	 */
	EOperation getConstraintInterpreter__Eval__Constraint_NamedElement();

	/**
	 * Returns the meta object for class '{@link semanticmanager.constraints.ConstraintResult <em>Constraint Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Result</em>'.
	 * @see semanticmanager.constraints.ConstraintResult
	 * @generated
	 */
	EClass getConstraintResult();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.constraints.ConstraintResult#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constraint</em>'.
	 * @see semanticmanager.constraints.ConstraintResult#getConstraint()
	 * @see #getConstraintResult()
	 * @generated
	 */
	EReference getConstraintResult_Constraint();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.constraints.ConstraintResult#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see semanticmanager.constraints.ConstraintResult#getContext()
	 * @see #getConstraintResult()
	 * @generated
	 */
	EReference getConstraintResult_Context();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.constraints.ConstraintResult#getUnsat <em>Unsat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unsat</em>'.
	 * @see semanticmanager.constraints.ConstraintResult#getUnsat()
	 * @see #getConstraintResult()
	 * @generated
	 */
	EReference getConstraintResult_Unsat();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConstraintsFactory getConstraintsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link semanticmanager.constraints.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.constraints.impl.ConstraintImpl
		 * @see semanticmanager.constraints.impl.ConstraintsPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__TYPE = eINSTANCE.getConstraint_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__NAME = eINSTANCE.getConstraint_Name();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__BODY = eINSTANCE.getConstraint_Body();

		/**
		 * The meta object literal for the '<em><b>Applied To</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__APPLIED_TO = eINSTANCE.getConstraint_AppliedTo();

		/**
		 * The meta object literal for the '<em><b>Evaluations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__EVALUATIONS = eINSTANCE.getConstraint_Evaluations();

		/**
		 * The meta object literal for the '{@link semanticmanager.constraints.impl.ConstraintInterpreterImpl <em>Constraint Interpreter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.constraints.impl.ConstraintInterpreterImpl
		 * @see semanticmanager.constraints.impl.ConstraintsPackageImpl#getConstraintInterpreter()
		 * @generated
		 */
		EClass CONSTRAINT_INTERPRETER = eINSTANCE.getConstraintInterpreter();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_INTERPRETER__ID = eINSTANCE.getConstraintInterpreter_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_INTERPRETER__NAME = eINSTANCE.getConstraintInterpreter_Name();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_INTERPRETER__CONSTRAINTS = eINSTANCE.getConstraintInterpreter_Constraints();

		/**
		 * The meta object literal for the '<em><b>Evals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_INTERPRETER__EVALS = eINSTANCE.getConstraintInterpreter_Evals();

		/**
		 * The meta object literal for the '<em><b>Eval</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONSTRAINT_INTERPRETER___EVAL__CONSTRAINT_NAMEDELEMENT = eINSTANCE.getConstraintInterpreter__Eval__Constraint_NamedElement();

		/**
		 * The meta object literal for the '{@link semanticmanager.constraints.impl.ConstraintResultImpl <em>Constraint Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.constraints.impl.ConstraintResultImpl
		 * @see semanticmanager.constraints.impl.ConstraintsPackageImpl#getConstraintResult()
		 * @generated
		 */
		EClass CONSTRAINT_RESULT = eINSTANCE.getConstraintResult();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_RESULT__CONSTRAINT = eINSTANCE.getConstraintResult_Constraint();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_RESULT__CONTEXT = eINSTANCE.getConstraintResult_Context();

		/**
		 * The meta object literal for the '<em><b>Unsat</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_RESULT__UNSAT = eINSTANCE.getConstraintResult_Unsat();

	}

} //ConstraintsPackage
