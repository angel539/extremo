/**
 */
package epml;

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage;

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
 * @see epml.EpmlFactory
 * @model kind="package"
 * @generated
 */
public interface EpmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "epml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://angel539.github.io/extremo/casestudy/epml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "epml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EpmlPackage eINSTANCE = epml.impl.EpmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link epml.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.NamedElementImpl
	 * @see epml.impl.EpmlPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link epml.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.ApplicationImpl
	 * @see epml.impl.EpmlPackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Agents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__OWNED_AGENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Places</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__OWNED_PLACES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.AgentImpl <em>Agent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.AgentImpl
	 * @see epml.impl.EpmlPackageImpl#getAgent()
	 * @generated
	 */
	int AGENT = 2;

	/**
	 * The feature id for the '<em><b>Date Of Original Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__DATE_OF_ORIGINAL_DEFINITION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DATE_OF_ORIGINAL_DEFINITION;

	/**
	 * The feature id for the '<em><b>Date Of Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__DATE_OF_CURRENT_VERSION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DATE_OF_CURRENT_VERSION;

	/**
	 * The feature id for the '<em><b>Date Of Current Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__DATE_OF_CURRENT_REVISION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DATE_OF_CURRENT_REVISION;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__REVISION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__REVISION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__STATUS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__STATUS;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__IS_DEPRECATED = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__IS_DEPRECATED;

	/**
	 * The feature id for the '<em><b>Hierarchical Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__HIERARCHICAL_POSITION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__HIERARCHICAL_POSITION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__ID = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__ID;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__TRANSLATION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__TRANSLATION;

	/**
	 * The feature id for the '<em><b>Source Language</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__SOURCE_LANGUAGE = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__SOURCE_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Is Deprecated Interpretation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__IS_DEPRECATED_INTERPRETATION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__IS_DEPRECATED_INTERPRETATION;

	/**
	 * The feature id for the '<em><b>Preferred Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__PREFERRED_NAME = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__PREFERRED_NAME;

	/**
	 * The feature id for the '<em><b>Synonymous Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__SYNONYMOUS_NAMES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__SYNONYMOUS_NAMES;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__SHORT_NAME = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__ICON = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__ICON;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__DEFINITION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DEFINITION;

	/**
	 * The feature id for the '<em><b>Source Doc Of Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__SOURCE_DOC_OF_DEFINITION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__SOURCE_DOC_OF_DEFINITION;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__NOTE = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__NOTE;

	/**
	 * The feature id for the '<em><b>Remark</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__REMARK = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__REMARK;

	/**
	 * The feature id for the '<em><b>Its Superclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__ITS_SUPERCLASS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__ITS_SUPERCLASS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__DESCRIBED_BY = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Defined Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__DEFINED_TYPES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Defined Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__DEFINED_DOCUMENTS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DEFINED_DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__CONSTRAINTS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__KEYWORDS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Sub Class Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__SUB_CLASS_PROPERTIES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__SUB_CLASS_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Class Constant Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__CLASS_CONSTANT_VALUES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__CLASS_CONSTANT_VALUES;

	/**
	 * The feature id for the '<em><b>Geometric Representation Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__GEOMETRIC_REPRESENTATION_CONTEXT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__GEOMETRIC_REPRESENTATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Global Unit Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__GLOBAL_UNIT_CONTEXT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__GLOBAL_UNIT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Categorization Class Superclasses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__CATEGORIZATION_CLASS_SUPERCLASSES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__CATEGORIZATION_CLASS_SUPERCLASSES;

	/**
	 * The feature id for the '<em><b>Owned Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__OWNED_PORTS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__OWNER = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_FEATURE_COUNT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_OPERATION_COUNT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.PortImpl
	 * @see epml.impl.EpmlPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OWNER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.InputPortImpl <em>Input Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.InputPortImpl
	 * @see epml.impl.EpmlPackageImpl#getInputPort()
	 * @generated
	 */
	int INPUT_PORT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__OWNER = PORT__OWNER;

	/**
	 * The number of structural features of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.OutputPortImpl <em>Output Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.OutputPortImpl
	 * @see epml.impl.EpmlPackageImpl#getOutputPort()
	 * @generated
	 */
	int OUTPUT_PORT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__OWNER = PORT__OWNER;

	/**
	 * The number of structural features of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.PlaceImpl <em>Place</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.PlaceImpl
	 * @see epml.impl.EpmlPackageImpl#getPlace()
	 * @generated
	 */
	int PLACE = 6;

	/**
	 * The feature id for the '<em><b>Date Of Original Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__DATE_OF_ORIGINAL_DEFINITION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DATE_OF_ORIGINAL_DEFINITION;

	/**
	 * The feature id for the '<em><b>Date Of Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__DATE_OF_CURRENT_VERSION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DATE_OF_CURRENT_VERSION;

	/**
	 * The feature id for the '<em><b>Date Of Current Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__DATE_OF_CURRENT_REVISION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DATE_OF_CURRENT_REVISION;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__REVISION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__REVISION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__STATUS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__STATUS;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__IS_DEPRECATED = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__IS_DEPRECATED;

	/**
	 * The feature id for the '<em><b>Hierarchical Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__HIERARCHICAL_POSITION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__HIERARCHICAL_POSITION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ID = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__ID;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__TRANSLATION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__TRANSLATION;

	/**
	 * The feature id for the '<em><b>Source Language</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__SOURCE_LANGUAGE = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__SOURCE_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Is Deprecated Interpretation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__IS_DEPRECATED_INTERPRETATION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__IS_DEPRECATED_INTERPRETATION;

	/**
	 * The feature id for the '<em><b>Preferred Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__PREFERRED_NAME = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__PREFERRED_NAME;

	/**
	 * The feature id for the '<em><b>Synonymous Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__SYNONYMOUS_NAMES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__SYNONYMOUS_NAMES;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__SHORT_NAME = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ICON = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__ICON;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__DEFINITION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DEFINITION;

	/**
	 * The feature id for the '<em><b>Source Doc Of Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__SOURCE_DOC_OF_DEFINITION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__SOURCE_DOC_OF_DEFINITION;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__NOTE = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__NOTE;

	/**
	 * The feature id for the '<em><b>Remark</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__REMARK = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__REMARK;

	/**
	 * The feature id for the '<em><b>Its Superclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ITS_SUPERCLASS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__ITS_SUPERCLASS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__DESCRIBED_BY = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Defined Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__DEFINED_TYPES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Defined Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__DEFINED_DOCUMENTS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__DEFINED_DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__CONSTRAINTS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__KEYWORDS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Sub Class Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__SUB_CLASS_PROPERTIES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__SUB_CLASS_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Class Constant Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__CLASS_CONSTANT_VALUES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__CLASS_CONSTANT_VALUES;

	/**
	 * The feature id for the '<em><b>Geometric Representation Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__GEOMETRIC_REPRESENTATION_CONTEXT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__GEOMETRIC_REPRESENTATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Global Unit Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__GLOBAL_UNIT_CONTEXT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__GLOBAL_UNIT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Categorization Class Superclasses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__CATEGORIZATION_CLASS_SUPERCLASSES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS__CATEGORIZATION_CLASS_SUPERCLASSES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__NAME = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Its Output Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ITS_OUTPUT_PORT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Its Input Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ITS_INPUT_PORT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__OWNER = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_FEATURE_COUNT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_OPERATION_COUNT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.CATEGORIZATIONCLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.PCBasedControlsImpl <em>PC Based Controls</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.PCBasedControlsImpl
	 * @see epml.impl.EpmlPackageImpl#getPCBasedControls()
	 * @generated
	 */
	int PC_BASED_CONTROLS = 7;

	/**
	 * The feature id for the '<em><b>Date Of Original Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__DATE_OF_ORIGINAL_DEFINITION = AGENT__DATE_OF_ORIGINAL_DEFINITION;

	/**
	 * The feature id for the '<em><b>Date Of Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__DATE_OF_CURRENT_VERSION = AGENT__DATE_OF_CURRENT_VERSION;

	/**
	 * The feature id for the '<em><b>Date Of Current Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__DATE_OF_CURRENT_REVISION = AGENT__DATE_OF_CURRENT_REVISION;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__REVISION = AGENT__REVISION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__STATUS = AGENT__STATUS;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__IS_DEPRECATED = AGENT__IS_DEPRECATED;

	/**
	 * The feature id for the '<em><b>Hierarchical Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__HIERARCHICAL_POSITION = AGENT__HIERARCHICAL_POSITION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__ID = AGENT__ID;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__TRANSLATION = AGENT__TRANSLATION;

	/**
	 * The feature id for the '<em><b>Source Language</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__SOURCE_LANGUAGE = AGENT__SOURCE_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Is Deprecated Interpretation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__IS_DEPRECATED_INTERPRETATION = AGENT__IS_DEPRECATED_INTERPRETATION;

	/**
	 * The feature id for the '<em><b>Preferred Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__PREFERRED_NAME = AGENT__PREFERRED_NAME;

	/**
	 * The feature id for the '<em><b>Synonymous Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__SYNONYMOUS_NAMES = AGENT__SYNONYMOUS_NAMES;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__SHORT_NAME = AGENT__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__ICON = AGENT__ICON;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__DEFINITION = AGENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Source Doc Of Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__SOURCE_DOC_OF_DEFINITION = AGENT__SOURCE_DOC_OF_DEFINITION;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__NOTE = AGENT__NOTE;

	/**
	 * The feature id for the '<em><b>Remark</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__REMARK = AGENT__REMARK;

	/**
	 * The feature id for the '<em><b>Its Superclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__ITS_SUPERCLASS = AGENT__ITS_SUPERCLASS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__DESCRIBED_BY = AGENT__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Defined Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__DEFINED_TYPES = AGENT__DEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Defined Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__DEFINED_DOCUMENTS = AGENT__DEFINED_DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__CONSTRAINTS = AGENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__KEYWORDS = AGENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Sub Class Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__SUB_CLASS_PROPERTIES = AGENT__SUB_CLASS_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Class Constant Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__CLASS_CONSTANT_VALUES = AGENT__CLASS_CONSTANT_VALUES;

	/**
	 * The feature id for the '<em><b>Geometric Representation Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__GEOMETRIC_REPRESENTATION_CONTEXT = AGENT__GEOMETRIC_REPRESENTATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Global Unit Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__GLOBAL_UNIT_CONTEXT = AGENT__GLOBAL_UNIT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Categorization Class Superclasses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__CATEGORIZATION_CLASS_SUPERCLASSES = AGENT__CATEGORIZATION_CLASS_SUPERCLASSES;

	/**
	 * The feature id for the '<em><b>Owned Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__OWNED_PORTS = AGENT__OWNED_PORTS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS__OWNER = AGENT__OWNER;

	/**
	 * The number of structural features of the '<em>PC Based Controls</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS_FEATURE_COUNT = AGENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>PC Based Controls</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PC_BASED_CONTROLS_OPERATION_COUNT = AGENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.FieldbusImpl <em>Fieldbus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.FieldbusImpl
	 * @see epml.impl.EpmlPackageImpl#getFieldbus()
	 * @generated
	 */
	int FIELDBUS = 8;

	/**
	 * The feature id for the '<em><b>Date Of Original Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__DATE_OF_ORIGINAL_DEFINITION = AGENT__DATE_OF_ORIGINAL_DEFINITION;

	/**
	 * The feature id for the '<em><b>Date Of Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__DATE_OF_CURRENT_VERSION = AGENT__DATE_OF_CURRENT_VERSION;

	/**
	 * The feature id for the '<em><b>Date Of Current Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__DATE_OF_CURRENT_REVISION = AGENT__DATE_OF_CURRENT_REVISION;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__REVISION = AGENT__REVISION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__STATUS = AGENT__STATUS;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__IS_DEPRECATED = AGENT__IS_DEPRECATED;

	/**
	 * The feature id for the '<em><b>Hierarchical Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__HIERARCHICAL_POSITION = AGENT__HIERARCHICAL_POSITION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__ID = AGENT__ID;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__TRANSLATION = AGENT__TRANSLATION;

	/**
	 * The feature id for the '<em><b>Source Language</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__SOURCE_LANGUAGE = AGENT__SOURCE_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Is Deprecated Interpretation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__IS_DEPRECATED_INTERPRETATION = AGENT__IS_DEPRECATED_INTERPRETATION;

	/**
	 * The feature id for the '<em><b>Preferred Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__PREFERRED_NAME = AGENT__PREFERRED_NAME;

	/**
	 * The feature id for the '<em><b>Synonymous Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__SYNONYMOUS_NAMES = AGENT__SYNONYMOUS_NAMES;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__SHORT_NAME = AGENT__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__ICON = AGENT__ICON;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__DEFINITION = AGENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Source Doc Of Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__SOURCE_DOC_OF_DEFINITION = AGENT__SOURCE_DOC_OF_DEFINITION;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__NOTE = AGENT__NOTE;

	/**
	 * The feature id for the '<em><b>Remark</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__REMARK = AGENT__REMARK;

	/**
	 * The feature id for the '<em><b>Its Superclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__ITS_SUPERCLASS = AGENT__ITS_SUPERCLASS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__DESCRIBED_BY = AGENT__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Defined Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__DEFINED_TYPES = AGENT__DEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Defined Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__DEFINED_DOCUMENTS = AGENT__DEFINED_DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__CONSTRAINTS = AGENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__KEYWORDS = AGENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Sub Class Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__SUB_CLASS_PROPERTIES = AGENT__SUB_CLASS_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Class Constant Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__CLASS_CONSTANT_VALUES = AGENT__CLASS_CONSTANT_VALUES;

	/**
	 * The feature id for the '<em><b>Geometric Representation Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__GEOMETRIC_REPRESENTATION_CONTEXT = AGENT__GEOMETRIC_REPRESENTATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Global Unit Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__GLOBAL_UNIT_CONTEXT = AGENT__GLOBAL_UNIT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Categorization Class Superclasses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__CATEGORIZATION_CLASS_SUPERCLASSES = AGENT__CATEGORIZATION_CLASS_SUPERCLASSES;

	/**
	 * The feature id for the '<em><b>Owned Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__OWNED_PORTS = AGENT__OWNED_PORTS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS__OWNER = AGENT__OWNER;

	/**
	 * The number of structural features of the '<em>Fieldbus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS_FEATURE_COUNT = AGENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fieldbus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELDBUS_OPERATION_COUNT = AGENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.RectangularConnectorSetImpl <em>Rectangular Connector Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.RectangularConnectorSetImpl
	 * @see epml.impl.EpmlPackageImpl#getRectangularConnectorSet()
	 * @generated
	 */
	int RECTANGULAR_CONNECTOR_SET = 9;

	/**
	 * The feature id for the '<em><b>Date Of Original Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__DATE_OF_ORIGINAL_DEFINITION = AGENT__DATE_OF_ORIGINAL_DEFINITION;

	/**
	 * The feature id for the '<em><b>Date Of Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__DATE_OF_CURRENT_VERSION = AGENT__DATE_OF_CURRENT_VERSION;

	/**
	 * The feature id for the '<em><b>Date Of Current Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__DATE_OF_CURRENT_REVISION = AGENT__DATE_OF_CURRENT_REVISION;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__REVISION = AGENT__REVISION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__STATUS = AGENT__STATUS;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__IS_DEPRECATED = AGENT__IS_DEPRECATED;

	/**
	 * The feature id for the '<em><b>Hierarchical Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__HIERARCHICAL_POSITION = AGENT__HIERARCHICAL_POSITION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__ID = AGENT__ID;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__TRANSLATION = AGENT__TRANSLATION;

	/**
	 * The feature id for the '<em><b>Source Language</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__SOURCE_LANGUAGE = AGENT__SOURCE_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Is Deprecated Interpretation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__IS_DEPRECATED_INTERPRETATION = AGENT__IS_DEPRECATED_INTERPRETATION;

	/**
	 * The feature id for the '<em><b>Preferred Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__PREFERRED_NAME = AGENT__PREFERRED_NAME;

	/**
	 * The feature id for the '<em><b>Synonymous Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__SYNONYMOUS_NAMES = AGENT__SYNONYMOUS_NAMES;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__SHORT_NAME = AGENT__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__ICON = AGENT__ICON;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__DEFINITION = AGENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Source Doc Of Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__SOURCE_DOC_OF_DEFINITION = AGENT__SOURCE_DOC_OF_DEFINITION;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__NOTE = AGENT__NOTE;

	/**
	 * The feature id for the '<em><b>Remark</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__REMARK = AGENT__REMARK;

	/**
	 * The feature id for the '<em><b>Its Superclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__ITS_SUPERCLASS = AGENT__ITS_SUPERCLASS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__DESCRIBED_BY = AGENT__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Defined Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__DEFINED_TYPES = AGENT__DEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Defined Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__DEFINED_DOCUMENTS = AGENT__DEFINED_DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__CONSTRAINTS = AGENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__KEYWORDS = AGENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Sub Class Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__SUB_CLASS_PROPERTIES = AGENT__SUB_CLASS_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Class Constant Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__CLASS_CONSTANT_VALUES = AGENT__CLASS_CONSTANT_VALUES;

	/**
	 * The feature id for the '<em><b>Geometric Representation Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__GEOMETRIC_REPRESENTATION_CONTEXT = AGENT__GEOMETRIC_REPRESENTATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Global Unit Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__GLOBAL_UNIT_CONTEXT = AGENT__GLOBAL_UNIT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Categorization Class Superclasses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__CATEGORIZATION_CLASS_SUPERCLASSES = AGENT__CATEGORIZATION_CLASS_SUPERCLASSES;

	/**
	 * The feature id for the '<em><b>Owned Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__OWNED_PORTS = AGENT__OWNED_PORTS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET__OWNER = AGENT__OWNER;

	/**
	 * The number of structural features of the '<em>Rectangular Connector Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET_FEATURE_COUNT = AGENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Rectangular Connector Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGULAR_CONNECTOR_SET_OPERATION_COUNT = AGENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.InductiveProximitySwitchImpl <em>Inductive Proximity Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.InductiveProximitySwitchImpl
	 * @see epml.impl.EpmlPackageImpl#getInductiveProximitySwitch()
	 * @generated
	 */
	int INDUCTIVE_PROXIMITY_SWITCH = 10;

	/**
	 * The feature id for the '<em><b>Date Of Original Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__DATE_OF_ORIGINAL_DEFINITION = AGENT__DATE_OF_ORIGINAL_DEFINITION;

	/**
	 * The feature id for the '<em><b>Date Of Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__DATE_OF_CURRENT_VERSION = AGENT__DATE_OF_CURRENT_VERSION;

	/**
	 * The feature id for the '<em><b>Date Of Current Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__DATE_OF_CURRENT_REVISION = AGENT__DATE_OF_CURRENT_REVISION;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__REVISION = AGENT__REVISION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__STATUS = AGENT__STATUS;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__IS_DEPRECATED = AGENT__IS_DEPRECATED;

	/**
	 * The feature id for the '<em><b>Hierarchical Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__HIERARCHICAL_POSITION = AGENT__HIERARCHICAL_POSITION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__ID = AGENT__ID;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__TRANSLATION = AGENT__TRANSLATION;

	/**
	 * The feature id for the '<em><b>Source Language</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__SOURCE_LANGUAGE = AGENT__SOURCE_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Is Deprecated Interpretation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__IS_DEPRECATED_INTERPRETATION = AGENT__IS_DEPRECATED_INTERPRETATION;

	/**
	 * The feature id for the '<em><b>Preferred Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__PREFERRED_NAME = AGENT__PREFERRED_NAME;

	/**
	 * The feature id for the '<em><b>Synonymous Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__SYNONYMOUS_NAMES = AGENT__SYNONYMOUS_NAMES;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__SHORT_NAME = AGENT__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__ICON = AGENT__ICON;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__DEFINITION = AGENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Source Doc Of Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__SOURCE_DOC_OF_DEFINITION = AGENT__SOURCE_DOC_OF_DEFINITION;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__NOTE = AGENT__NOTE;

	/**
	 * The feature id for the '<em><b>Remark</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__REMARK = AGENT__REMARK;

	/**
	 * The feature id for the '<em><b>Its Superclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__ITS_SUPERCLASS = AGENT__ITS_SUPERCLASS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__DESCRIBED_BY = AGENT__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Defined Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__DEFINED_TYPES = AGENT__DEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Defined Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__DEFINED_DOCUMENTS = AGENT__DEFINED_DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__CONSTRAINTS = AGENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__KEYWORDS = AGENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Sub Class Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__SUB_CLASS_PROPERTIES = AGENT__SUB_CLASS_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Class Constant Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__CLASS_CONSTANT_VALUES = AGENT__CLASS_CONSTANT_VALUES;

	/**
	 * The feature id for the '<em><b>Geometric Representation Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__GEOMETRIC_REPRESENTATION_CONTEXT = AGENT__GEOMETRIC_REPRESENTATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Global Unit Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__GLOBAL_UNIT_CONTEXT = AGENT__GLOBAL_UNIT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Categorization Class Superclasses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__CATEGORIZATION_CLASS_SUPERCLASSES = AGENT__CATEGORIZATION_CLASS_SUPERCLASSES;

	/**
	 * The feature id for the '<em><b>Owned Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__OWNED_PORTS = AGENT__OWNED_PORTS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH__OWNER = AGENT__OWNER;

	/**
	 * The number of structural features of the '<em>Inductive Proximity Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH_FEATURE_COUNT = AGENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Inductive Proximity Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDUCTIVE_PROXIMITY_SWITCH_OPERATION_COUNT = AGENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.CommunicationCableImpl <em>Communication Cable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.CommunicationCableImpl
	 * @see epml.impl.EpmlPackageImpl#getCommunicationCable()
	 * @generated
	 */
	int COMMUNICATION_CABLE = 11;

	/**
	 * The feature id for the '<em><b>Date Of Original Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__DATE_OF_ORIGINAL_DEFINITION = PLACE__DATE_OF_ORIGINAL_DEFINITION;

	/**
	 * The feature id for the '<em><b>Date Of Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__DATE_OF_CURRENT_VERSION = PLACE__DATE_OF_CURRENT_VERSION;

	/**
	 * The feature id for the '<em><b>Date Of Current Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__DATE_OF_CURRENT_REVISION = PLACE__DATE_OF_CURRENT_REVISION;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__REVISION = PLACE__REVISION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__STATUS = PLACE__STATUS;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__IS_DEPRECATED = PLACE__IS_DEPRECATED;

	/**
	 * The feature id for the '<em><b>Hierarchical Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__HIERARCHICAL_POSITION = PLACE__HIERARCHICAL_POSITION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__ID = PLACE__ID;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__TRANSLATION = PLACE__TRANSLATION;

	/**
	 * The feature id for the '<em><b>Source Language</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__SOURCE_LANGUAGE = PLACE__SOURCE_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Is Deprecated Interpretation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__IS_DEPRECATED_INTERPRETATION = PLACE__IS_DEPRECATED_INTERPRETATION;

	/**
	 * The feature id for the '<em><b>Preferred Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__PREFERRED_NAME = PLACE__PREFERRED_NAME;

	/**
	 * The feature id for the '<em><b>Synonymous Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__SYNONYMOUS_NAMES = PLACE__SYNONYMOUS_NAMES;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__SHORT_NAME = PLACE__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__ICON = PLACE__ICON;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__DEFINITION = PLACE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Source Doc Of Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__SOURCE_DOC_OF_DEFINITION = PLACE__SOURCE_DOC_OF_DEFINITION;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__NOTE = PLACE__NOTE;

	/**
	 * The feature id for the '<em><b>Remark</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__REMARK = PLACE__REMARK;

	/**
	 * The feature id for the '<em><b>Its Superclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__ITS_SUPERCLASS = PLACE__ITS_SUPERCLASS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__DESCRIBED_BY = PLACE__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Defined Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__DEFINED_TYPES = PLACE__DEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Defined Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__DEFINED_DOCUMENTS = PLACE__DEFINED_DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__CONSTRAINTS = PLACE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__KEYWORDS = PLACE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Sub Class Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__SUB_CLASS_PROPERTIES = PLACE__SUB_CLASS_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Class Constant Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__CLASS_CONSTANT_VALUES = PLACE__CLASS_CONSTANT_VALUES;

	/**
	 * The feature id for the '<em><b>Geometric Representation Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__GEOMETRIC_REPRESENTATION_CONTEXT = PLACE__GEOMETRIC_REPRESENTATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Global Unit Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__GLOBAL_UNIT_CONTEXT = PLACE__GLOBAL_UNIT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Categorization Class Superclasses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__CATEGORIZATION_CLASS_SUPERCLASSES = PLACE__CATEGORIZATION_CLASS_SUPERCLASSES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__NAME = PLACE__NAME;

	/**
	 * The feature id for the '<em><b>Its Output Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__ITS_OUTPUT_PORT = PLACE__ITS_OUTPUT_PORT;

	/**
	 * The feature id for the '<em><b>Its Input Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__ITS_INPUT_PORT = PLACE__ITS_INPUT_PORT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE__OWNER = PLACE__OWNER;

	/**
	 * The number of structural features of the '<em>Communication Cable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE_FEATURE_COUNT = PLACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Communication Cable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_CABLE_OPERATION_COUNT = PLACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.ReadyMadeDataCableImpl <em>Ready Made Data Cable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.ReadyMadeDataCableImpl
	 * @see epml.impl.EpmlPackageImpl#getReadyMadeDataCable()
	 * @generated
	 */
	int READY_MADE_DATA_CABLE = 12;

	/**
	 * The feature id for the '<em><b>Date Of Original Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__DATE_OF_ORIGINAL_DEFINITION = PLACE__DATE_OF_ORIGINAL_DEFINITION;

	/**
	 * The feature id for the '<em><b>Date Of Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__DATE_OF_CURRENT_VERSION = PLACE__DATE_OF_CURRENT_VERSION;

	/**
	 * The feature id for the '<em><b>Date Of Current Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__DATE_OF_CURRENT_REVISION = PLACE__DATE_OF_CURRENT_REVISION;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__REVISION = PLACE__REVISION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__STATUS = PLACE__STATUS;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__IS_DEPRECATED = PLACE__IS_DEPRECATED;

	/**
	 * The feature id for the '<em><b>Hierarchical Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__HIERARCHICAL_POSITION = PLACE__HIERARCHICAL_POSITION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__ID = PLACE__ID;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__TRANSLATION = PLACE__TRANSLATION;

	/**
	 * The feature id for the '<em><b>Source Language</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__SOURCE_LANGUAGE = PLACE__SOURCE_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Is Deprecated Interpretation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__IS_DEPRECATED_INTERPRETATION = PLACE__IS_DEPRECATED_INTERPRETATION;

	/**
	 * The feature id for the '<em><b>Preferred Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__PREFERRED_NAME = PLACE__PREFERRED_NAME;

	/**
	 * The feature id for the '<em><b>Synonymous Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__SYNONYMOUS_NAMES = PLACE__SYNONYMOUS_NAMES;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__SHORT_NAME = PLACE__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__ICON = PLACE__ICON;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__DEFINITION = PLACE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Source Doc Of Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__SOURCE_DOC_OF_DEFINITION = PLACE__SOURCE_DOC_OF_DEFINITION;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__NOTE = PLACE__NOTE;

	/**
	 * The feature id for the '<em><b>Remark</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__REMARK = PLACE__REMARK;

	/**
	 * The feature id for the '<em><b>Its Superclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__ITS_SUPERCLASS = PLACE__ITS_SUPERCLASS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__DESCRIBED_BY = PLACE__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Defined Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__DEFINED_TYPES = PLACE__DEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Defined Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__DEFINED_DOCUMENTS = PLACE__DEFINED_DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__CONSTRAINTS = PLACE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__KEYWORDS = PLACE__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Sub Class Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__SUB_CLASS_PROPERTIES = PLACE__SUB_CLASS_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Class Constant Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__CLASS_CONSTANT_VALUES = PLACE__CLASS_CONSTANT_VALUES;

	/**
	 * The feature id for the '<em><b>Geometric Representation Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__GEOMETRIC_REPRESENTATION_CONTEXT = PLACE__GEOMETRIC_REPRESENTATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Global Unit Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__GLOBAL_UNIT_CONTEXT = PLACE__GLOBAL_UNIT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Categorization Class Superclasses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__CATEGORIZATION_CLASS_SUPERCLASSES = PLACE__CATEGORIZATION_CLASS_SUPERCLASSES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__NAME = PLACE__NAME;

	/**
	 * The feature id for the '<em><b>Its Output Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__ITS_OUTPUT_PORT = PLACE__ITS_OUTPUT_PORT;

	/**
	 * The feature id for the '<em><b>Its Input Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__ITS_INPUT_PORT = PLACE__ITS_INPUT_PORT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE__OWNER = PLACE__OWNER;

	/**
	 * The number of structural features of the '<em>Ready Made Data Cable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE_FEATURE_COUNT = PLACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ready Made Data Cable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READY_MADE_DATA_CABLE_OPERATION_COUNT = PLACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.DCEngineImpl <em>DC Engine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.DCEngineImpl
	 * @see epml.impl.EpmlPackageImpl#getDCEngine()
	 * @generated
	 */
	int DC_ENGINE = 13;

	/**
	 * The feature id for the '<em><b>Date Of Original Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__DATE_OF_ORIGINAL_DEFINITION = AGENT__DATE_OF_ORIGINAL_DEFINITION;

	/**
	 * The feature id for the '<em><b>Date Of Current Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__DATE_OF_CURRENT_VERSION = AGENT__DATE_OF_CURRENT_VERSION;

	/**
	 * The feature id for the '<em><b>Date Of Current Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__DATE_OF_CURRENT_REVISION = AGENT__DATE_OF_CURRENT_REVISION;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__REVISION = AGENT__REVISION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__STATUS = AGENT__STATUS;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__IS_DEPRECATED = AGENT__IS_DEPRECATED;

	/**
	 * The feature id for the '<em><b>Hierarchical Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__HIERARCHICAL_POSITION = AGENT__HIERARCHICAL_POSITION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__ID = AGENT__ID;

	/**
	 * The feature id for the '<em><b>Translation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__TRANSLATION = AGENT__TRANSLATION;

	/**
	 * The feature id for the '<em><b>Source Language</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__SOURCE_LANGUAGE = AGENT__SOURCE_LANGUAGE;

	/**
	 * The feature id for the '<em><b>Is Deprecated Interpretation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__IS_DEPRECATED_INTERPRETATION = AGENT__IS_DEPRECATED_INTERPRETATION;

	/**
	 * The feature id for the '<em><b>Preferred Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__PREFERRED_NAME = AGENT__PREFERRED_NAME;

	/**
	 * The feature id for the '<em><b>Synonymous Names</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__SYNONYMOUS_NAMES = AGENT__SYNONYMOUS_NAMES;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__SHORT_NAME = AGENT__SHORT_NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__ICON = AGENT__ICON;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__DEFINITION = AGENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Source Doc Of Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__SOURCE_DOC_OF_DEFINITION = AGENT__SOURCE_DOC_OF_DEFINITION;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__NOTE = AGENT__NOTE;

	/**
	 * The feature id for the '<em><b>Remark</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__REMARK = AGENT__REMARK;

	/**
	 * The feature id for the '<em><b>Its Superclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__ITS_SUPERCLASS = AGENT__ITS_SUPERCLASS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__DESCRIBED_BY = AGENT__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Defined Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__DEFINED_TYPES = AGENT__DEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Defined Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__DEFINED_DOCUMENTS = AGENT__DEFINED_DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__CONSTRAINTS = AGENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__KEYWORDS = AGENT__KEYWORDS;

	/**
	 * The feature id for the '<em><b>Sub Class Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__SUB_CLASS_PROPERTIES = AGENT__SUB_CLASS_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Class Constant Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__CLASS_CONSTANT_VALUES = AGENT__CLASS_CONSTANT_VALUES;

	/**
	 * The feature id for the '<em><b>Geometric Representation Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__GEOMETRIC_REPRESENTATION_CONTEXT = AGENT__GEOMETRIC_REPRESENTATION_CONTEXT;

	/**
	 * The feature id for the '<em><b>Global Unit Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__GLOBAL_UNIT_CONTEXT = AGENT__GLOBAL_UNIT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Categorization Class Superclasses</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__CATEGORIZATION_CLASS_SUPERCLASSES = AGENT__CATEGORIZATION_CLASS_SUPERCLASSES;

	/**
	 * The feature id for the '<em><b>Owned Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__OWNED_PORTS = AGENT__OWNED_PORTS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE__OWNER = AGENT__OWNER;

	/**
	 * The number of structural features of the '<em>DC Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE_FEATURE_COUNT = AGENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>DC Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DC_ENGINE_OPERATION_COUNT = AGENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link epml.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see epml.impl.SystemImpl
	 * @see epml.impl.EpmlPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 14;

	/**
	 * The feature id for the '<em><b>Is Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__IS_COMPLETE = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__IS_COMPLETE;

	/**
	 * The feature id for the '<em><b>Update Agreement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__UPDATE_AGREEMENT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__UPDATE_AGREEMENT;

	/**
	 * The feature id for the '<em><b>Updates</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__UPDATES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__UPDATES;

	/**
	 * The feature id for the '<em><b>Referenced Dictionaries</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__REFERENCED_DICTIONARIES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__REFERENCED_DICTIONARIES;

	/**
	 * The feature id for the '<em><b>Responsible Supplier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__RESPONSIBLE_SUPPLIER = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__RESPONSIBLE_SUPPLIER;

	/**
	 * The feature id for the '<em><b>Contained Classes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CONTAINED_CLASSES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__CONTAINED_CLASSES;

	/**
	 * The feature id for the '<em><b>APosteriori Semantic Relationships</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__APOSTERIORI_SEMANTIC_RELATIONSHIPS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__APOSTERIORI_SEMANTIC_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Contained Suppliers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CONTAINED_SUPPLIERS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__CONTAINED_SUPPLIERS;

	/**
	 * The feature id for the '<em><b>Contained Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CONTAINED_PROPERTIES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__CONTAINED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Contained Documents</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CONTAINED_DOCUMENTS = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__CONTAINED_DOCUMENTS;

	/**
	 * The feature id for the '<em><b>Contained Datatypes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__CONTAINED_DATATYPES = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY__CONTAINED_DATATYPES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OWNED_APPLICATION = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.DICTIONARY_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link epml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see epml.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link epml.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see epml.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link epml.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see epml.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for the containment reference list '{@link epml.Application#getOwnedAgents <em>Owned Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Agents</em>'.
	 * @see epml.Application#getOwnedAgents()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_OwnedAgents();

	/**
	 * Returns the meta object for the containment reference list '{@link epml.Application#getOwnedPlaces <em>Owned Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Places</em>'.
	 * @see epml.Application#getOwnedPlaces()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_OwnedPlaces();

	/**
	 * Returns the meta object for class '{@link epml.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Agent</em>'.
	 * @see epml.Agent
	 * @generated
	 */
	EClass getAgent();

	/**
	 * Returns the meta object for the containment reference list '{@link epml.Agent#getOwnedPorts <em>Owned Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Ports</em>'.
	 * @see epml.Agent#getOwnedPorts()
	 * @see #getAgent()
	 * @generated
	 */
	EReference getAgent_OwnedPorts();

	/**
	 * Returns the meta object for the container reference '{@link epml.Agent#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see epml.Agent#getOwner()
	 * @see #getAgent()
	 * @generated
	 */
	EReference getAgent_Owner();

	/**
	 * Returns the meta object for class '{@link epml.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see epml.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the container reference '{@link epml.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see epml.Port#getOwner()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Owner();

	/**
	 * Returns the meta object for class '{@link epml.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Port</em>'.
	 * @see epml.InputPort
	 * @generated
	 */
	EClass getInputPort();

	/**
	 * Returns the meta object for class '{@link epml.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Port</em>'.
	 * @see epml.OutputPort
	 * @generated
	 */
	EClass getOutputPort();

	/**
	 * Returns the meta object for class '{@link epml.Place <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Place</em>'.
	 * @see epml.Place
	 * @generated
	 */
	EClass getPlace();

	/**
	 * Returns the meta object for the reference '{@link epml.Place#getItsOutputPort <em>Its Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Its Output Port</em>'.
	 * @see epml.Place#getItsOutputPort()
	 * @see #getPlace()
	 * @generated
	 */
	EReference getPlace_ItsOutputPort();

	/**
	 * Returns the meta object for the reference '{@link epml.Place#getItsInputPort <em>Its Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Its Input Port</em>'.
	 * @see epml.Place#getItsInputPort()
	 * @see #getPlace()
	 * @generated
	 */
	EReference getPlace_ItsInputPort();

	/**
	 * Returns the meta object for the container reference '{@link epml.Place#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see epml.Place#getOwner()
	 * @see #getPlace()
	 * @generated
	 */
	EReference getPlace_Owner();

	/**
	 * Returns the meta object for class '{@link epml.PCBasedControls <em>PC Based Controls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PC Based Controls</em>'.
	 * @see epml.PCBasedControls
	 * @generated
	 */
	EClass getPCBasedControls();

	/**
	 * Returns the meta object for class '{@link epml.Fieldbus <em>Fieldbus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fieldbus</em>'.
	 * @see epml.Fieldbus
	 * @generated
	 */
	EClass getFieldbus();

	/**
	 * Returns the meta object for class '{@link epml.RectangularConnectorSet <em>Rectangular Connector Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangular Connector Set</em>'.
	 * @see epml.RectangularConnectorSet
	 * @generated
	 */
	EClass getRectangularConnectorSet();

	/**
	 * Returns the meta object for class '{@link epml.InductiveProximitySwitch <em>Inductive Proximity Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inductive Proximity Switch</em>'.
	 * @see epml.InductiveProximitySwitch
	 * @generated
	 */
	EClass getInductiveProximitySwitch();

	/**
	 * Returns the meta object for class '{@link epml.CommunicationCable <em>Communication Cable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Cable</em>'.
	 * @see epml.CommunicationCable
	 * @generated
	 */
	EClass getCommunicationCable();

	/**
	 * Returns the meta object for class '{@link epml.ReadyMadeDataCable <em>Ready Made Data Cable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ready Made Data Cable</em>'.
	 * @see epml.ReadyMadeDataCable
	 * @generated
	 */
	EClass getReadyMadeDataCable();

	/**
	 * Returns the meta object for class '{@link epml.DCEngine <em>DC Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DC Engine</em>'.
	 * @see epml.DCEngine
	 * @generated
	 */
	EClass getDCEngine();

	/**
	 * Returns the meta object for class '{@link epml.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see epml.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference '{@link epml.System#getOwnedApplication <em>Owned Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Application</em>'.
	 * @see epml.System#getOwnedApplication()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_OwnedApplication();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EpmlFactory getEpmlFactory();

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
		 * The meta object literal for the '{@link epml.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.NamedElementImpl
		 * @see epml.impl.EpmlPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link epml.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.ApplicationImpl
		 * @see epml.impl.EpmlPackageImpl#getApplication()
		 * @generated
		 */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
		 * The meta object literal for the '<em><b>Owned Agents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__OWNED_AGENTS = eINSTANCE.getApplication_OwnedAgents();

		/**
		 * The meta object literal for the '<em><b>Owned Places</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__OWNED_PLACES = eINSTANCE.getApplication_OwnedPlaces();

		/**
		 * The meta object literal for the '{@link epml.impl.AgentImpl <em>Agent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.AgentImpl
		 * @see epml.impl.EpmlPackageImpl#getAgent()
		 * @generated
		 */
		EClass AGENT = eINSTANCE.getAgent();

		/**
		 * The meta object literal for the '<em><b>Owned Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT__OWNED_PORTS = eINSTANCE.getAgent_OwnedPorts();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT__OWNER = eINSTANCE.getAgent_Owner();

		/**
		 * The meta object literal for the '{@link epml.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.PortImpl
		 * @see epml.impl.EpmlPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__OWNER = eINSTANCE.getPort_Owner();

		/**
		 * The meta object literal for the '{@link epml.impl.InputPortImpl <em>Input Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.InputPortImpl
		 * @see epml.impl.EpmlPackageImpl#getInputPort()
		 * @generated
		 */
		EClass INPUT_PORT = eINSTANCE.getInputPort();

		/**
		 * The meta object literal for the '{@link epml.impl.OutputPortImpl <em>Output Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.OutputPortImpl
		 * @see epml.impl.EpmlPackageImpl#getOutputPort()
		 * @generated
		 */
		EClass OUTPUT_PORT = eINSTANCE.getOutputPort();

		/**
		 * The meta object literal for the '{@link epml.impl.PlaceImpl <em>Place</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.PlaceImpl
		 * @see epml.impl.EpmlPackageImpl#getPlace()
		 * @generated
		 */
		EClass PLACE = eINSTANCE.getPlace();

		/**
		 * The meta object literal for the '<em><b>Its Output Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE__ITS_OUTPUT_PORT = eINSTANCE.getPlace_ItsOutputPort();

		/**
		 * The meta object literal for the '<em><b>Its Input Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE__ITS_INPUT_PORT = eINSTANCE.getPlace_ItsInputPort();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE__OWNER = eINSTANCE.getPlace_Owner();

		/**
		 * The meta object literal for the '{@link epml.impl.PCBasedControlsImpl <em>PC Based Controls</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.PCBasedControlsImpl
		 * @see epml.impl.EpmlPackageImpl#getPCBasedControls()
		 * @generated
		 */
		EClass PC_BASED_CONTROLS = eINSTANCE.getPCBasedControls();

		/**
		 * The meta object literal for the '{@link epml.impl.FieldbusImpl <em>Fieldbus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.FieldbusImpl
		 * @see epml.impl.EpmlPackageImpl#getFieldbus()
		 * @generated
		 */
		EClass FIELDBUS = eINSTANCE.getFieldbus();

		/**
		 * The meta object literal for the '{@link epml.impl.RectangularConnectorSetImpl <em>Rectangular Connector Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.RectangularConnectorSetImpl
		 * @see epml.impl.EpmlPackageImpl#getRectangularConnectorSet()
		 * @generated
		 */
		EClass RECTANGULAR_CONNECTOR_SET = eINSTANCE.getRectangularConnectorSet();

		/**
		 * The meta object literal for the '{@link epml.impl.InductiveProximitySwitchImpl <em>Inductive Proximity Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.InductiveProximitySwitchImpl
		 * @see epml.impl.EpmlPackageImpl#getInductiveProximitySwitch()
		 * @generated
		 */
		EClass INDUCTIVE_PROXIMITY_SWITCH = eINSTANCE.getInductiveProximitySwitch();

		/**
		 * The meta object literal for the '{@link epml.impl.CommunicationCableImpl <em>Communication Cable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.CommunicationCableImpl
		 * @see epml.impl.EpmlPackageImpl#getCommunicationCable()
		 * @generated
		 */
		EClass COMMUNICATION_CABLE = eINSTANCE.getCommunicationCable();

		/**
		 * The meta object literal for the '{@link epml.impl.ReadyMadeDataCableImpl <em>Ready Made Data Cable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.ReadyMadeDataCableImpl
		 * @see epml.impl.EpmlPackageImpl#getReadyMadeDataCable()
		 * @generated
		 */
		EClass READY_MADE_DATA_CABLE = eINSTANCE.getReadyMadeDataCable();

		/**
		 * The meta object literal for the '{@link epml.impl.DCEngineImpl <em>DC Engine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.DCEngineImpl
		 * @see epml.impl.EpmlPackageImpl#getDCEngine()
		 * @generated
		 */
		EClass DC_ENGINE = eINSTANCE.getDCEngine();

		/**
		 * The meta object literal for the '{@link epml.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see epml.impl.SystemImpl
		 * @see epml.impl.EpmlPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Owned Application</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__OWNED_APPLICATION = eINSTANCE.getSystem_OwnedApplication();

	}

} //EpmlPackage
