/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.DataModelType;
import semanticmanager.DataModelTypeSearchOption;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Model Type Search Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.DataModelTypeSearchOptionImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataModelTypeSearchOptionImpl extends SearchOptionImpl implements DataModelTypeSearchOption {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataModelTypeSearchOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.DATA_MODEL_TYPE_SEARCH_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataModelType getType() {
		return (DataModelType)eGet(SemanticmanagerPackage.Literals.DATA_MODEL_TYPE_SEARCH_OPTION__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DataModelType newType) {
		eSet(SemanticmanagerPackage.Literals.DATA_MODEL_TYPE_SEARCH_OPTION__TYPE, newType);
	}

} //DataModelTypeSearchOptionImpl
