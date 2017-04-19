/**
 */
package semanticmanager.constraints;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import semanticmanager.dataModel.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Interpreter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.constraints.ConstraintInterpreter#getId <em>Id</em>}</li>
 *   <li>{@link semanticmanager.constraints.ConstraintInterpreter#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.constraints.ConstraintInterpreter#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link semanticmanager.constraints.ConstraintInterpreter#getEvals <em>Evals</em>}</li>
 * </ul>
 *
 * @see semanticmanager.constraints.ConstraintsPackage#getConstraintInterpreter()
 * @model abstract="true"
 * @generated
 */
public interface ConstraintInterpreter extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see semanticmanager.constraints.ConstraintsPackage#getConstraintInterpreter_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link semanticmanager.constraints.ConstraintInterpreter#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see semanticmanager.constraints.ConstraintsPackage#getConstraintInterpreter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link semanticmanager.constraints.ConstraintInterpreter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.constraints.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference list.
	 * @see semanticmanager.constraints.ConstraintsPackage#getConstraintInterpreter_Constraints()
	 * @model
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Evals</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.constraints.ConstraintResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evals</em>' reference list.
	 * @see semanticmanager.constraints.ConstraintsPackage#getConstraintInterpreter_Evals()
	 * @model
	 * @generated
	 */
	EList<ConstraintResult> getEvals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean eval(Constraint constraint, NamedElement namedElement);

} // ConstraintInterpreter
