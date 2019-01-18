/**
 */
package semanticmanager;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate Based Search</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see semanticmanager.SemanticmanagerPackage#getPredicateBasedSearch()
 * @model abstract="true"
 * @generated
 */
public interface PredicateBasedSearch extends SimpleSearchConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model namedElementRequired="true"
	 * @generated
	 */
	boolean matches(NamedElement namedElement);

} // PredicateBasedSearch
