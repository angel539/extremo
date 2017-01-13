/**
 */
package semanticmanager.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import semanticmanager.RepositoryManager;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Repository Manager</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositoryManagerTest extends TestCase {

	/**
	 * The fixture for this Repository Manager test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryManager fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RepositoryManagerTest.class);
	}

	/**
	 * Constructs a new Repository Manager test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryManagerTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Repository Manager test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(RepositoryManager fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Repository Manager test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryManager getFixture() {
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
		setFixture(SemanticmanagerFactory.eINSTANCE.createRepositoryManager());
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

} //RepositoryManagerTest
