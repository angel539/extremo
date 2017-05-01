/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.NamedElement#getDescription <em>Description</em>}</li>
 *   <li>{@link semanticmanager.NamedElement#getWeight <em>Weight</em>}</li>
 *   <li>{@link semanticmanager.NamedElement#getTrace <em>Trace</em>}</li>
 *   <li>{@link semanticmanager.NamedElement#isDrawn <em>Drawn</em>}</li>
 *   <li>{@link semanticmanager.NamedElement#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link semanticmanager.NamedElement#getDescribes <em>Describes</em>}</li>
 *   <li>{@link semanticmanager.NamedElement#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends EObject {
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
	 * @see semanticmanager.SemanticmanagerPackage#getNamedElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link semanticmanager.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see semanticmanager.SemanticmanagerPackage#getNamedElement_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link semanticmanager.NamedElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(int)
	 * @see semanticmanager.SemanticmanagerPackage#getNamedElement_Weight()
	 * @model
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link semanticmanager.NamedElement#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(int value);

	/**
	 * Returns the value of the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' attribute.
	 * @see #setTrace(Object)
	 * @see semanticmanager.SemanticmanagerPackage#getNamedElement_Trace()
	 * @model dataType="semanticmanager.JavaObject"
	 * @generated
	 */
	Object getTrace();

	/**
	 * Sets the value of the '{@link semanticmanager.NamedElement#getTrace <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' attribute.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(Object value);

	/**
	 * Returns the value of the '<em><b>Drawn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drawn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drawn</em>' attribute.
	 * @see #setDrawn(boolean)
	 * @see semanticmanager.SemanticmanagerPackage#getNamedElement_Drawn()
	 * @model
	 * @generated
	 */
	boolean isDrawn();

	/**
	 * Sets the value of the '{@link semanticmanager.NamedElement#isDrawn <em>Drawn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drawn</em>' attribute.
	 * @see #isDrawn()
	 * @generated
	 */
	void setDrawn(boolean value);

	/**
	 * Returns the value of the '<em><b>Descriptor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.NamedElement#getDescribes <em>Describes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor</em>' reference.
	 * @see #setDescriptor(NamedElement)
	 * @see semanticmanager.SemanticmanagerPackage#getNamedElement_Descriptor()
	 * @see semanticmanager.NamedElement#getDescribes
	 * @model opposite="describes"
	 * @generated
	 */
	NamedElement getDescriptor();

	/**
	 * Sets the value of the '{@link semanticmanager.NamedElement#getDescriptor <em>Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor</em>' reference.
	 * @see #getDescriptor()
	 * @generated
	 */
	void setDescriptor(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Describes</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.NamedElement}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.NamedElement#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Describes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Describes</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getNamedElement_Describes()
	 * @see semanticmanager.NamedElement#getDescriptor
	 * @model opposite="descriptor"
	 * @generated
	 */
	EList<NamedElement> getDescribes();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.Constraint}.
	 * It is bidirectional and its opposite is '{@link semanticmanager.Constraint#getAppliedTo <em>Applied To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getNamedElement_Constraints()
	 * @see semanticmanager.Constraint#getAppliedTo
	 * @model opposite="appliedTo" containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

} // NamedElement
