/**
 */
package semanticmanager.queries;

import org.eclipse.emf.common.util.EList;

import semanticmanager.dataModel.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Search Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.AtomicSearchResult#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see semanticmanager.queries.QueriesPackage#getAtomicSearchResult()
 * @model abstract="true"
 * @generated
 */
public interface AtomicSearchResult extends SearchResult {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.dataModel.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see semanticmanager.queries.QueriesPackage#getAtomicSearchResult_Elements()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getElements();

} // AtomicSearchResult
