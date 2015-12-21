/**
 */
package orders.Orders;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link orders.Orders.Item#getName <em>Name</em>}</li>
 *   <li>{@link orders.Orders.Item#getStock <em>Stock</em>}</li>
 *   <li>{@link orders.Orders.Item#getPrice <em>Price</em>}</li>
 * </ul>
 * </p>
 *
 * @see orders.Orders.OrdersPackage#getItem()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='nonEmptyName positivePrice'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot nonEmptyName='stock >= 0' positivePrice='price > 0'"
 * @generated
 */
public interface Item extends EObject {
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
	 * @see orders.Orders.OrdersPackage#getItem_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link orders.Orders.Item#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Stock</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stock</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stock</em>' attribute.
	 * @see #setStock(BigInteger)
	 * @see orders.Orders.OrdersPackage#getItem_Stock()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BigInteger getStock();

	/**
	 * Sets the value of the '{@link orders.Orders.Item#getStock <em>Stock</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stock</em>' attribute.
	 * @see #getStock()
	 * @generated
	 */
	void setStock(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Price</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Price</em>' attribute.
	 * @see #setPrice(BigDecimal)
	 * @see orders.Orders.OrdersPackage#getItem_Price()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BigDecimal getPrice();

	/**
	 * Sets the value of the '{@link orders.Orders.Item#getPrice <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Price</em>' attribute.
	 * @see #getPrice()
	 * @generated
	 */
	void setPrice(BigDecimal value);

} // Item
