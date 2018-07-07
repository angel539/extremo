/**
 */
package uam.extremo.core.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import uam.extremo.core.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see uam.extremo.core.SemanticmanagerPackage
 * @generated
 */
public class SemanticmanagerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SemanticmanagerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticmanagerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SemanticmanagerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticmanagerSwitch<Adapter> modelSwitch =
		new SemanticmanagerSwitch<Adapter>() {
			@Override
			public Adapter caseRepositoryManager(RepositoryManager object) {
				return createRepositoryManagerAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseConstraintInterpreter(ConstraintInterpreter object) {
				return createConstraintInterpreterAdapter();
			}
			@Override
			public Adapter caseConstraintResult(ConstraintResult object) {
				return createConstraintResultAdapter();
			}
			@Override
			public Adapter caseSearchParam(SearchParam object) {
				return createSearchParamAdapter();
			}
			@Override
			public Adapter caseSearchResult(SearchResult object) {
				return createSearchResultAdapter();
			}
			@Override
			public Adapter caseSearchParamValue(SearchParamValue object) {
				return createSearchParamValueAdapter();
			}
			@Override
			public Adapter caseSearchConfiguration(SearchConfiguration object) {
				return createSearchConfigurationAdapter();
			}
			@Override
			public Adapter caseSimpleSearchConfiguration(SimpleSearchConfiguration object) {
				return createSimpleSearchConfigurationAdapter();
			}
			@Override
			public Adapter caseCompositeSearchConfiguration(CompositeSearchConfiguration object) {
				return createCompositeSearchConfigurationAdapter();
			}
			@Override
			public Adapter caseService(Service object) {
				return createServiceAdapter();
			}
			@Override
			public Adapter caseCustomSearch(CustomSearch object) {
				return createCustomSearchAdapter();
			}
			@Override
			public Adapter casePredicateBasedSearch(PredicateBasedSearch object) {
				return createPredicateBasedSearchAdapter();
			}
			@Override
			public Adapter caseAtomicSearchResult(AtomicSearchResult object) {
				return createAtomicSearchResultAdapter();
			}
			@Override
			public Adapter caseGroupedSearchResult(GroupedSearchResult object) {
				return createGroupedSearchResultAdapter();
			}
			@Override
			public Adapter caseSemanticGroup(SemanticGroup object) {
				return createSemanticGroupAdapter();
			}
			@Override
			public Adapter caseRepository(Repository object) {
				return createRepositoryAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseSemanticNode(SemanticNode object) {
				return createSemanticNodeAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseObjectProperty(ObjectProperty object) {
				return createObjectPropertyAdapter();
			}
			@Override
			public Adapter caseDataProperty(DataProperty object) {
				return createDataPropertyAdapter();
			}
			@Override
			public Adapter caseMetaData(MetaData object) {
				return createMetaDataAdapter();
			}
			@Override
			public Adapter caseResourceElement(ResourceElement object) {
				return createResourceElementAdapter();
			}
			@Override
			public Adapter casePrimitiveTypeParam(PrimitiveTypeParam object) {
				return createPrimitiveTypeParamAdapter();
			}
			@Override
			public Adapter caseModelTypeParam(ModelTypeParam object) {
				return createModelTypeParamAdapter();
			}
			@Override
			public Adapter caseModelTypeParamValue(ModelTypeParamValue object) {
				return createModelTypeParamValueAdapter();
			}
			@Override
			public Adapter casePrimitiveTypeParamValue(PrimitiveTypeParamValue object) {
				return createPrimitiveTypeParamValueAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.RepositoryManager <em>Repository Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.RepositoryManager
	 * @generated
	 */
	public Adapter createRepositoryManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.ConstraintInterpreter <em>Constraint Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.ConstraintInterpreter
	 * @generated
	 */
	public Adapter createConstraintInterpreterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.ConstraintResult <em>Constraint Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.ConstraintResult
	 * @generated
	 */
	public Adapter createConstraintResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.SearchParam <em>Search Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.SearchParam
	 * @generated
	 */
	public Adapter createSearchParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.SearchResult <em>Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.SearchResult
	 * @generated
	 */
	public Adapter createSearchResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.SearchParamValue <em>Search Param Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.SearchParamValue
	 * @generated
	 */
	public Adapter createSearchParamValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.SearchConfiguration <em>Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.SearchConfiguration
	 * @generated
	 */
	public Adapter createSearchConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.SimpleSearchConfiguration <em>Simple Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.SimpleSearchConfiguration
	 * @generated
	 */
	public Adapter createSimpleSearchConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.CompositeSearchConfiguration <em>Composite Search Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.CompositeSearchConfiguration
	 * @generated
	 */
	public Adapter createCompositeSearchConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.Service
	 * @generated
	 */
	public Adapter createServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.CustomSearch <em>Custom Search</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.CustomSearch
	 * @generated
	 */
	public Adapter createCustomSearchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.PredicateBasedSearch <em>Predicate Based Search</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.PredicateBasedSearch
	 * @generated
	 */
	public Adapter createPredicateBasedSearchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.AtomicSearchResult <em>Atomic Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.AtomicSearchResult
	 * @generated
	 */
	public Adapter createAtomicSearchResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.GroupedSearchResult <em>Grouped Search Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.GroupedSearchResult
	 * @generated
	 */
	public Adapter createGroupedSearchResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.SemanticGroup <em>Semantic Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.SemanticGroup
	 * @generated
	 */
	public Adapter createSemanticGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.Repository
	 * @generated
	 */
	public Adapter createRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.SemanticNode <em>Semantic Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.SemanticNode
	 * @generated
	 */
	public Adapter createSemanticNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.ObjectProperty <em>Object Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.ObjectProperty
	 * @generated
	 */
	public Adapter createObjectPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.DataProperty <em>Data Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.DataProperty
	 * @generated
	 */
	public Adapter createDataPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.MetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.MetaData
	 * @generated
	 */
	public Adapter createMetaDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.ResourceElement <em>Resource Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.ResourceElement
	 * @generated
	 */
	public Adapter createResourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.PrimitiveTypeParam <em>Primitive Type Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.PrimitiveTypeParam
	 * @generated
	 */
	public Adapter createPrimitiveTypeParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.ModelTypeParam <em>Model Type Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.ModelTypeParam
	 * @generated
	 */
	public Adapter createModelTypeParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.ModelTypeParamValue <em>Model Type Param Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.ModelTypeParamValue
	 * @generated
	 */
	public Adapter createModelTypeParamValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link uam.extremo.core.PrimitiveTypeParamValue <em>Primitive Type Param Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see uam.extremo.core.PrimitiveTypeParamValue
	 * @generated
	 */
	public Adapter createPrimitiveTypeParamValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SemanticmanagerAdapterFactory
