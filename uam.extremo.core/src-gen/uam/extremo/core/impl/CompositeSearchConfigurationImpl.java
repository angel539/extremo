/**
 */
package uam.extremo.core.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import uam.extremo.core.CompositeSearchConfiguration;
import uam.extremo.core.ConnectionType;
import uam.extremo.core.SearchResult;
import uam.extremo.core.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.CompositeSearchConfigurationImpl#getType <em>Type</em>}</li>
 *   <li>{@link uam.extremo.core.impl.CompositeSearchConfigurationImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link uam.extremo.core.impl.CompositeSearchConfigurationImpl#getInputSearchResults <em>Input Search Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeSearchConfigurationImpl extends SearchConfigurationImpl implements CompositeSearchConfiguration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeSearchConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.COMPOSITE_SEARCH_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionType getType() {
		return (ConnectionType)eGet(SemanticmanagerPackage.Literals.COMPOSITE_SEARCH_CONFIGURATION__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ConnectionType newType) {
		eSet(SemanticmanagerPackage.Literals.COMPOSITE_SEARCH_CONFIGURATION__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<CompositeSearchConfiguration> getChildren() {
		return (EList<CompositeSearchConfiguration>)eGet(SemanticmanagerPackage.Literals.COMPOSITE_SEARCH_CONFIGURATION__CHILDREN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SearchResult> getInputSearchResults() {
		return (EList<SearchResult>)eGet(SemanticmanagerPackage.Literals.COMPOSITE_SEARCH_CONFIGURATION__INPUT_SEARCH_RESULTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void search(SearchResult result) {
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
			case SemanticmanagerPackage.COMPOSITE_SEARCH_CONFIGURATION___SEARCH__SEARCHRESULT:
				search((SearchResult)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //CompositeSearchConfigurationImpl
