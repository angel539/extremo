/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import semanticmanager.AtomicSearchResult;
import semanticmanager.CompositeSearchConfiguration;
import semanticmanager.ConnectionType;
import semanticmanager.Constraint;
import semanticmanager.ConstraintInterpreter;
import semanticmanager.ConstraintResult;
import semanticmanager.CustomSearch;
import semanticmanager.DataModelType;
import semanticmanager.DataProperty;
import semanticmanager.GroupedSearchResult;
import semanticmanager.MetaData;
import semanticmanager.ModelTypeParam;
import semanticmanager.ModelTypeParamValue;
import semanticmanager.NamedElement;
import semanticmanager.ObjectProperty;
import semanticmanager.PredicateBasedSearch;
import semanticmanager.PrimitiveTypeParam;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.Property;
import semanticmanager.Repository;
import semanticmanager.RepositoryManager;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchParam;
import semanticmanager.SearchParamValue;
import semanticmanager.SearchResult;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.Service;
import semanticmanager.SimpleSearchConfiguration;
import semanticmanager.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SemanticmanagerPackageImpl extends EPackageImpl implements SemanticmanagerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintInterpreterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass searchParamEClass = null;

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
	private EClass searchParamValueEClass = null;

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
	private EClass repositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass semanticNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelTypeParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelTypeParamValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeParamValueEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaObjectEDataType = null;

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
	 * @see semanticmanager.SemanticmanagerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SemanticmanagerPackageImpl() {
		super(eNS_URI, SemanticmanagerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SemanticmanagerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SemanticmanagerPackage init() {
		if (isInited) return (SemanticmanagerPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticmanagerPackage.eNS_URI);

		// Obtain or create and register package
		SemanticmanagerPackageImpl theSemanticmanagerPackage = (SemanticmanagerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SemanticmanagerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SemanticmanagerPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSemanticmanagerPackage.createPackageContents();

		// Initialize created meta-data
		theSemanticmanagerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSemanticmanagerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SemanticmanagerPackage.eNS_URI, theSemanticmanagerPackage);
		return theSemanticmanagerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepositoryManager() {
		return repositoryManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryManager_Repositories() {
		return (EReference)repositoryManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryManager_Configurations() {
		return (EReference)repositoryManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryManager_Interpreters() {
		return (EReference)repositoryManagerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryManager_Services() {
		return (EReference)repositoryManagerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Type() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Name() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Body() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_AppliedTo() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Evaluations() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Interpreter() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintInterpreter() {
		return constraintInterpreterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintInterpreter_Id() {
		return (EAttribute)constraintInterpreterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintInterpreter_Name() {
		return (EAttribute)constraintInterpreterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintInterpreter_Constraints() {
		return (EReference)constraintInterpreterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintInterpreter_Evals() {
		return (EReference)constraintInterpreterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintInterpreter_Type() {
		return (EAttribute)constraintInterpreterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConstraintInterpreter__Eval__Constraint_NamedElement() {
		return constraintInterpreterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintResult() {
		return constraintResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintResult_Constraint() {
		return (EReference)constraintResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintResult_Context() {
		return (EReference)constraintResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintResult_Unsat() {
		return (EReference)constraintResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchParam() {
		return searchParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchParam_Name() {
		return (EAttribute)searchParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchParam_Id() {
		return (EAttribute)searchParamEClass.getEStructuralFeatures().get(1);
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
	public EOperation getSearchResult__GetOptionValue__String() {
		return searchResultEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchParamValue() {
		return searchParamValueEClass;
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
	public EAttribute getSimpleSearchConfiguration_Description() {
		return (EAttribute)simpleSearchConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleSearchConfiguration_FilterBy() {
		return (EAttribute)simpleSearchConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSimpleSearchConfiguration__AddPrimitiveTypeSearchOption__String_String_Type() {
		return simpleSearchConfigurationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSimpleSearchConfiguration__AddDataModelTypeSearchOption__String_String_DataModelType() {
		return simpleSearchConfigurationEClass.getEOperations().get(1);
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
	public EReference getCompositeSearchConfiguration_Children() {
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
	public EReference getCompositeSearchConfiguration_QueryResults() {
		return (EReference)compositeSearchConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCompositeSearchConfiguration__Search__SearchResult() {
		return compositeSearchConfigurationEClass.getEOperations().get(0);
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
	public EAttribute getCustomSearch_Grouped() {
		return (EAttribute)customSearchEClass.getEStructuralFeatures().get(0);
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
	public EOperation getPredicateBasedSearch__Matches__NamedElement_EList() {
		return predicateBasedSearchEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPredicateBasedSearch__GetOptionValueKey__String_EList() {
		return predicateBasedSearchEClass.getEOperations().get(1);
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
	public EOperation getGroupedSearchResult__AddNamedElementToSemanticGroup__SemanticGroup_NamedElement() {
		return groupedSearchResultEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGroupedSearchResult__AddResourceToSemanticGroup__SemanticGroup_Resource() {
		return groupedSearchResultEClass.getEOperations().get(5);
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
	public EClass getRepository() {
		return repositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepository_Resources() {
		return (EReference)repositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepository_Project() {
		return (EAttribute)repositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepository_Name() {
		return (EAttribute)repositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepository_Description() {
		return (EAttribute)repositoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Active() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Alive() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Assistant() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResource_ResourceElements() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Uri() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResource_RepositoryFrom() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResource_DefaultConstraintInterpreter() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSemanticNode() {
		return semanticNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticNode_Properties() {
		return (EReference)semanticNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticNode_Abstract() {
		return (EAttribute)semanticNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Description() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Weight() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Trace() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Drawn() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedElement_Descriptors() {
		return (EReference)namedElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedElement_Describes() {
		return (EReference)namedElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedElement_Constraints() {
		return (EReference)namedElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedElement_Metadata() {
		return (EReference)namedElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedElement_Supers() {
		return (EReference)namedElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamedElement_Subs() {
		return (EReference)namedElementEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_SemanticNodeFrom() {
		return (EReference)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_LowerBound() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_UpperBound() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectProperty() {
		return objectPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectProperty_Range() {
		return (EReference)objectPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectProperty_InverseOf() {
		return (EReference)objectPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataProperty() {
		return dataPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataProperty_Type() {
		return (EAttribute)dataPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataProperty_Value() {
		return (EAttribute)dataPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaData() {
		return metaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetaData_Key() {
		return (EAttribute)metaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetaData_Value() {
		return (EAttribute)metaDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceElement() {
		return resourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceElement_ResourceFrom() {
		return (EReference)resourceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypeParam() {
		return primitiveTypeParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTypeParam_Type() {
		return (EAttribute)primitiveTypeParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelTypeParam() {
		return modelTypeParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelTypeParam_Type() {
		return (EAttribute)modelTypeParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelTypeParamValue() {
		return modelTypeParamValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeParamValue_Option() {
		return (EReference)modelTypeParamValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeParamValue_Value() {
		return (EReference)modelTypeParamValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypeParamValue() {
		return primitiveTypeParamValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTypeParamValue_Value() {
		return (EAttribute)primitiveTypeParamValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveTypeParamValue_Option() {
		return (EReference)primitiveTypeParamValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveTypeParamValue_Calls() {
		return (EReference)primitiveTypeParamValueEClass.getEStructuralFeatures().get(2);
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
	public EEnum getType() {
		return typeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJavaObject() {
		return javaObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticmanagerFactory getSemanticmanagerFactory() {
		return (SemanticmanagerFactory)getEFactoryInstance();
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
		repositoryManagerEClass = createEClass(REPOSITORY_MANAGER);
		createEReference(repositoryManagerEClass, REPOSITORY_MANAGER__REPOSITORIES);
		createEReference(repositoryManagerEClass, REPOSITORY_MANAGER__CONFIGURATIONS);
		createEReference(repositoryManagerEClass, REPOSITORY_MANAGER__INTERPRETERS);
		createEReference(repositoryManagerEClass, REPOSITORY_MANAGER__SERVICES);

		constraintEClass = createEClass(CONSTRAINT);
		createEAttribute(constraintEClass, CONSTRAINT__TYPE);
		createEAttribute(constraintEClass, CONSTRAINT__NAME);
		createEAttribute(constraintEClass, CONSTRAINT__BODY);
		createEReference(constraintEClass, CONSTRAINT__APPLIED_TO);
		createEReference(constraintEClass, CONSTRAINT__EVALUATIONS);
		createEReference(constraintEClass, CONSTRAINT__INTERPRETER);

		constraintInterpreterEClass = createEClass(CONSTRAINT_INTERPRETER);
		createEAttribute(constraintInterpreterEClass, CONSTRAINT_INTERPRETER__ID);
		createEAttribute(constraintInterpreterEClass, CONSTRAINT_INTERPRETER__NAME);
		createEReference(constraintInterpreterEClass, CONSTRAINT_INTERPRETER__CONSTRAINTS);
		createEReference(constraintInterpreterEClass, CONSTRAINT_INTERPRETER__EVALS);
		createEAttribute(constraintInterpreterEClass, CONSTRAINT_INTERPRETER__TYPE);
		createEOperation(constraintInterpreterEClass, CONSTRAINT_INTERPRETER___EVAL__CONSTRAINT_NAMEDELEMENT);

		constraintResultEClass = createEClass(CONSTRAINT_RESULT);
		createEReference(constraintResultEClass, CONSTRAINT_RESULT__CONSTRAINT);
		createEReference(constraintResultEClass, CONSTRAINT_RESULT__CONTEXT);
		createEReference(constraintResultEClass, CONSTRAINT_RESULT__UNSAT);

		searchParamEClass = createEClass(SEARCH_PARAM);
		createEAttribute(searchParamEClass, SEARCH_PARAM__NAME);
		createEAttribute(searchParamEClass, SEARCH_PARAM__ID);

		searchResultEClass = createEClass(SEARCH_RESULT);
		createEReference(searchResultEClass, SEARCH_RESULT__VALUES);
		createEReference(searchResultEClass, SEARCH_RESULT__CONFIGURATION);
		createEReference(searchResultEClass, SEARCH_RESULT__APPLY_ON_ELEMENTS);
		createEOperation(searchResultEClass, SEARCH_RESULT___GET_OPTION_VALUE__STRING);

		searchParamValueEClass = createEClass(SEARCH_PARAM_VALUE);

		searchConfigurationEClass = createEClass(SEARCH_CONFIGURATION);
		createEAttribute(searchConfigurationEClass, SEARCH_CONFIGURATION__ID);
		createEAttribute(searchConfigurationEClass, SEARCH_CONFIGURATION__NAME);
		createEReference(searchConfigurationEClass, SEARCH_CONFIGURATION__RESULTS);

		simpleSearchConfigurationEClass = createEClass(SIMPLE_SEARCH_CONFIGURATION);
		createEReference(simpleSearchConfigurationEClass, SIMPLE_SEARCH_CONFIGURATION__OPTIONS);
		createEAttribute(simpleSearchConfigurationEClass, SIMPLE_SEARCH_CONFIGURATION__DESCRIPTION);
		createEAttribute(simpleSearchConfigurationEClass, SIMPLE_SEARCH_CONFIGURATION__FILTER_BY);
		createEOperation(simpleSearchConfigurationEClass, SIMPLE_SEARCH_CONFIGURATION___ADD_PRIMITIVE_TYPE_SEARCH_OPTION__STRING_STRING_TYPE);
		createEOperation(simpleSearchConfigurationEClass, SIMPLE_SEARCH_CONFIGURATION___ADD_DATA_MODEL_TYPE_SEARCH_OPTION__STRING_STRING_DATAMODELTYPE);

		compositeSearchConfigurationEClass = createEClass(COMPOSITE_SEARCH_CONFIGURATION);
		createEReference(compositeSearchConfigurationEClass, COMPOSITE_SEARCH_CONFIGURATION__CHILDREN);
		createEAttribute(compositeSearchConfigurationEClass, COMPOSITE_SEARCH_CONFIGURATION__TYPE);
		createEReference(compositeSearchConfigurationEClass, COMPOSITE_SEARCH_CONFIGURATION__QUERY_RESULTS);
		createEOperation(compositeSearchConfigurationEClass, COMPOSITE_SEARCH_CONFIGURATION___SEARCH__SEARCHRESULT);

		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__ID);
		createEAttribute(serviceEClass, SERVICE__NAME);
		createEAttribute(serviceEClass, SERVICE__FILTER_BY);
		createEOperation(serviceEClass, SERVICE___MATCHES__STRING_STRING);

		customSearchEClass = createEClass(CUSTOM_SEARCH);
		createEAttribute(customSearchEClass, CUSTOM_SEARCH__GROUPED);
		createEOperation(customSearchEClass, CUSTOM_SEARCH___SEARCH__SEARCHRESULT);

		predicateBasedSearchEClass = createEClass(PREDICATE_BASED_SEARCH);
		createEOperation(predicateBasedSearchEClass, PREDICATE_BASED_SEARCH___MATCHES__NAMEDELEMENT_ELIST);
		createEOperation(predicateBasedSearchEClass, PREDICATE_BASED_SEARCH___GET_OPTION_VALUE_KEY__STRING_ELIST);

		atomicSearchResultEClass = createEClass(ATOMIC_SEARCH_RESULT);
		createEReference(atomicSearchResultEClass, ATOMIC_SEARCH_RESULT__ELEMENTS);

		groupedSearchResultEClass = createEClass(GROUPED_SEARCH_RESULT);
		createEReference(groupedSearchResultEClass, GROUPED_SEARCH_RESULT__GROUPS);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___CREATE_SEMANTIC_GROUP__STRING_STRING);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___ADD_SEMANTIC_NODE_TO_SEMANTIC_GROUP__SEMANTICGROUP_SEMANTICNODE);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___ADD_DATA_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_DATAPROPERTY);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___ADD_OBJECT_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_OBJECTPROPERTY);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___ADD_NAMED_ELEMENT_TO_SEMANTIC_GROUP__SEMANTICGROUP_NAMEDELEMENT);
		createEOperation(groupedSearchResultEClass, GROUPED_SEARCH_RESULT___ADD_RESOURCE_TO_SEMANTIC_GROUP__SEMANTICGROUP_RESOURCE);

		semanticGroupEClass = createEClass(SEMANTIC_GROUP);
		createEReference(semanticGroupEClass, SEMANTIC_GROUP__ELEMENTS);

		repositoryEClass = createEClass(REPOSITORY);
		createEReference(repositoryEClass, REPOSITORY__RESOURCES);
		createEAttribute(repositoryEClass, REPOSITORY__PROJECT);
		createEAttribute(repositoryEClass, REPOSITORY__NAME);
		createEAttribute(repositoryEClass, REPOSITORY__DESCRIPTION);

		resourceEClass = createEClass(RESOURCE);
		createEAttribute(resourceEClass, RESOURCE__ACTIVE);
		createEAttribute(resourceEClass, RESOURCE__ALIVE);
		createEAttribute(resourceEClass, RESOURCE__ASSISTANT);
		createEReference(resourceEClass, RESOURCE__RESOURCE_ELEMENTS);
		createEAttribute(resourceEClass, RESOURCE__URI);
		createEReference(resourceEClass, RESOURCE__REPOSITORY_FROM);
		createEReference(resourceEClass, RESOURCE__DEFAULT_CONSTRAINT_INTERPRETER);

		semanticNodeEClass = createEClass(SEMANTIC_NODE);
		createEReference(semanticNodeEClass, SEMANTIC_NODE__PROPERTIES);
		createEAttribute(semanticNodeEClass, SEMANTIC_NODE__ABSTRACT);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__DESCRIPTION);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__WEIGHT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__TRACE);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__DRAWN);
		createEReference(namedElementEClass, NAMED_ELEMENT__DESCRIPTORS);
		createEReference(namedElementEClass, NAMED_ELEMENT__DESCRIBES);
		createEReference(namedElementEClass, NAMED_ELEMENT__CONSTRAINTS);
		createEReference(namedElementEClass, NAMED_ELEMENT__METADATA);
		createEReference(namedElementEClass, NAMED_ELEMENT__SUPERS);
		createEReference(namedElementEClass, NAMED_ELEMENT__SUBS);

		propertyEClass = createEClass(PROPERTY);
		createEReference(propertyEClass, PROPERTY__SEMANTIC_NODE_FROM);
		createEAttribute(propertyEClass, PROPERTY__LOWER_BOUND);
		createEAttribute(propertyEClass, PROPERTY__UPPER_BOUND);

		objectPropertyEClass = createEClass(OBJECT_PROPERTY);
		createEReference(objectPropertyEClass, OBJECT_PROPERTY__RANGE);
		createEReference(objectPropertyEClass, OBJECT_PROPERTY__INVERSE_OF);

		dataPropertyEClass = createEClass(DATA_PROPERTY);
		createEAttribute(dataPropertyEClass, DATA_PROPERTY__TYPE);
		createEAttribute(dataPropertyEClass, DATA_PROPERTY__VALUE);

		metaDataEClass = createEClass(META_DATA);
		createEAttribute(metaDataEClass, META_DATA__KEY);
		createEAttribute(metaDataEClass, META_DATA__VALUE);

		resourceElementEClass = createEClass(RESOURCE_ELEMENT);
		createEReference(resourceElementEClass, RESOURCE_ELEMENT__RESOURCE_FROM);

		primitiveTypeParamEClass = createEClass(PRIMITIVE_TYPE_PARAM);
		createEAttribute(primitiveTypeParamEClass, PRIMITIVE_TYPE_PARAM__TYPE);

		modelTypeParamEClass = createEClass(MODEL_TYPE_PARAM);
		createEAttribute(modelTypeParamEClass, MODEL_TYPE_PARAM__TYPE);

		modelTypeParamValueEClass = createEClass(MODEL_TYPE_PARAM_VALUE);
		createEReference(modelTypeParamValueEClass, MODEL_TYPE_PARAM_VALUE__OPTION);
		createEReference(modelTypeParamValueEClass, MODEL_TYPE_PARAM_VALUE__VALUE);

		primitiveTypeParamValueEClass = createEClass(PRIMITIVE_TYPE_PARAM_VALUE);
		createEAttribute(primitiveTypeParamValueEClass, PRIMITIVE_TYPE_PARAM_VALUE__VALUE);
		createEReference(primitiveTypeParamValueEClass, PRIMITIVE_TYPE_PARAM_VALUE__OPTION);
		createEReference(primitiveTypeParamValueEClass, PRIMITIVE_TYPE_PARAM_VALUE__CALLS);

		// Create enums
		connectionTypeEEnum = createEEnum(CONNECTION_TYPE);
		dataModelTypeEEnum = createEEnum(DATA_MODEL_TYPE);
		typeEEnum = createEEnum(TYPE);

		// Create data types
		javaObjectEDataType = createEDataType(JAVA_OBJECT);
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
		simpleSearchConfigurationEClass.getESuperTypes().add(this.getSearchConfiguration());
		compositeSearchConfigurationEClass.getESuperTypes().add(this.getSearchConfiguration());
		customSearchEClass.getESuperTypes().add(this.getSimpleSearchConfiguration());
		predicateBasedSearchEClass.getESuperTypes().add(this.getSimpleSearchConfiguration());
		atomicSearchResultEClass.getESuperTypes().add(this.getSearchResult());
		groupedSearchResultEClass.getESuperTypes().add(this.getSearchResult());
		semanticGroupEClass.getESuperTypes().add(this.getNamedElement());
		resourceEClass.getESuperTypes().add(this.getResourceElement());
		semanticNodeEClass.getESuperTypes().add(this.getResourceElement());
		propertyEClass.getESuperTypes().add(this.getNamedElement());
		objectPropertyEClass.getESuperTypes().add(this.getProperty());
		dataPropertyEClass.getESuperTypes().add(this.getProperty());
		resourceElementEClass.getESuperTypes().add(this.getNamedElement());
		primitiveTypeParamEClass.getESuperTypes().add(this.getSearchParam());
		modelTypeParamEClass.getESuperTypes().add(this.getSearchParam());
		modelTypeParamValueEClass.getESuperTypes().add(this.getSearchParamValue());
		primitiveTypeParamValueEClass.getESuperTypes().add(this.getSearchParamValue());

		// Initialize classes, features, and operations; add parameters
		initEClass(repositoryManagerEClass, RepositoryManager.class, "RepositoryManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepositoryManager_Repositories(), this.getRepository(), null, "repositories", null, 0, -1, RepositoryManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepositoryManager_Configurations(), this.getSearchConfiguration(), null, "configurations", null, 0, -1, RepositoryManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepositoryManager_Interpreters(), this.getConstraintInterpreter(), null, "interpreters", null, 0, -1, RepositoryManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepositoryManager_Services(), this.getService(), null, "services", null, 0, -1, RepositoryManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraint_Type(), ecorePackage.getEString(), "type", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraint_Name(), ecorePackage.getEString(), "name", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraint_Body(), ecorePackage.getEString(), "body", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_AppliedTo(), this.getNamedElement(), this.getNamedElement_Constraints(), "appliedTo", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Evaluations(), this.getConstraintResult(), this.getConstraintResult_Constraint(), "evaluations", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Interpreter(), this.getConstraintInterpreter(), this.getConstraintInterpreter_Constraints(), "interpreter", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintInterpreterEClass, ConstraintInterpreter.class, "ConstraintInterpreter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraintInterpreter_Id(), ecorePackage.getEString(), "id", null, 0, 1, ConstraintInterpreter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraintInterpreter_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConstraintInterpreter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintInterpreter_Constraints(), this.getConstraint(), this.getConstraint_Interpreter(), "constraints", null, 0, -1, ConstraintInterpreter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintInterpreter_Evals(), this.getConstraintResult(), null, "evals", null, 0, -1, ConstraintInterpreter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraintInterpreter_Type(), ecorePackage.getEString(), "type", null, 0, 1, ConstraintInterpreter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getConstraintInterpreter__Eval__Constraint_NamedElement(), ecorePackage.getEBoolean(), "eval", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConstraint(), "constraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNamedElement(), "namedElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(constraintResultEClass, ConstraintResult.class, "ConstraintResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintResult_Constraint(), this.getConstraint(), this.getConstraint_Evaluations(), "constraint", null, 0, 1, ConstraintResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintResult_Context(), this.getResource(), null, "context", null, 0, 1, ConstraintResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintResult_Unsat(), this.getNamedElement(), null, "unsat", null, 0, -1, ConstraintResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(searchParamEClass, SearchParam.class, "SearchParam", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSearchParam_Name(), ecorePackage.getEString(), "name", null, 0, 1, SearchParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchParam_Id(), ecorePackage.getEString(), "id", null, 0, 1, SearchParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(searchResultEClass, SearchResult.class, "SearchResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSearchResult_Values(), this.getSearchParamValue(), null, "values", null, 0, -1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSearchResult_Configuration(), this.getSearchConfiguration(), this.getSearchConfiguration_Results(), "configuration", null, 0, 1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSearchResult_ApplyOnElements(), this.getNamedElement(), null, "applyOnElements", null, 0, -1, SearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSearchResult__GetOptionValue__String(), ecorePackage.getEJavaObject(), "getOptionValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(searchParamValueEClass, SearchParamValue.class, "SearchParamValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(searchConfigurationEClass, SearchConfiguration.class, "SearchConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSearchConfiguration_Id(), ecorePackage.getEString(), "id", null, 0, 1, SearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchConfiguration_Name(), ecorePackage.getEString(), "name", null, 0, 1, SearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSearchConfiguration_Results(), this.getSearchResult(), this.getSearchResult_Configuration(), "results", null, 0, -1, SearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleSearchConfigurationEClass, SimpleSearchConfiguration.class, "SimpleSearchConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleSearchConfiguration_Options(), this.getSearchParam(), null, "options", null, 0, -1, SimpleSearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSearchConfiguration_Description(), ecorePackage.getEString(), "description", null, 0, 1, SimpleSearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleSearchConfiguration_FilterBy(), this.getDataModelType(), "filterBy", null, 0, 1, SimpleSearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSimpleSearchConfiguration__AddPrimitiveTypeSearchOption__String_String_Type(), null, "addPrimitiveTypeSearchOption", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSimpleSearchConfiguration__AddDataModelTypeSearchOption__String_String_DataModelType(), null, "addDataModelTypeSearchOption", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataModelType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(compositeSearchConfigurationEClass, CompositeSearchConfiguration.class, "CompositeSearchConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeSearchConfiguration_Children(), this.getCompositeSearchConfiguration(), null, "children", null, 0, -1, CompositeSearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeSearchConfiguration_Type(), this.getConnectionType(), "type", null, 0, 1, CompositeSearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeSearchConfiguration_QueryResults(), this.getSearchResult(), null, "queryResults", null, 0, -1, CompositeSearchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCompositeSearchConfiguration__Search__SearchResult(), null, "search", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSearchResult(), "result", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getService_Id(), ecorePackage.getEString(), "id", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Name(), ecorePackage.getEString(), "name", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_FilterBy(), this.getType(), "filterBy", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getService__Matches__String_String(), ecorePackage.getEBoolean(), "matches", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "expression", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(customSearchEClass, CustomSearch.class, "CustomSearch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomSearch_Grouped(), ecorePackage.getEBoolean(), "grouped", null, 0, 1, CustomSearch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCustomSearch__Search__SearchResult(), null, "search", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSearchResult(), "result", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(predicateBasedSearchEClass, PredicateBasedSearch.class, "PredicateBasedSearch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getPredicateBasedSearch__Matches__NamedElement_EList(), ecorePackage.getEBoolean(), "matches", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNamedElement(), "namedElement", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSearchParamValue(), "inps", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPredicateBasedSearch__GetOptionValueKey__String_EList(), this.getJavaObject(), "getOptionValueKey", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSearchParamValue(), "inps", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(atomicSearchResultEClass, AtomicSearchResult.class, "AtomicSearchResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAtomicSearchResult_Elements(), this.getNamedElement(), null, "elements", null, 0, -1, AtomicSearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupedSearchResultEClass, GroupedSearchResult.class, "GroupedSearchResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroupedSearchResult_Groups(), this.getSemanticGroup(), null, "groups", null, 0, -1, GroupedSearchResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__CreateSemanticGroup__String_String(), this.getSemanticGroup(), "createSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "description", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__AddSemanticNodeToSemanticGroup__SemanticGroup_SemanticNode(), null, "addSemanticNodeToSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticGroup(), "semanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticNode(), "semanticNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__AddDataPropertyToSemanticGroup__SemanticGroup_DataProperty(), null, "addDataPropertyToSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticGroup(), "semanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataProperty(), "dataProperty", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__AddObjectPropertyToSemanticGroup__SemanticGroup_ObjectProperty(), null, "addObjectPropertyToSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticGroup(), "semanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObjectProperty(), "objectProperty", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__AddNamedElementToSemanticGroup__SemanticGroup_NamedElement(), null, "addNamedElementToSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticGroup(), "semanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNamedElement(), "namedElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getGroupedSearchResult__AddResourceToSemanticGroup__SemanticGroup_Resource(), null, "addResourceToSemanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSemanticGroup(), "semanticGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getResource(), "resource", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(semanticGroupEClass, SemanticGroup.class, "SemanticGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSemanticGroup_Elements(), this.getNamedElement(), null, "elements", null, 0, -1, SemanticGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repositoryEClass, Repository.class, "Repository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepository_Resources(), this.getResource(), this.getResource_RepositoryFrom(), "resources", null, 0, -1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepository_Project(), ecorePackage.getEString(), "project", null, 0, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepository_Name(), ecorePackage.getEString(), "name", null, 0, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepository_Description(), ecorePackage.getEString(), "description", null, 0, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResource_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_Alive(), ecorePackage.getEBoolean(), "alive", "true", 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_Assistant(), ecorePackage.getEString(), "assistant", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResource_ResourceElements(), this.getResourceElement(), this.getResourceElement_ResourceFrom(), "resourceElements", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResource_RepositoryFrom(), this.getRepository(), this.getRepository_Resources(), "repositoryFrom", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResource_DefaultConstraintInterpreter(), this.getConstraintInterpreter(), null, "defaultConstraintInterpreter", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(semanticNodeEClass, SemanticNode.class, "SemanticNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSemanticNode_Properties(), this.getProperty(), this.getProperty_SemanticNodeFrom(), "properties", null, 0, -1, SemanticNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticNode_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, SemanticNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Weight(), ecorePackage.getEInt(), "weight", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Trace(), this.getJavaObject(), "trace", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Drawn(), ecorePackage.getEBoolean(), "drawn", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedElement_Descriptors(), this.getNamedElement(), this.getNamedElement_Describes(), "descriptors", null, 0, -1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedElement_Describes(), this.getNamedElement(), this.getNamedElement_Descriptors(), "describes", null, 0, -1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedElement_Constraints(), this.getConstraint(), this.getConstraint_AppliedTo(), "constraints", null, 0, -1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedElement_Metadata(), this.getMetaData(), null, "metadata", null, 0, -1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedElement_Supers(), this.getNamedElement(), this.getNamedElement_Subs(), "supers", null, 0, -1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedElement_Subs(), this.getNamedElement(), this.getNamedElement_Supers(), "subs", null, 0, -1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProperty_SemanticNodeFrom(), this.getSemanticNode(), this.getSemanticNode_Properties(), "semanticNodeFrom", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectPropertyEClass, ObjectProperty.class, "ObjectProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectProperty_Range(), this.getSemanticNode(), null, "range", null, 0, 1, ObjectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectProperty_InverseOf(), this.getObjectProperty(), null, "inverseOf", null, 0, 1, ObjectProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataPropertyEClass, DataProperty.class, "DataProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataProperty_Type(), this.getType(), "type", null, 0, 1, DataProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, DataProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metaDataEClass, MetaData.class, "MetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetaData_Key(), ecorePackage.getEString(), "key", null, 0, 1, MetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaData_Value(), ecorePackage.getEString(), "value", null, 0, 1, MetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceElementEClass, ResourceElement.class, "ResourceElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceElement_ResourceFrom(), this.getResource(), this.getResource_ResourceElements(), "resourceFrom", null, 0, 1, ResourceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeParamEClass, PrimitiveTypeParam.class, "PrimitiveTypeParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveTypeParam_Type(), this.getType(), "type", null, 0, 1, PrimitiveTypeParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelTypeParamEClass, ModelTypeParam.class, "ModelTypeParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelTypeParam_Type(), this.getDataModelType(), "type", null, 0, 1, ModelTypeParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelTypeParamValueEClass, ModelTypeParamValue.class, "ModelTypeParamValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelTypeParamValue_Option(), this.getModelTypeParam(), null, "option", null, 0, 1, ModelTypeParamValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelTypeParamValue_Value(), this.getNamedElement(), null, "value", null, 0, 1, ModelTypeParamValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeParamValueEClass, PrimitiveTypeParamValue.class, "PrimitiveTypeParamValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveTypeParamValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, PrimitiveTypeParamValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimitiveTypeParamValue_Option(), this.getPrimitiveTypeParam(), null, "option", null, 0, 1, PrimitiveTypeParamValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimitiveTypeParamValue_Calls(), this.getService(), null, "calls", null, 0, 1, PrimitiveTypeParamValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEEnum(typeEEnum, Type.class, "Type");
		addEEnumLiteral(typeEEnum, Type.STRING);
		addEEnumLiteral(typeEEnum, Type.INT);
		addEEnumLiteral(typeEEnum, Type.BOOLEAN);
		addEEnumLiteral(typeEEnum, Type.FLOAT);
		addEEnumLiteral(typeEEnum, Type.DOUBLE);

		// Initialize data types
		initEDataType(javaObjectEDataType, Object.class, "JavaObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SemanticmanagerPackageImpl
