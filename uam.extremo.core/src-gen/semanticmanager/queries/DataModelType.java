/**
 */
package semanticmanager.queries;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Data Model Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see semanticmanager.queries.QueriesPackage#getDataModelType()
 * @model
 * @generated
 */
public enum DataModelType implements Enumerator {
	/**
	 * The '<em><b>Resource</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	RESOURCE(0, "Resource", "Resource"),

	/**
	 * The '<em><b>Semantic Node</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEMANTIC_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	SEMANTIC_NODE(1, "SemanticNode", "SemanticNode"),

	/**
	 * The '<em><b>Data Property</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_PROPERTY_VALUE
	 * @generated
	 * @ordered
	 */
	DATA_PROPERTY(2, "DataProperty", "DataProperty"),

	/**
	 * The '<em><b>Object Property</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBJECT_PROPERTY_VALUE
	 * @generated
	 * @ordered
	 */
	OBJECT_PROPERTY(3, "ObjectProperty", "ObjectProperty");

	/**
	 * The '<em><b>Resource</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Resource</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESOURCE
	 * @model name="Resource"
	 * @generated
	 * @ordered
	 */
	public static final int RESOURCE_VALUE = 0;

	/**
	 * The '<em><b>Semantic Node</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Semantic Node</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEMANTIC_NODE
	 * @model name="SemanticNode"
	 * @generated
	 * @ordered
	 */
	public static final int SEMANTIC_NODE_VALUE = 1;

	/**
	 * The '<em><b>Data Property</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Data Property</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA_PROPERTY
	 * @model name="DataProperty"
	 * @generated
	 * @ordered
	 */
	public static final int DATA_PROPERTY_VALUE = 2;

	/**
	 * The '<em><b>Object Property</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Object Property</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OBJECT_PROPERTY
	 * @model name="ObjectProperty"
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_PROPERTY_VALUE = 3;

	/**
	 * An array of all the '<em><b>Data Model Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DataModelType[] VALUES_ARRAY =
		new DataModelType[] {
			RESOURCE,
			SEMANTIC_NODE,
			DATA_PROPERTY,
			OBJECT_PROPERTY,
		};

	/**
	 * A public read-only list of all the '<em><b>Data Model Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DataModelType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Data Model Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DataModelType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataModelType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Data Model Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DataModelType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataModelType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Data Model Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DataModelType get(int value) {
		switch (value) {
			case RESOURCE_VALUE: return RESOURCE;
			case SEMANTIC_NODE_VALUE: return SEMANTIC_NODE;
			case DATA_PROPERTY_VALUE: return DATA_PROPERTY;
			case OBJECT_PROPERTY_VALUE: return OBJECT_PROPERTY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DataModelType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //DataModelType
