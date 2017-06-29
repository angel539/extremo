/**
 */
package semanticmanager.tests;

import junit.textui.TestRunner;

import semanticmanager.AtomicSearchResult;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Atomic Search Result</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AtomicSearchResultTest extends SearchResultTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AtomicSearchResultTest.class);
	}

	/**
	 * Constructs a new Atomic Search Result test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicSearchResultTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Atomic Search Result test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AtomicSearchResult getFixture() {
		return (AtomicSearchResult)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createAtomicSearchResult());
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

} //AtomicSearchResultTest
