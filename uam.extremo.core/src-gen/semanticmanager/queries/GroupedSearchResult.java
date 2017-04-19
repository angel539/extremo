/**
 */
package semanticmanager.queries;

import org.eclipse.emf.common.util.EList;

import semanticmanager.dataModel.DataProperty;
import semanticmanager.dataModel.NamedElement;
import semanticmanager.dataModel.ObjectProperty;
import semanticmanager.dataModel.Resource;
import semanticmanager.dataModel.SemanticNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grouped Search Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.GroupedSearchResult#getGroups <em>Groups</em>}</li>
 * </ul>
 *
 * @see semanticmanager.queries.QueriesPackage#getGroupedSearchResult()
 * @model abstract="true"
 * @generated
 */
public interface GroupedSearchResult extends SearchResult {
	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.queries.SemanticGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see semanticmanager.queries.QueriesPackage#getGroupedSearchResult_Groups()
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

} // GroupedSearchResult
