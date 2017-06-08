/**
 */
package semanticmanager.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.AtomicSearchResult;
import semanticmanager.NamedElement;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Search Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.AtomicSearchResultImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link semanticmanager.impl.AtomicSearchResultImpl#getDescriptor <em>Descriptor</em>}</li>
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getDescriptor() {
		return (NamedElement)eGet(SemanticmanagerPackage.Literals.ATOMIC_SEARCH_RESULT__DESCRIPTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptor(NamedElement newDescriptor) {
		eSet(SemanticmanagerPackage.Literals.ATOMIC_SEARCH_RESULT__DESCRIPTOR, newDescriptor);
	}

} //AtomicSearchResultImpl
