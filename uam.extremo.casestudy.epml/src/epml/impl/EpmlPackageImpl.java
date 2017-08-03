/**
 */
package epml.impl;

import epml.Agent;
import epml.Application;
import epml.CommunicationCable;
import epml.DCEngine;
import epml.EpmlFactory;
import epml.EpmlPackage;
import epml.Fieldbus;
import epml.InductiveProximitySwitch;
import epml.InputPort;
import epml.NamedElement;
import epml.OutputPort;
import epml.PCBasedControls;
import epml.Place;
import epml.Port;
import epml.ReadyMadeDataCable;
import epml.RectangularConnectorSet;

import epml.util.EpmlValidator;

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage;

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.impl.Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EpmlPackageImpl extends EPackageImpl implements EpmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass agentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcBasedControlsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldbusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rectangularConnectorSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inductiveProximitySwitchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationCableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readyMadeDataCableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dcEngineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

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
	 * @see epml.EpmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EpmlPackageImpl() {
		super(eNS_URI, EpmlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EpmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EpmlPackage init() {
		if (isInited) return (EpmlPackage)EPackage.Registry.INSTANCE.getEPackage(EpmlPackage.eNS_URI);

		// Obtain or create and register package
		EpmlPackageImpl theEpmlPackage = (EpmlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EpmlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EpmlPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage = (Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI) instanceof Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI) : Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eINSTANCE);

		// Load packages
		theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.loadPackage();

		// Create package meta-data objects
		theEpmlPackage.createPackageContents();

		// Initialize created meta-data
		theEpmlPackage.initializePackageContents();

		// Fix loaded packages
		theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.fixPackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theEpmlPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return EpmlValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theEpmlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EpmlPackage.eNS_URI, theEpmlPackage);
		return theEpmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplication() {
		return applicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplication_OwnedAgents() {
		return (EReference)applicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplication_OwnedPlaces() {
		return (EReference)applicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAgent() {
		return agentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgent_OwnedPorts() {
		return (EReference)agentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgent_Owner() {
		return (EReference)agentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_Owner() {
		return (EReference)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputPort() {
		return inputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputPort() {
		return outputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlace() {
		return placeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlace_ItsOutputPort() {
		return (EReference)placeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlace_ItsInputPort() {
		return (EReference)placeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlace_Owner() {
		return (EReference)placeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCBasedControls() {
		return pcBasedControlsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFieldbus() {
		return fieldbusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRectangularConnectorSet() {
		return rectangularConnectorSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInductiveProximitySwitch() {
		return inductiveProximitySwitchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationCable() {
		return communicationCableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadyMadeDataCable() {
		return readyMadeDataCableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDCEngine() {
		return dcEngineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_OwnedApplication() {
		return (EReference)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpmlFactory getEpmlFactory() {
		return (EpmlFactory)getEFactoryInstance();
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

		// Create classes and their features
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		applicationEClass = createEClass(APPLICATION);
		createEReference(applicationEClass, APPLICATION__OWNED_AGENTS);
		createEReference(applicationEClass, APPLICATION__OWNED_PLACES);

		agentEClass = createEClass(AGENT);
		createEReference(agentEClass, AGENT__OWNED_PORTS);
		createEReference(agentEClass, AGENT__OWNER);

		portEClass = createEClass(PORT);
		createEReference(portEClass, PORT__OWNER);

		inputPortEClass = createEClass(INPUT_PORT);

		outputPortEClass = createEClass(OUTPUT_PORT);

		placeEClass = createEClass(PLACE);
		createEReference(placeEClass, PLACE__ITS_OUTPUT_PORT);
		createEReference(placeEClass, PLACE__ITS_INPUT_PORT);
		createEReference(placeEClass, PLACE__OWNER);

		pcBasedControlsEClass = createEClass(PC_BASED_CONTROLS);

		fieldbusEClass = createEClass(FIELDBUS);

		rectangularConnectorSetEClass = createEClass(RECTANGULAR_CONNECTOR_SET);

		inductiveProximitySwitchEClass = createEClass(INDUCTIVE_PROXIMITY_SWITCH);

		communicationCableEClass = createEClass(COMMUNICATION_CABLE);

		readyMadeDataCableEClass = createEClass(READY_MADE_DATA_CABLE);

		dcEngineEClass = createEClass(DC_ENGINE);

		systemEClass = createEClass(SYSTEM);
		createEReference(systemEClass, SYSTEM__OWNED_APPLICATION);
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
		Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage = (Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage)EPackage.Registry.INSTANCE.getEPackage(Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		applicationEClass.getESuperTypes().add(this.getNamedElement());
		agentEClass.getESuperTypes().add(theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.getCATEGORIZATIONCLASS());
		portEClass.getESuperTypes().add(this.getNamedElement());
		inputPortEClass.getESuperTypes().add(this.getPort());
		outputPortEClass.getESuperTypes().add(this.getPort());
		placeEClass.getESuperTypes().add(theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.getCATEGORIZATIONCLASS());
		placeEClass.getESuperTypes().add(this.getNamedElement());
		pcBasedControlsEClass.getESuperTypes().add(this.getAgent());
		fieldbusEClass.getESuperTypes().add(this.getAgent());
		rectangularConnectorSetEClass.getESuperTypes().add(this.getAgent());
		inductiveProximitySwitchEClass.getESuperTypes().add(this.getAgent());
		communicationCableEClass.getESuperTypes().add(this.getPlace());
		readyMadeDataCableEClass.getESuperTypes().add(this.getPlace());
		dcEngineEClass.getESuperTypes().add(this.getAgent());
		systemEClass.getESuperTypes().add(theIsostdisois_13584_32ed_1techxmlschemaontomlSimplifiedPackage.getDICTIONARY());
		systemEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(applicationEClass, Application.class, "Application", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplication_OwnedAgents(), this.getAgent(), this.getAgent_Owner(), "ownedAgents", null, 0, -1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_OwnedPlaces(), this.getPlace(), this.getPlace_Owner(), "ownedPlaces", null, 0, -1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(agentEClass, Agent.class, "Agent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAgent_OwnedPorts(), this.getPort(), this.getPort_Owner(), "ownedPorts", null, 0, -1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgent_Owner(), this.getApplication(), this.getApplication_OwnedAgents(), "owner", null, 1, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPort_Owner(), this.getAgent(), this.getAgent_OwnedPorts(), "owner", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputPortEClass, InputPort.class, "InputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputPortEClass, OutputPort.class, "OutputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(placeEClass, Place.class, "Place", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlace_ItsOutputPort(), this.getOutputPort(), null, "itsOutputPort", null, 1, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlace_ItsInputPort(), this.getInputPort(), null, "itsInputPort", null, 1, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlace_Owner(), this.getApplication(), this.getApplication_OwnedPlaces(), "owner", null, 1, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pcBasedControlsEClass, PCBasedControls.class, "PCBasedControls", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fieldbusEClass, Fieldbus.class, "Fieldbus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rectangularConnectorSetEClass, RectangularConnectorSet.class, "RectangularConnectorSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inductiveProximitySwitchEClass, InductiveProximitySwitch.class, "InductiveProximitySwitch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(communicationCableEClass, CommunicationCable.class, "CommunicationCable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(readyMadeDataCableEClass, ReadyMadeDataCable.class, "ReadyMadeDataCable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dcEngineEClass, DCEngine.class, "DCEngine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(systemEClass, epml.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_OwnedApplication(), this.getApplication(), null, "ownedApplication", null, 1, 1, epml.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (placeEClass, 
		   source, 
		   new String[] {
			 "constraints", "matchRates"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";	
		addAnnotation
		  (placeEClass, 
		   source, 
		   new String[] {
			 "matchRates", "if byteSize > 0 then byteSize >= itsOutputPort.byteRate and byteSize >= itsInputPort.byteRate else true endif"
		   });
	}

} //EpmlPackageImpl
