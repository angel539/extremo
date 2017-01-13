/**
 */
package semanticmanager.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import semanticmanager.SearchOption;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Search Option</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SearchOptionTest extends TestCase {

	/**
	 * The fixture for this Search Option test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchOption fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SearchOptionTest.class);
	}

	/**
	 * Constructs a new Search Option test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchOptionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Search Option test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SearchOption fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Search Option test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchOption getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createSearchOption());
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

} //SearchOptionTest
