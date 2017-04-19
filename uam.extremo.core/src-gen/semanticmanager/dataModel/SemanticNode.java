/**
 */
package semanticmanager.dataModel;

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
 *   <li>{@link semanticmanager.dataModel.SemanticNode#getSupers <em>Supers</em>}</li>
 *   <li>{@link semanticmanager.dataModel.SemanticNode#getSubs <em>Subs</em>}</li>
 *   <li>{@link semanticmanager.dataModel.SemanticNode#getProperties <em>Properties</em>}</li>
 *   <li>{@link semanticmanager.dataModel.SemanticNode#getResourceFrom <em>Resource From</em>}</li>
 *   <li>{@link semanticmanager.dataModel.SemanticNode#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @see semanticmanager.dataModel.DataModelPackage#getSemanticNode()
 * @model
 * @generated
 */
public interface SemanticNode extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Supers</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.dataModel.SemanticNode}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.dataModel.SemanticNode#getSubs <em>Subs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supers</em>' reference list.
	 * @see semanticmanager.dataModel.DataModelPackage#getSemanticNode_Supers()
	 * @see semanticmanager.dataModel.SemanticNode#getSubs
	 * @model opposite="subs"
	 * @generated
	 */
	EList<SemanticNode> getSupers();

	/**
	 * Returns the value of the '<em><b>Subs</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.dataModel.SemanticNode}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.dataModel.SemanticNode#getSupers <em>Supers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subs</em>' reference list.
	 * @see semanticmanager.dataModel.DataModelPackage#getSemanticNode_Subs()
	 * @see semanticmanager.dataModel.SemanticNode#getSupers
	 * @model opposite="supers"
	 * @generated
	 */
	EList<SemanticNode> getSubs();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.dataModel.Property}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.dataModel.Property#getSemanticNodeFrom <em>Semantic Node From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see semanticmanager.dataModel.DataModelPackage#getSemanticNode_Properties()
	 * @see semanticmanager.dataModel.Property#getSemanticNodeFrom
	 * @model opposite="semanticNodeFrom" containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Resource From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.dataModel.Resource#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource From</em>' container reference.
	 * @see #setResourceFrom(Resource)
	 * @see semanticmanager.dataModel.DataModelPackage#getSemanticNode_ResourceFrom()
	 * @see semanticmanager.dataModel.Resource#getNodes
	 * @model opposite="nodes" transient="false"
	 * @generated
	 */
	Resource getResourceFrom();

	/**
	 * Sets the value of the '{@link semanticmanager.dataModel.SemanticNode#getResourceFrom <em>Resource From</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource From</em>' container reference.
	 * @see #getResourceFrom()
	 * @generated
	 */
	void setResourceFrom(Resource value);

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
	 * @see semanticmanager.dataModel.DataModelPackage#getSemanticNode_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link semanticmanager.dataModel.SemanticNode#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

} // SemanticNode
