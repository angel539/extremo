/**
 */
package semanticmanager;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.Property#getSemanticNodeFrom <em>Semantic Node From</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getProperty()
 * @model abstract="true"
 * @generated
 */
public interface Property extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Semantic Node From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.SemanticNode#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Node From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantic Node From</em>' container reference.
	 * @see #setSemanticNodeFrom(SemanticNode)
	 * @see semanticmanager.SemanticmanagerPackage#getProperty_SemanticNodeFrom()
	 * @see semanticmanager.SemanticNode#getProperties
	 * @model opposite="properties" transient="false"
	 * @generated
	 */
	SemanticNode getSemanticNodeFrom();

	/**
	 * Sets the value of the '{@link semanticmanager.Property#getSemanticNodeFrom <em>Semantic Node From</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantic Node From</em>' container reference.
	 * @see #getSemanticNodeFrom()
	 * @generated
	 */
	void setSemanticNodeFrom(SemanticNode value);

} // Property
