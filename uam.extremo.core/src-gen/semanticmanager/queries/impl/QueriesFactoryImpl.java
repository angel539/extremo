/**
 */
package semanticmanager.queries.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import semanticmanager.queries.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QueriesFactoryImpl extends EFactoryImpl implements QueriesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QueriesFactory init() {
		try {
			QueriesFactory theQueriesFactory = (QueriesFactory)EPackage.Registry.INSTANCE.getEFactory(QueriesPackage.eNS_URI);
			if (theQueriesFactory != null) {
				return theQueriesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QueriesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueriesFactoryImpl() {
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
			case QueriesPackage.SEARCH_OPTION: return createSearchOption();
			case QueriesPackage.SEARCH_RESULT: return createSearchResult();
			case QueriesPackage.SEARCH_RESULT_OPTION_VALUE: return createSearchResultOptionValue();
			case QueriesPackage.COMPOSITE_SEARCH_CONFIGURATION: return createCompositeSearchConfiguration();
			case QueriesPackage.CUSTOM_SEARCH: return createCustomSearch();
			case QueriesPackage.PREDICATE_BASED_SEARCH: return createPredicateBasedSearch();
			case QueriesPackage.SEMANTIC_GROUP: return createSemanticGroup();
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
			case QueriesPackage.CONNECTION_TYPE:
				return createConnectionTypeFromString(eDataType, initialValue);
			case QueriesPackage.DATA_MODEL_TYPE:
				return createDataModelTypeFromString(eDataType, initialValue);
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
			case QueriesPackage.CONNECTION_TYPE:
				return convertConnectionTypeToString(eDataType, instanceValue);
			case QueriesPackage.DATA_MODEL_TYPE:
				return convertDataModelTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchOption createSearchOption() {
		SearchOptionImpl searchOption = new SearchOptionImpl();
		return searchOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchResult createSearchResult() {
		SearchResultImpl searchResult = new SearchResultImpl();
		return searchResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchResultOptionValue createSearchResultOptionValue() {
		SearchResultOptionValueImpl searchResultOptionValue = new SearchResultOptionValueImpl();
		return searchResultOptionValue;
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
	public SemanticGroup createSemanticGroup() {
		SemanticGroupImpl semanticGroup = new SemanticGroupImpl();
		return semanticGroup;
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
	public QueriesPackage getQueriesPackage() {
		return (QueriesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QueriesPackage getPackage() {
		return QueriesPackage.eINSTANCE;
	}

} //QueriesFactoryImpl
