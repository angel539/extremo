/**
 */
package semanticmanager.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.CustomSearch;
import semanticmanager.Repository;
import semanticmanager.SearchResult;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Search</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.CustomSearchImpl#isGrouped <em>Grouped</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CustomSearchImpl extends SimpleSearchConfigurationImpl implements CustomSearch {
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
		return SemanticmanagerPackage.Literals.CUSTOM_SEARCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGrouped() {
		return (Boolean)eGet(SemanticmanagerPackage.Literals.CUSTOM_SEARCH__GROUPED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrouped(boolean newGrouped) {
		eSet(SemanticmanagerPackage.Literals.CUSTOM_SEARCH__GROUPED, newGrouped);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void search(Repository repository, SearchResult result);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SemanticmanagerPackage.CUSTOM_SEARCH___SEARCH__REPOSITORY_SEARCHRESULT:
				search((Repository)arguments.get(0), (SearchResult)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //CustomSearchImpl
