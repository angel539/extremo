/**
 */
package uam.extremo.core;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.SearchConfiguration#getId <em>Id</em>}</li>
 *   <li>{@link uam.extremo.core.SearchConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link uam.extremo.core.SearchConfiguration#getResults <em>Results</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getSearchConfiguration()
 * @model abstract="true"
 * @extends PersistentEObject
 * @generated
 */
public interface SearchConfiguration extends PersistentEObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see uam.extremo.core.SemanticmanagerPackage#getSearchConfiguration_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link uam.extremo.core.SearchConfiguration#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see uam.extremo.core.SemanticmanagerPackage#getSearchConfiguration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uam.extremo.core.SearchConfiguration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.SearchResult}.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.SearchResult#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getSearchConfiguration_Results()
	 * @see uam.extremo.core.SearchResult#getConfiguration
	 * @model opposite="configuration" containment="true"
	 * @generated
	 */
	EList<SearchResult> getResults();

} // SearchConfiguration
