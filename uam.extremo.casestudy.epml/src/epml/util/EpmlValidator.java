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

import isostdisois_13584_32ed_1techxmlschemaontomlSimplified.util.Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see epml.EpmlPackage
 * @generated
 */
public class EpmlValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final EpmlValidator INSTANCE = new EpmlValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "epml";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EpmlValidator() {
		super();
		isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator = Isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return EpmlPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case EpmlPackage.NAMED_ELEMENT:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case EpmlPackage.APPLICATION:
				return validateApplication((Application)value, diagnostics, context);
			case EpmlPackage.AGENT:
				return validateAgent((Agent)value, diagnostics, context);
			case EpmlPackage.PORT:
				return validatePort((Port)value, diagnostics, context);
			case EpmlPackage.INPUT_PORT:
				return validateInputPort((InputPort)value, diagnostics, context);
			case EpmlPackage.OUTPUT_PORT:
				return validateOutputPort((OutputPort)value, diagnostics, context);
			case EpmlPackage.PLACE:
				return validatePlace((Place)value, diagnostics, context);
			case EpmlPackage.PC_BASED_CONTROLS:
				return validatePCBasedControls((PCBasedControls)value, diagnostics, context);
			case EpmlPackage.FIELDBUS:
				return validateFieldbus((Fieldbus)value, diagnostics, context);
			case EpmlPackage.RECTANGULAR_CONNECTOR_SET:
				return validateRectangularConnectorSet((RectangularConnectorSet)value, diagnostics, context);
			case EpmlPackage.INDUCTIVE_PROXIMITY_SWITCH:
				return validateInductiveProximitySwitch((InductiveProximitySwitch)value, diagnostics, context);
			case EpmlPackage.COMMUNICATION_CABLE:
				return validateCommunicationCable((CommunicationCable)value, diagnostics, context);
			case EpmlPackage.READY_MADE_DATA_CABLE:
				return validateReadyMadeDataCable((ReadyMadeDataCable)value, diagnostics, context);
			case EpmlPackage.DC_ENGINE:
				return validateDCEngine((DCEngine)value, diagnostics, context);
			case EpmlPackage.SYSTEM:
				return validateSystem((epml.System)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateApplication(Application application, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(application, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAgent(Agent agent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(agent, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(agent, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_maxLengthRevision(agent, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternStatus(agent, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternId(agent, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(port, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInputPort(InputPort inputPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inputPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutputPort(OutputPort outputPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(outputPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlace(Place place, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(place, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(place, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(place, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(place, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(place, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(place, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(place, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(place, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(place, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_maxLengthRevision(place, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternStatus(place, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternId(place, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlace_matchRates(place, diagnostics, context);
		return result;
	}

	/**
	 * Validates the matchRates constraint of '<em>Place</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePlace_matchRates(Place place, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "matchRates", getObjectLabel(place, context) },
						 new Object[] { place },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePCBasedControls(PCBasedControls pcBasedControls, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(pcBasedControls, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(pcBasedControls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pcBasedControls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pcBasedControls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(pcBasedControls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pcBasedControls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pcBasedControls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pcBasedControls, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pcBasedControls, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_maxLengthRevision(pcBasedControls, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternStatus(pcBasedControls, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternId(pcBasedControls, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFieldbus(Fieldbus fieldbus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(fieldbus, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(fieldbus, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(fieldbus, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(fieldbus, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(fieldbus, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(fieldbus, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(fieldbus, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(fieldbus, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(fieldbus, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_maxLengthRevision(fieldbus, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternStatus(fieldbus, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternId(fieldbus, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRectangularConnectorSet(RectangularConnectorSet rectangularConnectorSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(rectangularConnectorSet, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(rectangularConnectorSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(rectangularConnectorSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(rectangularConnectorSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(rectangularConnectorSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(rectangularConnectorSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(rectangularConnectorSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(rectangularConnectorSet, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(rectangularConnectorSet, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_maxLengthRevision(rectangularConnectorSet, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternStatus(rectangularConnectorSet, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternId(rectangularConnectorSet, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInductiveProximitySwitch(InductiveProximitySwitch inductiveProximitySwitch, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(inductiveProximitySwitch, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(inductiveProximitySwitch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(inductiveProximitySwitch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(inductiveProximitySwitch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(inductiveProximitySwitch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(inductiveProximitySwitch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(inductiveProximitySwitch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(inductiveProximitySwitch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(inductiveProximitySwitch, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_maxLengthRevision(inductiveProximitySwitch, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternStatus(inductiveProximitySwitch, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternId(inductiveProximitySwitch, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCommunicationCable(CommunicationCable communicationCable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(communicationCable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_maxLengthRevision(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternStatus(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternId(communicationCable, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlace_matchRates(communicationCable, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReadyMadeDataCable(ReadyMadeDataCable readyMadeDataCable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(readyMadeDataCable, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_maxLengthRevision(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternStatus(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternId(readyMadeDataCable, diagnostics, context);
		if (result || diagnostics != null) result &= validatePlace_matchRates(readyMadeDataCable, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDCEngine(DCEngine dcEngine, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dcEngine, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dcEngine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dcEngine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dcEngine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dcEngine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dcEngine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dcEngine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dcEngine, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dcEngine, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_maxLengthRevision(dcEngine, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternStatus(dcEngine, diagnostics, context);
		if (result || diagnostics != null) result &= isostdisois_13584_32ed_1techxmlschemaontomlSimplifiedValidator.validateCLASS_patternId(dcEngine, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystem(epml.System system, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(system, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //EpmlValidator
