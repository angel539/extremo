/**
 */
package uam.extremo.core;

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
 * @see uam.extremo.core.SemanticmanagerFactory
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
	SemanticmanagerPackage eINSTANCE = uam.extremo.core.impl.SemanticmanagerPackageImpl.init();

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.RepositoryManagerImpl <em>Repository Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.RepositoryManagerImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getRepositoryManager()
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
	 * The feature id for the '<em><b>Interpreters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER__INTERPRETERS = 2;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER__SERVICES = 3;

	/**
	 * The number of structural features of the '<em>Repository Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Repository Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_MANAGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.ConstraintImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getConstraint()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.ConstraintInterpreterImpl <em>Constraint Interpreter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.ConstraintInterpreterImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getConstraintInterpreter()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.ConstraintResultImpl <em>Constraint Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.ConstraintResultImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getConstraintResult()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.SearchParamImpl <em>Search Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.SearchParamImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSearchParam()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.SearchResultImpl <em>Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.SearchResultImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSearchResult()
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
	 * The feature id for the '<em><b>Apply On Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT__APPLY_ON_ELEMENTS = 2;

	/**
	 * The number of structural features of the '<em>Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Get Option Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT___GET_OPTION_VALUE__STRING = 0;

	/**
	 * The number of operations of the '<em>Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.SearchParamValueImpl <em>Search Param Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.SearchParamValueImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSearchParamValue()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.SearchConfigurationImpl <em>Search Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.SearchConfigurationImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSearchConfiguration()
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
	 * The number of structural features of the '<em>Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.SimpleSearchConfigurationImpl <em>Simple Search Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.SimpleSearchConfigurationImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSimpleSearchConfiguration()
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
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION__OPTIONS = SEARCH_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION__DESCRIPTION = SEARCH_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Filter By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION__FILTER_BY = SEARCH_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Simple Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION_FEATURE_COUNT = SEARCH_CONFIGURATION_FEATURE_COUNT + 3;

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
	 * The number of operations of the '<em>Simple Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT = SEARCH_CONFIGURATION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.CompositeSearchConfigurationImpl <em>Composite Search Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.CompositeSearchConfigurationImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getCompositeSearchConfiguration()
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
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__TYPE = SEARCH_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__CHILDREN = SEARCH_CONFIGURATION_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link uam.extremo.core.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.ServiceImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getService()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.CustomSearchImpl <em>Custom Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.CustomSearchImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getCustomSearch()
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
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH__OPTIONS = SIMPLE_SEARCH_CONFIGURATION__OPTIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH__DESCRIPTION = SIMPLE_SEARCH_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Filter By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH__FILTER_BY = SIMPLE_SEARCH_CONFIGURATION__FILTER_BY;

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
	 * The operation id for the '<em>Search</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH___SEARCH__SEARCHRESULT = SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Custom Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH_OPERATION_COUNT = SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.PredicateBasedSearchImpl <em>Predicate Based Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.PredicateBasedSearchImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getPredicateBasedSearch()
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
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH__OPTIONS = SIMPLE_SEARCH_CONFIGURATION__OPTIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH__DESCRIPTION = SIMPLE_SEARCH_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Filter By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH__FILTER_BY = SIMPLE_SEARCH_CONFIGURATION__FILTER_BY;

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
	 * The operation id for the '<em>Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH___MATCHES__NAMEDELEMENT = SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Option Value Key</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH___GET_OPTION_VALUE_KEY__STRING_ELIST = SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH___INIT__ELIST = SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Predicate Based Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH_OPERATION_COUNT = SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.AtomicSearchResultImpl <em>Atomic Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.AtomicSearchResultImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getAtomicSearchResult()
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
	 * The feature id for the '<em><b>Apply On Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_SEARCH_RESULT__APPLY_ON_ELEMENTS = SEARCH_RESULT__APPLY_ON_ELEMENTS;

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
	 * The operation id for the '<em>Get Option Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_SEARCH_RESULT___GET_OPTION_VALUE__STRING = SEARCH_RESULT___GET_OPTION_VALUE__STRING;

	/**
	 * The number of operations of the '<em>Atomic Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_SEARCH_RESULT_OPERATION_COUNT = SEARCH_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.GroupedSearchResultImpl <em>Grouped Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.GroupedSearchResultImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getGroupedSearchResult()
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
	 * The feature id for the '<em><b>Apply On Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT__APPLY_ON_ELEMENTS = SEARCH_RESULT__APPLY_ON_ELEMENTS;

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
	 * The operation id for the '<em>Get Option Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___GET_OPTION_VALUE__STRING = SEARCH_RESULT___GET_OPTION_VALUE__STRING;

	/**
	 * The operation id for the '<em>Create Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___CREATE_SEMANTIC_GROUP__STRING_STRING = SEARCH_RESULT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Add Semantic Node To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___ADD_SEMANTIC_NODE_TO_SEMANTIC_GROUP__SEMANTICGROUP_SEMANTICNODE = SEARCH_RESULT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Add Data Property To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___ADD_DATA_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_DATAPROPERTY = SEARCH_RESULT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Add Object Property To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___ADD_OBJECT_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_OBJECTPROPERTY = SEARCH_RESULT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Add Named Element To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___ADD_NAMED_ELEMENT_TO_SEMANTIC_GROUP__SEMANTICGROUP_NAMEDELEMENT = SEARCH_RESULT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Add Resource To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___ADD_RESOURCE_TO_SEMANTIC_GROUP__SEMANTICGROUP_RESOURCE = SEARCH_RESULT_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Grouped Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT_OPERATION_COUNT = SEARCH_RESULT_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.NamedElementImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getNamedElement()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.SemanticGroupImpl <em>Semantic Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.SemanticGroupImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSemanticGroup()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.RepositoryImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getRepository()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.ResourceElementImpl <em>Resource Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.ResourceElementImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getResourceElement()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.ResourceImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getResource()
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
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ACTIVE = RESOURCE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ALIVE = RESOURCE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assistant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ASSISTANT = RESOURCE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__RESOURCE_ELEMENTS = RESOURCE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__URI = RESOURCE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Repository From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__REPOSITORY_FROM = RESOURCE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Default Constraint Interpreter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEFAULT_CONSTRAINT_INTERPRETER = RESOURCE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = RESOURCE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = RESOURCE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.SemanticNodeImpl <em>Semantic Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.SemanticNodeImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSemanticNode()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.PropertyImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getProperty()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.ObjectPropertyImpl <em>Object Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.ObjectPropertyImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getObjectProperty()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.DataPropertyImpl <em>Data Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.DataPropertyImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getDataProperty()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.MetaDataImpl <em>Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.MetaDataImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getMetaData()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.PrimitiveTypeParamImpl <em>Primitive Type Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.PrimitiveTypeParamImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getPrimitiveTypeParam()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.ModelTypeParamImpl <em>Model Type Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.ModelTypeParamImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getModelTypeParam()
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
	 * The meta object id for the '{@link uam.extremo.core.impl.ModelTypeParamValueImpl <em>Model Type Param Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.ModelTypeParamValueImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getModelTypeParamValue()
	 * @generated
	 */
	int MODEL_TYPE_PARAM_VALUE = 27;

	/**
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM_VALUE__OPTION = SEARCH_PARAM_VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM_VALUE__VALUE = SEARCH_PARAM_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Type Param Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM_VALUE_FEATURE_COUNT = SEARCH_PARAM_VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Model Type Param Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TYPE_PARAM_VALUE_OPERATION_COUNT = SEARCH_PARAM_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uam.extremo.core.impl.PrimitiveTypeParamValueImpl <em>Primitive Type Param Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.impl.PrimitiveTypeParamValueImpl
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getPrimitiveTypeParamValue()
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
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM_VALUE__OPTION = SEARCH_PARAM_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Calls</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM_VALUE__CALLS = SEARCH_PARAM_VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Primitive Type Param Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM_VALUE_FEATURE_COUNT = SEARCH_PARAM_VALUE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Primitive Type Param Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_PARAM_VALUE_OPERATION_COUNT = SEARCH_PARAM_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link uam.extremo.core.ConnectionType <em>Connection Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.ConnectionType
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getConnectionType()
	 * @generated
	 */
	int CONNECTION_TYPE = 29;

	/**
	 * The meta object id for the '{@link uam.extremo.core.DataModelType <em>Data Model Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.DataModelType
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getDataModelType()
	 * @generated
	 */
	int DATA_MODEL_TYPE = 30;

	/**
	 * The meta object id for the '{@link uam.extremo.core.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see uam.extremo.core.Type
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 31;

	/**
	 * The meta object id for the '<em>Java Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getJavaObject()
	 * @generated
	 */
	int JAVA_OBJECT = 32;


	/**
	 * Returns the meta object for class '{@link uam.extremo.core.RepositoryManager <em>Repository Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository Manager</em>'.
	 * @see uam.extremo.core.RepositoryManager
	 * @generated
	 */
	EClass getRepositoryManager();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.RepositoryManager#getRepositories <em>Repositories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Repositories</em>'.
	 * @see uam.extremo.core.RepositoryManager#getRepositories()
	 * @see #getRepositoryManager()
	 * @generated
	 */
	EReference getRepositoryManager_Repositories();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.RepositoryManager#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see uam.extremo.core.RepositoryManager#getConfigurations()
	 * @see #getRepositoryManager()
	 * @generated
	 */
	EReference getRepositoryManager_Configurations();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.RepositoryManager#getInterpreters <em>Interpreters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interpreters</em>'.
	 * @see uam.extremo.core.RepositoryManager#getInterpreters()
	 * @see #getRepositoryManager()
	 * @generated
	 */
	EReference getRepositoryManager_Interpreters();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.RepositoryManager#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see uam.extremo.core.RepositoryManager#getServices()
	 * @see #getRepositoryManager()
	 * @generated
	 */
	EReference getRepositoryManager_Services();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see uam.extremo.core.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Constraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uam.extremo.core.Constraint#getType()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Type();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Constraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uam.extremo.core.Constraint#getName()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Name();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Constraint#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see uam.extremo.core.Constraint#getBody()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Body();

	/**
	 * Returns the meta object for the container reference '{@link uam.extremo.core.Constraint#getAppliedTo <em>Applied To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Applied To</em>'.
	 * @see uam.extremo.core.Constraint#getAppliedTo()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_AppliedTo();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.Constraint#getEvaluations <em>Evaluations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Evaluations</em>'.
	 * @see uam.extremo.core.Constraint#getEvaluations()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Evaluations();

	/**
	 * Returns the meta object for the reference '{@link uam.extremo.core.Constraint#getInterpreter <em>Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Interpreter</em>'.
	 * @see uam.extremo.core.Constraint#getInterpreter()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Interpreter();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.ConstraintInterpreter <em>Constraint Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Interpreter</em>'.
	 * @see uam.extremo.core.ConstraintInterpreter
	 * @generated
	 */
	EClass getConstraintInterpreter();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.ConstraintInterpreter#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see uam.extremo.core.ConstraintInterpreter#getId()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EAttribute getConstraintInterpreter_Id();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.ConstraintInterpreter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uam.extremo.core.ConstraintInterpreter#getName()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EAttribute getConstraintInterpreter_Name();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.ConstraintInterpreter#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see uam.extremo.core.ConstraintInterpreter#getConstraints()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EReference getConstraintInterpreter_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.ConstraintInterpreter#getEvals <em>Evals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Evals</em>'.
	 * @see uam.extremo.core.ConstraintInterpreter#getEvals()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EReference getConstraintInterpreter_Evals();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.ConstraintInterpreter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uam.extremo.core.ConstraintInterpreter#getType()
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	EAttribute getConstraintInterpreter_Type();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.ConstraintInterpreter#eval(uam.extremo.core.Constraint, uam.extremo.core.NamedElement) <em>Eval</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Eval</em>' operation.
	 * @see uam.extremo.core.ConstraintInterpreter#eval(uam.extremo.core.Constraint, uam.extremo.core.NamedElement)
	 * @generated
	 */
	EOperation getConstraintInterpreter__Eval__Constraint_NamedElement();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.ConstraintResult <em>Constraint Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Result</em>'.
	 * @see uam.extremo.core.ConstraintResult
	 * @generated
	 */
	EClass getConstraintResult();

	/**
	 * Returns the meta object for the reference '{@link uam.extremo.core.ConstraintResult#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constraint</em>'.
	 * @see uam.extremo.core.ConstraintResult#getConstraint()
	 * @see #getConstraintResult()
	 * @generated
	 */
	EReference getConstraintResult_Constraint();

	/**
	 * Returns the meta object for the reference '{@link uam.extremo.core.ConstraintResult#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see uam.extremo.core.ConstraintResult#getContext()
	 * @see #getConstraintResult()
	 * @generated
	 */
	EReference getConstraintResult_Context();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.ConstraintResult#getUnsat <em>Unsat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unsat</em>'.
	 * @see uam.extremo.core.ConstraintResult#getUnsat()
	 * @see #getConstraintResult()
	 * @generated
	 */
	EReference getConstraintResult_Unsat();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.SearchParam <em>Search Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Param</em>'.
	 * @see uam.extremo.core.SearchParam
	 * @generated
	 */
	EClass getSearchParam();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.SearchParam#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uam.extremo.core.SearchParam#getName()
	 * @see #getSearchParam()
	 * @generated
	 */
	EAttribute getSearchParam_Name();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.SearchParam#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see uam.extremo.core.SearchParam#getId()
	 * @see #getSearchParam()
	 * @generated
	 */
	EAttribute getSearchParam_Id();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.SearchResult <em>Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Result</em>'.
	 * @see uam.extremo.core.SearchResult
	 * @generated
	 */
	EClass getSearchResult();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.SearchResult#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see uam.extremo.core.SearchResult#getValues()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_Values();

	/**
	 * Returns the meta object for the container reference '{@link uam.extremo.core.SearchResult#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Configuration</em>'.
	 * @see uam.extremo.core.SearchResult#getConfiguration()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_Configuration();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.SearchResult#getApplyOnElements <em>Apply On Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Apply On Elements</em>'.
	 * @see uam.extremo.core.SearchResult#getApplyOnElements()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_ApplyOnElements();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.SearchResult#getOptionValue(java.lang.String) <em>Get Option Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Option Value</em>' operation.
	 * @see uam.extremo.core.SearchResult#getOptionValue(java.lang.String)
	 * @generated
	 */
	EOperation getSearchResult__GetOptionValue__String();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.SearchParamValue <em>Search Param Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Param Value</em>'.
	 * @see uam.extremo.core.SearchParamValue
	 * @generated
	 */
	EClass getSearchParamValue();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.SearchConfiguration <em>Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Configuration</em>'.
	 * @see uam.extremo.core.SearchConfiguration
	 * @generated
	 */
	EClass getSearchConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.SearchConfiguration#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see uam.extremo.core.SearchConfiguration#getId()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EAttribute getSearchConfiguration_Id();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.SearchConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uam.extremo.core.SearchConfiguration#getName()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EAttribute getSearchConfiguration_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.SearchConfiguration#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see uam.extremo.core.SearchConfiguration#getResults()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EReference getSearchConfiguration_Results();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.SimpleSearchConfiguration <em>Simple Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Search Configuration</em>'.
	 * @see uam.extremo.core.SimpleSearchConfiguration
	 * @generated
	 */
	EClass getSimpleSearchConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.SimpleSearchConfiguration#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see uam.extremo.core.SimpleSearchConfiguration#getOptions()
	 * @see #getSimpleSearchConfiguration()
	 * @generated
	 */
	EReference getSimpleSearchConfiguration_Options();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.SimpleSearchConfiguration#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see uam.extremo.core.SimpleSearchConfiguration#getDescription()
	 * @see #getSimpleSearchConfiguration()
	 * @generated
	 */
	EAttribute getSimpleSearchConfiguration_Description();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.SimpleSearchConfiguration#getFilterBy <em>Filter By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter By</em>'.
	 * @see uam.extremo.core.SimpleSearchConfiguration#getFilterBy()
	 * @see #getSimpleSearchConfiguration()
	 * @generated
	 */
	EAttribute getSimpleSearchConfiguration_FilterBy();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.SimpleSearchConfiguration#addPrimitiveTypeSearchOption(java.lang.String, java.lang.String, uam.extremo.core.Type) <em>Add Primitive Type Search Option</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Primitive Type Search Option</em>' operation.
	 * @see uam.extremo.core.SimpleSearchConfiguration#addPrimitiveTypeSearchOption(java.lang.String, java.lang.String, uam.extremo.core.Type)
	 * @generated
	 */
	EOperation getSimpleSearchConfiguration__AddPrimitiveTypeSearchOption__String_String_Type();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.SimpleSearchConfiguration#addDataModelTypeSearchOption(java.lang.String, java.lang.String, uam.extremo.core.DataModelType) <em>Add Data Model Type Search Option</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Data Model Type Search Option</em>' operation.
	 * @see uam.extremo.core.SimpleSearchConfiguration#addDataModelTypeSearchOption(java.lang.String, java.lang.String, uam.extremo.core.DataModelType)
	 * @generated
	 */
	EOperation getSimpleSearchConfiguration__AddDataModelTypeSearchOption__String_String_DataModelType();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.CompositeSearchConfiguration <em>Composite Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Search Configuration</em>'.
	 * @see uam.extremo.core.CompositeSearchConfiguration
	 * @generated
	 */
	EClass getCompositeSearchConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.CompositeSearchConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uam.extremo.core.CompositeSearchConfiguration#getType()
	 * @see #getCompositeSearchConfiguration()
	 * @generated
	 */
	EAttribute getCompositeSearchConfiguration_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.CompositeSearchConfiguration#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see uam.extremo.core.CompositeSearchConfiguration#getChildren()
	 * @see #getCompositeSearchConfiguration()
	 * @generated
	 */
	EReference getCompositeSearchConfiguration_Children();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.CompositeSearchConfiguration#getInputSearchResults <em>Input Search Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Search Results</em>'.
	 * @see uam.extremo.core.CompositeSearchConfiguration#getInputSearchResults()
	 * @see #getCompositeSearchConfiguration()
	 * @generated
	 */
	EReference getCompositeSearchConfiguration_InputSearchResults();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.CompositeSearchConfiguration#search(uam.extremo.core.SearchResult) <em>Search</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Search</em>' operation.
	 * @see uam.extremo.core.CompositeSearchConfiguration#search(uam.extremo.core.SearchResult)
	 * @generated
	 */
	EOperation getCompositeSearchConfiguration__Search__SearchResult();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see uam.extremo.core.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Service#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see uam.extremo.core.Service#getId()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Id();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uam.extremo.core.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Name();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Service#getFilterBy <em>Filter By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter By</em>'.
	 * @see uam.extremo.core.Service#getFilterBy()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_FilterBy();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.Service#matches(java.lang.String, java.lang.String) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Matches</em>' operation.
	 * @see uam.extremo.core.Service#matches(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getService__Matches__String_String();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.CustomSearch <em>Custom Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Search</em>'.
	 * @see uam.extremo.core.CustomSearch
	 * @generated
	 */
	EClass getCustomSearch();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.CustomSearch#isGrouped <em>Grouped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grouped</em>'.
	 * @see uam.extremo.core.CustomSearch#isGrouped()
	 * @see #getCustomSearch()
	 * @generated
	 */
	EAttribute getCustomSearch_Grouped();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.CustomSearch#search(uam.extremo.core.SearchResult) <em>Search</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Search</em>' operation.
	 * @see uam.extremo.core.CustomSearch#search(uam.extremo.core.SearchResult)
	 * @generated
	 */
	EOperation getCustomSearch__Search__SearchResult();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.PredicateBasedSearch <em>Predicate Based Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate Based Search</em>'.
	 * @see uam.extremo.core.PredicateBasedSearch
	 * @generated
	 */
	EClass getPredicateBasedSearch();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.PredicateBasedSearch#matches(uam.extremo.core.NamedElement) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Matches</em>' operation.
	 * @see uam.extremo.core.PredicateBasedSearch#matches(uam.extremo.core.NamedElement)
	 * @generated
	 */
	EOperation getPredicateBasedSearch__Matches__NamedElement();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.PredicateBasedSearch#getOptionValueKey(java.lang.String, org.eclipse.emf.common.util.EList) <em>Get Option Value Key</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Option Value Key</em>' operation.
	 * @see uam.extremo.core.PredicateBasedSearch#getOptionValueKey(java.lang.String, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getPredicateBasedSearch__GetOptionValueKey__String_EList();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.PredicateBasedSearch#init(org.eclipse.emf.common.util.EList) <em>Init</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Init</em>' operation.
	 * @see uam.extremo.core.PredicateBasedSearch#init(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getPredicateBasedSearch__Init__EList();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.AtomicSearchResult <em>Atomic Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Search Result</em>'.
	 * @see uam.extremo.core.AtomicSearchResult
	 * @generated
	 */
	EClass getAtomicSearchResult();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.AtomicSearchResult#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see uam.extremo.core.AtomicSearchResult#getElements()
	 * @see #getAtomicSearchResult()
	 * @generated
	 */
	EReference getAtomicSearchResult_Elements();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.GroupedSearchResult <em>Grouped Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grouped Search Result</em>'.
	 * @see uam.extremo.core.GroupedSearchResult
	 * @generated
	 */
	EClass getGroupedSearchResult();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.GroupedSearchResult#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see uam.extremo.core.GroupedSearchResult#getGroups()
	 * @see #getGroupedSearchResult()
	 * @generated
	 */
	EReference getGroupedSearchResult_Groups();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.GroupedSearchResult#createSemanticGroup(java.lang.String, java.lang.String) <em>Create Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Semantic Group</em>' operation.
	 * @see uam.extremo.core.GroupedSearchResult#createSemanticGroup(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getGroupedSearchResult__CreateSemanticGroup__String_String();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.GroupedSearchResult#addSemanticNodeToSemanticGroup(uam.extremo.core.SemanticGroup, uam.extremo.core.SemanticNode) <em>Add Semantic Node To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Semantic Node To Semantic Group</em>' operation.
	 * @see uam.extremo.core.GroupedSearchResult#addSemanticNodeToSemanticGroup(uam.extremo.core.SemanticGroup, uam.extremo.core.SemanticNode)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddSemanticNodeToSemanticGroup__SemanticGroup_SemanticNode();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.GroupedSearchResult#addDataPropertyToSemanticGroup(uam.extremo.core.SemanticGroup, uam.extremo.core.DataProperty) <em>Add Data Property To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Data Property To Semantic Group</em>' operation.
	 * @see uam.extremo.core.GroupedSearchResult#addDataPropertyToSemanticGroup(uam.extremo.core.SemanticGroup, uam.extremo.core.DataProperty)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddDataPropertyToSemanticGroup__SemanticGroup_DataProperty();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.GroupedSearchResult#addObjectPropertyToSemanticGroup(uam.extremo.core.SemanticGroup, uam.extremo.core.ObjectProperty) <em>Add Object Property To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Object Property To Semantic Group</em>' operation.
	 * @see uam.extremo.core.GroupedSearchResult#addObjectPropertyToSemanticGroup(uam.extremo.core.SemanticGroup, uam.extremo.core.ObjectProperty)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddObjectPropertyToSemanticGroup__SemanticGroup_ObjectProperty();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.GroupedSearchResult#addNamedElementToSemanticGroup(uam.extremo.core.SemanticGroup, uam.extremo.core.NamedElement) <em>Add Named Element To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Named Element To Semantic Group</em>' operation.
	 * @see uam.extremo.core.GroupedSearchResult#addNamedElementToSemanticGroup(uam.extremo.core.SemanticGroup, uam.extremo.core.NamedElement)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddNamedElementToSemanticGroup__SemanticGroup_NamedElement();

	/**
	 * Returns the meta object for the '{@link uam.extremo.core.GroupedSearchResult#addResourceToSemanticGroup(uam.extremo.core.SemanticGroup, uam.extremo.core.Resource) <em>Add Resource To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Resource To Semantic Group</em>' operation.
	 * @see uam.extremo.core.GroupedSearchResult#addResourceToSemanticGroup(uam.extremo.core.SemanticGroup, uam.extremo.core.Resource)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddResourceToSemanticGroup__SemanticGroup_Resource();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.SemanticGroup <em>Semantic Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantic Group</em>'.
	 * @see uam.extremo.core.SemanticGroup
	 * @generated
	 */
	EClass getSemanticGroup();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.SemanticGroup#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see uam.extremo.core.SemanticGroup#getElements()
	 * @see #getSemanticGroup()
	 * @generated
	 */
	EReference getSemanticGroup_Elements();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see uam.extremo.core.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.Repository#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see uam.extremo.core.Repository#getResources()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Resources();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Repository#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project</em>'.
	 * @see uam.extremo.core.Repository#getProject()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Project();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Repository#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uam.extremo.core.Repository#getName()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Name();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Repository#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see uam.extremo.core.Repository#getDescription()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Description();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see uam.extremo.core.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Resource#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see uam.extremo.core.Resource#isActive()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Active();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Resource#isAlive <em>Alive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alive</em>'.
	 * @see uam.extremo.core.Resource#isAlive()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Alive();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Resource#getAssistant <em>Assistant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assistant</em>'.
	 * @see uam.extremo.core.Resource#getAssistant()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Assistant();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.Resource#getResourceElements <em>Resource Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Elements</em>'.
	 * @see uam.extremo.core.Resource#getResourceElements()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_ResourceElements();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Resource#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see uam.extremo.core.Resource#getUri()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Uri();

	/**
	 * Returns the meta object for the container reference '{@link uam.extremo.core.Resource#getRepositoryFrom <em>Repository From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository From</em>'.
	 * @see uam.extremo.core.Resource#getRepositoryFrom()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_RepositoryFrom();

	/**
	 * Returns the meta object for the reference '{@link uam.extremo.core.Resource#getDefaultConstraintInterpreter <em>Default Constraint Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Constraint Interpreter</em>'.
	 * @see uam.extremo.core.Resource#getDefaultConstraintInterpreter()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_DefaultConstraintInterpreter();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.SemanticNode <em>Semantic Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantic Node</em>'.
	 * @see uam.extremo.core.SemanticNode
	 * @generated
	 */
	EClass getSemanticNode();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.SemanticNode#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see uam.extremo.core.SemanticNode#getProperties()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EReference getSemanticNode_Properties();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.SemanticNode#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see uam.extremo.core.SemanticNode#isAbstract()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EAttribute getSemanticNode_Abstract();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.SemanticNode#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Domain</em>'.
	 * @see uam.extremo.core.SemanticNode#getDomain()
	 * @see #getSemanticNode()
	 * @generated
	 */
	EReference getSemanticNode_Domain();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see uam.extremo.core.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see uam.extremo.core.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.NamedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see uam.extremo.core.NamedElement#getDescription()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.NamedElement#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see uam.extremo.core.NamedElement#getWeight()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Weight();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.NamedElement#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see uam.extremo.core.NamedElement#getTrace()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Trace();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.NamedElement#isDrawn <em>Drawn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Drawn</em>'.
	 * @see uam.extremo.core.NamedElement#isDrawn()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Drawn();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.NamedElement#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Descriptors</em>'.
	 * @see uam.extremo.core.NamedElement#getDescriptors()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Descriptors();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.NamedElement#getDescribes <em>Describes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Describes</em>'.
	 * @see uam.extremo.core.NamedElement#getDescribes()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Describes();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.NamedElement#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see uam.extremo.core.NamedElement#getConstraints()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link uam.extremo.core.NamedElement#getMetadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metadata</em>'.
	 * @see uam.extremo.core.NamedElement#getMetadata()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Metadata();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.NamedElement#getSupers <em>Supers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supers</em>'.
	 * @see uam.extremo.core.NamedElement#getSupers()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Supers();

	/**
	 * Returns the meta object for the reference list '{@link uam.extremo.core.NamedElement#getSubs <em>Subs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subs</em>'.
	 * @see uam.extremo.core.NamedElement#getSubs()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Subs();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see uam.extremo.core.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the container reference '{@link uam.extremo.core.Property#getSemanticNodeFrom <em>Semantic Node From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Semantic Node From</em>'.
	 * @see uam.extremo.core.Property#getSemanticNodeFrom()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_SemanticNodeFrom();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Property#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see uam.extremo.core.Property#getLowerBound()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.Property#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see uam.extremo.core.Property#getUpperBound()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_UpperBound();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.ObjectProperty <em>Object Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Property</em>'.
	 * @see uam.extremo.core.ObjectProperty
	 * @generated
	 */
	EClass getObjectProperty();

	/**
	 * Returns the meta object for the reference '{@link uam.extremo.core.ObjectProperty#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Range</em>'.
	 * @see uam.extremo.core.ObjectProperty#getRange()
	 * @see #getObjectProperty()
	 * @generated
	 */
	EReference getObjectProperty_Range();

	/**
	 * Returns the meta object for the reference '{@link uam.extremo.core.ObjectProperty#getInverseOf <em>Inverse Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inverse Of</em>'.
	 * @see uam.extremo.core.ObjectProperty#getInverseOf()
	 * @see #getObjectProperty()
	 * @generated
	 */
	EReference getObjectProperty_InverseOf();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.DataProperty <em>Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Property</em>'.
	 * @see uam.extremo.core.DataProperty
	 * @generated
	 */
	EClass getDataProperty();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.DataProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uam.extremo.core.DataProperty#getType()
	 * @see #getDataProperty()
	 * @generated
	 */
	EAttribute getDataProperty_Type();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.DataProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see uam.extremo.core.DataProperty#getValue()
	 * @see #getDataProperty()
	 * @generated
	 */
	EAttribute getDataProperty_Value();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.MetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Data</em>'.
	 * @see uam.extremo.core.MetaData
	 * @generated
	 */
	EClass getMetaData();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.MetaData#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see uam.extremo.core.MetaData#getKey()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_Key();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.MetaData#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see uam.extremo.core.MetaData#getValue()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_Value();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.ResourceElement <em>Resource Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Element</em>'.
	 * @see uam.extremo.core.ResourceElement
	 * @generated
	 */
	EClass getResourceElement();

	/**
	 * Returns the meta object for the container reference '{@link uam.extremo.core.ResourceElement#getResourceFrom <em>Resource From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource From</em>'.
	 * @see uam.extremo.core.ResourceElement#getResourceFrom()
	 * @see #getResourceElement()
	 * @generated
	 */
	EReference getResourceElement_ResourceFrom();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.PrimitiveTypeParam <em>Primitive Type Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Param</em>'.
	 * @see uam.extremo.core.PrimitiveTypeParam
	 * @generated
	 */
	EClass getPrimitiveTypeParam();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.PrimitiveTypeParam#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uam.extremo.core.PrimitiveTypeParam#getType()
	 * @see #getPrimitiveTypeParam()
	 * @generated
	 */
	EAttribute getPrimitiveTypeParam_Type();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.ModelTypeParam <em>Model Type Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type Param</em>'.
	 * @see uam.extremo.core.ModelTypeParam
	 * @generated
	 */
	EClass getModelTypeParam();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.ModelTypeParam#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see uam.extremo.core.ModelTypeParam#getType()
	 * @see #getModelTypeParam()
	 * @generated
	 */
	EAttribute getModelTypeParam_Type();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.ModelTypeParamValue <em>Model Type Param Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Type Param Value</em>'.
	 * @see uam.extremo.core.ModelTypeParamValue
	 * @generated
	 */
	EClass getModelTypeParamValue();

	/**
	 * Returns the meta object for the reference '{@link uam.extremo.core.ModelTypeParamValue#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Option</em>'.
	 * @see uam.extremo.core.ModelTypeParamValue#getOption()
	 * @see #getModelTypeParamValue()
	 * @generated
	 */
	EReference getModelTypeParamValue_Option();

	/**
	 * Returns the meta object for the reference '{@link uam.extremo.core.ModelTypeParamValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see uam.extremo.core.ModelTypeParamValue#getValue()
	 * @see #getModelTypeParamValue()
	 * @generated
	 */
	EReference getModelTypeParamValue_Value();

	/**
	 * Returns the meta object for class '{@link uam.extremo.core.PrimitiveTypeParamValue <em>Primitive Type Param Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Param Value</em>'.
	 * @see uam.extremo.core.PrimitiveTypeParamValue
	 * @generated
	 */
	EClass getPrimitiveTypeParamValue();

	/**
	 * Returns the meta object for the attribute '{@link uam.extremo.core.PrimitiveTypeParamValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see uam.extremo.core.PrimitiveTypeParamValue#getValue()
	 * @see #getPrimitiveTypeParamValue()
	 * @generated
	 */
	EAttribute getPrimitiveTypeParamValue_Value();

	/**
	 * Returns the meta object for the reference '{@link uam.extremo.core.PrimitiveTypeParamValue#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Option</em>'.
	 * @see uam.extremo.core.PrimitiveTypeParamValue#getOption()
	 * @see #getPrimitiveTypeParamValue()
	 * @generated
	 */
	EReference getPrimitiveTypeParamValue_Option();

	/**
	 * Returns the meta object for the reference '{@link uam.extremo.core.PrimitiveTypeParamValue#getCalls <em>Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Calls</em>'.
	 * @see uam.extremo.core.PrimitiveTypeParamValue#getCalls()
	 * @see #getPrimitiveTypeParamValue()
	 * @generated
	 */
	EReference getPrimitiveTypeParamValue_Calls();

	/**
	 * Returns the meta object for enum '{@link uam.extremo.core.ConnectionType <em>Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Connection Type</em>'.
	 * @see uam.extremo.core.ConnectionType
	 * @generated
	 */
	EEnum getConnectionType();

	/**
	 * Returns the meta object for enum '{@link uam.extremo.core.DataModelType <em>Data Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Model Type</em>'.
	 * @see uam.extremo.core.DataModelType
	 * @generated
	 */
	EEnum getDataModelType();

	/**
	 * Returns the meta object for enum '{@link uam.extremo.core.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see uam.extremo.core.Type
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.RepositoryManagerImpl <em>Repository Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.RepositoryManagerImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getRepositoryManager()
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
		 * The meta object literal for the '<em><b>Interpreters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_MANAGER__INTERPRETERS = eINSTANCE.getRepositoryManager_Interpreters();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY_MANAGER__SERVICES = eINSTANCE.getRepositoryManager_Services();

		/**
		 * The meta object literal for the '{@link uam.extremo.core.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.ConstraintImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getConstraint()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.ConstraintInterpreterImpl <em>Constraint Interpreter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.ConstraintInterpreterImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getConstraintInterpreter()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.ConstraintResultImpl <em>Constraint Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.ConstraintResultImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getConstraintResult()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.SearchParamImpl <em>Search Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.SearchParamImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSearchParam()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.SearchResultImpl <em>Search Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.SearchResultImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSearchResult()
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
		 * The meta object literal for the '<em><b>Apply On Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_RESULT__APPLY_ON_ELEMENTS = eINSTANCE.getSearchResult_ApplyOnElements();

		/**
		 * The meta object literal for the '<em><b>Get Option Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SEARCH_RESULT___GET_OPTION_VALUE__STRING = eINSTANCE.getSearchResult__GetOptionValue__String();

		/**
		 * The meta object literal for the '{@link uam.extremo.core.impl.SearchParamValueImpl <em>Search Param Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.SearchParamValueImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSearchParamValue()
		 * @generated
		 */
		EClass SEARCH_PARAM_VALUE = eINSTANCE.getSearchParamValue();

		/**
		 * The meta object literal for the '{@link uam.extremo.core.impl.SearchConfigurationImpl <em>Search Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.SearchConfigurationImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSearchConfiguration()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.SimpleSearchConfigurationImpl <em>Simple Search Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.SimpleSearchConfigurationImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSimpleSearchConfiguration()
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
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SEARCH_CONFIGURATION__DESCRIPTION = eINSTANCE.getSimpleSearchConfiguration_Description();

		/**
		 * The meta object literal for the '<em><b>Filter By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SEARCH_CONFIGURATION__FILTER_BY = eINSTANCE.getSimpleSearchConfiguration_FilterBy();

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
		 * The meta object literal for the '{@link uam.extremo.core.impl.CompositeSearchConfigurationImpl <em>Composite Search Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.CompositeSearchConfigurationImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getCompositeSearchConfiguration()
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
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_SEARCH_CONFIGURATION__CHILDREN = eINSTANCE.getCompositeSearchConfiguration_Children();

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
		 * The meta object literal for the '{@link uam.extremo.core.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.ServiceImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getService()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.CustomSearchImpl <em>Custom Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.CustomSearchImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getCustomSearch()
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
		EOperation CUSTOM_SEARCH___SEARCH__SEARCHRESULT = eINSTANCE.getCustomSearch__Search__SearchResult();

		/**
		 * The meta object literal for the '{@link uam.extremo.core.impl.PredicateBasedSearchImpl <em>Predicate Based Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.PredicateBasedSearchImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getPredicateBasedSearch()
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
		 * The meta object literal for the '<em><b>Get Option Value Key</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PREDICATE_BASED_SEARCH___GET_OPTION_VALUE_KEY__STRING_ELIST = eINSTANCE.getPredicateBasedSearch__GetOptionValueKey__String_EList();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PREDICATE_BASED_SEARCH___INIT__ELIST = eINSTANCE.getPredicateBasedSearch__Init__EList();

		/**
		 * The meta object literal for the '{@link uam.extremo.core.impl.AtomicSearchResultImpl <em>Atomic Search Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.AtomicSearchResultImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getAtomicSearchResult()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.GroupedSearchResultImpl <em>Grouped Search Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.GroupedSearchResultImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getGroupedSearchResult()
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
		 * The meta object literal for the '<em><b>Add Semantic Node To Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GROUPED_SEARCH_RESULT___ADD_SEMANTIC_NODE_TO_SEMANTIC_GROUP__SEMANTICGROUP_SEMANTICNODE = eINSTANCE.getGroupedSearchResult__AddSemanticNodeToSemanticGroup__SemanticGroup_SemanticNode();

		/**
		 * The meta object literal for the '<em><b>Add Data Property To Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GROUPED_SEARCH_RESULT___ADD_DATA_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_DATAPROPERTY = eINSTANCE.getGroupedSearchResult__AddDataPropertyToSemanticGroup__SemanticGroup_DataProperty();

		/**
		 * The meta object literal for the '<em><b>Add Object Property To Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GROUPED_SEARCH_RESULT___ADD_OBJECT_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_OBJECTPROPERTY = eINSTANCE.getGroupedSearchResult__AddObjectPropertyToSemanticGroup__SemanticGroup_ObjectProperty();

		/**
		 * The meta object literal for the '<em><b>Add Named Element To Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GROUPED_SEARCH_RESULT___ADD_NAMED_ELEMENT_TO_SEMANTIC_GROUP__SEMANTICGROUP_NAMEDELEMENT = eINSTANCE.getGroupedSearchResult__AddNamedElementToSemanticGroup__SemanticGroup_NamedElement();

		/**
		 * The meta object literal for the '<em><b>Add Resource To Semantic Group</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GROUPED_SEARCH_RESULT___ADD_RESOURCE_TO_SEMANTIC_GROUP__SEMANTICGROUP_RESOURCE = eINSTANCE.getGroupedSearchResult__AddResourceToSemanticGroup__SemanticGroup_Resource();

		/**
		 * The meta object literal for the '{@link uam.extremo.core.impl.SemanticGroupImpl <em>Semantic Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.SemanticGroupImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSemanticGroup()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.RepositoryImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getRepository()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.ResourceImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getResource()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.SemanticNodeImpl <em>Semantic Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.SemanticNodeImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getSemanticNode()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.NamedElementImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.PropertyImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getProperty()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.ObjectPropertyImpl <em>Object Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.ObjectPropertyImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getObjectProperty()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.DataPropertyImpl <em>Data Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.DataPropertyImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getDataProperty()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.MetaDataImpl <em>Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.MetaDataImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getMetaData()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.ResourceElementImpl <em>Resource Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.ResourceElementImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getResourceElement()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.PrimitiveTypeParamImpl <em>Primitive Type Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.PrimitiveTypeParamImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getPrimitiveTypeParam()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.ModelTypeParamImpl <em>Model Type Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.ModelTypeParamImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getModelTypeParam()
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
		 * The meta object literal for the '{@link uam.extremo.core.impl.ModelTypeParamValueImpl <em>Model Type Param Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.ModelTypeParamValueImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getModelTypeParamValue()
		 * @generated
		 */
		EClass MODEL_TYPE_PARAM_VALUE = eINSTANCE.getModelTypeParamValue();

		/**
		 * The meta object literal for the '<em><b>Option</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE_PARAM_VALUE__OPTION = eINSTANCE.getModelTypeParamValue_Option();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TYPE_PARAM_VALUE__VALUE = eINSTANCE.getModelTypeParamValue_Value();

		/**
		 * The meta object literal for the '{@link uam.extremo.core.impl.PrimitiveTypeParamValueImpl <em>Primitive Type Param Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.impl.PrimitiveTypeParamValueImpl
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getPrimitiveTypeParamValue()
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
		 * The meta object literal for the '<em><b>Option</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPE_PARAM_VALUE__OPTION = eINSTANCE.getPrimitiveTypeParamValue_Option();

		/**
		 * The meta object literal for the '<em><b>Calls</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_TYPE_PARAM_VALUE__CALLS = eINSTANCE.getPrimitiveTypeParamValue_Calls();

		/**
		 * The meta object literal for the '{@link uam.extremo.core.ConnectionType <em>Connection Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.ConnectionType
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getConnectionType()
		 * @generated
		 */
		EEnum CONNECTION_TYPE = eINSTANCE.getConnectionType();

		/**
		 * The meta object literal for the '{@link uam.extremo.core.DataModelType <em>Data Model Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.DataModelType
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getDataModelType()
		 * @generated
		 */
		EEnum DATA_MODEL_TYPE = eINSTANCE.getDataModelType();

		/**
		 * The meta object literal for the '{@link uam.extremo.core.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see uam.extremo.core.Type
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em>Java Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see uam.extremo.core.impl.SemanticmanagerPackageImpl#getJavaObject()
		 * @generated
		 */
		EDataType JAVA_OBJECT = eINSTANCE.getJavaObject();

	}

} //SemanticmanagerPackage
