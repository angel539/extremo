/**
 */
package semanticmanager.tests;

import junit.textui.TestRunner;

import semanticmanager.ModelTypeParamValue;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Model Type Param Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelTypeParamValueTest extends SearchParamValueTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModelTypeParamValueTest.class);
	}

	/**
	 * Constructs a new Model Type Param Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTypeParamValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Model Type Param Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ModelTypeParamValue getFixture() {
		return (ModelTypeParamValue)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createModelTypeParamValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ModelTypeParamValueTest
