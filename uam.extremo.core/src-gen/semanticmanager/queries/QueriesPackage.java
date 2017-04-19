/**
 */
package semanticmanager.queries;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import semanticmanager.dataModel.DataModelPackage;

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
 * @see semanticmanager.queries.QueriesFactory
 * @model kind="package"
 * @generated
 */
public interface QueriesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "queries";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "queries";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "queries";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QueriesPackage eINSTANCE = semanticmanager.queries.impl.QueriesPackageImpl.init();

	/**
	 * The meta object id for the '{@link semanticmanager.queries.impl.SearchOptionImpl <em>Search Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.SearchOptionImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSearchOption()
	 * @generated
	 */
	int SEARCH_OPTION = 0;

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
	 * The meta object id for the '{@link semanticmanager.queries.impl.SearchResultImpl <em>Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.SearchResultImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSearchResult()
	 * @generated
	 */
	int SEARCH_RESULT = 1;

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
	 * The number of operations of the '<em>Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link semanticmanager.queries.impl.SearchResultOptionValueImpl <em>Search Result Option Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.SearchResultOptionValueImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSearchResultOptionValue()
	 * @generated
	 */
	int SEARCH_RESULT_OPTION_VALUE = 2;

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
	 * The meta object id for the '{@link semanticmanager.queries.impl.SearchConfigurationImpl <em>Search Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.SearchConfigurationImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSearchConfiguration()
	 * @generated
	 */
	int SEARCH_CONFIGURATION = 3;

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
	 * The meta object id for the '{@link semanticmanager.queries.impl.SimpleSearchConfigurationImpl <em>Simple Search Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.SimpleSearchConfigurationImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSimpleSearchConfiguration()
	 * @generated
	 */
	int SIMPLE_SEARCH_CONFIGURATION = 4;

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
	 * The feature id for the '<em><b>Filter By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION__FILTER_BY = SEARCH_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION_FEATURE_COUNT = SEARCH_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Add Search Option</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION___ADD_SEARCH_OPTION__STRING_STRING_TYPE = SEARCH_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Simple Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_SEARCH_CONFIGURATION_OPERATION_COUNT = SEARCH_CONFIGURATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link semanticmanager.queries.impl.CompositeSearchConfigurationImpl <em>Composite Search Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.CompositeSearchConfigurationImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getCompositeSearchConfiguration()
	 * @generated
	 */
	int COMPOSITE_SEARCH_CONFIGURATION = 5;

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
	 * The feature id for the '<em><b>Queries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__QUERIES = SEARCH_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION__TYPE = SEARCH_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION_FEATURE_COUNT = SEARCH_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composite Search Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_SEARCH_CONFIGURATION_OPERATION_COUNT = SEARCH_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.queries.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.ServiceImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 6;

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
	 * The meta object id for the '{@link semanticmanager.queries.impl.CustomSearchImpl <em>Custom Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.CustomSearchImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getCustomSearch()
	 * @generated
	 */
	int CUSTOM_SEARCH = 7;

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
	 * The feature id for the '<em><b>Filter By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH__FILTER_BY = SIMPLE_SEARCH_CONFIGURATION__FILTER_BY;

	/**
	 * The number of structural features of the '<em>Custom Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH_FEATURE_COUNT = SIMPLE_SEARCH_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Add Search Option</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_SEARCH___ADD_SEARCH_OPTION__STRING_STRING_TYPE = SIMPLE_SEARCH_CONFIGURATION___ADD_SEARCH_OPTION__STRING_STRING_TYPE;

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
	 * The meta object id for the '{@link semanticmanager.queries.impl.PredicateBasedSearchImpl <em>Predicate Based Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.PredicateBasedSearchImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getPredicateBasedSearch()
	 * @generated
	 */
	int PREDICATE_BASED_SEARCH = 8;

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
	 * The operation id for the '<em>Add Search Option</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_BASED_SEARCH___ADD_SEARCH_OPTION__STRING_STRING_TYPE = SIMPLE_SEARCH_CONFIGURATION___ADD_SEARCH_OPTION__STRING_STRING_TYPE;

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
	 * The meta object id for the '{@link semanticmanager.queries.impl.AtomicSearchResultImpl <em>Atomic Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.AtomicSearchResultImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getAtomicSearchResult()
	 * @generated
	 */
	int ATOMIC_SEARCH_RESULT = 9;

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
	 * The number of operations of the '<em>Atomic Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_SEARCH_RESULT_OPERATION_COUNT = SEARCH_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.queries.impl.GroupedSearchResultImpl <em>Grouped Search Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.GroupedSearchResultImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getGroupedSearchResult()
	 * @generated
	 */
	int GROUPED_SEARCH_RESULT = 10;

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
	 * The operation id for the '<em>Get Option Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___GET_OPTION_VALUE__STRING = SEARCH_RESULT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Add Named Element To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___ADD_NAMED_ELEMENT_TO_SEMANTIC_GROUP__SEMANTICGROUP_NAMEDELEMENT = SEARCH_RESULT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Add Resource To Semantic Group</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT___ADD_RESOURCE_TO_SEMANTIC_GROUP__SEMANTICGROUP_RESOURCE = SEARCH_RESULT_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Grouped Search Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_SEARCH_RESULT_OPERATION_COUNT = SEARCH_RESULT_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link semanticmanager.queries.impl.SemanticGroupImpl <em>Semantic Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.impl.SemanticGroupImpl
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSemanticGroup()
	 * @generated
	 */
	int SEMANTIC_GROUP = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__NAME = DataModelPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__DESCRIPTION = DataModelPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__WEIGHT = DataModelPackage.NAMED_ELEMENT__WEIGHT;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__TRACE = DataModelPackage.NAMED_ELEMENT__TRACE;

	/**
	 * The feature id for the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__DRAWN = DataModelPackage.NAMED_ELEMENT__DRAWN;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__DESCRIPTOR = DataModelPackage.NAMED_ELEMENT__DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Describes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__DESCRIBES = DataModelPackage.NAMED_ELEMENT__DESCRIBES;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__CONSTRAINTS = DataModelPackage.NAMED_ELEMENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP__ELEMENTS = DataModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Semantic Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP_FEATURE_COUNT = DataModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Semantic Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_GROUP_OPERATION_COUNT = DataModelPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link semanticmanager.queries.ConnectionType <em>Connection Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.ConnectionType
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getConnectionType()
	 * @generated
	 */
	int CONNECTION_TYPE = 12;

	/**
	 * The meta object id for the '{@link semanticmanager.queries.DataModelType <em>Data Model Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.queries.DataModelType
	 * @see semanticmanager.queries.impl.QueriesPackageImpl#getDataModelType()
	 * @generated
	 */
	int DATA_MODEL_TYPE = 13;


	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.SearchOption <em>Search Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Option</em>'.
	 * @see semanticmanager.queries.SearchOption
	 * @generated
	 */
	EClass getSearchOption();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.SearchOption#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see semanticmanager.queries.SearchOption#getType()
	 * @see #getSearchOption()
	 * @generated
	 */
	EAttribute getSearchOption_Type();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.SearchOption#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.queries.SearchOption#getName()
	 * @see #getSearchOption()
	 * @generated
	 */
	EAttribute getSearchOption_Name();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.SearchOption#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.queries.SearchOption#getId()
	 * @see #getSearchOption()
	 * @generated
	 */
	EAttribute getSearchOption_Id();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.SearchResult <em>Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Result</em>'.
	 * @see semanticmanager.queries.SearchResult
	 * @generated
	 */
	EClass getSearchResult();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.queries.SearchResult#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see semanticmanager.queries.SearchResult#getValues()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_Values();

	/**
	 * Returns the meta object for the container reference '{@link semanticmanager.queries.SearchResult#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Configuration</em>'.
	 * @see semanticmanager.queries.SearchResult#getConfiguration()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_Configuration();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.queries.SearchResult#getApplyOnElements <em>Apply On Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Apply On Elements</em>'.
	 * @see semanticmanager.queries.SearchResult#getApplyOnElements()
	 * @see #getSearchResult()
	 * @generated
	 */
	EReference getSearchResult_ApplyOnElements();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.SearchResultOptionValue <em>Search Result Option Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Result Option Value</em>'.
	 * @see semanticmanager.queries.SearchResultOptionValue
	 * @generated
	 */
	EClass getSearchResultOptionValue();

	/**
	 * Returns the meta object for the reference '{@link semanticmanager.queries.SearchResultOptionValue#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Option</em>'.
	 * @see semanticmanager.queries.SearchResultOptionValue#getOption()
	 * @see #getSearchResultOptionValue()
	 * @generated
	 */
	EReference getSearchResultOptionValue_Option();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.SearchResultOptionValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see semanticmanager.queries.SearchResultOptionValue#getValue()
	 * @see #getSearchResultOptionValue()
	 * @generated
	 */
	EAttribute getSearchResultOptionValue_Value();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.SearchConfiguration <em>Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Configuration</em>'.
	 * @see semanticmanager.queries.SearchConfiguration
	 * @generated
	 */
	EClass getSearchConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.SearchConfiguration#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.queries.SearchConfiguration#getId()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EAttribute getSearchConfiguration_Id();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.SearchConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.queries.SearchConfiguration#getName()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EAttribute getSearchConfiguration_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.queries.SearchConfiguration#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see semanticmanager.queries.SearchConfiguration#getResults()
	 * @see #getSearchConfiguration()
	 * @generated
	 */
	EReference getSearchConfiguration_Results();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.SimpleSearchConfiguration <em>Simple Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Search Configuration</em>'.
	 * @see semanticmanager.queries.SimpleSearchConfiguration
	 * @generated
	 */
	EClass getSimpleSearchConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.queries.SimpleSearchConfiguration#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see semanticmanager.queries.SimpleSearchConfiguration#getOptions()
	 * @see #getSimpleSearchConfiguration()
	 * @generated
	 */
	EReference getSimpleSearchConfiguration_Options();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.SimpleSearchConfiguration#getFilterBy <em>Filter By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter By</em>'.
	 * @see semanticmanager.queries.SimpleSearchConfiguration#getFilterBy()
	 * @see #getSimpleSearchConfiguration()
	 * @generated
	 */
	EAttribute getSimpleSearchConfiguration_FilterBy();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.SimpleSearchConfiguration#addSearchOption(java.lang.String, java.lang.String, semanticmanager.dataModel.Type) <em>Add Search Option</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Search Option</em>' operation.
	 * @see semanticmanager.queries.SimpleSearchConfiguration#addSearchOption(java.lang.String, java.lang.String, semanticmanager.dataModel.Type)
	 * @generated
	 */
	EOperation getSimpleSearchConfiguration__AddSearchOption__String_String_Type();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.CompositeSearchConfiguration <em>Composite Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Search Configuration</em>'.
	 * @see semanticmanager.queries.CompositeSearchConfiguration
	 * @generated
	 */
	EClass getCompositeSearchConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.queries.CompositeSearchConfiguration#getQueries <em>Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Queries</em>'.
	 * @see semanticmanager.queries.CompositeSearchConfiguration#getQueries()
	 * @see #getCompositeSearchConfiguration()
	 * @generated
	 */
	EReference getCompositeSearchConfiguration_Queries();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.CompositeSearchConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see semanticmanager.queries.CompositeSearchConfiguration#getType()
	 * @see #getCompositeSearchConfiguration()
	 * @generated
	 */
	EAttribute getCompositeSearchConfiguration_Type();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see semanticmanager.queries.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.Service#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see semanticmanager.queries.Service#getId()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Id();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.Service#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see semanticmanager.queries.Service#getName()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Name();

	/**
	 * Returns the meta object for the attribute '{@link semanticmanager.queries.Service#getFilterBy <em>Filter By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter By</em>'.
	 * @see semanticmanager.queries.Service#getFilterBy()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_FilterBy();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.Service#matches(java.lang.String, java.lang.String) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Matches</em>' operation.
	 * @see semanticmanager.queries.Service#matches(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getService__Matches__String_String();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.CustomSearch <em>Custom Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Search</em>'.
	 * @see semanticmanager.queries.CustomSearch
	 * @generated
	 */
	EClass getCustomSearch();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.CustomSearch#search(semanticmanager.queries.SearchResult) <em>Search</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Search</em>' operation.
	 * @see semanticmanager.queries.CustomSearch#search(semanticmanager.queries.SearchResult)
	 * @generated
	 */
	EOperation getCustomSearch__Search__SearchResult();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.PredicateBasedSearch <em>Predicate Based Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate Based Search</em>'.
	 * @see semanticmanager.queries.PredicateBasedSearch
	 * @generated
	 */
	EClass getPredicateBasedSearch();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.PredicateBasedSearch#matches(semanticmanager.dataModel.NamedElement) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Matches</em>' operation.
	 * @see semanticmanager.queries.PredicateBasedSearch#matches(semanticmanager.dataModel.NamedElement)
	 * @generated
	 */
	EOperation getPredicateBasedSearch__Matches__NamedElement();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.AtomicSearchResult <em>Atomic Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Search Result</em>'.
	 * @see semanticmanager.queries.AtomicSearchResult
	 * @generated
	 */
	EClass getAtomicSearchResult();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.queries.AtomicSearchResult#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see semanticmanager.queries.AtomicSearchResult#getElements()
	 * @see #getAtomicSearchResult()
	 * @generated
	 */
	EReference getAtomicSearchResult_Elements();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.GroupedSearchResult <em>Grouped Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grouped Search Result</em>'.
	 * @see semanticmanager.queries.GroupedSearchResult
	 * @generated
	 */
	EClass getGroupedSearchResult();

	/**
	 * Returns the meta object for the containment reference list '{@link semanticmanager.queries.GroupedSearchResult#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see semanticmanager.queries.GroupedSearchResult#getGroups()
	 * @see #getGroupedSearchResult()
	 * @generated
	 */
	EReference getGroupedSearchResult_Groups();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.GroupedSearchResult#createSemanticGroup(java.lang.String, java.lang.String) <em>Create Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Semantic Group</em>' operation.
	 * @see semanticmanager.queries.GroupedSearchResult#createSemanticGroup(java.lang.String, java.lang.String)
	 * @generated
	 */
	EOperation getGroupedSearchResult__CreateSemanticGroup__String_String();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.GroupedSearchResult#addSemanticNodeToSemanticGroup(semanticmanager.queries.SemanticGroup, semanticmanager.dataModel.SemanticNode) <em>Add Semantic Node To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Semantic Node To Semantic Group</em>' operation.
	 * @see semanticmanager.queries.GroupedSearchResult#addSemanticNodeToSemanticGroup(semanticmanager.queries.SemanticGroup, semanticmanager.dataModel.SemanticNode)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddSemanticNodeToSemanticGroup__SemanticGroup_SemanticNode();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.GroupedSearchResult#addDataPropertyToSemanticGroup(semanticmanager.queries.SemanticGroup, semanticmanager.dataModel.DataProperty) <em>Add Data Property To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Data Property To Semantic Group</em>' operation.
	 * @see semanticmanager.queries.GroupedSearchResult#addDataPropertyToSemanticGroup(semanticmanager.queries.SemanticGroup, semanticmanager.dataModel.DataProperty)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddDataPropertyToSemanticGroup__SemanticGroup_DataProperty();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.GroupedSearchResult#addObjectPropertyToSemanticGroup(semanticmanager.queries.SemanticGroup, semanticmanager.dataModel.ObjectProperty) <em>Add Object Property To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Object Property To Semantic Group</em>' operation.
	 * @see semanticmanager.queries.GroupedSearchResult#addObjectPropertyToSemanticGroup(semanticmanager.queries.SemanticGroup, semanticmanager.dataModel.ObjectProperty)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddObjectPropertyToSemanticGroup__SemanticGroup_ObjectProperty();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.GroupedSearchResult#getOptionValue(java.lang.String) <em>Get Option Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Option Value</em>' operation.
	 * @see semanticmanager.queries.GroupedSearchResult#getOptionValue(java.lang.String)
	 * @generated
	 */
	EOperation getGroupedSearchResult__GetOptionValue__String();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.GroupedSearchResult#addNamedElementToSemanticGroup(semanticmanager.queries.SemanticGroup, semanticmanager.dataModel.NamedElement) <em>Add Named Element To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Named Element To Semantic Group</em>' operation.
	 * @see semanticmanager.queries.GroupedSearchResult#addNamedElementToSemanticGroup(semanticmanager.queries.SemanticGroup, semanticmanager.dataModel.NamedElement)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddNamedElementToSemanticGroup__SemanticGroup_NamedElement();

	/**
	 * Returns the meta object for the '{@link semanticmanager.queries.GroupedSearchResult#addResourceToSemanticGroup(semanticmanager.queries.SemanticGroup, semanticmanager.dataModel.Resource) <em>Add Resource To Semantic Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Resource To Semantic Group</em>' operation.
	 * @see semanticmanager.queries.GroupedSearchResult#addResourceToSemanticGroup(semanticmanager.queries.SemanticGroup, semanticmanager.dataModel.Resource)
	 * @generated
	 */
	EOperation getGroupedSearchResult__AddResourceToSemanticGroup__SemanticGroup_Resource();

	/**
	 * Returns the meta object for class '{@link semanticmanager.queries.SemanticGroup <em>Semantic Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantic Group</em>'.
	 * @see semanticmanager.queries.SemanticGroup
	 * @generated
	 */
	EClass getSemanticGroup();

	/**
	 * Returns the meta object for the reference list '{@link semanticmanager.queries.SemanticGroup#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see semanticmanager.queries.SemanticGroup#getElements()
	 * @see #getSemanticGroup()
	 * @generated
	 */
	EReference getSemanticGroup_Elements();

	/**
	 * Returns the meta object for enum '{@link semanticmanager.queries.ConnectionType <em>Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Connection Type</em>'.
	 * @see semanticmanager.queries.ConnectionType
	 * @generated
	 */
	EEnum getConnectionType();

	/**
	 * Returns the meta object for enum '{@link semanticmanager.queries.DataModelType <em>Data Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Model Type</em>'.
	 * @see semanticmanager.queries.DataModelType
	 * @generated
	 */
	EEnum getDataModelType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QueriesFactory getQueriesFactory();

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
		 * The meta object literal for the '{@link semanticmanager.queries.impl.SearchOptionImpl <em>Search Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.SearchOptionImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSearchOption()
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
		 * The meta object literal for the '{@link semanticmanager.queries.impl.SearchResultImpl <em>Search Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.SearchResultImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSearchResult()
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
		 * The meta object literal for the '{@link semanticmanager.queries.impl.SearchResultOptionValueImpl <em>Search Result Option Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.SearchResultOptionValueImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSearchResultOptionValue()
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
		 * The meta object literal for the '{@link semanticmanager.queries.impl.SearchConfigurationImpl <em>Search Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.SearchConfigurationImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSearchConfiguration()
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
		 * The meta object literal for the '{@link semanticmanager.queries.impl.SimpleSearchConfigurationImpl <em>Simple Search Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.SimpleSearchConfigurationImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSimpleSearchConfiguration()
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
		 * The meta object literal for the '<em><b>Filter By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_SEARCH_CONFIGURATION__FILTER_BY = eINSTANCE.getSimpleSearchConfiguration_FilterBy();

		/**
		 * The meta object literal for the '<em><b>Add Search Option</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SIMPLE_SEARCH_CONFIGURATION___ADD_SEARCH_OPTION__STRING_STRING_TYPE = eINSTANCE.getSimpleSearchConfiguration__AddSearchOption__String_String_Type();

		/**
		 * The meta object literal for the '{@link semanticmanager.queries.impl.CompositeSearchConfigurationImpl <em>Composite Search Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.CompositeSearchConfigurationImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getCompositeSearchConfiguration()
		 * @generated
		 */
		EClass COMPOSITE_SEARCH_CONFIGURATION = eINSTANCE.getCompositeSearchConfiguration();

		/**
		 * The meta object literal for the '<em><b>Queries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_SEARCH_CONFIGURATION__QUERIES = eINSTANCE.getCompositeSearchConfiguration_Queries();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_SEARCH_CONFIGURATION__TYPE = eINSTANCE.getCompositeSearchConfiguration_Type();

		/**
		 * The meta object literal for the '{@link semanticmanager.queries.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.ServiceImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getService()
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
		 * The meta object literal for the '{@link semanticmanager.queries.impl.CustomSearchImpl <em>Custom Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.CustomSearchImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getCustomSearch()
		 * @generated
		 */
		EClass CUSTOM_SEARCH = eINSTANCE.getCustomSearch();

		/**
		 * The meta object literal for the '<em><b>Search</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CUSTOM_SEARCH___SEARCH__SEARCHRESULT = eINSTANCE.getCustomSearch__Search__SearchResult();

		/**
		 * The meta object literal for the '{@link semanticmanager.queries.impl.PredicateBasedSearchImpl <em>Predicate Based Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.PredicateBasedSearchImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getPredicateBasedSearch()
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
		 * The meta object literal for the '{@link semanticmanager.queries.impl.AtomicSearchResultImpl <em>Atomic Search Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.AtomicSearchResultImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getAtomicSearchResult()
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
		 * The meta object literal for the '{@link semanticmanager.queries.impl.GroupedSearchResultImpl <em>Grouped Search Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.GroupedSearchResultImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getGroupedSearchResult()
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
		 * The meta object literal for the '<em><b>Get Option Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GROUPED_SEARCH_RESULT___GET_OPTION_VALUE__STRING = eINSTANCE.getGroupedSearchResult__GetOptionValue__String();

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
		 * The meta object literal for the '{@link semanticmanager.queries.impl.SemanticGroupImpl <em>Semantic Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.impl.SemanticGroupImpl
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getSemanticGroup()
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
		 * The meta object literal for the '{@link semanticmanager.queries.ConnectionType <em>Connection Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.ConnectionType
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getConnectionType()
		 * @generated
		 */
		EEnum CONNECTION_TYPE = eINSTANCE.getConnectionType();

		/**
		 * The meta object literal for the '{@link semanticmanager.queries.DataModelType <em>Data Model Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see semanticmanager.queries.DataModelType
		 * @see semanticmanager.queries.impl.QueriesPackageImpl#getDataModelType()
		 * @generated
		 */
		EEnum DATA_MODEL_TYPE = eINSTANCE.getDataModelType();

	}

} //QueriesPackage
