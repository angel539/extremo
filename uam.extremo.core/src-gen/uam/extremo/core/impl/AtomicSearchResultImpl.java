/**
 */
package uam.extremo.core.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import uam.extremo.core.AtomicSearchResult;
import uam.extremo.core.NamedElement;
import uam.extremo.core.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Search Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.AtomicSearchResultImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AtomicSearchResultImpl extends SearchResultImpl implements AtomicSearchResult {
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
		return SemanticmanagerPackage.Literals.ATOMIC_SEARCH_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getElements() {
		return (EList<NamedElement>)eGet(SemanticmanagerPackage.Literals.ATOMIC_SEARCH_RESULT__ELEMENTS, true);
	}

} //AtomicSearchResultImpl
