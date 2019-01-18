/**
 */
package semanticmanager;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint Interpreter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.ConstraintInterpreter#getId <em>Id</em>}</li>
 *   <li>{@link semanticmanager.ConstraintInterpreter#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.ConstraintInterpreter#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link semanticmanager.ConstraintInterpreter#getEvals <em>Evals</em>}</li>
 *   <li>{@link semanticmanager.ConstraintInterpreter#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getConstraintInterpreter()
 * @model abstract="true"
 * @extends PersistentEObject
 * @generated
 */
public interface ConstraintInterpreter extends PersistentEObject {
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
	 * @see semanticmanager.SemanticmanagerPackage#getConstraintInterpreter_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link semanticmanager.ConstraintInterpreter#getId <em>Id</em>}' attribute.
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
	 * @see semanticmanager.SemanticmanagerPackage#getConstraintInterpreter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link semanticmanager.ConstraintInterpreter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.Constraint}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.Constraint#getInterpreter <em>Interpreter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getConstraintInterpreter_Constraints()
	 * @see semanticmanager.Constraint#getInterpreter
	 * @model opposite="interpreter"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Evals</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.ConstraintResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evals</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getConstraintInterpreter_Evals()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintResult> getEvals();

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
	 * @see semanticmanager.SemanticmanagerPackage#getConstraintInterpreter_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link semanticmanager.ConstraintInterpreter#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean eval(Constraint constraint, NamedElement namedElement);

} // ConstraintInterpreter
