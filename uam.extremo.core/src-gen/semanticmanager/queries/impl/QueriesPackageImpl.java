/**
 */
package semanticmanager.queries.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import semanticmanager.SemanticmanagerPackage;

import semanticmanager.constraints.ConstraintsPackage;

import semanticmanager.constraints.impl.ConstraintsPackageImpl;

import semanticmanager.dataModel.DataModelPackage;

import semanticmanager.dataModel.impl.DataModelPackageImpl;

import semanticmanager.impl.SemanticmanagerPackageImpl;

import semanticmanager.queries.AtomicSearchResult;
import semanticmanager.queries.CompositeSearchConfiguration;
import semanticmanager.queries.ConnectionType;
import semanticmanager.queries.CustomSearch;
import semanticmanager.queries.DataModelType;
import semanticmanager.queries.GroupedSearchResult;
import semanticmanager.queries.PredicateBasedSearch;
import semanticmanager.queries.QueriesFactory;
import semanticmanager.queries.QueriesPackage;
import semanticmanager.queries.SearchConfiguration;
import semanticmanager.queries.SearchOption;
import semanticmanager.queries.SearchResult;
import semanticmanager.queries.SearchResultOptionValue;
import semanticmanager.queries.SemanticGroup;
import semanticmanager.queries.Service;
import semanticmanager.queries.SimpleSearchConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QueriesPackageImpl extends EPackageImpl implements QueriesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass searchOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass searchResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass searchResultOptionValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass searchConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleSearchConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeSearchConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customSearchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateBasedSearchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicSearchResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupedSearchResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass semanticGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum connectionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataModelTypeEEnum = null;

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
	 * @see semanticmanager.queries.QueriesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QueriesPackageImpl() {
		super(eNS_URI, QueriesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QueriesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QueriesPackage init() {
		if (isInited) return (QueriesPackage)EPackage.Registry.INSTANCE.getEPackage(QueriesPackage.eNS_URI);

		// Obtain or create and register package
		QueriesPackageImpl theQueriesPackage = (QueriesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QueriesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QueriesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SemanticmanagerPackageImpl theSemanticmanagerPackage = (SemanticmanagerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticmanagerPackage.eNS_URI) instanceof SemanticmanagerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticmanagerPackage.eNS_URI) : SemanticmanagerPackage.eINSTANCE);
		ConstraintsPackageImpl theConstraintsPackage = (ConstraintsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI) instanceof ConstraintsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI) : ConstraintsPackage.eINSTANCE);
		DataModelPackageImpl theDataModelPackage = (DataModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataModelPackage.eNS_URI) instanceof DataModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataModelPackage.eNS_URI) : DataModelPackage.eINSTANCE);

		// Create package meta-data objects
		theQueriesPackage.createPackageContents();
		theSemanticmanagerPackage.createPackageContents();
		theConstraintsPackage.createPackageContents();
		theDataModelPackage.createPackageContents();

		// Initialize created meta-data
		theQueriesPackage.initializePackageContents();
		theSemanticmanagerPackage.initializePackageContents();
		theConstraintsPackage.initializePackageContents();
		theDataModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQueriesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QueriesPackage.eNS_URI, theQueriesPackage);
		return theQueriesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchOption() {
		return searchOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchOption_Type() {
		return (EAttribute)searchOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchOption_Name() {
		return (EAttribute)searchOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchOption_Id() {
		return (EAttribute)searchOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchResult() {
		return searchResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSearchResult_Values() {
		return (EReference)searchResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSearchResult_Configuration() {
		return (EReference)searchResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSearchResult_ApplyOnElements() {
		return (EReference)searchResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchResultOptionValue() {
		return searchResultOptionValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSearchResultOptionValue_Option() {
		return (EReference)searchResultOptionValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchResultOptionValue_Value() {
		return (EAttribute)searchResultOptionValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchConfiguration() {
		return searchConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchConfiguration_Id() {
		return (EAttribute)searchConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchConfiguration_Name() {
		return (EAttribute)searchConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSearchConfiguration_Results() {
		return (EReference)searchConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleSearchConfiguration() {
		return simpleSearchConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleSearchConfiguration_Options() {
		return (EReference)simpleSearchConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSearchConfiguration_FilterBy() {
		return (EAttribute)simpleSearchConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSimpleSearchConfiguration__AddSearchOption__String_String_Type() {
		return simpleSearchConfigurationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeSearchConfiguration() {
		return compositeSearchConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeSearchConfiguration_Queries() {
		return (EReference)compositeSearchConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeSearchConfiguration_Type() {
		return (EAttribute)compositeSearchConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Id() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Name() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_FilterBy() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getService__Matches__String_String() {
		return serviceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomSearch() {
		return customSearchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCustomSearch__Search__SearchResult() {
		return customSearchEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredicateBasedSearch() {
		return predicateBasedSearchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPredicateBasedSearch__Matches__NamedElement() {
		return predicateBasedSearchEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicSearchResult() {
		return atomicSearchResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtomicSearchResult_Elements() {
		return (EReference)atomicSearchResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupedSearchResult() {
		return groupedSearchResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupedSearchResult_Groups() {
		return (EReference)groupedSearchResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroupedSearchResult__CreateSemanticGroup__String_String() {
		return groupedSearchResultEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroupedSearchResult__AddSemanticNodeToSemanticGroup__SemanticGroup_SemanticNode() {
		return groupedSearchResultEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroupedSearchResult__AddDataPropertyToSemanticGroup__SemanticGroup_DataProperty() {
		return groupedSearchResultEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroupedSearchResult__AddObjectPropertyToSemanticGroup__SemanticGroup_ObjectProperty() {
		return groupedSearchResultEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroupedSearchResult__GetOptionValue__String() {
		return groupedSearchResultEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroupedSearchResult__AddNamedElementToSemanticGroup__SemanticGroup_NamedElement() {
		return groupedSearchResultEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroupedSearchResult__AddResourceToSemanticGroup__SemanticGroup_Resource() {
		return groupedSearchResultEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSemanticGroup() {
		return semanticGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticGroup_Elements() {
		return (EReference)semanticGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConnectionType() {
		return connectionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataModelType() {
		return dataModelTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueriesFactory getQueriesFactory() {
		return (QueriesFactory)getEFactoryInstance();
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
		searchOptionEClass = createEClass(SEARCH_OPTION);
		createEAttribute(searchOptionEClass, SEARCH_OPTION__TYPE);
		createEAttribute(searchOptionEClass, SEARCH_OPTION__NAME);
		createEAttribute(searchOptionEClass, SEARCH_OPTION__ID);

		searchResultEClass = createEClass(SEARCH_RESULT);
		createEReference(searchResultEClass, SEARCH_RESULT__VALUES);
		createEReference(searchResultEClass, SEARCH_RESULT__CONFIGURATION);
		createEReference(searchResultEClass, SEARCH_RESULT__APPLY_ON_ELEMENTS);

		searchResultOptionValueEClass = createEClass(SEARCH_RESULT_OPTION_VALUE);
		createEReference(searchResultOptionValueEClass, SEARCH_RESULT_OPTION_VALUE__OPTION);
		createEAttribute(searchResultOptionValueEClass, SEARCH_RESULT_OPTION_VALUE__VALUE);

		searchConfigurationEClass = createEClass(SEARCH_CONFIGURATION);
		createEAttribute(searchConfigurationEClass, SEARCH_CONFIGURATION__ID);
		createEAttribute(searchConfigurationEClass, SEARCH_CONFIGURATION__NAME);
		createEReference(searchConfigurationEClass, SEARCH_CONFIGURATION__RESULTS);

		simpleSearchConfigurationEClass = createEClass(SIMPLE_SEARCH_CONFIGURATION);
		createEReference(simpleSearchConfigurationEClass, SIMPLE_SEARCH_CONFIGURATION__OPTIONS);
		createEAttribute(simpleSearchConfigurationEClass, SIMPLE_SEARCH_CONFIGURATION__FILTER_BY);
		createEOperation(simpleSearchConfigurationEClass, SIMPLE_SEARCH_CONFIGURATION___ADD_SEARCH_OPTION__STRING_STRING_TYPE);

		compositeSearchConfigurationEClass = createEClass(COMPOSITE_SEARCH_CONFIGURATION);
		createEReference(compositeSearchConfigurationEClass, COMPOSITE_SEARCH_CONFIGURATION__QUERIES);
		createEAttribute(compositeSearchConfigurationEClass, COMPOSITE_SEARCH_CONFIGURATION__TYPE);

		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__ID);
		createEAttribute(serviceEClass, SERVICE__NAME);
		createEAttribute(serviceEClass, SERVICE__FILTER_BY);
		createEOperation(serviceEClass, SERVICE___MATCHES__STRING_STRING);

		customSearchEClass = createEClass(CUSTOM_SEARCH);
		createEOperation(customSearchEClass, CUSTOM_SEARCH___SEARCH__SEARCHRESULT);

		predicateBasedSearchEClass = createEClass(PREDICATE_BASED_SEARCH);
		createEOperation(predicateBasedSearchEClass, PREDICATE_BASED_SEARCH___MATCHES__NAMEDELEMENT);

		atomicSearchResultEClass = createEClass(ATOMIC_SEARCH_RESULT);
		createEReference(atomicSearchResultEClass, ATOMIC_SEARCH_RESULT__ELEMENTS);

		groupedSearchResultEClass = createEClass(GROUPED_SEARCH_RESULT);
		createEReference(groupedSearchResultEClass, GROUPED_SEARCH_RESULT__GROUPS);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___CREATE_SEMANTIC_GROUP__STRING_STRING);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___ADD_SEMANTIC_NODE_TO_SEMANTIC_GROUP__SEMANTICGROUP_SEMANTICNODE);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___ADD_DATA_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_DATAPROPERTY);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___ADD_OBJECT_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_OBJECTPROPERTY);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___GET_OPTION_VALUE__STRING);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___ADD_NAMED_ELEMENT_TO_SEMANTIC_GROUP__SEMANTICGROUP_NAMEDELEMENT);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___ADD_RESOURCE_TO_SEMANTIC_GROUP__SEMANTICGROUP_RESOURCE);

		semanticGroupEClass = createEClass(SEMANTIC_GROUP);
		createEReference(semanticGroupEClass, SEMANTIC_GROUP__ELEMENTS);

		// Create enums
		connectionTypeEEnum = createEEnum(CONNECTION_TYPE);
		dataModelTypeEEnum = createEEnum(DATA_MODEL_TYPE);
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
		simpleSearchConfigurationEClass.getESuperTypes().add(this.getSearchConfiguration());
		compositeSearchConfigurationEClass.getESuperTypes().add(this.getSearchConfiguration());
		customSearchEClass.getESuperTypes().add(this.getSimpleSearchConfiguration());
		predicateBasedSearchEClass.getESuperTypes().add(this.getSimpleSearchConfiguration());
		atomicSearchResultEClass.getESuperTypes().add(this.getSearchResult());
		groupedSearchResultEClass.getESuperTypes().add(this.getSearchResult());
		semanticGroupEClass.getESuperTypes().add(theDataModelPackage.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(searchOptionEClass, SearchOption.class, "SearchOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSearchOption_Type(), theDataModelPackage.getType(), "type", null, 0, 1, SearchOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchOption_Name(), ecorePackage.getEString(), "name", null, 0, 1, SearchOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchOption_Id(), ecorePackage.getEString(), "id", null, 0, 1, SearchOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(searchResultEClass, SearchResult.class, "SearchResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSearchResult_Values(), this.getSearchResultOptionValue(), null, "values", null, 0, -1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSearchResult_Configuration(), this.getSearchConfiguration(), this.getSearchConfiguration_Results(), "configuration", null, 0, 1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSearchResult_ApplyOnElements(), theDataModelPackage.getNamedElement(), null, "applyOnElements", null, 0, -1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(searchResultOptionValueEClass, SearchResultOptionValue.class, "SearchResultOptionValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSearchResultOptionValue_Option(), this.getSearchOption(), null, "option", null, 0, 1, SearchResultOptionValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchResultOptionValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, SearchResultOptionValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(searchConfigurationEClass, SearchConfiguration.class, "SearchConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSearchConfiguration_Id(), ecorePackage.getEString(), "id", null, 0, 1, SearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchConfiguration_Name(), ecorePackage.getEString(), "name", null, 0, 1, SearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSearchConfiguration_Results(), this.getSearchResult(), this.getSearchResult_Configuration(), "results", null, 0, -1, SearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleSearchConfigurationEClass, SimpleSearchConfiguration.class, "SimpleSearchConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleSearchConfiguration_Options(), this.getSearchOption(), null, "options", null, 0, -1, SimpleSearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSearchConfiguration_FilterBy(), this.getDataModelType(), "filterBy", null, 0, 1, SimpleSearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getSimpleSearchConfiguration__AddSearchOption__String_String_Type(), null, "addSearchOption", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataModelPackage.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(compositeSearchConfigurationEClass, CompositeSearchConfiguration.class, "CompositeSearchConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeSearchConfiguration_Queries(), this.getSearchConfiguration(), null, "queries", null, 1, -1, CompositeSearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeSearchConfiguration_Type(), this.getConnectionType(), "type", null, 0, 1, CompositeSearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getService_Id(), ecorePackage.getEString(), "id", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Name(), ecorePackage.getEString(), "name", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_FilterBy(), theDataModelPackage.getType(), "filterBy", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getService__Matches__String_String(), ecorePackage.getEBoolean(), "matches", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "expression", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(customSearchEClass, CustomSearch.class, "CustomSearch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getCustomSearch__Search__SearchResult(), null, "search", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSearchResult(), "search", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(predicateBasedSearchEClass, PredicateBasedSearch.class, "PredicateBasedSearch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getPredicateBasedSearch__Matches__NamedElement(), ecorePackage.getEBoolean(), "matches", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataModelPackage.getNamedElement(), "namedElement", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(atomicSearchResultEClass, AtomicSearchResult.class, "AtomicSearchResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAtomicSearchResult_Elements(), theDataModelPackage.getNamedElement(), null, "elements", null, 0, -1, AtomicSearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupedSearchResultEClass, GroupedSearchResult.class, "GroupedSearchResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroupedSearchResult_Groups(), this.getSemanticGroup(), null, "groups", null, 0, -1, GroupedSearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__CreateSemanticGroup__String_String(), this.getSemanticGroup(), "createSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "description", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__AddSemanticNodeToSemanticGroup__SemanticGroup_SemanticNode(), null, "addSemanticNodeToSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticGroup(), "semanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataModelPackage.getSemanticNode(), "semanticNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__AddDataPropertyToSemanticGroup__SemanticGroup_DataProperty(), null, "addDataPropertyToSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticGroup(), "semanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataModelPackage.getDataProperty(), "dataProperty", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__AddObjectPropertyToSemanticGroup__SemanticGroup_ObjectProperty(), null, "addObjectPropertyToSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticGroup(), "semanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataModelPackage.getObjectProperty(), "objectProperty", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__GetOptionValue__String(), ecorePackage.getEJavaObject(), "getOptionValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__AddNamedElementToSemanticGroup__SemanticGroup_NamedElement(), null, "addNamedElementToSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticGroup(), "semanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataModelPackage.getNamedElement(), "namedElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__AddResourceToSemanticGroup__SemanticGroup_Resource(), null, "addResourceToSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticGroup(), "semanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDataModelPackage.getResource(), "resource", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(semanticGroupEClass, SemanticGroup.class, "SemanticGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSemanticGroup_Elements(), theDataModelPackage.getNamedElement(), null, "elements", null, 0, -1, SemanticGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(connectionTypeEEnum, ConnectionType.class, "ConnectionType");
		addEEnumLiteral(connectionTypeEEnum, ConnectionType.OR);
		addEEnumLiteral(connectionTypeEEnum, ConnectionType.AND);
		addEEnumLiteral(connectionTypeEEnum, ConnectionType.NOT);

		initEEnum(dataModelTypeEEnum, DataModelType.class, "DataModelType");
		addEEnumLiteral(dataModelTypeEEnum, DataModelType.RESOURCE);
		addEEnumLiteral(dataModelTypeEEnum, DataModelType.SEMANTIC_NODE);
		addEEnumLiteral(dataModelTypeEEnum, DataModelType.DATA_PROPERTY);
		addEEnumLiteral(dataModelTypeEEnum, DataModelType.OBJECT_PROPERTY);
	}

} //QueriesPackageImpl
