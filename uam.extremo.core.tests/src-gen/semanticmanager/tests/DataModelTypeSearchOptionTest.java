/**
 */
package semanticmanager.tests;

import junit.textui.TestRunner;

import semanticmanager.DataModelTypeSearchOption;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Data Model Type Search Option</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataModelTypeSearchOptionTest extends SearchOptionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DataModelTypeSearchOptionTest.class);
	}

	/**
	 * Constructs a new Data Model Type Search Option test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataModelTypeSearchOptionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Data Model Type Search Option test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DataModelTypeSearchOption getFixture() {
		return (DataModelTypeSearchOption)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createDataModelTypeSearchOption());
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

} //DataModelTypeSearchOptionTest
