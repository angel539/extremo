/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Search Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.AtomicSearchResult#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getAtomicSearchResult()
 * @model
 * @generated
 */
public interface AtomicSearchResult extends SearchResult {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getAtomicSearchResult_Elements()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getElements();

} // AtomicSearchResult
