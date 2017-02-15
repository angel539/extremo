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
 *   <li>{@link semanticmanager.SearchResult#isShowByResource <em>Show By Resource</em>}</li>
 *   <li>{@link semanticmanager.SearchResult#getApplyOnElements <em>Apply On Elements</em>}</li>
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
	 * It is bidirectional and its opposite is '{@link semanticmanager.SimpleSearchConfiguration#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' container reference.
	 * @see #setConfiguration(SimpleSearchConfiguration)
	 * @see semanticmanager.SemanticmanagerPackage#getSearchResult_Configuration()
	 * @see semanticmanager.SimpleSearchConfiguration#getResults
	 * @model opposite="results" transient="false"
	 * @generated
	 */
	SimpleSearchConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link semanticmanager.SearchResult#getConfiguration <em>Configuration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' container reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(SimpleSearchConfiguration value);

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
	 * Returns the value of the '<em><b>Show By Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show By Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show By Resource</em>' attribute.
	 * @see #setShowByResource(boolean)
	 * @see semanticmanager.SemanticmanagerPackage#getSearchResult_ShowByResource()
	 * @model
	 * @generated
	 */
	boolean isShowByResource();

	/**
	 * Sets the value of the '{@link semanticmanager.SearchResult#isShowByResource <em>Show By Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show By Resource</em>' attribute.
	 * @see #isShowByResource()
	 * @generated
	 */
	void setShowByResource(boolean value);

	/**
	 * Returns the value of the '<em><b>Apply On Elements</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Apply On Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Apply On Elements</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSearchResult_ApplyOnElements()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getApplyOnElements();

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Object getOptionValue(String key);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addNamedElementToSemanticGroup(SemanticGroup semanticGroup, NamedElement namedElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addResourceToSemanticGroup(SemanticGroup semanticGroup, Resource resource);

} // SearchResult
