/**
 */
package uam.extremo.core;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.SearchResult#getValues <em>Values</em>}</li>
 *   <li>{@link uam.extremo.core.SearchResult#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link uam.extremo.core.SearchResult#getApplyOnElements <em>Apply On Elements</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getSearchResult()
 * @model abstract="true"
 * @extends PersistentEObject
 * @generated
 */
public interface SearchResult extends PersistentEObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.SearchParamValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getSearchResult_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchParamValue> getValues();

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.SearchConfiguration#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' container reference.
	 * @see #setConfiguration(SearchConfiguration)
	 * @see uam.extremo.core.SemanticmanagerPackage#getSearchResult_Configuration()
	 * @see uam.extremo.core.SearchConfiguration#getResults
	 * @model opposite="results" transient="false"
	 * @generated
	 */
	SearchConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link uam.extremo.core.SearchResult#getConfiguration <em>Configuration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' container reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(SearchConfiguration value);

	/**
	 * Returns the value of the '<em><b>Apply On Elements</b></em>' reference list.
	 * The list contents are of type {@link uam.extremo.core.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Apply On Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Apply On Elements</em>' reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getSearchResult_ApplyOnElements()
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
	Object getOptionValue(String key);

} // SearchResult
