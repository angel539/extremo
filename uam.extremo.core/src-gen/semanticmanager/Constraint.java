/**
 */
package semanticmanager;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.Constraint#getType <em>Type</em>}</li>
 *   <li>{@link semanticmanager.Constraint#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.Constraint#getBody <em>Body</em>}</li>
 *   <li>{@link semanticmanager.Constraint#getAppliedTo <em>Applied To</em>}</li>
 *   <li>{@link semanticmanager.Constraint#getEvaluations <em>Evaluations</em>}</li>
 *   <li>{@link semanticmanager.Constraint#getInterpreter <em>Interpreter</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getConstraint()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface Constraint extends PersistentEObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see semanticmanager.SemanticmanagerPackage#getConstraint_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link semanticmanager.Constraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see semanticmanager.SemanticmanagerPackage#getConstraint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link semanticmanager.Constraint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see semanticmanager.SemanticmanagerPackage#getConstraint_Body()
	 * @model
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link semanticmanager.Constraint#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Applied To</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.NamedElement#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied To</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied To</em>' container reference.
	 * @see #setAppliedTo(NamedElement)
	 * @see semanticmanager.SemanticmanagerPackage#getConstraint_AppliedTo()
	 * @see semanticmanager.NamedElement#getConstraints
	 * @model opposite="constraints" transient="false"
	 * @generated
	 */
	NamedElement getAppliedTo();

	/**
	 * Sets the value of the '{@link semanticmanager.Constraint#getAppliedTo <em>Applied To</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied To</em>' container reference.
	 * @see #getAppliedTo()
	 * @generated
	 */
	void setAppliedTo(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Evaluations</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.ConstraintResult}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.ConstraintResult#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluations</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getConstraint_Evaluations()
	 * @see semanticmanager.ConstraintResult#getConstraint
	 * @model opposite="constraint"
	 * @generated
	 */
	EList<ConstraintResult> getEvaluations();

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

} // Constraint
