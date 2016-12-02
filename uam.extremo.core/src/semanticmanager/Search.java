/**
 */
package semanticmanager;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.Search#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.Search#isEquivalents <em>Equivalents</em>}</li>
 *   <li>{@link semanticmanager.Search#isAllProperties <em>All Properties</em>}</li>
 *   <li>{@link semanticmanager.Search#isOnlyDirectSubclasses <em>Only Direct Subclasses</em>}</li>
 *   <li>{@link semanticmanager.Search#getSearchtree <em>Searchtree</em>}</li>
 *   <li>{@link semanticmanager.Search#getResources <em>Resources</em>}</li>
 *   <li>{@link semanticmanager.Search#getResults <em>Results</em>}</li>
 *   <li>{@link semanticmanager.Search#getRelevanceR1 <em>Relevance R1</em>}</li>
 *   <li>{@link semanticmanager.Search#getRelevanceR2 <em>Relevance R2</em>}</li>
 *   <li>{@link semanticmanager.Search#getRelevanceR3 <em>Relevance R3</em>}</li>
 *   <li>{@link semanticmanager.Search#getRelevanceR4 <em>Relevance R4</em>}</li>
 *   <li>{@link semanticmanager.Search#getRelevanceR5 <em>Relevance R5</em>}</li>
 *   <li>{@link semanticmanager.Search#getMaxWeight <em>Max Weight</em>}</li>
 *   <li>{@link semanticmanager.Search#getStrategyApplied <em>Strategy Applied</em>}</li>
 *   <li>{@link semanticmanager.Search#getSearchField <em>Search Field</em>}</li>
 *   <li>{@link semanticmanager.Search#isOnlyDirectSuperclasses <em>Only Direct Superclasses</em>}</li>
 *   <li>{@link semanticmanager.Search#getVariance <em>Variance</em>}</li>
 *   <li>{@link semanticmanager.Search#getSearchFieldTarget <em>Search Field Target</em>}</li>
 *   <li>{@link semanticmanager.Search#getW1 <em>W1</em>}</li>
 *   <li>{@link semanticmanager.Search#getW2 <em>W2</em>}</li>
 *   <li>{@link semanticmanager.Search#getW3 <em>W3</em>}</li>
 *   <li>{@link semanticmanager.Search#getW4 <em>W4</em>}</li>
 *   <li>{@link semanticmanager.Search#getSearchMode <em>Search Mode</em>}</li>
 * </ul>
 *
 * @see semanticmanager.SemanticmanagerPackage#getSearch()
 * @model
 * @generated
 */
public interface Search extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Equivalents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equivalents</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equivalents</em>' attribute.
	 * @see #setEquivalents(boolean)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_Equivalents()
	 * @model
	 * @generated
	 */
	boolean isEquivalents();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#isEquivalents <em>Equivalents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equivalents</em>' attribute.
	 * @see #isEquivalents()
	 * @generated
	 */
	void setEquivalents(boolean value);

	/**
	 * Returns the value of the '<em><b>All Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Properties</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Properties</em>' attribute.
	 * @see #setAllProperties(boolean)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_AllProperties()
	 * @model
	 * @generated
	 */
	boolean isAllProperties();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#isAllProperties <em>All Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All Properties</em>' attribute.
	 * @see #isAllProperties()
	 * @generated
	 */
	void setAllProperties(boolean value);

	/**
	 * Returns the value of the '<em><b>Only Direct Subclasses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Only Direct Subclasses</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Only Direct Subclasses</em>' attribute.
	 * @see #setOnlyDirectSubclasses(boolean)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_OnlyDirectSubclasses()
	 * @model
	 * @generated
	 */
	boolean isOnlyDirectSubclasses();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#isOnlyDirectSubclasses <em>Only Direct Subclasses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Only Direct Subclasses</em>' attribute.
	 * @see #isOnlyDirectSubclasses()
	 * @generated
	 */
	void setOnlyDirectSubclasses(boolean value);

	/**
	 * Returns the value of the '<em><b>Searchtree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Searchtree</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Searchtree</em>' containment reference.
	 * @see #setSearchtree(TreeNode)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_Searchtree()
	 * @model containment="true"
	 * @generated
	 */
	TreeNode getSearchtree();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getSearchtree <em>Searchtree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Searchtree</em>' containment reference.
	 * @see #getSearchtree()
	 * @generated
	 */
	void setSearchtree(TreeNode value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' reference list.
	 * The list contents are of type {@link semanticmanager.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_Resources()
	 * @model
	 * @generated
	 */
	EList<Resource> getResources();

	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link semanticmanager.SemanticGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<SemanticGroup> getResults();

	/**
	 * Returns the value of the '<em><b>Relevance R1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevance R1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevance R1</em>' attribute.
	 * @see #setRelevanceR1(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_RelevanceR1()
	 * @model
	 * @generated
	 */
	int getRelevanceR1();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getRelevanceR1 <em>Relevance R1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevance R1</em>' attribute.
	 * @see #getRelevanceR1()
	 * @generated
	 */
	void setRelevanceR1(int value);

	/**
	 * Returns the value of the '<em><b>Relevance R2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevance R2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevance R2</em>' attribute.
	 * @see #setRelevanceR2(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_RelevanceR2()
	 * @model
	 * @generated
	 */
	int getRelevanceR2();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getRelevanceR2 <em>Relevance R2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevance R2</em>' attribute.
	 * @see #getRelevanceR2()
	 * @generated
	 */
	void setRelevanceR2(int value);

	/**
	 * Returns the value of the '<em><b>Relevance R3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevance R3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevance R3</em>' attribute.
	 * @see #setRelevanceR3(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_RelevanceR3()
	 * @model
	 * @generated
	 */
	int getRelevanceR3();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getRelevanceR3 <em>Relevance R3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevance R3</em>' attribute.
	 * @see #getRelevanceR3()
	 * @generated
	 */
	void setRelevanceR3(int value);

	/**
	 * Returns the value of the '<em><b>Relevance R4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevance R4</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevance R4</em>' attribute.
	 * @see #setRelevanceR4(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_RelevanceR4()
	 * @model
	 * @generated
	 */
	int getRelevanceR4();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getRelevanceR4 <em>Relevance R4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevance R4</em>' attribute.
	 * @see #getRelevanceR4()
	 * @generated
	 */
	void setRelevanceR4(int value);

	/**
	 * Returns the value of the '<em><b>Relevance R5</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relevance R5</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevance R5</em>' attribute.
	 * @see #setRelevanceR5(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_RelevanceR5()
	 * @model
	 * @generated
	 */
	int getRelevanceR5();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getRelevanceR5 <em>Relevance R5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevance R5</em>' attribute.
	 * @see #getRelevanceR5()
	 * @generated
	 */
	void setRelevanceR5(int value);

	/**
	 * Returns the value of the '<em><b>Max Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Weight</em>' attribute.
	 * @see #setMaxWeight(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_MaxWeight()
	 * @model
	 * @generated
	 */
	int getMaxWeight();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getMaxWeight <em>Max Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Weight</em>' attribute.
	 * @see #getMaxWeight()
	 * @generated
	 */
	void setMaxWeight(int value);

	/**
	 * Returns the value of the '<em><b>Strategy Applied</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strategy Applied</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strategy Applied</em>' attribute.
	 * @see #setStrategyApplied(String)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_StrategyApplied()
	 * @model
	 * @generated
	 */
	String getStrategyApplied();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getStrategyApplied <em>Strategy Applied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strategy Applied</em>' attribute.
	 * @see #getStrategyApplied()
	 * @generated
	 */
	void setStrategyApplied(String value);

	/**
	 * Returns the value of the '<em><b>Search Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Search Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search Field</em>' attribute.
	 * @see #setSearchField(String)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_SearchField()
	 * @model
	 * @generated
	 */
	String getSearchField();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getSearchField <em>Search Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search Field</em>' attribute.
	 * @see #getSearchField()
	 * @generated
	 */
	void setSearchField(String value);

	/**
	 * Returns the value of the '<em><b>Only Direct Superclasses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Only Direct Superclasses</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Only Direct Superclasses</em>' attribute.
	 * @see #setOnlyDirectSuperclasses(boolean)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_OnlyDirectSuperclasses()
	 * @model
	 * @generated
	 */
	boolean isOnlyDirectSuperclasses();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#isOnlyDirectSuperclasses <em>Only Direct Superclasses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Only Direct Superclasses</em>' attribute.
	 * @see #isOnlyDirectSuperclasses()
	 * @generated
	 */
	void setOnlyDirectSuperclasses(boolean value);

	/**
	 * Returns the value of the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variance</em>' attribute.
	 * @see #setVariance(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_Variance()
	 * @model
	 * @generated
	 */
	int getVariance();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getVariance <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variance</em>' attribute.
	 * @see #getVariance()
	 * @generated
	 */
	void setVariance(int value);

	/**
	 * Returns the value of the '<em><b>Search Field Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Search Field Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search Field Target</em>' attribute.
	 * @see #setSearchFieldTarget(String)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_SearchFieldTarget()
	 * @model
	 * @generated
	 */
	String getSearchFieldTarget();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getSearchFieldTarget <em>Search Field Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search Field Target</em>' attribute.
	 * @see #getSearchFieldTarget()
	 * @generated
	 */
	void setSearchFieldTarget(String value);

	/**
	 * Returns the value of the '<em><b>W1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>W1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>W1</em>' attribute.
	 * @see #setW1(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_W1()
	 * @model
	 * @generated
	 */
	int getW1();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getW1 <em>W1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>W1</em>' attribute.
	 * @see #getW1()
	 * @generated
	 */
	void setW1(int value);

	/**
	 * Returns the value of the '<em><b>W2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>W2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>W2</em>' attribute.
	 * @see #setW2(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_W2()
	 * @model
	 * @generated
	 */
	int getW2();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getW2 <em>W2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>W2</em>' attribute.
	 * @see #getW2()
	 * @generated
	 */
	void setW2(int value);

	/**
	 * Returns the value of the '<em><b>W3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>W3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>W3</em>' attribute.
	 * @see #setW3(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_W3()
	 * @model
	 * @generated
	 */
	int getW3();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getW3 <em>W3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>W3</em>' attribute.
	 * @see #getW3()
	 * @generated
	 */
	void setW3(int value);

	/**
	 * Returns the value of the '<em><b>W4</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>W4</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>W4</em>' attribute.
	 * @see #setW4(int)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_W4()
	 * @model
	 * @generated
	 */
	int getW4();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getW4 <em>W4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>W4</em>' attribute.
	 * @see #getW4()
	 * @generated
	 */
	void setW4(int value);

	/**
	 * Returns the value of the '<em><b>Search Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Search Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Search Mode</em>' attribute.
	 * @see #setSearchMode(String)
	 * @see semanticmanager.SemanticmanagerPackage#getSearch_SearchMode()
	 * @model
	 * @generated
	 */
	String getSearchMode();

	/**
	 * Sets the value of the '{@link semanticmanager.Search#getSearchMode <em>Search Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Search Mode</em>' attribute.
	 * @see #getSearchMode()
	 * @generated
	 */
	void setSearchMode(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Map<?, ?> getOrderSearchesListByWeight();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void expand();

} // Search
