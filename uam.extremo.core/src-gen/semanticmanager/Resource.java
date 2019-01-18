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
 *   <li>{@link semanticmanager.Resource#getResourceElements <em>Resource Elements</em>}</li>
 *   <li>{@link semanticmanager.Resource#getUri <em>Uri</em>}</li>
 *   <li>{@link semanticmanager.Resource#getRepositoryFrom <em>Repository From</em>}</li>
 *   <li>{@link semanticmanager.Resource#getDefaultConstraintInterpreter <em>Default Constraint Interpreter</em>}</li>
 *   <li>{@link semanticmanager.Resource#getAssistant <em>Assistant</em>}</li>
 *   <li>{@link semanticmanager.Resource#getGuardSemanticNodes <em>Guard Semantic Nodes</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends ResourceElement {
	/**
	 * Returns the value of the '<em><b>Resource Elements</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.ResourceElement}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.ResourceElement#getResourceFrom <em>Resource From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Elements</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getResource_ResourceElements()
	 * @see semanticmanager.ResourceElement#getResourceFrom
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

	/**
	 * Returns the value of the '<em><b>Repository From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.Repository#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository From</em>' container reference.
	 * @see #setRepositoryFrom(Repository)
	 * @see semanticmanager.SemanticmanagerPackage#getResource_RepositoryFrom()
	 * @see semanticmanager.Repository#getResources
	 * @model opposite="resources" transient="false"
	 * @generated
	 */
	Repository getRepositoryFrom();

	/**
	 * Sets the value of the '{@link semanticmanager.Resource#getRepositoryFrom <em>Repository From</em>}' container reference.
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
	 * @see semanticmanager.SemanticmanagerPackage#getResource_DefaultConstraintInterpreter()
	 * @model
	 * @generated
	 */
	ConstraintInterpreter getDefaultConstraintInterpreter();

	/**
	 * Sets the value of the '{@link semanticmanager.Resource#getDefaultConstraintInterpreter <em>Default Constraint Interpreter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Constraint Interpreter</em>' reference.
	 * @see #getDefaultConstraintInterpreter()
	 * @generated
	 */
	void setDefaultConstraintInterpreter(ConstraintInterpreter value);

	/**
	 * Returns the value of the '<em><b>Assistant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assistant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assistant</em>' reference.
	 * @see #setAssistant(FormatAssistant)
	 * @see semanticmanager.SemanticmanagerPackage#getResource_Assistant()
	 * @model
	 * @generated
	 */
	FormatAssistant getAssistant();

	/**
	 * Sets the value of the '{@link semanticmanager.Resource#getAssistant <em>Assistant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assistant</em>' reference.
	 * @see #getAssistant()
	 * @generated
	 */
	void setAssistant(FormatAssistant value);

	/**
	 * Returns the value of the '<em><b>Guard Semantic Nodes</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.SemanticNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard Semantic Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard Semantic Nodes</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getResource_GuardSemanticNodes()
	 * @model
	 * @generated
	 */
	EList<SemanticNode> getGuardSemanticNodes();

} // Resource
