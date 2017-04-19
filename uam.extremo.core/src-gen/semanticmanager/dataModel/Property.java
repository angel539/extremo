/**
 */
package semanticmanager.dataModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link semanticmanager.dataModel.Property#getSemanticNodeFrom <em>Semantic Node From</em>}</li>
 *   <li>{@link semanticmanager.dataModel.Property#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link semanticmanager.dataModel.Property#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 *
 * @see semanticmanager.dataModel.DataModelPackage#getProperty()
 * @model abstract="true"
 * @generated
 */
public interface Property extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Semantic Node From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link semanticmanager.dataModel.SemanticNode#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Node From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantic Node From</em>' container reference.
	 * @see #setSemanticNodeFrom(SemanticNode)
	 * @see semanticmanager.dataModel.DataModelPackage#getProperty_SemanticNodeFrom()
	 * @see semanticmanager.dataModel.SemanticNode#getProperties
	 * @model opposite="properties" transient="false"
	 * @generated
	 */
	SemanticNode getSemanticNodeFrom();

	/**
	 * Sets the value of the '{@link semanticmanager.dataModel.Property#getSemanticNodeFrom <em>Semantic Node From</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantic Node From</em>' container reference.
	 * @see #getSemanticNodeFrom()
	 * @generated
	 */
	void setSemanticNodeFrom(SemanticNode value);

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see semanticmanager.dataModel.DataModelPackage#getProperty_LowerBound()
	 * @model
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link semanticmanager.dataModel.Property#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(int)
	 * @see semanticmanager.dataModel.DataModelPackage#getProperty_UpperBound()
	 * @model
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link semanticmanager.dataModel.Property#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

} // Property
