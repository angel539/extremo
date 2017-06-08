/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate Based Search</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.PredicateBasedSearch#getFilterBy <em>Filter By</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getPredicateBasedSearch()
 * @model
 * @generated
 */
public interface PredicateBasedSearch extends SimpleSearchConfiguration {
	/**
	 * Returns the value of the '<em><b>Filter By</b></em>' attribute.
	 * The literals are from the enumeration {@link semanticmanager.DataModelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter By</em>' attribute.
	 * @see semanticmanager.DataModelType
	 * @see #setFilterBy(DataModelType)
	 * @see semanticmanager.SemanticmanagerPackage#getPredicateBasedSearch_FilterBy()
	 * @model
	 * @generated
	 */
	DataModelType getFilterBy();

	/**
	 * Sets the value of the '{@link semanticmanager.PredicateBasedSearch#getFilterBy <em>Filter By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter By</em>' attribute.
	 * @see semanticmanager.DataModelType
	 * @see #getFilterBy()
	 * @generated
	 */
	void setFilterBy(DataModelType value);

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
