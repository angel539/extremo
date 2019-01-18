/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grouped Search Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.GroupedSearchResult#getGroups <em>Groups</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getGroupedSearchResult()
 * @model
 * @generated
 */
public interface GroupedSearchResult extends SearchResult {
	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.SemanticGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getGroupedSearchResult_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<SemanticGroup> getGroups();

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
	void addNamedElementToSemanticGroup(SemanticGroup semanticGroup, NamedElement namedElement);

} // GroupedSearchResult
