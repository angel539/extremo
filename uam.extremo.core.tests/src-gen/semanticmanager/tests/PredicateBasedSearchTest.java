/**
 */
package semanticmanager.tests;

import junit.textui.TestRunner;

import semanticmanager.PredicateBasedSearch;
import semanticmanager.SemanticmanagerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Predicate Based Search</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link semanticmanager.PredicateBasedSearch#matches(semanticmanager.NamedElement) <em>Matches</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PredicateBasedSearchTest extends SimpleSearchConfigurationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PredicateBasedSearchTest.class);
	}

	/**
	 * Constructs a new Predicate Based Search test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateBasedSearchTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Predicate Based Search test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PredicateBasedSearch getFixture() {
		return (PredicateBasedSearch)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SemanticmanagerFactory.eINSTANCE.createPredicateBasedSearch());
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
	 * Tests the '{@link semanticmanager.PredicateBasedSearch#matches(semanticmanager.NamedElement) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see semanticmanager.PredicateBasedSearch#matches(semanticmanager.NamedElement)
	 * @generated
	 */
	public void testMatches__NamedElement() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //PredicateBasedSearchTest
