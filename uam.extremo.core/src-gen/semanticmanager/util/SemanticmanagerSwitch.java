/**
 */
package semanticmanager.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import semanticmanager.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see semanticmanager.SemanticmanagerPackage
 * @generated
 */
public class SemanticmanagerSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SemanticmanagerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticmanagerSwitch() {
		if (modelPackage == null) {
			modelPackage = SemanticmanagerPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SemanticmanagerPackage.REPOSITORY_MANAGER: {
				RepositoryManager repositoryManager = (RepositoryManager)theEObject;
				T result = caseRepositoryManager(repositoryManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.CONSTRAINT_INTERPRETER: {
				ConstraintInterpreter constraintInterpreter = (ConstraintInterpreter)theEObject;
				T result = caseConstraintInterpreter(constraintInterpreter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.CONSTRAINT_RESULT: {
				ConstraintResult constraintResult = (ConstraintResult)theEObject;
				T result = caseConstraintResult(constraintResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.SEARCH_PARAM: {
				SearchParam searchParam = (SearchParam)theEObject;
				T result = caseSearchParam(searchParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.SEARCH_RESULT: {
				SearchResult searchResult = (SearchResult)theEObject;
				T result = caseSearchResult(searchResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.SEARCH_PARAM_VALUE: {
				SearchParamValue searchParamValue = (SearchParamValue)theEObject;
				T result = caseSearchParamValue(searchParamValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.SEARCH_CONFIGURATION: {
				SearchConfiguration searchConfiguration = (SearchConfiguration)theEObject;
				T result = caseSearchConfiguration(searchConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION: {
				SimpleSearchConfiguration simpleSearchConfiguration = (SimpleSearchConfiguration)theEObject;
				T result = caseSimpleSearchConfiguration(simpleSearchConfiguration);
				if (result == null) result = caseSearchConfiguration(simpleSearchConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.COMPOSITE_SEARCH_CONFIGURATION: {
				CompositeSearchConfiguration compositeSearchConfiguration = (CompositeSearchConfiguration)theEObject;
				T result = caseCompositeSearchConfiguration(compositeSearchConfiguration);
				if (result == null) result = caseSearchConfiguration(compositeSearchConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.SERVICE: {
				Service service = (Service)theEObject;
				T result = caseService(service);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.CUSTOM_SEARCH: {
				CustomSearch customSearch = (CustomSearch)theEObject;
				T result = caseCustomSearch(customSearch);
				if (result == null) result = caseSimpleSearchConfiguration(customSearch);
				if (result == null) result = caseSearchConfiguration(customSearch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.PREDICATE_BASED_SEARCH: {
				PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch)theEObject;
				T result = casePredicateBasedSearch(predicateBasedSearch);
				if (result == null) result = caseSimpleSearchConfiguration(predicateBasedSearch);
				if (result == null) result = caseSearchConfiguration(predicateBasedSearch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.ATOMIC_SEARCH_RESULT: {
				AtomicSearchResult atomicSearchResult = (AtomicSearchResult)theEObject;
				T result = caseAtomicSearchResult(atomicSearchResult);
				if (result == null) result = caseSearchResult(atomicSearchResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.GROUPED_SEARCH_RESULT: {
				GroupedSearchResult groupedSearchResult = (GroupedSearchResult)theEObject;
				T result = caseGroupedSearchResult(groupedSearchResult);
				if (result == null) result = caseSearchResult(groupedSearchResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.SEMANTIC_GROUP: {
				SemanticGroup semanticGroup = (SemanticGroup)theEObject;
				T result = caseSemanticGroup(semanticGroup);
				if (result == null) result = caseNamedElement(semanticGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.REPOSITORY: {
				Repository repository = (Repository)theEObject;
				T result = caseRepository(repository);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseResourceElement(resource);
				if (result == null) result = caseNamedElement(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.SEMANTIC_NODE: {
				SemanticNode semanticNode = (SemanticNode)theEObject;
				T result = caseSemanticNode(semanticNode);
				if (result == null) result = caseResourceElement(semanticNode);
				if (result == null) result = caseNamedElement(semanticNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseNamedElement(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.OBJECT_PROPERTY: {
				ObjectProperty objectProperty = (ObjectProperty)theEObject;
				T result = caseObjectProperty(objectProperty);
				if (result == null) result = caseProperty(objectProperty);
				if (result == null) result = caseNamedElement(objectProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.DATA_PROPERTY: {
				DataProperty dataProperty = (DataProperty)theEObject;
				T result = caseDataProperty(dataProperty);
				if (result == null) result = caseProperty(dataProperty);
				if (result == null) result = caseNamedElement(dataProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.META_DATA: {
				MetaData metaData = (MetaData)theEObject;
				T result = caseMetaData(metaData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.RESOURCE_ELEMENT: {
				ResourceElement resourceElement = (ResourceElement)theEObject;
				T result = caseResourceElement(resourceElement);
				if (result == null) result = caseNamedElement(resourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.PRIMITIVE_TYPE_PARAM: {
				PrimitiveTypeParam primitiveTypeParam = (PrimitiveTypeParam)theEObject;
				T result = casePrimitiveTypeParam(primitiveTypeParam);
				if (result == null) result = caseSearchParam(primitiveTypeParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.MODEL_TYPE_PARAM: {
				ModelTypeParam modelTypeParam = (ModelTypeParam)theEObject;
				T result = caseModelTypeParam(modelTypeParam);
				if (result == null) result = caseSearchParam(modelTypeParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.MODEL_TYPE_PARAM_VALUE: {
				ModelTypeParamValue modelTypeParamValue = (ModelTypeParamValue)theEObject;
				T result = caseModelTypeParamValue(modelTypeParamValue);
				if (result == null) result = caseSearchParamValue(modelTypeParamValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.PRIMITIVE_TYPE_PARAM_VALUE: {
				PrimitiveTypeParamValue primitiveTypeParamValue = (PrimitiveTypeParamValue)theEObject;
				T result = casePrimitiveTypeParamValue(primitiveTypeParamValue);
				if (result == null) result = caseSearchParamValue(primitiveTypeParamValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.FORMAT_ASSISTANT: {
				FormatAssistant formatAssistant = (FormatAssistant)theEObject;
				T result = caseFormatAssistant(formatAssistant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SemanticmanagerPackage.MODEL_PERSISTENCE: {
				ModelPersistence modelPersistence = (ModelPersistence)theEObject;
				T result = caseModelPersistence(modelPersistence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repository Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repository Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepositoryManager(RepositoryManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Interpreter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Interpreter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintInterpreter(ConstraintInterpreter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintResult(ConstraintResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Search Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Search Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSearchParam(SearchParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Search Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Search Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSearchResult(SearchResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Search Param Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Search Param Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSearchParamValue(SearchParamValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Search Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Search Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSearchConfiguration(SearchConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Search Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Search Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleSearchConfiguration(SimpleSearchConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Search Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Search Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeSearchConfiguration(CompositeSearchConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseService(Service object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Search</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Search</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomSearch(CustomSearch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate Based Search</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate Based Search</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredicateBasedSearch(PredicateBasedSearch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Search Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Search Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicSearchResult(AtomicSearchResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grouped Search Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grouped Search Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroupedSearchResult(GroupedSearchResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticGroup(SemanticGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepository(Repository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticNode(SemanticNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectProperty(ObjectProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataProperty(DataProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaData(MetaData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceElement(ResourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveTypeParam(PrimitiveTypeParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Type Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Type Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelTypeParam(ModelTypeParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Type Param Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Type Param Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelTypeParamValue(ModelTypeParamValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type Param Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type Param Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveTypeParamValue(PrimitiveTypeParamValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Format Assistant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Format Assistant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormatAssistant(FormatAssistant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Persistence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Persistence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelPersistence(ModelPersistence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SemanticmanagerSwitch
