/**
 */
package uam.extremo.core.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import uam.extremo.core.DataProperty;
import uam.extremo.core.GroupedSearchResult;
import uam.extremo.core.NamedElement;
import uam.extremo.core.ObjectProperty;
import uam.extremo.core.Resource;
import uam.extremo.core.SemanticGroup;
import uam.extremo.core.SemanticNode;
import uam.extremo.core.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grouped Search Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.GroupedSearchResultImpl#getGroups <em>Groups</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupedSearchResultImpl extends SearchResultImpl implements GroupedSearchResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupedSearchResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.GROUPED_SEARCH_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SemanticGroup> getGroups() {
		return (EList<SemanticGroup>)eGet(SemanticmanagerPackage.Literals.GROUPED_SEARCH_RESULT__GROUPS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticGroup createSemanticGroup(String name, String description) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addSemanticNodeToSemanticGroup(SemanticGroup semanticGroup, SemanticNode semanticNode) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addDataPropertyToSemanticGroup(SemanticGroup semanticGroup, DataProperty dataProperty) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addObjectPropertyToSemanticGroup(SemanticGroup semanticGroup, ObjectProperty objectProperty) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addNamedElementToSemanticGroup(SemanticGroup semanticGroup, NamedElement namedElement) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addResourceToSemanticGroup(SemanticGroup semanticGroup, Resource resource) {
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
			case SemanticmanagerPackage.GROUPED_SEARCH_RESULT___CREATE_SEMANTIC_GROUP__STRING_STRING:
				return createSemanticGroup((String)arguments.get(0), (String)arguments.get(1));
			case SemanticmanagerPackage.GROUPED_SEARCH_RESULT___ADD_SEMANTIC_NODE_TO_SEMANTIC_GROUP__SEMANTICGROUP_SEMANTICNODE:
				addSemanticNodeToSemanticGroup((SemanticGroup)arguments.get(0), (SemanticNode)arguments.get(1));
				return null;
			case SemanticmanagerPackage.GROUPED_SEARCH_RESULT___ADD_DATA_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_DATAPROPERTY:
				addDataPropertyToSemanticGroup((SemanticGroup)arguments.get(0), (DataProperty)arguments.get(1));
				return null;
			case SemanticmanagerPackage.GROUPED_SEARCH_RESULT___ADD_OBJECT_PROPERTY_TO_SEMANTIC_GROUP__SEMANTICGROUP_OBJECTPROPERTY:
				addObjectPropertyToSemanticGroup((SemanticGroup)arguments.get(0), (ObjectProperty)arguments.get(1));
				return null;
			case SemanticmanagerPackage.GROUPED_SEARCH_RESULT___ADD_NAMED_ELEMENT_TO_SEMANTIC_GROUP__SEMANTICGROUP_NAMEDELEMENT:
				addNamedElementToSemanticGroup((SemanticGroup)arguments.get(0), (NamedElement)arguments.get(1));
				return null;
			case SemanticmanagerPackage.GROUPED_SEARCH_RESULT___ADD_RESOURCE_TO_SEMANTIC_GROUP__SEMANTICGROUP_RESOURCE:
				addResourceToSemanticGroup((SemanticGroup)arguments.get(0), (Resource)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //GroupedSearchResultImpl
