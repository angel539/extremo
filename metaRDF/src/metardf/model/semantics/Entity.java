/**
 */
package metardf.model.semantics;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metardf.model.semantics.Entity#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see metardf.model.semantics.SemanticsPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends Descriptor {

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list.
	 * The list contents are of type {@link metardf.model.semantics.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see metardf.model.semantics.SemanticsPackage#getEntity_Properties()
	 * @model
	 * @generated
	 */
	EList<Property> getProperties();
} // Entity
