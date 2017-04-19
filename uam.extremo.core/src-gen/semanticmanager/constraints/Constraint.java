/**
 */
package semanticmanager.constraints;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import semanticmanager.dataModel.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.constraints.Constraint#getType <em>Type</em>}</li>
 *   <li>{@link semanticmanager.constraints.Constraint#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.constraints.Constraint#getBody <em>Body</em>}</li>
 *   <li>{@link semanticmanager.constraints.Constraint#getAppliedTo <em>Applied To</em>}</li>
 *   <li>{@link semanticmanager.constraints.Constraint#getEvaluations <em>Evaluations</em>}</li>
 * </ul>
 *
 * @see semanticmanager.constraints.ConstraintsPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject {
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
	 * @see semanticmanager.constraints.ConstraintsPackage#getConstraint_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link semanticmanager.constraints.Constraint#getType <em>Type</em>}' attribute.
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
	 * @see semanticmanager.constraints.ConstraintsPackage#getConstraint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link semanticmanager.constraints.Constraint#getName <em>Name</em>}' attribute.
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
	 * @see semanticmanager.constraints.ConstraintsPackage#getConstraint_Body()
	 * @model
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link semanticmanager.constraints.Constraint#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Applied To</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.dataModel.NamedElement#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied To</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied To</em>' container reference.
	 * @see #setAppliedTo(NamedElement)
	 * @see semanticmanager.constraints.ConstraintsPackage#getConstraint_AppliedTo()
	 * @see semanticmanager.dataModel.NamedElement#getConstraints
	 * @model opposite="constraints" transient="false"
	 * @generated
	 */
	NamedElement getAppliedTo();

	/**
	 * Sets the value of the '{@link semanticmanager.constraints.Constraint#getAppliedTo <em>Applied To</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied To</em>' container reference.
	 * @see #getAppliedTo()
	 * @generated
	 */
	void setAppliedTo(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Evaluations</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.constraints.ConstraintResult}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.constraints.ConstraintResult#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluations</em>' reference list.
	 * @see semanticmanager.constraints.ConstraintsPackage#getConstraint_Evaluations()
	 * @see semanticmanager.constraints.ConstraintResult#getConstraint
	 * @model opposite="constraint"
	 * @generated
	 */
	EList<ConstraintResult> getEvaluations();

} // Constraint
