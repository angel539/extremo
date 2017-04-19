/**
 */
package semanticmanager.queries.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.dataModel.NamedElement;

import semanticmanager.queries.PredicateBasedSearch;
import semanticmanager.queries.QueriesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate Based Search</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PredicateBasedSearchImpl extends SimpleSearchConfigurationImpl implements PredicateBasedSearch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateBasedSearchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QueriesPackage.Literals.PREDICATE_BASED_SEARCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean matches(NamedElement namedElement) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case QueriesPackage.PREDICATE_BASED_SEARCH___MATCHES__NAMEDELEMENT:
				return matches((NamedElement)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //PredicateBasedSearchImpl
