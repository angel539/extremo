/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.Constraint#getKey <em>Key</em>}</li>
 *   <li>{@link semanticmanager.Constraint#getValue <em>Value</em>}</li>
 *   <li>{@link semanticmanager.Constraint#getValidatedElements <em>Validated Elements</em>}</li>
 *   <li>{@link semanticmanager.Constraint#getInterpreter <em>Interpreter</em>}</li>
 *   <li>{@link semanticmanager.Constraint#getApplyOnElements <em>Apply On Elements</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see semanticmanager.SemanticmanagerPackage#getConstraint_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link semanticmanager.Constraint#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see semanticmanager.SemanticmanagerPackage#getConstraint_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link semanticmanager.Constraint#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Validated Elements</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validated Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validated Elements</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getConstraint_ValidatedElements()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getValidatedElements();

	/**
	 * Returns the value of the '<em><b>Interpreter</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.ConstraintInterpreter#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpreter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpreter</em>' reference.
	 * @see #setInterpreter(ConstraintInterpreter)
	 * @see semanticmanager.SemanticmanagerPackage#getConstraint_Interpreter()
	 * @see semanticmanager.ConstraintInterpreter#getConstraints
	 * @model opposite="constraints"
	 * @generated
	 */
	ConstraintInterpreter getInterpreter();

	/**
	 * Sets the value of the '{@link semanticmanager.Constraint#getInterpreter <em>Interpreter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpreter</em>' reference.
	 * @see #getInterpreter()
	 * @generated
	 */
	void setInterpreter(ConstraintInterpreter value);

	/**
	 * Returns the value of the '<em><b>Apply On Elements</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Apply On Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Apply On Elements</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getConstraint_ApplyOnElements()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getApplyOnElements();

} // Constraint
