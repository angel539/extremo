/**
 */
package uam.extremo.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Semantic Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.SemanticNode#getProperties <em>Properties</em>}</li>
 *   <li>{@link uam.extremo.core.SemanticNode#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link uam.extremo.core.SemanticNode#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getSemanticNode()
 * @model
 * @generated
 */
public interface SemanticNode extends ResourceElement {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.Property}.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.Property#getSemanticNodeFrom <em>Semantic Node From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getSemanticNode_Properties()
	 * @see uam.extremo.core.Property#getSemanticNodeFrom
	 * @model opposite="semanticNodeFrom" containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see uam.extremo.core.SemanticmanagerPackage#getSemanticNode_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link uam.extremo.core.SemanticNode#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference list.
	 * The list contents are of type {@link uam.extremo.core.ObjectProperty}.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.ObjectProperty#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getSemanticNode_Domain()
	 * @see uam.extremo.core.ObjectProperty#getRange
	 * @model opposite="range"
	 * @generated
	 */
	EList<ObjectProperty> getDomain();

} // SemanticNode
