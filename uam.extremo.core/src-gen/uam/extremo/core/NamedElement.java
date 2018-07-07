/**
 */
package uam.extremo.core;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link uam.extremo.core.NamedElement#getDescription <em>Description</em>}</li>
 *   <li>{@link uam.extremo.core.NamedElement#getWeight <em>Weight</em>}</li>
 *   <li>{@link uam.extremo.core.NamedElement#getTrace <em>Trace</em>}</li>
 *   <li>{@link uam.extremo.core.NamedElement#isDrawn <em>Drawn</em>}</li>
 *   <li>{@link uam.extremo.core.NamedElement#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link uam.extremo.core.NamedElement#getDescribes <em>Describes</em>}</li>
 *   <li>{@link uam.extremo.core.NamedElement#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link uam.extremo.core.NamedElement#getMetadata <em>Metadata</em>}</li>
 *   <li>{@link uam.extremo.core.NamedElement#getSupers <em>Supers</em>}</li>
 *   <li>{@link uam.extremo.core.NamedElement#getSubs <em>Subs</em>}</li>
 * </ul>
 *
 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement()
 * @model abstract="true"
 * @extends PersistentEObject
 * @generated
 */
public interface NamedElement extends PersistentEObject {
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
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link uam.extremo.core.NamedElement#getName <em>Name</em>}' attribute.
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
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link uam.extremo.core.NamedElement#getDescription <em>Description</em>}' attribute.
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
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Weight()
	 * @model
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link uam.extremo.core.NamedElement#getWeight <em>Weight</em>}' attribute.
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
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Trace()
	 * @model dataType="semanticmanager.JavaObject"
	 * @generated
	 */
	Object getTrace();

	/**
	 * Sets the value of the '{@link uam.extremo.core.NamedElement#getTrace <em>Trace</em>}' attribute.
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
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Drawn()
	 * @model
	 * @generated
	 */
	boolean isDrawn();

	/**
	 * Sets the value of the '{@link uam.extremo.core.NamedElement#isDrawn <em>Drawn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drawn</em>' attribute.
	 * @see #isDrawn()
	 * @generated
	 */
	void setDrawn(boolean value);

	/**
	 * Returns the value of the '<em><b>Descriptors</b></em>' reference list.
	 * The list contents are of type {@link uam.extremo.core.NamedElement}.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.NamedElement#getDescribes <em>Describes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors</em>' reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Descriptors()
	 * @see uam.extremo.core.NamedElement#getDescribes
	 * @model opposite="describes"
	 * @generated
	 */
	EList<NamedElement> getDescriptors();

	/**
	 * Returns the value of the '<em><b>Describes</b></em>' reference list.
	 * The list contents are of type {@link uam.extremo.core.NamedElement}.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.NamedElement#getDescriptors <em>Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Describes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Describes</em>' reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Describes()
	 * @see uam.extremo.core.NamedElement#getDescriptors
	 * @model opposite="descriptors"
	 * @generated
	 */
	EList<NamedElement> getDescribes();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.Constraint}.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.Constraint#getAppliedTo <em>Applied To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Constraints()
	 * @see uam.extremo.core.Constraint#getAppliedTo
	 * @model opposite="appliedTo" containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Metadata</b></em>' containment reference list.
	 * The list contents are of type {@link uam.extremo.core.MetaData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metadata</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metadata</em>' containment reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Metadata()
	 * @model containment="true"
	 * @generated
	 */
	EList<MetaData> getMetadata();

	/**
	 * Returns the value of the '<em><b>Supers</b></em>' reference list.
	 * The list contents are of type {@link uam.extremo.core.NamedElement}.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.NamedElement#getSubs <em>Subs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supers</em>' reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Supers()
	 * @see uam.extremo.core.NamedElement#getSubs
	 * @model opposite="subs"
	 * @generated
	 */
	EList<NamedElement> getSupers();

	/**
	 * Returns the value of the '<em><b>Subs</b></em>' reference list.
	 * The list contents are of type {@link uam.extremo.core.NamedElement}.
	 * It is bidirectional and its opposite is '{@link uam.extremo.core.NamedElement#getSupers <em>Supers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subs</em>' reference list.
	 * @see uam.extremo.core.SemanticmanagerPackage#getNamedElement_Subs()
	 * @see uam.extremo.core.NamedElement#getSupers
	 * @model opposite="supers"
	 * @generated
	 */
	EList<NamedElement> getSubs();

} // NamedElement
