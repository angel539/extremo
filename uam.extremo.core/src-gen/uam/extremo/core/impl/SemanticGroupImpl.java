/**
 */
package uam.extremo.core.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import uam.extremo.core.NamedElement;
import uam.extremo.core.SemanticGroup;
import uam.extremo.core.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.SemanticGroupImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticGroupImpl extends NamedElementImpl implements SemanticGroup {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.SEMANTIC_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getElements() {
		return (EList<NamedElement>)eGet(SemanticmanagerPackage.Literals.SEMANTIC_GROUP__ELEMENTS, true);
	}

} //SemanticGroupImpl
