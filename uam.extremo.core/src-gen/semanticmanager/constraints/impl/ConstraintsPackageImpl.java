/**
 */
package semanticmanager.constraints.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import semanticmanager.SemanticmanagerPackage;

import semanticmanager.constraints.Constraint;
import semanticmanager.constraints.ConstraintInterpreter;
import semanticmanager.constraints.ConstraintResult;
import semanticmanager.constraints.ConstraintsFactory;
import semanticmanager.constraints.ConstraintsPackage;

import semanticmanager.dataModel.DataModelPackage;

import semanticmanager.dataModel.impl.DataModelPackageImpl;

import semanticmanager.impl.SemanticmanagerPackageImpl;

import semanticmanager.queries.QueriesPackage;

import semanticmanager.queries.impl.QueriesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstraintsPackageImpl extends EPackageImpl implements ConstraintsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintInterpreterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintResultEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see semanticmanager.constraints.ConstraintsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConstraintsPackageImpl() {
		super(eNS_URI, ConstraintsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ConstraintsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConstraintsPackage init() {
		if (isInited) return (ConstraintsPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI);

		// Obtain or create and register package
		ConstraintsPackageImpl theConstraintsPackage = (ConstraintsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConstraintsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConstraintsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SemanticmanagerPackageImpl theSemanticmanagerPackage = (SemanticmanagerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticmanagerPackage.eNS_URI) instanceof SemanticmanagerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticmanagerPackage.eNS_URI) : SemanticmanagerPackage.eINSTANCE);
		QueriesPackageImpl theQueriesPackage = (QueriesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QueriesPackage.eNS_URI) instanceof QueriesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QueriesPackage.eNS_URI) : QueriesPackage.eINSTANCE);
		DataModelPackageImpl theDataModelPackage = (DataModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataModelPackage.eNS_URI) instanceof DataModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataModelPackage.eNS_URI) : DataModelPackage.eINSTANCE);

		// Create package meta-data objects
		theConstraintsPackage.createPackageContents();
		theSemanticmanagerPackage.createPackageContents();
		theQueriesPackage.createPackageContents();
		theDataModelPackage.createPackageContents();

		// Initialize created meta-data
		theConstraintsPackage.initializePackageContents();
		theSemanticmanagerPackage.initializePackageContents();
		theQueriesPackage.initializePackageContents();
		theDataModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConstraintsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConstraintsPackage.eNS_URI, theConstraintsPackage);
		return theConstraintsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Type() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Name() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Body() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_AppliedTo() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Evaluations() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintInterpreter() {
		return constraintInterpreterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintInterpreter_Id() {
		return (EAttribute)constraintInterpreterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintInterpreter_Name() {
		return (EAttribute)constraintInterpreterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintInterpreter_Constraints() {
		return (EReference)constraintInterpreterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintInterpreter_Evals() {
		return (EReference)constraintInterpreterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConstraintInterpreter__Eval__Constraint_NamedElement() {
		return constraintInterpreterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintResult() {
		return constraintResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintResult_Constraint() {
		return (EReference)constraintResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintResult_Context() {
		return (EReference)constraintResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintResult_Unsat() {
		return (EReference)constraintResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintsFactory getConstraintsFactory() {
		return (ConstraintsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		constraintEClass = createEClass(CONSTRAINT);
		createEAttribute(constraintEClass, CONSTRAINT__TYPE);
		createEAttribute(constraintEClass, CONSTRAINT__NAME);
		createEAttribute(constraintEClass, CONSTRAINT__BODY);
		createEReference(constraintEClass, CONSTRAINT__APPLIED_TO);
		createEReference(constraintEClass, CONSTRAINT__EVALUATIONS);

		constraintInterpreterEClass = createEClass(CONSTRAINT_INTERPRETER);
		createEAttribute(constraintInterpreterEClass, CONSTRAINT_INTERPRETER__ID);
		createEAttribute(constraintInterpreterEClass, CONSTRAINT_INTERPRETER__NAME);
		createEReference(constraintInterpreterEClass, CONSTRAINT_INTERPRETER__CONSTRAINTS);
		createEReference(constraintInterpreterEClass, CONSTRAINT_INTERPRETER__EVALS);
		createEOperation(constraintInterpreterEClass, CONSTRAINT_INTERPRETER___EVAL__CONSTRAINT_NAMEDELEMENT);

		constraintResultEClass = createEClass(CONSTRAINT_RESULT);
		createEReference(constraintResultEClass, CONSTRAINT_RESULT__CONSTRAINT);
		createEReference(constraintResultEClass, CONSTRAINT_RESULT__CONTEXT);
		createEReference(constraintResultEClass, CONSTRAINT_RESULT__UNSAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DataModelPackage theDataModelPackage = (DataModelPackage)EPackage.Registry.INSTANCE.getEPackage(DataModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraint_Type(), ecorePackage.getEString(), "type", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraint_Name(), ecorePackage.getEString(), "name", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraint_Body(), ecorePackage.getEString(), "body", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_AppliedTo(), theDataModelPackage.getNamedElement(), theDataModelPackage.getNamedElement_Constraints(), "appliedTo", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Evaluations(), this.getConstraintResult(), this.getConstraintResult_Constraint(), "evaluations", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintInterpreterEClass, ConstraintInterpreter.class, "ConstraintInterpreter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraintInterpreter_Id(), ecorePackage.getEString(), "id", null, 0, 1, ConstraintInterpreter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraintInterpreter_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConstraintInterpreter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintInterpreter_Constraints(), this.getConstraint(), null, "constraints", null, 0, -1, ConstraintInterpreter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintInterpreter_Evals(), this.getConstraintResult(), null, "evals", null, 0, -1, ConstraintInterpreter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getConstraintInterpreter__Eval__Constraint_NamedElement(), ecorePackage.getEBoolean(), "eval", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConstraint(), "constraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataModelPackage.getNamedElement(), "namedElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(constraintResultEClass, ConstraintResult.class, "ConstraintResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintResult_Constraint(), this.getConstraint(), this.getConstraint_Evaluations(), "constraint", null, 0, 1, ConstraintResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintResult_Context(), theDataModelPackage.getResource(), null, "context", null, 0, 1, ConstraintResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintResult_Unsat(), theDataModelPackage.getNamedElement(), null, "unsat", null, 0, -1, ConstraintResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //ConstraintsPackageImpl
