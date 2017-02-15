/**
 */
package semanticmanager.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import semanticmanager.SearchOption;
import semanticmanager.SearchResult;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.SimpleSearchConfiguration;
import semanticmanager.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.SimpleSearchConfigurationImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link semanticmanager.impl.SimpleSearchConfigurationImpl#getResults <em>Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SimpleSearchConfigurationImpl extends SearchConfigurationImpl implements SimpleSearchConfiguration {
	/**
	 * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<SearchOption> options;

	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<SearchResult> results;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleSearchConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.SIMPLE_SEARCH_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SearchOption> getOptions() {
		if (options == null) {
			options = new EObjectContainmentEList<SearchOption>(SearchOption.class, this, SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__OPTIONS);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SearchResult> getResults() {
		if (results == null) {
			results = new EObjectContainmentWithInverseEList<SearchResult>(SearchResult.class, this, SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__RESULTS, SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addSearchOption(String id, String name, Type type) {
		SearchOption searchOption = SemanticmanagerFactory.eINSTANCE.createSearchOption();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		getOptions().add(searchOption);
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__RESULTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResults()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__OPTIONS:
				return ((InternalEList<?>)getOptions()).basicRemove(otherEnd, msgs);
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__OPTIONS:
				return getOptions();
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__RESULTS:
				return getResults();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends SearchOption>)newValue);
				return;
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends SearchResult>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__OPTIONS:
				getOptions().clear();
				return;
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__RESULTS:
				getResults().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__OPTIONS:
				return options != null && !options.isEmpty();
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION__RESULTS:
				return results != null && !results.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION___ADD_SEARCH_OPTION__STRING_STRING_TYPE:
				addSearchOption((String)arguments.get(0), (String)arguments.get(1), (Type)arguments.get(2));
				return null;
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION___SEARCH__SEARCHRESULT:
				search((SearchResult)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //SimpleSearchConfigurationImpl
