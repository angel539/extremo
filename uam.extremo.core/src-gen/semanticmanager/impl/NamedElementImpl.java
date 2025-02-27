/**
 */
package semanticmanager.impl;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import semanticmanager.Constraint;
import semanticmanager.MetaData;
import semanticmanager.NamedElement;
import semanticmanager.SemanticmanagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#isDrawn <em>Drawn</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getDescribes <em>Describes</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getMetadata <em>Metadata</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getSupers <em>Supers</em>}</li>
 *   <li>{@link semanticmanager.impl.NamedElementImpl#getSubs <em>Subs</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NamedElementImpl extends DefaultPersistentEObject implements NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.NAMED_ELEMENT;
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
	public String getName() {
		return (String)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWeight() {
		return (Integer)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__WEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(int newWeight) {
		eSet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__WEIGHT, newWeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTrace() {
		return (Object)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__TRACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrace(Object newTrace) {
		eSet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__TRACE, newTrace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDrawn() {
		return (Boolean)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__DRAWN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrawn(boolean newDrawn) {
		eSet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__DRAWN, newDrawn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getDescriptors() {
		return (EList<NamedElement>)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__DESCRIPTORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getDescribes() {
		return (EList<NamedElement>)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__DESCRIBES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Constraint> getConstraints() {
		return (EList<Constraint>)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__CONSTRAINTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<MetaData> getMetadata() {
		return (EList<MetaData>)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__METADATA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getSupers() {
		return (EList<NamedElement>)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__SUPERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NamedElement> getSubs() {
		return (EList<NamedElement>)eGet(SemanticmanagerPackage.Literals.NAMED_ELEMENT__SUBS, true);
	}

} //NamedElementImpl
