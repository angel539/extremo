/**
 */
package semanticmanager.queries.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.dataModel.Type;

import semanticmanager.queries.DataModelType;
import semanticmanager.queries.QueriesPackage;
import semanticmanager.queries.SearchOption;
import semanticmanager.queries.SimpleSearchConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.impl.SimpleSearchConfigurationImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link semanticmanager.queries.impl.SimpleSearchConfigurationImpl#getFilterBy <em>Filter By</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SimpleSearchConfigurationImpl extends SearchConfigurationImpl implements SimpleSearchConfiguration {
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
		return QueriesPackage.Literals.SIMPLE_SEARCH_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SearchOption> getOptions() {
		return (EList<SearchOption>)eGet(QueriesPackage.Literals.SIMPLE_SEARCH_CONFIGURATION__OPTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataModelType getFilterBy() {
		return (DataModelType)eGet(QueriesPackage.Literals.SIMPLE_SEARCH_CONFIGURATION__FILTER_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterBy(DataModelType newFilterBy) {
		eSet(QueriesPackage.Literals.SIMPLE_SEARCH_CONFIGURATION__FILTER_BY, newFilterBy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addSearchOption(String id, String name, Type type) {
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
			case QueriesPackage.SIMPLE_SEARCH_CONFIGURATION___ADD_SEARCH_OPTION__STRING_STRING_TYPE:
				addSearchOption((String)arguments.get(0), (String)arguments.get(1), (Type)arguments.get(2));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //SimpleSearchConfigurationImpl
