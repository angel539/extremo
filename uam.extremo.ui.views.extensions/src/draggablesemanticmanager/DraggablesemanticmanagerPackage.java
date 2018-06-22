/**
 */
package draggablesemanticmanager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see draggablesemanticmanager.DraggablesemanticmanagerFactory
 * @model kind="package"
 * @generated
 */
public interface DraggablesemanticmanagerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "draggablesemanticmanager";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.core.extremo/DraggableSemanticManager";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "draggablesemanticmanager";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DraggablesemanticmanagerPackage eINSTANCE = draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl.init();

	/**
	 * The meta object id for the '{@link draggablesemanticmanager.impl.DraggableNamedElementImpl <em>Draggable Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see draggablesemanticmanager.impl.DraggableNamedElementImpl
	 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableNamedElement()
	 * @generated
	 */
	int DRAGGABLE_NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_NAMED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_NAMED_ELEMENT__DESCRIPTORS = 1;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_NAMED_ELEMENT__DESCRIBES = 2;

	/**
	 * The number of structural features of the '<em>Draggable Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_NAMED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Draggable Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link draggablesemanticmanager.impl.DraggablePropertyImpl <em>Draggable Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see draggablesemanticmanager.impl.DraggablePropertyImpl
	 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableProperty()
	 * @generated
	 */
	int DRAGGABLE_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_PROPERTY__NAME = DRAGGABLE_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_PROPERTY__DESCRIPTORS = DRAGGABLE_NAMED_ELEMENT__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_PROPERTY__DESCRIBES = DRAGGABLE_NAMED_ELEMENT__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_PROPERTY__LOWER_BOUND = DRAGGABLE_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_PROPERTY__UPPER_BOUND = DRAGGABLE_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Semantic Node From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_PROPERTY__SEMANTIC_NODE_FROM = DRAGGABLE_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Draggable Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_PROPERTY_FEATURE_COUNT = DRAGGABLE_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Draggable Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_PROPERTY_OPERATION_COUNT = DRAGGABLE_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link draggablesemanticmanager.impl.DraggableObjectPropertyImpl <em>Draggable Object Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see draggablesemanticmanager.impl.DraggableObjectPropertyImpl
	 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableObjectProperty()
	 * @generated
	 */
	int DRAGGABLE_OBJECT_PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_OBJECT_PROPERTY__NAME = DRAGGABLE_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_OBJECT_PROPERTY__DESCRIPTORS = DRAGGABLE_PROPERTY__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_OBJECT_PROPERTY__DESCRIBES = DRAGGABLE_PROPERTY__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_OBJECT_PROPERTY__LOWER_BOUND = DRAGGABLE_PROPERTY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_OBJECT_PROPERTY__UPPER_BOUND = DRAGGABLE_PROPERTY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Semantic Node From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_OBJECT_PROPERTY__SEMANTIC_NODE_FROM = DRAGGABLE_PROPERTY__SEMANTIC_NODE_FROM;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_OBJECT_PROPERTY__RANGE = DRAGGABLE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Draggable Object Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_OBJECT_PROPERTY_FEATURE_COUNT = DRAGGABLE_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Draggable Object Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_OBJECT_PROPERTY_OPERATION_COUNT = DRAGGABLE_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link draggablesemanticmanager.impl.DraggableDataPropertyImpl <em>Draggable Data Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see draggablesemanticmanager.impl.DraggableDataPropertyImpl
	 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableDataProperty()
	 * @generated
	 */
	int DRAGGABLE_DATA_PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_DATA_PROPERTY__NAME = DRAGGABLE_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_DATA_PROPERTY__DESCRIPTORS = DRAGGABLE_PROPERTY__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_DATA_PROPERTY__DESCRIBES = DRAGGABLE_PROPERTY__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_DATA_PROPERTY__LOWER_BOUND = DRAGGABLE_PROPERTY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_DATA_PROPERTY__UPPER_BOUND = DRAGGABLE_PROPERTY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Semantic Node From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_DATA_PROPERTY__SEMANTIC_NODE_FROM = DRAGGABLE_PROPERTY__SEMANTIC_NODE_FROM;

	/**
	 * The number of structural features of the '<em>Draggable Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_DATA_PROPERTY_FEATURE_COUNT = DRAGGABLE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Draggable Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_DATA_PROPERTY_OPERATION_COUNT = DRAGGABLE_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link draggablesemanticmanager.impl.DraggableSemanticNodeImpl <em>Draggable Semantic Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see draggablesemanticmanager.impl.DraggableSemanticNodeImpl
	 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableSemanticNode()
	 * @generated
	 */
	int DRAGGABLE_SEMANTIC_NODE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_SEMANTIC_NODE__NAME = DRAGGABLE_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_SEMANTIC_NODE__DESCRIPTORS = DRAGGABLE_NAMED_ELEMENT__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_SEMANTIC_NODE__DESCRIBES = DRAGGABLE_NAMED_ELEMENT__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_SEMANTIC_NODE__PROPERTIES = DRAGGABLE_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Draggable Semantic Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_SEMANTIC_NODE_FEATURE_COUNT = DRAGGABLE_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Draggable Semantic Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_SEMANTIC_NODE_OPERATION_COUNT = DRAGGABLE_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link draggablesemanticmanager.impl.DraggableNamedElementSetImpl <em>Draggable Named Element Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see draggablesemanticmanager.impl.DraggableNamedElementSetImpl
	 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableNamedElementSet()
	 * @generated
	 */
	int DRAGGABLE_NAMED_ELEMENT_SET = 5;

	/**
	 * The feature id for the '<em><b>Draggable Semantic Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_NAMED_ELEMENT_SET__DRAGGABLE_SEMANTIC_NODES = 0;

	/**
	 * The number of structural features of the '<em>Draggable Named Element Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_NAMED_ELEMENT_SET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Draggable Named Element Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAGGABLE_NAMED_ELEMENT_SET_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link draggablesemanticmanager.DraggableNamedElement <em>Draggable Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Draggable Named Element</em>'.
	 * @see draggablesemanticmanager.DraggableNamedElement
	 * @generated
	 */
	EClass getDraggableNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link draggablesemanticmanager.DraggableNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see draggablesemanticmanager.DraggableNamedElement#getName()
	 * @see #getDraggableNamedElement()
	 * @generated
	 */
	EAttribute getDraggableNamedElement_Name();

	/**
	 * Returns the meta object for the reference list '{@link draggablesemanticmanager.DraggableNamedElement#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptors</em>'.
	 * @see draggablesemanticmanager.DraggableNamedElement#getDescriptors()
	 * @see #getDraggableNamedElement()
	 * @generated
	 */
	EReference getDraggableNamedElement_Descriptors();

	/**
	 * Returns the meta object for the reference list '{@link draggablesemanticmanager.DraggableNamedElement#getDescribes <em>Describes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Describes</em>'.
	 * @see draggablesemanticmanager.DraggableNamedElement#getDescribes()
	 * @see #getDraggableNamedElement()
	 * @generated
	 */
	EReference getDraggableNamedElement_Describes();

	/**
	 * Returns the meta object for class '{@link draggablesemanticmanager.DraggableProperty <em>Draggable Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Draggable Property</em>'.
	 * @see draggablesemanticmanager.DraggableProperty
	 * @generated
	 */
	EClass getDraggableProperty();

	/**
	 * Returns the meta object for the attribute '{@link draggablesemanticmanager.DraggableProperty#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see draggablesemanticmanager.DraggableProperty#getLowerBound()
	 * @see #getDraggableProperty()
	 * @generated
	 */
	EAttribute getDraggableProperty_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link draggablesemanticmanager.DraggableProperty#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see draggablesemanticmanager.DraggableProperty#getUpperBound()
	 * @see #getDraggableProperty()
	 * @generated
	 */
	EAttribute getDraggableProperty_UpperBound();

	/**
	 * Returns the meta object for the container reference '{@link draggablesemanticmanager.DraggableProperty#getSemanticNodeFrom <em>Semantic Node From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Semantic Node From</em>'.
	 * @see draggablesemanticmanager.DraggableProperty#getSemanticNodeFrom()
	 * @see #getDraggableProperty()
	 * @generated
	 */
	EReference getDraggableProperty_SemanticNodeFrom();

	/**
	 * Returns the meta object for class '{@link draggablesemanticmanager.DraggableObjectProperty <em>Draggable Object Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Draggable Object Property</em>'.
	 * @see draggablesemanticmanager.DraggableObjectProperty
	 * @generated
	 */
	EClass getDraggableObjectProperty();

	/**
	 * Returns the meta object for the reference '{@link draggablesemanticmanager.DraggableObjectProperty#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Range</em>'.
	 * @see draggablesemanticmanager.DraggableObjectProperty#getRange()
	 * @see #getDraggableObjectProperty()
	 * @generated
	 */
	EReference getDraggableObjectProperty_Range();

	/**
	 * Returns the meta object for class '{@link draggablesemanticmanager.DraggableDataProperty <em>Draggable Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Draggable Data Property</em>'.
	 * @see draggablesemanticmanager.DraggableDataProperty
	 * @generated
	 */
	EClass getDraggableDataProperty();

	/**
	 * Returns the meta object for class '{@link draggablesemanticmanager.DraggableSemanticNode <em>Draggable Semantic Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Draggable Semantic Node</em>'.
	 * @see draggablesemanticmanager.DraggableSemanticNode
	 * @generated
	 */
	EClass getDraggableSemanticNode();

	/**
	 * Returns the meta object for the containment reference list '{@link draggablesemanticmanager.DraggableSemanticNode#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see draggablesemanticmanager.DraggableSemanticNode#getProperties()
	 * @see #getDraggableSemanticNode()
	 * @generated
	 */
	EReference getDraggableSemanticNode_Properties();

	/**
	 * Returns the meta object for class '{@link draggablesemanticmanager.DraggableNamedElementSet <em>Draggable Named Element Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Draggable Named Element Set</em>'.
	 * @see draggablesemanticmanager.DraggableNamedElementSet
	 * @generated
	 */
	EClass getDraggableNamedElementSet();

	/**
	 * Returns the meta object for the containment reference list '{@link draggablesemanticmanager.DraggableNamedElementSet#getDraggableSemanticNodes <em>Draggable Semantic Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Draggable Semantic Nodes</em>'.
	 * @see draggablesemanticmanager.DraggableNamedElementSet#getDraggableSemanticNodes()
	 * @see #getDraggableNamedElementSet()
	 * @generated
	 */
	EReference getDraggableNamedElementSet_DraggableSemanticNodes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DraggablesemanticmanagerFactory getDraggablesemanticmanagerFactory();

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
		 * The meta object literal for the '{@link draggablesemanticmanager.impl.DraggableNamedElementImpl <em>Draggable Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see draggablesemanticmanager.impl.DraggableNamedElementImpl
		 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableNamedElement()
		 * @generated
		 */
		EClass DRAGGABLE_NAMED_ELEMENT = eINSTANCE.getDraggableNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAGGABLE_NAMED_ELEMENT__NAME = eINSTANCE.getDraggableNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Descriptors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAGGABLE_NAMED_ELEMENT__DESCRIPTORS = eINSTANCE.getDraggableNamedElement_Descriptors();

		/**
		 * The meta object literal for the '<em><b>Describes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAGGABLE_NAMED_ELEMENT__DESCRIBES = eINSTANCE.getDraggableNamedElement_Describes();

		/**
		 * The meta object literal for the '{@link draggablesemanticmanager.impl.DraggablePropertyImpl <em>Draggable Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see draggablesemanticmanager.impl.DraggablePropertyImpl
		 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableProperty()
		 * @generated
		 */
		EClass DRAGGABLE_PROPERTY = eINSTANCE.getDraggableProperty();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAGGABLE_PROPERTY__LOWER_BOUND = eINSTANCE.getDraggableProperty_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAGGABLE_PROPERTY__UPPER_BOUND = eINSTANCE.getDraggableProperty_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Semantic Node From</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAGGABLE_PROPERTY__SEMANTIC_NODE_FROM = eINSTANCE.getDraggableProperty_SemanticNodeFrom();

		/**
		 * The meta object literal for the '{@link draggablesemanticmanager.impl.DraggableObjectPropertyImpl <em>Draggable Object Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see draggablesemanticmanager.impl.DraggableObjectPropertyImpl
		 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableObjectProperty()
		 * @generated
		 */
		EClass DRAGGABLE_OBJECT_PROPERTY = eINSTANCE.getDraggableObjectProperty();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAGGABLE_OBJECT_PROPERTY__RANGE = eINSTANCE.getDraggableObjectProperty_Range();

		/**
		 * The meta object literal for the '{@link draggablesemanticmanager.impl.DraggableDataPropertyImpl <em>Draggable Data Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see draggablesemanticmanager.impl.DraggableDataPropertyImpl
		 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableDataProperty()
		 * @generated
		 */
		EClass DRAGGABLE_DATA_PROPERTY = eINSTANCE.getDraggableDataProperty();

		/**
		 * The meta object literal for the '{@link draggablesemanticmanager.impl.DraggableSemanticNodeImpl <em>Draggable Semantic Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see draggablesemanticmanager.impl.DraggableSemanticNodeImpl
		 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableSemanticNode()
		 * @generated
		 */
		EClass DRAGGABLE_SEMANTIC_NODE = eINSTANCE.getDraggableSemanticNode();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAGGABLE_SEMANTIC_NODE__PROPERTIES = eINSTANCE.getDraggableSemanticNode_Properties();

		/**
		 * The meta object literal for the '{@link draggablesemanticmanager.impl.DraggableNamedElementSetImpl <em>Draggable Named Element Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see draggablesemanticmanager.impl.DraggableNamedElementSetImpl
		 * @see draggablesemanticmanager.impl.DraggablesemanticmanagerPackageImpl#getDraggableNamedElementSet()
		 * @generated
		 */
		EClass DRAGGABLE_NAMED_ELEMENT_SET = eINSTANCE.getDraggableNamedElementSet();

		/**
		 * The meta object literal for the '<em><b>Draggable Semantic Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAGGABLE_NAMED_ELEMENT_SET__DRAGGABLE_SEMANTIC_NODES = eINSTANCE.getDraggableNamedElementSet_DraggableSemanticNodes();

	}

} //DraggablesemanticmanagerPackage
