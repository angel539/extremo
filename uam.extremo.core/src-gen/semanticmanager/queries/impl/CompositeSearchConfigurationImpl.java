/**
 */
package semanticmanager.queries.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.queries.CompositeSearchConfiguration;
import semanticmanager.queries.ConnectionType;
import semanticmanager.queries.QueriesPackage;
import semanticmanager.queries.SearchConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.queries.impl.CompositeSearchConfigurationImpl#getQueries <em>Queries</em>}</li>
 *   <li>{@link semanticmanager.queries.impl.CompositeSearchConfigurationImpl#getType <em>Type</em>}</li>
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
		return QueriesPackage.Literals.COMPOSITE_SEARCH_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SearchConfiguration> getQueries() {
		return (EList<SearchConfiguration>)eGet(QueriesPackage.Literals.COMPOSITE_SEARCH_CONFIGURATION__QUERIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionType getType() {
		return (ConnectionType)eGet(QueriesPackage.Literals.COMPOSITE_SEARCH_CONFIGURATION__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ConnectionType newType) {
		eSet(QueriesPackage.Literals.COMPOSITE_SEARCH_CONFIGURATION__TYPE, newType);
	}

} //CompositeSearchConfigurationImpl
