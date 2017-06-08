/**
 */
package semanticmanager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Search</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.CustomSearch#isGrouped <em>Grouped</em>}</li>
 *   <li>{@link semanticmanager.CustomSearch#getLevel <em>Level</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getCustomSearch()
 * @model
 * @generated
 */
public interface CustomSearch extends SimpleSearchConfiguration {
	/**
	 * Returns the value of the '<em><b>Grouped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grouped</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grouped</em>' attribute.
	 * @see #setGrouped(boolean)
	 * @see semanticmanager.SemanticmanagerPackage#getCustomSearch_Grouped()
	 * @model
	 * @generated
	 */
	boolean isGrouped();

	/**
	 * Sets the value of the '{@link semanticmanager.CustomSearch#isGrouped <em>Grouped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grouped</em>' attribute.
	 * @see #isGrouped()
	 * @generated
	 */
	void setGrouped(boolean value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link semanticmanager.Level}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see semanticmanager.Level
	 * @see #setLevel(Level)
	 * @see semanticmanager.SemanticmanagerPackage#getCustomSearch_Level()
	 * @model
	 * @generated
	 */
	Level getLevel();

	/**
	 * Sets the value of the '{@link semanticmanager.CustomSearch#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see semanticmanager.Level
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(Level value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void search(SearchResult result);

} // CustomSearch
