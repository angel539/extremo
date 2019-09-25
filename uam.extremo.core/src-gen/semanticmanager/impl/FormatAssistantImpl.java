/**
 */
package semanticmanager.impl;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.ConstraintInterpreter;
import semanticmanager.DataProperty;
import semanticmanager.FormatAssistant;
import semanticmanager.ObjectProperty;
import semanticmanager.Resource;
import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Format Assistant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.FormatAssistantImpl#getId <em>Id</em>}</li>
 *   <li>{@link semanticmanager.impl.FormatAssistantImpl#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.impl.FormatAssistantImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link semanticmanager.impl.FormatAssistantImpl#getInterpreter <em>Interpreter</em>}</li>
 *   <li>{@link semanticmanager.impl.FormatAssistantImpl#getConstraintInterpreter <em>Constraint Interpreter</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FormatAssistantImpl extends DefaultPersistentEObject implements FormatAssistant {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormatAssistantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.FORMAT_ASSISTANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return (String)eGet(SemanticmanagerPackage.Literals.FORMAT_ASSISTANT__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eSet(SemanticmanagerPackage.Literals.FORMAT_ASSISTANT__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(SemanticmanagerPackage.Literals.FORMAT_ASSISTANT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SemanticmanagerPackage.Literals.FORMAT_ASSISTANT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getExtensions() {
		return (EList<String>)eGet(SemanticmanagerPackage.Literals.FORMAT_ASSISTANT__EXTENSIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterpreter() {
		return (String)eGet(SemanticmanagerPackage.Literals.FORMAT_ASSISTANT__INTERPRETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpreter(String newInterpreter) {
		eSet(SemanticmanagerPackage.Literals.FORMAT_ASSISTANT__INTERPRETER, newInterpreter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintInterpreter getConstraintInterpreter() {
		return (ConstraintInterpreter)eGet(SemanticmanagerPackage.Literals.FORMAT_ASSISTANT__CONSTRAINT_INTERPRETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintInterpreter(ConstraintInterpreter newConstraintInterpreter) {
		eSet(SemanticmanagerPackage.Literals.FORMAT_ASSISTANT__CONSTRAINT_INTERPRETER, newConstraintInterpreter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract boolean loadAndValidate(Resource resource, ConstraintInterpreter constraintInterpreter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void toDataProperty(SemanticNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void toObjectProperty(SemanticNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void toSuper(SemanticNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void toSuper(DataProperty dataProperty);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void toSuper(ObjectProperty objectProperty);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void toInverseOf(ObjectProperty objectProperty);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SemanticmanagerPackage.FORMAT_ASSISTANT___LOAD_AND_VALIDATE__RESOURCE_CONSTRAINTINTERPRETER:
				return loadAndValidate((Resource)arguments.get(0), (ConstraintInterpreter)arguments.get(1));
			case SemanticmanagerPackage.FORMAT_ASSISTANT___TO_DATA_PROPERTY__SEMANTICNODE:
				toDataProperty((SemanticNode)arguments.get(0));
				return null;
			case SemanticmanagerPackage.FORMAT_ASSISTANT___TO_OBJECT_PROPERTY__SEMANTICNODE:
				toObjectProperty((SemanticNode)arguments.get(0));
				return null;
			case SemanticmanagerPackage.FORMAT_ASSISTANT___TO_SUPER__SEMANTICNODE:
				toSuper((SemanticNode)arguments.get(0));
				return null;
			case SemanticmanagerPackage.FORMAT_ASSISTANT___TO_SUPER__DATAPROPERTY:
				toSuper((DataProperty)arguments.get(0));
				return null;
			case SemanticmanagerPackage.FORMAT_ASSISTANT___TO_SUPER__OBJECTPROPERTY:
				toSuper((ObjectProperty)arguments.get(0));
				return null;
			case SemanticmanagerPackage.FORMAT_ASSISTANT___TO_INVERSE_OF__OBJECTPROPERTY:
				toInverseOf((ObjectProperty)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //FormatAssistantImpl
