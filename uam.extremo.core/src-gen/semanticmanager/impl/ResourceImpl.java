/**
 */
package semanticmanager.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.ConstraintInterpreter;
import semanticmanager.FormatAssistant;
import semanticmanager.Repository;
import semanticmanager.Resource;
import semanticmanager.ResourceElement;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getResourceElements <em>Resource Elements</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getRepositoryFrom <em>Repository From</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getDefaultConstraintInterpreter <em>Default Constraint Interpreter</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getAssistant <em>Assistant</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getGuardSemanticNodes <em>Guard Semantic Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceImpl extends ResourceElementImpl implements Resource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ResourceElement> getResourceElements() {
		return (EList<ResourceElement>)eGet(SemanticmanagerPackage.Literals.RESOURCE__RESOURCE_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return (String)eGet(SemanticmanagerPackage.Literals.RESOURCE__URI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		eSet(SemanticmanagerPackage.Literals.RESOURCE__URI, newUri);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepositoryFrom() {
		return (Repository)eGet(SemanticmanagerPackage.Literals.RESOURCE__REPOSITORY_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryFrom(Repository newRepositoryFrom) {
		eSet(SemanticmanagerPackage.Literals.RESOURCE__REPOSITORY_FROM, newRepositoryFrom);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintInterpreter getDefaultConstraintInterpreter() {
		return (ConstraintInterpreter)eGet(SemanticmanagerPackage.Literals.RESOURCE__DEFAULT_CONSTRAINT_INTERPRETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultConstraintInterpreter(ConstraintInterpreter newDefaultConstraintInterpreter) {
		eSet(SemanticmanagerPackage.Literals.RESOURCE__DEFAULT_CONSTRAINT_INTERPRETER, newDefaultConstraintInterpreter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormatAssistant getAssistant() {
		return (FormatAssistant)eGet(SemanticmanagerPackage.Literals.RESOURCE__ASSISTANT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssistant(FormatAssistant newAssistant) {
		eSet(SemanticmanagerPackage.Literals.RESOURCE__ASSISTANT, newAssistant);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SemanticNode> getGuardSemanticNodes() {
		return (EList<SemanticNode>)eGet(SemanticmanagerPackage.Literals.RESOURCE__GUARD_SEMANTIC_NODES, true);
	}

} //ResourceImpl
