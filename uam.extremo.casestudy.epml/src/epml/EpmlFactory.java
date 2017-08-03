/**
 */
package epml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see epml.EpmlPackage
 * @generated
 */
public interface EpmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EpmlFactory eINSTANCE = epml.impl.EpmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Element</em>'.
	 * @generated
	 */
	NamedElement createNamedElement();

	/**
	 * Returns a new object of class '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application</em>'.
	 * @generated
	 */
	Application createApplication();

	/**
	 * Returns a new object of class '<em>Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Port</em>'.
	 * @generated
	 */
	InputPort createInputPort();

	/**
	 * Returns a new object of class '<em>Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Port</em>'.
	 * @generated
	 */
	OutputPort createOutputPort();

	/**
	 * Returns a new object of class '<em>PC Based Controls</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PC Based Controls</em>'.
	 * @generated
	 */
	PCBasedControls createPCBasedControls();

	/**
	 * Returns a new object of class '<em>Fieldbus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fieldbus</em>'.
	 * @generated
	 */
	Fieldbus createFieldbus();

	/**
	 * Returns a new object of class '<em>Rectangular Connector Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rectangular Connector Set</em>'.
	 * @generated
	 */
	RectangularConnectorSet createRectangularConnectorSet();

	/**
	 * Returns a new object of class '<em>Inductive Proximity Switch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inductive Proximity Switch</em>'.
	 * @generated
	 */
	InductiveProximitySwitch createInductiveProximitySwitch();

	/**
	 * Returns a new object of class '<em>Communication Cable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Cable</em>'.
	 * @generated
	 */
	CommunicationCable createCommunicationCable();

	/**
	 * Returns a new object of class '<em>Ready Made Data Cable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ready Made Data Cable</em>'.
	 * @generated
	 */
	ReadyMadeDataCable createReadyMadeDataCable();

	/**
	 * Returns a new object of class '<em>DC Engine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DC Engine</em>'.
	 * @generated
	 */
	DCEngine createDCEngine();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EpmlPackage getEpmlPackage();

} //EpmlFactory
