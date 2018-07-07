/**
 */
package uam.extremo.core.impl;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;
import uam.extremo.core.NamedElement;
import uam.extremo.core.SearchConfiguration;
import uam.extremo.core.SearchParamValue;
import uam.extremo.core.SearchResult;
import uam.extremo.core.SemanticmanagerPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.SearchResultImpl#getValues <em>Values</em>}</li>
 *   <li>{@link uam.extremo.core.impl.SearchResultImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link uam.extremo.core.impl.SearchResultImpl#getApplyOnElements <em>Apply On Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SearchResultImpl extends DefaultPersistentEObject implements SearchResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.SEARCH_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SearchParamValue> getValues() {
		return (EList<SearchParamValue>)eGet(SemanticmanagerPackage.Literals.SEARCH_RESULT__VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchConfiguration getConfiguration() {
		return (SearchConfiguration)eGet(SemanticmanagerPackage.Literals.SEARCH_RESULT__CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(SearchConfiguration newConfiguration) {
		eSet(SemanticmanagerPackage.Literals.SEARCH_RESULT__CONFIGURATION, newConfiguration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getApplyOnElements() {
		return (EList<NamedElement>)eGet(SemanticmanagerPackage.Literals.SEARCH_RESULT__APPLY_ON_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOptionValue(String key) {
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
			case SemanticmanagerPackage.SEARCH_RESULT___GET_OPTION_VALUE__STRING:
				return getOptionValue((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //SearchResultImpl
