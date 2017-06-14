/**
 */
package semanticmanager.tests;

import junit.textui.TestRunner;
import semanticmanager.CustomSearch;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Custom Search</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link semanticmanager.CustomSearch#search(semanticmanager.SearchResult) <em>Search</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class CustomSearchTest extends SimpleSearchConfigurationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CustomSearchTest.class);
	}

	/**
	 * Constructs a new Custom Search test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomSearchTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Custom Search test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CustomSearch getFixture() {
		return (CustomSearch)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createCustomSearch());
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

	/**
	 * Tests the '{@link semanticmanager.CustomSearch#search(semanticmanager.SearchResult) <em>Search</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.CustomSearch#search(semanticmanager.SearchResult)
	 * @generated
	 */
	public void testSearch__SearchResult() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //CustomSearchTest
