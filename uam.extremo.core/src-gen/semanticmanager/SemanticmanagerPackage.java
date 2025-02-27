/**
 */
package semanticmanager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
	 * The feature id for the '<em><b>Constraint Interpreters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER__CONSTRAINT_INTERPRETERS = 2;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER__SERVICES = 3;

	/**
	 * The feature id for the '<em><b>Format Assistants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER__FORMAT_ASSISTANTS = 4;

	/**
	 * The feature id for the '<em><b>Model Persistences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER__MODEL_PERSISTENCES = 5;

	/**
	 * The number of structural features of the '<em>Repository Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Repository Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ConstraintImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 1;

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
	 * The feature id for the '<em><b>Interpreter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__INTERPRETER = 5;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.ConstraintInterpreterImpl <em>Constraint Interpreter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ConstraintInterpreterImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getConstraintInterpreter()
	 * @generated
	 */
	int CONSTRAINT_INTERPRETER = 2;

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
	 * The feature id for the '<em><b>Evals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INTERPRETER__EVALS = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INTERPRETER__TYPE = 4;

	/**
	 * The number of structural features of the '<em>Constraint Interpreter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INTERPRETER_FEATURE_COUNT = 5;

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
	 * The meta object id for the '{@link semanticmanager.impl.ConstraintResultImpl <em>Constraint Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ConstraintResultImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getConstraintResult()
	 * @generated
	 */
	int CONSTRAINT_RESULT = 3;

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
	 * The meta object id for the '{@link semanticmanager.impl.SearchParamImpl <em>Search Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SearchParamImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchParam()
	 * @generated
	 */
	int SEARCH_PARAM = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_PARAM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_PARAM__ID = 1;

	/**
	 * The number of structural features of the '<em>Search Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_PARAM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Search Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_PARAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SearchResultImpl <em>Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SearchResultImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchResult()
	 * @generated
	 */
	int SEARCH_RESULT = 5;

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
	 * The number of structural features of the '<em>Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SearchParamValueImpl <em>Search Param Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SearchParamValueImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchParamValue()
	 * @generated
	 */
	int SEARCH_PARAM_VALUE = 6;

	/**
	 * The number of structural features of the '<em>Search Param Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_PARAM_VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Search Param Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_PARAM_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SearchConfigurationImpl <em>Search Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SearchConfigurationImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchConfiguration()
	 * @generated
	 */
	int SEARCH_CONFIGURATION = 7;

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
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION__RESULTS = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SimpleSearchConfigurationImpl <em>Simple Search Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SimpleSearchConfigurationImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSimpleSearchConfiguration()
	 * @generated
	 */
	int SIMPLE_SEARCH_CONFIGURATION = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION__ID = SEARCH_CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION__NAME = SEARCH_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION__RESULTS = SEARCH_CONFIGURATION__RESULTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION__DESCRIPTION = SEARCH_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION__OPTIONS = SEARCH_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION_FEATURE_COUNT = SEARCH_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Add Primitive Type Search Option</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION___ADD_PRIMITIVE_TYPE_SEARCH_OPTION__STRING_STRING_TYPE = SEARCH_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Add Data Model Type Search Option</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION___ADD_DATA_MODEL_TYPE_SEARCH_OPTION__STRING_STRING_DATAMODELTYPE = SEARCH_CONFIGURATION_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION___INIT__ELIST = SEARCH_CONFIGURATION_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Param Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION___GET_PARAM_VALUE__STRING_ELIST = SEARCH_CONFIGURATION_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Service For Param Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION___GET_SERVICE_FOR_PARAM_VALUE__STRING_ELIST = SEARCH_CONFIGURATION_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Simple Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT = SEARCH_CONFIGURATION_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.CompositeSearchConfigurationImpl <em>Composite Search Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.CompositeSearchConfigurationImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getCompositeSearchConfiguration()
	 * @generated
	 */
	int COMPOSITE_SEARCH_CONFIGURATION = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__ID = SEARCH_CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__NAME = SEARCH_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__RESULTS = SEARCH_CONFIGURATION__RESULTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__DESCRIPTION = SEARCH_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__TYPE = SEARCH_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Search Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__SEARCH_CONFIGURATIONS = SEARCH_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Search Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__INPUT_SEARCH_RESULTS = SEARCH_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION_FEATURE_COUNT = SEARCH_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Search</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION___SEARCH__SEARCHRESULT = SEARCH_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Composite Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION_OPERATION_COUNT = SEARCH_CONFIGURATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ServiceImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Filter By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__FILTER_BY = 2;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE___MATCHES__STRING_STRING = 0;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.CustomSearchImpl <em>Custom Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.CustomSearchImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getCustomSearch()
	 * @generated
	 */
	int CUSTOM_SEARCH = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH__ID = SIMPLE_SEARCH_CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH__NAME = SIMPLE_SEARCH_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH__RESULTS = SIMPLE_SEARCH_CONFIGURATION__RESULTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH__DESCRIPTION = SIMPLE_SEARCH_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH__OPTIONS = SIMPLE_SEARCH_CONFIGURATION__OPTIONS;

	/**
	 * The feature id for the '<em><b>Grouped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH__GROUPED = SIMPLE_SEARCH_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Custom Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH_FEATURE_COUNT = SIMPLE_SEARCH_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Add Primitive Type Search Option</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH___ADD_PRIMITIVE_TYPE_SEARCH_OPTION__STRING_STRING_TYPE = SIMPLE_SEARCH_CONFIGURATION___ADD_PRIMITIVE_TYPE_SEARCH_OPTION__STRING_STRING_TYPE;

	/**
	 * The operation id for the '<em>Add Data Model Type Search Option</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH___ADD_DATA_MODEL_TYPE_SEARCH_OPTION__STRING_STRING_DATAMODELTYPE = SIMPLE_SEARCH_CONFIGURATION___ADD_DATA_MODEL_TYPE_SEARCH_OPTION__STRING_STRING_DATAMODELTYPE;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH___INIT__ELIST = SIMPLE_SEARCH_CONFIGURATION___INIT__ELIST;

	/**
	 * The operation id for the '<em>Get Param Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH___GET_PARAM_VALUE__STRING_ELIST = SIMPLE_SEARCH_CONFIGURATION___GET_PARAM_VALUE__STRING_ELIST;

	/**
	 * The operation id for the '<em>Get Service For Param Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH___GET_SERVICE_FOR_PARAM_VALUE__STRING_ELIST = SIMPLE_SEARCH_CONFIGURATION___GET_SERVICE_FOR_PARAM_VALUE__STRING_ELIST;

	/**
	 * The operation id for the '<em>Search</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH___SEARCH__REPOSITORY_SEARCHRESULT = SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Custom Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH_OPERATION_COUNT = SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.PredicateBasedSearchImpl <em>Predicate Based Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.PredicateBasedSearchImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getPredicateBasedSearch()
	 * @generated
	 */
	int PREDICATE_BASED_SEARCH = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH__ID = SIMPLE_SEARCH_CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH__NAME = SIMPLE_SEARCH_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH__RESULTS = SIMPLE_SEARCH_CONFIGURATION__RESULTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH__DESCRIPTION = SIMPLE_SEARCH_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH__OPTIONS = SIMPLE_SEARCH_CONFIGURATION__OPTIONS;

	/**
	 * The number of structural features of the '<em>Predicate Based Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH_FEATURE_COUNT = SIMPLE_SEARCH_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Add Primitive Type Search Option</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH___ADD_PRIMITIVE_TYPE_SEARCH_OPTION__STRING_STRING_TYPE = SIMPLE_SEARCH_CONFIGURATION___ADD_PRIMITIVE_TYPE_SEARCH_OPTION__STRING_STRING_TYPE;

	/**
	 * The operation id for the '<em>Add Data Model Type Search Option</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH___ADD_DATA_MODEL_TYPE_SEARCH_OPTION__STRING_STRING_DATAMODELTYPE = SIMPLE_SEARCH_CONFIGURATION___ADD_DATA_MODEL_TYPE_SEARCH_OPTION__STRING_STRING_DATAMODELTYPE;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH___INIT__ELIST = SIMPLE_SEARCH_CONFIGURATION___INIT__ELIST;

	/**
	 * The operation id for the '<em>Get Param Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH___GET_PARAM_VALUE__STRING_ELIST = SIMPLE_SEARCH_CONFIGURATION___GET_PARAM_VALUE__STRING_ELIST;

	/**
	 * The operation id for the '<em>Get Service For Param Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH___GET_SERVICE_FOR_PARAM_VALUE__STRING_ELIST = SIMPLE_SEARCH_CONFIGURATION___GET_SERVICE_FOR_PARAM_VALUE__STRING_ELIST;

	/**
	 * The operation id for the '<em>Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH___MATCHES__NAMEDELEMENT = SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Predicate Based Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH_OPERATION_COUNT = SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.AtomicSearchResultImpl <em>Atomic Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.AtomicSearchResultImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getAtomicSearchResult()
	 * @generated
	 */
	int ATOMIC_SEARCH_RESULT = 13;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_SEARCH_RESULT__VALUES = SEARCH_RESULT__VALUES;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_SEARCH_RESULT__CONFIGURATION = SEARCH_RESULT__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_SEARCH_RESULT__ELEMENTS = SEARCH_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Atomic Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_SEARCH_RESULT_FEATURE_COUNT = SEARCH_RESULT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Atomic Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_SEARCH_RESULT_OPERATION_COUNT = SEARCH_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.GroupedSearchResultImpl <em>Grouped Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.GroupedSearchResultImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getGroupedSearchResult()
	 * @generated
	 */
	int GROUPED_SEARCH_RESULT = 14;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT__VALUES = SEARCH_RESULT__VALUES;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT__CONFIGURATION = SEARCH_RESULT__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT__GROUPS = SEARCH_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Grouped Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT_FEATURE_COUNT = SEARCH_RESULT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Create Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___CREATE_SEMANTIC_GROUP__STRING_STRING = SEARCH_RESULT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Add Named Element To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___ADD_NAMED_ELEMENT_TO_SEMANTIC_GROUP__SEMANTICGROUP_NAMEDELEMENT = SEARCH_RESULT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Grouped Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT_OPERATION_COUNT = SEARCH_RESULT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.NamedElementImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 19;

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
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__TRACE = 3;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DRAWN = 4;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DESCRIPTORS = 5;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DESCRIBES = 6;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__CONSTRAINTS = 7;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__METADATA = 8;

	/**
	 * The feature id for the '<em><b>Supers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__SUPERS = 9;

	/**
	 * The feature id for the '<em><b>Subs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__SUBS = 10;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SemanticGroupImpl <em>Semantic Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SemanticGroupImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSemanticGroup()
	 * @generated
	 */
	int SEMANTIC_GROUP = 15;

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
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__TRACE = NAMED_ELEMENT__TRACE;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__DRAWN = NAMED_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__DESCRIPTORS = NAMED_ELEMENT__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__DESCRIBES = NAMED_ELEMENT__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__CONSTRAINTS = NAMED_ELEMENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__METADATA = NAMED_ELEMENT__METADATA;

	/**
	 * The feature id for the '<em><b>Supers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__SUPERS = NAMED_ELEMENT__SUPERS;

	/**
	 * The feature id for the '<em><b>Subs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__SUBS = NAMED_ELEMENT__SUBS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link semanticmanager.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.RepositoryImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 16;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__RESOURCES = 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__NAME = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.ResourceElementImpl <em>Resource Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ResourceElementImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getResourceElement()
	 * @generated
	 */
	int RESOURCE_ELEMENT = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__WEIGHT = NAMED_ELEMENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__TRACE = NAMED_ELEMENT__TRACE;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__DRAWN = NAMED_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__DESCRIPTORS = NAMED_ELEMENT__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__DESCRIBES = NAMED_ELEMENT__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__CONSTRAINTS = NAMED_ELEMENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__METADATA = NAMED_ELEMENT__METADATA;

	/**
	 * The feature id for the '<em><b>Supers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__SUPERS = NAMED_ELEMENT__SUPERS;

	/**
	 * The feature id for the '<em><b>Subs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__SUBS = NAMED_ELEMENT__SUBS;

	/**
	 * The feature id for the '<em><b>Resource From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT__RESOURCE_FROM = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ResourceImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = RESOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DESCRIPTION = RESOURCE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__WEIGHT = RESOURCE_ELEMENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__TRACE = RESOURCE_ELEMENT__TRACE;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DRAWN = RESOURCE_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DESCRIPTORS = RESOURCE_ELEMENT__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DESCRIBES = RESOURCE_ELEMENT__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__CONSTRAINTS = RESOURCE_ELEMENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__METADATA = RESOURCE_ELEMENT__METADATA;

	/**
	 * The feature id for the '<em><b>Supers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__SUPERS = RESOURCE_ELEMENT__SUPERS;

	/**
	 * The feature id for the '<em><b>Subs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__SUBS = RESOURCE_ELEMENT__SUBS;

	/**
	 * The feature id for the '<em><b>Resource From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__RESOURCE_FROM = RESOURCE_ELEMENT__RESOURCE_FROM;

	/**
	 * The feature id for the '<em><b>Resource Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__RESOURCE_ELEMENTS = RESOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__URI = RESOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Repository From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__REPOSITORY_FROM = RESOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Constraint Interpreter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEFAULT_CONSTRAINT_INTERPRETER = RESOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Assistant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ASSISTANT = RESOURCE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Guard Semantic Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__GUARD_SEMANTIC_NODES = RESOURCE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = RESOURCE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = RESOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.SemanticNodeImpl <em>Semantic Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.SemanticNodeImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSemanticNode()
	 * @generated
	 */
	int SEMANTIC_NODE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__NAME = RESOURCE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__DESCRIPTION = RESOURCE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__WEIGHT = RESOURCE_ELEMENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__TRACE = RESOURCE_ELEMENT__TRACE;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__DRAWN = RESOURCE_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__DESCRIPTORS = RESOURCE_ELEMENT__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__DESCRIBES = RESOURCE_ELEMENT__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__CONSTRAINTS = RESOURCE_ELEMENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__METADATA = RESOURCE_ELEMENT__METADATA;

	/**
	 * The feature id for the '<em><b>Supers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__SUPERS = RESOURCE_ELEMENT__SUPERS;

	/**
	 * The feature id for the '<em><b>Subs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__SUBS = RESOURCE_ELEMENT__SUBS;

	/**
	 * The feature id for the '<em><b>Resource From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__RESOURCE_FROM = RESOURCE_ELEMENT__RESOURCE_FROM;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__PROPERTIES = RESOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__ABSTRACT = RESOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE__DOMAIN = RESOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Semantic Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE_FEATURE_COUNT = RESOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Semantic Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_NODE_OPERATION_COUNT = RESOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.PropertyImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 20;

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
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TRACE = NAMED_ELEMENT__TRACE;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DRAWN = NAMED_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DESCRIPTORS = NAMED_ELEMENT__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DESCRIBES = NAMED_ELEMENT__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__CONSTRAINTS = NAMED_ELEMENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__METADATA = NAMED_ELEMENT__METADATA;

	/**
	 * The feature id for the '<em><b>Supers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__SUPERS = NAMED_ELEMENT__SUPERS;

	/**
	 * The feature id for the '<em><b>Subs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__SUBS = NAMED_ELEMENT__SUBS;

	/**
	 * The feature id for the '<em><b>Semantic Node From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__SEMANTIC_NODE_FROM = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__LOWER_BOUND = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UPPER_BOUND = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

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
	int OBJECT_PROPERTY = 21;

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
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__TRACE = PROPERTY__TRACE;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__DRAWN = PROPERTY__DRAWN;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__DESCRIPTORS = PROPERTY__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__DESCRIBES = PROPERTY__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__CONSTRAINTS = PROPERTY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__METADATA = PROPERTY__METADATA;

	/**
	 * The feature id for the '<em><b>Supers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__SUPERS = PROPERTY__SUPERS;

	/**
	 * The feature id for the '<em><b>Subs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__SUBS = PROPERTY__SUBS;

	/**
	 * The feature id for the '<em><b>Semantic Node From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__SEMANTIC_NODE_FROM = PROPERTY__SEMANTIC_NODE_FROM;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__LOWER_BOUND = PROPERTY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__UPPER_BOUND = PROPERTY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Range</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__RANGE = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inverse Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY__INVERSE_OF = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 2;

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
	int DATA_PROPERTY = 22;

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
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__TRACE = PROPERTY__TRACE;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__DRAWN = PROPERTY__DRAWN;

	/**
	 * The feature id for the '<em><b>Descriptors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__DESCRIPTORS = PROPERTY__DESCRIPTORS;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__DESCRIBES = PROPERTY__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__CONSTRAINTS = PROPERTY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__METADATA = PROPERTY__METADATA;

	/**
	 * The feature id for the '<em><b>Supers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__SUPERS = PROPERTY__SUPERS;

	/**
	 * The feature id for the '<em><b>Subs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__SUBS = PROPERTY__SUBS;

	/**
	 * The feature id for the '<em><b>Semantic Node From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__SEMANTIC_NODE_FROM = PROPERTY__SEMANTIC_NODE_FROM;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__LOWER_BOUND = PROPERTY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__UPPER_BOUND = PROPERTY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__TYPE = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY__VALUE = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROPERTY_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.MetaDataImpl <em>Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.MetaDataImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getMetaData()
	 * @generated
	 */
	int META_DATA = 23;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.PrimitiveTypeParamImpl <em>Primitive Type Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.PrimitiveTypeParamImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getPrimitiveTypeParam()
	 * @generated
	 */
	int PRIMITIVE_TYPE_PARAM = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM__NAME = SEARCH_PARAM__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM__ID = SEARCH_PARAM__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM__TYPE = SEARCH_PARAM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM_FEATURE_COUNT = SEARCH_PARAM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive Type Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM_OPERATION_COUNT = SEARCH_PARAM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.ModelTypeParamImpl <em>Model Type Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ModelTypeParamImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getModelTypeParam()
	 * @generated
	 */
	int MODEL_TYPE_PARAM = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM__NAME = SEARCH_PARAM__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM__ID = SEARCH_PARAM__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM__TYPE = SEARCH_PARAM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Type Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM_FEATURE_COUNT = SEARCH_PARAM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Model Type Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM_OPERATION_COUNT = SEARCH_PARAM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.ModelTypeParamValueImpl <em>Model Type Param Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ModelTypeParamValueImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getModelTypeParamValue()
	 * @generated
	 */
	int MODEL_TYPE_PARAM_VALUE = 27;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM_VALUE__VALUE = SEARCH_PARAM_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model Type Param Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM_VALUE_FEATURE_COUNT = SEARCH_PARAM_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Model Type Param Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM_VALUE_OPERATION_COUNT = SEARCH_PARAM_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.PrimitiveTypeParamValueImpl <em>Primitive Type Param Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.PrimitiveTypeParamValueImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getPrimitiveTypeParamValue()
	 * @generated
	 */
	int PRIMITIVE_TYPE_PARAM_VALUE = 28;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM_VALUE__VALUE = SEARCH_PARAM_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Calls</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM_VALUE__CALLS = SEARCH_PARAM_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Primitive Type Param Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM_VALUE_FEATURE_COUNT = SEARCH_PARAM_VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Primitive Type Param Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM_VALUE_OPERATION_COUNT = SEARCH_PARAM_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.FormatAssistantImpl <em>Format Assistant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.FormatAssistantImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getFormatAssistant()
	 * @generated
	 */
	int FORMAT_ASSISTANT = 29;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT__EXTENSIONS = 2;

	/**
	 * The feature id for the '<em><b>Interpreter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT__INTERPRETER = 3;

	/**
	 * The feature id for the '<em><b>Constraint Interpreter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT__CONSTRAINT_INTERPRETER = 4;

	/**
	 * The number of structural features of the '<em>Format Assistant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Load And Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT___LOAD_AND_VALIDATE__RESOURCE_CONSTRAINTINTERPRETER = 0;

	/**
	 * The operation id for the '<em>To Data Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT___TO_DATA_PROPERTY__SEMANTICNODE = 1;

	/**
	 * The operation id for the '<em>To Object Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT___TO_OBJECT_PROPERTY__SEMANTICNODE = 2;

	/**
	 * The operation id for the '<em>To Super</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT___TO_SUPER__SEMANTICNODE = 3;

	/**
	 * The operation id for the '<em>To Super</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT___TO_SUPER__DATAPROPERTY = 4;

	/**
	 * The operation id for the '<em>To Super</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT___TO_SUPER__OBJECTPROPERTY = 5;

	/**
	 * The operation id for the '<em>To Inverse Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT___TO_INVERSE_OF__OBJECTPROPERTY = 6;

	/**
	 * The number of operations of the '<em>Format Assistant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAT_ASSISTANT_OPERATION_COUNT = 7;

	/**
	 * The meta object id for the '{@link semanticmanager.impl.ModelPersistenceImpl <em>Model Persistence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.impl.ModelPersistenceImpl
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getModelPersistence()
	 * @generated
	 */
	int MODEL_PERSISTENCE = 30;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PERSISTENCE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PERSISTENCE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Model Persistence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PERSISTENCE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Load</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PERSISTENCE___LOAD__STRING = 0;

	/**
	 * The operation id for the '<em>Save</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PERSISTENCE___SAVE = 1;

	/**
	 * The operation id for the '<em>Add Content</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PERSISTENCE___ADD_CONTENT__REPOSITORYMANAGER = 2;

	/**
	 * The operation id for the '<em>Get Content</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PERSISTENCE___GET_CONTENT = 3;

	/**
	 * The number of operations of the '<em>Model Persistence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_PERSISTENCE_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link semanticmanager.ConnectionType <em>Connection Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.ConnectionType
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getConnectionType()
	 * @generated
	 */
	int CONNECTION_TYPE = 31;

	/**
	 * The meta object id for the '{@link semanticmanager.DataModelType <em>Data Model Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.DataModelType
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getDataModelType()
	 * @generated
	 */
	int DATA_MODEL_TYPE = 32;

	/**
	 * The meta object id for the '{@link semanticmanager.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.Type
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 33;

	/**
	 * The meta object id for the '<em>Java Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getJavaObject()
	 * @generated
	 */
	int JAVA_OBJECT = 34;


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
	 * Returns the meta object for the containment reference list '{@link semanticmanager.RepositoryManager#getConstraintInterpreters <em>Constraint Interpreters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint Interpreters</em>'.
	 * @see semanticmanager.RepositoryManager#getConstraintInterpreters()
	 * @see #getRepositoryManager()
	 * @generated
	 */
	EReference getRepositoryManager_ConstraintInterpreters();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.RepositoryManager#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see semanticmanager.RepositoryManager#getServices()
	 * @see #getRepositoryManager()
	 * @generated
	 */
	EReference getRepositoryManager_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.RepositoryManager#getFormatAssistants <em>Format Assistants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Format Assistants</em>'.
	 * @see semanticmanager.RepositoryManager#getFormatAssistants()
	 * @see #getRepositoryManager()
	 * @generated
	 */
	EReference getRepositoryManager_FormatAssistants();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.RepositoryManager#getModelPersistences <em>Model Persistences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Persistences</em>'.
	 * @see semanticmanager.RepositoryManager#getModelPersistences()
	 * @see #getRepositoryManager()
	 * @generated
	 */
	EReference getRepositoryManager_ModelPersistences();

	/**
	 * Returns the meta object for class '{@link semanticmanager.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see semanticmanager.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Constraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see semanticmanager.Constraint#getType()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Type();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Constraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.Constraint#getName()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Name();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Constraint#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see semanticmanager.Constraint#getBody()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Body();

	/**
	 * Returns the meta object for the container reference '{@link semanticmanager.Constraint#getAppliedTo <em>Applied To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Applied To</em>'.
	 * @see semanticmanager.Constraint#getAppliedTo()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_AppliedTo();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.Constraint#getEvaluations <em>Evaluations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Evaluations</em>'.
	 * @see semanticmanager.Constraint#getEvaluations()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Evaluations();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.Constraint#getInterpreter <em>Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interpreter</em>'.
	 * @see semanticmanager.Constraint#getInterpreter()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Interpreter();

	/**
	 * Returns the meta object for class '{@link semanticmanager.ConstraintInterpreter <em>Constraint Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Interpreter</em>'.
	 * @see semanticmanager.ConstraintInterpreter
	 * @generated
	 */
	EClass getConstraintInterpreter();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.ConstraintInterpreter#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.ConstraintInterpreter#getId()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EAttribute getConstraintInterpreter_Id();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.ConstraintInterpreter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.ConstraintInterpreter#getName()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EAttribute getConstraintInterpreter_Name();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.ConstraintInterpreter#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see semanticmanager.ConstraintInterpreter#getConstraints()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EReference getConstraintInterpreter_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.ConstraintInterpreter#getEvals <em>Evals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Evals</em>'.
	 * @see semanticmanager.ConstraintInterpreter#getEvals()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EReference getConstraintInterpreter_Evals();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.ConstraintInterpreter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see semanticmanager.ConstraintInterpreter#getType()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EAttribute getConstraintInterpreter_Type();

	/**
	 * Returns the meta object for the '{@link semanticmanager.ConstraintInterpreter#eval(semanticmanager.Constraint, semanticmanager.NamedElement) <em>Eval</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Eval</em>' operation.
	 * @see semanticmanager.ConstraintInterpreter#eval(semanticmanager.Constraint, semanticmanager.NamedElement)
	 * @generated
	 */
	EOperation getConstraintInterpreter__Eval__Constraint_NamedElement();

	/**
	 * Returns the meta object for class '{@link semanticmanager.ConstraintResult <em>Constraint Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Result</em>'.
	 * @see semanticmanager.ConstraintResult
	 * @generated
	 */
	EClass getConstraintResult();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.ConstraintResult#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constraint</em>'.
	 * @see semanticmanager.ConstraintResult#getConstraint()
	 * @see #getConstraintResult()
	 * @generated
	 */
	EReference getConstraintResult_Constraint();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.ConstraintResult#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see semanticmanager.ConstraintResult#getContext()
	 * @see #getConstraintResult()
	 * @generated
	 */
	EReference getConstraintResult_Context();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.ConstraintResult#getUnsat <em>Unsat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unsat</em>'.
	 * @see semanticmanager.ConstraintResult#getUnsat()
	 * @see #getConstraintResult()
	 * @generated
	 */
	EReference getConstraintResult_Unsat();

	/**
	 * Returns the meta object for class '{@link semanticmanager.SearchParam <em>Search Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Param</em>'.
	 * @see semanticmanager.SearchParam
	 * @generated
	 */
	EClass getSearchParam();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.SearchParam#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.SearchParam#getName()
	 * @see #getSearchParam()
	 * @generated
	 */
	EAttribute getSearchParam_Name();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.SearchParam#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.SearchParam#getId()
	 * @see #getSearchParam()
	 * @generated
	 */
	EAttribute getSearchParam_Id();

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
	 * Returns the meta object for class '{@link semanticmanager.SearchParamValue <em>Search Param Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Param Value</em>'.
	 * @see semanticmanager.SearchParamValue
	 * @generated
	 */
	EClass getSearchParamValue();

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
	 * Returns the meta object for the attribute '{@link semanticmanager.SearchConfiguration#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see semanticmanager.SearchConfiguration#getDescription()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EAttribute getSearchConfiguration_Description();

	/**
	 * Returns the meta object for class '{@link semanticmanager.SimpleSearchConfiguration <em>Simple Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Search Configuration</em>'.
	 * @see semanticmanager.SimpleSearchConfiguration
	 * @generated
	 */
	EClass getSimpleSearchConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.SimpleSearchConfiguration#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see semanticmanager.SimpleSearchConfiguration#getOptions()
	 * @see #getSimpleSearchConfiguration()
	 * @generated
	 */
	EReference getSimpleSearchConfiguration_Options();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SimpleSearchConfiguration#addPrimitiveTypeSearchOption(java.lang.String, java.lang.String, semanticmanager.Type) <em>Add Primitive Type Search Option</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Primitive Type Search Option</em>' operation.
	 * @see semanticmanager.SimpleSearchConfiguration#addPrimitiveTypeSearchOption(java.lang.String, java.lang.String, semanticmanager.Type)
	 * @generated
	 */
	EOperation getSimpleSearchConfiguration__AddPrimitiveTypeSearchOption__String_String_Type();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SimpleSearchConfiguration#addDataModelTypeSearchOption(java.lang.String, java.lang.String, semanticmanager.DataModelType) <em>Add Data Model Type Search Option</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Data Model Type Search Option</em>' operation.
	 * @see semanticmanager.SimpleSearchConfiguration#addDataModelTypeSearchOption(java.lang.String, java.lang.String, semanticmanager.DataModelType)
	 * @generated
	 */
	EOperation getSimpleSearchConfiguration__AddDataModelTypeSearchOption__String_String_DataModelType();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SimpleSearchConfiguration#init(org.eclipse.emf.common.util.EList) <em>Init</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Init</em>' operation.
	 * @see semanticmanager.SimpleSearchConfiguration#init(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getSimpleSearchConfiguration__Init__EList();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SimpleSearchConfiguration#getParamValue(java.lang.String, org.eclipse.emf.common.util.EList) <em>Get Param Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Param Value</em>' operation.
	 * @see semanticmanager.SimpleSearchConfiguration#getParamValue(java.lang.String, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getSimpleSearchConfiguration__GetParamValue__String_EList();

	/**
	 * Returns the meta object for the '{@link semanticmanager.SimpleSearchConfiguration#getServiceForParamValue(java.lang.String, org.eclipse.emf.common.util.EList) <em>Get Service For Param Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Service For Param Value</em>' operation.
	 * @see semanticmanager.SimpleSearchConfiguration#getServiceForParamValue(java.lang.String, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getSimpleSearchConfiguration__GetServiceForParamValue__String_EList();

	/**
	 * Returns the meta object for class '{@link semanticmanager.CompositeSearchConfiguration <em>Composite Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Search Configuration</em>'.
	 * @see semanticmanager.CompositeSearchConfiguration
	 * @generated
	 */
	EClass getCompositeSearchConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.CompositeSearchConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see semanticmanager.CompositeSearchConfiguration#getType()
	 * @see #getCompositeSearchConfiguration()
	 * @generated
	 */
	EAttribute getCompositeSearchConfiguration_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.CompositeSearchConfiguration#getSearchConfigurations <em>Search Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Search Configurations</em>'.
	 * @see semanticmanager.CompositeSearchConfiguration#getSearchConfigurations()
	 * @see #getCompositeSearchConfiguration()
	 * @generated
	 */
	EReference getCompositeSearchConfiguration_SearchConfigurations();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.CompositeSearchConfiguration#getInputSearchResults <em>Input Search Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Search Results</em>'.
	 * @see semanticmanager.CompositeSearchConfiguration#getInputSearchResults()
	 * @see #getCompositeSearchConfiguration()
	 * @generated
	 */
	EReference getCompositeSearchConfiguration_InputSearchResults();

	/**
	 * Returns the meta object for the '{@link semanticmanager.CompositeSearchConfiguration#search(semanticmanager.SearchResult) <em>Search</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Search</em>' operation.
	 * @see semanticmanager.CompositeSearchConfiguration#search(semanticmanager.SearchResult)
	 * @generated
	 */
	EOperation getCompositeSearchConfiguration__Search__SearchResult();

	/**
	 * Returns the meta object for class '{@link semanticmanager.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see semanticmanager.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Service#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.Service#getId()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Id();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Name();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Service#getFilterBy <em>Filter By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter By</em>'.
	 * @see semanticmanager.Service#getFilterBy()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_FilterBy();

	/**
	 * Returns the meta object for the '{@link semanticmanager.Service#matches(java.lang.String, java.lang.String) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Matches</em>' operation.
	 * @see semanticmanager.Service#matches(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getService__Matches__String_String();

	/**
	 * Returns the meta object for class '{@link semanticmanager.CustomSearch <em>Custom Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Search</em>'.
	 * @see semanticmanager.CustomSearch
	 * @generated
	 */
	EClass getCustomSearch();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.CustomSearch#isGrouped <em>Grouped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grouped</em>'.
	 * @see semanticmanager.CustomSearch#isGrouped()
	 * @see #getCustomSearch()
	 * @generated
	 */
	EAttribute getCustomSearch_Grouped();

	/**
	 * Returns the meta object for the '{@link semanticmanager.CustomSearch#search(semanticmanager.Repository, semanticmanager.SearchResult) <em>Search</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Search</em>' operation.
	 * @see semanticmanager.CustomSearch#search(semanticmanager.Repository, semanticmanager.SearchResult)
	 * @generated
	 */
	EOperation getCustomSearch__Search__Repository_SearchResult();

	/**
	 * Returns the meta object for class '{@link semanticmanager.PredicateBasedSearch <em>Predicate Based Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate Based Search</em>'.
	 * @see semanticmanager.PredicateBasedSearch
	 * @generated
	 */
	EClass getPredicateBasedSearch();

	/**
	 * Returns the meta object for the '{@link semanticmanager.PredicateBasedSearch#matches(semanticmanager.NamedElement) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Matches</em>' operation.
	 * @see semanticmanager.PredicateBasedSearch#matches(semanticmanager.NamedElement)
	 * @generated
	 */
	EOperation getPredicateBasedSearch__Matches__NamedElement();

	/**
	 * Returns the meta object for class '{@link semanticmanager.AtomicSearchResult <em>Atomic Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Search Result</em>'.
	 * @see semanticmanager.AtomicSearchResult
	 * @generated
	 */
	EClass getAtomicSearchResult();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.AtomicSearchResult#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see semanticmanager.AtomicSearchResult#getElements()
	 * @see #getAtomicSearchResult()
	 * @generated
	 */
	EReference getAtomicSearchResult_Elements();

	/**
	 * Returns the meta object for class '{@link semanticmanager.GroupedSearchResult <em>Grouped Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grouped Search Result</em>'.
	 * @see semanticmanager.GroupedSearchResult
	 * @generated
	 */
	EClass getGroupedSearchResult();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.GroupedSearchResult#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see semanticmanager.GroupedSearchResult#getGroups()
	 * @see #getGroupedSearchResult()
	 * @generated
	 */
	EReference getGroupedSearchResult_Groups();

	/**
	 * Returns the meta object for the '{@link semanticmanager.GroupedSearchResult#createSemanticGroup(java.lang.String, java.lang.String) <em>Create Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Semantic Group</em>' operation.
	 * @see semanticmanager.GroupedSearchResult#createSemanticGroup(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getGroupedSearchResult__CreateSemanticGroup__String_String();

	/**
	 * Returns the meta object for the '{@link semanticmanager.GroupedSearchResult#addNamedElementToSemanticGroup(semanticmanager.SemanticGroup, semanticmanager.NamedElement) <em>Add Named Element To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Named Element To Semantic Group</em>' operation.
	 * @see semanticmanager.GroupedSearchResult#addNamedElementToSemanticGroup(semanticmanager.SemanticGroup, semanticmanager.NamedElement)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddNamedElementToSemanticGroup__SemanticGroup_NamedElement();

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
	 * Returns the meta object for the reference list '{@link semanticmanager.SemanticGroup#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see semanticmanager.SemanticGroup#getElements()
	 * @see #getSemanticGroup()
	 * @generated
	 */
	EReference getSemanticGroup_Elements();

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
	 * Returns the meta object for the attribute '{@link semanticmanager.Repository#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project</em>'.
	 * @see semanticmanager.Repository#getProject()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Project();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Repository#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.Repository#getName()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Name();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Repository#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see semanticmanager.Repository#getDescription()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Description();

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
	 * Returns the meta object for the containment reference list '{@link semanticmanager.Resource#getResourceElements <em>Resource Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Elements</em>'.
	 * @see semanticmanager.Resource#getResourceElements()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_ResourceElements();

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
	 * Returns the meta object for the reference '{@link semanticmanager.Resource#getDefaultConstraintInterpreter <em>Default Constraint Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Constraint Interpreter</em>'.
	 * @see semanticmanager.Resource#getDefaultConstraintInterpreter()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_DefaultConstraintInterpreter();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.Resource#getAssistant <em>Assistant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assistant</em>'.
	 * @see semanticmanager.Resource#getAssistant()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Assistant();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.Resource#getGuardSemanticNodes <em>Guard Semantic Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Guard Semantic Nodes</em>'.
	 * @see semanticmanager.Resource#getGuardSemanticNodes()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_GuardSemanticNodes();

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
	 * Returns the meta object for the attribute '{@link semanticmanager.SemanticNode#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see semanticmanager.SemanticNode#isAbstract()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EAttribute getSemanticNode_Abstract();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.SemanticNode#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Domain</em>'.
	 * @see semanticmanager.SemanticNode#getDomain()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EReference getSemanticNode_Domain();

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
	 * Returns the meta object for the attribute '{@link semanticmanager.NamedElement#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see semanticmanager.NamedElement#getTrace()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Trace();

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
	 * Returns the meta object for the reference list '{@link semanticmanager.NamedElement#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptors</em>'.
	 * @see semanticmanager.NamedElement#getDescriptors()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Descriptors();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.NamedElement#getDescribes <em>Describes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Describes</em>'.
	 * @see semanticmanager.NamedElement#getDescribes()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Describes();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.NamedElement#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see semanticmanager.NamedElement#getConstraints()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.NamedElement#getMetadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metadata</em>'.
	 * @see semanticmanager.NamedElement#getMetadata()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Metadata();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.NamedElement#getSupers <em>Supers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supers</em>'.
	 * @see semanticmanager.NamedElement#getSupers()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Supers();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.NamedElement#getSubs <em>Subs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subs</em>'.
	 * @see semanticmanager.NamedElement#getSubs()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Subs();

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
	 * Returns the meta object for the attribute '{@link semanticmanager.Property#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see semanticmanager.Property#getLowerBound()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.Property#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see semanticmanager.Property#getUpperBound()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_UpperBound();

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
	 * Returns the meta object for the reference '{@link semanticmanager.ObjectProperty#getInverseOf <em>Inverse Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inverse Of</em>'.
	 * @see semanticmanager.ObjectProperty#getInverseOf()
	 * @see #getObjectProperty()
	 * @generated
	 */
	EReference getObjectProperty_InverseOf();

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
	 * Returns the meta object for the attribute '{@link semanticmanager.DataProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see semanticmanager.DataProperty#getValue()
	 * @see #getDataProperty()
	 * @generated
	 */
	EAttribute getDataProperty_Value();

	/**
	 * Returns the meta object for class '{@link semanticmanager.MetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Data</em>'.
	 * @see semanticmanager.MetaData
	 * @generated
	 */
	EClass getMetaData();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.MetaData#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see semanticmanager.MetaData#getKey()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_Key();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.MetaData#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see semanticmanager.MetaData#getValue()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_Value();

	/**
	 * Returns the meta object for class '{@link semanticmanager.ResourceElement <em>Resource Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Element</em>'.
	 * @see semanticmanager.ResourceElement
	 * @generated
	 */
	EClass getResourceElement();

	/**
	 * Returns the meta object for the container reference '{@link semanticmanager.ResourceElement#getResourceFrom <em>Resource From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource From</em>'.
	 * @see semanticmanager.ResourceElement#getResourceFrom()
	 * @see #getResourceElement()
	 * @generated
	 */
	EReference getResourceElement_ResourceFrom();

	/**
	 * Returns the meta object for class '{@link semanticmanager.PrimitiveTypeParam <em>Primitive Type Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Param</em>'.
	 * @see semanticmanager.PrimitiveTypeParam
	 * @generated
	 */
	EClass getPrimitiveTypeParam();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.PrimitiveTypeParam#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see semanticmanager.PrimitiveTypeParam#getType()
	 * @see #getPrimitiveTypeParam()
	 * @generated
	 */
	EAttribute getPrimitiveTypeParam_Type();

	/**
	 * Returns the meta object for class '{@link semanticmanager.ModelTypeParam <em>Model Type Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type Param</em>'.
	 * @see semanticmanager.ModelTypeParam
	 * @generated
	 */
	EClass getModelTypeParam();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.ModelTypeParam#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see semanticmanager.ModelTypeParam#getType()
	 * @see #getModelTypeParam()
	 * @generated
	 */
	EAttribute getModelTypeParam_Type();

	/**
	 * Returns the meta object for class '{@link semanticmanager.ModelTypeParamValue <em>Model Type Param Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type Param Value</em>'.
	 * @see semanticmanager.ModelTypeParamValue
	 * @generated
	 */
	EClass getModelTypeParamValue();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.ModelTypeParamValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see semanticmanager.ModelTypeParamValue#getValue()
	 * @see #getModelTypeParamValue()
	 * @generated
	 */
	EReference getModelTypeParamValue_Value();

	/**
	 * Returns the meta object for class '{@link semanticmanager.PrimitiveTypeParamValue <em>Primitive Type Param Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Param Value</em>'.
	 * @see semanticmanager.PrimitiveTypeParamValue
	 * @generated
	 */
	EClass getPrimitiveTypeParamValue();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.PrimitiveTypeParamValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see semanticmanager.PrimitiveTypeParamValue#getValue()
	 * @see #getPrimitiveTypeParamValue()
	 * @generated
	 */
	EAttribute getPrimitiveTypeParamValue_Value();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.PrimitiveTypeParamValue#getCalls <em>Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Calls</em>'.
	 * @see semanticmanager.PrimitiveTypeParamValue#getCalls()
	 * @see #getPrimitiveTypeParamValue()
	 * @generated
	 */
	EReference getPrimitiveTypeParamValue_Calls();

	/**
	 * Returns the meta object for class '{@link semanticmanager.FormatAssistant <em>Format Assistant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Format Assistant</em>'.
	 * @see semanticmanager.FormatAssistant
	 * @generated
	 */
	EClass getFormatAssistant();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.FormatAssistant#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.FormatAssistant#getId()
	 * @see #getFormatAssistant()
	 * @generated
	 */
	EAttribute getFormatAssistant_Id();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.FormatAssistant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.FormatAssistant#getName()
	 * @see #getFormatAssistant()
	 * @generated
	 */
	EAttribute getFormatAssistant_Name();

	/**
	 * Returns the meta object for the attribute list '{@link semanticmanager.FormatAssistant#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Extensions</em>'.
	 * @see semanticmanager.FormatAssistant#getExtensions()
	 * @see #getFormatAssistant()
	 * @generated
	 */
	EAttribute getFormatAssistant_Extensions();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.FormatAssistant#getInterpreter <em>Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interpreter</em>'.
	 * @see semanticmanager.FormatAssistant#getInterpreter()
	 * @see #getFormatAssistant()
	 * @generated
	 */
	EAttribute getFormatAssistant_Interpreter();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.FormatAssistant#getConstraintInterpreter <em>Constraint Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constraint Interpreter</em>'.
	 * @see semanticmanager.FormatAssistant#getConstraintInterpreter()
	 * @see #getFormatAssistant()
	 * @generated
	 */
	EReference getFormatAssistant_ConstraintInterpreter();

	/**
	 * Returns the meta object for the '{@link semanticmanager.FormatAssistant#loadAndValidate(semanticmanager.Resource, semanticmanager.ConstraintInterpreter) <em>Load And Validate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Load And Validate</em>' operation.
	 * @see semanticmanager.FormatAssistant#loadAndValidate(semanticmanager.Resource, semanticmanager.ConstraintInterpreter)
	 * @generated
	 */
	EOperation getFormatAssistant__LoadAndValidate__Resource_ConstraintInterpreter();

	/**
	 * Returns the meta object for the '{@link semanticmanager.FormatAssistant#toDataProperty(semanticmanager.SemanticNode) <em>To Data Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Data Property</em>' operation.
	 * @see semanticmanager.FormatAssistant#toDataProperty(semanticmanager.SemanticNode)
	 * @generated
	 */
	EOperation getFormatAssistant__ToDataProperty__SemanticNode();

	/**
	 * Returns the meta object for the '{@link semanticmanager.FormatAssistant#toObjectProperty(semanticmanager.SemanticNode) <em>To Object Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Object Property</em>' operation.
	 * @see semanticmanager.FormatAssistant#toObjectProperty(semanticmanager.SemanticNode)
	 * @generated
	 */
	EOperation getFormatAssistant__ToObjectProperty__SemanticNode();

	/**
	 * Returns the meta object for the '{@link semanticmanager.FormatAssistant#toSuper(semanticmanager.SemanticNode) <em>To Super</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Super</em>' operation.
	 * @see semanticmanager.FormatAssistant#toSuper(semanticmanager.SemanticNode)
	 * @generated
	 */
	EOperation getFormatAssistant__ToSuper__SemanticNode();

	/**
	 * Returns the meta object for the '{@link semanticmanager.FormatAssistant#toSuper(semanticmanager.DataProperty) <em>To Super</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Super</em>' operation.
	 * @see semanticmanager.FormatAssistant#toSuper(semanticmanager.DataProperty)
	 * @generated
	 */
	EOperation getFormatAssistant__ToSuper__DataProperty();

	/**
	 * Returns the meta object for the '{@link semanticmanager.FormatAssistant#toSuper(semanticmanager.ObjectProperty) <em>To Super</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Super</em>' operation.
	 * @see semanticmanager.FormatAssistant#toSuper(semanticmanager.ObjectProperty)
	 * @generated
	 */
	EOperation getFormatAssistant__ToSuper__ObjectProperty();

	/**
	 * Returns the meta object for the '{@link semanticmanager.FormatAssistant#toInverseOf(semanticmanager.ObjectProperty) <em>To Inverse Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Inverse Of</em>' operation.
	 * @see semanticmanager.FormatAssistant#toInverseOf(semanticmanager.ObjectProperty)
	 * @generated
	 */
	EOperation getFormatAssistant__ToInverseOf__ObjectProperty();

	/**
	 * Returns the meta object for class '{@link semanticmanager.ModelPersistence <em>Model Persistence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Persistence</em>'.
	 * @see semanticmanager.ModelPersistence
	 * @generated
	 */
	EClass getModelPersistence();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.ModelPersistence#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.ModelPersistence#getId()
	 * @see #getModelPersistence()
	 * @generated
	 */
	EAttribute getModelPersistence_Id();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.ModelPersistence#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.ModelPersistence#getName()
	 * @see #getModelPersistence()
	 * @generated
	 */
	EAttribute getModelPersistence_Name();

	/**
	 * Returns the meta object for the '{@link semanticmanager.ModelPersistence#load(java.lang.String) <em>Load</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Load</em>' operation.
	 * @see semanticmanager.ModelPersistence#load(java.lang.String)
	 * @generated
	 */
	EOperation getModelPersistence__Load__String();

	/**
	 * Returns the meta object for the '{@link semanticmanager.ModelPersistence#save() <em>Save</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Save</em>' operation.
	 * @see semanticmanager.ModelPersistence#save()
	 * @generated
	 */
	EOperation getModelPersistence__Save();

	/**
	 * Returns the meta object for the '{@link semanticmanager.ModelPersistence#addContent(semanticmanager.RepositoryManager) <em>Add Content</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Content</em>' operation.
	 * @see semanticmanager.ModelPersistence#addContent(semanticmanager.RepositoryManager)
	 * @generated
	 */
	EOperation getModelPersistence__AddContent__RepositoryManager();

	/**
	 * Returns the meta object for the '{@link semanticmanager.ModelPersistence#getContent() <em>Get Content</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Content</em>' operation.
	 * @see semanticmanager.ModelPersistence#getContent()
	 * @generated
	 */
	EOperation getModelPersistence__GetContent();

	/**
	 * Returns the meta object for enum '{@link semanticmanager.ConnectionType <em>Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Connection Type</em>'.
	 * @see semanticmanager.ConnectionType
	 * @generated
	 */
	EEnum getConnectionType();

	/**
	 * Returns the meta object for enum '{@link semanticmanager.DataModelType <em>Data Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Model Type</em>'.
	 * @see semanticmanager.DataModelType
	 * @generated
	 */
	EEnum getDataModelType();

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
	 * Returns the meta object for data type '{@link java.lang.Object <em>Java Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Object</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getJavaObject();

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
		 * The meta object literal for the '<em><b>Constraint Interpreters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_MANAGER__CONSTRAINT_INTERPRETERS = eINSTANCE.getRepositoryManager_ConstraintInterpreters();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_MANAGER__SERVICES = eINSTANCE.getRepositoryManager_Services();

		/**
		 * The meta object literal for the '<em><b>Format Assistants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_MANAGER__FORMAT_ASSISTANTS = eINSTANCE.getRepositoryManager_FormatAssistants();

		/**
		 * The meta object literal for the '<em><b>Model Persistences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_MANAGER__MODEL_PERSISTENCES = eINSTANCE.getRepositoryManager_ModelPersistences();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.ConstraintImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getConstraint()
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
		 * The meta object literal for the '<em><b>Interpreter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__INTERPRETER = eINSTANCE.getConstraint_Interpreter();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.ConstraintInterpreterImpl <em>Constraint Interpreter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.ConstraintInterpreterImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getConstraintInterpreter()
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
		 * The meta object literal for the '<em><b>Evals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_INTERPRETER__EVALS = eINSTANCE.getConstraintInterpreter_Evals();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_INTERPRETER__TYPE = eINSTANCE.getConstraintInterpreter_Type();

		/**
		 * The meta object literal for the '<em><b>Eval</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONSTRAINT_INTERPRETER___EVAL__CONSTRAINT_NAMEDELEMENT = eINSTANCE.getConstraintInterpreter__Eval__Constraint_NamedElement();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.ConstraintResultImpl <em>Constraint Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.ConstraintResultImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getConstraintResult()
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

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.SearchParamImpl <em>Search Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.SearchParamImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchParam()
		 * @generated
		 */
		EClass SEARCH_PARAM = eINSTANCE.getSearchParam();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_PARAM__NAME = eINSTANCE.getSearchParam_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_PARAM__ID = eINSTANCE.getSearchParam_Id();

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
		 * The meta object literal for the '{@link semanticmanager.impl.SearchParamValueImpl <em>Search Param Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.SearchParamValueImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSearchParamValue()
		 * @generated
		 */
		EClass SEARCH_PARAM_VALUE = eINSTANCE.getSearchParamValue();

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
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_CONFIGURATION__RESULTS = eINSTANCE.getSearchConfiguration_Results();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_CONFIGURATION__DESCRIPTION = eINSTANCE.getSearchConfiguration_Description();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.SimpleSearchConfigurationImpl <em>Simple Search Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.SimpleSearchConfigurationImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getSimpleSearchConfiguration()
		 * @generated
		 */
		EClass SIMPLE_SEARCH_CONFIGURATION = eINSTANCE.getSimpleSearchConfiguration();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_SEARCH_CONFIGURATION__OPTIONS = eINSTANCE.getSimpleSearchConfiguration_Options();

		/**
		 * The meta object literal for the '<em><b>Add Primitive Type Search Option</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMPLE_SEARCH_CONFIGURATION___ADD_PRIMITIVE_TYPE_SEARCH_OPTION__STRING_STRING_TYPE = eINSTANCE.getSimpleSearchConfiguration__AddPrimitiveTypeSearchOption__String_String_Type();

		/**
		 * The meta object literal for the '<em><b>Add Data Model Type Search Option</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMPLE_SEARCH_CONFIGURATION___ADD_DATA_MODEL_TYPE_SEARCH_OPTION__STRING_STRING_DATAMODELTYPE = eINSTANCE.getSimpleSearchConfiguration__AddDataModelTypeSearchOption__String_String_DataModelType();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMPLE_SEARCH_CONFIGURATION___INIT__ELIST = eINSTANCE.getSimpleSearchConfiguration__Init__EList();

		/**
		 * The meta object literal for the '<em><b>Get Param Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMPLE_SEARCH_CONFIGURATION___GET_PARAM_VALUE__STRING_ELIST = eINSTANCE.getSimpleSearchConfiguration__GetParamValue__String_EList();

		/**
		 * The meta object literal for the '<em><b>Get Service For Param Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMPLE_SEARCH_CONFIGURATION___GET_SERVICE_FOR_PARAM_VALUE__STRING_ELIST = eINSTANCE.getSimpleSearchConfiguration__GetServiceForParamValue__String_EList();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.CompositeSearchConfigurationImpl <em>Composite Search Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.CompositeSearchConfigurationImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getCompositeSearchConfiguration()
		 * @generated
		 */
		EClass COMPOSITE_SEARCH_CONFIGURATION = eINSTANCE.getCompositeSearchConfiguration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_SEARCH_CONFIGURATION__TYPE = eINSTANCE.getCompositeSearchConfiguration_Type();

		/**
		 * The meta object literal for the '<em><b>Search Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_SEARCH_CONFIGURATION__SEARCH_CONFIGURATIONS = eINSTANCE.getCompositeSearchConfiguration_SearchConfigurations();

		/**
		 * The meta object literal for the '<em><b>Input Search Results</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_SEARCH_CONFIGURATION__INPUT_SEARCH_RESULTS = eINSTANCE.getCompositeSearchConfiguration_InputSearchResults();

		/**
		 * The meta object literal for the '<em><b>Search</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSITE_SEARCH_CONFIGURATION___SEARCH__SEARCHRESULT = eINSTANCE.getCompositeSearchConfiguration__Search__SearchResult();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.ServiceImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__ID = eINSTANCE.getService_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__NAME = eINSTANCE.getService_Name();

		/**
		 * The meta object literal for the '<em><b>Filter By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__FILTER_BY = eINSTANCE.getService_FilterBy();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE___MATCHES__STRING_STRING = eINSTANCE.getService__Matches__String_String();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.CustomSearchImpl <em>Custom Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.CustomSearchImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getCustomSearch()
		 * @generated
		 */
		EClass CUSTOM_SEARCH = eINSTANCE.getCustomSearch();

		/**
		 * The meta object literal for the '<em><b>Grouped</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_SEARCH__GROUPED = eINSTANCE.getCustomSearch_Grouped();

		/**
		 * The meta object literal for the '<em><b>Search</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CUSTOM_SEARCH___SEARCH__REPOSITORY_SEARCHRESULT = eINSTANCE.getCustomSearch__Search__Repository_SearchResult();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.PredicateBasedSearchImpl <em>Predicate Based Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.PredicateBasedSearchImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getPredicateBasedSearch()
		 * @generated
		 */
		EClass PREDICATE_BASED_SEARCH = eINSTANCE.getPredicateBasedSearch();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PREDICATE_BASED_SEARCH___MATCHES__NAMEDELEMENT = eINSTANCE.getPredicateBasedSearch__Matches__NamedElement();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.AtomicSearchResultImpl <em>Atomic Search Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.AtomicSearchResultImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getAtomicSearchResult()
		 * @generated
		 */
		EClass ATOMIC_SEARCH_RESULT = eINSTANCE.getAtomicSearchResult();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATOMIC_SEARCH_RESULT__ELEMENTS = eINSTANCE.getAtomicSearchResult_Elements();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.GroupedSearchResultImpl <em>Grouped Search Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.GroupedSearchResultImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getGroupedSearchResult()
		 * @generated
		 */
		EClass GROUPED_SEARCH_RESULT = eINSTANCE.getGroupedSearchResult();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUPED_SEARCH_RESULT__GROUPS = eINSTANCE.getGroupedSearchResult_Groups();

		/**
		 * The meta object literal for the '<em><b>Create Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GROUPED_SEARCH_RESULT___CREATE_SEMANTIC_GROUP__STRING_STRING = eINSTANCE.getGroupedSearchResult__CreateSemanticGroup__String_String();

		/**
		 * The meta object literal for the '<em><b>Add Named Element To Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GROUPED_SEARCH_RESULT___ADD_NAMED_ELEMENT_TO_SEMANTIC_GROUP__SEMANTICGROUP_NAMEDELEMENT = eINSTANCE.getGroupedSearchResult__AddNamedElementToSemanticGroup__SemanticGroup_NamedElement();

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
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_GROUP__ELEMENTS = eINSTANCE.getSemanticGroup_Elements();

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
		 * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__PROJECT = eINSTANCE.getRepository_Project();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__NAME = eINSTANCE.getRepository_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__DESCRIPTION = eINSTANCE.getRepository_Description();

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
		 * The meta object literal for the '<em><b>Resource Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__RESOURCE_ELEMENTS = eINSTANCE.getResource_ResourceElements();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__URI = eINSTANCE.getResource_Uri();

		/**
		 * The meta object literal for the '<em><b>Repository From</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__REPOSITORY_FROM = eINSTANCE.getResource_RepositoryFrom();

		/**
		 * The meta object literal for the '<em><b>Default Constraint Interpreter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__DEFAULT_CONSTRAINT_INTERPRETER = eINSTANCE.getResource_DefaultConstraintInterpreter();

		/**
		 * The meta object literal for the '<em><b>Assistant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__ASSISTANT = eINSTANCE.getResource_Assistant();

		/**
		 * The meta object literal for the '<em><b>Guard Semantic Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__GUARD_SEMANTIC_NODES = eINSTANCE.getResource_GuardSemanticNodes();

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
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_NODE__PROPERTIES = eINSTANCE.getSemanticNode_Properties();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEMANTIC_NODE__ABSTRACT = eINSTANCE.getSemanticNode_Abstract();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_NODE__DOMAIN = eINSTANCE.getSemanticNode_Domain();

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
		 * The meta object literal for the '<em><b>Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__TRACE = eINSTANCE.getNamedElement_Trace();

		/**
		 * The meta object literal for the '<em><b>Drawn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__DRAWN = eINSTANCE.getNamedElement_Drawn();

		/**
		 * The meta object literal for the '<em><b>Descriptors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__DESCRIPTORS = eINSTANCE.getNamedElement_Descriptors();

		/**
		 * The meta object literal for the '<em><b>Describes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__DESCRIBES = eINSTANCE.getNamedElement_Describes();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__CONSTRAINTS = eINSTANCE.getNamedElement_Constraints();

		/**
		 * The meta object literal for the '<em><b>Metadata</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__METADATA = eINSTANCE.getNamedElement_Metadata();

		/**
		 * The meta object literal for the '<em><b>Supers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__SUPERS = eINSTANCE.getNamedElement_Supers();

		/**
		 * The meta object literal for the '<em><b>Subs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__SUBS = eINSTANCE.getNamedElement_Subs();

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
		 * The meta object literal for the '<em><b>Semantic Node From</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__SEMANTIC_NODE_FROM = eINSTANCE.getProperty_SemanticNodeFrom();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__LOWER_BOUND = eINSTANCE.getProperty_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__UPPER_BOUND = eINSTANCE.getProperty_UpperBound();

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
		 * The meta object literal for the '<em><b>Inverse Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_PROPERTY__INVERSE_OF = eINSTANCE.getObjectProperty_InverseOf();

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
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_PROPERTY__VALUE = eINSTANCE.getDataProperty_Value();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.MetaDataImpl <em>Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.MetaDataImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getMetaData()
		 * @generated
		 */
		EClass META_DATA = eINSTANCE.getMetaData();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__KEY = eINSTANCE.getMetaData_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__VALUE = eINSTANCE.getMetaData_Value();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.ResourceElementImpl <em>Resource Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.ResourceElementImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getResourceElement()
		 * @generated
		 */
		EClass RESOURCE_ELEMENT = eINSTANCE.getResourceElement();

		/**
		 * The meta object literal for the '<em><b>Resource From</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_ELEMENT__RESOURCE_FROM = eINSTANCE.getResourceElement_ResourceFrom();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.PrimitiveTypeParamImpl <em>Primitive Type Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.PrimitiveTypeParamImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getPrimitiveTypeParam()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_PARAM = eINSTANCE.getPrimitiveTypeParam();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE_PARAM__TYPE = eINSTANCE.getPrimitiveTypeParam_Type();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.ModelTypeParamImpl <em>Model Type Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.ModelTypeParamImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getModelTypeParam()
		 * @generated
		 */
		EClass MODEL_TYPE_PARAM = eINSTANCE.getModelTypeParam();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TYPE_PARAM__TYPE = eINSTANCE.getModelTypeParam_Type();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.ModelTypeParamValueImpl <em>Model Type Param Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.ModelTypeParamValueImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getModelTypeParamValue()
		 * @generated
		 */
		EClass MODEL_TYPE_PARAM_VALUE = eINSTANCE.getModelTypeParamValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE_PARAM_VALUE__VALUE = eINSTANCE.getModelTypeParamValue_Value();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.PrimitiveTypeParamValueImpl <em>Primitive Type Param Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.PrimitiveTypeParamValueImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getPrimitiveTypeParamValue()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_PARAM_VALUE = eINSTANCE.getPrimitiveTypeParamValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE_PARAM_VALUE__VALUE = eINSTANCE.getPrimitiveTypeParamValue_Value();

		/**
		 * The meta object literal for the '<em><b>Calls</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPE_PARAM_VALUE__CALLS = eINSTANCE.getPrimitiveTypeParamValue_Calls();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.FormatAssistantImpl <em>Format Assistant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.FormatAssistantImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getFormatAssistant()
		 * @generated
		 */
		EClass FORMAT_ASSISTANT = eINSTANCE.getFormatAssistant();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMAT_ASSISTANT__ID = eINSTANCE.getFormatAssistant_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMAT_ASSISTANT__NAME = eINSTANCE.getFormatAssistant_Name();

		/**
		 * The meta object literal for the '<em><b>Extensions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMAT_ASSISTANT__EXTENSIONS = eINSTANCE.getFormatAssistant_Extensions();

		/**
		 * The meta object literal for the '<em><b>Interpreter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMAT_ASSISTANT__INTERPRETER = eINSTANCE.getFormatAssistant_Interpreter();

		/**
		 * The meta object literal for the '<em><b>Constraint Interpreter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMAT_ASSISTANT__CONSTRAINT_INTERPRETER = eINSTANCE.getFormatAssistant_ConstraintInterpreter();

		/**
		 * The meta object literal for the '<em><b>Load And Validate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMAT_ASSISTANT___LOAD_AND_VALIDATE__RESOURCE_CONSTRAINTINTERPRETER = eINSTANCE.getFormatAssistant__LoadAndValidate__Resource_ConstraintInterpreter();

		/**
		 * The meta object literal for the '<em><b>To Data Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMAT_ASSISTANT___TO_DATA_PROPERTY__SEMANTICNODE = eINSTANCE.getFormatAssistant__ToDataProperty__SemanticNode();

		/**
		 * The meta object literal for the '<em><b>To Object Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMAT_ASSISTANT___TO_OBJECT_PROPERTY__SEMANTICNODE = eINSTANCE.getFormatAssistant__ToObjectProperty__SemanticNode();

		/**
		 * The meta object literal for the '<em><b>To Super</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMAT_ASSISTANT___TO_SUPER__SEMANTICNODE = eINSTANCE.getFormatAssistant__ToSuper__SemanticNode();

		/**
		 * The meta object literal for the '<em><b>To Super</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMAT_ASSISTANT___TO_SUPER__DATAPROPERTY = eINSTANCE.getFormatAssistant__ToSuper__DataProperty();

		/**
		 * The meta object literal for the '<em><b>To Super</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMAT_ASSISTANT___TO_SUPER__OBJECTPROPERTY = eINSTANCE.getFormatAssistant__ToSuper__ObjectProperty();

		/**
		 * The meta object literal for the '<em><b>To Inverse Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMAT_ASSISTANT___TO_INVERSE_OF__OBJECTPROPERTY = eINSTANCE.getFormatAssistant__ToInverseOf__ObjectProperty();

		/**
		 * The meta object literal for the '{@link semanticmanager.impl.ModelPersistenceImpl <em>Model Persistence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.impl.ModelPersistenceImpl
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getModelPersistence()
		 * @generated
		 */
		EClass MODEL_PERSISTENCE = eINSTANCE.getModelPersistence();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_PERSISTENCE__ID = eINSTANCE.getModelPersistence_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_PERSISTENCE__NAME = eINSTANCE.getModelPersistence_Name();

		/**
		 * The meta object literal for the '<em><b>Load</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_PERSISTENCE___LOAD__STRING = eINSTANCE.getModelPersistence__Load__String();

		/**
		 * The meta object literal for the '<em><b>Save</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_PERSISTENCE___SAVE = eINSTANCE.getModelPersistence__Save();

		/**
		 * The meta object literal for the '<em><b>Add Content</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_PERSISTENCE___ADD_CONTENT__REPOSITORYMANAGER = eINSTANCE.getModelPersistence__AddContent__RepositoryManager();

		/**
		 * The meta object literal for the '<em><b>Get Content</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MODEL_PERSISTENCE___GET_CONTENT = eINSTANCE.getModelPersistence__GetContent();

		/**
		 * The meta object literal for the '{@link semanticmanager.ConnectionType <em>Connection Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.ConnectionType
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getConnectionType()
		 * @generated
		 */
		EEnum CONNECTION_TYPE = eINSTANCE.getConnectionType();

		/**
		 * The meta object literal for the '{@link semanticmanager.DataModelType <em>Data Model Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.DataModelType
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getDataModelType()
		 * @generated
		 */
		EEnum DATA_MODEL_TYPE = eINSTANCE.getDataModelType();

		/**
		 * The meta object literal for the '{@link semanticmanager.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.Type
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em>Java Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see semanticmanager.impl.SemanticmanagerPackageImpl#getJavaObject()
		 * @generated
		 */
		EDataType JAVA_OBJECT = eINSTANCE.getJavaObject();

	}

} //SemanticmanagerPackage
