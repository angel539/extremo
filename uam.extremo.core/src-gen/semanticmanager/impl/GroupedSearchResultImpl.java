/**
 */
package semanticmanager.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import semanticmanager.GroupedSearchResult;
import semanticmanager.NamedElement;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grouped Search Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.GroupedSearchResultImpl#getGroups <em>Groups</em>}</li>
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
	 * @generated NOT
	 */
	public final SemanticGroup createSemanticGroup(String name, String description) {
		SemanticGroup semanticGroup = SemanticmanagerFactory.eINSTANCE.createSemanticGroup();
		semanticGroup.setName(name);
		semanticGroup.setDescription(description);
	    return semanticGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public final void addNamedElementToSemanticGroup(SemanticGroup semanticGroup, NamedElement namedElement) {
		semanticGroup.getElements().add(namedElement);
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
			case SemanticmanagerPackage.GROUPED_SEARCH_RESULT___ADD_NAMED_ELEMENT_TO_SEMANTIC_GROUP__SEMANTICGROUP_NAMEDELEMENT:
				addNamedElementToSemanticGroup((SemanticGroup)arguments.get(0), (NamedElement)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //GroupedSearchResultImpl
