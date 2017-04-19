/**
 */
package semanticmanager.queries.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.dataModel.NamedElement;

import semanticmanager.dataModel.impl.NamedElementImpl;

import semanticmanager.queries.QueriesPackage;
import semanticmanager.queries.SemanticGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.impl.SemanticGroupImpl#getElements <em>Elements</em>}</li>
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
		return QueriesPackage.Literals.SEMANTIC_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getElements() {
		return (EList<NamedElement>)eGet(QueriesPackage.Literals.SEMANTIC_GROUP__ELEMENTS, true);
	}

} //SemanticGroupImpl
