/**
 */
package semanticmanager.tests;

import junit.textui.TestRunner;

import semanticmanager.PrimitiveTypeSearchOption;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Primitive Type Search Option</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrimitiveTypeSearchOptionTest extends SearchOptionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PrimitiveTypeSearchOptionTest.class);
	}

	/**
	 * Constructs a new Primitive Type Search Option test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeSearchOptionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Primitive Type Search Option test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PrimitiveTypeSearchOption getFixture() {
		return (PrimitiveTypeSearchOption)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createPrimitiveTypeSearchOption());
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

} //PrimitiveTypeSearchOptionTest
