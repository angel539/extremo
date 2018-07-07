/**
 */
package uam.extremo.core.impl;

import org.eclipse.emf.ecore.EClass;

import uam.extremo.core.Resource;
import uam.extremo.core.ResourceElement;
import uam.extremo.core.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.ResourceElementImpl#getResourceFrom <em>Resource From</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ResourceElementImpl extends NamedElementImpl implements ResourceElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.RESOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getResourceFrom() {
		return (Resource)eGet(SemanticmanagerPackage.Literals.RESOURCE_ELEMENT__RESOURCE_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceFrom(Resource newResourceFrom) {
		eSet(SemanticmanagerPackage.Literals.RESOURCE_ELEMENT__RESOURCE_FROM, newResourceFrom);
	}

} //ResourceElementImpl
