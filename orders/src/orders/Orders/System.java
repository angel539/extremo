/**
 */
package orders.Orders;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link orders.Orders.System#getOrders <em>Orders</em>}</li>
 *   <li>{@link orders.Orders.System#getStock <em>Stock</em>}</li>
 * </ul>
 * </p>
 *
 * @see orders.Orders.OrdersPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject {
	/**
	 * Returns the value of the '<em><b>Orders</b></em>' containment reference list.
	 * The list contents are of type {@link orders.Orders.PurchaseOrder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orders</em>' containment reference list.
	 * @see orders.Orders.OrdersPackage#getSystem_Orders()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PurchaseOrder> getOrders();

	/**
	 * Returns the value of the '<em><b>Stock</b></em>' containment reference list.
	 * The list contents are of type {@link orders.Orders.Item}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stock</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stock</em>' containment reference list.
	 * @see orders.Orders.OrdersPackage#getSystem_Stock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Item> getStock();

} // System
