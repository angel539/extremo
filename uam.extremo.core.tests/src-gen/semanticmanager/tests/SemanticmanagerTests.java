/**
 */
package semanticmanager.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>semanticmanager</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class SemanticmanagerTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new SemanticmanagerTests("semanticmanager Tests");
		suite.addTestSuite(CompositeSearchConfigurationTest.class);
		suite.addTestSuite(CustomSearchTest.class);
		suite.addTestSuite(PredicateBasedSearchTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticmanagerTests(String name) {
		super(name);
	}

} //SemanticmanagerTests
