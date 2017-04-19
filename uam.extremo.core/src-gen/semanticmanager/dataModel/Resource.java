/**
 */
package semanticmanager.dataModel;

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
 *   <li>{@link semanticmanager.dataModel.Resource#isActive <em>Active</em>}</li>
 *   <li>{@link semanticmanager.dataModel.Resource#isAlive <em>Alive</em>}</li>
 *   <li>{@link semanticmanager.dataModel.Resource#getAssistant <em>Assistant</em>}</li>
 *   <li>{@link semanticmanager.dataModel.Resource#getNodes <em>Nodes</em>}</li>
 *   <li>{@link semanticmanager.dataModel.Resource#getUri <em>Uri</em>}</li>
 *   <li>{@link semanticmanager.dataModel.Resource#getRepositoryFrom <em>Repository From</em>}</li>
 * </ul>
 *
 * @see semanticmanager.dataModel.DataModelPackage#getResource()
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
	 * @see semanticmanager.dataModel.DataModelPackage#getResource_Active()
	 * @model
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link semanticmanager.dataModel.Resource#isActive <em>Active</em>}' attribute.
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
	 * @see semanticmanager.dataModel.DataModelPackage#getResource_Alive()
	 * @model
	 * @generated
	 */
	boolean isAlive();

	/**
	 * Sets the value of the '{@link semanticmanager.dataModel.Resource#isAlive <em>Alive</em>}' attribute.
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
	 * @see semanticmanager.dataModel.DataModelPackage#getResource_Assistant()
	 * @model
	 * @generated
	 */
	String getAssistant();

	/**
	 * Sets the value of the '{@link semanticmanager.dataModel.Resource#getAssistant <em>Assistant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assistant</em>' attribute.
	 * @see #getAssistant()
	 * @generated
	 */
	void setAssistant(String value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.dataModel.SemanticNode}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.dataModel.SemanticNode#getResourceFrom <em>Resource From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see semanticmanager.dataModel.DataModelPackage#getResource_Nodes()
	 * @see semanticmanager.dataModel.SemanticNode#getResourceFrom
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
	 * @see semanticmanager.dataModel.DataModelPackage#getResource_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link semanticmanager.dataModel.Resource#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Repository From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.dataModel.Repository#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository From</em>' container reference.
	 * @see #setRepositoryFrom(Repository)
	 * @see semanticmanager.dataModel.DataModelPackage#getResource_RepositoryFrom()
	 * @see semanticmanager.dataModel.Repository#getResources
	 * @model opposite="resources" transient="false"
	 * @generated
	 */
	Repository getRepositoryFrom();

	/**
	 * Sets the value of the '{@link semanticmanager.dataModel.Resource#getRepositoryFrom <em>Repository From</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository From</em>' container reference.
	 * @see #getRepositoryFrom()
	 * @generated
	 */
	void setRepositoryFrom(Repository value);

} // Resource
