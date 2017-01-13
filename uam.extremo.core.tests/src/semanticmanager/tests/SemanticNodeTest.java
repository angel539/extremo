/**
 */
package semanticmanager.tests;

import junit.textui.TestRunner;

import semanticmanager.SemanticNode;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Semantic Node</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SemanticNodeTest extends NamedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SemanticNodeTest.class);
	}

	/**
	 * Constructs a new Semantic Node test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticNodeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Semantic Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SemanticNode getFixture() {
		return (SemanticNode)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createSemanticNode());
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

} //SemanticNodeTest
