/**
 */
package semanticmanager;

import semanticmanager.constraints.ExtensibleConstraintInterpreter;
import semanticmanager.queries.ExtensibleAtomicSearchResult;
import semanticmanager.queries.ExtensibleCustomSearch;
import semanticmanager.queries.ExtensibleGroupedSearchResult;
import semanticmanager.queries.ExtensiblePredicateBasedSearch;
import semanticmanager.queries.ExtensibleService;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see semanticmanager.SemanticmanagerPackage
 * @generated
 */
public interface ExtendedSemanticmanagerFactory extends SemanticmanagerFactory {
	ExtensibleAtomicSearchResult createAtomicSearchResult();
	ExtensibleGroupedSearchResult createGroupedSearchResult();
	
	ExtensibleCustomSearch createCustomSearch();
	ExtensiblePredicateBasedSearch createPredicateBasedSearch();
	ExtensibleService createService();
	ExtensibleConstraintInterpreter createConstraintInterpreter();
}
