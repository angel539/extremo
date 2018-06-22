/**
 */
package draggablesemanticmanager.impl;

import draggablesemanticmanager.DraggableDataProperty;
import draggablesemanticmanager.DraggableNamedElement;
import draggablesemanticmanager.DraggableNamedElementSet;
import draggablesemanticmanager.DraggableObjectProperty;
import draggablesemanticmanager.DraggableProperty;
import draggablesemanticmanager.DraggableSemanticNode;
import draggablesemanticmanager.DraggablesemanticmanagerFactory;
import draggablesemanticmanager.DraggablesemanticmanagerPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DraggablesemanticmanagerPackageImpl extends EPackageImpl implements DraggablesemanticmanagerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass draggableNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass draggablePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass draggableObjectPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass draggableDataPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass draggableSemanticNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass draggableNamedElementSetEClass = null;

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
	 * @see draggablesemanticmanager.DraggablesemanticmanagerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DraggablesemanticmanagerPackageImpl() {
		super(eNS_URI, DraggablesemanticmanagerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DraggablesemanticmanagerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DraggablesemanticmanagerPackage init() {
		if (isInited) return (DraggablesemanticmanagerPackage)EPackage.Registry.INSTANCE.getEPackage(DraggablesemanticmanagerPackage.eNS_URI);

		// Obtain or create and register package
		DraggablesemanticmanagerPackageImpl theDraggablesemanticmanagerPackage = (DraggablesemanticmanagerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DraggablesemanticmanagerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DraggablesemanticmanagerPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDraggablesemanticmanagerPackage.createPackageContents();

		// Initialize created meta-data
		theDraggablesemanticmanagerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDraggablesemanticmanagerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DraggablesemanticmanagerPackage.eNS_URI, theDraggablesemanticmanagerPackage);
		return theDraggablesemanticmanagerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDraggableNamedElement() {
		return draggableNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDraggableNamedElement_Name() {
		return (EAttribute)draggableNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDraggableNamedElement_Descriptors() {
		return (EReference)draggableNamedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDraggableNamedElement_Describes() {
		return (EReference)draggableNamedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDraggableProperty() {
		return draggablePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDraggableProperty_LowerBound() {
		return (EAttribute)draggablePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDraggableProperty_UpperBound() {
		return (EAttribute)draggablePropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDraggableProperty_SemanticNodeFrom() {
		return (EReference)draggablePropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDraggableObjectProperty() {
		return draggableObjectPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDraggableObjectProperty_Range() {
		return (EReference)draggableObjectPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDraggableDataProperty() {
		return draggableDataPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDraggableSemanticNode() {
		return draggableSemanticNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDraggableSemanticNode_Properties() {
		return (EReference)draggableSemanticNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDraggableNamedElementSet() {
		return draggableNamedElementSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDraggableNamedElementSet_DraggableSemanticNodes() {
		return (EReference)draggableNamedElementSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DraggablesemanticmanagerFactory getDraggablesemanticmanagerFactory() {
		return (DraggablesemanticmanagerFactory)getEFactoryInstance();
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
		draggableNamedElementEClass = createEClass(DRAGGABLE_NAMED_ELEMENT);
		createEAttribute(draggableNamedElementEClass, DRAGGABLE_NAMED_ELEMENT__NAME);
		createEReference(draggableNamedElementEClass, DRAGGABLE_NAMED_ELEMENT__DESCRIPTORS);
		createEReference(draggableNamedElementEClass, DRAGGABLE_NAMED_ELEMENT__DESCRIBES);

		draggablePropertyEClass = createEClass(DRAGGABLE_PROPERTY);
		createEAttribute(draggablePropertyEClass, DRAGGABLE_PROPERTY__LOWER_BOUND);
		createEAttribute(draggablePropertyEClass, DRAGGABLE_PROPERTY__UPPER_BOUND);
		createEReference(draggablePropertyEClass, DRAGGABLE_PROPERTY__SEMANTIC_NODE_FROM);

		draggableObjectPropertyEClass = createEClass(DRAGGABLE_OBJECT_PROPERTY);
		createEReference(draggableObjectPropertyEClass, DRAGGABLE_OBJECT_PROPERTY__RANGE);

		draggableDataPropertyEClass = createEClass(DRAGGABLE_DATA_PROPERTY);

		draggableSemanticNodeEClass = createEClass(DRAGGABLE_SEMANTIC_NODE);
		createEReference(draggableSemanticNodeEClass, DRAGGABLE_SEMANTIC_NODE__PROPERTIES);

		draggableNamedElementSetEClass = createEClass(DRAGGABLE_NAMED_ELEMENT_SET);
		createEReference(draggableNamedElementSetEClass, DRAGGABLE_NAMED_ELEMENT_SET__DRAGGABLE_SEMANTIC_NODES);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		draggablePropertyEClass.getESuperTypes().add(this.getDraggableNamedElement());
		draggableObjectPropertyEClass.getESuperTypes().add(this.getDraggableProperty());
		draggableDataPropertyEClass.getESuperTypes().add(this.getDraggableProperty());
		draggableSemanticNodeEClass.getESuperTypes().add(this.getDraggableNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(draggableNamedElementEClass, DraggableNamedElement.class, "DraggableNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDraggableNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, DraggableNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDraggableNamedElement_Descriptors(), this.getDraggableNamedElement(), this.getDraggableNamedElement_Describes(), "descriptors", null, 0, -1, DraggableNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDraggableNamedElement_Describes(), this.getDraggableNamedElement(), this.getDraggableNamedElement_Descriptors(), "describes", null, 0, -1, DraggableNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(draggablePropertyEClass, DraggableProperty.class, "DraggableProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDraggableProperty_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 0, 1, DraggableProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDraggableProperty_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 0, 1, DraggableProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDraggableProperty_SemanticNodeFrom(), this.getDraggableSemanticNode(), this.getDraggableSemanticNode_Properties(), "semanticNodeFrom", null, 0, 1, DraggableProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(draggableObjectPropertyEClass, DraggableObjectProperty.class, "DraggableObjectProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDraggableObjectProperty_Range(), this.getDraggableSemanticNode(), null, "range", null, 0, 1, DraggableObjectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(draggableDataPropertyEClass, DraggableDataProperty.class, "DraggableDataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(draggableSemanticNodeEClass, DraggableSemanticNode.class, "DraggableSemanticNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDraggableSemanticNode_Properties(), this.getDraggableProperty(), this.getDraggableProperty_SemanticNodeFrom(), "properties", null, 0, -1, DraggableSemanticNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(draggableNamedElementSetEClass, DraggableNamedElementSet.class, "DraggableNamedElementSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDraggableNamedElementSet_DraggableSemanticNodes(), this.getDraggableSemanticNode(), null, "draggableSemanticNodes", null, 0, -1, DraggableNamedElementSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DraggablesemanticmanagerPackageImpl
