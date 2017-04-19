/**
 */
package semanticmanager.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.constraints.ConstraintsPackage;
import semanticmanager.constraints.impl.ConstraintsPackageImpl;
import semanticmanager.dataModel.DataModelPackage;
import semanticmanager.dataModel.impl.DataModelPackageImpl;
import semanticmanager.queries.QueriesPackage;
import semanticmanager.queries.impl.QueriesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SemanticmanagerPackageImpl extends EPackageImpl implements SemanticmanagerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see semanticmanager.SemanticmanagerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SemanticmanagerPackageImpl() {
		super(eNS_URI, SemanticmanagerFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SemanticmanagerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SemanticmanagerPackage init() {
		if (isInited) return (SemanticmanagerPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticmanagerPackage.eNS_URI);

		// Obtain or create and register package
		SemanticmanagerPackageImpl theSemanticmanagerPackage = (SemanticmanagerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SemanticmanagerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SemanticmanagerPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ConstraintsPackageImpl theConstraintsPackage = (ConstraintsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI) instanceof ConstraintsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI) : ConstraintsPackage.eINSTANCE);
		QueriesPackageImpl theQueriesPackage = (QueriesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QueriesPackage.eNS_URI) instanceof QueriesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QueriesPackage.eNS_URI) : QueriesPackage.eINSTANCE);
		DataModelPackageImpl theDataModelPackage = (DataModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DataModelPackage.eNS_URI) instanceof DataModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DataModelPackage.eNS_URI) : DataModelPackage.eINSTANCE);

		// Create package meta-data objects
		theSemanticmanagerPackage.createPackageContents();
		theConstraintsPackage.createPackageContents();
		theQueriesPackage.createPackageContents();
		theDataModelPackage.createPackageContents();

		// Initialize created meta-data
		theSemanticmanagerPackage.initializePackageContents();
		theConstraintsPackage.initializePackageContents();
		theQueriesPackage.initializePackageContents();
		theDataModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSemanticmanagerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SemanticmanagerPackage.eNS_URI, theSemanticmanagerPackage);
		return theSemanticmanagerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJavaObject() {
		return javaObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticmanagerFactory getSemanticmanagerFactory() {
		return (SemanticmanagerFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create data types
		javaObjectEDataType = createEDataType(JAVA_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ConstraintsPackage theConstraintsPackage = (ConstraintsPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI);
		QueriesPackage theQueriesPackage = (QueriesPackage)EPackage.Registry.INSTANCE.getEPackage(QueriesPackage.eNS_URI);
		DataModelPackage theDataModelPackage = (DataModelPackage)EPackage.Registry.INSTANCE.getEPackage(DataModelPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theConstraintsPackage);
		getESubpackages().add(theQueriesPackage);
		getESubpackages().add(theDataModelPackage);

		// Initialize data types
		initEDataType(javaObjectEDataType, Object.class, "JavaObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SemanticmanagerPackageImpl
