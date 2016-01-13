/**
 */
package orders.Orders;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Purchase Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link orders.Orders.PurchaseOrder#getShipTo <em>Ship To</em>}</li>
 *   <li>{@link orders.Orders.PurchaseOrder#getBillTo <em>Bill To</em>}</li>
 *   <li>{@link orders.Orders.PurchaseOrder#getLines <em>Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @see orders.Orders.OrdersPackage#getPurchaseOrder()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='nonDuplicatedItems'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot nonDuplicatedItems='not lines->isEmpty() implies lines->forAll(l1 : OrderLine, l2 : OrderLine | l1 <> l2 implies l1.item <> l2.item)'"
 * @generated
 */
public interface PurchaseOrder extends EObject {
	/**
	 * Returns the value of the '<em><b>Ship To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ship To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ship To</em>' attribute.
	 * @see #setShipTo(String)
	 * @see orders.Orders.OrdersPackage#getPurchaseOrder_ShipTo()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getShipTo();

	/**
	 * Sets the value of the '{@link orders.Orders.PurchaseOrder#getShipTo <em>Ship To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ship To</em>' attribute.
	 * @see #getShipTo()
	 * @generated
	 */
	void setShipTo(String value);

	/**
	 * Returns the value of the '<em><b>Bill To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bill To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bill To</em>' attribute.
	 * @see #setBillTo(String)
	 * @see orders.Orders.OrdersPackage#getPurchaseOrder_BillTo()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getBillTo();

	/**
	 * Sets the value of the '{@link orders.Orders.PurchaseOrder#getBillTo <em>Bill To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bill To</em>' attribute.
	 * @see #getBillTo()
	 * @generated
	 */
	void setBillTo(String value);

	/**
	 * Returns the value of the '<em><b>Lines</b></em>' containment reference list.
	 * The list contents are of type {@link orders.Orders.OrderLine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lines</em>' containment reference list.
	 * @see orders.Orders.OrdersPackage#getPurchaseOrder_Lines()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<OrderLine> getLines();

} // PurchaseOrder
