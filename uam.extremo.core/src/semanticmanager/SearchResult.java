/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.SearchResult#getValues <em>Values</em>}</li>
 *   <li>{@link semanticmanager.SearchResult#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link semanticmanager.SearchResult#getResults <em>Results</em>}</li>
 *   <li>{@link semanticmanager.SearchResult#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getSearchResult()
 * @model
 * @generated
 */
public interface SearchResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.SearchResultOptionValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSearchResult_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchResultOptionValue> getValues();

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.SearchConfiguration#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' container reference.
	 * @see #setConfiguration(SearchConfiguration)
	 * @see semanticmanager.SemanticmanagerPackage#getSearchResult_Configuration()
	 * @see semanticmanager.SearchConfiguration#getResults
	 * @model opposite="results" transient="false"
	 * @generated
	 */
	SearchConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link semanticmanager.SearchResult#getConfiguration <em>Configuration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' container reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(SearchConfiguration value);

	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.SemanticGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSearchResult_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<SemanticGroup> getResults();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSearchResult_Resources()
	 * @model
	 * @generated
	 */
	EList<Resource> getResources();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SemanticGroup createSemanticGroup(String name, String description);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSemanticNodeToSemanticGroup(SemanticGroup semanticGroup, SemanticNode semanticNode);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addDataPropertyToSemanticGroup(SemanticGroup semanticGroup, DataProperty dataProperty);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addObjectPropertyToSemanticGroup(SemanticGroup semanticGroup, ObjectProperty objectProperty);

} // SearchResult
