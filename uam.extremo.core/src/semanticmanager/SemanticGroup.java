/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Semantic Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.SemanticGroup#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getSemanticGroup()
 * @model
 * @generated
 */
public interface SemanticGroup extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.SemanticNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSemanticGroup_Nodes()
	 * @model
	 * @generated
	 */
	EList<SemanticNode> getNodes();

} // SemanticGroup
