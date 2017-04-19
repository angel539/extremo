/**
 */
package semanticmanager.queries.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.queries.CustomSearch;
import semanticmanager.queries.QueriesPackage;
import semanticmanager.queries.SearchResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Search</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CustomSearchImpl extends SimpleSearchConfigurationImpl implements CustomSearch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomSearchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QueriesPackage.Literals.CUSTOM_SEARCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void search(SearchResult search) {
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
			case QueriesPackage.CUSTOM_SEARCH___SEARCH__SEARCHRESULT:
				search((SearchResult)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //CustomSearchImpl
