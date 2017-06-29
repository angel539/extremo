/**
 */
package semanticmanager.tests;

import junit.textui.TestRunner;

import semanticmanager.PrimitiveTypeParam;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Primitive Type Param</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrimitiveTypeParamTest extends SearchParamTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PrimitiveTypeParamTest.class);
	}

	/**
	 * Constructs a new Primitive Type Param test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeParamTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Primitive Type Param test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PrimitiveTypeParam getFixture() {
		return (PrimitiveTypeParam)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createPrimitiveTypeParam());
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

} //PrimitiveTypeParamTest
