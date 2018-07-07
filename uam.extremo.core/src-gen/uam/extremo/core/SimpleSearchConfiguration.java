/**
 */
package uam.extremo.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.SimpleSearchConfiguration#getOptions <em>Options</em>}</li>
 *   <li>{@link uam.extremo.core.SimpleSearchConfiguration#getDescription <em>Description</em>}</li>
 *   <li>{@link uam.extremo.core.SimpleSearchConfiguration#getFilterBy <em>Filter By</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getSimpleSearchConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface SimpleSearchConfiguration extends SearchConfiguration {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.SearchParam}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getSimpleSearchConfiguration_Options()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchParam> getOptions();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see uam.extremo.core.SemanticmanagerPackage#getSimpleSearchConfiguration_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link uam.extremo.core.SimpleSearchConfiguration#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Filter By</b></em>' attribute.
	 * The literals are from the enumeration {@link uam.extremo.core.DataModelType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter By</em>' attribute.
	 * @see uam.extremo.core.DataModelType
	 * @see #setFilterBy(DataModelType)
	 * @see uam.extremo.core.SemanticmanagerPackage#getSimpleSearchConfiguration_FilterBy()
	 * @model
	 * @generated
	 */
	DataModelType getFilterBy();

	/**
	 * Sets the value of the '{@link uam.extremo.core.SimpleSearchConfiguration#getFilterBy <em>Filter By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter By</em>' attribute.
	 * @see uam.extremo.core.DataModelType
	 * @see #getFilterBy()
	 * @generated
	 */
	void setFilterBy(DataModelType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addPrimitiveTypeSearchOption(String id, String name, Type type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addDataModelTypeSearchOption(String id, String name, DataModelType type);

} // SimpleSearchConfiguration
