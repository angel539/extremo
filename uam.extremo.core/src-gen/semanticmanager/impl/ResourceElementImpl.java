/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.ResourceElementImpl#getResourceFrom <em>Resource From</em>}</li>
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
