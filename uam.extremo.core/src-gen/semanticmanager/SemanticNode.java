/**
 */
package semanticmanager;

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
 *   <li>{@link semanticmanager.SemanticNode#getProperties <em>Properties</em>}</li>
 *   <li>{@link semanticmanager.SemanticNode#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link semanticmanager.SemanticNode#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getSemanticNode()
 * @model
 * @generated
 */
public interface SemanticNode extends ResourceElement {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.Property}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.Property#getSemanticNodeFrom <em>Semantic Node From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSemanticNode_Properties()
	 * @see semanticmanager.Property#getSemanticNodeFrom
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
	 * @see semanticmanager.SemanticmanagerPackage#getSemanticNode_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link semanticmanager.SemanticNode#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.ObjectProperty}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.ObjectProperty#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSemanticNode_Domain()
	 * @see semanticmanager.ObjectProperty#getRange
	 * @model opposite="range"
	 * @generated
	 */
	EList<ObjectProperty> getDomain();

} // SemanticNode
