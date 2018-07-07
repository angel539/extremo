/**
 */
package uam.extremo.core.impl;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;
import uam.extremo.core.MetaData;
import uam.extremo.core.SemanticmanagerPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link uam.extremo.core.impl.MetaDataImpl#getKey <em>Key</em>}</li>
 *   <li>{@link uam.extremo.core.impl.MetaDataImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaDataImpl extends DefaultPersistentEObject implements MetaData {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.META_DATA;
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
	public String getKey() {
		return (String)eGet(SemanticmanagerPackage.Literals.META_DATA__KEY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		eSet(SemanticmanagerPackage.Literals.META_DATA__KEY, newKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return (String)eGet(SemanticmanagerPackage.Literals.META_DATA__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		eSet(SemanticmanagerPackage.Literals.META_DATA__VALUE, newValue);
	}

} //MetaDataImpl
