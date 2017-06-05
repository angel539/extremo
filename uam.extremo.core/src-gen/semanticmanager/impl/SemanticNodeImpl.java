/**
 */
package semanticmanager.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.Property;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.SemanticNodeImpl#getSupers <em>Supers</em>}</li>
 *   <li>{@link semanticmanager.impl.SemanticNodeImpl#getSubs <em>Subs</em>}</li>
 *   <li>{@link semanticmanager.impl.SemanticNodeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link semanticmanager.impl.SemanticNodeImpl#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticNodeImpl extends ResourceElementImpl implements SemanticNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.SEMANTIC_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SemanticNode> getSupers() {
		return (EList<SemanticNode>)eGet(SemanticmanagerPackage.Literals.SEMANTIC_NODE__SUPERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SemanticNode> getSubs() {
		return (EList<SemanticNode>)eGet(SemanticmanagerPackage.Literals.SEMANTIC_NODE__SUBS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Property> getProperties() {
		return (EList<Property>)eGet(SemanticmanagerPackage.Literals.SEMANTIC_NODE__PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return (Boolean)eGet(SemanticmanagerPackage.Literals.SEMANTIC_NODE__ABSTRACT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		eSet(SemanticmanagerPackage.Literals.SEMANTIC_NODE__ABSTRACT, newAbstract);
	}

} //SemanticNodeImpl
