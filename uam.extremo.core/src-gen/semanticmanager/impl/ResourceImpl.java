/**
 */
package semanticmanager.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.ConstraintInterpreter;
import semanticmanager.Repository;
import semanticmanager.Resource;
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
 *   <li>{@link semanticmanager.impl.ResourceImpl#isActive <em>Active</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#isAlive <em>Alive</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getAssistant <em>Assistant</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getRepositoryFrom <em>Repository From</em>}</li>
 *   <li>{@link semanticmanager.impl.ResourceImpl#getDefaultConstraintInterpreter <em>Default Constraint Interpreter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceImpl extends NamedElementImpl implements Resource {
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
	public boolean isActive() {
		return (Boolean)eGet(SemanticmanagerPackage.Literals.RESOURCE__ACTIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		eSet(SemanticmanagerPackage.Literals.RESOURCE__ACTIVE, newActive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAlive() {
		return (Boolean)eGet(SemanticmanagerPackage.Literals.RESOURCE__ALIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlive(boolean newAlive) {
		eSet(SemanticmanagerPackage.Literals.RESOURCE__ALIVE, newAlive);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAssistant() {
		return (String)eGet(SemanticmanagerPackage.Literals.RESOURCE__ASSISTANT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssistant(String newAssistant) {
		eSet(SemanticmanagerPackage.Literals.RESOURCE__ASSISTANT, newAssistant);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<SemanticNode> getNodes() {
		return (EList<SemanticNode>)eGet(SemanticmanagerPackage.Literals.RESOURCE__NODES, true);
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

} //ResourceImpl
