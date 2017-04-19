/**
 */
package semanticmanager.queries.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.dataModel.NamedElement;

import semanticmanager.queries.AtomicSearchResult;
import semanticmanager.queries.QueriesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Search Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.impl.AtomicSearchResultImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AtomicSearchResultImpl extends SearchResultImpl implements AtomicSearchResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomicSearchResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QueriesPackage.Literals.ATOMIC_SEARCH_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getElements() {
		return (EList<NamedElement>)eGet(QueriesPackage.Literals.ATOMIC_SEARCH_RESULT__ELEMENTS, true);
	}

} //AtomicSearchResultImpl
