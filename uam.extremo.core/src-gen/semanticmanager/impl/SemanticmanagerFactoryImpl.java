/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import semanticmanager.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SemanticmanagerFactoryImpl extends EFactoryImpl implements SemanticmanagerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SemanticmanagerFactory init() {
		try {
			SemanticmanagerFactory theSemanticmanagerFactory = (SemanticmanagerFactory)EPackage.Registry.INSTANCE.getEFactory(SemanticmanagerPackage.eNS_URI);
			if (theSemanticmanagerFactory != null) {
				return theSemanticmanagerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SemanticmanagerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticmanagerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SemanticmanagerPackage.REPOSITORY_MANAGER: return (EObject)createRepositoryManager();
			case SemanticmanagerPackage.CONSTRAINT: return (EObject)createConstraint();
			case SemanticmanagerPackage.CONSTRAINT_RESULT: return (EObject)createConstraintResult();
			case SemanticmanagerPackage.COMPOSITE_SEARCH_CONFIGURATION: return (EObject)createCompositeSearchConfiguration();
			case SemanticmanagerPackage.SERVICE: return (EObject)createService();
			case SemanticmanagerPackage.CUSTOM_SEARCH: return (EObject)createCustomSearch();
			case SemanticmanagerPackage.PREDICATE_BASED_SEARCH: return (EObject)createPredicateBasedSearch();
			case SemanticmanagerPackage.ATOMIC_SEARCH_RESULT: return (EObject)createAtomicSearchResult();
			case SemanticmanagerPackage.GROUPED_SEARCH_RESULT: return (EObject)createGroupedSearchResult();
			case SemanticmanagerPackage.SEMANTIC_GROUP: return (EObject)createSemanticGroup();
			case SemanticmanagerPackage.REPOSITORY: return (EObject)createRepository();
			case SemanticmanagerPackage.RESOURCE: return (EObject)createResource();
			case SemanticmanagerPackage.SEMANTIC_NODE: return (EObject)createSemanticNode();
			case SemanticmanagerPackage.OBJECT_PROPERTY: return (EObject)createObjectProperty();
			case SemanticmanagerPackage.DATA_PROPERTY: return (EObject)createDataProperty();
			case SemanticmanagerPackage.META_DATA: return (EObject)createMetaData();
			case SemanticmanagerPackage.PRIMITIVE_TYPE_SEARCH_OPTION: return (EObject)createPrimitiveTypeSearchOption();
			case SemanticmanagerPackage.DATA_MODEL_TYPE_SEARCH_OPTION: return (EObject)createDataModelTypeSearchOption();
			case SemanticmanagerPackage.DATA_MODEL_TYPE_SEARCH_RESULT_OPTION_VALUE: return (EObject)createDataModelTypeSearchResultOptionValue();
			case SemanticmanagerPackage.PRIMITIVE_TYPE_SEARCH_RESULT_OPTION_VALUE: return (EObject)createPrimitiveTypeSearchResultOptionValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SemanticmanagerPackage.CONNECTION_TYPE:
				return createConnectionTypeFromString(eDataType, initialValue);
			case SemanticmanagerPackage.DATA_MODEL_TYPE:
				return createDataModelTypeFromString(eDataType, initialValue);
			case SemanticmanagerPackage.TYPE:
				return createTypeFromString(eDataType, initialValue);
			case SemanticmanagerPackage.JAVA_OBJECT:
				return createJavaObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SemanticmanagerPackage.CONNECTION_TYPE:
				return convertConnectionTypeToString(eDataType, instanceValue);
			case SemanticmanagerPackage.DATA_MODEL_TYPE:
				return convertDataModelTypeToString(eDataType, instanceValue);
			case SemanticmanagerPackage.TYPE:
				return convertTypeToString(eDataType, instanceValue);
			case SemanticmanagerPackage.JAVA_OBJECT:
				return convertJavaObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryManager createRepositoryManager() {
		RepositoryManagerImpl repositoryManager = new RepositoryManagerImpl();
		return repositoryManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintResult createConstraintResult() {
		ConstraintResultImpl constraintResult = new ConstraintResultImpl();
		return constraintResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSearchConfiguration createCompositeSearchConfiguration() {
		CompositeSearchConfigurationImpl compositeSearchConfiguration = new CompositeSearchConfigurationImpl();
		return compositeSearchConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomSearch createCustomSearch() {
		CustomSearchImpl customSearch = new CustomSearchImpl();
		return customSearch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateBasedSearch createPredicateBasedSearch() {
		PredicateBasedSearchImpl predicateBasedSearch = new PredicateBasedSearchImpl();
		return predicateBasedSearch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicSearchResult createAtomicSearchResult() {
		AtomicSearchResultImpl atomicSearchResult = new AtomicSearchResultImpl();
		return atomicSearchResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupedSearchResult createGroupedSearchResult() {
		GroupedSearchResultImpl groupedSearchResult = new GroupedSearchResultImpl();
		return groupedSearchResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticGroup createSemanticGroup() {
		SemanticGroupImpl semanticGroup = new SemanticGroupImpl();
		return semanticGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository createRepository() {
		RepositoryImpl repository = new RepositoryImpl();
		return repository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticNode createSemanticNode() {
		SemanticNodeImpl semanticNode = new SemanticNodeImpl();
		return semanticNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectProperty createObjectProperty() {
		ObjectPropertyImpl objectProperty = new ObjectPropertyImpl();
		return objectProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProperty createDataProperty() {
		DataPropertyImpl dataProperty = new DataPropertyImpl();
		return dataProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaData createMetaData() {
		MetaDataImpl metaData = new MetaDataImpl();
		return metaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeSearchOption createPrimitiveTypeSearchOption() {
		PrimitiveTypeSearchOptionImpl primitiveTypeSearchOption = new PrimitiveTypeSearchOptionImpl();
		return primitiveTypeSearchOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataModelTypeSearchOption createDataModelTypeSearchOption() {
		DataModelTypeSearchOptionImpl dataModelTypeSearchOption = new DataModelTypeSearchOptionImpl();
		return dataModelTypeSearchOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataModelTypeSearchResultOptionValue createDataModelTypeSearchResultOptionValue() {
		DataModelTypeSearchResultOptionValueImpl dataModelTypeSearchResultOptionValue = new DataModelTypeSearchResultOptionValueImpl();
		return dataModelTypeSearchResultOptionValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeSearchResultOptionValue createPrimitiveTypeSearchResultOptionValue() {
		PrimitiveTypeSearchResultOptionValueImpl primitiveTypeSearchResultOptionValue = new PrimitiveTypeSearchResultOptionValueImpl();
		return primitiveTypeSearchResultOptionValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionType createConnectionTypeFromString(EDataType eDataType, String initialValue) {
		ConnectionType result = ConnectionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataModelType createDataModelTypeFromString(EDataType eDataType, String initialValue) {
		DataModelType result = DataModelType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataModelTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createTypeFromString(EDataType eDataType, String initialValue) {
		Type result = Type.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createJavaObjectFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticmanagerPackage getSemanticmanagerPackage() {
		return (SemanticmanagerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SemanticmanagerPackage getPackage() {
		return SemanticmanagerPackage.eINSTANCE;
	}

} //SemanticmanagerFactoryImpl
