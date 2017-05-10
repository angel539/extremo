/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate Based Search</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see semanticmanager.SemanticmanagerPackage#getPredicateBasedSearch()
 * @model
 * @generated
 */
public interface PredicateBasedSearch extends SimpleSearchConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model namedElementRequired="true" inpsMany="true"
	 * @generated
	 */
	boolean matches(NamedElement namedElement, EList<SearchResultOptionValue> inps);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="semanticmanager.JavaObject" inpsMany="true"
	 * @generated
	 */
	Object getOptionValueKey(String key, EList<SearchResultOptionValue> inps);

} // PredicateBasedSearch
