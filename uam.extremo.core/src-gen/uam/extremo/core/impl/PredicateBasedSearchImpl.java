/**
 */
package uam.extremo.core.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import uam.extremo.core.NamedElement;
import uam.extremo.core.PredicateBasedSearch;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.SemanticmanagerPackage;

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
		return SemanticmanagerPackage.Literals.PREDICATE_BASED_SEARCH;
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
	public Object getOptionValueKey(String key, EList<SearchParamValue> inps) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(EList<SearchParamValue> inputs) {
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SemanticmanagerPackage.PREDICATE_BASED_SEARCH___MATCHES__NAMEDELEMENT:
				return matches((NamedElement)arguments.get(0));
			case SemanticmanagerPackage.PREDICATE_BASED_SEARCH___GET_OPTION_VALUE_KEY__STRING_ELIST:
				return getOptionValueKey((String)arguments.get(0), (EList<SearchParamValue>)arguments.get(1));
			case SemanticmanagerPackage.PREDICATE_BASED_SEARCH___INIT__ELIST:
				init((EList<SearchParamValue>)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //PredicateBasedSearchImpl