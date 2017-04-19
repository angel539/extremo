/**
 */
package semanticmanager.queries.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import semanticmanager.dataModel.NamedElement;

import semanticmanager.queries.*;

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
 * @see semanticmanager.queries.QueriesPackage
 * @generated
 */
public class QueriesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QueriesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueriesSwitch() {
		if (modelPackage == null) {
			modelPackage = QueriesPackage.eINSTANCE;
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
			case QueriesPackage.SEARCH_OPTION: {
				SearchOption searchOption = (SearchOption)theEObject;
				T result = caseSearchOption(searchOption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.SEARCH_RESULT: {
				SearchResult searchResult = (SearchResult)theEObject;
				T result = caseSearchResult(searchResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.SEARCH_RESULT_OPTION_VALUE: {
				SearchResultOptionValue searchResultOptionValue = (SearchResultOptionValue)theEObject;
				T result = caseSearchResultOptionValue(searchResultOptionValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.SEARCH_CONFIGURATION: {
				SearchConfiguration searchConfiguration = (SearchConfiguration)theEObject;
				T result = caseSearchConfiguration(searchConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.SIMPLE_SEARCH_CONFIGURATION: {
				SimpleSearchConfiguration simpleSearchConfiguration = (SimpleSearchConfiguration)theEObject;
				T result = caseSimpleSearchConfiguration(simpleSearchConfiguration);
				if (result == null) result = caseSearchConfiguration(simpleSearchConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.COMPOSITE_SEARCH_CONFIGURATION: {
				CompositeSearchConfiguration compositeSearchConfiguration = (CompositeSearchConfiguration)theEObject;
				T result = caseCompositeSearchConfiguration(compositeSearchConfiguration);
				if (result == null) result = caseSearchConfiguration(compositeSearchConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.SERVICE: {
				Service service = (Service)theEObject;
				T result = caseService(service);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.CUSTOM_SEARCH: {
				CustomSearch customSearch = (CustomSearch)theEObject;
				T result = caseCustomSearch(customSearch);
				if (result == null) result = caseSimpleSearchConfiguration(customSearch);
				if (result == null) result = caseSearchConfiguration(customSearch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.PREDICATE_BASED_SEARCH: {
				PredicateBasedSearch predicateBasedSearch = (PredicateBasedSearch)theEObject;
				T result = casePredicateBasedSearch(predicateBasedSearch);
				if (result == null) result = caseSimpleSearchConfiguration(predicateBasedSearch);
				if (result == null) result = caseSearchConfiguration(predicateBasedSearch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.ATOMIC_SEARCH_RESULT: {
				AtomicSearchResult atomicSearchResult = (AtomicSearchResult)theEObject;
				T result = caseAtomicSearchResult(atomicSearchResult);
				if (result == null) result = caseSearchResult(atomicSearchResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.GROUPED_SEARCH_RESULT: {
				GroupedSearchResult groupedSearchResult = (GroupedSearchResult)theEObject;
				T result = caseGroupedSearchResult(groupedSearchResult);
				if (result == null) result = caseSearchResult(groupedSearchResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QueriesPackage.SEMANTIC_GROUP: {
				SemanticGroup semanticGroup = (SemanticGroup)theEObject;
				T result = caseSemanticGroup(semanticGroup);
				if (result == null) result = caseNamedElement(semanticGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Search Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Search Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSearchOption(SearchOption object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Search Result Option Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Search Result Option Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSearchResultOptionValue(SearchResultOptionValue object) {
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

} //QueriesSwitch
