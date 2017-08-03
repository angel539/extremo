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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see epml.EpmlPackage
 * @generated
 */
public class EpmlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EpmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpmlSwitch() {
		if (modelPackage == null) {
			modelPackage = EpmlPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EpmlPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.APPLICATION: {
				Application application = (Application)theEObject;
				T result = caseApplication(application);
				if (result == null) result = caseNamedElement(application);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.AGENT: {
				Agent agent = (Agent)theEObject;
				T result = caseAgent(agent);
				if (result == null) result = caseCATEGORIZATIONCLASS(agent);
				if (result == null) result = caseCLASS(agent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseNamedElement(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.INPUT_PORT: {
				InputPort inputPort = (InputPort)theEObject;
				T result = caseInputPort(inputPort);
				if (result == null) result = casePort(inputPort);
				if (result == null) result = caseNamedElement(inputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.OUTPUT_PORT: {
				OutputPort outputPort = (OutputPort)theEObject;
				T result = caseOutputPort(outputPort);
				if (result == null) result = casePort(outputPort);
				if (result == null) result = caseNamedElement(outputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.PLACE: {
				Place place = (Place)theEObject;
				T result = casePlace(place);
				if (result == null) result = caseCATEGORIZATIONCLASS(place);
				if (result == null) result = caseNamedElement(place);
				if (result == null) result = caseCLASS(place);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.PC_BASED_CONTROLS: {
				PCBasedControls pcBasedControls = (PCBasedControls)theEObject;
				T result = casePCBasedControls(pcBasedControls);
				if (result == null) result = caseAgent(pcBasedControls);
				if (result == null) result = caseCATEGORIZATIONCLASS(pcBasedControls);
				if (result == null) result = caseCLASS(pcBasedControls);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.FIELDBUS: {
				Fieldbus fieldbus = (Fieldbus)theEObject;
				T result = caseFieldbus(fieldbus);
				if (result == null) result = caseAgent(fieldbus);
				if (result == null) result = caseCATEGORIZATIONCLASS(fieldbus);
				if (result == null) result = caseCLASS(fieldbus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.RECTANGULAR_CONNECTOR_SET: {
				RectangularConnectorSet rectangularConnectorSet = (RectangularConnectorSet)theEObject;
				T result = caseRectangularConnectorSet(rectangularConnectorSet);
				if (result == null) result = caseAgent(rectangularConnectorSet);
				if (result == null) result = caseCATEGORIZATIONCLASS(rectangularConnectorSet);
				if (result == null) result = caseCLASS(rectangularConnectorSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.INDUCTIVE_PROXIMITY_SWITCH: {
				InductiveProximitySwitch inductiveProximitySwitch = (InductiveProximitySwitch)theEObject;
				T result = caseInductiveProximitySwitch(inductiveProximitySwitch);
				if (result == null) result = caseAgent(inductiveProximitySwitch);
				if (result == null) result = caseCATEGORIZATIONCLASS(inductiveProximitySwitch);
				if (result == null) result = caseCLASS(inductiveProximitySwitch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.COMMUNICATION_CABLE: {
				CommunicationCable communicationCable = (CommunicationCable)theEObject;
				T result = caseCommunicationCable(communicationCable);
				if (result == null) result = casePlace(communicationCable);
				if (result == null) result = caseCATEGORIZATIONCLASS(communicationCable);
				if (result == null) result = caseNamedElement(communicationCable);
				if (result == null) result = caseCLASS(communicationCable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.READY_MADE_DATA_CABLE: {
				ReadyMadeDataCable readyMadeDataCable = (ReadyMadeDataCable)theEObject;
				T result = caseReadyMadeDataCable(readyMadeDataCable);
				if (result == null) result = casePlace(readyMadeDataCable);
				if (result == null) result = caseCATEGORIZATIONCLASS(readyMadeDataCable);
				if (result == null) result = caseNamedElement(readyMadeDataCable);
				if (result == null) result = caseCLASS(readyMadeDataCable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.DC_ENGINE: {
				DCEngine dcEngine = (DCEngine)theEObject;
				T result = caseDCEngine(dcEngine);
				if (result == null) result = caseAgent(dcEngine);
				if (result == null) result = caseCATEGORIZATIONCLASS(dcEngine);
				if (result == null) result = caseCLASS(dcEngine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EpmlPackage.SYSTEM: {
				epml.System system = (epml.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = caseDICTIONARY(system);
				if (result == null) result = caseNamedElement(system);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplication(Application object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Agent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Agent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAgent(Agent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputPort(InputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputPort(OutputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Place</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Place</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlace(Place object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PC Based Controls</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PC Based Controls</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePCBasedControls(PCBasedControls object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fieldbus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fieldbus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFieldbus(Fieldbus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rectangular Connector Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rectangular Connector Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRectangularConnectorSet(RectangularConnectorSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inductive Proximity Switch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inductive Proximity Switch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInductiveProximitySwitch(InductiveProximitySwitch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Communication Cable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Communication Cable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommunicationCable(CommunicationCable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ready Made Data Cable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ready Made Data Cable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReadyMadeDataCable(ReadyMadeDataCable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DC Engine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DC Engine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDCEngine(DCEngine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem(epml.System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CLASS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CLASS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCLASS(CLASS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CATEGORIZATIONCLASS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CATEGORIZATIONCLASS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCATEGORIZATIONCLASS(CATEGORIZATIONCLASS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DICTIONARY</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DICTIONARY</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDICTIONARY(DICTIONARY object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EpmlSwitch
