/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.TreeNode#getChildren <em>Children</em>}</li>
 *   <li>{@link semanticmanager.TreeNode#getDefinition <em>Definition</em>}</li>
 *   <li>{@link semanticmanager.TreeNode#getUsages <em>Usages</em>}</li>
 *   <li>{@link semanticmanager.TreeNode#getKind <em>Kind</em>}</li>
 *   <li>{@link semanticmanager.TreeNode#isValid <em>Valid</em>}</li>
 *   <li>{@link semanticmanager.TreeNode#getPoints <em>Points</em>}</li>
 *   <li>{@link semanticmanager.TreeNode#getCountWordnet <em>Count Wordnet</em>}</li>
 *   <li>{@link semanticmanager.TreeNode#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getTreeNode()
 * @model
 * @generated
 */
public interface TreeNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.TreeNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getTreeNode_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<TreeNode> getChildren();

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' attribute.
	 * @see #setDefinition(String)
	 * @see semanticmanager.SemanticmanagerPackage#getTreeNode_Definition()
	 * @model
	 * @generated
	 */
	String getDefinition();

	/**
	 * Sets the value of the '{@link semanticmanager.TreeNode#getDefinition <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' attribute.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(String value);

	/**
	 * Returns the value of the '<em><b>Usages</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usages</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usages</em>' attribute list.
	 * @see semanticmanager.SemanticmanagerPackage#getTreeNode_Usages()
	 * @model
	 * @generated
	 */
	EList<String> getUsages();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(int)
	 * @see semanticmanager.SemanticmanagerPackage#getTreeNode_Kind()
	 * @model
	 * @generated
	 */
	int getKind();

	/**
	 * Sets the value of the '{@link semanticmanager.TreeNode#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(int value);

	/**
	 * Returns the value of the '<em><b>Valid</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid</em>' attribute.
	 * @see #setValid(boolean)
	 * @see semanticmanager.SemanticmanagerPackage#getTreeNode_Valid()
	 * @model default="true"
	 * @generated
	 */
	boolean isValid();

	/**
	 * Sets the value of the '{@link semanticmanager.TreeNode#isValid <em>Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid</em>' attribute.
	 * @see #isValid()
	 * @generated
	 */
	void setValid(boolean value);

	/**
	 * Returns the value of the '<em><b>Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Points</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' attribute.
	 * @see #setPoints(int)
	 * @see semanticmanager.SemanticmanagerPackage#getTreeNode_Points()
	 * @model
	 * @generated
	 */
	int getPoints();

	/**
	 * Sets the value of the '{@link semanticmanager.TreeNode#getPoints <em>Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Points</em>' attribute.
	 * @see #getPoints()
	 * @generated
	 */
	void setPoints(int value);

	/**
	 * Returns the value of the '<em><b>Count Wordnet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count Wordnet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count Wordnet</em>' attribute.
	 * @see #setCountWordnet(int)
	 * @see semanticmanager.SemanticmanagerPackage#getTreeNode_CountWordnet()
	 * @model
	 * @generated
	 */
	int getCountWordnet();

	/**
	 * Sets the value of the '{@link semanticmanager.TreeNode#getCountWordnet <em>Count Wordnet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count Wordnet</em>' attribute.
	 * @see #getCountWordnet()
	 * @generated
	 */
	void setCountWordnet(int value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute list.
	 * @see semanticmanager.SemanticmanagerPackage#getTreeNode_Data()
	 * @model
	 * @generated
	 */
	EList<String> getData();

} // TreeNode
