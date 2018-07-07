/**
 */
package uam.extremo.core;

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
 *   <li>{@link uam.extremo.core.AtomicSearchResult#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getAtomicSearchResult()
 * @model
 * @generated
 */
public interface AtomicSearchResult extends SearchResult {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link uam.extremo.core.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getAtomicSearchResult_Elements()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getElements();

} // AtomicSearchResult
