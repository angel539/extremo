/**
 */
package semanticmanager.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.ecore.util.InternalEList;
import semanticmanager.DataProperty;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SearchConfiguration;
import semanticmanager.SearchResult;
import semanticmanager.SearchResultOptionValue;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.SearchResultImpl#getValues <em>Values</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchResultImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchResultImpl#getResults <em>Results</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchResultImpl#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchResultImpl extends MinimalEObjectImpl.Container implements SearchResult {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<SearchResultOptionValue> values;

	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticGroup> results;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

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
	public EList<SearchResultOptionValue> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<SearchResultOptionValue>(SearchResultOptionValue.class, this, SemanticmanagerPackage.SEARCH_RESULT__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchConfiguration getConfiguration() {
		if (eContainerFeatureID() != SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION) return null;
		return (SearchConfiguration)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(SearchConfiguration newConfiguration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConfiguration, SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(SearchConfiguration newConfiguration) {
		if (newConfiguration != eInternalContainer() || (eContainerFeatureID() != SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION && newConfiguration != null)) {
			if (EcoreUtil.isAncestor(this, newConfiguration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, SemanticmanagerPackage.SEARCH_CONFIGURATION__RESULTS, SearchConfiguration.class, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticGroup> getResults() {
		if (results == null) {
			results = new EObjectContainmentEList<SemanticGroup>(SemanticGroup.class, this, SemanticmanagerPackage.SEARCH_RESULT__RESULTS);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResources() {
		if (resources == null) {
			resources = new EObjectResolvingEList<Resource>(Resource.class, this, SemanticmanagerPackage.SEARCH_RESULT__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SemanticGroup createSemanticGroup(String name, String description) {
		SemanticGroup semanticGroup = SemanticmanagerFactory.eINSTANCE.createSemanticGroup();
		semanticGroup.setName(name);
		semanticGroup.setDescription(description);
		getResults().add(semanticGroup);
		return semanticGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addSemanticNodeToSemanticGroup(SemanticGroup semanticGroup, SemanticNode semanticNode) {
		semanticGroup.getNodes().add(semanticNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addDataPropertyToSemanticGroup(SemanticGroup semanticGroup, DataProperty dataProperty) {
		semanticGroup.getNodes().add(dataProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addObjectPropertyToSemanticGroup(SemanticGroup semanticGroup, ObjectProperty objectProperty) {
		semanticGroup.getNodes().add(objectProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConfiguration((SearchConfiguration)otherEnd, msgs);
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
			case SemanticmanagerPackage.SEARCH_RESULT__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
			case SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case SemanticmanagerPackage.SEARCH_RESULT__RESULTS:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION:
				return eInternalContainer().eInverseRemove(this, SemanticmanagerPackage.SEARCH_CONFIGURATION__RESULTS, SearchConfiguration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SemanticmanagerPackage.SEARCH_RESULT__VALUES:
				return getValues();
			case SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION:
				return getConfiguration();
			case SemanticmanagerPackage.SEARCH_RESULT__RESULTS:
				return getResults();
			case SemanticmanagerPackage.SEARCH_RESULT__RESOURCES:
				return getResources();
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
			case SemanticmanagerPackage.SEARCH_RESULT__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends SearchResultOptionValue>)newValue);
				return;
			case SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION:
				setConfiguration((SearchConfiguration)newValue);
				return;
			case SemanticmanagerPackage.SEARCH_RESULT__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends SemanticGroup>)newValue);
				return;
			case SemanticmanagerPackage.SEARCH_RESULT__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends Resource>)newValue);
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
			case SemanticmanagerPackage.SEARCH_RESULT__VALUES:
				getValues().clear();
				return;
			case SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION:
				setConfiguration((SearchConfiguration)null);
				return;
			case SemanticmanagerPackage.SEARCH_RESULT__RESULTS:
				getResults().clear();
				return;
			case SemanticmanagerPackage.SEARCH_RESULT__RESOURCES:
				getResources().clear();
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
			case SemanticmanagerPackage.SEARCH_RESULT__VALUES:
				return values != null && !values.isEmpty();
			case SemanticmanagerPackage.SEARCH_RESULT__CONFIGURATION:
				return getConfiguration() != null;
			case SemanticmanagerPackage.SEARCH_RESULT__RESULTS:
				return results != null && !results.isEmpty();
			case SemanticmanagerPackage.SEARCH_RESULT__RESOURCES:
				return resources != null && !resources.isEmpty();
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
			case SemanticmanagerPackage.SEARCH_RESULT___CREATE_SEMANTIC_GROUP__STRING_STRING:
				return createSemanticGroup((String)arguments.get(0), (String)arguments.get(1));
			case SemanticmanagerPackage.SEARCH_RESULT___ADD_SEMANTIC_NODE_TO_SEMANTIC_GROUP__SEMANTICGROUP_SEMANTICNODE:
				addSemanticNodeToSemanticGroup((SemanticGroup)arguments.get(0), (SemanticNode)arguments.get(1));
				return null;
			case SemanticmanagerPackage.SEARCH_RESULT___ADD_DATA_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_DATAPROPERTY:
				addDataPropertyToSemanticGroup((SemanticGroup)arguments.get(0), (DataProperty)arguments.get(1));
				return null;
			case SemanticmanagerPackage.SEARCH_RESULT___ADD_OBJECT_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_OBJECTPROPERTY:
				addObjectPropertyToSemanticGroup((SemanticGroup)arguments.get(0), (ObjectProperty)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //SearchResultImpl
