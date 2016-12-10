/**
 */
package semanticmanager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see semanticmanager.SemanticmanagerFactory
 * @model kind="package"
 * @generated
 */
public interface SemanticmanagerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "semanticmanager";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.core.extremo/SemanticManager";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "semanticmanager";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SemanticmanagerPackage eINSTANCE = semanticmanager.impl.SemanticmanagerPackageImpl.init();

	/**
	 * The meta object id for the '{@link semanticmanager.impl.RepositoryManagerImpl <em>Repository Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.RepositoryManagerImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getRepositoryManager()
	 * @generated
	 */
	int REPOSITORY_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Repositories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER__REPOSITORIES = 0;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER__CONFIGURATIONS = 1;

	/**
	 * The number of structural features of the '<em>Repository Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Repository Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.RepositoryImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 1;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ResourceImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 2;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.NamedElementImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__WEIGHT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ID = 3;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DRAWN = 4;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__WEIGHT = NAMED_ELEMENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__DRAWN = NAMED_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__RESOURCES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__WEIGHT = NAMED_ELEMENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DRAWN = NAMED_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ACTIVE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ALIVE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assistant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ASSISTANT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NODES = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__URI = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DESCRIPTOR = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DESCRIBES = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Repository From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__REPOSITORY_FROM = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SemanticNodeImpl <em>Semantic Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SemanticNodeImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSemanticNode()
	 * @generated
	 */
	int SEMANTIC_NODE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__WEIGHT = NAMED_ELEMENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__DRAWN = NAMED_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Supers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__SUPERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__SUBS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__PROPERTIES = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Instance Of</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__INSTANCE_OF = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Instance Of Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__INSTANCE_OF_NODE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Resource From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__RESOURCE_FROM = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Semantic Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Semantic Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.PropertyImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__WEIGHT = NAMED_ELEMENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DRAWN = NAMED_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Semantic Node From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__SEMANTIC_NODE_FROM = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.ObjectPropertyImpl <em>Object Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ObjectPropertyImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getObjectProperty()
	 * @generated
	 */
	int OBJECT_PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__DESCRIPTION = PROPERTY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__WEIGHT = PROPERTY__WEIGHT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__ID = PROPERTY__ID;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__DRAWN = PROPERTY__DRAWN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__VALUE = PROPERTY__VALUE;

	/**
	 * The feature id for the '<em><b>Semantic Node From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__SEMANTIC_NODE_FROM = PROPERTY__SEMANTIC_NODE_FROM;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__RANGE = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.DataPropertyImpl <em>Data Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.DataPropertyImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getDataProperty()
	 * @generated
	 */
	int DATA_PROPERTY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__DESCRIPTION = PROPERTY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__WEIGHT = PROPERTY__WEIGHT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__ID = PROPERTY__ID;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__DRAWN = PROPERTY__DRAWN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__VALUE = PROPERTY__VALUE;

	/**
	 * The feature id for the '<em><b>Semantic Node From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__SEMANTIC_NODE_FROM = PROPERTY__SEMANTIC_NODE_FROM;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__TYPE = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SemanticGroupImpl <em>Semantic Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SemanticGroupImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSemanticGroup()
	 * @generated
	 */
	int SEMANTIC_GROUP = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__WEIGHT = NAMED_ELEMENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__DRAWN = NAMED_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__NODES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Semantic Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Semantic Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SearchConfigurationImpl <em>Search Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SearchConfigurationImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchConfiguration()
	 * @generated
	 */
	int SEARCH_CONFIGURATION = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION__OPTIONS = 2;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION__RESULTS = 3;

	/**
	 * The number of structural features of the '<em>Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Add Search Option</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION___ADD_SEARCH_OPTION__STRING_STRING_TYPE = 0;

	/**
	 * The operation id for the '<em>Search</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION___SEARCH__SEARCHRESULT = 1;

	/**
	 * The operation id for the '<em>Resolve Options</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION___RESOLVE_OPTIONS__ELIST = 2;

	/**
	 * The number of operations of the '<em>Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SearchOptionImpl <em>Search Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SearchOptionImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchOption()
	 * @generated
	 */
	int SEARCH_OPTION = 10;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_OPTION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_OPTION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_OPTION__ID = 2;

	/**
	 * The number of structural features of the '<em>Search Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_OPTION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Search Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_OPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SearchResultImpl <em>Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SearchResultImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchResult()
	 * @generated
	 */
	int SEARCH_RESULT = 11;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__VALUES = 0;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__RESULTS = 2;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__RESOURCES = 3;

	/**
	 * The number of structural features of the '<em>Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Create Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT___CREATE_SEMANTIC_GROUP__STRING_STRING = 0;

	/**
	 * The operation id for the '<em>Add Semantic Node To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT___ADD_SEMANTIC_NODE_TO_SEMANTIC_GROUP__SEMANTICGROUP_SEMANTICNODE = 1;

	/**
	 * The operation id for the '<em>Add Data Property To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT___ADD_DATA_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_DATAPROPERTY = 2;

	/**
	 * The operation id for the '<em>Add Object Property To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT___ADD_OBJECT_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_OBJECTPROPERTY = 3;

	/**
	 * The number of operations of the '<em>Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SearchResultOptionValueImpl <em>Search Result Option Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SearchResultOptionValueImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchResultOptionValue()
	 * @generated
	 */
	int SEARCH_RESULT_OPTION_VALUE = 12;

	/**
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_OPTION_VALUE__OPTION = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_OPTION_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Search Result Option Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_OPTION_VALUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Search Result Option Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_OPTION_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.Type
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 13;


	/**
	 * Returns the meta object for class '{@link semanticmanager.RepositoryManager <em>Repository Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository Manager</em>'.
	 * @see semanticmanager.RepositoryManager
	 * @generated
	 */
	EClass getRepositoryManager();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.RepositoryManager#getRepositories <em>Repositories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Repositories</em>'.
	 * @see semanticmanager.RepositoryManager#getRepositories()
	 * @see #getRepositoryManager()
	 * @generated
	 */
	EReference getRepositoryManager_Repositories();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.RepositoryManager#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see semanticmanager.RepositoryManager#getConfigurations()
	 * @see #getRepositoryManager()
	 * @generated
	 */
	EReference getRepositoryManager_Configurations();

	/**
	 * Returns the meta object for class '{@link semanticmanager.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see semanticmanager.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.Repository#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see semanticmanager.Repository#getResources()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Resources();

	/**
	 * Returns the meta object for class '{@link semanticmanager.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see semanticmanager.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Resource#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see semanticmanager.Resource#isActive()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Active();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Resource#isAlive <em>Alive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alive</em>'.
	 * @see semanticmanager.Resource#isAlive()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Alive();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Resource#getAssistant <em>Assistant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assistant</em>'.
	 * @see semanticmanager.Resource#getAssistant()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Assistant();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.Resource#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see semanticmanager.Resource#getNodes()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Nodes();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Resource#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see semanticmanager.Resource#getUri()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Uri();

	/**
	 * Returns the meta object for the container reference '{@link semanticmanager.Resource#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Descriptor</em>'.
	 * @see semanticmanager.Resource#getDescriptor()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Descriptor();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.Resource#getDescribes <em>Describes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Describes</em>'.
	 * @see semanticmanager.Resource#getDescribes()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Describes();

	/**
	 * Returns the meta object for the container reference '{@link semanticmanager.Resource#getRepositoryFrom <em>Repository From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository From</em>'.
	 * @see semanticmanager.Resource#getRepositoryFrom()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_RepositoryFrom();

	/**
	 * Returns the meta object for class '{@link semanticmanager.SemanticNode <em>Semantic Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantic Node</em>'.
	 * @see semanticmanager.SemanticNode
	 * @generated
	 */
	EClass getSemanticNode();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.SemanticNode#getSupers <em>Supers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supers</em>'.
	 * @see semanticmanager.SemanticNode#getSupers()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EReference getSemanticNode_Supers();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.SemanticNode#getSubs <em>Subs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subs</em>'.
	 * @see semanticmanager.SemanticNode#getSubs()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EReference getSemanticNode_Subs();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.SemanticNode#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see semanticmanager.SemanticNode#getProperties()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EReference getSemanticNode_Properties();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.SemanticNode#isInstanceOf <em>Instance Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Of</em>'.
	 * @see semanticmanager.SemanticNode#isInstanceOf()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EAttribute getSemanticNode_InstanceOf();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.SemanticNode#getInstanceOfNode <em>Instance Of Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Of Node</em>'.
	 * @see semanticmanager.SemanticNode#getInstanceOfNode()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EReference getSemanticNode_InstanceOfNode();

	/**
	 * Returns the meta object for the container reference '{@link semanticmanager.SemanticNode#getResourceFrom <em>Resource From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource From</em>'.
	 * @see semanticmanager.SemanticNode#getResourceFrom()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EReference getSemanticNode_ResourceFrom();

	/**
	 * Returns the meta object for class '{@link semanticmanager.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see semanticmanager.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.NamedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see semanticmanager.NamedElement#getDescription()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.NamedElement#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see semanticmanager.NamedElement#getWeight()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Weight();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.NamedElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.NamedElement#getId()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.NamedElement#isDrawn <em>Drawn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Drawn</em>'.
	 * @see semanticmanager.NamedElement#isDrawn()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Drawn();

	/**
	 * Returns the meta object for class '{@link semanticmanager.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see semanticmanager.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see semanticmanager.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for the container reference '{@link semanticmanager.Property#getSemanticNodeFrom <em>Semantic Node From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Semantic Node From</em>'.
	 * @see semanticmanager.Property#getSemanticNodeFrom()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_SemanticNodeFrom();

	/**
	 * Returns the meta object for class '{@link semanticmanager.ObjectProperty <em>Object Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Property</em>'.
	 * @see semanticmanager.ObjectProperty
	 * @generated
	 */
	EClass getObjectProperty();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.ObjectProperty#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Range</em>'.
	 * @see semanticmanager.ObjectProperty#getRange()
	 * @see #getObjectProperty()
	 * @generated
	 */
	EReference getObjectProperty_Range();

	/**
	 * Returns the meta object for class '{@link semanticmanager.DataProperty <em>Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Property</em>'.
	 * @see semanticmanager.DataProperty
	 * @generated
	 */
	EClass getDataProperty();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.DataProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see semanticmanager.DataProperty#getType()
	 * @see #getDataProperty()
	 * @generated
	 */
	EAttribute getDataProperty_Type();

	/**
	 * Returns the meta object for class '{@link semanticmanager.SemanticGroup <em>Semantic Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantic Group</em>'.
	 * @see semanticmanager.SemanticGroup
	 * @generated
	 */
	EClass getSemanticGroup();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.SemanticGroup#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nodes</em>'.
	 * @see semanticmanager.SemanticGroup#getNodes()
	 * @see #getSemanticGroup()
	 * @generated
	 */
	EReference getSemanticGroup_Nodes();

	/**
	 * Returns the meta object for class '{@link semanticmanager.SearchConfiguration <em>Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Configuration</em>'.
	 * @see semanticmanager.SearchConfiguration
	 * @generated
	 */
	EClass getSearchConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.SearchConfiguration#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.SearchConfiguration#getId()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EAttribute getSearchConfiguration_Id();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.SearchConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.SearchConfiguration#getName()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EAttribute getSearchConfiguration_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.SearchConfiguration#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see semanticmanager.SearchConfiguration#getOptions()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EReference getSearchConfiguration_Options();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.SearchConfiguration#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see semanticmanager.SearchConfiguration#getResults()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EReference getSearchConfiguration_Results();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SearchConfiguration#addSearchOption(java.lang.String, java.lang.String, semanticmanager.Type) <em>Add Search Option</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Search Option</em>' operation.
	 * @see semanticmanager.SearchConfiguration#addSearchOption(java.lang.String, java.lang.String, semanticmanager.Type)
	 * @generated
	 */
	EOperation getSearchConfiguration__AddSearchOption__String_String_Type();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SearchConfiguration#search(semanticmanager.SearchResult) <em>Search</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Search</em>' operation.
	 * @see semanticmanager.SearchConfiguration#search(semanticmanager.SearchResult)
	 * @generated
	 */
	EOperation getSearchConfiguration__Search__SearchResult();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SearchConfiguration#resolveOptions(org.eclipse.emf.common.util.EList) <em>Resolve Options</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resolve Options</em>' operation.
	 * @see semanticmanager.SearchConfiguration#resolveOptions(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getSearchConfiguration__ResolveOptions__EList();

	/**
	 * Returns the meta object for class '{@link semanticmanager.SearchOption <em>Search Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Option</em>'.
	 * @see semanticmanager.SearchOption
	 * @generated
	 */
	EClass getSearchOption();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.SearchOption#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see semanticmanager.SearchOption#getType()
	 * @see #getSearchOption()
	 * @generated
	 */
	EAttribute getSearchOption_Type();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.SearchOption#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.SearchOption#getName()
	 * @see #getSearchOption()
	 * @generated
	 */
	EAttribute getSearchOption_Name();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.SearchOption#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.SearchOption#getId()
	 * @see #getSearchOption()
	 * @generated
	 */
	EAttribute getSearchOption_Id();

	/**
	 * Returns the meta object for class '{@link semanticmanager.SearchResult <em>Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Result</em>'.
	 * @see semanticmanager.SearchResult
	 * @generated
	 */
	EClass getSearchResult();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.SearchResult#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see semanticmanager.SearchResult#getValues()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_Values();

	/**
	 * Returns the meta object for the container reference '{@link semanticmanager.SearchResult#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Configuration</em>'.
	 * @see semanticmanager.SearchResult#getConfiguration()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_Configuration();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.SearchResult#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see semanticmanager.SearchResult#getResults()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_Results();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.SearchResult#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resources</em>'.
	 * @see semanticmanager.SearchResult#getResources()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_Resources();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SearchResult#createSemanticGroup(java.lang.String, java.lang.String) <em>Create Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Semantic Group</em>' operation.
	 * @see semanticmanager.SearchResult#createSemanticGroup(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getSearchResult__CreateSemanticGroup__String_String();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SearchResult#addSemanticNodeToSemanticGroup(semanticmanager.SemanticGroup, semanticmanager.SemanticNode) <em>Add Semantic Node To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Semantic Node To Semantic Group</em>' operation.
	 * @see semanticmanager.SearchResult#addSemanticNodeToSemanticGroup(semanticmanager.SemanticGroup, semanticmanager.SemanticNode)
	 * @generated
	 */
	EOperation getSearchResult__AddSemanticNodeToSemanticGroup__SemanticGroup_SemanticNode();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SearchResult#addDataPropertyToSemanticGroup(semanticmanager.SemanticGroup, semanticmanager.DataProperty) <em>Add Data Property To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Data Property To Semantic Group</em>' operation.
	 * @see semanticmanager.SearchResult#addDataPropertyToSemanticGroup(semanticmanager.SemanticGroup, semanticmanager.DataProperty)
	 * @generated
	 */
	EOperation getSearchResult__AddDataPropertyToSemanticGroup__SemanticGroup_DataProperty();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SearchResult#addObjectPropertyToSemanticGroup(semanticmanager.SemanticGroup, semanticmanager.ObjectProperty) <em>Add Object Property To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Object Property To Semantic Group</em>' operation.
	 * @see semanticmanager.SearchResult#addObjectPropertyToSemanticGroup(semanticmanager.SemanticGroup, semanticmanager.ObjectProperty)
	 * @generated
	 */
	EOperation getSearchResult__AddObjectPropertyToSemanticGroup__SemanticGroup_ObjectProperty();

	/**
	 * Returns the meta object for class '{@link semanticmanager.SearchResultOptionValue <em>Search Result Option Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Result Option Value</em>'.
	 * @see semanticmanager.SearchResultOptionValue
	 * @generated
	 */
	EClass getSearchResultOptionValue();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.SearchResultOptionValue#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Option</em>'.
	 * @see semanticmanager.SearchResultOptionValue#getOption()
	 * @see #getSearchResultOptionValue()
	 * @generated
	 */
	EReference getSearchResultOptionValue_Option();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.SearchResultOptionValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see semanticmanager.SearchResultOptionValue#getValue()
	 * @see #getSearchResultOptionValue()
	 * @generated
	 */
	EAttribute getSearchResultOptionValue_Value();

	/**
	 * Returns the meta object for enum '{@link semanticmanager.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see semanticmanager.Type
	 * @generated
	 */
	EEnum getType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SemanticmanagerFactory getSemanticmanagerFactory();

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
		 * The meta object literal for the '{@link semanticmanager.impl.RepositoryManagerImpl <em>Repository Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.RepositoryManagerImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getRepositoryManager()
		 * @generated
		 */
		EClass REPOSITORY_MANAGER = eINSTANCE.getRepositoryManager();

		/**
		 * The meta object literal for the '<em><b>Repositories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_MANAGER__REPOSITORIES = eINSTANCE.getRepositoryManager_Repositories();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_MANAGER__CONFIGURATIONS = eINSTANCE.getRepositoryManager_Configurations();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.RepositoryImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__RESOURCES = eINSTANCE.getRepository_Resources();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.ResourceImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__ACTIVE = eINSTANCE.getResource_Active();

		/**
		 * The meta object literal for the '<em><b>Alive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__ALIVE = eINSTANCE.getResource_Alive();

		/**
		 * The meta object literal for the '<em><b>Assistant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__ASSISTANT = eINSTANCE.getResource_Assistant();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__NODES = eINSTANCE.getResource_Nodes();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__URI = eINSTANCE.getResource_Uri();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__DESCRIPTOR = eINSTANCE.getResource_Descriptor();

		/**
		 * The meta object literal for the '<em><b>Describes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__DESCRIBES = eINSTANCE.getResource_Describes();

		/**
		 * The meta object literal for the '<em><b>Repository From</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__REPOSITORY_FROM = eINSTANCE.getResource_RepositoryFrom();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.SemanticNodeImpl <em>Semantic Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.SemanticNodeImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSemanticNode()
		 * @generated
		 */
		EClass SEMANTIC_NODE = eINSTANCE.getSemanticNode();

		/**
		 * The meta object literal for the '<em><b>Supers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_NODE__SUPERS = eINSTANCE.getSemanticNode_Supers();

		/**
		 * The meta object literal for the '<em><b>Subs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_NODE__SUBS = eINSTANCE.getSemanticNode_Subs();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_NODE__PROPERTIES = eINSTANCE.getSemanticNode_Properties();

		/**
		 * The meta object literal for the '<em><b>Instance Of</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEMANTIC_NODE__INSTANCE_OF = eINSTANCE.getSemanticNode_InstanceOf();

		/**
		 * The meta object literal for the '<em><b>Instance Of Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_NODE__INSTANCE_OF_NODE = eINSTANCE.getSemanticNode_InstanceOfNode();

		/**
		 * The meta object literal for the '<em><b>Resource From</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_NODE__RESOURCE_FROM = eINSTANCE.getSemanticNode_ResourceFrom();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.NamedElementImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__DESCRIPTION = eINSTANCE.getNamedElement_Description();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__WEIGHT = eINSTANCE.getNamedElement_Weight();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__ID = eINSTANCE.getNamedElement_Id();

		/**
		 * The meta object literal for the '<em><b>Drawn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__DRAWN = eINSTANCE.getNamedElement_Drawn();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.PropertyImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Semantic Node From</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__SEMANTIC_NODE_FROM = eINSTANCE.getProperty_SemanticNodeFrom();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.ObjectPropertyImpl <em>Object Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.ObjectPropertyImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getObjectProperty()
		 * @generated
		 */
		EClass OBJECT_PROPERTY = eINSTANCE.getObjectProperty();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PROPERTY__RANGE = eINSTANCE.getObjectProperty_Range();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.DataPropertyImpl <em>Data Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.DataPropertyImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getDataProperty()
		 * @generated
		 */
		EClass DATA_PROPERTY = eINSTANCE.getDataProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_PROPERTY__TYPE = eINSTANCE.getDataProperty_Type();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.SemanticGroupImpl <em>Semantic Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.SemanticGroupImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSemanticGroup()
		 * @generated
		 */
		EClass SEMANTIC_GROUP = eINSTANCE.getSemanticGroup();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_GROUP__NODES = eINSTANCE.getSemanticGroup_Nodes();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.SearchConfigurationImpl <em>Search Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.SearchConfigurationImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchConfiguration()
		 * @generated
		 */
		EClass SEARCH_CONFIGURATION = eINSTANCE.getSearchConfiguration();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_CONFIGURATION__ID = eINSTANCE.getSearchConfiguration_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_CONFIGURATION__NAME = eINSTANCE.getSearchConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_CONFIGURATION__OPTIONS = eINSTANCE.getSearchConfiguration_Options();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_CONFIGURATION__RESULTS = eINSTANCE.getSearchConfiguration_Results();

		/**
		 * The meta object literal for the '<em><b>Add Search Option</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEARCH_CONFIGURATION___ADD_SEARCH_OPTION__STRING_STRING_TYPE = eINSTANCE.getSearchConfiguration__AddSearchOption__String_String_Type();

		/**
		 * The meta object literal for the '<em><b>Search</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEARCH_CONFIGURATION___SEARCH__SEARCHRESULT = eINSTANCE.getSearchConfiguration__Search__SearchResult();

		/**
		 * The meta object literal for the '<em><b>Resolve Options</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEARCH_CONFIGURATION___RESOLVE_OPTIONS__ELIST = eINSTANCE.getSearchConfiguration__ResolveOptions__EList();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.SearchOptionImpl <em>Search Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.SearchOptionImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchOption()
		 * @generated
		 */
		EClass SEARCH_OPTION = eINSTANCE.getSearchOption();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_OPTION__TYPE = eINSTANCE.getSearchOption_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_OPTION__NAME = eINSTANCE.getSearchOption_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_OPTION__ID = eINSTANCE.getSearchOption_Id();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.SearchResultImpl <em>Search Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.SearchResultImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchResult()
		 * @generated
		 */
		EClass SEARCH_RESULT = eINSTANCE.getSearchResult();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_RESULT__VALUES = eINSTANCE.getSearchResult_Values();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_RESULT__CONFIGURATION = eINSTANCE.getSearchResult_Configuration();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_RESULT__RESULTS = eINSTANCE.getSearchResult_Results();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_RESULT__RESOURCES = eINSTANCE.getSearchResult_Resources();

		/**
		 * The meta object literal for the '<em><b>Create Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEARCH_RESULT___CREATE_SEMANTIC_GROUP__STRING_STRING = eINSTANCE.getSearchResult__CreateSemanticGroup__String_String();

		/**
		 * The meta object literal for the '<em><b>Add Semantic Node To Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEARCH_RESULT___ADD_SEMANTIC_NODE_TO_SEMANTIC_GROUP__SEMANTICGROUP_SEMANTICNODE = eINSTANCE.getSearchResult__AddSemanticNodeToSemanticGroup__SemanticGroup_SemanticNode();

		/**
		 * The meta object literal for the '<em><b>Add Data Property To Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEARCH_RESULT___ADD_DATA_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_DATAPROPERTY = eINSTANCE.getSearchResult__AddDataPropertyToSemanticGroup__SemanticGroup_DataProperty();

		/**
		 * The meta object literal for the '<em><b>Add Object Property To Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEARCH_RESULT___ADD_OBJECT_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_OBJECTPROPERTY = eINSTANCE.getSearchResult__AddObjectPropertyToSemanticGroup__SemanticGroup_ObjectProperty();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.SearchResultOptionValueImpl <em>Search Result Option Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.SearchResultOptionValueImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchResultOptionValue()
		 * @generated
		 */
		EClass SEARCH_RESULT_OPTION_VALUE = eINSTANCE.getSearchResultOptionValue();

		/**
		 * The meta object literal for the '<em><b>Option</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_RESULT_OPTION_VALUE__OPTION = eINSTANCE.getSearchResultOptionValue_Option();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_RESULT_OPTION_VALUE__VALUE = eINSTANCE.getSearchResultOptionValue_Value();

		/**
		 * The meta object literal for the '{@link semanticmanager.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.Type
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

	}

} //SemanticmanagerPackage
