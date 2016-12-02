/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.Resource#isActive <em>Active</em>}</li>
 *   <li>{@link semanticmanager.Resource#isAlive <em>Alive</em>}</li>
 *   <li>{@link semanticmanager.Resource#getAssistant <em>Assistant</em>}</li>
 *   <li>{@link semanticmanager.Resource#getNodes <em>Nodes</em>}</li>
 *   <li>{@link semanticmanager.Resource#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see semanticmanager.SemanticmanagerPackage#getResource_Active()
	 * @model
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link semanticmanager.Resource#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Alive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alive</em>' attribute.
	 * @see #setAlive(boolean)
	 * @see semanticmanager.SemanticmanagerPackage#getResource_Alive()
	 * @model
	 * @generated
	 */
	boolean isAlive();

	/**
	 * Sets the value of the '{@link semanticmanager.Resource#isAlive <em>Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alive</em>' attribute.
	 * @see #isAlive()
	 * @generated
	 */
	void setAlive(boolean value);

	/**
	 * Returns the value of the '<em><b>Assistant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assistant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assistant</em>' attribute.
	 * @see #setAssistant(String)
	 * @see semanticmanager.SemanticmanagerPackage#getResource_Assistant()
	 * @model
	 * @generated
	 */
	String getAssistant();

	/**
	 * Sets the value of the '{@link semanticmanager.Resource#getAssistant <em>Assistant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assistant</em>' attribute.
	 * @see #getAssistant()
	 * @generated
	 */
	void setAssistant(String value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.SemanticNode}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.SemanticNode#getResourceFrom <em>Resource From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getResource_Nodes()
	 * @see semanticmanager.SemanticNode#getResourceFrom
	 * @model opposite="resourceFrom" containment="true"
	 * @generated
	 */
	EList<SemanticNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see semanticmanager.SemanticmanagerPackage#getResource_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link semanticmanager.Resource#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // Resource
