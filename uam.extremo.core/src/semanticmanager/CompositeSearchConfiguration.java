/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.CompositeSearchConfiguration#getResults <em>Results</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getCompositeSearchConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface CompositeSearchConfiguration extends SearchConfiguration {
	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.SearchResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getCompositeSearchConfiguration_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchResult> getResults();

} // CompositeSearchConfiguration
