/**
 */
package semanticmanager.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import semanticmanager.DataModelType;
import semanticmanager.ModelTypeParam;
import semanticmanager.ModelTypeParamValue;
import semanticmanager.PrimitiveTypeParam;
import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.SearchParam;
import semanticmanager.SearchParamValue;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.Service;
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
	public EList<SearchParam> getOptions() {
		return (EList<SearchParam>)eGet(SemanticmanagerPackage.Literals.SIMPLE_SEARCH_CONFIGURATION__OPTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public final void addPrimitiveTypeSearchOption(String id, String name, Type type) {
		PrimitiveTypeParam searchOption = SemanticmanagerFactory.eINSTANCE.createPrimitiveTypeParam();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		getOptions().add(searchOption);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public final void addDataModelTypeSearchOption(String id, String name, DataModelType type) {
		ModelTypeParam searchOption = SemanticmanagerFactory.eINSTANCE.createModelTypeParam();
		searchOption.setId(id);
		searchOption.setName(name);
		searchOption.setType(type);
		getOptions().add(searchOption);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void init(EList<SearchParamValue> inputs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getParamValue(String key, EList<SearchParamValue> inputs) {
		for(int i = 0; i < getOptions().size(); i++){
			SearchParam searchParam = getOptions().get(i);
			
			if(searchParam.getId().compareTo(key) == 0){
				if((searchParam instanceof PrimitiveTypeParam) && (inputs.get(i) instanceof PrimitiveTypeParamValue)){
					return ((PrimitiveTypeParamValue) inputs.get(i)).getValue();
				}
				else{
					if((searchParam instanceof ModelTypeParam) && (inputs.get(i) instanceof ModelTypeParamValue)){
						return ((ModelTypeParamValue) inputs.get(i)).getValue();
					}
				}					
			}
		}
		
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Service getServiceForParamValue(String key, EList<SearchParamValue> inputs) {
		for(int i = 0; i < getOptions().size(); i++){
			SearchParam searchParam = getOptions().get(i);
			
			if(searchParam.getName().compareTo(key) == 0){
				if(inputs.get(i) instanceof PrimitiveTypeParamValue)
					return ((PrimitiveTypeParamValue) inputs.get(i)).getCalls();
				else
					return null;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION___ADD_PRIMITIVE_TYPE_SEARCH_OPTION__STRING_STRING_TYPE:
				addPrimitiveTypeSearchOption((String)arguments.get(0), (String)arguments.get(1), (Type)arguments.get(2));
				return null;
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION___ADD_DATA_MODEL_TYPE_SEARCH_OPTION__STRING_STRING_DATAMODELTYPE:
				addDataModelTypeSearchOption((String)arguments.get(0), (String)arguments.get(1), (DataModelType)arguments.get(2));
				return null;
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION___INIT__ELIST:
				init((EList<SearchParamValue>)arguments.get(0));
				return null;
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION___GET_PARAM_VALUE__STRING_ELIST:
				return getParamValue((String)arguments.get(0), (EList<SearchParamValue>)arguments.get(1));
			case SemanticmanagerPackage.SIMPLE_SEARCH_CONFIGURATION___GET_SERVICE_FOR_PARAM_VALUE__STRING_ELIST:
				return getServiceForParamValue((String)arguments.get(0), (EList<SearchParamValue>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //SimpleSearchConfigurationImpl
