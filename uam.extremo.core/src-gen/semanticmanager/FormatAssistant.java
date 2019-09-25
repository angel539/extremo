/**
 */
package semanticmanager;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Format Assistant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.FormatAssistant#getId <em>Id</em>}</li>
 *   <li>{@link semanticmanager.FormatAssistant#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.FormatAssistant#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link semanticmanager.FormatAssistant#getInterpreter <em>Interpreter</em>}</li>
 *   <li>{@link semanticmanager.FormatAssistant#getConstraintInterpreter <em>Constraint Interpreter</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getFormatAssistant()
 * @model abstract="true"
 * @extends PersistentEObject
 * @generated
 */
public interface FormatAssistant extends PersistentEObject {
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
	 * @see semanticmanager.SemanticmanagerPackage#getFormatAssistant_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link semanticmanager.FormatAssistant#getId <em>Id</em>}' attribute.
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
	 * @see semanticmanager.SemanticmanagerPackage#getFormatAssistant_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link semanticmanager.FormatAssistant#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' attribute list.
	 * @see semanticmanager.SemanticmanagerPackage#getFormatAssistant_Extensions()
	 * @model
	 * @generated
	 */
	EList<String> getExtensions();

	/**
	 * Returns the value of the '<em><b>Interpreter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpreter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpreter</em>' attribute.
	 * @see #setInterpreter(String)
	 * @see semanticmanager.SemanticmanagerPackage#getFormatAssistant_Interpreter()
	 * @model
	 * @generated
	 */
	String getInterpreter();

	/**
	 * Sets the value of the '{@link semanticmanager.FormatAssistant#getInterpreter <em>Interpreter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpreter</em>' attribute.
	 * @see #getInterpreter()
	 * @generated
	 */
	void setInterpreter(String value);

	/**
	 * Returns the value of the '<em><b>Constraint Interpreter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Interpreter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Interpreter</em>' reference.
	 * @see #setConstraintInterpreter(ConstraintInterpreter)
	 * @see semanticmanager.SemanticmanagerPackage#getFormatAssistant_ConstraintInterpreter()
	 * @model
	 * @generated
	 */
	ConstraintInterpreter getConstraintInterpreter();

	/**
	 * Sets the value of the '{@link semanticmanager.FormatAssistant#getConstraintInterpreter <em>Constraint Interpreter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Interpreter</em>' reference.
	 * @see #getConstraintInterpreter()
	 * @generated
	 */
	void setConstraintInterpreter(ConstraintInterpreter value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean loadAndValidate(Resource resource, ConstraintInterpreter constraintInterpreter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void toDataProperty(SemanticNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void toObjectProperty(SemanticNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void toSuper(SemanticNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void toSuper(DataProperty dataProperty);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void toSuper(ObjectProperty objectProperty);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void toInverseOf(ObjectProperty objectProperty);

} // FormatAssistant
