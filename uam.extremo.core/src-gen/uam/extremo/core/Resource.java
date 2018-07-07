/**
 */
package uam.extremo.core;

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
 *   <li>{@link uam.extremo.core.Resource#isActive <em>Active</em>}</li>
 *   <li>{@link uam.extremo.core.Resource#isAlive <em>Alive</em>}</li>
 *   <li>{@link uam.extremo.core.Resource#getAssistant <em>Assistant</em>}</li>
 *   <li>{@link uam.extremo.core.Resource#getResourceElements <em>Resource Elements</em>}</li>
 *   <li>{@link uam.extremo.core.Resource#getUri <em>Uri</em>}</li>
 *   <li>{@link uam.extremo.core.Resource#getRepositoryFrom <em>Repository From</em>}</li>
 *   <li>{@link uam.extremo.core.Resource#getDefaultConstraintInterpreter <em>Default Constraint Interpreter</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends ResourceElement {
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
	 * @see uam.extremo.core.SemanticmanagerPackage#getResource_Active()
	 * @model
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link uam.extremo.core.Resource#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Alive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alive</em>' attribute.
	 * @see #setAlive(boolean)
	 * @see uam.extremo.core.SemanticmanagerPackage#getResource_Alive()
	 * @model default="true"
	 * @generated
	 */
	boolean isAlive();

	/**
	 * Sets the value of the '{@link uam.extremo.core.Resource#isAlive <em>Alive</em>}' attribute.
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
	 * @see uam.extremo.core.SemanticmanagerPackage#getResource_Assistant()
	 * @model
	 * @generated
	 */
	String getAssistant();

	/**
	 * Sets the value of the '{@link uam.extremo.core.Resource#getAssistant <em>Assistant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assistant</em>' attribute.
	 * @see #getAssistant()
	 * @generated
	 */
	void setAssistant(String value);

	/**
	 * Returns the value of the '<em><b>Resource Elements</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.ResourceElement}.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.ResourceElement#getResourceFrom <em>Resource From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Elements</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getResource_ResourceElements()
	 * @see uam.extremo.core.ResourceElement#getResourceFrom
	 * @model opposite="resourceFrom" containment="true"
	 * @generated
	 */
	EList<ResourceElement> getResourceElements();

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
	 * @see uam.extremo.core.SemanticmanagerPackage#getResource_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link uam.extremo.core.Resource#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Repository From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.Repository#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository From</em>' container reference.
	 * @see #setRepositoryFrom(Repository)
	 * @see uam.extremo.core.SemanticmanagerPackage#getResource_RepositoryFrom()
	 * @see uam.extremo.core.Repository#getResources
	 * @model opposite="resources" transient="false"
	 * @generated
	 */
	Repository getRepositoryFrom();

	/**
	 * Sets the value of the '{@link uam.extremo.core.Resource#getRepositoryFrom <em>Repository From</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository From</em>' container reference.
	 * @see #getRepositoryFrom()
	 * @generated
	 */
	void setRepositoryFrom(Repository value);

	/**
	 * Returns the value of the '<em><b>Default Constraint Interpreter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Constraint Interpreter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Constraint Interpreter</em>' reference.
	 * @see #setDefaultConstraintInterpreter(ConstraintInterpreter)
	 * @see uam.extremo.core.SemanticmanagerPackage#getResource_DefaultConstraintInterpreter()
	 * @model
	 * @generated
	 */
	ConstraintInterpreter getDefaultConstraintInterpreter();

	/**
	 * Sets the value of the '{@link uam.extremo.core.Resource#getDefaultConstraintInterpreter <em>Default Constraint Interpreter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Constraint Interpreter</em>' reference.
	 * @see #getDefaultConstraintInterpreter()
	 * @generated
	 */
	void setDefaultConstraintInterpreter(ConstraintInterpreter value);

} // Resource
