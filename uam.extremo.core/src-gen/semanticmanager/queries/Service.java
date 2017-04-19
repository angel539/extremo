/**
 */
package semanticmanager.queries;

import org.eclipse.emf.ecore.EObject;

import semanticmanager.dataModel.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.Service#getId <em>Id</em>}</li>
 *   <li>{@link semanticmanager.queries.Service#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.queries.Service#getFilterBy <em>Filter By</em>}</li>
 * </ul>
 *
 * @see semanticmanager.queries.QueriesPackage#getService()
 * @model abstract="true"
 * @generated
 */
public interface Service extends EObject {
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
	 * @see semanticmanager.queries.QueriesPackage#getService_Id()
	 * @model id="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link semanticmanager.queries.Service#getId <em>Id</em>}' attribute.
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
	 * @see semanticmanager.queries.QueriesPackage#getService_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link semanticmanager.queries.Service#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Filter By</b></em>' attribute.
	 * The literals are from the enumeration {@link semanticmanager.dataModel.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter By</em>' attribute.
	 * @see semanticmanager.dataModel.Type
	 * @see #setFilterBy(Type)
	 * @see semanticmanager.queries.QueriesPackage#getService_FilterBy()
	 * @model
	 * @generated
	 */
	Type getFilterBy();

	/**
	 * Sets the value of the '{@link semanticmanager.queries.Service#getFilterBy <em>Filter By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter By</em>' attribute.
	 * @see semanticmanager.dataModel.Type
	 * @see #getFilterBy()
	 * @generated
	 */
	void setFilterBy(Type value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model expressionRequired="true" valueRequired="true"
	 * @generated
	 */
	boolean matches(String expression, String value);

} // Service
