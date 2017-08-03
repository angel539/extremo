/**
 */
package epml.impl;

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
import epml.ReadyMadeDataCable;
import epml.RectangularConnectorSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EpmlFactoryImpl extends EFactoryImpl implements EpmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EpmlFactory init() {
		try {
			EpmlFactory theEpmlFactory = (EpmlFactory)EPackage.Registry.INSTANCE.getEFactory(EpmlPackage.eNS_URI);
			if (theEpmlFactory != null) {
				return theEpmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EpmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EpmlPackage.NAMED_ELEMENT: return createNamedElement();
			case EpmlPackage.APPLICATION: return createApplication();
			case EpmlPackage.INPUT_PORT: return createInputPort();
			case EpmlPackage.OUTPUT_PORT: return createOutputPort();
			case EpmlPackage.PC_BASED_CONTROLS: return createPCBasedControls();
			case EpmlPackage.FIELDBUS: return createFieldbus();
			case EpmlPackage.RECTANGULAR_CONNECTOR_SET: return createRectangularConnectorSet();
			case EpmlPackage.INDUCTIVE_PROXIMITY_SWITCH: return createInductiveProximitySwitch();
			case EpmlPackage.COMMUNICATION_CABLE: return createCommunicationCable();
			case EpmlPackage.READY_MADE_DATA_CABLE: return createReadyMadeDataCable();
			case EpmlPackage.DC_ENGINE: return createDCEngine();
			case EpmlPackage.SYSTEM: return createSystem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application createApplication() {
		ApplicationImpl application = new ApplicationImpl();
		return application;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort createInputPort() {
		InputPortImpl inputPort = new InputPortImpl();
		return inputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort createOutputPort() {
		OutputPortImpl outputPort = new OutputPortImpl();
		return outputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCBasedControls createPCBasedControls() {
		PCBasedControlsImpl pcBasedControls = new PCBasedControlsImpl();
		return pcBasedControls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fieldbus createFieldbus() {
		FieldbusImpl fieldbus = new FieldbusImpl();
		return fieldbus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RectangularConnectorSet createRectangularConnectorSet() {
		RectangularConnectorSetImpl rectangularConnectorSet = new RectangularConnectorSetImpl();
		return rectangularConnectorSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InductiveProximitySwitch createInductiveProximitySwitch() {
		InductiveProximitySwitchImpl inductiveProximitySwitch = new InductiveProximitySwitchImpl();
		return inductiveProximitySwitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationCable createCommunicationCable() {
		CommunicationCableImpl communicationCable = new CommunicationCableImpl();
		return communicationCable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadyMadeDataCable createReadyMadeDataCable() {
		ReadyMadeDataCableImpl readyMadeDataCable = new ReadyMadeDataCableImpl();
		return readyMadeDataCable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DCEngine createDCEngine() {
		DCEngineImpl dcEngine = new DCEngineImpl();
		return dcEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public epml.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpmlPackage getEpmlPackage() {
		return (EpmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EpmlPackage getPackage() {
		return EpmlPackage.eINSTANCE;
	}

} //EpmlFactoryImpl
