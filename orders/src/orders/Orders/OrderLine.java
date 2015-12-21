/**
 */
package orders.Orders;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Order Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link orders.Orders.OrderLine#getQuantity <em>Quantity</em>}</li>
 *   <li>{@link orders.Orders.OrderLine#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see orders.Orders.OrdersPackage#getOrderLine()
 * @model
 * @generated
 */
public interface OrderLine extends EObject {
	/**
	 * Returns the value of the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity</em>' attribute.
	 * @see #setQuantity(BigInteger)
	 * @see orders.Orders.OrdersPackage#getOrderLine_Quantity()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BigInteger getQuantity();

	/**
	 * Sets the value of the '{@link orders.Orders.OrderLine#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' reference.
	 * @see #setItem(Item)
	 * @see orders.Orders.OrdersPackage#getOrderLine_Item()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Item getItem();

	/**
	 * Sets the value of the '{@link orders.Orders.OrderLine#getItem <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(Item value);

} // OrderLine
