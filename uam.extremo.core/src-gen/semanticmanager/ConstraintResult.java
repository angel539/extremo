/**
 */
package semanticmanager;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.ConstraintResult#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link semanticmanager.ConstraintResult#getContext <em>Context</em>}</li>
 *   <li>{@link semanticmanager.ConstraintResult#getUnsat <em>Unsat</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getConstraintResult()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface ConstraintResult extends PersistentEObject {
	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.Constraint#getEvaluations <em>Evaluations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' reference.
	 * @see #setConstraint(Constraint)
	 * @see semanticmanager.SemanticmanagerPackage#getConstraintResult_Constraint()
	 * @see semanticmanager.Constraint#getEvaluations
	 * @model opposite="evaluations"
	 * @generated
	 */
	Constraint getConstraint();

	/**
	 * Sets the value of the '{@link semanticmanager.ConstraintResult#getConstraint <em>Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' reference.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(Constraint value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(Resource)
	 * @see semanticmanager.SemanticmanagerPackage#getConstraintResult_Context()
	 * @model
	 * @generated
	 */
	Resource getContext();

	/**
	 * Sets the value of the '{@link semanticmanager.ConstraintResult#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Resource value);

	/**
	 * Returns the value of the '<em><b>Unsat</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsat</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsat</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getConstraintResult_Unsat()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getUnsat();

} // ConstraintResult
