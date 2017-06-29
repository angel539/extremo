/**
 */
package semanticmanager.tests;

import junit.textui.TestRunner;

import semanticmanager.PrimitiveTypeParamValue;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Primitive Type Param Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrimitiveTypeParamValueTest extends SearchParamValueTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PrimitiveTypeParamValueTest.class);
	}

	/**
	 * Constructs a new Primitive Type Param Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeParamValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Primitive Type Param Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PrimitiveTypeParamValue getFixture() {
		return (PrimitiveTypeParamValue)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createPrimitiveTypeParamValue());
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

} //PrimitiveTypeParamValueTest
