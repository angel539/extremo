/**
 */
package semanticmanager.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.DataModelType;
import semanticmanager.SearchOption;
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
 *   <li>{@link semanticmanager.impl.SimpleSearchConfigurationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link semanticmanager.impl.SimpleSearchConfigurationImpl#getFilterBy <em>Filter By</em>}</li>
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
		return SemanticmanagerPackage.Literals.SIMPLE_SEARCH_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SearchOption> getOptions() {
		return (EList<SearchOption>)eGet(SemanticmanagerPackage.Literals.SIMPLE_SEARCH_CONFIGURATION__OPTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(SemanticmanagerPackage.Literals.SIMPLE_SEARCH_CONFIGURATION__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(SemanticmanagerPackage.Literals.SIMPLE_SEARCH_CONFIGURATION__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataModelType getFilterBy() {
		return (DataModelType)eGet(SemanticmanagerPackage.Literals.SIMPLE_SEARCH_CONFIGURATION__FILTER_BY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterBy(DataModelType newFilterBy) {
		eSet(SemanticmanagerPackage.Literals.SIMPLE_SEARCH_CONFIGURATION__FILTER_BY, newFilterBy);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addPrimitiveTypeSearchOption(String id, String name, Type type) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addDataModelTypeSearchOption(String id, String name, DataModelType type) {
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
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION___ADD_PRIMITIVE_TYPE_SEARCH_OPTION__STRING_STRING_TYPE:
				addPrimitiveTypeSearchOption((String)arguments.get(0), (String)arguments.get(1), (Type)arguments.get(2));
				return null;
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION___ADD_DATA_MODEL_TYPE_SEARCH_OPTION__STRING_STRING_DATAMODELTYPE:
				addDataModelTypeSearchOption((String)arguments.get(0), (String)arguments.get(1), (DataModelType)arguments.get(2));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //SimpleSearchConfigurationImpl
