/**
 */
package semanticmanager.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ecore.util.InternalEList;
import semanticmanager.Resource;
import semanticmanager.Search;
import semanticmanager.SemanticGroup;
import semanticmanager.SemanticmanagerFactory;
import semanticmanager.SemanticmanagerPackage;
import semanticmanager.TreeNode;
import uam.extremo.core.utils.Tuple;
import uam.extremo.core.wordnet.Wordnet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.impl.SearchImpl#getName <em>Name</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#isEquivalents <em>Equivalents</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#isAllProperties <em>All Properties</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#isOnlyDirectSubclasses <em>Only Direct Subclasses</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getSearchtree <em>Searchtree</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getResults <em>Results</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getRelevanceR1 <em>Relevance R1</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getRelevanceR2 <em>Relevance R2</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getRelevanceR3 <em>Relevance R3</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getRelevanceR4 <em>Relevance R4</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getRelevanceR5 <em>Relevance R5</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getMaxWeight <em>Max Weight</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getStrategyApplied <em>Strategy Applied</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getSearchField <em>Search Field</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#isOnlyDirectSuperclasses <em>Only Direct Superclasses</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getVariance <em>Variance</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getSearchFieldTarget <em>Search Field Target</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getW1 <em>W1</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getW2 <em>W2</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getW3 <em>W3</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getW4 <em>W4</em>}</li>
 *   <li>{@link semanticmanager.impl.SearchImpl#getSearchMode <em>Search Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchImpl extends MinimalEObjectImpl.Container implements Search {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isEquivalents() <em>Equivalents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEquivalents()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EQUIVALENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEquivalents() <em>Equivalents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEquivalents()
	 * @generated
	 * @ordered
	 */
	protected boolean equivalents = EQUIVALENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllProperties() <em>All Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllProperties()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALL_PROPERTIES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllProperties() <em>All Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllProperties()
	 * @generated
	 * @ordered
	 */
	protected boolean allProperties = ALL_PROPERTIES_EDEFAULT;

	/**
	 * The default value of the '{@link #isOnlyDirectSubclasses() <em>Only Direct Subclasses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnlyDirectSubclasses()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ONLY_DIRECT_SUBCLASSES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOnlyDirectSubclasses() <em>Only Direct Subclasses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnlyDirectSubclasses()
	 * @generated
	 * @ordered
	 */
	protected boolean onlyDirectSubclasses = ONLY_DIRECT_SUBCLASSES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSearchtree() <em>Searchtree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchtree()
	 * @generated
	 * @ordered
	 */
	protected TreeNode searchtree;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticGroup> results;

	/**
	 * The default value of the '{@link #getRelevanceR1() <em>Relevance R1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevanceR1()
	 * @generated
	 * @ordered
	 */
	protected static final int RELEVANCE_R1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRelevanceR1() <em>Relevance R1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevanceR1()
	 * @generated
	 * @ordered
	 */
	protected int relevanceR1 = RELEVANCE_R1_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelevanceR2() <em>Relevance R2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevanceR2()
	 * @generated
	 * @ordered
	 */
	protected static final int RELEVANCE_R2_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRelevanceR2() <em>Relevance R2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevanceR2()
	 * @generated
	 * @ordered
	 */
	protected int relevanceR2 = RELEVANCE_R2_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelevanceR3() <em>Relevance R3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevanceR3()
	 * @generated
	 * @ordered
	 */
	protected static final int RELEVANCE_R3_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRelevanceR3() <em>Relevance R3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevanceR3()
	 * @generated
	 * @ordered
	 */
	protected int relevanceR3 = RELEVANCE_R3_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelevanceR4() <em>Relevance R4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevanceR4()
	 * @generated
	 * @ordered
	 */
	protected static final int RELEVANCE_R4_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRelevanceR4() <em>Relevance R4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevanceR4()
	 * @generated
	 * @ordered
	 */
	protected int relevanceR4 = RELEVANCE_R4_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelevanceR5() <em>Relevance R5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevanceR5()
	 * @generated
	 * @ordered
	 */
	protected static final int RELEVANCE_R5_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRelevanceR5() <em>Relevance R5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevanceR5()
	 * @generated
	 * @ordered
	 */
	protected int relevanceR5 = RELEVANCE_R5_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxWeight() <em>Max Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxWeight()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_WEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxWeight() <em>Max Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxWeight()
	 * @generated
	 * @ordered
	 */
	protected int maxWeight = MAX_WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStrategyApplied() <em>Strategy Applied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategyApplied()
	 * @generated
	 * @ordered
	 */
	protected static final String STRATEGY_APPLIED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStrategyApplied() <em>Strategy Applied</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategyApplied()
	 * @generated
	 * @ordered
	 */
	protected String strategyApplied = STRATEGY_APPLIED_EDEFAULT;

	/**
	 * The default value of the '{@link #getSearchField() <em>Search Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchField()
	 * @generated
	 * @ordered
	 */
	protected static final String SEARCH_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSearchField() <em>Search Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchField()
	 * @generated
	 * @ordered
	 */
	protected String searchField = SEARCH_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #isOnlyDirectSuperclasses() <em>Only Direct Superclasses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnlyDirectSuperclasses()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ONLY_DIRECT_SUPERCLASSES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOnlyDirectSuperclasses() <em>Only Direct Superclasses</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnlyDirectSuperclasses()
	 * @generated
	 * @ordered
	 */
	protected boolean onlyDirectSuperclasses = ONLY_DIRECT_SUPERCLASSES_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariance() <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariance()
	 * @generated
	 * @ordered
	 */
	protected static final int VARIANCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVariance() <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariance()
	 * @generated
	 * @ordered
	 */
	protected int variance = VARIANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSearchFieldTarget() <em>Search Field Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchFieldTarget()
	 * @generated
	 * @ordered
	 */
	protected static final String SEARCH_FIELD_TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSearchFieldTarget() <em>Search Field Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchFieldTarget()
	 * @generated
	 * @ordered
	 */
	protected String searchFieldTarget = SEARCH_FIELD_TARGET_EDEFAULT;

	/**
	 * The default value of the '{@link #getW1() <em>W1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW1()
	 * @generated
	 * @ordered
	 */
	protected static final int W1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getW1() <em>W1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW1()
	 * @generated
	 * @ordered
	 */
	protected int w1 = W1_EDEFAULT;

	/**
	 * The default value of the '{@link #getW2() <em>W2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW2()
	 * @generated
	 * @ordered
	 */
	protected static final int W2_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getW2() <em>W2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW2()
	 * @generated
	 * @ordered
	 */
	protected int w2 = W2_EDEFAULT;

	/**
	 * The default value of the '{@link #getW3() <em>W3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW3()
	 * @generated
	 * @ordered
	 */
	protected static final int W3_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getW3() <em>W3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW3()
	 * @generated
	 * @ordered
	 */
	protected int w3 = W3_EDEFAULT;

	/**
	 * The default value of the '{@link #getW4() <em>W4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW4()
	 * @generated
	 * @ordered
	 */
	protected static final int W4_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getW4() <em>W4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW4()
	 * @generated
	 * @ordered
	 */
	protected int w4 = W4_EDEFAULT;

	/**
	 * The default value of the '{@link #getSearchMode() <em>Search Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchMode()
	 * @generated
	 * @ordered
	 */
	protected static final String SEARCH_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSearchMode() <em>Search Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchMode()
	 * @generated
	 * @ordered
	 */
	protected String searchMode = SEARCH_MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticmanagerPackage.Literals.SEARCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEquivalents() {
		return equivalents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEquivalents(boolean newEquivalents) {
		boolean oldEquivalents = equivalents;
		equivalents = newEquivalents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__EQUIVALENTS, oldEquivalents, equivalents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllProperties() {
		return allProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllProperties(boolean newAllProperties) {
		boolean oldAllProperties = allProperties;
		allProperties = newAllProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__ALL_PROPERTIES, oldAllProperties, allProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOnlyDirectSubclasses() {
		return onlyDirectSubclasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnlyDirectSubclasses(boolean newOnlyDirectSubclasses) {
		boolean oldOnlyDirectSubclasses = onlyDirectSubclasses;
		onlyDirectSubclasses = newOnlyDirectSubclasses;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__ONLY_DIRECT_SUBCLASSES, oldOnlyDirectSubclasses, onlyDirectSubclasses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeNode getSearchtree() {
		return searchtree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSearchtree(TreeNode newSearchtree, NotificationChain msgs) {
		TreeNode oldSearchtree = searchtree;
		searchtree = newSearchtree;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__SEARCHTREE, oldSearchtree, newSearchtree);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearchtree(TreeNode newSearchtree) {
		if (newSearchtree != searchtree) {
			NotificationChain msgs = null;
			if (searchtree != null)
				msgs = ((InternalEObject)searchtree).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SemanticmanagerPackage.SEARCH__SEARCHTREE, null, msgs);
			if (newSearchtree != null)
				msgs = ((InternalEObject)newSearchtree).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SemanticmanagerPackage.SEARCH__SEARCHTREE, null, msgs);
			msgs = basicSetSearchtree(newSearchtree, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__SEARCHTREE, newSearchtree, newSearchtree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResources() {
		if (resources == null) {
			resources = new EObjectResolvingEList<Resource>(Resource.class, this, SemanticmanagerPackage.SEARCH__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticGroup> getResults() {
		if (results == null) {
			results = new EObjectContainmentEList<SemanticGroup>(SemanticGroup.class, this, SemanticmanagerPackage.SEARCH__RESULTS);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRelevanceR1() {
		return relevanceR1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevanceR1(int newRelevanceR1) {
		int oldRelevanceR1 = relevanceR1;
		relevanceR1 = newRelevanceR1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__RELEVANCE_R1, oldRelevanceR1, relevanceR1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRelevanceR2() {
		return relevanceR2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevanceR2(int newRelevanceR2) {
		int oldRelevanceR2 = relevanceR2;
		relevanceR2 = newRelevanceR2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__RELEVANCE_R2, oldRelevanceR2, relevanceR2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRelevanceR3() {
		return relevanceR3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevanceR3(int newRelevanceR3) {
		int oldRelevanceR3 = relevanceR3;
		relevanceR3 = newRelevanceR3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__RELEVANCE_R3, oldRelevanceR3, relevanceR3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRelevanceR4() {
		return relevanceR4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevanceR4(int newRelevanceR4) {
		int oldRelevanceR4 = relevanceR4;
		relevanceR4 = newRelevanceR4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__RELEVANCE_R4, oldRelevanceR4, relevanceR4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRelevanceR5() {
		return relevanceR5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevanceR5(int newRelevanceR5) {
		int oldRelevanceR5 = relevanceR5;
		relevanceR5 = newRelevanceR5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__RELEVANCE_R5, oldRelevanceR5, relevanceR5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxWeight() {
		return maxWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxWeight(int newMaxWeight) {
		int oldMaxWeight = maxWeight;
		maxWeight = newMaxWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__MAX_WEIGHT, oldMaxWeight, maxWeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStrategyApplied() {
		return strategyApplied;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrategyApplied(String newStrategyApplied) {
		String oldStrategyApplied = strategyApplied;
		strategyApplied = newStrategyApplied;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__STRATEGY_APPLIED, oldStrategyApplied, strategyApplied));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSearchField() {
		return searchField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearchField(String newSearchField) {
		String oldSearchField = searchField;
		searchField = newSearchField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__SEARCH_FIELD, oldSearchField, searchField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOnlyDirectSuperclasses() {
		return onlyDirectSuperclasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnlyDirectSuperclasses(boolean newOnlyDirectSuperclasses) {
		boolean oldOnlyDirectSuperclasses = onlyDirectSuperclasses;
		onlyDirectSuperclasses = newOnlyDirectSuperclasses;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__ONLY_DIRECT_SUPERCLASSES, oldOnlyDirectSuperclasses, onlyDirectSuperclasses));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVariance() {
		return variance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariance(int newVariance) {
		int oldVariance = variance;
		variance = newVariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__VARIANCE, oldVariance, variance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSearchFieldTarget() {
		return searchFieldTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearchFieldTarget(String newSearchFieldTarget) {
		String oldSearchFieldTarget = searchFieldTarget;
		searchFieldTarget = newSearchFieldTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__SEARCH_FIELD_TARGET, oldSearchFieldTarget, searchFieldTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getW1() {
		return w1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setW1(int newW1) {
		int oldW1 = w1;
		w1 = newW1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__W1, oldW1, w1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getW2() {
		return w2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setW2(int newW2) {
		int oldW2 = w2;
		w2 = newW2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__W2, oldW2, w2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getW3() {
		return w3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setW3(int newW3) {
		int oldW3 = w3;
		w3 = newW3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__W3, oldW3, w3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getW4() {
		return w4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setW4(int newW4) {
		int oldW4 = w4;
		w4 = newW4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__W4, oldW4, w4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSearchMode() {
		return searchMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSearchMode(String newSearchMode) {
		String oldSearchMode = searchMode;
		searchMode = newSearchMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticmanagerPackage.SEARCH__SEARCH_MODE, oldSearchMode, searchMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<?, ?> getOrderSearchesListByWeight() {
		Map<String, Integer> searches = new TreeMap<String, Integer>();
		
		for(TreeNode child : getSearchtree().getChildren()){
			for(String data : child.getData()){
		    	if(!isOnTheList(searches, data)){
		    		searches.put(data, getMaxWeight() * 10);
		    	}
		    }
		}
		
		PriorityQueue<TreeNode> queue = getOrderSearchesListByWeightHelper(getSearchtree());
		Iterator<TreeNode> iter = queue.iterator();
		
		while (iter.hasNext()) {
		    TreeNode current = iter.next();
		    for(String data : current.getData()){
		    	if(!isOnTheList(searches, data)){
		    		searches.put(data, current.getPoints());
		    	}
		    }
		}
		
		return searches;
	}
	
	private boolean isOnTheList(Map<String, Integer> searches, String data) {
		for(Entry<String, Integer> s : searches.entrySet()){
			if(StringUtils.capitalize(s.getKey()).compareTo(StringUtils.capitalize(data)) == 0) return true;
		}
		return false;
	}
	
	private PriorityQueue<TreeNode> getOrderSearchesListByWeightHelper(TreeNode root){
		TreeNodeSynsetComparator comparator = new TreeNodeSynsetComparator();
		PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>(comparator);
		
		if(root == null) return queue;
		if(!root.isValid()) return queue;
		if(root.getKind() == 3){
			if((root.getCountWordnet() > 0) || (root.getPoints() > 0)){
				queue.add(root); 
			}
		}
		
		for(TreeNode child : root.getChildren()) queue.addAll(getOrderSearchesListByWeightHelper(child));
		
		return queue;
	}

	class TreeNodeSynsetComparator implements Comparator<TreeNode>{
		@Override
		public int compare(TreeNode node1, TreeNode node2) {
			if(node1.getPoints() > node2.getPoints()){
				return 1;
			}
			if(node1.getPoints() < node2.getPoints()){
				return -1;
			}
			if(node1.getPoints() == node2.getPoints()){
				if(node1.getCountWordnet() > node2.getCountWordnet()){
					return 1;
				}
				if(node1.getCountWordnet() < node2.getCountWordnet()){
					return -1;
				}
			}
		
			return 0;
		}
		
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void expand() {
		TreeNode searchtree = SemanticmanagerFactory.eINSTANCE.createTreeNode();
		expandLanguageTree(searchtree);
		cleanRepeatedBranch(searchtree);
		cleanSynsetsWithNoSense(searchtree);
		setSearchtree(searchtree);
	}
	
	private void expandLanguageTree(TreeNode searchtree){
		String[] root = StringUtils.splitByWholeSeparator(getSearchField(), ",", 0);
		
		//TreeNode searchtree = SemanticmanagerFactory.eINSTANCE.createTreeNode();
		searchtree.getData().clear();
		searchtree.getData().addAll(Arrays.asList(root));
		searchtree.setKind(0);
		
		for(String dataR : root){
			TreeNode dataRChild = SemanticmanagerFactory.eINSTANCE.createTreeNode();
			dataRChild.setValid(true);
			
			String[] dataRSeparated = StringUtils.splitByCharacterTypeCamelCase(dataR);
			
			List<String> dataRSeparatedNoBlank = new ArrayList<String>();
			for(String dataRSep : dataRSeparated){
				if((!StringUtils.isWhitespace(dataRSep)) && (!StringUtils.isBlank(dataRSep))){
					dataRSeparatedNoBlank.add(StringUtils.capitalize(dataRSep));
				}
			}	
			
			dataRChild.getData().addAll(dataRSeparatedNoBlank);
			dataRChild.setKind(1);
			
			if(dataRChild.getData().size() > 1){
				for(String s : dataRChild.getData()){
					TreeNode atomicWordNode = SemanticmanagerFactory.eINSTANCE.createTreeNode();
					atomicWordNode.setValid(true);
					
					atomicWordNode.getData().clear();
					atomicWordNode.getData().add(s);
					atomicWordNode.setKind(2);
					dataRChild.getChildren().add(atomicWordNode);
					
					Map<String, Tuple<String[], String[]>> wordnetSynsetMap = Wordnet.getInstance().getSynonymsProposal(s);
					
					for(Entry<String, Tuple<String[], String[]>> entry : wordnetSynsetMap.entrySet()){
						//System.out.println("wordnet entry 1 " + entry.toString());
						
						TreeNode synsetWordnetNode = SemanticmanagerFactory.eINSTANCE.createTreeNode();
						synsetWordnetNode.setValid(true);
						
						synsetWordnetNode.setDefinition(entry.getKey());
						
						synsetWordnetNode.getData().clear();
						synsetWordnetNode.getData().addAll(Arrays.asList(entry.getValue().x));
						synsetWordnetNode.getUsages().clear();
						synsetWordnetNode.getUsages().addAll(Arrays.asList(entry.getValue().y));
						
						synsetWordnetNode.setCountWordnet(entry.getValue().weight);
						
						synsetWordnetNode.setKind(3);
						atomicWordNode.getChildren().add(synsetWordnetNode);
					}
				}
			}
			else{
				if(dataRChild.getData().size() > 0){
					dataRChild.setKind(2);
					Map<String, Tuple<String[], String[]>> wordnetSynsetMap = Wordnet.getInstance().getSynonymsProposal(dataRChild.getData().get(0));
					
					for(Entry<String, uam.extremo.core.utils.Tuple<String[], String[]>> entry : wordnetSynsetMap.entrySet()){
						//System.out.println("wordnet entry 2 " + entry.toString());

						TreeNode synsetWordnetNode = SemanticmanagerFactory.eINSTANCE.createTreeNode();
						synsetWordnetNode.setValid(true);
						
						synsetWordnetNode.setDefinition(entry.getKey());
						
						synsetWordnetNode.getData().clear();
						synsetWordnetNode.getData().addAll(Arrays.asList(entry.getValue().x));
						synsetWordnetNode.getUsages().clear();
						synsetWordnetNode.getUsages().addAll(Arrays.asList(entry.getValue().y));
						synsetWordnetNode.setCountWordnet(entry.getValue().weight);
						
						synsetWordnetNode.setKind(3);
						dataRChild.getChildren().add(synsetWordnetNode);
					}
				}
				else{
					dataRChild.setKind(-1);
				}
			}

			searchtree.getChildren().add(dataRChild);
		}
	}
	
	private synchronized void cleanRepeatedBranch(TreeNode searchtree){
		for(TreeNode child : searchtree.getChildren()) 
			cleanRepeatedBranch(searchtree, child);
	}
	
	private void cleanRepeatedBranch(TreeNode parent, TreeNode child) {
		if((child.getKind() == 1) || (child.getKind() == 2)){
			for(TreeNode sibling : parent.getChildren()){
				if(!sibling.equals(child)){
					if(Arrays.equals(sibling.getData().toArray(), child.getData().toArray())){
						sibling.setValid(false);
						child.setValid(true);
					}
				}
				
				for(TreeNode nephew : sibling.getChildren()){
					if(Arrays.equals(nephew.getData().toArray(), child.getData().toArray())){
						child.setValid(false);
						nephew.setValid(true);
					}
				}
			}
		}
		
		for(TreeNode grandchild : child.getChildren()) cleanRepeatedBranch(child, grandchild);
	}
	
	private synchronized void cleanSynsetsWithNoSense(TreeNode searchtree) {
    	for(TreeNode child : searchtree.getChildren()) 
    		cleanSynsetsWithNoSense(searchtree, child);
	}
    

	private void cleanSynsetsWithNoSense(TreeNode parent, TreeNode child){
   	 	if((child == null) || (!child.isValid())) return;
   	 	
   	 	calculateWeights();
   	 	
   	 	if(child.getKind() == 2){
	   	 	for(TreeNode sibling : parent.getChildren()){
				if((!sibling.equals(child)) && (sibling.getKind() == 2)){
					for(String data : sibling.getData()){

						for(TreeNode grandchild : child.getChildren()){
							List<String> synsets = grandchild.getData();
							if(synsets != null){
								for(String synset : synsets){
									if(StringUtils.containsIgnoreCase(synset, data)){
										grandchild.setPoints(getW1());
									}
									
									if(!Wordnet.getInstance().getDerivation(synset, data).isEmpty()){
										grandchild.setPoints(getW2());
									}
								}
							}
							
							String definition = grandchild.getDefinition();
							if(definition != null){
								String[] sppliteds = StringUtils.split(definition, " ");
								for(String spplited : sppliteds){
									if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
										grandchild.setPoints(getW3());
									}
								}
							}
							
							List<String> examples = grandchild.getUsages();
							for(String example : examples){
								if(example != null){
									String[] sppliteds = StringUtils.split(example, " ");
									for(String spplited : sppliteds){
										if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
											grandchild.setPoints(getW4());
										}
									}
								}
							}
						}
					}
					for(TreeNode cousin : sibling.getChildren()){
						for(String data : cousin.getData()){
							for(TreeNode grandchild : child.getChildren()){
								List<String> synsets = grandchild.getData();
								if(synsets != null){
									for(String synset : synsets){
										if(StringUtils.containsIgnoreCase(synset, data)){
											grandchild.setPoints(getW1() * (getVariance() / 100));
										}
										
										if(!Wordnet.getInstance().getDerivation(synset, data).isEmpty()){
											grandchild.setPoints(getW2() * (getVariance() / 100));
										}
									}
								}
								
								String definition = grandchild.getDefinition();
								if(definition != null){
									String[] sppliteds = StringUtils.split(definition, " ");
									for(String spplited : sppliteds){
										if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
											grandchild.setPoints(getW3() * (getVariance() / 100));
										}
									}
								}
								
								List<String> examples = grandchild.getUsages();
								for(String example : examples){
									if(example != null){
										String[] sppliteds = StringUtils.split(example, " ");
										for(String spplited : sppliteds){
											if(StringUtils.containsOnly(StringUtils.capitalize(StringUtils.deleteWhitespace(spplited)), data)){
												grandchild.setPoints(getW4() * (getVariance() / 100));
											}
										}
									}
								}
							}
						}
					}
				}
			}
   	 	}
   	 	
   	 	for(TreeNode grandchild : child.getChildren()) cleanSynsetsWithNoSense(child, grandchild);
   }
	
	public void calculateWeights() {
		setW1((getRelevanceR1() * getMaxWeight()) / 10);
		setW2((getRelevanceR2() * getMaxWeight()) / 10);
		setW3((getRelevanceR3() * getMaxWeight()) / 10);
		setW4((getRelevanceR4() * getMaxWeight()) / 10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SemanticmanagerPackage.SEARCH__SEARCHTREE:
				return basicSetSearchtree(null, msgs);
			case SemanticmanagerPackage.SEARCH__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SemanticmanagerPackage.SEARCH__NAME:
				return getName();
			case SemanticmanagerPackage.SEARCH__EQUIVALENTS:
				return isEquivalents();
			case SemanticmanagerPackage.SEARCH__ALL_PROPERTIES:
				return isAllProperties();
			case SemanticmanagerPackage.SEARCH__ONLY_DIRECT_SUBCLASSES:
				return isOnlyDirectSubclasses();
			case SemanticmanagerPackage.SEARCH__SEARCHTREE:
				return getSearchtree();
			case SemanticmanagerPackage.SEARCH__RESOURCES:
				return getResources();
			case SemanticmanagerPackage.SEARCH__RESULTS:
				return getResults();
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R1:
				return getRelevanceR1();
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R2:
				return getRelevanceR2();
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R3:
				return getRelevanceR3();
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R4:
				return getRelevanceR4();
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R5:
				return getRelevanceR5();
			case SemanticmanagerPackage.SEARCH__MAX_WEIGHT:
				return getMaxWeight();
			case SemanticmanagerPackage.SEARCH__STRATEGY_APPLIED:
				return getStrategyApplied();
			case SemanticmanagerPackage.SEARCH__SEARCH_FIELD:
				return getSearchField();
			case SemanticmanagerPackage.SEARCH__ONLY_DIRECT_SUPERCLASSES:
				return isOnlyDirectSuperclasses();
			case SemanticmanagerPackage.SEARCH__VARIANCE:
				return getVariance();
			case SemanticmanagerPackage.SEARCH__SEARCH_FIELD_TARGET:
				return getSearchFieldTarget();
			case SemanticmanagerPackage.SEARCH__W1:
				return getW1();
			case SemanticmanagerPackage.SEARCH__W2:
				return getW2();
			case SemanticmanagerPackage.SEARCH__W3:
				return getW3();
			case SemanticmanagerPackage.SEARCH__W4:
				return getW4();
			case SemanticmanagerPackage.SEARCH__SEARCH_MODE:
				return getSearchMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SemanticmanagerPackage.SEARCH__NAME:
				setName((String)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__EQUIVALENTS:
				setEquivalents((Boolean)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__ALL_PROPERTIES:
				setAllProperties((Boolean)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__ONLY_DIRECT_SUBCLASSES:
				setOnlyDirectSubclasses((Boolean)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__SEARCHTREE:
				setSearchtree((TreeNode)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends Resource>)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends SemanticGroup>)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R1:
				setRelevanceR1((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R2:
				setRelevanceR2((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R3:
				setRelevanceR3((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R4:
				setRelevanceR4((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R5:
				setRelevanceR5((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__MAX_WEIGHT:
				setMaxWeight((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__STRATEGY_APPLIED:
				setStrategyApplied((String)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__SEARCH_FIELD:
				setSearchField((String)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__ONLY_DIRECT_SUPERCLASSES:
				setOnlyDirectSuperclasses((Boolean)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__VARIANCE:
				setVariance((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__SEARCH_FIELD_TARGET:
				setSearchFieldTarget((String)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__W1:
				setW1((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__W2:
				setW2((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__W3:
				setW3((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__W4:
				setW4((Integer)newValue);
				return;
			case SemanticmanagerPackage.SEARCH__SEARCH_MODE:
				setSearchMode((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SemanticmanagerPackage.SEARCH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__EQUIVALENTS:
				setEquivalents(EQUIVALENTS_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__ALL_PROPERTIES:
				setAllProperties(ALL_PROPERTIES_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__ONLY_DIRECT_SUBCLASSES:
				setOnlyDirectSubclasses(ONLY_DIRECT_SUBCLASSES_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__SEARCHTREE:
				setSearchtree((TreeNode)null);
				return;
			case SemanticmanagerPackage.SEARCH__RESOURCES:
				getResources().clear();
				return;
			case SemanticmanagerPackage.SEARCH__RESULTS:
				getResults().clear();
				return;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R1:
				setRelevanceR1(RELEVANCE_R1_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R2:
				setRelevanceR2(RELEVANCE_R2_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R3:
				setRelevanceR3(RELEVANCE_R3_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R4:
				setRelevanceR4(RELEVANCE_R4_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R5:
				setRelevanceR5(RELEVANCE_R5_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__MAX_WEIGHT:
				setMaxWeight(MAX_WEIGHT_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__STRATEGY_APPLIED:
				setStrategyApplied(STRATEGY_APPLIED_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__SEARCH_FIELD:
				setSearchField(SEARCH_FIELD_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__ONLY_DIRECT_SUPERCLASSES:
				setOnlyDirectSuperclasses(ONLY_DIRECT_SUPERCLASSES_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__VARIANCE:
				setVariance(VARIANCE_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__SEARCH_FIELD_TARGET:
				setSearchFieldTarget(SEARCH_FIELD_TARGET_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__W1:
				setW1(W1_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__W2:
				setW2(W2_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__W3:
				setW3(W3_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__W4:
				setW4(W4_EDEFAULT);
				return;
			case SemanticmanagerPackage.SEARCH__SEARCH_MODE:
				setSearchMode(SEARCH_MODE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SemanticmanagerPackage.SEARCH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SemanticmanagerPackage.SEARCH__EQUIVALENTS:
				return equivalents != EQUIVALENTS_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__ALL_PROPERTIES:
				return allProperties != ALL_PROPERTIES_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__ONLY_DIRECT_SUBCLASSES:
				return onlyDirectSubclasses != ONLY_DIRECT_SUBCLASSES_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__SEARCHTREE:
				return searchtree != null;
			case SemanticmanagerPackage.SEARCH__RESOURCES:
				return resources != null && !resources.isEmpty();
			case SemanticmanagerPackage.SEARCH__RESULTS:
				return results != null && !results.isEmpty();
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R1:
				return relevanceR1 != RELEVANCE_R1_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R2:
				return relevanceR2 != RELEVANCE_R2_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R3:
				return relevanceR3 != RELEVANCE_R3_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R4:
				return relevanceR4 != RELEVANCE_R4_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__RELEVANCE_R5:
				return relevanceR5 != RELEVANCE_R5_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__MAX_WEIGHT:
				return maxWeight != MAX_WEIGHT_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__STRATEGY_APPLIED:
				return STRATEGY_APPLIED_EDEFAULT == null ? strategyApplied != null : !STRATEGY_APPLIED_EDEFAULT.equals(strategyApplied);
			case SemanticmanagerPackage.SEARCH__SEARCH_FIELD:
				return SEARCH_FIELD_EDEFAULT == null ? searchField != null : !SEARCH_FIELD_EDEFAULT.equals(searchField);
			case SemanticmanagerPackage.SEARCH__ONLY_DIRECT_SUPERCLASSES:
				return onlyDirectSuperclasses != ONLY_DIRECT_SUPERCLASSES_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__VARIANCE:
				return variance != VARIANCE_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__SEARCH_FIELD_TARGET:
				return SEARCH_FIELD_TARGET_EDEFAULT == null ? searchFieldTarget != null : !SEARCH_FIELD_TARGET_EDEFAULT.equals(searchFieldTarget);
			case SemanticmanagerPackage.SEARCH__W1:
				return w1 != W1_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__W2:
				return w2 != W2_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__W3:
				return w3 != W3_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__W4:
				return w4 != W4_EDEFAULT;
			case SemanticmanagerPackage.SEARCH__SEARCH_MODE:
				return SEARCH_MODE_EDEFAULT == null ? searchMode != null : !SEARCH_MODE_EDEFAULT.equals(searchMode);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SemanticmanagerPackage.SEARCH___GET_ORDER_SEARCHES_LIST_BY_WEIGHT:
				return getOrderSearchesListByWeight();
			case SemanticmanagerPackage.SEARCH___EXPAND:
				expand();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", equivalents: ");
		result.append(equivalents);
		result.append(", allProperties: ");
		result.append(allProperties);
		result.append(", onlyDirectSubclasses: ");
		result.append(onlyDirectSubclasses);
		result.append(", relevanceR1: ");
		result.append(relevanceR1);
		result.append(", relevanceR2: ");
		result.append(relevanceR2);
		result.append(", relevanceR3: ");
		result.append(relevanceR3);
		result.append(", relevanceR4: ");
		result.append(relevanceR4);
		result.append(", relevanceR5: ");
		result.append(relevanceR5);
		result.append(", maxWeight: ");
		result.append(maxWeight);
		result.append(", strategyApplied: ");
		result.append(strategyApplied);
		result.append(", searchField: ");
		result.append(searchField);
		result.append(", onlyDirectSuperclasses: ");
		result.append(onlyDirectSuperclasses);
		result.append(", variance: ");
		result.append(variance);
		result.append(", searchFieldTarget: ");
		result.append(searchFieldTarget);
		result.append(", w1: ");
		result.append(w1);
		result.append(", w2: ");
		result.append(w2);
		result.append(", w3: ");
		result.append(w3);
		result.append(", w4: ");
		result.append(w4);
		result.append(", searchMode: ");
		result.append(searchMode);
		result.append(')');
		return result.toString();
	}

} //SearchImpl
