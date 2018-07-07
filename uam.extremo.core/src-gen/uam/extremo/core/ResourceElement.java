/**
 */
package uam.extremo.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.ResourceElement#getResourceFrom <em>Resource From</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getResourceElement()
 * @model abstract="true"
 * @generated
 */
public interface ResourceElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Resource From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.Resource#getResourceElements <em>Resource Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource From</em>' container reference.
	 * @see #setResourceFrom(Resource)
	 * @see uam.extremo.core.SemanticmanagerPackage#getResourceElement_ResourceFrom()
	 * @see uam.extremo.core.Resource#getResourceElements
	 * @model opposite="resourceElements" transient="false"
	 * @generated
	 */
	Resource getResourceFrom();

	/**
	 * Sets the value of the '{@link uam.extremo.core.ResourceElement#getResourceFrom <em>Resource From</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource From</em>' container reference.
	 * @see #getResourceFrom()
	 * @generated
	 */
	void setResourceFrom(Resource value);

} // ResourceElement
