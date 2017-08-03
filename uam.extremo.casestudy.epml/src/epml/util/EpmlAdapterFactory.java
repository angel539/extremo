/**
 */
package epml.util;

import epml.Agent;
import epml.Application;
import epml.CommunicationCable;
import epml.DCEngine;
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

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.CATEGORIZATIONCLASS;
import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.CLASS;
import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.DICTIONARY;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see epml.EpmlPackage
 * @generated
 */
public class EpmlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EpmlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpmlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EpmlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EpmlSwitch<Adapter> modelSwitch =
		new EpmlSwitch<Adapter>() {
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseApplication(Application object) {
				return createApplicationAdapter();
			}
			@Override
			public Adapter caseAgent(Agent object) {
				return createAgentAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseInputPort(InputPort object) {
				return createInputPortAdapter();
			}
			@Override
			public Adapter caseOutputPort(OutputPort object) {
				return createOutputPortAdapter();
			}
			@Override
			public Adapter casePlace(Place object) {
				return createPlaceAdapter();
			}
			@Override
			public Adapter casePCBasedControls(PCBasedControls object) {
				return createPCBasedControlsAdapter();
			}
			@Override
			public Adapter caseFieldbus(Fieldbus object) {
				return createFieldbusAdapter();
			}
			@Override
			public Adapter caseRectangularConnectorSet(RectangularConnectorSet object) {
				return createRectangularConnectorSetAdapter();
			}
			@Override
			public Adapter caseInductiveProximitySwitch(InductiveProximitySwitch object) {
				return createInductiveProximitySwitchAdapter();
			}
			@Override
			public Adapter caseCommunicationCable(CommunicationCable object) {
				return createCommunicationCableAdapter();
			}
			@Override
			public Adapter caseReadyMadeDataCable(ReadyMadeDataCable object) {
				return createReadyMadeDataCableAdapter();
			}
			@Override
			public Adapter caseDCEngine(DCEngine object) {
				return createDCEngineAdapter();
			}
			@Override
			public Adapter caseSystem(epml.System object) {
				return createSystemAdapter();
			}
			@Override
			public Adapter caseCLASS(CLASS object) {
				return createCLASSAdapter();
			}
			@Override
			public Adapter caseCATEGORIZATIONCLASS(CATEGORIZATIONCLASS object) {
				return createCATEGORIZATIONCLASSAdapter();
			}
			@Override
			public Adapter caseDICTIONARY(DICTIONARY object) {
				return createDICTIONARYAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link epml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.Application
	 * @generated
	 */
	public Adapter createApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.Agent
	 * @generated
	 */
	public Adapter createAgentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.InputPort
	 * @generated
	 */
	public Adapter createInputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.OutputPort
	 * @generated
	 */
	public Adapter createOutputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.Place <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.Place
	 * @generated
	 */
	public Adapter createPlaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.PCBasedControls <em>PC Based Controls</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.PCBasedControls
	 * @generated
	 */
	public Adapter createPCBasedControlsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.Fieldbus <em>Fieldbus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.Fieldbus
	 * @generated
	 */
	public Adapter createFieldbusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.RectangularConnectorSet <em>Rectangular Connector Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.RectangularConnectorSet
	 * @generated
	 */
	public Adapter createRectangularConnectorSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.InductiveProximitySwitch <em>Inductive Proximity Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.InductiveProximitySwitch
	 * @generated
	 */
	public Adapter createInductiveProximitySwitchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.CommunicationCable <em>Communication Cable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.CommunicationCable
	 * @generated
	 */
	public Adapter createCommunicationCableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.ReadyMadeDataCable <em>Ready Made Data Cable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.ReadyMadeDataCable
	 * @generated
	 */
	public Adapter createReadyMadeDataCableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.DCEngine <em>DC Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.DCEngine
	 * @generated
	 */
	public Adapter createDCEngineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link epml.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see epml.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link isostdisois_13584_32ed_1techxmlschemaontomlSimplified.CLASS <em>CLASS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see isostdisois_13584_32ed_1techxmlschemaontomlSimplified.CLASS
	 * @generated
	 */
	public Adapter createCLASSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link isostdisois_13584_32ed_1techxmlschemaontomlSimplified.CATEGORIZATIONCLASS <em>CATEGORIZATIONCLASS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see isostdisois_13584_32ed_1techxmlschemaontomlSimplified.CATEGORIZATIONCLASS
	 * @generated
	 */
	public Adapter createCATEGORIZATIONCLASSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link isostdisois_13584_32ed_1techxmlschemaontomlSimplified.DICTIONARY <em>DICTIONARY</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see isostdisois_13584_32ed_1techxmlschemaontomlSimplified.DICTIONARY
	 * @generated
	 */
	public Adapter createDICTIONARYAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EpmlAdapterFactory
