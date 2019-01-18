/**
 */
package semanticmanager;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Search Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.SimpleSearchConfiguration#getOptions <em>Options</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getSimpleSearchConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface SimpleSearchConfiguration extends SearchConfiguration {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.SearchParam}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSimpleSearchConfiguration_Options()
	 * @model containment="true"
	 * @generated
	 */
	EList<SearchParam> getOptions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addPrimitiveTypeSearchOption(String id, String name, Type type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addDataModelTypeSearchOption(String id, String name, DataModelType type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inputsMany="true"
	 * @generated
	 */
	void init(EList<SearchParamValue> inputs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="semanticmanager.JavaObject" inputsMany="true"
	 * @generated
	 */
	Object getParamValue(String key, EList<SearchParamValue> inputs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inputsMany="true"
	 * @generated
	 */
	Service getServiceForParamValue(String key, EList<SearchParamValue> inputs);

} // SimpleSearchConfiguration
