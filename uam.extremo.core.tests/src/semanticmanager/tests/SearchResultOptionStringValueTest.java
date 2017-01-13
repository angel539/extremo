/**
 */
package semanticmanager.tests;

import junit.textui.TestRunner;

import semanticmanager.SearchResultOptionStringValue;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Search Result Option String Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SearchResultOptionStringValueTest extends SearchResultOptionValueTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SearchResultOptionStringValueTest.class);
	}

	/**
	 * Constructs a new Search Result Option String Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchResultOptionStringValueTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Search Result Option String Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SearchResultOptionStringValue getFixture() {
		return (SearchResultOptionStringValue)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createSearchResultOptionStringValue());
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

} //SearchResultOptionStringValueTest
